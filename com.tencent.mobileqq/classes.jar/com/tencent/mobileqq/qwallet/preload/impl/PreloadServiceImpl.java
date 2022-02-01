package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.DownloadChooseReq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigApi.ConfigInfo;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.DownloadCallback;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.FlowControlObj;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathsListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.qwallet.preload.PreloadConfBean;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreloadServiceImpl
  extends PreloadManagerAbs
  implements IPreloadService
{
  private static final int PRELOAD_DELAYS_DEFAULT = 30;
  private static final int PRELOAD_DELAYS_MAX = 1800;
  private static final int PRELOAD_DELAYS_MIN = 5;
  private static final int PRELOAD_WAIT_SIZE_MIN = 1024;
  private static final int SAFE_FREE_SPACE = 104857600;
  private PreloadBackControlConfig mBackControlConfig;
  private Handler mFlowControlHandler;
  private HandlerThread mFlowControlThread;
  public boolean mIsOnDestroy = false;
  private int mNeedWaitSize = 1024;
  private PreloadConfig mPreloadConfig;
  private int mPreloadDelays = 30;
  
  /* Error */
  private void checkAndDownload(DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +40 -> 45
    //   8: ldc 71
    //   10: iconst_2
    //   11: new 73	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   18: ldc 76
    //   20: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_2
    //   24: invokevirtual 83	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: ldc 85
    //   29: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   36: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: invokevirtual 101	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:preCheck	()V
    //   49: aload_0
    //   50: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   53: invokevirtual 107	com/tencent/mobileqq/qwallet/preload/impl/PreloadConfig:getModuleNum	()I
    //   56: ifle +12 -> 68
    //   59: aload_0
    //   60: invokespecial 110	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:isDiskEnoughToDownload	()Z
    //   63: istore_3
    //   64: iload_3
    //   65: ifne +6 -> 71
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: aload_0
    //   72: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   75: aload_0
    //   76: invokevirtual 114	com/tencent/mobileqq/qwallet/preload/impl/PreloadConfig:filterInvalidModules	(Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl;)V
    //   79: aload_0
    //   80: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   83: invokevirtual 118	com/tencent/mobileqq/qwallet/preload/impl/PreloadConfig:getModules	()Ljava/util/List;
    //   86: astore 4
    //   88: new 120	java/util/ArrayList
    //   91: dup
    //   92: invokespecial 121	java/util/ArrayList:<init>	()V
    //   95: astore 5
    //   97: new 120	java/util/ArrayList
    //   100: dup
    //   101: invokespecial 121	java/util/ArrayList:<init>	()V
    //   104: astore 6
    //   106: aload 4
    //   108: aload 5
    //   110: aload 6
    //   112: invokestatic 125	com/tencent/mobileqq/qwallet/preload/impl/PreloadConfig:splitModulesByBackControl	(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V
    //   115: aload 6
    //   117: invokeinterface 130 1 0
    //   122: ifle +43 -> 165
    //   125: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +29 -> 157
    //   131: ldc 71
    //   133: iconst_2
    //   134: new 73	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   141: ldc 132
    //   143: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 6
    //   148: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_0
    //   158: aload 6
    //   160: aload_1
    //   161: iload_2
    //   162: invokespecial 134	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:downloadModules	(Ljava/util/List;Lcom/tencent/mobileqq/vip/DownloadListener;Z)V
    //   165: aload 5
    //   167: invokeinterface 130 1 0
    //   172: ifle +43 -> 215
    //   175: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +29 -> 207
    //   181: ldc 71
    //   183: iconst_2
    //   184: new 73	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   191: ldc 136
    //   193: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 5
    //   198: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_0
    //   208: aload 5
    //   210: aload_1
    //   211: iload_2
    //   212: invokespecial 50	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:downloadBackControlModules	(Ljava/util/List;Lcom/tencent/mobileqq/vip/DownloadListener;Z)V
    //   215: aload_0
    //   216: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   219: invokevirtual 139	com/tencent/mobileqq/qwallet/preload/impl/PreloadConfig:savePreloadConfig	()V
    //   222: goto -154 -> 68
    //   225: astore_1
    //   226: aload_0
    //   227: monitorexit
    //   228: aload_1
    //   229: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	PreloadServiceImpl
    //   0	230	1	paramDownloadListener	DownloadListener
    //   0	230	2	paramBoolean	boolean
    //   63	2	3	bool	boolean
    //   86	21	4	localList	List
    //   95	114	5	localArrayList1	ArrayList
    //   104	55	6	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	45	225	finally
    //   45	64	225	finally
    //   71	157	225	finally
    //   157	165	225	finally
    //   165	207	225	finally
    //   207	215	225	finally
    //   215	222	225	finally
  }
  
  private void checkAndDownload(boolean paramBoolean)
  {
    try
    {
      checkAndDownload(null, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("PreloadService", 1, "checkAndDownload is error msg= " + localThrowable.getMessage());
      }
    }
    finally {}
  }
  
  private List<PreloadModuleImpl> delayLargerModulesAndReturnSmallerModules(List<PreloadModuleImpl> paramList, DownloadListener paramDownloadListener)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    PreloadConfig.splitModulesBySize(this.mNeedWaitSize, paramList, localArrayList1, localArrayList2);
    if (localArrayList2.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "delayLargerModulesAndReturnSmallerModules|begin delay download:" + this.mPreloadDelays + "|" + this.mNeedWaitSize + "|" + localArrayList2);
      }
      paramList = new WeakReference(this);
      ThreadManager.getTimer().schedule(new PreloadServiceImpl.4(this, paramList, localArrayList2, paramDownloadListener), this.mPreloadDelays * 1000);
    }
    return localArrayList1;
  }
  
  private void downloadBackControlModules(List<PreloadModuleImpl> paramList, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    if (this.mBackControlConfig == null) {
      return;
    }
    if (!this.mBackControlConfig.isLocalResNewest())
    {
      DownloadChooseReq localDownloadChooseReq = new DownloadChooseReq();
      localDownloadChooseReq.iUin = this.mApp.getLongAccountUin();
      localDownloadChooseReq.vecResInfo = PreloadConfig.modulesToResInfos(paramList);
      QWalletCommonServlet.a(localDownloadChooseReq, new PreloadServiceImpl.3(this, paramList, paramDownloadListener, paramBoolean));
      return;
    }
    paramList = this.mPreloadConfig.resInfosToModules(this.mBackControlConfig.getLastBackResInfos());
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "downloadBackControlModules|choose res:" + paramList);
    }
    downloadModules(paramList, paramDownloadListener, paramBoolean);
  }
  
  private void downloadModules(List<PreloadModuleImpl> paramList, DownloadListener paramDownloadListener)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((PreloadModuleImpl)paramList.next()).downloadModule(false, paramDownloadListener, this, true);
      }
    }
  }
  
  private void downloadModules(List<PreloadModuleImpl> paramList, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    Object localObject = paramList;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "downloadModules|afterGetConfig");
      }
      localObject = delayLargerModulesAndReturnSmallerModules(paramList, paramDownloadListener);
    }
    downloadModules((List)localObject, paramDownloadListener);
  }
  
  private void initFlowControlHandler()
  {
    if (this.mFlowControlHandler == null) {
      this.mFlowControlHandler = new PreloadServiceImpl.8(this, ThreadManager.getSubThreadLooper());
    }
  }
  
  private void initPreloadHelpConfig()
  {
    int i = QWalletSetting.a(this.mApp.getLongAccountUin() + "", "deal_delay_interval", 30);
    int j = QWalletSetting.a(this.mApp.getLongAccountUin() + "", "need_wait_size", 1024);
    setPreloadHelpConfig(i, j);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "initPreloadHelpConfig|" + i + "|" + j + "|" + this.mPreloadDelays + "|" + this.mNeedWaitSize);
    }
  }
  
  private boolean isDiskEnoughToDownload()
  {
    String str = PreloadStaticApi.a();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    long l1 = 0L;
    if (!TextUtils.isEmpty(str))
    {
      long l2 = StorageManager.a(str);
      l1 = l2;
      if (l2 > 104857600L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "isDiskEnoughToDownload|true|" + str + "|" + l2);
        }
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "isDiskEnoughToDownload|false|" + str + "|" + l1);
    }
    return false;
  }
  
  public static boolean isManagerValid(PreloadServiceImpl paramPreloadServiceImpl)
  {
    return (paramPreloadServiceImpl != null) && (!paramPreloadServiceImpl.mIsOnDestroy);
  }
  
  private void saveConfigFromQQToSp(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("qwallet_preload_config", 4);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("config_from_qq" + this.mApp.getAccount(), paramString).apply();
      }
    }
  }
  
  private void startCheckConfig()
  {
    startCheckConfig(false);
  }
  
  private void synDataFromMoggy()
  {
    ThreadManager.executeOnSubThread(new PreloadServiceImpl.1(this));
  }
  
  private void toReportCrash(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append(paramThrowable.toString());
      if (paramThrowable.getStackTrace() != null)
      {
        paramThrowable = paramThrowable.getStackTrace();
        int i = 0;
        while ((i < paramThrowable.length) && (i < 16))
        {
          localStringBuilder.append("\n ");
          localStringBuilder.append(paramThrowable[i].toString());
          i += 1;
        }
      }
      VACDReportUtil.a("preload_crash", "qqwallet", "crash", "Catch", null, 668814, localStringBuilder.toString());
    }
  }
  
  public void addResToFlowControlCheck(IPreloadService.FlowControlObj paramFlowControlObj)
  {
    if (this.mFlowControlHandler == null) {
      initFlowControlHandler();
    }
    Message localMessage = this.mFlowControlHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramFlowControlObj;
    this.mFlowControlHandler.sendMessage(localMessage);
  }
  
  public void downloadModule(String paramString)
  {
    try
    {
      paramString = getModuleByMID(paramString);
      if (paramString != null) {
        paramString.downloadModule(true, null, this, false);
      }
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void downloadModule(String paramString1, String paramString2, IPreloadService.DownloadCallback paramDownloadCallback)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "downloadModule|" + paramString1 + " | " + paramString2);
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          boolean bool = TextUtils.isEmpty(paramString1);
          if ((!bool) && (paramDownloadCallback != null)) {}
        }
        else
        {
          return;
        }
        mergeConfig(paramString2);
        this.mPreloadConfig.savePreloadConfig();
        paramString2 = this.mPreloadConfig.getModuleByID(paramString1);
        if ((paramString2 == null) || (paramString2.getResNum() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadService", 2, "downloadModule|json wrong");
          }
          paramDownloadCallback.onDownloadResFinished(paramString1, -7, null, null);
          continue;
        }
        if (isDiskEnoughToDownload()) {
          break label171;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "downloadModule|disk space not enough");
      }
      paramDownloadCallback.onDownloadResFinished(paramString1, -4, null, null);
      continue;
      label171:
      paramString2.downloadModule(true, new PreloadServiceImpl.7(this, paramString1, paramDownloadCallback), this, false);
    }
  }
  
  public void downloadModule(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = getModuleByName(paramString);
      if (paramString != null) {
        paramString.downloadModule(paramBoolean, null, this, false);
      }
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void downloadRes(String paramString1, String paramString2, IPreloadService.DownloadCallback paramDownloadCallback)
  {
    String str = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "downloadRes|" + paramString1 + "|" + paramString2);
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          mergeConfig(paramString2);
          this.mPreloadConfig.savePreloadConfig();
        }
        Iterator localIterator1 = this.mPreloadConfig.getModules().iterator();
        localObject2 = null;
        if (!localIterator1.hasNext()) {
          break label268;
        }
        PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)localIterator1.next();
        Iterator localIterator2 = localPreloadModuleImpl.getResList().iterator();
        Object localObject1 = localObject2;
        paramString2 = str;
        str = paramString2;
        localObject2 = localObject1;
        if (!localIterator2.hasNext()) {
          continue;
        }
        localObject2 = (PreloadResourceImpl)localIterator2.next();
        if (!QWalletTools.c(paramString1, ((PreloadResourceImpl)localObject2).mResId)) {
          break label265;
        }
        localObject1 = localObject2;
        paramString2 = localPreloadModuleImpl;
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "downloadRes ERR_CONFIG_NOT_EXIST");
      }
      paramDownloadCallback.onDownloadResFinished(null, -7, null, null);
      return;
      if (!isDiskEnoughToDownload())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "downloadRes|disk space not enough");
        }
        paramDownloadCallback.onDownloadResFinished(null, -4, null, null);
      }
      else
      {
        ((PreloadResourceImpl)localObject2).startDownload(this, str, new PreloadServiceImpl.6(this, paramDownloadCallback), false);
        continue;
        label265:
        continue;
        label268:
        if (str != null) {
          if (localObject2 != null) {}
        }
      }
    }
  }
  
  public void downloadUrls(List<String> paramList, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        getResPath((String)paramList.next(), paramOnGetPathListener);
      }
    }
  }
  
  public void getFilePath(String paramString, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    getFilePath(paramString, "", paramOnGetPathListener);
  }
  
  public void getFilePath(String paramString1, String paramString2, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = paramString1;
    localDownloadParam.md5 = paramString2;
    localDownloadParam.isForceUnzip = false;
    localDownloadParam.useQWalletConfig = true;
    getResPath(localDownloadParam, paramOnGetPathListener);
  }
  
  public void getFilePathByResID(String paramString, ResultReceiver paramResultReceiver)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          Iterator localIterator1 = this.mPreloadConfig.getModules().iterator();
          localObject2 = null;
          if (!localIterator1.hasNext()) {
            break label211;
          }
          PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)localIterator1.next();
          Iterator localIterator2 = localPreloadModuleImpl.getResList().iterator();
          localObject1 = localObject2;
          localObject2 = localObject1;
          if (!localIterator2.hasNext()) {
            continue;
          }
          localObject2 = (PreloadResourceImpl)localIterator2.next();
          if (QWalletTools.c(paramString, ((PreloadResourceImpl)localObject2).mResId)) {
            localObject1 = PreloadStaticApi.a(((PreloadResourceImpl)localObject2).getResDownloadUrl(localPreloadModuleImpl), ((PreloadResourceImpl)localObject2).getFilePos());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadService", 2, "getFilePathByResID|" + paramString + "|" + this.mPreloadConfig + "|" + (String)localObject1);
          }
          if (paramResultReceiver != null)
          {
            paramString = new Bundle();
            paramString.putString("path", (String)localObject1);
            paramResultReceiver.send(0, paramString);
          }
          return;
        }
      }
      finally {}
      continue;
      label211:
      localObject1 = localObject2;
    }
  }
  
  public PreloadModuleImpl getModuleByMID(String paramString)
  {
    try
    {
      paramString = this.mPreloadConfig.getModuleByID(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public PreloadModuleImpl getModuleByName(String paramString)
  {
    try
    {
      paramString = this.mPreloadConfig.getModuleByName(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String getResIdByUrl(String paramString)
  {
    return this.mPreloadConfig.getResIdByUrl(paramString);
  }
  
  public ResourceInfo getResInfoByResId(String paramString)
  {
    ResourceInfo localResourceInfo = this.mPreloadConfig.getResInfoByResId(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "getResInfoByResId :" + paramString + "|" + localResourceInfo);
    }
    return localResourceInfo;
  }
  
  public void getResPath(DownloadParam paramDownloadParam, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    if ((paramDownloadParam == null) || (TextUtils.isEmpty(paramDownloadParam.url))) {
      if (paramOnGetPathListener != null) {
        paramOnGetPathListener.onResult(1, IPreloadService.PathResult.getFailRes(null));
      }
    }
    ResourceInfo localResourceInfo;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "getResPath: param" + paramDownloadParam);
      }
      paramDownloadParam.standardlize();
      localResourceInfo = PreloadStaticApi.a(paramDownloadParam.url, paramDownloadParam.isForceUnzip, paramDownloadParam.filePos);
      boolean bool = PreloadStaticApi.a(localResourceInfo, paramDownloadParam);
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "getResPath: isValidFileExist" + bool + "|" + localResourceInfo);
      }
      if (!bool) {
        break;
      }
    } while (paramOnGetPathListener == null);
    IPreloadService.PathResult localPathResult = new IPreloadService.PathResult();
    localPathResult.url = paramDownloadParam.url;
    localPathResult.filePath = localResourceInfo.filePath;
    localPathResult.folderPath = localResourceInfo.folderPath;
    localPathResult.isAlreadyExist = true;
    paramOnGetPathListener.onResult(0, localPathResult);
    return;
    if (localResourceInfo != null)
    {
      ResUtil.b(paramDownloadParam.url, paramDownloadParam.filePos);
      QWalletTools.a(localResourceInfo.filePath);
      QWalletTools.a(localResourceInfo.folderPath);
    }
    realTimeDownload(paramDownloadParam, paramOnGetPathListener);
  }
  
  public void getResPath(LinkedList<DownloadParam> paramLinkedList, IPreloadService.OnGetPathsListener paramOnGetPathsListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "getResPath: params" + paramLinkedList + ",OnGetPathsListener=" + paramOnGetPathsListener);
    }
    if (paramLinkedList == null)
    {
      if (paramOnGetPathsListener != null) {
        paramOnGetPathsListener.a(1, null);
      }
      return;
    }
    new PreloadServiceImpl.MultiDownTask(this, paramLinkedList, paramOnGetPathsListener).a();
  }
  
  public PreloadResourceImpl getResourceByResID(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator1 = this.mPreloadConfig.getModules().iterator();
      Iterator localIterator2;
      do
      {
        localObject2 = localObject1;
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((PreloadModuleImpl)localIterator1.next()).getResList().iterator();
        localObject2 = localObject1;
        localObject1 = localObject2;
      } while (!localIterator2.hasNext());
      localObject1 = (PreloadResourceImpl)localIterator2.next();
      if (!QWalletTools.c(paramString, ((PreloadResourceImpl)localObject1).mResId)) {
        break label100;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      break;
      return localObject2;
      label100:
      localObject1 = localObject2;
    }
  }
  
  public void getUnzipFolderPath(String paramString, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    getUnzipFolderPath(paramString, "", paramOnGetPathListener);
  }
  
  public void getUnzipFolderPath(String paramString1, String paramString2, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = paramString1;
    localDownloadParam.md5 = paramString2;
    localDownloadParam.isForceUnzip = true;
    localDownloadParam.useQWalletConfig = true;
    getResPath(localDownloadParam, paramOnGetPathListener);
  }
  
  public String getUnzipFolderPathByResId(String paramString)
  {
    paramString = getResInfoByResId(paramString);
    if (paramString != null) {
      return paramString.folderPath;
    }
    return null;
  }
  
  /* Error */
  public String getVideoResPathByID(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +41 -> 46
    //   8: ldc 71
    //   10: iconst_2
    //   11: new 73	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 648
    //   21: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 85
    //   30: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   37: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   50: aload_1
    //   51: invokevirtual 438	com/tencent/mobileqq/qwallet/preload/impl/PreloadConfig:getModuleByID	(Ljava/lang/String;)Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadModuleImpl;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +77 -> 133
    //   59: aload_1
    //   60: invokevirtual 467	com/tencent/mobileqq/qwallet/preload/impl/PreloadModuleImpl:getResList	()Ljava/util/List;
    //   63: invokeinterface 238 1 0
    //   68: astore_2
    //   69: aload_2
    //   70: invokeinterface 243 1 0
    //   75: ifeq +58 -> 133
    //   78: aload_2
    //   79: invokeinterface 247 1 0
    //   84: checkcast 469	com/tencent/mobileqq/qwallet/preload/impl/PreloadResourceImpl
    //   87: astore_3
    //   88: aload_3
    //   89: getfield 651	com/tencent/mobileqq/qwallet/preload/impl/PreloadResourceImpl:type	I
    //   92: iconst_5
    //   93: if_icmpne -24 -> 69
    //   96: aload_3
    //   97: getfield 652	com/tencent/mobileqq/qwallet/preload/impl/PreloadResourceImpl:url	Ljava/lang/String;
    //   100: invokestatic 312	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifeq +13 -> 116
    //   106: aload_3
    //   107: getfield 655	com/tencent/mobileqq/qwallet/preload/impl/PreloadResourceImpl:urlPath	Ljava/lang/String;
    //   110: invokestatic 312	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne -44 -> 69
    //   116: aload_3
    //   117: aload_1
    //   118: invokevirtual 529	com/tencent/mobileqq/qwallet/preload/impl/PreloadResourceImpl:getResDownloadUrl	(Lcom/tencent/mobileqq/qwallet/preload/IPreloadModule;)Ljava/lang/String;
    //   121: aload_3
    //   122: invokevirtual 532	com/tencent/mobileqq/qwallet/preload/impl/PreloadResourceImpl:getFilePos	()I
    //   125: invokestatic 535	com/tencent/mobileqq/qwallet/preload/PreloadStaticApi:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: areturn
    //   133: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +12 -> 148
    //   139: ldc 71
    //   141: iconst_2
    //   142: ldc_w 657
    //   145: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -21 -> 129
    //   153: astore_1
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	PreloadServiceImpl
    //   0	158	1	paramString	String
    //   68	11	2	localIterator	Iterator
    //   87	35	3	localPreloadResourceImpl	PreloadResourceImpl
    // Exception table:
    //   from	to	target	type
    //   2	46	153	finally
    //   46	55	153	finally
    //   59	69	153	finally
    //   69	116	153	finally
    //   116	129	153	finally
    //   133	148	153	finally
  }
  
  public boolean isResInConfig(PreloadResourceImpl paramPreloadResourceImpl)
  {
    return this.mPreloadConfig.isResInConfig(paramPreloadResourceImpl);
  }
  
  public void mergeConfig(String paramString)
  {
    try
    {
      this.mPreloadConfig.mergeConfig(paramString, this);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void notifyResFlowCheckNext()
  {
    if (this.mFlowControlHandler == null) {
      initFlowControlHandler();
    }
    this.mFlowControlHandler.sendEmptyMessage(2);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    super.onCreate(paramAppRuntime);
    this.mPreloadConfig = PreloadConfig.readConfig("preload.config", this.mApp);
    this.mBackControlConfig = PreloadBackControlConfig.readBackControlConfig(this.mApp);
    initPreloadHelpConfig();
    try
    {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
      synDataFromMoggy();
      return;
    }
    catch (Throwable paramAppRuntime)
    {
      for (;;)
      {
        QLog.d("PreloadService", 1, "AppNetConnInfo.registerConnectionChangeReceiver is error msg=" + paramAppRuntime.getMessage());
        toReportCrash(paramAppRuntime);
      }
    }
  }
  
  public void onDestroy()
  {
    this.mIsOnDestroy = true;
    QWalletConfigManager localQWalletConfigManager = (QWalletConfigManager)this.mApp.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    if (localQWalletConfigManager != null) {
      localQWalletConfigManager.d("preload", this);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    if (this.mFlowControlHandler != null) {
      this.mFlowControlHandler.removeCallbacksAndMessages(null);
    }
    this.mBackControlConfig = null;
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "onNetMobile2Wifi");
    }
    startCheckConfig();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "onNetNone2Mobile");
    }
    startCheckConfig();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "onNetNone2Wifi");
    }
    startCheckConfig();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "onNetWifi2Mobile");
    }
    startCheckConfig();
  }
  
  public void onNetWifi2None() {}
  
  public void onUpdate(String paramString1, String paramString2, IQWalletConfigApi.ConfigInfo paramConfigInfo)
  {
    if (QWalletTools.c(paramString1, "preload"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "configFromMoggy onUpdate");
      }
      replaceConfigFromMoggy(paramConfigInfo);
      startCheckConfig();
    }
  }
  
  public void preCheck()
  {
    if (!PreloadStaticApi.a) {
      ResUtil.a(0, this.mPreloadConfig);
    }
    ResUtil.a(1, this.mPreloadConfig);
  }
  
  public void realTimeDownload(DownloadParam paramDownloadParam, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    paramOnGetPathListener = new PreloadServiceImpl.2(this, paramDownloadParam, paramOnGetPathListener, new WeakReference(this));
    if (TextUtils.isEmpty(paramDownloadParam.filePath)) {
      paramDownloadParam.filePath = PreloadStaticApi.b(paramDownloadParam.url, paramDownloadParam.filePos);
    }
    if (paramDownloadParam.isFlowControl)
    {
      addResToFlowControlCheck(new RealTimeFlowControlObj(paramDownloadParam, paramOnGetPathListener));
      return;
    }
    PreloadComDownloader.a().a(paramDownloadParam, paramOnGetPathListener, null);
  }
  
  public void replaceConfig(PreloadConfBean paramPreloadConfBean)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray();
        if ((paramPreloadConfBean != null) && (paramPreloadConfBean.a != null))
        {
          paramPreloadConfBean = paramPreloadConfBean.a;
          int k = paramPreloadConfBean.length;
          i = 0;
          if (i < k)
          {
            Object localObject = paramPreloadConfBean[i].jdField_a_of_type_JavaLangString;
            if (QLog.isColorLevel()) {
              QLog.d("PreloadService", 2, "receiveAllConfigs|type: 68,content: " + (String)localObject);
            }
            try
            {
              localObject = new JSONObject((String)localObject).getJSONArray("module_config");
              int j = 0;
              if (j >= ((JSONArray)localObject).length()) {
                break label165;
              }
              localJSONArray.put(((JSONArray)localObject).get(j));
              j += 1;
              continue;
              saveConfigFromQQToSp(localJSONArray.toString());
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        }
        this.mPreloadConfig.innerReplaceConfig(localJSONArray, this, 0);
        return;
      }
      finally {}
      label165:
      i += 1;
    }
  }
  
  public void replaceConfig(JSONArray paramJSONArray, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("PreloadService", 2, "[replaceConfig] fromType=" + paramInt + "configJa=" + paramJSONArray);
      }
      this.mPreloadConfig.innerReplaceConfig(paramJSONArray, this, paramInt);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void replaceConfigFromMoggy(IQWalletConfigApi.ConfigInfo paramConfigInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 779	org/json/JSONArray
    //   5: dup
    //   6: invokespecial 780	org/json/JSONArray:<init>	()V
    //   9: astore 8
    //   11: aload_1
    //   12: ifnull +18 -> 30
    //   15: ldc_w 714
    //   18: aload_1
    //   19: getfield 832	com/tencent/mobileqq/qwallet/config/IQWalletConfigApi$ConfigInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   22: invokevirtual 836	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: istore_3
    //   26: iload_3
    //   27: ifne +6 -> 33
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +59 -> 95
    //   39: ldc 71
    //   41: iconst_2
    //   42: new 73	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 838
    //   52: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 840	com/tencent/mobileqq/qwallet/config/IQWalletConfigApi$ConfigInfo:jdField_a_of_type_Long	J
    //   59: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc 85
    //   64: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   71: getfield 843	com/tencent/mobileqq/qwallet/preload/impl/PreloadConfig:moggyConfigVersion	J
    //   74: invokevirtual 274	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: ldc 85
    //   79: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: getfield 845	com/tencent/mobileqq/qwallet/config/IQWalletConfigApi$ConfigInfo:b	Ljava/lang/String;
    //   86: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_1
    //   96: getfield 840	com/tencent/mobileqq/qwallet/config/IQWalletConfigApi$ConfigInfo:jdField_a_of_type_Long	J
    //   99: lstore 4
    //   101: aload_0
    //   102: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   105: getfield 843	com/tencent/mobileqq/qwallet/preload/impl/PreloadConfig:moggyConfigVersion	J
    //   108: lstore 6
    //   110: lload 4
    //   112: lload 6
    //   114: lcmp
    //   115: ifle -85 -> 30
    //   118: new 793	org/json/JSONObject
    //   121: dup
    //   122: aload_1
    //   123: getfield 845	com/tencent/mobileqq/qwallet/config/IQWalletConfigApi$ConfigInfo:b	Ljava/lang/String;
    //   126: invokespecial 794	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   129: ldc_w 796
    //   132: invokevirtual 800	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   135: astore 9
    //   137: iconst_0
    //   138: istore_2
    //   139: iload_2
    //   140: aload 9
    //   142: invokevirtual 803	org/json/JSONArray:length	()I
    //   145: if_icmpge +29 -> 174
    //   148: aload 8
    //   150: aload 9
    //   152: iload_2
    //   153: invokevirtual 807	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   156: invokevirtual 811	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   159: pop
    //   160: iload_2
    //   161: iconst_1
    //   162: iadd
    //   163: istore_2
    //   164: goto -25 -> 139
    //   167: astore 9
    //   169: aload 9
    //   171: invokevirtual 814	java/lang/Throwable:printStackTrace	()V
    //   174: aload_0
    //   175: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   178: aload 8
    //   180: aload_0
    //   181: iconst_1
    //   182: invokevirtual 821	com/tencent/mobileqq/qwallet/preload/impl/PreloadConfig:innerReplaceConfig	(Lorg/json/JSONArray;Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl;I)V
    //   185: aload_0
    //   186: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   189: aload_1
    //   190: getfield 840	com/tencent/mobileqq/qwallet/config/IQWalletConfigApi$ConfigInfo:jdField_a_of_type_Long	J
    //   193: putfield 843	com/tencent/mobileqq/qwallet/preload/impl/PreloadConfig:moggyConfigVersion	J
    //   196: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +32 -> 231
    //   202: ldc 71
    //   204: iconst_2
    //   205: new 73	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 847
    //   215: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   222: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aload_0
    //   232: getfield 87	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:mPreloadConfig	Lcom/tencent/mobileqq/qwallet/preload/impl/PreloadConfig;
    //   235: invokevirtual 139	com/tencent/mobileqq/qwallet/preload/impl/PreloadConfig:savePreloadConfig	()V
    //   238: goto -208 -> 30
    //   241: astore_1
    //   242: aload_0
    //   243: monitorexit
    //   244: aload_1
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	PreloadServiceImpl
    //   0	246	1	paramConfigInfo	IQWalletConfigApi.ConfigInfo
    //   138	26	2	i	int
    //   25	2	3	bool	boolean
    //   99	12	4	l1	long
    //   108	5	6	l2	long
    //   9	170	8	localJSONArray1	JSONArray
    //   135	16	9	localJSONArray2	JSONArray
    //   167	3	9	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   118	137	167	java/lang/Throwable
    //   139	160	167	java/lang/Throwable
    //   2	11	241	finally
    //   15	26	241	finally
    //   33	95	241	finally
    //   95	110	241	finally
    //   118	137	241	finally
    //   139	160	241	finally
    //   169	174	241	finally
    //   174	231	241	finally
    //   231	238	241	finally
  }
  
  public void savePreloadConfig()
  {
    try
    {
      this.mPreloadConfig.savePreloadConfig();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setPreloadHelpConfig(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 5) {
      this.mPreloadDelays = 5;
    }
    while (paramInt2 <= 0)
    {
      this.mNeedWaitSize = 1024;
      return;
      if (paramInt1 > 1800) {
        this.mPreloadDelays = 1800;
      } else {
        this.mPreloadDelays = paramInt1;
      }
    }
    this.mNeedWaitSize = paramInt2;
  }
  
  public void startCheckConfig(boolean paramBoolean)
  {
    if (this.mIsOnDestroy) {
      return;
    }
    ThreadManager.post(new PreloadServiceImpl.5(this, new WeakReference(this), paramBoolean), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */