package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.JudgeDownloadReq;
import Wallet.ResInfo;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadModule;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class PreloadResourceImpl
  implements IPreloadResource
{
  private static final long serialVersionUID = 1L;
  private transient PreloadFlowControlConfig a;
  private transient boolean b;
  private transient long c = 0L;
  public String mAbi;
  public String mDownloadTime;
  public int mFilePos;
  public boolean mFlowControl;
  public int mFromType;
  @Deprecated
  public boolean mHasUnzip;
  public String mInvalidTime;
  public boolean mIsFromLocal = false;
  @Deprecated
  public boolean mIsNeedUnzip;
  public boolean mIsTemp;
  @Deprecated
  public boolean mIsUnzipInside;
  private PreloadResourceImpl.PreloadTimerTask mReqTask = null;
  public String mResId;
  public int mRetryTime = 0;
  @Deprecated
  public String mUnzipPrefix;
  public String md5;
  public String netType;
  public int size;
  public int type;
  public String url;
  public String urlPath;
  
  public PreloadResourceImpl() {}
  
  public PreloadResourceImpl(PreloadResourceImpl paramPreloadResourceImpl)
  {
    this();
    this.url = paramPreloadResourceImpl.url;
    this.urlPath = paramPreloadResourceImpl.urlPath;
    this.type = paramPreloadResourceImpl.type;
    this.md5 = paramPreloadResourceImpl.md5;
    this.mDownloadTime = paramPreloadResourceImpl.mDownloadTime;
    this.mInvalidTime = paramPreloadResourceImpl.mInvalidTime;
    this.netType = paramPreloadResourceImpl.netType;
    this.size = paramPreloadResourceImpl.size;
    this.mResId = paramPreloadResourceImpl.mResId;
    this.mFlowControl = paramPreloadResourceImpl.mFlowControl;
    this.mIsFromLocal = paramPreloadResourceImpl.mIsFromLocal;
    this.mIsTemp = paramPreloadResourceImpl.mIsTemp;
    this.mRetryTime = paramPreloadResourceImpl.mRetryTime;
    this.mIsNeedUnzip = paramPreloadResourceImpl.mIsNeedUnzip;
    this.mIsUnzipInside = paramPreloadResourceImpl.mIsUnzipInside;
    this.mUnzipPrefix = paramPreloadResourceImpl.mUnzipPrefix;
    this.mHasUnzip = paramPreloadResourceImpl.mHasUnzip;
    this.mFromType = paramPreloadResourceImpl.mFromType;
    this.mFilePos = paramPreloadResourceImpl.mFilePos;
    this.mAbi = paramPreloadResourceImpl.mAbi;
  }
  
  private void a(DownloadListener paramDownloadListener, PreloadModuleImpl paramPreloadModuleImpl, PreloadServiceImpl paramPreloadServiceImpl)
  {
    if (paramDownloadListener == null) {
      return;
    }
    paramPreloadServiceImpl = getResDownloadUrl(paramPreloadModuleImpl);
    paramPreloadServiceImpl = new DownloadTask(paramPreloadServiceImpl, new File(PreloadStaticApi.b(paramPreloadServiceImpl, getFilePos())));
    paramPreloadServiceImpl.c = 0;
    paramPreloadServiceImpl.a(getDownloadParams(paramPreloadModuleImpl));
    paramDownloadListener.onDoneFile(paramPreloadServiceImpl);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return (PreloadStaticApi.c(paramString2, this.type)) && (!isFolderPathValid(getFolderPath(paramString2, paramString1)));
  }
  
  public static boolean checkFolderAndUnzip(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = isFolderPathValid(paramString2);
      if (bool) {
        return true;
      }
      bool = PreloadStaticApi.a(paramString1, paramString2);
      return bool;
    }
    finally {}
  }
  
  public static String getFolderPathByMD5AndUrl(String paramString1, String paramString2, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      paramString1 = MD5.toMD5(localStringBuilder.toString());
      paramString2 = new StringBuilder();
      paramString2.append(PreloadStaticApi.a(paramInt));
      paramString2.append(paramString1);
      return paramString2.toString();
    }
    return null;
  }
  
  public static boolean isFolderPathValid(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()) && (FileUtils.getFileOrFolderSize(paramString) > 0L);
  }
  
  public static boolean isPreloadRetryProtectTestOpen()
  {
    return MobileQQ.getContext().getSharedPreferences("envSwitch", 4).getBoolean("qwalley_key_preload_retry_protect", false);
  }
  
  public static boolean isValidToReport(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1000L;
  }
  
  public static PreloadResourceImpl parsePreloadResource(JSONObject paramJSONObject, PreloadModuleImpl paramPreloadModuleImpl, boolean paramBoolean, int paramInt)
  {
    PreloadResourceImpl localPreloadResourceImpl = new PreloadResourceImpl();
    for (;;)
    {
      try
      {
        localPreloadResourceImpl.url = paramJSONObject.optString("url");
        localPreloadResourceImpl.urlPath = paramJSONObject.optString("url_path");
        localPreloadResourceImpl.type = paramJSONObject.optInt("type");
        localPreloadResourceImpl.md5 = paramJSONObject.optString("md5");
        localPreloadResourceImpl.mDownloadTime = paramJSONObject.optString("download_time");
        localPreloadResourceImpl.mInvalidTime = paramJSONObject.optString("invalid_time");
        localPreloadResourceImpl.netType = paramJSONObject.optString("net_type");
        localPreloadResourceImpl.size = paramJSONObject.optInt("size");
        int i = paramJSONObject.optInt("flow_control");
        boolean bool2 = true;
        if (i == 1)
        {
          bool1 = true;
          localPreloadResourceImpl.mFlowControl = bool1;
          localPreloadResourceImpl.mIsFromLocal = paramBoolean;
          if (paramJSONObject.optInt("is_temp") != 1) {
            break label296;
          }
          paramBoolean = true;
          localPreloadResourceImpl.mIsTemp = paramBoolean;
          if (paramJSONObject.optInt("is_need_unzip") != 1) {
            break label301;
          }
          paramBoolean = true;
          localPreloadResourceImpl.mIsNeedUnzip = paramBoolean;
          if (paramJSONObject.optInt("is_unzip_inside") != 1) {
            break label306;
          }
          paramBoolean = bool2;
          localPreloadResourceImpl.mIsUnzipInside = paramBoolean;
          localPreloadResourceImpl.mUnzipPrefix = paramJSONObject.optString("unzip_prefix");
          localPreloadResourceImpl.mFromType = paramInt;
          localPreloadResourceImpl.mFilePos = paramJSONObject.optInt("file_pos", 0);
          localPreloadResourceImpl.mAbi = paramJSONObject.optString("abi", "32");
          paramJSONObject = paramJSONObject.optString("res_id");
          if (!TextUtils.isEmpty(paramJSONObject))
          {
            localPreloadResourceImpl.mResId = paramJSONObject;
            return localPreloadResourceImpl;
          }
          localPreloadResourceImpl.mResId = localPreloadResourceImpl.getResDownloadUrl(paramPreloadModuleImpl);
          return localPreloadResourceImpl;
        }
      }
      catch (Throwable paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localPreloadResourceImpl;
      }
      boolean bool1 = false;
      continue;
      label296:
      paramBoolean = false;
      continue;
      label301:
      paramBoolean = false;
      continue;
      label306:
      paramBoolean = false;
    }
  }
  
  public static boolean unzipToCustomPath(String paramString1, String paramString2)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        if (PreloadStaticApi.e(paramString2))
        {
          boolean bool = QWalletTools.a(paramString1, paramString2, true);
          return bool;
        }
        return false;
      }
      return false;
    }
    finally {}
  }
  
  public void deleteResFile(PreloadModuleImpl paramPreloadModuleImpl, PreloadServiceImpl paramPreloadServiceImpl, int paramInt)
  {
    FileUtils.deleteFile(PreloadFlowControlConfig.getConfigPath(this.mResId, paramPreloadServiceImpl.mApp));
    paramPreloadModuleImpl = getResDownloadUrl(paramPreloadModuleImpl);
    paramPreloadServiceImpl = PreloadStaticApi.b(paramPreloadModuleImpl, getFilePos());
    if (paramInt == 9) {
      ResDownRecordUtil.a(paramPreloadModuleImpl, getFilePos());
    } else {
      ResDownRecordUtil.a(paramPreloadModuleImpl, paramInt, getFilePos());
    }
    if (PreloadStaticApi.c(paramPreloadModuleImpl, this.type))
    {
      String str = getFolderPath(this.url, paramPreloadServiceImpl);
      if (!TextUtils.isEmpty(str)) {
        FileUtils.delete(str, false);
      }
    }
    FileUtils.deleteFile(paramPreloadServiceImpl);
    ResUtil.d(paramPreloadModuleImpl, getFilePos());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof PreloadResourceImpl)))
    {
      paramObject = (PreloadResourceImpl)paramObject;
      if (QWalletTools.c(this.mResId, paramObject.mResId)) {
        return true;
      }
    }
    return false;
  }
  
  public Bundle getDownloadParams(PreloadModuleImpl paramPreloadModuleImpl)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("module", paramPreloadModuleImpl);
    localBundle.putSerializable("resource", this);
    return localBundle;
  }
  
  public int getFilePos()
  {
    if (PreloadStaticApi.a) {
      return 1;
    }
    return this.mFilePos;
  }
  
  public DownloadListener getFlowControlDownloadListener(long paramLong, DownloadListener paramDownloadListener, PreloadServiceImpl paramPreloadServiceImpl, int paramInt)
  {
    return new PreloadResourceImpl.2(this, paramInt, new WeakReference(paramPreloadServiceImpl), paramDownloadListener, paramLong);
  }
  
  public String getFolderPath(String paramString1, String paramString2)
  {
    if (PreloadStaticApi.c(paramString1, this.type)) {
      return getFolderPathByMD5AndUrl(ResUtil.c(paramString1, paramString2, getFilePos()), paramString1, getFilePos());
    }
    return null;
  }
  
  public ArrayList<ResInfo> getMyResInfos()
  {
    return getMyResInfos(this.size);
  }
  
  public ArrayList<ResInfo> getMyResInfos(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ResInfo localResInfo = new ResInfo();
    try
    {
      localResInfo.sResId = this.mResId;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    localResInfo.iSize = paramInt;
    localArrayList.add(localResInfo);
    return localArrayList;
  }
  
  public String getResDownloadUrl(IPreloadModule paramIPreloadModule)
  {
    if (!TextUtils.isEmpty(this.url)) {
      return this.url;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramIPreloadModule.getBaseUrl());
    localStringBuilder.append("/");
    localStringBuilder.append(this.urlPath);
    return localStringBuilder.toString();
  }
  
  public String getResId()
  {
    return this.mResId;
  }
  
  public ResourceInfo getResInfo(PreloadModuleImpl paramPreloadModuleImpl)
  {
    paramPreloadModuleImpl = ResUtil.a(getResDownloadUrl(paramPreloadModuleImpl), this.mIsNeedUnzip ^ true, this.type, getFilePos());
    paramPreloadModuleImpl.type = this.type;
    paramPreloadModuleImpl.resId = this.mResId;
    return paramPreloadModuleImpl;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public boolean handleAbnormalRetry(PreloadModuleImpl paramPreloadModuleImpl)
  {
    int i = ResUtil.b(getResDownloadUrl(paramPreloadModuleImpl), getFilePos());
    long l = ResUtil.c(getResDownloadUrl(paramPreloadModuleImpl), getFilePos());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[handleAbnormalRetry]:");
      localStringBuilder.append(this.url);
      localStringBuilder.append("|");
      localStringBuilder.append(i);
      localStringBuilder.append("|");
      localStringBuilder.append(l);
      localStringBuilder.append("|");
      localStringBuilder.append(paramPreloadModuleImpl.mRetryTimeInterval);
      localStringBuilder.append("|");
      localStringBuilder.append(paramPreloadModuleImpl.mRetryCount);
      QLog.d("PreloadResource", 2, localStringBuilder.toString());
    }
    if (isRetryProtectOpen()) {
      if (i > paramPreloadModuleImpl.mRetryCount)
      {
        if (!isResFileExist(paramPreloadModuleImpl)) {
          return true;
        }
      }
      else if ((i >= 1) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - l) < paramPreloadModuleImpl.mRetryTimeInterval * 60 * 60 * 1000))
      {
        this.b = true;
        if (QLog.isColorLevel())
        {
          paramPreloadModuleImpl = new StringBuilder();
          paramPreloadModuleImpl.append("ignore set to true for");
          paramPreloadModuleImpl.append(this.mResId);
          QLog.d("PreloadResource", 2, paramPreloadModuleImpl.toString());
        }
        return false;
      }
    }
    this.b = false;
    return false;
  }
  
  public void handleFlowConfig(IPreloadService arg1, PreloadModuleImpl paramPreloadModuleImpl, DownloadListener paramDownloadListener)
  {
    PreloadServiceImpl localPreloadServiceImpl = (PreloadServiceImpl)???;
    if (isResFileExist(paramPreloadModuleImpl))
    {
      if (isNeedUnzip(paramPreloadModuleImpl)) {
        unzip(PreloadStaticApi.b(getResDownloadUrl(paramPreloadModuleImpl), getFilePos()), getResDownloadUrl(paramPreloadModuleImpl));
      }
      if (paramDownloadListener != null) {
        a(paramDownloadListener, paramPreloadModuleImpl, localPreloadServiceImpl);
      }
      localPreloadServiceImpl.notifyResFlowCheckNext();
      return;
    }
    if (this.a == null) {
      this.a = PreloadFlowControlConfig.getFlowControlConfig(this.mResId, localPreloadServiceImpl.mApp);
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append(this.mResId);
      ???.append("handleFlowConfig:");
      ???.append(this.a.mDownloadStatus);
      QLog.d("PreloadResource", 2, ???.toString());
    }
    long l1 = localPreloadServiceImpl.mApp.getLongAccountUin();
    String str1 = DeviceInfoUtil.u();
    String str2 = DeviceInfoUtil.e();
    float f1 = (float)DeviceInfoUtil.k();
    float f2 = (float)DeviceInfoUtil.l();
    int i = DeviceInfoUtil.h();
    long l2 = DeviceInfoUtil.a() / 1024L;
    synchronized (this.a)
    {
      int j = this.a.mDownloadStatus;
      long l3;
      Object localObject1;
      if (j != -1) {
        if (j != 0) {
          if (j != 1)
          {
            if (j != 2)
            {
              localPreloadServiceImpl.notifyResFlowCheckNext();
              break label1030;
            }
            l3 = NetConnInfoCenter.getServerTimeMillis();
            if (!QLog.isColorLevel()) {
              break label1033;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.mResId);
            ((StringBuilder)localObject1).append(" STATUS_NOT_DOWNLOAD|");
            ((StringBuilder)localObject1).append(l3);
            ((StringBuilder)localObject1).append("|");
            ((StringBuilder)localObject1).append(this.a.mNextCanReqTime);
            QLog.d("PreloadResource", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      label1030:
      label1033:
      for (;;)
      {
        if (l3 > this.a.mNextCanReqTime)
        {
          startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, paramPreloadModuleImpl, paramDownloadListener);
        }
        else
        {
          localPreloadServiceImpl.notifyResFlowCheckNext();
          if (paramDownloadListener != null)
          {
            notifyListenerDownloadFailInFlowControl(paramDownloadListener, paramPreloadModuleImpl, localPreloadServiceImpl);
            break label1030;
            l3 = NetConnInfoCenter.getServerTimeMillis();
            if (!QLog.isColorLevel()) {
              break;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.mResId);
            ((StringBuilder)localObject1).append("STATUS_NOW_DOWNLOAD|");
            ((StringBuilder)localObject1).append(l3);
            ((StringBuilder)localObject1).append("|");
            ((StringBuilder)localObject1).append(this.a.mValidDownloadTime);
            QLog.d("PreloadResource", 2, ((StringBuilder)localObject1).toString());
            if (l3 < this.a.mValidDownloadTime) {
              if (isTimeToDownload(localPreloadServiceImpl))
              {
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append(this.mResId);
                  ((StringBuilder)localObject1).append("begin download");
                  QLog.d("PreloadResource", 2, ((StringBuilder)localObject1).toString());
                }
                i = this.a.mRetryDownloadTimes;
                localObject1 = ???;
              }
            }
          }
        }
        for (;;)
        {
          try
          {
            startDownloadRes(paramPreloadModuleImpl, localPreloadServiceImpl, getFlowControlDownloadListener(l1, paramDownloadListener, localPreloadServiceImpl, i), true);
            continue;
            IPreloadService localIPreloadService = ???;
            localObject1 = localIPreloadService;
            localPreloadServiceImpl.notifyResFlowCheckNext();
            if (paramDownloadListener != null)
            {
              localObject1 = localIPreloadService;
              notifyListenerDownloadFailInFlowControl(paramDownloadListener, paramPreloadModuleImpl, localPreloadServiceImpl);
              continue;
              localObject1 = ???;
              startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, paramPreloadModuleImpl, paramDownloadListener);
              continue;
              localIPreloadService = ???;
              localObject1 = localIPreloadService;
              l3 = NetConnInfoCenter.getServerTimeMillis();
              localObject1 = localIPreloadService;
              long l4 = this.a.mNextRetryReqTime - l3;
              localObject1 = localIPreloadService;
              Object localObject2;
              if (QLog.isColorLevel())
              {
                localObject1 = localIPreloadService;
                localObject2 = new StringBuilder();
                localObject1 = localIPreloadService;
                ((StringBuilder)localObject2).append(this.mResId);
                localObject1 = localIPreloadService;
                ((StringBuilder)localObject2).append("STATUS_WAIT_TO_REQ|");
                localObject1 = localIPreloadService;
                ((StringBuilder)localObject2).append(l3);
                localObject1 = localIPreloadService;
                ((StringBuilder)localObject2).append("|");
                localObject1 = localIPreloadService;
                ((StringBuilder)localObject2).append(this.a.mNextRetryReqTime);
                localObject1 = localIPreloadService;
                ((StringBuilder)localObject2).append("|");
                localObject1 = localIPreloadService;
                ((StringBuilder)localObject2).append(l4);
                localObject1 = localIPreloadService;
                QLog.d("PreloadResource", 2, ((StringBuilder)localObject2).toString());
              }
              if (l4 <= 0L)
              {
                localObject1 = localIPreloadService;
                localObject2 = getMyResInfos();
                localObject1 = localIPreloadService;
                PreloadFlowControlConfig localPreloadFlowControlConfig = this.a;
                localObject1 = localIPreloadService;
                j = localPreloadFlowControlConfig.mRetryReqTimes + 1;
                localObject1 = localIPreloadService;
                localPreloadFlowControlConfig.mRetryReqTimes = j;
                localObject1 = localIPreloadService;
                startFlowControlReq(JudgeDownloadReq.createReq((ArrayList)localObject2, l1, j, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, paramPreloadModuleImpl, paramDownloadListener);
              }
              else
              {
                localObject1 = localIPreloadService;
                if (this.mReqTask != null)
                {
                  localObject1 = localIPreloadService;
                  if (!this.mReqTask.b()) {}
                }
                else
                {
                  localObject1 = localIPreloadService;
                  this.mReqTask = new PreloadResourceImpl.1(this, new WeakReference(localPreloadServiceImpl), paramPreloadModuleImpl);
                  localObject1 = localIPreloadService;
                  ThreadManager.getTimer().schedule(this.mReqTask, l4);
                }
                localObject1 = localIPreloadService;
                localPreloadServiceImpl.notifyResFlowCheckNext();
                if (paramDownloadListener != null)
                {
                  localObject1 = localIPreloadService;
                  notifyListenerDownloadFailInFlowControl(paramDownloadListener, paramPreloadModuleImpl, localPreloadServiceImpl);
                  continue;
                  localObject1 = ???;
                  startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, paramPreloadModuleImpl, paramDownloadListener);
                }
              }
            }
            localObject1 = ???;
            return;
          }
          finally
          {
            paramPreloadModuleImpl = (PreloadModuleImpl)localObject1;
            continue;
          }
          localObject1 = paramPreloadModuleImpl;
          throw ???;
        }
      }
    }
  }
  
  public boolean isAbiMatch()
  {
    if (TextUtils.isEmpty(this.mAbi)) {
      return true;
    }
    String[] arrayOfString = this.mAbi.split("\\|");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (("32".equals(str)) && (!SoDataUtil.c())) {
        return true;
      }
      if (("64".equals(str)) && (SoDataUtil.c())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isChosenToReport()
  {
    Object localObject = QWalletTools.b();
    if (localObject == null) {
      return false;
    }
    IQWalletConfigService localIQWalletConfigService = (IQWalletConfigService)((AppRuntime)localObject).getRuntimeService(IQWalletConfigService.class, "");
    int i = 10000;
    if (localIQWalletConfigService != null) {
      i = localIQWalletConfigService.getInt("report", 10000, new String[] { "preDownSampleBase" });
    }
    if (i == 0) {
      return false;
    }
    int k = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getInt(((AppRuntime)localObject).getCurrentUin(), "download_report_random", 0);
    int j = k;
    if (k == 0)
    {
      j = new Random(((AppRuntime)localObject).getLongAccountUin()).nextInt();
      ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putInt(((AppRuntime)localObject).getCurrentUin(), "download_report_random", j);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isChosenToReport|");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(i);
      QLog.d("PreloadResource", 2, ((StringBuilder)localObject).toString());
    }
    return j % i == 0;
  }
  
  public boolean isInValidTime()
  {
    long l1 = QWalletTools.d(this.mInvalidTime);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if ((l1 != -1L) && (l1 < l2))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mResId);
        localStringBuilder.append(" out of date");
        QLog.d("PreloadResource", 2, localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
  
  public boolean isNeedDeleteOldFileWhenUpdate(PreloadModuleImpl paramPreloadModuleImpl, PreloadResourceImpl paramPreloadResourceImpl, PreloadServiceImpl paramPreloadServiceImpl)
  {
    if (getFilePos() != paramPreloadResourceImpl.getFilePos()) {
      return true;
    }
    if (!this.md5.equalsIgnoreCase(paramPreloadResourceImpl.md5))
    {
      paramPreloadModuleImpl = getResDownloadUrl(paramPreloadModuleImpl);
      paramPreloadServiceImpl = PreloadStaticApi.b(paramPreloadModuleImpl, getFilePos());
      if ((!TextUtils.isEmpty(paramPreloadResourceImpl.md5)) && (!paramPreloadResourceImpl.md5.equalsIgnoreCase(ResUtil.c(paramPreloadModuleImpl, paramPreloadServiceImpl, getFilePos())))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isNeedReport(String paramString)
  {
    if (!isChosenToReport()) {
      return false;
    }
    if (!this.mIsFromLocal) {
      return true;
    }
    Object localObject1 = QWalletTools.b();
    if (localObject1 != null)
    {
      Object localObject2 = (IQWalletConfigService)((AppRuntime)localObject1).getRuntimeService(IQWalletConfigService.class, "");
      if (localObject2 != null)
      {
        localObject2 = ((IQWalletConfigService)localObject2).getConfig("preload");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).contains(paramString))) {
          return true;
        }
      }
      localObject1 = PreloadStaticApi.d(((AppRuntime)localObject1).getCurrentUin());
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isNeedUnzip(PreloadModuleImpl paramPreloadModuleImpl)
  {
    if (paramPreloadModuleImpl != null) {
      return a(PreloadStaticApi.b(getResDownloadUrl(paramPreloadModuleImpl), getFilePos()), getResDownloadUrl(paramPreloadModuleImpl));
    }
    return false;
  }
  
  public boolean isResChange(PreloadResourceImpl paramPreloadResourceImpl)
  {
    if (!QWalletTools.c(this.url, paramPreloadResourceImpl.url)) {
      return true;
    }
    if (!QWalletTools.c(this.urlPath, paramPreloadResourceImpl.urlPath)) {
      return true;
    }
    if (this.type != paramPreloadResourceImpl.type) {
      return true;
    }
    if (!QWalletTools.c(this.md5, paramPreloadResourceImpl.md5)) {
      return true;
    }
    if (!QWalletTools.c(this.mDownloadTime, paramPreloadResourceImpl.mDownloadTime)) {
      return true;
    }
    if (!QWalletTools.c(this.mInvalidTime, paramPreloadResourceImpl.mInvalidTime)) {
      return true;
    }
    if (!QWalletTools.c(this.netType, paramPreloadResourceImpl.netType)) {
      return true;
    }
    if (this.size != paramPreloadResourceImpl.size) {
      return true;
    }
    if (this.mFlowControl != paramPreloadResourceImpl.mFlowControl) {
      return true;
    }
    if (!QWalletTools.c(this.mResId, paramPreloadResourceImpl.mResId)) {
      return true;
    }
    if (this.mIsFromLocal != paramPreloadResourceImpl.mIsFromLocal) {
      return true;
    }
    if (this.mIsTemp != paramPreloadResourceImpl.mIsTemp) {
      return true;
    }
    if (this.mRetryTime != paramPreloadResourceImpl.mRetryTime) {
      return true;
    }
    if (this.mIsNeedUnzip != paramPreloadResourceImpl.mIsNeedUnzip) {
      return true;
    }
    if (this.mIsUnzipInside != paramPreloadResourceImpl.mIsUnzipInside) {
      return true;
    }
    if (!QWalletTools.c(this.mUnzipPrefix, paramPreloadResourceImpl.mUnzipPrefix)) {
      return true;
    }
    if (this.mHasUnzip != paramPreloadResourceImpl.mHasUnzip) {
      return true;
    }
    if (this.mFromType != paramPreloadResourceImpl.mFromType) {
      return true;
    }
    if (this.mFilePos != paramPreloadResourceImpl.mFilePos) {
      return true;
    }
    return !TextUtils.equals(this.mAbi, paramPreloadResourceImpl.mAbi);
  }
  
  public boolean isResFileExist(IPreloadModule paramIPreloadModule)
  {
    paramIPreloadModule = getResDownloadUrl(paramIPreloadModule);
    StringBuilder localStringBuilder;
    if (new File(PreloadStaticApi.b(paramIPreloadModule, getFilePos())).exists())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ResFileExist|");
        localStringBuilder.append(this.mResId);
        localStringBuilder.append("|");
        localStringBuilder.append(paramIPreloadModule);
        QLog.d("PreloadResource", 2, localStringBuilder.toString());
      }
      return true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ResFileNotExist|");
      localStringBuilder.append(this.mResId);
      localStringBuilder.append("|");
      localStringBuilder.append(paramIPreloadModule);
      QLog.d("PreloadResource", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean isRetryProtectOpen()
  {
    return true;
  }
  
  public boolean isTimeToDownload(PreloadServiceImpl paramPreloadServiceImpl)
  {
    if (this.b) {
      return false;
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = QWalletTools.d(this.mDownloadTime);
    return ((l2 == -1L) || (l2 < l1)) && (paramPreloadServiceImpl.isNetValidToDownload(this.netType));
  }
  
  public void notifyListenerDownloadFailInFlowControl(DownloadListener paramDownloadListener, PreloadModuleImpl paramPreloadModuleImpl, PreloadServiceImpl paramPreloadServiceImpl)
  {
    if (paramDownloadListener == null) {
      return;
    }
    paramPreloadServiceImpl = getResDownloadUrl(paramPreloadModuleImpl);
    paramPreloadServiceImpl = new DownloadTask(paramPreloadServiceImpl, new File(PreloadStaticApi.b(paramPreloadServiceImpl, getFilePos())));
    paramPreloadServiceImpl.c = -5;
    paramPreloadServiceImpl.a(getDownloadParams(paramPreloadModuleImpl));
    paramDownloadListener.onDoneFile(paramPreloadServiceImpl);
  }
  
  public void reportDownload(String paramString, int paramInt, PreloadModuleImpl paramPreloadModuleImpl)
  {
    if (isValidToReport(this.c, System.currentTimeMillis()))
    {
      this.c = System.currentTimeMillis();
      if (paramInt == 0) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      if (paramPreloadModuleImpl == null) {
        paramPreloadModuleImpl = "";
      } else {
        paramPreloadModuleImpl = paramPreloadModuleImpl.mid;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      localStringBuilder.append(paramPreloadModuleImpl);
      localStringBuilder.append("|");
      localStringBuilder.append(this.mResId);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString);
      VACDReportUtil.b(localStringBuilder.toString(), "QWalletStat", "downloadReport", null, null, 0, null);
    }
  }
  
  public void startDownload(PreloadServiceImpl paramPreloadServiceImpl, PreloadModuleImpl paramPreloadModuleImpl, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    if (this.mFlowControl)
    {
      paramPreloadServiceImpl.addResToFlowControlCheck(new PreloadServiceImpl.FlowControlDownloadStruct(this, paramPreloadModuleImpl, paramDownloadListener));
      return;
    }
    startDownloadRes(paramPreloadModuleImpl, paramPreloadServiceImpl, paramDownloadListener, paramBoolean);
  }
  
  public void startDownloadRes(PreloadModuleImpl paramPreloadModuleImpl, PreloadServiceImpl paramPreloadServiceImpl, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    String str1 = getResDownloadUrl(paramPreloadModuleImpl);
    String str2 = PreloadStaticApi.b(str1, getFilePos());
    Bundle localBundle = getDownloadParams(paramPreloadModuleImpl);
    if (isResFileExist(paramPreloadModuleImpl))
    {
      if (isNeedUnzip(paramPreloadModuleImpl)) {
        unzip(str2, str1);
      }
      a(paramDownloadListener, paramPreloadModuleImpl, paramPreloadServiceImpl);
      return;
    }
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    paramPreloadModuleImpl = new DownloadParam();
    paramPreloadModuleImpl.url = str1;
    paramPreloadModuleImpl.filePath = str2;
    paramPreloadModuleImpl.isPreDownload = paramBoolean;
    PreloadComDownloader.a().a(paramPreloadModuleImpl, new PreloadResourceImpl.DefaultDownloadListener(this, paramDownloadListener), localBundle);
  }
  
  public void startFlowControlReq(JudgeDownloadReq paramJudgeDownloadReq, PreloadServiceImpl paramPreloadServiceImpl, PreloadModuleImpl paramPreloadModuleImpl, DownloadListener paramDownloadListener)
  {
    QWalletCommonServlet.a(paramJudgeDownloadReq, new PreloadResourceImpl.3(this, new WeakReference(paramPreloadServiceImpl), paramDownloadListener, paramPreloadModuleImpl), 1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Res [");
    localStringBuilder.append(this.mResId);
    localStringBuilder.append("|");
    localStringBuilder.append(this.mFlowControl);
    localStringBuilder.append("|");
    localStringBuilder.append(this.mIsFromLocal);
    localStringBuilder.append("|");
    localStringBuilder.append(this.mIsNeedUnzip);
    localStringBuilder.append("|");
    localStringBuilder.append(this.mIsUnzipInside);
    localStringBuilder.append("|");
    localStringBuilder.append(this.mUnzipPrefix);
    localStringBuilder.append("|");
    localStringBuilder.append(this.mHasUnzip);
    localStringBuilder.append("|");
    localStringBuilder.append(this.mFromType);
    localStringBuilder.append("|");
    localStringBuilder.append(this.mFilePos);
    localStringBuilder.append("|");
    localStringBuilder.append(this.mAbi);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void unzip(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    checkFolderAndUnzip(paramString1, getFolderPath(paramString2, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl
 * JD-Core Version:    0.7.0.1
 */