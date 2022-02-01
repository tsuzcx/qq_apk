package com.tencent.mobileqq.transfile.predownload.schedule;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import bcad;
import bfqd;
import bfqf;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import mqq.manager.Manager;

public class PreDownloadScheduler
  implements Handler.Callback, Manager
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
  private QQAppInterface mApp;
  private boolean mAppBackground;
  private boolean mAppLiteStart;
  private boolean mBeReady;
  private boolean mCPUReady;
  private long mCPUReadyCount;
  private double mCPUThreshold = 50.0D;
  private PreDownloadScheduler.MyComparator mComparator = new PreDownloadScheduler.MyComparator(null);
  private double mCurCPU = 0.0D;
  private double mCurFPS = 0.0D;
  private long mCurFPSTime;
  private long mCurSuccesSize;
  private String mCurSuccessUrl;
  private PreDownloadItem mCurrentTask;
  private ArrayList<PreDownloadItem> mDownloadList = new ArrayList(10);
  private boolean mEnable = true;
  private boolean mEnableFPSAndCPU;
  private long mEnableTime;
  private bfqf mFPSListener = new PreDownloadScheduler.1(this);
  private boolean mFPSReady;
  private long mFPSReadyCount;
  private double mFPSThreshold = 30.0D;
  private Handler mHandler;
  private String mInnerPath;
  private Object mLock = new Object();
  private boolean mNeedReport;
  private ArrayList<PreDownloadItem> mPendingList = new ArrayList(10);
  private String mSdcardPath;
  private long mStartTime;
  private long mSysVolatilityCount = 6L;
  
  public PreDownloadScheduler(QQAppInterface paramQQAppInterface)
  {
    init(paramQQAppInterface);
  }
  
  private void checkStateToStart()
  {
    if ((this.mCurrentTask != null) && (Math.abs(System.currentTimeMillis() - this.mCurrentTask.startTime) >= 60000L)) {
      this.mCurrentTask = null;
    }
    int j;
    int k;
    if ((checkState()) && (this.mCurrentTask == null) && (this.mPendingList.size() > 0))
    {
      Collections.sort(this.mPendingList, this.mComparator);
      j = getStartUpCondition();
      k = NetworkUtil.getNetworkType(this.mApp.getApp());
      if (k != 0) {
        break label103;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreDownloadScheduler", 2, " [no network] donot start any task! ");
      }
    }
    return;
    for (;;)
    {
      label103:
      int i;
      synchronized (this.mLock)
      {
        printDownloadTaskInfo();
        i = 0;
        if (i >= this.mPendingList.size()) {
          break;
        }
        PreDownloadItem localPreDownloadItem1 = (PreDownloadItem)this.mPendingList.get(i);
        if ((localPreDownloadItem1 != null) && (localPreDownloadItem1.reqCondition == 1) && (j == 1))
        {
          printRemoveTaskInfo(localPreDownloadItem1);
          this.mPendingList.remove(i);
          return;
        }
      }
      if ((localPreDownloadItem2 != null) && (((localPreDownloadItem2.reqCondition == 2) && (!this.mAppBackground)) || ((localPreDownloadItem2.reqNetWork == 1) && (k > 1)) || ((k > 1) && (k < localPreDownloadItem2.reqNetWork)) || ((localPreDownloadItem2.reqCondition == 3) && (!this.mAppLiteStart))))
      {
        printIgnoreTaskInfo(k, localPreDownloadItem2);
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
      this.mCurrentTask.downNetWork = getNetworkName(this.mApp);
      this.mCurrentTask.state = 1;
      this.mCurrentTask.task.start();
      this.mDownloadList.add(this.mCurrentTask);
      printStartTaskInfo("[start downloading] begin task :", this.mCurrentTask);
    }
    for (;;)
    {
      return;
      this.mCurrentTask = null;
    }
  }
  
  private void checkTaskToStopFPSCallback()
  {
    if (this.mEnableFPSAndCPU)
    {
      if (this.mPendingList.size() <= 0)
      {
        bfqd.a().b(this.mFPSListener);
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadScheduler", 2, "[fps callback disabled],there is no pending task!");
        }
      }
      if (this.mPendingList.size() > 0)
      {
        bfqd.a().a(this.mFPSListener);
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadScheduler", 2, "[fps callback enabled],there is pending tasks!");
        }
      }
    }
  }
  
  private void directDownloadItem(PreDownloadItem paramPreDownloadItem)
  {
    int i = NetworkUtil.getNetworkType(this.mApp.getApp());
    if ((i <= 1) || (i >= paramPreDownloadItem.reqNetWork))
    {
      paramPreDownloadItem.startCondition = getStartUpCondition();
      paramPreDownloadItem.startTime = System.currentTimeMillis();
      paramPreDownloadItem.downNetWork = getNetworkName(this.mApp);
      paramPreDownloadItem.state = 1;
      paramPreDownloadItem.task.start();
      this.mDownloadList.add(paramPreDownloadItem);
      printStartTaskInfo("[start downloading direct without contrl] begin task :", paramPreDownloadItem);
      report(paramPreDownloadItem);
    }
  }
  
  private static String getNetworkName(QQAppInterface paramQQAppInterface)
  {
    switch (NetworkUtil.getNetworkType(paramQQAppInterface.getApp()))
    {
    default: 
      return "unknown";
    case 0: 
      return "none";
    case 1: 
      return "Wi-Fi";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "5G";
  }
  
  public static String getPreDownloadPathStatic(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "department should not be empty");
      }
      paramString = null;
      return paramString;
    }
    String str3 = (String)PreDownloadConstants.BUSINESS_NAME_ENG.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(str3))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
      }
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        String str1 = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/pddata/");
        File localFile = new File(str1);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        str1 = str1 + paramString + "/" + str3;
        paramString = str1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("PreDownloadScheduler", 1, "[getPreDownloadPath] path = " + str1);
        return str1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PreDownloadScheduler", 1, "Exception:", localException);
        }
        str2 = VFSAssistantUtils.getSDKPrivatePath("/sdcard/tencent/MobileQQ/pddata/");
        continue;
      }
      String str2 = BaseApplicationImpl.getContext().getFilesDir() + "/pddata/";
    }
  }
  
  private int getStartUpCondition()
  {
    int i = 0;
    if (BaseApplicationImpl.isFirstLaunchNew) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreDownloadScheduler", 2, " getStartUpCondition  condition = " + i);
      }
      return i;
      if (BaseApplicationImpl.isCurrentVersionFirstLaunch) {
        i = 2;
      }
    }
  }
  
  private void handleMessageForCancelPreDownload(Message paramMessage)
  {
    paramMessage = (String)paramMessage.obj;
    if (!TextUtils.isEmpty(paramMessage))
    {
      int i = 0;
      while (i < this.mPendingList.size())
      {
        PreDownloadItem localPreDownloadItem = (PreDownloadItem)this.mPendingList.get(i);
        if (paramMessage.equals(localPreDownloadItem.downloadUrl))
        {
          this.mPendingList.remove(localPreDownloadItem);
          localPreDownloadItem.state = 3;
          report(localPreDownloadItem);
          if (QLog.isColorLevel()) {
            QLog.e("PreDownloadScheduler", 1, "[ msg cancel] task.url = " + localPreDownloadItem.downloadUrl);
          }
          if (localPreDownloadItem == this.mCurrentTask) {
            this.mCurrentTask = null;
          }
          checkTaskToStopFPSCallback();
        }
        i += 1;
      }
    }
    checkStateToStart();
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
          if (QLog.isColorLevel()) {
            QLog.e("PreDownloadScheduler", 1, "[msg download sucess] task.url = " + paramMessage.downloadUrl);
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
    if ((this.mCurrentTask != null) && (this.mCurrentTask.task != null) && (paramMessage != null) && (this.mCurrentTask.task == paramMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, " pre download onTaskEnd task key = " + this.mCurrentTask.task.key);
      }
      this.mCurrentTask = null;
    }
    checkStateToStart();
  }
  
  private void handleMessageForRequestPreDownload(Message paramMessage)
  {
    int j = 0;
    PreDownloadItem localPreDownloadItem1 = (PreDownloadItem)paramMessage.obj;
    int i;
    label138:
    int k;
    if (this.mEnable)
    {
      paramMessage = this.mLock;
      i = 0;
      PreDownloadItem localPreDownloadItem3;
      try
      {
        if (i >= this.mPendingList.size()) {
          break label332;
        }
        localPreDownloadItem3 = (PreDownloadItem)this.mPendingList.get(i);
        if (!localPreDownloadItem1.downloadUrl.equals(localPreDownloadItem3.downloadUrl)) {
          break label337;
        }
        if ((!localPreDownloadItem1.downloadUrl.contains("doodle")) || (localPreDownloadItem1.filePath == null) || (localPreDownloadItem1.filePath.equals(localPreDownloadItem3.filePath))) {
          break label344;
        }
        if (!QLog.isColorLevel()) {
          break label337;
        }
        QLog.d("PreDownloadScheduler", 2, new Object[] { "mPendingList, same url, filePath diff, ", localPreDownloadItem1.downloadUrl });
      }
      finally {}
      k = i;
      if (j < this.mDownloadList.size())
      {
        localPreDownloadItem3 = (PreDownloadItem)this.mDownloadList.get(j);
        if (!localPreDownloadItem1.downloadUrl.equals(localPreDownloadItem3.downloadUrl)) {
          break label349;
        }
        if ((!localPreDownloadItem1.downloadUrl.contains("doodle")) || (localPreDownloadItem1.filePath == null) || (localPreDownloadItem1.filePath.equals(localPreDownloadItem3.filePath))) {
          break label356;
        }
        if (!QLog.isColorLevel()) {
          break label349;
        }
        QLog.d("PreDownloadScheduler", 2, new Object[] { "downloadUrl, same url, filePath diff, ", localPreDownloadItem1.downloadUrl });
        break label349;
      }
    }
    for (;;)
    {
      if (k == 0) {
        this.mPendingList.add(localPreDownloadItem1);
      }
      for (;;)
      {
        checkStateToStart();
        checkTaskToStopFPSCallback();
        if (QLog.isColorLevel()) {
          QLog.e("PreDownloadScheduler", 1, " [msg request add to list]  mPendingList size = " + this.mPendingList.size());
        }
        return;
        directDownloadItem(localPreDownloadItem2);
      }
      label332:
      i = 0;
      break label138;
      label337:
      i += 1;
      break;
      label344:
      i = 1;
      break label138;
      label349:
      j += 1;
      break label138;
      label356:
      k = 1;
    }
  }
  
  private void handleMessageForStartPreDownload()
  {
    this.mBeReady = true;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "startPreDownload mBeReady set true, all pre download will start ");
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_pre_downlaod", 0);
    int i = localSharedPreferences.getInt("sp_key_pre_download_version", 0);
    if (i != 0)
    {
      ArrayList localArrayList = PreDownloadController.onVersionUpdate(i, 0);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        i = 0;
        while (i < localArrayList.size())
        {
          if (QLog.isColorLevel()) {
            QLog.e("PreDownloadScheduler", 1, "[onVersionUpdate PreDownloadScheduler]  delete file: " + (String)localArrayList.get(i));
          }
          FileUtils.delete((String)localArrayList.get(i), false);
          i += 1;
        }
      }
    }
    localSharedPreferences.edit().putInt("sp_key_pre_download_version", 0).commit();
    checkStateToStart();
    checkTaskToStopFPSCallback();
  }
  
  private void printDownloadTaskInfo()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("pending task id:");
      int i = 0;
      while (i < this.mPendingList.size())
      {
        PreDownloadItem localPreDownloadItem = (PreDownloadItem)this.mPendingList.get(i);
        if (localPreDownloadItem != null) {
          localStringBuilder.append(localPreDownloadItem.businessID).append(",");
        }
        i += 1;
      }
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
  }
  
  private void printIgnoreTaskInfo(int paramInt, PreDownloadItem paramPreDownloadItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[network or reqconditon not fit] donot download task :\n");
      localStringBuilder.append(",businessID=").append(paramPreDownloadItem.businessID);
      localStringBuilder.append(",businessName=").append(paramPreDownloadItem.businessName);
      localStringBuilder.append(",downloadUrl=").append(paramPreDownloadItem.downloadUrl);
      localStringBuilder.append(",reqCondition=").append(paramPreDownloadItem.reqCondition);
      localStringBuilder.append(",current appBackground=").append(this.mAppBackground);
      localStringBuilder.append(",reqNetWork=").append(paramPreDownloadItem.reqNetWork);
      localStringBuilder.append(",current netWorkType=").append(paramInt);
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
  }
  
  private void printRemoveTaskInfo(PreDownloadItem paramPreDownloadItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[forbidden on first start] remove task :\n");
      localStringBuilder.append(",businessID=").append(paramPreDownloadItem.businessID);
      localStringBuilder.append(",businessName=").append(paramPreDownloadItem.businessName);
      localStringBuilder.append(",downloadUrl=").append(paramPreDownloadItem.downloadUrl);
      localStringBuilder.append(",reqCondition=").append(paramPreDownloadItem.reqCondition);
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
  }
  
  private void printStartTaskInfo(String paramString, PreDownloadItem paramPreDownloadItem)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder(paramString);
      paramString.append(",businessID=").append(paramPreDownloadItem.businessID);
      paramString.append(",businessName=").append(paramPreDownloadItem.businessName);
      paramString.append(",downloadUrl=").append(paramPreDownloadItem.downloadUrl);
      paramString.append(",fileKey=").append(paramPreDownloadItem.fileKey);
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
      localStringBuilder.append(", ").append("businessID").append("=").append(paramPreDownloadItem.businessID);
      localStringBuilder.append(", ").append("businessName").append("=").append(paramPreDownloadItem.businessName);
      localStringBuilder.append(", ").append("businessEngName").append("=").append(paramPreDownloadItem.businessEngName);
      localStringBuilder.append(", ").append("department").append("=").append(paramPreDownloadItem.department);
      localStringBuilder.append(", ").append("fileKey").append("=").append(paramPreDownloadItem.fileKey);
      localStringBuilder.append(", ").append("downloadUrl").append("=").append(paramPreDownloadItem.downloadUrl);
      localStringBuilder.append(", ").append("filePath").append("=").append(paramPreDownloadItem.filePath);
      localStringBuilder.append(", ").append("reqTime").append("=").append(String.valueOf(paramPreDownloadItem.reqTime));
      localStringBuilder.append(", ").append("reqNetWork").append("=").append(String.valueOf(paramPreDownloadItem.reqNetWork));
      localStringBuilder.append(", ").append("downNetWork").append("=").append(String.valueOf(paramPreDownloadItem.downNetWork));
      localStringBuilder.append(", ").append("startTime").append("=").append(String.valueOf(paramPreDownloadItem.startTime));
      localStringBuilder.append(", ").append("downloadTime").append("=").append(String.valueOf(paramPreDownloadItem.downloadTime));
      localStringBuilder.append(", ").append("downloadSize").append("=").append(String.valueOf(paramPreDownloadItem.downloadSize));
      localStringBuilder.append(", ").append("businessPriority").append("=").append(String.valueOf(paramPreDownloadItem.businessPriority));
      localStringBuilder.append(", ").append("innerPriority").append("=").append(String.valueOf(paramPreDownloadItem.innerPriority));
      localStringBuilder.append(", ").append("state").append("=").append(String.valueOf(paramPreDownloadItem.state));
      localStringBuilder.append(", ").append("reqCondition").append("=").append(String.valueOf(paramPreDownloadItem.reqCondition));
      localStringBuilder.append(", ").append("startCondition").append("=").append(String.valueOf(paramPreDownloadItem.startCondition));
      localStringBuilder.append(", ").append("saveOnSD").append("=").append(String.valueOf(paramPreDownloadItem.saveOnSD));
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "PreDownloadReport", true, 0L, 0L, localHashMap, null);
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
      localStringBuilder.append(", ").append("downloadUrl").append("=").append(paramString);
      localStringBuilder.append(", ").append("downloadSize").append("=").append(String.valueOf(paramLong));
      localStringBuilder.append(", ").append("CPU").append("=").append(String.valueOf(paramDouble2));
      localStringBuilder.append(", ").append("FPS").append("=").append(String.valueOf(paramDouble1));
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "PreDownloadReportPause", true, 0L, 0L, localHashMap, null);
  }
  
  public AbsPreDownloadTask cancelPreDownload(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ cancelPreDownload ] downloadUrl = " + paramString);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject3 = this.mLock;
      i = 0;
      localObject1 = localObject2;
    }
    for (;;)
    {
      try
      {
        if (i < this.mPendingList.size())
        {
          localObject2 = (PreDownloadItem)this.mPendingList.get(i);
          if (paramString.equals(((PreDownloadItem)localObject2).downloadUrl)) {
            localObject1 = ((PreDownloadItem)localObject2).task;
          }
        }
        else
        {
          localObject2 = new Message();
          ((Message)localObject2).what = 1003;
          ((Message)localObject2).obj = paramString;
          this.mHandler.sendMessage((Message)localObject2);
          return localObject1;
        }
      }
      finally {}
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
        QLog.d("PreDownloadScheduler", 2, "mCPUThreshold = " + this.mCPUThreshold + ",mFPSThreshold=" + this.mFPSThreshold);
      }
    }
    else
    {
      return true;
    }
    return false;
  }
  
  public String getPreDownloadPath(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "department should not be empty");
      }
      paramString = null;
      return paramString;
    }
    String str2 = (String)PreDownloadConstants.BUSINESS_NAME_ENG.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(str2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
      }
      return null;
    }
    if (paramBoolean) {}
    for (String str1 = this.mSdcardPath;; str1 = this.mInnerPath)
    {
      str1 = str1 + paramString + "/" + str2;
      paramString = str1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("PreDownloadScheduler", 1, "[getPreDownloadPath] path = " + str1);
      return str1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      handleMessageForStartPreDownload();
      continue;
      handleMessageForRequestPreDownload(paramMessage);
      continue;
      handleMessageForCancelPreDownload(paramMessage);
      continue;
      handleMessageForDownloadSuccess(paramMessage);
      continue;
      checkStateToStart();
      checkTaskToStopFPSCallback();
      continue;
      paramMessage = (Bundle)paramMessage.obj;
      reportPauseInfo(paramMessage.getDouble("FPS"), paramMessage.getDouble("CPU"), this.mCurSuccessUrl, this.mCurSuccesSize);
      continue;
      handleMessageForOnTaskEnd(paramMessage);
      continue;
      checkStateToStart();
    }
  }
  
  public void init(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mInnerPath = (BaseApplicationImpl.getContext().getFilesDir() + "/pddata/");
    paramQQAppInterface = new File(this.mInnerPath);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    this.mSdcardPath = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/pddata/");
    this.mSdcardPath = VFSAssistantUtils.getSDKPrivatePath(this.mSdcardPath);
    paramQQAppInterface = new File(this.mSdcardPath);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    this.mSysVolatilityCount = 6L;
    this.mFPSThreshold = 30.0D;
    this.mCPUThreshold = 50.0D;
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences("sp_pre_downlaod", 0);
    boolean bool2 = paramQQAppInterface.getBoolean("sp_key_pre_sample_mark", false);
    QLog.e("PreDownloadScheduler", 1, " pre download bSampledLastTime = " + bool2);
    double d = Math.random();
    boolean bool1;
    if (9.999999747378752E-006D >= d)
    {
      bool1 = true;
      this.mNeedReport = bool1;
      QLog.e("PreDownloadScheduler", 1, " pre download random = " + d);
      if (!bool2) {
        break label331;
      }
      this.mNeedReport = true;
      paramQQAppInterface.edit().putBoolean("sp_key_pre_sample_mark", false).commit();
      QLog.e("PreDownloadScheduler", 1, " pre download last time sampled, also sampled this time");
    }
    for (;;)
    {
      QLog.e("PreDownloadScheduler", 1, " pre download set mNeedReport = " + this.mNeedReport);
      return;
      bool1 = false;
      break;
      label331:
      paramQQAppInterface.edit().putBoolean("sp_key_pre_sample_mark", this.mNeedReport).commit();
    }
  }
  
  public void onAppBackground()
  {
    this.mAppBackground = true;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ onAppBackground ] mAppBackground = " + this.mAppBackground);
    }
    Message localMessage = new Message();
    localMessage.what = 1009;
    this.mHandler.sendMessage(localMessage);
  }
  
  public void onAppForground()
  {
    this.mCPUReady = false;
    this.mFPSReady = false;
    this.mAppBackground = false;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ onAppForground ] mAppBackground = " + this.mAppBackground);
    }
    Message localMessage = new Message();
    localMessage.what = 1008;
    this.mHandler.sendMessage(localMessage);
  }
  
  public void onAppLiteStart(boolean paramBoolean)
  {
    this.mAppLiteStart = paramBoolean;
  }
  
  public void onDestroy()
  {
    if (this.mEnableFPSAndCPU) {
      bfqd.a().b(this.mFPSListener);
    }
    this.mHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
    synchronized (this.mLock)
    {
      this.mPendingList.removeAll(this.mPendingList);
      this.mDownloadList.removeAll(this.mDownloadList);
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
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ preDownloadSuccess ] downloadUrl = " + paramString + ",size = " + paramLong);
    }
    this.mCurSuccessUrl = paramString;
    this.mCurSuccesSize = paramLong;
    Message localMessage = new Message();
    localMessage.what = 1004;
    localMessage.obj = paramString;
    localMessage.arg1 = ((int)paramLong);
    this.mHandler.sendMessage(localMessage);
  }
  
  public boolean requestPreDownload(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    if ((bcad.e) && (!bcad.a.contains(Integer.valueOf(paramInt1))) && (!PreDownloadConstants.sPreDownloadWhiteList.contains(Integer.valueOf(paramInt1))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "delay pre_download,busindessID:" + paramInt1);
      }
      bcad.f = System.currentTimeMillis();
      return false;
    }
    if ((paramInt1 == 0) || (TextUtils.isEmpty(paramString3)) || (paramAbsPreDownloadTask == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "requestPreDownload param error! busindessID=0 or downloadUrl is empty or task is empty\n");
      }
      return false;
    }
    String str1 = (String)PreDownloadConstants.BUSINESS_NAME.get(Integer.valueOf(paramInt1));
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define name in PreDownloadConstants.BUSINESS_NAME for business");
      }
      return false;
    }
    String str2 = (String)PreDownloadConstants.BUSINESS_NAME_ENG.get(Integer.valueOf(paramInt1));
    if (TextUtils.isEmpty(str2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
      }
      return false;
    }
    Object localObject = (Integer)PreDownloadConstants.BUSINESS_PRIORITY.get(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define priority in PreDownloadConstants.BUSINESS_PRIORITY for business");
      }
      return false;
    }
    int i = ((Integer)localObject).intValue();
    if ((i < 0) || (i > 4))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, " requestPreDownload param priority error,priority value should be in[0,1,2,3,4]!");
      }
      return false;
    }
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
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ requestPreDownload ]  downloadUrl = " + paramString3);
    }
    return checkState();
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[setEnable] enable = " + this.mEnable);
    }
  }
  
  public void startPreDownload()
  {
    this.mEnableTime = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ startPreDownload ] enable time = " + this.mEnableTime);
    }
    if (this.mEnable)
    {
      this.mHandler.sendEmptyMessageDelayed(1001, 10000L);
      return;
    }
    this.mHandler.sendEmptyMessage(1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler
 * JD-Core Version:    0.7.0.1
 */