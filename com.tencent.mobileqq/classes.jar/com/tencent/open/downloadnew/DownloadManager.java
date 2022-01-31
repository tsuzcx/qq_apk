package com.tencent.open.downloadnew;

import aloh;
import alok;
import alol;
import alom;
import alon;
import alop;
import alos;
import alot;
import alou;
import alov;
import alow;
import alox;
import aloy;
import aloz;
import alpa;
import alpd;
import alpe;
import alpf;
import alpg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.open.downloadnew.common.NoticeDownloadListener;
import com.tencent.open.downloadnew.common.PackageInstallReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.ITMAssistantDownloadLogListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import cooperation.qappcenter.QAppCenterPluginProxyActivityTools;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class DownloadManager
{
  protected static DownloadManager a;
  public static final String a;
  protected static final byte[] a;
  public static final String b;
  protected final int a;
  protected long a;
  private ApkGetCodeListener jdField_a_of_type_ComTencentOpenDownloadnewApkGetCodeListener = new alot(this);
  private ApkWriteCodeListener jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener;
  protected PackageInstallReceiver a;
  public ITMAssistantDownloadClientListener a;
  public ITMAssistantDownloadLogListener a;
  protected TMAssistantDownloadClient a;
  protected WeakReference a;
  public ConcurrentHashMap a;
  protected ConcurrentLinkedQueue a;
  public boolean a;
  protected long b;
  protected boolean b;
  protected String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = DownloadManager.class.getName();
    jdField_b_of_type_JavaLangString = File.separator + "tencent" + File.separator + ".qqdownload" + File.separator;
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected DownloadManager()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new alpa(this);
    this.jdField_a_of_type_Int = 1000;
    this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener = new alox(this);
    LogUtility.c(jdField_a_of_type_JavaLangString, "DownloadManager create QQ5.0");
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver = new PackageInstallReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addDataScheme("package");
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    CommonDataAdapter.a().a().registerReceiver(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver, localIntentFilter);
    NoticeDownloadListener.a().a(ThreadManager.getSubThreadHandler().getLooper());
    a(WebViewDownloadListener.a());
    a(NoticeDownloadListener.a());
    ThreadManager.getSubThreadHandler().post(new alou(this));
    DownloaderGetCodeClient.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewApkGetCodeListener);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 1: 
      return 20;
    case 2: 
      return 2;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 6: 
      return 10;
    }
    return -2;
  }
  
  /* Error */
  public static DownloadManager a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 185	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +33 -> 41
    //   11: new 2	com/tencent/open/downloadnew/DownloadManager
    //   14: dup
    //   15: invokespecial 186	com/tencent/open/downloadnew/DownloadManager:<init>	()V
    //   18: putstatic 185	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   21: getstatic 185	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   24: ldc 188
    //   26: putfield 63	com/tencent/open/downloadnew/DownloadManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   29: getstatic 185	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   32: invokevirtual 190	com/tencent/open/downloadnew/DownloadManager:b	()V
    //   35: getstatic 185	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   38: invokevirtual 193	com/tencent/open/downloadnew/DownloadManager:e	()V
    //   41: getstatic 185	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   55: goto -14 -> 41
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	43	0	localDownloadManager	DownloadManager
    //   50	2	0	localException	Exception
    //   58	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	41	50	java/lang/Exception
    //   3	7	58	finally
    //   11	41	58	finally
    //   41	48	58	finally
    //   51	55	58	finally
    //   59	62	58	finally
  }
  
  private void a(Bundle paramBundle)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "receive write code msg......");
    if (paramBundle == null)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "receive write code msg but data is null......");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new alow(this, paramBundle));
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 185	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localDownloadManager	DownloadManager
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  private void h(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new alon(this, paramDownloadInfo));
  }
  
  private void i(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "receive get code msg......");
    if (paramDownloadInfo == null)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "receive get code msg but info is null......");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new alov(this, paramDownloadInfo));
  }
  
  public int a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return -30;
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener != null) {
      return this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener.a(paramDownloadInfo.jdField_d_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_Int, paramDownloadInfo.jdField_k_of_type_JavaLangString, null);
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = null;
    return -40;
  }
  
  public int a(String paramString)
  {
    Object localObject = a(paramString);
    if (localObject != null) {
      if (((DownloadInfo)localObject).jdField_a_of_type_Int != 1) {
        break label77;
      }
    }
    label77:
    for (localObject = ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString;; localObject = ((DownloadInfo)localObject).jdField_c_of_type_JavaLangString)
    {
      ThreadManager.getSubThreadHandler().post(new alok(this, (String)localObject));
      LogUtility.a(jdField_a_of_type_JavaLangString, "pause url=" + (String)localObject + ", appid=" + paramString);
      return 0;
    }
  }
  
  public DownloadInfo a(String paramString)
  {
    if (paramString == null)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "getDownloadInfoById appId == null");
      return null;
    }
    return (DownloadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public DownloadInfo a(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if ((paramString != null) && (paramInt != -2)) {
      paramString.a(paramInt);
    }
    return paramString;
  }
  
  public TMAssistantDownloadTaskInfo a(DownloadInfo paramDownloadInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, paramDownloadInfo.jdField_i_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_j_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.jdField_e_of_type_JavaLangString, paramDownloadInfo.jdField_d_of_type_JavaLangString);
    localBundle.putInt(DownloadConstants.jdField_d_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_Int);
    localBundle.putString(DownloadConstants.jdField_h_of_type_JavaLangString, paramDownloadInfo.jdField_g_of_type_JavaLangString);
    try
    {
      LogUtility.a("State_Log", "OpenSDK getTaskInfoFromMyApp param SNGAppId=" + paramDownloadInfo.jdField_b_of_type_JavaLangString + " apkId=" + paramDownloadInfo.jdField_j_of_type_JavaLangString + " taskAppId=" + paramDownloadInfo.jdField_i_of_type_JavaLangString + " packageName=" + paramDownloadInfo.jdField_d_of_type_JavaLangString + " version=" + paramDownloadInfo.jdField_b_of_type_Int + " via=" + paramDownloadInfo.jdField_g_of_type_JavaLangString);
      paramDownloadInfo = MyAppApi.a().a(localBundle);
      if (paramDownloadInfo != null) {}
      try
      {
        LogUtility.a("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo path=" + paramDownloadInfo.mSavePath + " state=" + paramDownloadInfo.mState);
        return paramDownloadInfo;
      }
      catch (Exception localException1) {}
      LogUtility.a("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo is null");
      return paramDownloadInfo;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        paramDownloadInfo = null;
      }
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "getTaskInfoFromMyApp>>>", localException1);
    return paramDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = a().getDownloadTaskState(paramString);
        if (localTMAssistantDownloadTaskInfo == null) {
          LogUtility.a(jdField_a_of_type_JavaLangString, "getTaskInfoFromSDK null url=" + paramString);
        }
        return localTMAssistantDownloadTaskInfo;
      }
      catch (Exception localException)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", localException);
      }
      Object localObject = null;
    }
  }
  
  public TMAssistantDownloadClient a()
  {
    TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.jdField_c_of_type_JavaLangString).registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    if (QLog.isColorLevel())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "registerLogListener!");
      TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.jdField_c_of_type_JavaLangString).registerLogListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener);
    }
    if (!this.jdField_b_of_type_Boolean) {}
    try
    {
      TMAssistantDownloadSettingClient localTMAssistantDownloadSettingClient = TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKSettingClient();
      if (localTMAssistantDownloadSettingClient != null)
      {
        localTMAssistantDownloadSettingClient.setDownloadSDKMaxTaskNum(3);
        this.jdField_b_of_type_Boolean = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.e(jdField_a_of_type_JavaLangString, "exception: " + localException.toString());
      }
    }
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.jdField_c_of_type_JavaLangString);
    return this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  }
  
  public String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.jdField_k_of_type_JavaLangString;
    }
    return "";
  }
  
  public WeakReference a()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 == null) {}
      try
      {
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
        {
          localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localObject1 != null) {
            this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          LogUtility.c(jdField_a_of_type_JavaLangString, "getQQAppInterface>>>", localException);
        }
      }
      localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
      return localObject1;
    }
    finally {}
  }
  
  protected List a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (localDownloadInfo.a() == paramInt) {
          localArrayList.add(localDownloadInfo);
        }
      }
    }
    finally {}
    return localList;
  }
  
  public List a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "getDownloadInfoById via == " + paramString);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((!TextUtils.isEmpty(localDownloadInfo.jdField_g_of_type_JavaLangString)) && (localDownloadInfo.jdField_g_of_type_JavaLangString.equals(paramString))) {
        localArrayList.add(localDownloadInfo);
      }
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "getDownloadInfoByVia result =" + localArrayList);
    return localArrayList;
  }
  
  public ConcurrentLinkedQueue a()
  {
    try
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
      return localConcurrentLinkedQueue;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    ThreadManager.getSubThreadHandler().post(new aloh(this));
  }
  
  public void a(int paramInt, DownloadInfo paramDownloadInfo)
  {
    a(paramInt, paramDownloadInfo, 0, "");
  }
  
  public void a(int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2, String paramString)
  {
    if (paramDownloadInfo == null) {}
    for (;;)
    {
      try
      {
        LogUtility.e(jdField_a_of_type_JavaLangString, "notifyListener info == null id=" + paramInt1);
        return;
      }
      finally {}
      switch (paramInt1)
      {
      default: 
        break;
      case -2: 
        a(paramDownloadInfo, paramInt2, paramString);
        break;
      case 20: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载等待:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).onDownloadWait(paramDownloadInfo);
        }
      case 3: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载暂停:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).onDownloadPause(paramDownloadInfo);
        }
      case 4: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载完成:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).onDownloadFinish(paramDownloadInfo);
        }
      case 10: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载取消:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        DownloadDBHelper.a().a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        AppNotificationManager.a().a(paramDownloadInfo.jdField_f_of_type_JavaLangString);
        paramDownloadInfo.a(10);
        LogUtility.a(jdField_a_of_type_JavaLangString, "downloadInfo.state = " + paramDownloadInfo.a());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).onDownloadCancel(paramDownloadInfo);
        }
      case 2: 
        if ((paramDownloadInfo.jdField_c_of_type_Int == 1) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L))
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载进度更新:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
          paramDownloadInfo = a(2);
          LogUtility.a(jdField_a_of_type_JavaLangString, "###下载进度更新  size=" + paramDownloadInfo.size());
          paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
          while (paramString.hasNext())
          {
            DownloadListener localDownloadListener = (DownloadListener)paramString.next();
            LogUtility.a(jdField_a_of_type_JavaLangString, "###下载1 listner name" + localDownloadListener.getClass().getName());
            localDownloadListener.onDownloadUpdate(paramDownloadInfo);
          }
        }
        break;
      case 6: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###安装成功:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).installSucceed(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo.jdField_d_of_type_JavaLangString);
        }
      case 13: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "###包被替换:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).packageReplaced(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo.jdField_d_of_type_JavaLangString);
        }
      case 9: 
        LogUtility.a(jdField_a_of_type_JavaLangString, "###卸载成功:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).uninstallSucceed(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo.jdField_d_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2)
  {
    new Handler(Looper.getMainLooper()).post(new alop(this, paramBundle, paramActivity, paramInt1, paramApkUpdateDetail, paramInt2));
  }
  
  public void a(AppInterface paramAppInterface)
  {
    try
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      return;
    }
    finally
    {
      paramAppInterface = finally;
      throw paramAppInterface;
    }
  }
  
  /* Error */
  public void a(DownloadInfo paramDownloadInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 32	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5: new 34	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 606
    //   15: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_1
    //   19: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 99	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: getfield 608	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_Boolean	Z
    //   32: ifeq +27 -> 59
    //   35: ldc_w 610
    //   38: aload_1
    //   39: getfield 283	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   42: bipush 100
    //   44: invokestatic 615	com/tencent/open/base/ImageUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   47: new 617	aloi
    //   50: dup
    //   51: aload_0
    //   52: aload_1
    //   53: invokespecial 618	aloi:<init>	(Lcom/tencent/open/downloadnew/DownloadManager;Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   56: invokestatic 623	com/tencent/open/base/img/ImageCache:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/open/base/img/ImageDownCallback;)V
    //   59: aload_0
    //   60: aload_1
    //   61: getfield 283	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokevirtual 248	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   67: astore 4
    //   69: aload 4
    //   71: ifnull +354 -> 425
    //   74: aload_0
    //   75: aload 4
    //   77: aload_1
    //   78: invokevirtual 626	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;Lcom/tencent/open/downloadnew/DownloadInfo;)Z
    //   81: ifeq +339 -> 420
    //   84: aload 4
    //   86: astore_3
    //   87: getstatic 32	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: new 34	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 628
    //   100: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: getfield 263	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc_w 630
    //   113: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: getfield 632	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   120: invokevirtual 635	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   123: ldc_w 637
    //   126: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: getfield 249	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Int	I
    //   133: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc_w 639
    //   139: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_0
    //   143: aload_1
    //   144: getfield 283	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   147: invokevirtual 248	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   150: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 262	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_0
    //   160: aload_3
    //   161: invokevirtual 641	com/tencent/open/downloadnew/DownloadManager:e	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   164: ldc_w 643
    //   167: aload_3
    //   168: getfield 234	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   171: invokevirtual 478	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifeq +15 -> 189
    //   177: aload_0
    //   178: invokevirtual 645	com/tencent/open/downloadnew/DownloadManager:b	()Z
    //   181: ifeq +8 -> 189
    //   184: aload_0
    //   185: aload_3
    //   186: invokevirtual 647	com/tencent/open/downloadnew/DownloadManager:f	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   189: aload_3
    //   190: getfield 249	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Int	I
    //   193: iconst_1
    //   194: if_icmpne +311 -> 505
    //   197: aload_3
    //   198: getfield 251	com/tencent/open/downloadnew/DownloadInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   201: astore_1
    //   202: aload_3
    //   203: getfield 249	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Int	I
    //   206: istore_2
    //   207: new 649	java/util/HashMap
    //   210: dup
    //   211: invokespecial 650	java/util/HashMap:<init>	()V
    //   214: astore 5
    //   216: aload 5
    //   218: getstatic 655	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APPID	Ljava/lang/String;
    //   221: aload_3
    //   222: getfield 283	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   225: invokeinterface 661 3 0
    //   230: pop
    //   231: aload 5
    //   233: getstatic 664	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_PACKNAME	Ljava/lang/String;
    //   236: aload_3
    //   237: getfield 234	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   240: invokeinterface 661 3 0
    //   245: pop
    //   246: aload 5
    //   248: getstatic 667	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_TASK_VERSION	Ljava/lang/String;
    //   251: aload_3
    //   252: getfield 236	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_Int	I
    //   255: invokestatic 671	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   258: invokeinterface 661 3 0
    //   263: pop
    //   264: aload 5
    //   266: getstatic 674	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_VIA	Ljava/lang/String;
    //   269: aload_3
    //   270: getfield 304	com/tencent/open/downloadnew/DownloadInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   273: invokeinterface 661 3 0
    //   278: pop
    //   279: aload 5
    //   281: getstatic 677	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_UIN_TYPE	Ljava/lang/String;
    //   284: ldc_w 679
    //   287: invokestatic 682	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   290: invokeinterface 661 3 0
    //   295: pop
    //   296: aload 5
    //   298: getstatic 685	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADTYPE	Ljava/lang/String;
    //   301: iconst_2
    //   302: invokestatic 671	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   305: invokeinterface 661 3 0
    //   310: pop
    //   311: aload 5
    //   313: getstatic 688	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_ICON_URL	Ljava/lang/String;
    //   316: aload_3
    //   317: getfield 691	com/tencent/open/downloadnew/DownloadInfo:l	Ljava/lang/String;
    //   320: invokeinterface 661 3 0
    //   325: pop
    //   326: aload 5
    //   328: getstatic 694	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_APP_NAME	Ljava/lang/String;
    //   331: aload_3
    //   332: getfield 695	com/tencent/open/downloadnew/DownloadInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   335: invokeinterface 661 3 0
    //   340: pop
    //   341: aload 5
    //   343: getstatic 698	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_SHOW_NOTIFICATION	Ljava/lang/String;
    //   346: aload_3
    //   347: getfield 700	com/tencent/open/downloadnew/DownloadInfo:jdField_j_of_type_Int	I
    //   350: invokestatic 671	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   353: invokeinterface 661 3 0
    //   358: pop
    //   359: aload 5
    //   361: getstatic 703	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_IS_AUTOINSTALL_BY_SDK	Ljava/lang/String;
    //   364: aload_3
    //   365: getfield 705	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Boolean	Z
    //   368: invokestatic 708	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   371: invokeinterface 661 3 0
    //   376: pop
    //   377: aload 5
    //   379: getstatic 711	com/tencent/tmassistantbase/common/TMAssistantDownloadConst:PARAM_DOWNLOADSIZE	Ljava/lang/String;
    //   382: aload_3
    //   383: getfield 713	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Long	J
    //   386: invokestatic 716	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   389: invokeinterface 661 3 0
    //   394: pop
    //   395: invokestatic 147	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   398: new 718	aloj
    //   401: dup
    //   402: aload_0
    //   403: aload_1
    //   404: aload 5
    //   406: iload_2
    //   407: aload_3
    //   408: aload 4
    //   410: invokespecial 721	aloj:<init>	(Lcom/tencent/open/downloadnew/DownloadManager;Ljava/lang/String;Ljava/util/Map;ILcom/tencent/open/downloadnew/DownloadInfo;Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   413: invokevirtual 171	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   416: pop
    //   417: aload_0
    //   418: monitorexit
    //   419: return
    //   420: aload_1
    //   421: astore_3
    //   422: goto -335 -> 87
    //   425: ldc_w 723
    //   428: astore_3
    //   429: aload_1
    //   430: getfield 725	com/tencent/open/downloadnew/DownloadInfo:jdField_h_of_type_Int	I
    //   433: bipush 12
    //   435: if_icmpne +7 -> 442
    //   438: ldc_w 727
    //   441: astore_3
    //   442: aload_3
    //   443: aload_1
    //   444: getfield 304	com/tencent/open/downloadnew/DownloadInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   447: aload_1
    //   448: getfield 283	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   451: aload_1
    //   452: getfield 730	com/tencent/open/downloadnew/DownloadInfo:m	Ljava/lang/String;
    //   455: invokestatic 735	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   458: getstatic 32	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   461: new 34	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   468: ldc_w 737
    //   471: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload_1
    //   475: getfield 263	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   478: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: ldc_w 637
    //   484: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload_1
    //   488: getfield 249	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Int	I
    //   491: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 262	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: aload_1
    //   501: astore_3
    //   502: goto -343 -> 159
    //   505: aload_3
    //   506: getfield 263	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   509: astore_1
    //   510: goto -308 -> 202
    //   513: astore_1
    //   514: aload_0
    //   515: monitorexit
    //   516: aload_1
    //   517: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	this	DownloadManager
    //   0	518	1	paramDownloadInfo	DownloadInfo
    //   206	201	2	i	int
    //   86	420	3	localObject	Object
    //   67	342	4	localDownloadInfo	DownloadInfo
    //   214	191	5	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   2	59	513	finally
    //   59	69	513	finally
    //   74	84	513	finally
    //   87	159	513	finally
    //   159	189	513	finally
    //   189	202	513	finally
    //   202	417	513	finally
    //   429	438	513	finally
    //   442	500	513	finally
    //   505	510	513	finally
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt, String paramString)
  {
    this.jdField_b_of_type_Boolean = false;
    if (paramDownloadInfo == null)
    {
      LogUtility.d(jdField_a_of_type_JavaLangString, "handleDownloadErrorCallBack info == null code = " + paramInt + " msg = " + paramString);
      return;
    }
    LogUtility.d(jdField_a_of_type_JavaLangString, "handleDownloadErrorCallBack code = " + paramInt + " msg = " + paramString);
    if ((paramInt >= 400) && (paramInt <= 599)) {}
    for (;;)
    {
      try
      {
        paramString = CommonDataAdapter.a().a().getString(2131428521);
      }
      catch (Exception paramDownloadInfo)
      {
        paramDownloadInfo.printStackTrace();
        return;
      }
      paramString = CommonDataAdapter.a().a().getString(2131428522);
      int i = 3;
      paramDownloadInfo.a(i);
      LogUtility.a(jdField_a_of_type_JavaLangString, "onNetworkConnect ###下载错误:" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      if (((Iterator)localObject).hasNext())
      {
        ((DownloadListener)((Iterator)localObject).next()).onDownloadError(paramDownloadInfo, paramInt, paramString, i);
        continue;
        LogUtility.a(jdField_a_of_type_JavaLangString, "onDownloadError ###写码失败引起的..........11111");
        if ((paramDownloadInfo.jdField_d_of_type_JavaLangString != null) && ("com.tencent.mobileqq".equals(paramDownloadInfo.jdField_d_of_type_JavaLangString)) && (paramDownloadInfo.jdField_a_of_type_Int != 1) && (b()))
        {
          LogUtility.a(jdField_a_of_type_JavaLangString, "onDownloadError ###写码失败引起的..........");
          ThreadManager.getSubThreadHandler().post(new alpd(this, paramDownloadInfo));
          return;
        }
        paramDownloadInfo.a(4);
        if (paramDownloadInfo.jdField_a_of_type_Int == 1)
        {
          h(paramDownloadInfo);
          return;
        }
        ThreadManager.getSubThreadHandler().post(new alpe(this, paramDownloadInfo));
        return;
        paramString = CommonDataAdapter.a().a().getString(2131428529);
        i = 3;
        continue;
        paramString = CommonDataAdapter.a().a().getString(2131428521);
        i = 3;
        continue;
        paramString = CommonDataAdapter.a().a().getString(2131428522);
        i = 3;
        continue;
        paramString = CommonDataAdapter.a().a().getString(2131428527);
        i = 3;
        continue;
        paramString = CommonDataAdapter.a().a().getString(2131428528);
        i = 3;
        continue;
        paramString = CommonDataAdapter.a().a().getString(2131428526);
        i = 3;
        continue;
        label455:
        int j;
        if (paramInt == 712)
        {
          localObject = CommonDataAdapter.a().a().getString(2131428530);
          j = 10;
          if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
          {
            paramString = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class);
            if ((paramString != null) && (UpgradeController.a().a() == 4)) {
              paramString.obtainMessage(1134019).sendToTarget();
            }
          }
          i = j;
          paramString = (String)localObject;
          if (paramDownloadInfo == null) {
            continue;
          }
          if (paramDownloadInfo.jdField_a_of_type_Int != 1) {
            break label593;
          }
        }
        label593:
        for (String str = paramDownloadInfo.jdField_h_of_type_JavaLangString;; str = paramDownloadInfo.jdField_c_of_type_JavaLangString)
        {
          i = j;
          paramString = (String)localObject;
          if (str == null) {
            break;
          }
          ThreadManager.getSubThreadHandler().post(new alpf(this, str, paramDownloadInfo));
          i = j;
          paramString = (String)localObject;
          break;
          localObject = CommonDataAdapter.a().a().getString(2131428519);
          break label455;
        }
        LogUtility.a(jdField_a_of_type_JavaLangString, "onDownloadError ###失败处理..........");
        i = 3;
      }
      else
      {
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        b(paramString);
        return;
        switch (paramInt)
        {
        }
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong)
  {
    if ((a() == null) || (a().get() == null)) {}
    while ((AppInterface)a().get() == null) {
      return;
    }
    int i = 14;
    switch (paramDownloadInfo.jdField_e_of_type_Int)
    {
    default: 
      i = 40;
    }
    for (;;)
    {
      Bundle localBundle1 = null;
      if (!TextUtils.isEmpty(paramDownloadInfo.jdField_e_of_type_JavaLangString))
      {
        localBundle1 = new Bundle();
        localBundle1.putString("appname", paramDownloadInfo.jdField_e_of_type_JavaLangString + ".apk");
      }
      LogUtility.c(jdField_a_of_type_JavaLangString, "reportDownloadResult info.packageName = " + paramDownloadInfo.jdField_d_of_type_JavaLangString + ",info.urlStr = " + paramDownloadInfo.jdField_c_of_type_JavaLangString + ",info.filePath = " + paramDownloadInfo.jdField_k_of_type_JavaLangString);
      Intent localIntent = new Intent("com.opensdk.downloadmanager.renameFilename");
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("filePath", paramDownloadInfo.jdField_k_of_type_JavaLangString);
      localBundle2.putLong("dataLength", paramLong);
      localBundle2.putInt("fileSourceId", i);
      localBundle2.putBundle("otherData", localBundle1);
      localBundle2.putInt("peerType", -1);
      localIntent.putExtra("extraBundle", localBundle2);
      CommonDataAdapter.a().a().sendBroadcast(localIntent);
      return;
      i = 15;
      continue;
      i = 17;
      continue;
      i = 18;
      continue;
      i = 40;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramDownloadInfo == null)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "trafficReport info == null code = " + paramInt);
      return;
    }
    LogUtility.c(jdField_a_of_type_JavaLangString, "trafficReport code = " + paramInt);
    if ((paramInt >= 400) && (paramInt <= 599)) {
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "open appstore network error");
    }
    switch (paramInt)
    {
    default: 
      return;
    case -24: 
      a(paramDownloadInfo, 0L, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "package invalid");
      return;
    case 0: 
    case 5: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "do not need to handle error");
      return;
    case 4: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "DownloadSDK_START_FAILED_EXISTED");
      return;
    case 1: 
    case 601: 
    case 602: 
    case 603: 
    case 605: 
    case 701: 
    case 702: 
    case 706: 
    case 707: 
    case 708: 
    case 709: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "network error");
      return;
    case 3: 
    case 600: 
    case 604: 
    case 700: 
    case 704: 
    case 705: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "download error");
      return;
    }
    a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "write file error");
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, String paramString)
  {
    if (paramLong2 > 0L)
    {
      paramDownloadInfo.jdField_b_of_type_Long = paramLong1;
      e(paramDownloadInfo);
      a(paramString, paramLong2, paramDownloadInfo.jdField_e_of_type_Int);
    }
  }
  
  /* Error */
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull +11 -> 14
    //   6: aload_2
    //   7: getfield 889	com/tencent/apkupdate/logic/data/ApkUpdateDetail:updatemethod	I
    //   10: iconst_4
    //   11: if_icmpeq +20 -> 31
    //   14: getstatic 32	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: ldc_w 891
    //   20: invokestatic 99	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 893	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_2
    //   32: getfield 896	com/tencent/apkupdate/logic/data/ApkUpdateDetail:url	Ljava/lang/String;
    //   35: astore 5
    //   37: aload_2
    //   38: getfield 899	com/tencent/apkupdate/logic/data/ApkUpdateDetail:patchsize	I
    //   41: i2l
    //   42: lstore_3
    //   43: aload_2
    //   44: getfield 902	com/tencent/apkupdate/logic/data/ApkUpdateDetail:fileMd5	Ljava/lang/String;
    //   47: astore_2
    //   48: getstatic 32	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   51: new 34	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 904
    //   61: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: lload_3
    //   65: ldc2_w 905
    //   68: ldiv
    //   69: invokevirtual 909	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: ldc_w 911
    //   75: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_2
    //   79: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 913
    //   85: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload 5
    //   90: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 99	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_1
    //   100: aload 5
    //   102: putfield 251	com/tencent/open/downloadnew/DownloadInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   105: aload_1
    //   106: iconst_1
    //   107: putfield 249	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Int	I
    //   110: lload_3
    //   111: lconst_0
    //   112: lcmp
    //   113: ifle +8 -> 121
    //   116: aload_1
    //   117: lload_3
    //   118: putfield 713	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Long	J
    //   121: aload_0
    //   122: aload_1
    //   123: invokevirtual 893	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   126: goto -98 -> 28
    //   129: astore_2
    //   130: getstatic 32	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   133: ldc_w 915
    //   136: aload_2
    //   137: invokestatic 369	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_0
    //   141: aload_1
    //   142: invokevirtual 893	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   145: goto -117 -> 28
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	DownloadManager
    //   0	153	1	paramDownloadInfo	DownloadInfo
    //   0	153	2	paramApkUpdateDetail	ApkUpdateDetail
    //   42	76	3	l	long
    //   35	66	5	str	String
    // Exception table:
    //   from	to	target	type
    //   31	110	129	java/lang/Exception
    //   116	121	129	java/lang/Exception
    //   121	126	129	java/lang/Exception
    //   6	14	148	finally
    //   14	28	148	finally
    //   31	110	148	finally
    //   116	121	148	finally
    //   121	126	148	finally
    //   130	145	148	finally
  }
  
  public void a(DownloadListener paramDownloadListener)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramDownloadListener)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramDownloadListener);
      }
      return;
    }
    finally
    {
      paramDownloadListener = finally;
      throw paramDownloadListener;
    }
  }
  
  public void a(ITMAssistantDownloadLogListener paramITMAssistantDownloadLogListener)
  {
    if (paramITMAssistantDownloadLogListener == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "unregisterLogListener logListener == null");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "unregisterLogListener");
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient != null)
        {
          this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterLogListener(paramITMAssistantDownloadLogListener);
          return;
        }
      }
      catch (Exception paramITMAssistantDownloadLogListener)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "unregisterLogListener Exception:", paramITMAssistantDownloadLogListener);
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      AppNotificationManager.a().a(paramString);
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    String[] arrayOfString = null;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
      switch (paramInt)
      {
      }
    }
    while ((a() == null) || (arrayOfString == null))
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "application or tags is null");
      return;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAppCenterDefaultDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
      continue;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAppCenterQQUpdateDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
      continue;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAppCenterGameCenterDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
      continue;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIAppCenterOthersDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
      continue;
      switch (paramInt)
      {
      default: 
        arrayOfString = null;
        break;
      case 0: 
        arrayOfString = new String[] { "param_XGAppCenterDefaultDownloadFlow", "param_XGFlow", "param_Flow" };
        break;
      case 1: 
        arrayOfString = new String[] { "param_XGAppCenterQQUpdateDownloadFlow", "param_XGFlow", "param_Flow" };
        break;
      case 2: 
        arrayOfString = new String[] { "param_XGAppCenterGameCenterDownloadFlow", "param_XGFlow", "param_Flow" };
        break;
      case 3: 
        arrayOfString = new String[] { "param_XGAppCenterOthersDownloadFlow", "param_XGFlow", "param_Flow" };
      }
    }
    AppInterface localAppInterface = (AppInterface)a().get();
    if (localAppInterface == null)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "appinterface is null");
      return;
    }
    try
    {
      localAppInterface.sendAppDataIncerment(localAppInterface.getCurrentAccountUin(), arrayOfString, paramLong);
      LogUtility.c(jdField_a_of_type_JavaLangString, "sendAppDataIncerment logMsg: " + paramString + " ,fileSize : " + paramLong);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      LogUtility.d(jdField_a_of_type_JavaLangString, "appid is empty");
      return;
    }
    Object localObject = a(paramString);
    if (localObject == null)
    {
      LogUtility.d(jdField_a_of_type_JavaLangString, "clearDownloadInfo info == null");
      return;
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "clearDownloadInfo info =" + ((DownloadInfo)localObject).toString());
    if (((DownloadInfo)localObject).jdField_c_of_type_Int == 0) {
      if (((DownloadInfo)localObject).jdField_a_of_type_Int != 1) {
        break label127;
      }
    }
    label127:
    for (localObject = ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString;; localObject = ((DownloadInfo)localObject).jdField_c_of_type_JavaLangString)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.getSubThreadHandler().post(new alpg(this, paramBoolean, (String)localObject));
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      DownloadDBHelper.a().a(paramString);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    int i = 0;
    String str = "";
    Object localObject2 = new ArrayList();
    if (((Iterator)localObject1).hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)((Iterator)localObject1).next();
      if ((localDownloadInfo == null) || (localDownloadInfo.jdField_f_of_type_Int == 4) || (localDownloadInfo.jdField_f_of_type_Int == 1) || (localDownloadInfo.jdField_c_of_type_Int != 1)) {
        break label287;
      }
      ((ArrayList)localObject2).add(localDownloadInfo);
      if ((!TextUtils.isEmpty(str)) || (AppUtil.a(localDownloadInfo.jdField_d_of_type_JavaLangString))) {
        break label284;
      }
      str = localDownloadInfo.jdField_e_of_type_JavaLangString;
      label117:
      i += 1;
    }
    label267:
    label284:
    label287:
    for (;;)
    {
      break;
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DownloadInfo)((Iterator)localObject1).next();
          ((DownloadInfo)localObject2).a(10);
          a(10, (DownloadInfo)localObject2);
        }
      }
      boolean bool = QAppCenterPluginProxyActivityTools.jdField_a_of_type_Boolean;
      if ((paramBoolean) && (i > 0))
      {
        localObject1 = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
          break label267;
        }
      }
      for (str = str + "等";; str = "")
      {
        str = str + i + "款应用下载失败，请重新下载";
        if (!bool) {
          break;
        }
        ToastUtil.a().a(str, 1);
        return;
      }
      MyAppApi.a().a(true, str);
      return;
      break label117;
    }
  }
  
  public boolean a(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    if (paramApkWriteCodeListener == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = paramApkWriteCodeListener;
    return true;
  }
  
  public boolean a(DownloadInfo paramDownloadInfo)
  {
    LogUtility.a(jdField_a_of_type_JavaLangString, "refreshDownloadInfo DownloadInfo=" + paramDownloadInfo);
    DownloadInfo localDownloadInfo = a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    if (localDownloadInfo != null)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "refreshDownloadInfo cacheInfo =" + localDownloadInfo);
      Object localObject;
      if (localDownloadInfo.jdField_c_of_type_Int == 0)
      {
        LogUtility.a(jdField_a_of_type_JavaLangString, "refreshDownloadInfo DownloadInfo.DOWNLOAD_TYPE_DOWNLOADSDK......");
        paramDownloadInfo.jdField_i_of_type_Int = localDownloadInfo.jdField_i_of_type_Int;
        if (localDownloadInfo.jdField_a_of_type_Int == 1)
        {
          localObject = localDownloadInfo.jdField_h_of_type_JavaLangString;
          localObject = a().a((String)localObject);
          if (localObject == null) {
            break label308;
          }
          LogUtility.a(jdField_a_of_type_JavaLangString, "refreshDownloadInfo sdk getReceiveDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen + " getTotalDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen);
          paramDownloadInfo.jdField_g_of_type_Int = ((int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen * 100.0F / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen));
          paramDownloadInfo.a(a(((TMAssistantDownloadTaskInfo)localObject).mState));
          paramDownloadInfo.jdField_c_of_type_Int = 0;
          if (localDownloadInfo.jdField_a_of_type_Int != 1) {
            break label296;
          }
          if (!TextUtils.isEmpty(localDownloadInfo.jdField_k_of_type_JavaLangString)) {
            break label284;
          }
          paramDownloadInfo.jdField_k_of_type_JavaLangString = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
        }
        for (;;)
        {
          if (paramDownloadInfo.jdField_f_of_type_Int == 4)
          {
            paramDownloadInfo.jdField_k_of_type_Int = localDownloadInfo.jdField_k_of_type_Int;
            if (paramDownloadInfo.jdField_k_of_type_Int != 0)
            {
              paramDownloadInfo.jdField_f_of_type_Int = 3;
              e(localDownloadInfo);
            }
          }
          return true;
          localObject = localDownloadInfo.jdField_c_of_type_JavaLangString;
          break;
          label284:
          paramDownloadInfo.jdField_k_of_type_JavaLangString = localDownloadInfo.jdField_k_of_type_JavaLangString;
          continue;
          label296:
          paramDownloadInfo.jdField_k_of_type_JavaLangString = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
        }
        label308:
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
        DownloadDBHelper.a().a(localDownloadInfo.jdField_b_of_type_JavaLangString);
        paramDownloadInfo.jdField_f_of_type_Int = -100;
        return true;
      }
      if (localDownloadInfo.jdField_c_of_type_Int == 1)
      {
        localObject = a(localDownloadInfo);
        if (localObject != null)
        {
          int j = a(((TMAssistantDownloadTaskInfo)localObject).mState);
          int i = j;
          if (j == -2) {
            i = 3;
          }
          paramDownloadInfo.a(i);
          paramDownloadInfo.jdField_c_of_type_Int = 1;
          paramDownloadInfo.jdField_k_of_type_JavaLangString = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          long l1 = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
          long l2 = ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen;
          paramDownloadInfo.jdField_g_of_type_Int = ((int)((float)l1 * 100.0F / (float)l2));
          if (!MyAppApi.a().e()) {
            paramDownloadInfo.jdField_g_of_type_Int = 0;
          }
          return true;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
        DownloadDBHelper.a().a(localDownloadInfo.jdField_b_of_type_JavaLangString);
      }
    }
    return false;
  }
  
  protected boolean a(DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2)
  {
    paramDownloadInfo1.jdField_a_of_type_Boolean = paramDownloadInfo2.jdField_a_of_type_Boolean;
    paramDownloadInfo1.jdField_b_of_type_Boolean = paramDownloadInfo2.jdField_b_of_type_Boolean;
    paramDownloadInfo1.jdField_c_of_type_Int = paramDownloadInfo2.jdField_c_of_type_Int;
    paramDownloadInfo1.jdField_g_of_type_JavaLangString = paramDownloadInfo2.jdField_g_of_type_JavaLangString;
    if (!TextUtils.isEmpty(paramDownloadInfo1.jdField_c_of_type_JavaLangString))
    {
      if (!paramDownloadInfo1.jdField_c_of_type_JavaLangString.equals(paramDownloadInfo2.jdField_c_of_type_JavaLangString))
      {
        a(paramDownloadInfo2.jdField_b_of_type_JavaLangString, false);
        return false;
      }
    }
    else {
      paramDownloadInfo1.jdField_c_of_type_JavaLangString = paramDownloadInfo2.jdField_c_of_type_JavaLangString;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    paramString = a().a(paramString);
    return (paramString != null) && (paramString.a() == 4);
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = a(paramString1);
    if (paramString2 != null) {
      a(paramString1, false);
    }
    if (paramString2 != null)
    {
      if (!paramBoolean) {
        break label33;
      }
      a(10, paramString2);
    }
    for (;;)
    {
      return true;
      try
      {
        label33:
        AppNotificationManager.a().a(paramString2.jdField_f_of_type_JavaLangString);
      }
      catch (Exception paramString1)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", paramString1);
      }
    }
  }
  
  /* Error */
  public DownloadInfo b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 355	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +57 -> 63
    //   9: aload_0
    //   10: getfield 68	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: invokevirtual 446	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   16: invokeinterface 452 1 0
    //   21: astore 4
    //   23: aload 4
    //   25: invokeinterface 457 1 0
    //   30: ifeq +33 -> 63
    //   33: aload 4
    //   35: invokeinterface 461 1 0
    //   40: checkcast 231	com/tencent/open/downloadnew/DownloadInfo
    //   43: astore_3
    //   44: aload_1
    //   45: aload_3
    //   46: getfield 234	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   49: invokevirtual 478	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: istore_2
    //   53: iload_2
    //   54: ifeq -31 -> 23
    //   57: aload_3
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -6 -> 59
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	DownloadManager
    //   0	73	1	paramString	String
    //   52	2	2	bool	boolean
    //   43	15	3	localDownloadInfo	DownloadInfo
    //   21	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	23	68	finally
    //   23	53	68	finally
  }
  
  public DownloadInfo b(String paramString, int paramInt)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      int i = paramInt;
      if (paramInt == -2) {
        i = 3;
      }
      paramString.a(i);
    }
    return paramString;
  }
  
  public List b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (localDownloadInfo != null) {
          if (localDownloadInfo.jdField_c_of_type_Int == 0)
          {
            if (localDownloadInfo.jdField_a_of_type_Int == 1)
            {
              paramString = localDownloadInfo.jdField_h_of_type_JavaLangString;
              label82:
              paramString = a().a(paramString);
              if (paramString == null) {
                break label231;
              }
              LogUtility.a(jdField_a_of_type_JavaLangString, "queryDownloadInfosByVia sdk getReceiveDataLen=" + paramString.mReceiveDataLen + " getTotalDataLen=" + paramString.mTotalDataLen);
              localDownloadInfo.jdField_g_of_type_Int = ((int)((float)paramString.mReceiveDataLen * 100.0F / (float)paramString.mTotalDataLen));
              localDownloadInfo.a(a(paramString.mState));
              if (localDownloadInfo.jdField_a_of_type_Int != 1) {
                break label219;
              }
              if (!TextUtils.isEmpty(localDownloadInfo.jdField_k_of_type_JavaLangString)) {}
            }
            label219:
            for (localDownloadInfo.jdField_k_of_type_JavaLangString = paramString.mSavePath;; localDownloadInfo.jdField_k_of_type_JavaLangString = paramString.mSavePath)
            {
              localArrayList.add(localDownloadInfo);
              break;
              paramString = localDownloadInfo.jdField_c_of_type_JavaLangString;
              break label82;
            }
            label231:
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
            DownloadDBHelper.a().a(localDownloadInfo.jdField_b_of_type_JavaLangString);
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_b_of_type_JavaLangString);
            DownloadDBHelper.a().a(localDownloadInfo.jdField_b_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected void b()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new aloy(this), 5000L);
    ThreadManager.getSubThreadHandler().postDelayed(new aloz(this), 10000L);
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    for (;;)
    {
      try
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "complete info == null ");
        return;
      }
      finally {}
      if (((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) && ("com.tencent.mobileqq".equals(paramDownloadInfo.jdField_d_of_type_JavaLangString)) && (ConfigHandler.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
        paramDownloadInfo.jdField_a_of_type_Boolean = false;
      }
      LogUtility.a(jdField_a_of_type_JavaLangString, "onDownload complete, info = " + paramDownloadInfo.toString());
      if (paramDownloadInfo.jdField_c_of_type_Int == 0)
      {
        if (paramDownloadInfo.jdField_a_of_type_Int == 1) {
          h(paramDownloadInfo);
        } else {
          ThreadManager.getSubThreadHandler().post(new alol(this, paramDownloadInfo));
        }
      }
      else {
        ThreadManager.getSubThreadHandler().post(new alom(this, paramDownloadInfo));
      }
    }
  }
  
  public void b(DownloadListener paramDownloadListener)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramDownloadListener)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramDownloadListener);
      }
      return;
    }
    finally
    {
      paramDownloadListener = finally;
      throw paramDownloadListener;
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      if ((BaseActivity.sTopActivity.isResume()) && (System.currentTimeMillis() - this.jdField_b_of_type_Long > 1000L))
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        ToastUtil.a().a(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "showToast>>>", paramString);
    }
  }
  
  public boolean b()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  public boolean b(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    if (paramApkWriteCodeListener == null) {}
    while ((this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener == null) || (paramApkWriteCodeListener != this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = null;
    return true;
  }
  
  public boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = a(paramString1);
    if (paramString2 != null) {
      a(paramString1, true);
    }
    if (paramString2 != null)
    {
      if (paramBoolean) {
        a(10, paramString2);
      }
    }
    else {
      return true;
    }
    try
    {
      AppNotificationManager.a().a(paramString2.jdField_f_of_type_JavaLangString);
      return true;
    }
    catch (Exception paramString1)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "downloadSDKClient>>>", paramString1);
    }
    return true;
  }
  
  public DownloadInfo c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (((localDownloadInfo.jdField_a_of_type_Int == 0) && (paramString.equals(localDownloadInfo.jdField_c_of_type_JavaLangString))) || ((localDownloadInfo.jdField_a_of_type_Int == 1) && (paramString.equals(localDownloadInfo.jdField_h_of_type_JavaLangString))) || ((localDownloadInfo.jdField_a_of_type_Int == 2) && (paramString.equals(localDownloadInfo.jdField_c_of_type_JavaLangString)))) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  public DownloadInfo c(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if (paramString != null)
    {
      paramString.a(2);
      paramString.jdField_g_of_type_Int = paramInt;
    }
    return paramString;
  }
  
  public void c()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if ((localDownloadInfo != null) && (localDownloadInfo.jdField_c_of_type_Int == 1) && ((localDownloadInfo.a() == 2) || (localDownloadInfo.a() == 20)))
        {
          localDownloadInfo.a(3);
          a(3, localDownloadInfo);
        }
      }
    }
    finally {}
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    Object localObject3 = null;
    if (paramDownloadInfo == null) {
      LogUtility.a(jdField_a_of_type_JavaLangString, "installDownload info == null");
    }
    Object localObject2;
    Object localObject1;
    label525:
    label547:
    for (;;)
    {
      return;
      if (!paramDownloadInfo.jdField_c_of_type_Boolean)
      {
        LogUtility.a(jdField_a_of_type_JavaLangString, "installDownload info is not apk");
        return;
      }
      localObject2 = "";
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
      label111:
      boolean bool;
      if (TextUtils.isEmpty(paramDownloadInfo.jdField_k_of_type_JavaLangString)) {
        if (paramDownloadInfo.jdField_c_of_type_Int == 0)
        {
          localTMAssistantDownloadTaskInfo = a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localTMAssistantDownloadTaskInfo != null)
          {
            localObject1 = localObject2;
            if (localTMAssistantDownloadTaskInfo.mState == 4) {
              localObject1 = localTMAssistantDownloadTaskInfo.mSavePath;
            }
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = a(paramDownloadInfo);
            localObject2 = localObject1;
          }
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((TMAssistantDownloadTaskInfo)localObject3).mState == 4) {
              localObject1 = ((TMAssistantDownloadTaskInfo)localObject3).mSavePath;
            }
          }
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramDownloadInfo.jdField_k_of_type_JavaLangString = ((String)localObject1);
            paramDownloadInfo.a(4);
            e(paramDownloadInfo);
            localObject2 = localObject1;
          }
          label165:
          localObject1 = AppUtil.a((String)localObject2);
          LogUtility.a(jdField_a_of_type_JavaLangString, "installDownload localAPKPath=" + (String)localObject2 + ", apkPackageName=" + (String)localObject1 + " updateType=" + paramDownloadInfo.jdField_a_of_type_Int);
          Log.v(jdField_a_of_type_JavaLangString, "installDownload localAPKPath=" + (String)localObject2 + ", apkPackageName=" + (String)localObject1 + " updateType=" + paramDownloadInfo.jdField_a_of_type_Int);
          if (localObject1 == null) {
            break;
          }
          if ((paramDownloadInfo.jdField_f_of_type_Int == 4) || (!paramDownloadInfo.jdField_d_of_type_Boolean)) {
            break label525;
          }
          LogUtility.b(jdField_a_of_type_JavaLangString, "isAutoInstallBySDK is true");
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists())) {
            continue;
          }
          bool = AppUtil.a(CommonDataAdapter.a().a(), (String)localObject2);
          AppCircleReportManager.a().a(100, paramDownloadInfo);
        }
      }
      for (;;)
      {
        if ((!bool) || (!((String)localObject1).equals("com.tencent.android.qqdownloader")) || (!paramDownloadInfo.jdField_b_of_type_JavaLangString.equals("1101070898"))) {
          break label547;
        }
        LogUtility.a(jdField_a_of_type_JavaLangString, "report yyb start install");
        localObject3 = StaticAnalyz.a(paramDownloadInfo.jdField_g_of_type_JavaLangString, "NEWYYB");
        MyAppApi.a().b();
        localObject2 = MyAppApi.a().a();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = paramDownloadInfo.jdField_b_of_type_JavaLangString;
        }
        StaticAnalyz.a("311", (String)localObject3, (String)localObject1, paramDownloadInfo.m);
        paramDownloadInfo = CommonDataAdapter.a().a();
        if (paramDownloadInfo == null) {
          break;
        }
        StaticAnalyz.a(paramDownloadInfo, "312", (String)localObject3, (String)localObject1);
        return;
        localTMAssistantDownloadTaskInfo = a(paramDownloadInfo);
        localObject1 = localObject2;
        if (localTMAssistantDownloadTaskInfo != null)
        {
          localObject1 = localObject2;
          if (localTMAssistantDownloadTaskInfo.mState == 4) {
            localObject1 = localTMAssistantDownloadTaskInfo.mSavePath;
          }
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label111;
        }
        localObject3 = a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
        localObject2 = localObject1;
        break label111;
        localObject2 = paramDownloadInfo.jdField_k_of_type_JavaLangString;
        break label165;
        bool = AppUtil.a(CommonDataAdapter.a().a(), (String)localObject2);
        AppCircleReportManager.a().a(100, paramDownloadInfo);
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      LogUtility.a(jdField_a_of_type_JavaLangString, "package invaild del file");
    }
    try
    {
      localObject1 = new File((String)localObject2);
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      label588:
      a(-2, paramDownloadInfo, -24, "");
      return;
    }
    catch (Exception localException)
    {
      break label588;
    }
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 73	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   4: invokevirtual 502	java/util/concurrent/ConcurrentLinkedQueue:iterator	()Ljava/util/Iterator;
    //   7: astore_1
    //   8: aload_1
    //   9: invokeinterface 457 1 0
    //   14: ifeq +41 -> 55
    //   17: aload_0
    //   18: aload_1
    //   19: invokeinterface 461 1 0
    //   24: checkcast 504	com/tencent/open/downloadnew/DownloadListener
    //   27: invokevirtual 1182	com/tencent/open/downloadnew/DownloadManager:b	(Lcom/tencent/open/downloadnew/DownloadListener;)V
    //   30: goto -22 -> 8
    //   33: astore_1
    //   34: getstatic 32	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: ldc_w 1184
    //   40: aload_1
    //   41: invokestatic 348	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   44: ldc 2
    //   46: monitorenter
    //   47: aconst_null
    //   48: putstatic 185	com/tencent/open/downloadnew/DownloadManager:jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager	Lcom/tencent/open/downloadnew/DownloadManager;
    //   51: ldc 2
    //   53: monitorexit
    //   54: return
    //   55: invokestatic 147	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   58: new 1186	aloo
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 1187	aloo:<init>	(Lcom/tencent/open/downloadnew/DownloadManager;)V
    //   66: invokevirtual 171	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   69: pop
    //   70: goto -26 -> 44
    //   73: astore_1
    //   74: ldc 2
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	DownloadManager
    //   7	12	1	localIterator	Iterator
    //   33	8	1	localException	Exception
    //   73	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	33	java/lang/Exception
    //   8	30	33	java/lang/Exception
    //   55	70	33	java/lang/Exception
    //   47	54	73	finally
    //   74	77	73	finally
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "onReveiveInstallIntent info=" + paramDownloadInfo);
    if (paramDownloadInfo.jdField_c_of_type_Int == 0) {
      StaticAnalyz.a("310", paramDownloadInfo.jdField_g_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo.m);
    }
    if (paramDownloadInfo.jdField_e_of_type_Int != 5) {
      a(paramDownloadInfo.jdField_b_of_type_JavaLangString, false);
    }
    AppNotificationManager.a().a(paramDownloadInfo.jdField_f_of_type_JavaLangString);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 200) {
      ThreadManager.getSubThreadHandler().postDelayed(new alos(this), 3000L);
    }
  }
  
  public void e(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {}
    try
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "addDownloadInfo info.appId = " + paramDownloadInfo.jdField_b_of_type_JavaLangString + ",info.packageName = " + paramDownloadInfo.jdField_d_of_type_JavaLangString + ",info.filePath = " + paramDownloadInfo.jdField_k_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo);
      DownloadDBHelper.a().a(paramDownloadInfo);
      return;
    }
    finally
    {
      paramDownloadInfo = finally;
      throw paramDownloadInfo;
    }
  }
  
  public void f(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener != null)
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener.a(paramDownloadInfo.jdField_d_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_Int, null);
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = null;
  }
  
  public void g(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "patchNewApkSuccess DownloadInfo|" + paramDownloadInfo);
    i(paramDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager
 * JD-Core Version:    0.7.0.1
 */