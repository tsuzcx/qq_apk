package com.tencent.mobileqq.transfile.predownload.schedule;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.automator.AutomatorHelper;
import com.tencent.mobileqq.qqperf.api.IDeviceOptSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class PreDownloadScheduler
  implements Handler.Callback
{
  private static final int MSG_CANCEL_PRE_DOWNLOAD = 1003;
  private static final int MSG_DOWNLOAD_ON_APP_BACKGROUD = 1009;
  private static final int MSG_DOWNLOAD_ON_APP_FOREROUD = 1008;
  private static final int MSG_DOWNLOAD_PAUSE_BY_FPS_CPU = 1007;
  private static final int MSG_ON_TASK_END = 1006;
  private static final int MSG_PRE_DOWNLOAD_SUCCESS = 1004;
  private static final int MSG_REQUEST_PRE_DOWNLOAD = 1002;
  private static final int MSG_START_PRE_DOWNLOAD = 1001;
  private static final int MSG_UPDATE_FPS_CPU = 1005;
  private static final String TAG = "PreDownloadScheduler";
  private BaseQQAppInterface mApp;
  private boolean mAppBackground = false;
  private boolean mAppLiteStart = false;
  private boolean mBeReady = false;
  private boolean mCPUReady = false;
  private long mCPUReadyCount = 0L;
  private double mCPUThreshold = 50.0D;
  private PreDownloadScheduler.MyComparator mComparator = new PreDownloadScheduler.MyComparator(null);
  private double mCurCPU = 0.0D;
  private double mCurFPS = 0.0D;
  private long mCurFPSTime = 0L;
  private long mCurSuccesSize;
  private String mCurSuccessUrl;
  private PreDownloadItem mCurrentTask = null;
  private ArrayList<PreDownloadItem> mDownloadList = new ArrayList(10);
  private boolean mEnable = true;
  private boolean mEnableFPSAndCPU = false;
  private long mEnableTime = 0L;
  private FPSCalculator.GetFPSListener mFPSListener = new PreDownloadScheduler.1(this);
  private boolean mFPSReady = false;
  private long mFPSReadyCount = 0L;
  private double mFPSThreshold = 30.0D;
  private Handler mHandler = null;
  private String mInnerPath;
  private Object mLock = new Object();
  private boolean mNeedReport = false;
  private ArrayList<PreDownloadItem> mPendingList = new ArrayList(10);
  private final PreDownloadConfigHelper mPreDownloadConfigHelper = new PreDownloadConfigHelper();
  private String mSdcardPath;
  private long mStartTime = 0L;
  private long mSysVolatilityCount = 6L;
  
  public PreDownloadScheduler(BaseQQAppInterface paramBaseQQAppInterface)
  {
    init(paramBaseQQAppInterface);
  }
  
  private void checkStateToStart()
  {
    if ((this.mCurrentTask != null) && (Math.abs(System.currentTimeMillis() - this.mCurrentTask.startTime) >= 60000L)) {
      this.mCurrentTask = null;
    }
    if ((checkState()) && (this.mCurrentTask == null) && (this.mPendingList.size() > 0))
    {
      Collections.sort(this.mPendingList, this.mComparator);
      int j = getStartUpCondition();
      int k = PreDownloadScheduleUtil.getNetworkType(this.mApp.getApp());
      if (k == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadScheduler", 2, " [no network] donot start any task! ");
        }
        return;
      }
      synchronized (this.mLock)
      {
        printDownloadTaskInfo();
        int i = 0;
        while (i < this.mPendingList.size())
        {
          PreDownloadItem localPreDownloadItem = (PreDownloadItem)this.mPendingList.get(i);
          if ((localPreDownloadItem != null) && (localPreDownloadItem.reqCondition == 1) && (j == 1))
          {
            printRemoveTaskInfo(localPreDownloadItem);
            this.mPendingList.remove(i);
            return;
          }
          if ((localPreDownloadItem != null) && (((localPreDownloadItem.reqCondition == 2) && (!this.mAppBackground)) || ((localPreDownloadItem.reqNetWork == 1) && (k > 1)) || ((k > 1) && (k < localPreDownloadItem.reqNetWork)) || ((localPreDownloadItem.reqCondition == 3) && (!this.mAppLiteStart))))
          {
            printIgnoreTaskInfo(k, localPreDownloadItem);
            i += 1;
          }
          else
          {
            this.mCurrentTask = ((PreDownloadItem)this.mPendingList.remove(i));
          }
        }
        if ((this.mCurrentTask != null) && (this.mCurrentTask.task != null))
        {
          if (this.mStartTime == 0L) {
            this.mStartTime = System.currentTimeMillis();
          }
          this.mCurrentTask.startCondition = j;
          this.mCurrentTask.startTime = System.currentTimeMillis();
          this.mCurrentTask.downNetWork = PreDownloadScheduleUtil.getNetworkName(this.mApp);
          this.mCurrentTask.state = 1;
          this.mCurrentTask.task.start();
          this.mDownloadList.add(this.mCurrentTask);
          printStartTaskInfo("[start downloading] begin task :", this.mCurrentTask);
        }
        else
        {
          this.mCurrentTask = null;
        }
        return;
      }
    }
  }
  
  private void checkTaskToStopFPSCallback()
  {
    if (this.mEnableFPSAndCPU)
    {
      if (this.mPendingList.size() <= 0)
      {
        FPSCalculator.a().b(this.mFPSListener);
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadScheduler", 2, "[fps callback disabled],there is no pending task!");
        }
      }
      if (this.mPendingList.size() > 0)
      {
        FPSCalculator.a().a(this.mFPSListener);
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadScheduler", 2, "[fps callback enabled],there is pending tasks!");
        }
      }
    }
  }
  
  private void directDownloadItem(PreDownloadItem paramPreDownloadItem)
  {
    int i = PreDownloadScheduleUtil.getNetworkType(this.mApp.getApp());
    if ((i <= 1) || (i >= paramPreDownloadItem.reqNetWork))
    {
      paramPreDownloadItem.startCondition = getStartUpCondition();
      paramPreDownloadItem.startTime = System.currentTimeMillis();
      paramPreDownloadItem.downNetWork = PreDownloadScheduleUtil.getNetworkName(this.mApp);
      paramPreDownloadItem.state = 1;
      paramPreDownloadItem.task.start();
      this.mDownloadList.add(paramPreDownloadItem);
      printStartTaskInfo("[start downloading direct without contrl] begin task :", paramPreDownloadItem);
      report(paramPreDownloadItem);
    }
  }
  
  private int getStartUpCondition()
  {
    int i;
    if (AutomatorHelper.a) {
      i = 1;
    } else if (AutomatorHelper.b) {
      i = 2;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getStartUpCondition  condition = ");
      localStringBuilder.append(i);
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  private void handleMessageForCancelPreDownload(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    int i;
    if (!TextUtils.isEmpty(str))
    {
      paramMessage = this.mLock;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.mPendingList.size())
        {
          PreDownloadItem localPreDownloadItem = (PreDownloadItem)this.mPendingList.get(i);
          if (!str.equals(localPreDownloadItem.downloadUrl)) {
            break label164;
          }
          this.mPendingList.remove(localPreDownloadItem);
          localPreDownloadItem.state = 3;
          report(localPreDownloadItem);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[ msg cancel] task.url = ");
            localStringBuilder.append(localPreDownloadItem.downloadUrl);
            QLog.e("PreDownloadScheduler", 1, localStringBuilder.toString());
          }
          if (localPreDownloadItem == this.mCurrentTask) {
            this.mCurrentTask = null;
          }
          checkTaskToStopFPSCallback();
          break label164;
        }
      }
      finally {}
      checkStateToStart();
      return;
      label164:
      i += 1;
    }
  }
  
  private void handleMessageForDownloadSuccess(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    int j = paramMessage.arg1;
    if (!TextUtils.isEmpty(str))
    {
      int i = 0;
      while (i < this.mDownloadList.size())
      {
        paramMessage = (PreDownloadItem)this.mDownloadList.get(i);
        if (str.equals(paramMessage.downloadUrl))
        {
          paramMessage.downloadSize = j;
          paramMessage.downloadTime = (System.currentTimeMillis() - paramMessage.startTime);
          paramMessage.state = 2;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[msg download sucess] task.url = ");
            localStringBuilder.append(paramMessage.downloadUrl);
            QLog.e("PreDownloadScheduler", 1, localStringBuilder.toString());
          }
          report(paramMessage);
          this.mDownloadList.remove(i);
          if (paramMessage == this.mCurrentTask) {
            this.mCurrentTask = null;
          }
        }
        i += 1;
      }
    }
    checkStateToStart();
  }
  
  private void handleMessageForOnTaskEnd(Message paramMessage)
  {
    paramMessage = (AbsPreDownloadTask)paramMessage.obj;
    PreDownloadItem localPreDownloadItem = this.mCurrentTask;
    if ((localPreDownloadItem != null) && (localPreDownloadItem.task != null) && (paramMessage != null) && (this.mCurrentTask.task == paramMessage))
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append(" pre download onTaskEnd task key = ");
        paramMessage.append(this.mCurrentTask.task.key);
        QLog.e("PreDownloadScheduler", 1, paramMessage.toString());
      }
      this.mCurrentTask = null;
    }
    checkStateToStart();
  }
  
  private void handleMessageForRequestPreDownload(Message paramMessage)
  {
    PreDownloadItem localPreDownloadItem1 = (PreDownloadItem)paramMessage.obj;
    int i;
    if (this.mEnable)
    {
      paramMessage = this.mLock;
      i = 0;
    }
    for (;;)
    {
      PreDownloadItem localPreDownloadItem3;
      int j;
      try
      {
        if (i >= this.mPendingList.size()) {
          break label348;
        }
        localPreDownloadItem3 = (PreDownloadItem)this.mPendingList.get(i);
        if (!localPreDownloadItem1.downloadUrl.equals(localPreDownloadItem3.downloadUrl)) {
          break label341;
        }
        if ((!localPreDownloadItem1.downloadUrl.contains("doodle")) || (localPreDownloadItem1.filePath == null) || (localPreDownloadItem1.filePath.equals(localPreDownloadItem3.filePath))) {
          break label336;
        }
        if (!QLog.isColorLevel()) {
          break label341;
        }
        QLog.d("PreDownloadScheduler", 2, new Object[] { "mPendingList, same url, filePath diff, ", localPreDownloadItem1.downloadUrl });
      }
      finally {}
      int k = i;
      if (j < this.mDownloadList.size())
      {
        localPreDownloadItem3 = (PreDownloadItem)this.mDownloadList.get(j);
        if (!localPreDownloadItem1.downloadUrl.equals(localPreDownloadItem3.downloadUrl)) {
          break label361;
        }
        if ((localPreDownloadItem1.downloadUrl.contains("doodle")) && (localPreDownloadItem1.filePath != null) && (!localPreDownloadItem1.filePath.equals(localPreDownloadItem3.filePath)))
        {
          if (!QLog.isColorLevel()) {
            break label361;
          }
          QLog.d("PreDownloadScheduler", 2, new Object[] { "downloadUrl, same url, filePath diff, ", localPreDownloadItem1.downloadUrl });
          break label361;
        }
      }
      else
      {
        if (k == 0) {
          this.mPendingList.add(localPreDownloadItem1);
        }
        break label283;
        directDownloadItem(localPreDownloadItem2);
        label283:
        checkStateToStart();
        checkTaskToStopFPSCallback();
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append(" [msg request add to list]  mPendingList size = ");
          paramMessage.append(this.mPendingList.size());
          QLog.e("PreDownloadScheduler", 1, paramMessage.toString());
        }
        return;
        label336:
        i = 1;
        break label350;
        label341:
        i += 1;
        continue;
        label348:
        i = 0;
        label350:
        j = 0;
        continue;
      }
      k = 1;
      continue;
      label361:
      j += 1;
    }
  }
  
  private void handleMessageForStartPreDownload()
  {
    this.mBeReady = true;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "startPreDownload mBeReady set true, all pre download will start ");
    }
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("sp_pre_downlaod", 0);
    int i = localSharedPreferences.getInt("sp_key_pre_download_version", 0);
    if (i != this.mPreDownloadConfigHelper.getVersion())
    {
      Object localObject = this.mPreDownloadConfigHelper;
      localObject = ((PreDownloadConfigHelper)localObject).cleanOnVersionUpdate(i, ((PreDownloadConfigHelper)localObject).getVersion());
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        i = 0;
        while (i < ((List)localObject).size())
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[onVersionUpdate PreDownloadScheduler]  delete file: ");
            localStringBuilder.append((String)((List)localObject).get(i));
            QLog.e("PreDownloadScheduler", 1, localStringBuilder.toString());
          }
          FileUtils.delete((String)((List)localObject).get(i), false);
          i += 1;
        }
      }
    }
    localSharedPreferences.edit().putInt("sp_key_pre_download_version", this.mPreDownloadConfigHelper.getVersion()).apply();
    checkStateToStart();
    checkTaskToStopFPSCallback();
  }
  
  private void printDownloadTaskInfo()
  {
    StringBuilder localStringBuilder;
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("pending task id:");
      localObject1 = this.mLock;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.mPendingList.size())
        {
          PreDownloadItem localPreDownloadItem = (PreDownloadItem)this.mPendingList.get(i);
          if (localPreDownloadItem == null) {
            break label95;
          }
          localStringBuilder.append(localPreDownloadItem.businessID);
          localStringBuilder.append(",");
          break label95;
        }
        QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
        return;
      }
      finally {}
      return;
      label95:
      i += 1;
    }
  }
  
  private void printIgnoreTaskInfo(int paramInt, PreDownloadItem paramPreDownloadItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[network or reqconditon not fit] donot download task :\n");
      localStringBuilder.append(",businessID=");
      localStringBuilder.append(paramPreDownloadItem.businessID);
      localStringBuilder.append(",businessName=");
      localStringBuilder.append(paramPreDownloadItem.businessName);
      localStringBuilder.append(",downloadUrl=");
      localStringBuilder.append(paramPreDownloadItem.downloadUrl);
      localStringBuilder.append(",reqCondition=");
      localStringBuilder.append(paramPreDownloadItem.reqCondition);
      localStringBuilder.append(",current appBackground=");
      localStringBuilder.append(this.mAppBackground);
      localStringBuilder.append(",reqNetWork=");
      localStringBuilder.append(paramPreDownloadItem.reqNetWork);
      localStringBuilder.append(",current netWorkType=");
      localStringBuilder.append(paramInt);
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
  }
  
  private void printRemoveTaskInfo(PreDownloadItem paramPreDownloadItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[forbidden on first start] remove task :\n");
      localStringBuilder.append(",businessID=");
      localStringBuilder.append(paramPreDownloadItem.businessID);
      localStringBuilder.append(",businessName=");
      localStringBuilder.append(paramPreDownloadItem.businessName);
      localStringBuilder.append(",downloadUrl=");
      localStringBuilder.append(paramPreDownloadItem.downloadUrl);
      localStringBuilder.append(",reqCondition=");
      localStringBuilder.append(paramPreDownloadItem.reqCondition);
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
  }
  
  private void printStartTaskInfo(String paramString, PreDownloadItem paramPreDownloadItem)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder(paramString);
      paramString.append(",businessID=");
      paramString.append(paramPreDownloadItem.businessID);
      paramString.append(",businessName=");
      paramString.append(paramPreDownloadItem.businessName);
      paramString.append(",downloadUrl=");
      paramString.append(paramPreDownloadItem.downloadUrl);
      paramString.append(",fileKey=");
      paramString.append(paramPreDownloadItem.fileKey);
      QLog.d("PreDownloadScheduler", 2, paramString.toString());
    }
  }
  
  private void report(PreDownloadItem paramPreDownloadItem)
  {
    if (!this.mNeedReport) {
      return;
    }
    HashMap localHashMap = new HashMap(20);
    localHashMap.put("businessID", String.valueOf(paramPreDownloadItem.businessID));
    localHashMap.put("businessName", paramPreDownloadItem.businessName);
    localHashMap.put("businessEngName", paramPreDownloadItem.businessEngName);
    localHashMap.put("department", paramPreDownloadItem.department);
    localHashMap.put("fileKey", paramPreDownloadItem.fileKey);
    localHashMap.put("downloadUrl", paramPreDownloadItem.downloadUrl);
    localHashMap.put("filePath", paramPreDownloadItem.filePath);
    localHashMap.put("reqTime", String.valueOf(paramPreDownloadItem.reqTime));
    localHashMap.put("reqNetWork", String.valueOf(paramPreDownloadItem.reqNetWork));
    localHashMap.put("downNetWork", String.valueOf(paramPreDownloadItem.downNetWork));
    localHashMap.put("startTime", String.valueOf(paramPreDownloadItem.startTime));
    localHashMap.put("downloadTime", String.valueOf(paramPreDownloadItem.downloadTime));
    localHashMap.put("downloadSize", String.valueOf(paramPreDownloadItem.downloadSize));
    localHashMap.put("businessPriority", String.valueOf(paramPreDownloadItem.businessPriority));
    localHashMap.put("innerPriority", String.valueOf(paramPreDownloadItem.innerPriority));
    localHashMap.put("state", String.valueOf(paramPreDownloadItem.state));
    localHashMap.put("reqCondition", String.valueOf(paramPreDownloadItem.reqCondition));
    localHashMap.put("startCondition", String.valueOf(paramPreDownloadItem.startCondition));
    localHashMap.put("saveOnSD", String.valueOf(paramPreDownloadItem.saveOnSD));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[report item]:");
      localStringBuilder.append(", ");
      localStringBuilder.append("businessID");
      localStringBuilder.append("=");
      localStringBuilder.append(paramPreDownloadItem.businessID);
      localStringBuilder.append(", ");
      localStringBuilder.append("businessName");
      localStringBuilder.append("=");
      localStringBuilder.append(paramPreDownloadItem.businessName);
      localStringBuilder.append(", ");
      localStringBuilder.append("businessEngName");
      localStringBuilder.append("=");
      localStringBuilder.append(paramPreDownloadItem.businessEngName);
      localStringBuilder.append(", ");
      localStringBuilder.append("department");
      localStringBuilder.append("=");
      localStringBuilder.append(paramPreDownloadItem.department);
      localStringBuilder.append(", ");
      localStringBuilder.append("fileKey");
      localStringBuilder.append("=");
      localStringBuilder.append(paramPreDownloadItem.fileKey);
      localStringBuilder.append(", ");
      localStringBuilder.append("downloadUrl");
      localStringBuilder.append("=");
      localStringBuilder.append(paramPreDownloadItem.downloadUrl);
      localStringBuilder.append(", ");
      localStringBuilder.append("filePath");
      localStringBuilder.append("=");
      localStringBuilder.append(paramPreDownloadItem.filePath);
      localStringBuilder.append(", ");
      localStringBuilder.append("reqTime");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramPreDownloadItem.reqTime));
      localStringBuilder.append(", ");
      localStringBuilder.append("reqNetWork");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramPreDownloadItem.reqNetWork));
      localStringBuilder.append(", ");
      localStringBuilder.append("downNetWork");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramPreDownloadItem.downNetWork));
      localStringBuilder.append(", ");
      localStringBuilder.append("startTime");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramPreDownloadItem.startTime));
      localStringBuilder.append(", ");
      localStringBuilder.append("downloadTime");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramPreDownloadItem.downloadTime));
      localStringBuilder.append(", ");
      localStringBuilder.append("downloadSize");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramPreDownloadItem.downloadSize));
      localStringBuilder.append(", ");
      localStringBuilder.append("businessPriority");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramPreDownloadItem.businessPriority));
      localStringBuilder.append(", ");
      localStringBuilder.append("innerPriority");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramPreDownloadItem.innerPriority));
      localStringBuilder.append(", ");
      localStringBuilder.append("state");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramPreDownloadItem.state));
      localStringBuilder.append(", ");
      localStringBuilder.append("reqCondition");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramPreDownloadItem.reqCondition));
      localStringBuilder.append(", ");
      localStringBuilder.append("startCondition");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramPreDownloadItem.startCondition));
      localStringBuilder.append(", ");
      localStringBuilder.append("saveOnSD");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramPreDownloadItem.saveOnSD));
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(this.mApp.getApp()).collectPerformance(null, "PreDownloadReport", true, 0L, 0L, localHashMap, null);
  }
  
  private void reportPauseInfo(double paramDouble1, double paramDouble2, String paramString, long paramLong)
  {
    if (!this.mNeedReport) {
      return;
    }
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("downloadUrl", paramString);
    localHashMap.put("downloadSize", String.valueOf(paramLong));
    localHashMap.put("CPU", String.valueOf(paramDouble2));
    localHashMap.put("FPS", String.valueOf(paramDouble1));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[report puse info]:");
      localStringBuilder.append(", ");
      localStringBuilder.append("downloadUrl");
      localStringBuilder.append("=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", ");
      localStringBuilder.append("downloadSize");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramLong));
      localStringBuilder.append(", ");
      localStringBuilder.append("CPU");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramDouble2));
      localStringBuilder.append(", ");
      localStringBuilder.append("FPS");
      localStringBuilder.append("=");
      localStringBuilder.append(String.valueOf(paramDouble1));
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(this.mApp.getApp()).collectPerformance(null, "PreDownloadReportPause", true, 0L, 0L, localHashMap, null);
  }
  
  public AbsPreDownloadTask cancelPreDownload(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[ cancelPreDownload ] downloadUrl = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("PreDownloadScheduler", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Object localObject2;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject2 = this.mLock;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.mPendingList.size())
        {
          PreDownloadItem localPreDownloadItem = (PreDownloadItem)this.mPendingList.get(i);
          if (!paramString.equals(localPreDownloadItem.downloadUrl)) {
            break label149;
          }
          localObject1 = localPreDownloadItem.task;
          break label149;
        }
        localObject2 = new Message();
        ((Message)localObject2).what = 1003;
        ((Message)localObject2).obj = paramString;
        this.mHandler.sendMessage((Message)localObject2);
        return localObject1;
      }
      finally {}
      return null;
      label149:
      i += 1;
    }
  }
  
  public boolean checkState()
  {
    if ((this.mEnable) && (!this.mBeReady))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreDownloadScheduler", 2, "[System busy] dowload not ready!");
      }
      if ((this.mPendingList.size() > 0) && (Math.abs(System.currentTimeMillis() - this.mEnableTime) >= 60000L) && (this.mStartTime == 0L))
      {
        this.mSysVolatilityCount -= 2L;
        this.mCPUThreshold += 10.0D;
        this.mFPSThreshold -= 10.0D;
        this.mFPSReady = true;
        this.mCPUReady = true;
        this.mBeReady = true;
        QLog.d("PreDownloadScheduler", 2, "[System busy] for 60 seconds after pull msg, set download enable");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mCPUThreshold = ");
        localStringBuilder.append(this.mCPUThreshold);
        localStringBuilder.append(",mFPSThreshold=");
        localStringBuilder.append(this.mFPSThreshold);
        QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
        return true;
      }
      return false;
    }
    return true;
  }
  
  public String getPreDownloadPath(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "department should not be empty");
      }
      return null;
    }
    String str = (String)this.mPreDownloadConfigHelper.getBusinessNameEng().get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
      }
      return null;
    }
    Object localObject;
    if (paramBoolean) {
      localObject = this.mSdcardPath;
    } else {
      localObject = this.mInnerPath;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    localStringBuilder.append(str);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getPreDownloadPath] path = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("PreDownloadScheduler", 1, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 1008: 
    case 1009: 
      checkStateToStart();
      break;
    case 1007: 
      paramMessage = (Bundle)paramMessage.obj;
      reportPauseInfo(paramMessage.getDouble("FPS"), paramMessage.getDouble("CPU"), this.mCurSuccessUrl, this.mCurSuccesSize);
      break;
    case 1006: 
      handleMessageForOnTaskEnd(paramMessage);
      break;
    case 1005: 
      checkStateToStart();
      checkTaskToStopFPSCallback();
      break;
    case 1004: 
      handleMessageForDownloadSuccess(paramMessage);
      break;
    case 1003: 
      handleMessageForCancelPreDownload(paramMessage);
      break;
    case 1002: 
      handleMessageForRequestPreDownload(paramMessage);
      break;
    case 1001: 
      handleMessageForStartPreDownload();
    }
    return true;
  }
  
  public void init(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.mApp = paramBaseQQAppInterface;
    this.mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    paramBaseQQAppInterface = new StringBuilder();
    paramBaseQQAppInterface.append(MobileQQ.sMobileQQ.getFilesDir());
    paramBaseQQAppInterface.append("/pddata/");
    this.mInnerPath = paramBaseQQAppInterface.toString();
    paramBaseQQAppInterface = new File(this.mInnerPath);
    if (!paramBaseQQAppInterface.exists()) {
      paramBaseQQAppInterface.mkdirs();
    }
    paramBaseQQAppInterface = new StringBuilder();
    paramBaseQQAppInterface.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    paramBaseQQAppInterface.append("/tencent/MobileQQ/pddata/");
    this.mSdcardPath = paramBaseQQAppInterface.toString();
    this.mSdcardPath = VFSAssistantUtils.getSDKPrivatePath(this.mSdcardPath);
    paramBaseQQAppInterface = new File(this.mSdcardPath);
    if (!paramBaseQQAppInterface.exists()) {
      paramBaseQQAppInterface.mkdirs();
    }
    this.mSysVolatilityCount = 6L;
    this.mFPSThreshold = 30.0D;
    this.mCPUThreshold = 50.0D;
    paramBaseQQAppInterface = MobileQQ.sMobileQQ.getSharedPreferences("sp_pre_downlaod", 0);
    boolean bool2 = paramBaseQQAppInterface.getBoolean("sp_key_pre_sample_mark", false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" pre download bSampledLastTime = ");
    localStringBuilder.append(bool2);
    QLog.e("PreDownloadScheduler", 1, localStringBuilder.toString());
    double d = Math.random();
    boolean bool1;
    if (9.999999747378752E-006D >= d) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mNeedReport = bool1;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" pre download random = ");
    localStringBuilder.append(d);
    QLog.e("PreDownloadScheduler", 1, localStringBuilder.toString());
    if (bool2)
    {
      this.mNeedReport = true;
      paramBaseQQAppInterface.edit().putBoolean("sp_key_pre_sample_mark", false).commit();
      QLog.e("PreDownloadScheduler", 1, " pre download last time sampled, also sampled this time");
    }
    else
    {
      paramBaseQQAppInterface.edit().putBoolean("sp_key_pre_sample_mark", this.mNeedReport).commit();
    }
    paramBaseQQAppInterface = new StringBuilder();
    paramBaseQQAppInterface.append(" pre download set mNeedReport = ");
    paramBaseQQAppInterface.append(this.mNeedReport);
    QLog.e("PreDownloadScheduler", 1, paramBaseQQAppInterface.toString());
  }
  
  public void onAppBackground()
  {
    this.mAppBackground = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ onAppBackground ] mAppBackground = ");
      ((StringBuilder)localObject).append(this.mAppBackground);
      QLog.e("PreDownloadScheduler", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Message();
    ((Message)localObject).what = 1009;
    this.mHandler.sendMessage((Message)localObject);
  }
  
  public void onAppForground()
  {
    this.mCPUReady = false;
    this.mFPSReady = false;
    this.mAppBackground = false;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ onAppForground ] mAppBackground = ");
      ((StringBuilder)localObject).append(this.mAppBackground);
      QLog.e("PreDownloadScheduler", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Message();
    ((Message)localObject).what = 1008;
    this.mHandler.sendMessage((Message)localObject);
  }
  
  public void onAppLiteStart(boolean paramBoolean)
  {
    this.mAppLiteStart = paramBoolean;
  }
  
  public void onDestroy()
  {
    if (this.mEnableFPSAndCPU) {
      FPSCalculator.a().b(this.mFPSListener);
    }
    this.mHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
    synchronized (this.mLock)
    {
      this.mPendingList.removeAll(this.mPendingList);
      ??? = this.mDownloadList;
      ((ArrayList)???).removeAll((Collection)???);
      return;
    }
  }
  
  public void onTaskEnd(AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    Message localMessage = new Message();
    localMessage.what = 1006;
    localMessage.obj = paramAbsPreDownloadTask;
    this.mHandler.sendMessage(localMessage);
  }
  
  public void preDownloadSuccess(String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ preDownloadSuccess ] downloadUrl = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",size = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.e("PreDownloadScheduler", 1, ((StringBuilder)localObject).toString());
    }
    this.mCurSuccessUrl = paramString;
    this.mCurSuccesSize = paramLong;
    Object localObject = new Message();
    ((Message)localObject).what = 1004;
    ((Message)localObject).obj = paramString;
    ((Message)localObject).arg1 = ((int)paramLong);
    this.mHandler.sendMessage((Message)localObject);
  }
  
  public boolean requestPreDownload(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    if ((((IDeviceOptSwitch)QRoute.api(IDeviceOptSwitch.class)).isDisablePreDownload()) && (!((IDeviceOptSwitch)QRoute.api(IDeviceOptSwitch.class)).getPreDownloadWhiteList().contains(Integer.valueOf(paramInt1))) && (!this.mPreDownloadConfigHelper.getPreDownloadWhiteList().contains(Integer.valueOf(paramInt1))))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("delay pre_download,busindessID:");
        paramString1.append(paramInt1);
        QLog.d("Perf", 2, paramString1.toString());
      }
      ((IDeviceOptSwitch)QRoute.api(IDeviceOptSwitch.class)).setDisablePreDownloadTime(System.currentTimeMillis());
      return false;
    }
    if ((paramInt1 != 0) && (!TextUtils.isEmpty(paramString3)) && (paramAbsPreDownloadTask != null))
    {
      String str1 = (String)this.mPreDownloadConfigHelper.getBusinessName().get(Integer.valueOf(paramInt1));
      if (TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PreDownloadScheduler", 1, "Should define name in PreDownloadConstants.BUSINESS_NAME for business");
        }
        return false;
      }
      String str2 = (String)this.mPreDownloadConfigHelper.getBusinessNameEng().get(Integer.valueOf(paramInt1));
      if (TextUtils.isEmpty(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PreDownloadScheduler", 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
        }
        return false;
      }
      Object localObject = (Integer)this.mPreDownloadConfigHelper.getBusinessPriority().get(Integer.valueOf(paramInt1));
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PreDownloadScheduler", 1, "Should define priority in PreDownloadConstants.BUSINESS_PRIORITY for business");
        }
        return false;
      }
      int i = ((Integer)localObject).intValue();
      if ((i >= 0) && (i <= 4))
      {
        localObject = new PreDownloadItem();
        ((PreDownloadItem)localObject).businessID = paramInt1;
        ((PreDownloadItem)localObject).businessName = str1;
        ((PreDownloadItem)localObject).businessEngName = str2;
        ((PreDownloadItem)localObject).department = paramString1;
        ((PreDownloadItem)localObject).fileKey = paramString2;
        ((PreDownloadItem)localObject).downloadUrl = paramString3;
        ((PreDownloadItem)localObject).reqNetWork = paramInt3;
        ((PreDownloadItem)localObject).innerPriority = paramInt2;
        ((PreDownloadItem)localObject).filePath = paramString4;
        ((PreDownloadItem)localObject).state = 0;
        ((PreDownloadItem)localObject).reqTime = System.currentTimeMillis();
        ((PreDownloadItem)localObject).businessPriority = i;
        ((PreDownloadItem)localObject).reqCondition = paramInt4;
        ((PreDownloadItem)localObject).saveOnSD = paramBoolean;
        ((PreDownloadItem)localObject).task = paramAbsPreDownloadTask;
        paramString1 = new Message();
        paramString1.what = 1002;
        paramString1.obj = localObject;
        this.mHandler.sendMessage(paramString1);
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("[ requestPreDownload ]  downloadUrl = ");
          paramString1.append(paramString3);
          QLog.e("PreDownloadScheduler", 1, paramString1.toString());
        }
        return checkState();
      }
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, " requestPreDownload param priority error,priority value should be in[0,1,2,3,4]!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "requestPreDownload param error! busindessID=0 or downloadUrl is empty or task is empty\n");
    }
    return false;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setEnable] enable = ");
      localStringBuilder.append(this.mEnable);
      QLog.e("PreDownloadScheduler", 1, localStringBuilder.toString());
    }
  }
  
  public void startPreDownload()
  {
    this.mEnableTime = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ startPreDownload ] enable time = ");
      localStringBuilder.append(this.mEnableTime);
      QLog.e("PreDownloadScheduler", 1, localStringBuilder.toString());
    }
    if (this.mEnable)
    {
      this.mHandler.sendEmptyMessageDelayed(1001, 10000L);
      return;
    }
    this.mHandler.sendEmptyMessage(1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler
 * JD-Core Version:    0.7.0.1
 */