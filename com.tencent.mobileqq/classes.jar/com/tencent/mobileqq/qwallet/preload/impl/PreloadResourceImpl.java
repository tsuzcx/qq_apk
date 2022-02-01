package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.JudgeDownloadReq;
import Wallet.ResInfo;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadModule;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class PreloadResourceImpl
  implements IPreloadResource
{
  private static final long serialVersionUID = 1L;
  private transient long jdField_a_of_type_Long = 0L;
  private transient PreloadFlowControlConfig jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig;
  private transient boolean jdField_a_of_type_Boolean;
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
    paramPreloadServiceImpl.a = 0;
    paramPreloadServiceImpl.a(getDownloadParams(paramPreloadModuleImpl));
    paramDownloadListener.onDoneFile(paramPreloadServiceImpl);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return (PreloadStaticApi.a(paramString2, this.type)) && (!isFolderPathValid(getFolderPath(paramString2, paramString1)));
  }
  
  /* Error */
  public static boolean checkFolderAndUnzip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 141	com/tencent/mobileqq/qwallet/preload/impl/PreloadResourceImpl:isFolderPathValid	(Ljava/lang/String;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq +10 -> 19
    //   12: iconst_1
    //   13: istore_2
    //   14: ldc 2
    //   16: monitorexit
    //   17: iload_2
    //   18: ireturn
    //   19: aload_0
    //   20: aload_1
    //   21: invokestatic 151	com/tencent/mobileqq/qwallet/preload/PreloadStaticApi:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   24: istore_2
    //   25: goto -11 -> 14
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	paramString1	String
    //   0	34	1	paramString2	String
    //   7	18	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	8	28	finally
    //   19	25	28	finally
  }
  
  public static String getFolderPathByMD5AndUrl(String paramString1, String paramString2, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = MD5.toMD5(paramString2 + paramString1);
      return PreloadStaticApi.a(paramInt) + paramString1;
    }
    return null;
  }
  
  public static boolean isFolderPathValid(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()) && (FileUtils.b(paramString) > 0L);
  }
  
  public static boolean isPreloadRetryProtectTestOpen()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("envSwitch", 4).getBoolean("qwalley_key_preload_retry_protect", false);
  }
  
  public static boolean isValidToReport(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1000L;
  }
  
  public static PreloadResourceImpl parsePreloadResource(JSONObject paramJSONObject, PreloadModuleImpl paramPreloadModuleImpl, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
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
        if (paramJSONObject.optInt("flow_control") == 1)
        {
          bool1 = true;
          localPreloadResourceImpl.mFlowControl = bool1;
          localPreloadResourceImpl.mIsFromLocal = paramBoolean;
          if (paramJSONObject.optInt("is_temp") != 1) {
            break label278;
          }
          paramBoolean = true;
          localPreloadResourceImpl.mIsTemp = paramBoolean;
          if (paramJSONObject.optInt("is_need_unzip") != 1) {
            break label283;
          }
          paramBoolean = true;
          localPreloadResourceImpl.mIsNeedUnzip = paramBoolean;
          if (paramJSONObject.optInt("is_unzip_inside") != 1) {
            break label288;
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
      label278:
      paramBoolean = false;
      continue;
      label283:
      paramBoolean = false;
      continue;
      label288:
      paramBoolean = false;
    }
  }
  
  /* Error */
  public static boolean unzipToCustomPath(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: iload_3
    //   6: istore_2
    //   7: aload_0
    //   8: invokestatic 159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +14 -> 25
    //   14: aload_1
    //   15: invokestatic 159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifeq +10 -> 30
    //   23: iload_3
    //   24: istore_2
    //   25: ldc 2
    //   27: monitorexit
    //   28: iload_2
    //   29: ireturn
    //   30: iload_3
    //   31: istore_2
    //   32: aload_1
    //   33: invokestatic 273	com/tencent/mobileqq/qwallet/preload/PreloadStaticApi:a	(Ljava/lang/String;)Z
    //   36: ifeq -11 -> 25
    //   39: aload_0
    //   40: aload_1
    //   41: iconst_1
    //   42: invokestatic 278	com/tencent/mobileqq/activity/qwallet/utils/QWalletTools:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   45: istore_2
    //   46: goto -21 -> 25
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString1	String
    //   0	55	1	paramString2	String
    //   6	40	2	bool1	boolean
    //   1	30	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   7	19	49	finally
    //   32	46	49	finally
  }
  
  public void deleteResFile(PreloadModuleImpl paramPreloadModuleImpl, PreloadServiceImpl paramPreloadServiceImpl, int paramInt)
  {
    FileUtils.e(PreloadFlowControlConfig.getConfigPath(this.mResId, paramPreloadServiceImpl.mApp));
    paramPreloadModuleImpl = getResDownloadUrl(paramPreloadModuleImpl);
    paramPreloadServiceImpl = PreloadStaticApi.b(paramPreloadModuleImpl, getFilePos());
    if (paramInt == 9) {
      ResDownRecordUtil.a(paramPreloadModuleImpl, getFilePos());
    }
    for (;;)
    {
      if (PreloadStaticApi.a(paramPreloadModuleImpl, this.type))
      {
        String str = getFolderPath(this.url, paramPreloadServiceImpl);
        if (!TextUtils.isEmpty(str)) {
          FileUtils.a(str, false);
        }
      }
      FileUtils.e(paramPreloadServiceImpl);
      ResUtil.b(paramPreloadModuleImpl, getFilePos());
      return;
      ResDownRecordUtil.a(paramPreloadModuleImpl, paramInt, getFilePos());
    }
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
    if (PreloadStaticApi.jdField_a_of_type_Boolean) {
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
    if (PreloadStaticApi.a(paramString1, this.type)) {
      return getFolderPathByMD5AndUrl(ResUtil.b(paramString1, paramString2, getFilePos()), paramString1, getFilePos());
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
      localResInfo.iSize = paramInt;
      localArrayList.add(localResInfo);
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public String getResDownloadUrl(IPreloadModule paramIPreloadModule)
  {
    if (!TextUtils.isEmpty(this.url)) {
      return this.url;
    }
    return paramIPreloadModule.getBaseUrl() + "/" + this.urlPath;
  }
  
  public String getResId()
  {
    return this.mResId;
  }
  
  public ResourceInfo getResInfo(PreloadModuleImpl paramPreloadModuleImpl)
  {
    paramPreloadModuleImpl = getResDownloadUrl(paramPreloadModuleImpl);
    if (!this.mIsNeedUnzip) {}
    for (boolean bool = true;; bool = false)
    {
      paramPreloadModuleImpl = ResUtil.a(paramPreloadModuleImpl, bool, this.type, getFilePos());
      paramPreloadModuleImpl.type = this.type;
      paramPreloadModuleImpl.resId = this.mResId;
      return paramPreloadModuleImpl;
    }
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public boolean handleAbnormalRetry(PreloadModuleImpl paramPreloadModuleImpl)
  {
    int i = ResUtil.a(getResDownloadUrl(paramPreloadModuleImpl), getFilePos());
    long l = ResUtil.a(getResDownloadUrl(paramPreloadModuleImpl), getFilePos());
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, "[handleAbnormalRetry]:" + this.url + "|" + i + "|" + l + "|" + paramPreloadModuleImpl.mRetryTimeInterval + "|" + paramPreloadModuleImpl.mRetryCount);
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
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, "ignore set to true for" + this.mResId);
        }
        return false;
      }
    }
    this.jdField_a_of_type_Boolean = false;
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
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig = PreloadFlowControlConfig.getFlowControlConfig(this.mResId, localPreloadServiceImpl.mApp);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, this.mResId + "handleFlowConfig:" + this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mDownloadStatus);
    }
    long l1 = localPreloadServiceImpl.mApp.getLongAccountUin();
    String str1 = DeviceInfoUtil.i();
    String str2 = DeviceInfoUtil.c();
    float f1 = (float)DeviceInfoUtil.b();
    float f2 = (float)DeviceInfoUtil.c();
    int i = DeviceInfoUtil.b();
    long l2 = DeviceInfoUtil.a() / 1024L;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig)
      {
        switch (this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mDownloadStatus)
        {
        case -1: 
          localPreloadServiceImpl.notifyResFlowCheckNext();
          return;
        }
      }
      startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, paramPreloadModuleImpl, paramDownloadListener);
      continue;
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, this.mResId + "STATUS_NOW_DOWNLOAD|" + l3 + "|" + this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mValidDownloadTime);
      }
      if (l3 < this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mValidDownloadTime)
      {
        if (isTimeToDownload(localPreloadServiceImpl))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadResource", 2, this.mResId + "begin download");
          }
          startDownloadRes(paramPreloadModuleImpl, localPreloadServiceImpl, getFlowControlDownloadListener(l1, paramDownloadListener, localPreloadServiceImpl, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mRetryDownloadTimes), true);
        }
        else
        {
          localPreloadServiceImpl.notifyResFlowCheckNext();
          if (paramDownloadListener != null) {
            notifyListenerDownloadFailInFlowControl(paramDownloadListener, paramPreloadModuleImpl, localPreloadServiceImpl);
          }
        }
      }
      else
      {
        startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, paramPreloadModuleImpl, paramDownloadListener);
        continue;
        l3 = NetConnInfoCenter.getServerTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.mResId + " STATUS_NOT_DOWNLOAD|" + l3 + "|" + this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mNextCanReqTime);
        }
        if (l3 > this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mNextCanReqTime)
        {
          startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), l1, 0, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, paramPreloadModuleImpl, paramDownloadListener);
        }
        else
        {
          localPreloadServiceImpl.notifyResFlowCheckNext();
          if (paramDownloadListener != null)
          {
            notifyListenerDownloadFailInFlowControl(paramDownloadListener, paramPreloadModuleImpl, localPreloadServiceImpl);
            continue;
            l3 = NetConnInfoCenter.getServerTimeMillis();
            long l4 = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mNextRetryReqTime - l3;
            if (QLog.isColorLevel()) {
              QLog.d("PreloadResource", 2, this.mResId + "STATUS_WAIT_TO_REQ|" + l3 + "|" + this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig.mNextRetryReqTime + "|" + l4);
            }
            if (l4 <= 0L)
            {
              ArrayList localArrayList = getMyResInfos();
              PreloadFlowControlConfig localPreloadFlowControlConfig = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadFlowControlConfig;
              int j = localPreloadFlowControlConfig.mRetryReqTimes + 1;
              localPreloadFlowControlConfig.mRetryReqTimes = j;
              startFlowControlReq(JudgeDownloadReq.createReq(localArrayList, l1, j, str1, str2, f1, f2, i, l2), localPreloadServiceImpl, paramPreloadModuleImpl, paramDownloadListener);
            }
            else
            {
              if ((this.mReqTask == null) || (this.mReqTask.a()))
              {
                this.mReqTask = new PreloadResourceImpl.1(this, new WeakReference(localPreloadServiceImpl), paramPreloadModuleImpl);
                ThreadManager.getTimer().schedule(this.mReqTask, l4);
              }
              localPreloadServiceImpl.notifyResFlowCheckNext();
              if (paramDownloadListener != null) {
                notifyListenerDownloadFailInFlowControl(paramDownloadListener, paramPreloadModuleImpl, localPreloadServiceImpl);
              }
            }
          }
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
    for (;;)
    {
      if (i >= j) {
        break label79;
      }
      String str = arrayOfString[i];
      if ((("32".equals(str)) && (!SoDataUtil.a())) || (("64".equals(str)) && (SoDataUtil.a()))) {
        break;
      }
      i += 1;
    }
    label79:
    return false;
  }
  
  public boolean isChosenToReport()
  {
    int i = 10000;
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if (localQQAppInterface == null) {
      return false;
    }
    QWalletConfigManager localQWalletConfigManager = (QWalletConfigManager)localQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    if (localQWalletConfigManager == null) {}
    while (i == 0)
    {
      return false;
      i = localQWalletConfigManager.a("report", 10000, new String[] { "preDownSampleBase" });
    }
    int k = QWalletSetting.a(localQQAppInterface.getCurrentUin(), "download_report_random", 0);
    int j = k;
    if (k == 0)
    {
      j = new Random(localQQAppInterface.getLongAccountUin()).nextInt();
      QWalletSetting.a(localQQAppInterface.getCurrentUin(), "download_report_random", j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, "isChosenToReport|" + j + "|" + i);
    }
    return j % i == 0;
  }
  
  public boolean isInValidTime()
  {
    long l1 = QWalletTools.a(this.mInvalidTime);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if ((l1 != -1L) && (l1 < l2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, this.mResId + " out of date");
      }
      return false;
    }
    return true;
  }
  
  public boolean isNeedDeleteOldFileWhenUpdate(PreloadModuleImpl paramPreloadModuleImpl, PreloadResourceImpl paramPreloadResourceImpl, PreloadServiceImpl paramPreloadServiceImpl)
  {
    if (getFilePos() != paramPreloadResourceImpl.getFilePos()) {}
    do
    {
      return true;
      if (this.md5.equalsIgnoreCase(paramPreloadResourceImpl.md5)) {
        break;
      }
      paramPreloadModuleImpl = getResDownloadUrl(paramPreloadModuleImpl);
      paramPreloadServiceImpl = PreloadStaticApi.b(paramPreloadModuleImpl, getFilePos());
    } while ((!TextUtils.isEmpty(paramPreloadResourceImpl.md5)) && (!paramPreloadResourceImpl.md5.equalsIgnoreCase(ResUtil.b(paramPreloadModuleImpl, paramPreloadServiceImpl, getFilePos()))));
    return false;
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
    Object localObject1 = QWalletTools.a();
    if (localObject1 != null)
    {
      Object localObject2 = (QWalletConfigManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
      if (localObject2 != null)
      {
        localObject2 = ((QWalletConfigManager)localObject2).a("preload");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).contains(paramString))) {
          return true;
        }
      }
      localObject1 = PreloadStaticApi.d(((QQAppInterface)localObject1).getCurrentUin());
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
    if (!QWalletTools.c(this.url, paramPreloadResourceImpl.url)) {}
    while ((!QWalletTools.c(this.urlPath, paramPreloadResourceImpl.urlPath)) || (this.type != paramPreloadResourceImpl.type) || (!QWalletTools.c(this.md5, paramPreloadResourceImpl.md5)) || (!QWalletTools.c(this.mDownloadTime, paramPreloadResourceImpl.mDownloadTime)) || (!QWalletTools.c(this.mInvalidTime, paramPreloadResourceImpl.mInvalidTime)) || (!QWalletTools.c(this.netType, paramPreloadResourceImpl.netType)) || (this.size != paramPreloadResourceImpl.size) || (this.mFlowControl != paramPreloadResourceImpl.mFlowControl) || (!QWalletTools.c(this.mResId, paramPreloadResourceImpl.mResId)) || (this.mIsFromLocal != paramPreloadResourceImpl.mIsFromLocal) || (this.mIsTemp != paramPreloadResourceImpl.mIsTemp) || (this.mRetryTime != paramPreloadResourceImpl.mRetryTime) || (this.mIsNeedUnzip != paramPreloadResourceImpl.mIsNeedUnzip) || (this.mIsUnzipInside != paramPreloadResourceImpl.mIsUnzipInside) || (!QWalletTools.c(this.mUnzipPrefix, paramPreloadResourceImpl.mUnzipPrefix)) || (this.mHasUnzip != paramPreloadResourceImpl.mHasUnzip) || (this.mFromType != paramPreloadResourceImpl.mFromType) || (this.mFilePos != paramPreloadResourceImpl.mFilePos) || (!TextUtils.equals(this.mAbi, paramPreloadResourceImpl.mAbi))) {
      return true;
    }
    return false;
  }
  
  public boolean isResFileExist(IPreloadModule paramIPreloadModule)
  {
    paramIPreloadModule = getResDownloadUrl(paramIPreloadModule);
    if (new File(PreloadStaticApi.b(paramIPreloadModule, getFilePos())).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "ResFileExist|" + this.mResId + "|" + paramIPreloadModule);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, "ResFileNotExist|" + this.mResId + "|" + paramIPreloadModule);
    }
    return false;
  }
  
  public boolean isRetryProtectOpen()
  {
    return true;
  }
  
  public boolean isTimeToDownload(PreloadServiceImpl paramPreloadServiceImpl)
  {
    if (this.jdField_a_of_type_Boolean) {}
    long l1;
    long l2;
    do
    {
      return false;
      l1 = NetConnInfoCenter.getServerTimeMillis();
      l2 = QWalletTools.a(this.mDownloadTime);
    } while (((l2 != -1L) && (l2 >= l1)) || (!paramPreloadServiceImpl.isNetValidToDownload(this.netType)));
    return true;
  }
  
  public void notifyListenerDownloadFailInFlowControl(DownloadListener paramDownloadListener, PreloadModuleImpl paramPreloadModuleImpl, PreloadServiceImpl paramPreloadServiceImpl)
  {
    if (paramDownloadListener == null) {
      return;
    }
    paramPreloadServiceImpl = getResDownloadUrl(paramPreloadModuleImpl);
    paramPreloadServiceImpl = new DownloadTask(paramPreloadServiceImpl, new File(PreloadStaticApi.b(paramPreloadServiceImpl, getFilePos())));
    paramPreloadServiceImpl.a = -5;
    paramPreloadServiceImpl.a(getDownloadParams(paramPreloadModuleImpl));
    paramDownloadListener.onDoneFile(paramPreloadServiceImpl);
  }
  
  public void reportDownload(String paramString, int paramInt, PreloadModuleImpl paramPreloadModuleImpl)
  {
    if (isValidToReport(this.jdField_a_of_type_Long, System.currentTimeMillis()))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (paramInt != 0) {
        break label102;
      }
      paramInt = 0;
      if (paramPreloadModuleImpl != null) {
        break label107;
      }
    }
    label102:
    label107:
    for (paramPreloadModuleImpl = "";; paramPreloadModuleImpl = paramPreloadModuleImpl.mid)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt).append("|").append(paramPreloadModuleImpl).append("|").append(this.mResId).append("|").append(paramString);
      VACDReportUtil.a(localStringBuilder.toString(), "QWalletStat", "downloadReport", null, null, 0, null);
      return;
      paramInt = 1;
      break;
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
    }
    while (TextUtils.isEmpty(str1)) {
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
    return "Res [" + this.mResId + "|" + this.mFlowControl + "|" + this.mIsFromLocal + "|" + this.mIsNeedUnzip + "|" + this.mIsUnzipInside + "|" + this.mUnzipPrefix + "|" + this.mHasUnzip + "|" + this.mFromType + "|" + this.mFilePos + "|" + this.mAbi + "]";
  }
  
  public void unzip(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    checkFolderAndUnzip(paramString1, getFolderPath(paramString2, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl
 * JD-Core Version:    0.7.0.1
 */