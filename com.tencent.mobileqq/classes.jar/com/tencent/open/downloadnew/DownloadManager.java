package com.tencent.open.downloadnew;

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
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.img.ImageCache;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.open.downloadnew.common.NoticeDownloadListener;
import com.tencent.open.downloadnew.common.PackageInstallReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class DownloadManager
{
  protected static DownloadManager a;
  public static final String a;
  protected static final byte[] a;
  protected final int a;
  protected long a;
  private ApkGetCodeListener jdField_a_of_type_ComTencentOpenDownloadnewApkGetCodeListener = new DownloadManager.19(this);
  private ApkWriteCodeListener jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener;
  private DownloaderGetCodeClient jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient;
  protected PackageInstallReceiver a;
  protected ITMAssistantDownloadClientListener a;
  protected ITMAssistantDownloadLogListener a;
  protected TMAssistantDownloadClient a;
  protected WeakReference<AppInterface> a;
  protected ConcurrentHashMap<String, DownloadInfo> a;
  protected ConcurrentLinkedQueue<DownloadListener> a;
  protected boolean a;
  protected long b;
  protected String b;
  protected boolean b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(File.separator);
    localStringBuilder.append("tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(".qqdownload");
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected DownloadManager()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new DownloadManager.5(this);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 1000;
    this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener = new DownloadManager.22(this);
    LogUtility.c("DownloadManager_", "DownloadManager create QQ5.0");
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient = DownloaderGetCodeClient.a();
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
    ThreadManager.excute(new DownloadManager.2(this), 32, null, true);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 6: 
      return 10;
    case 5: 
      return -2;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 2: 
      return 2;
    }
    return 20;
  }
  
  public static DownloadManager a()
  {
    try
    {
      DownloadManager localDownloadManager1 = jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager;
      if (localDownloadManager1 == null) {
        try
        {
          jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager = new DownloadManager();
          jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.jdField_b_of_type_JavaLangString = "open_sdkcom.tencent.mobileqq:web";
          jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.b();
          jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.f();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      DownloadManager localDownloadManager2 = jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager;
      return localDownloadManager2;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle)
  {
    LogUtility.c("DownloadManager_", "receive write code msg......");
    if (paramBundle == null)
    {
      LogUtility.c("DownloadManager_", "receive write code msg but data is null......");
      return;
    }
    ThreadManager.excute(new DownloadManager.21(this, paramBundle), 32, null, true);
  }
  
  private void a(DownloadInfo paramDownloadInfo, String paramString1, String paramString2)
  {
    boolean bool;
    if ((paramDownloadInfo.jdField_e_of_type_Int != 4) && (paramDownloadInfo.jdField_d_of_type_Boolean))
    {
      LogUtility.b("DownloadManager_", "isAutoInstallBySDK is true");
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      if (new File(paramString1).exists())
      {
        bool = AppUtil.a(CommonDataAdapter.a().a(), paramString1, paramDownloadInfo.m, paramDownloadInfo.a("big_brother_ref_source_key"), paramDownloadInfo.a("hideInstallSuccessPage"));
        AppCircleReportManager.a().a(100, paramDownloadInfo);
      }
    }
    else
    {
      bool = AppUtil.a(CommonDataAdapter.a().a(), paramString1, paramDownloadInfo.m, paramDownloadInfo.a("big_brother_ref_source_key"), paramDownloadInfo.a("hideInstallSuccessPage"));
      AppCircleReportManager.a().a(100, paramDownloadInfo);
    }
    if ((bool) && (paramString2.equals("com.tencent.android.qqdownloader")) && (paramDownloadInfo.jdField_c_of_type_JavaLangString.equals("1101070898")))
    {
      LogUtility.a("DownloadManager_", "report yyb start install");
      String str = StaticAnalyz.a(paramDownloadInfo.jdField_h_of_type_JavaLangString, "NEWYYB");
      MyAppApi.a().b();
      paramString2 = MyAppApi.a().a();
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = paramDownloadInfo.jdField_c_of_type_JavaLangString;
      }
      StaticAnalyz.a("311", str, paramString1, paramDownloadInfo.o);
      paramDownloadInfo = CommonDataAdapter.a().a();
      if (paramDownloadInfo != null) {
        StaticAnalyz.a(paramDownloadInfo, "312", str, paramString1);
      }
    }
  }
  
  public static boolean a()
  {
    try
    {
      DownloadManager localDownloadManager = jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager;
      boolean bool;
      if (localDownloadManager != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void h(DownloadInfo paramDownloadInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(">>startDownload downloadInfo:");
    ((StringBuilder)localObject1).append(paramDownloadInfo);
    LogUtility.c("DownloadManager_", ((StringBuilder)localObject1).toString());
    if (paramDownloadInfo.jdField_c_of_type_Boolean) {
      ImageCache.a("app", ImageUtil.a(paramDownloadInfo.jdField_c_of_type_JavaLangString, 100), new DownloadManager.10(this, paramDownloadInfo));
    }
    DownloadInfo localDownloadInfo = a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    Object localObject2;
    if (localDownloadInfo != null)
    {
      if (a(localDownloadInfo, paramDownloadInfo)) {
        localObject1 = localDownloadInfo;
      } else {
        localObject1 = paramDownloadInfo;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startDownload() downloadInfo != null>>>downloadInfo.url=");
      ((StringBuilder)localObject2).append(paramDownloadInfo.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("downloadInfo.isAutoInstall");
      ((StringBuilder)localObject2).append(paramDownloadInfo.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject2).append("+++++downloadInfo.downloadType=");
      ((StringBuilder)localObject2).append(paramDownloadInfo.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append("  test");
      ((StringBuilder)localObject2).append(a(paramDownloadInfo.jdField_c_of_type_JavaLangString));
      LogUtility.a("DownloadManager_", ((StringBuilder)localObject2).toString());
    }
    else
    {
      if (paramDownloadInfo.jdField_g_of_type_Int == 12) {
        localObject1 = "2000";
      } else {
        localObject1 = "900";
      }
      StaticAnalyz.a((String)localObject1, paramDownloadInfo.jdField_h_of_type_JavaLangString, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.o);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("+++++startDownload()+++++ downloadInfo == null>>>downloadInfo.url=");
      ((StringBuilder)localObject1).append(paramDownloadInfo.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("+++++downloadInfo.downloadType=");
      ((StringBuilder)localObject1).append(paramDownloadInfo.jdField_a_of_type_Int);
      LogUtility.a("DownloadManager_", ((StringBuilder)localObject1).toString());
      localObject1 = paramDownloadInfo;
    }
    e((DownloadInfo)localObject1);
    if (("com.tencent.mobileqq".equals(((DownloadInfo)localObject1).jdField_e_of_type_JavaLangString)) && (b())) {
      f((DownloadInfo)localObject1);
    }
    if (((DownloadInfo)localObject1).jdField_a_of_type_Int == 1) {
      localObject2 = ((DownloadInfo)localObject1).jdField_i_of_type_JavaLangString;
    } else {
      localObject2 = ((DownloadInfo)localObject1).jdField_d_of_type_JavaLangString;
    }
    int i = ((DownloadInfo)localObject1).jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    localHashMap.put(TMAssistantDownloadConst.PARAM_APPID, ((DownloadInfo)localObject1).jdField_c_of_type_JavaLangString);
    localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, ((DownloadInfo)localObject1).jdField_e_of_type_JavaLangString);
    localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(((DownloadInfo)localObject1).jdField_b_of_type_Int));
    localHashMap.put(TMAssistantDownloadConst.PARAM_VIA, ((DownloadInfo)localObject1).jdField_h_of_type_JavaLangString);
    localHashMap.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, "qqNumber");
    localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
    localHashMap.put(TMAssistantDownloadConst.PARAM_ICON_URL, ((DownloadInfo)localObject1).n);
    localHashMap.put(TMAssistantDownloadConst.PARAM_APP_NAME, ((DownloadInfo)localObject1).jdField_f_of_type_JavaLangString);
    localHashMap.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(((DownloadInfo)localObject1).jdField_i_of_type_Int));
    localHashMap.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(((DownloadInfo)localObject1).jdField_d_of_type_Boolean));
    localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(((DownloadInfo)localObject1).jdField_d_of_type_Long));
    ThreadManager.getSubThreadHandler().post(new DownloadManager.11(this, (String)localObject2, localHashMap, i, (DownloadInfo)localObject1, localDownloadInfo, paramDownloadInfo));
    try
    {
      DownloadInfoReport.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (DownloadInfo)localObject1);
      return;
    }
    catch (Throwable paramDownloadInfo) {}
  }
  
  private void i(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManager.15(this, paramDownloadInfo));
  }
  
  private void j(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c("DownloadManager_", "receive get code msg......");
    if (paramDownloadInfo == null)
    {
      LogUtility.c("DownloadManager_", "receive get code msg but info is null......");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadManager.20(this, paramDownloadInfo));
  }
  
  public int a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return -30;
    }
    ApkWriteCodeListener localApkWriteCodeListener = this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener;
    if (localApkWriteCodeListener != null) {
      return localApkWriteCodeListener.a(paramDownloadInfo.jdField_e_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_Int, paramDownloadInfo.l, null);
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = null;
    return -40;
  }
  
  public int a(String paramString)
  {
    Object localObject = a(paramString);
    if (localObject != null)
    {
      if (((DownloadInfo)localObject).jdField_a_of_type_Int == 1) {
        localObject = ((DownloadInfo)localObject).jdField_i_of_type_JavaLangString;
      } else {
        localObject = ((DownloadInfo)localObject).jdField_d_of_type_JavaLangString;
      }
      ThreadManager.getSubThreadHandler().post(new DownloadManager.12(this, (String)localObject));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pause url=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", appid=");
      localStringBuilder.append(paramString);
      LogUtility.a("DownloadManager_", localStringBuilder.toString());
    }
    return 0;
  }
  
  public DownloadInfo a(String paramString)
  {
    if (paramString == null)
    {
      LogUtility.a("DownloadManager_", "getDownloadInfoById appId == null");
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
    localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, paramDownloadInfo.jdField_c_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_j_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.jdField_d_of_type_JavaLangString, paramDownloadInfo.k);
    localBundle.putString(DownloadConstants.jdField_f_of_type_JavaLangString, paramDownloadInfo.jdField_e_of_type_JavaLangString);
    localBundle.putInt(DownloadConstants.jdField_e_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_Int);
    localBundle.putString(DownloadConstants.jdField_i_of_type_JavaLangString, paramDownloadInfo.jdField_h_of_type_JavaLangString);
    StringBuilder localStringBuilder1 = null;
    Object localObject = localStringBuilder1;
    try
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localObject = localStringBuilder1;
      localStringBuilder2.append("OpenSDK getTaskInfoFromMyApp param SNGAppId=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.jdField_c_of_type_JavaLangString);
      localObject = localStringBuilder1;
      localStringBuilder2.append(" apkId=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.k);
      localObject = localStringBuilder1;
      localStringBuilder2.append(" taskAppId=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.jdField_j_of_type_JavaLangString);
      localObject = localStringBuilder1;
      localStringBuilder2.append(" packageName=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.jdField_e_of_type_JavaLangString);
      localObject = localStringBuilder1;
      localStringBuilder2.append(" version=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.jdField_b_of_type_Int);
      localObject = localStringBuilder1;
      localStringBuilder2.append(" via=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.jdField_h_of_type_JavaLangString);
      localObject = localStringBuilder1;
      LogUtility.a("State_Log", localStringBuilder2.toString());
      localObject = localStringBuilder1;
      paramDownloadInfo = MyAppApi.a().a(localBundle);
      if (paramDownloadInfo != null)
      {
        localObject = paramDownloadInfo;
        localStringBuilder1 = new StringBuilder();
        localObject = paramDownloadInfo;
        localStringBuilder1.append("OpenSDK getTaskInfoFromMyApp result taskInfo path=");
        localObject = paramDownloadInfo;
        localStringBuilder1.append(paramDownloadInfo.mSavePath);
        localObject = paramDownloadInfo;
        localStringBuilder1.append(" state=");
        localObject = paramDownloadInfo;
        localStringBuilder1.append(paramDownloadInfo.mState);
        localObject = paramDownloadInfo;
        LogUtility.a("State_Log", localStringBuilder1.toString());
        return paramDownloadInfo;
      }
      localObject = paramDownloadInfo;
      LogUtility.a("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo is null");
      return paramDownloadInfo;
    }
    catch (Exception paramDownloadInfo)
    {
      LogUtility.a("DownloadManager_", "getTaskInfoFromMyApp>>>", paramDownloadInfo);
    }
    return localObject;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = a().getDownloadTaskState(paramString);
      }
      catch (Exception localException)
      {
        LogUtility.c("DownloadManager_", "downloadSDKClient>>>", localException);
      }
    } else {
      localTMAssistantDownloadTaskInfo2 = null;
    }
    if (localTMAssistantDownloadTaskInfo2 == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTaskInfoFromSDK null url=");
      localStringBuilder.append(paramString);
      LogUtility.a("DownloadManager_", localStringBuilder.toString());
    }
    return localTMAssistantDownloadTaskInfo2;
  }
  
  public TMAssistantDownloadClient a()
  {
    TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.jdField_b_of_type_JavaLangString).registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    if (QLog.isColorLevel())
    {
      QLog.i("DownloadManager_", 2, "registerLogListener!");
      TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.jdField_b_of_type_JavaLangString).registerLogListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener);
    }
    if (!this.jdField_b_of_type_Boolean) {
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception: ");
        localStringBuilder.append(localException.toString());
        LogUtility.e("DownloadManager_", localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.jdField_b_of_type_JavaLangString);
    return this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  }
  
  public String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.l;
    }
    return "";
  }
  
  public WeakReference<AppInterface> a()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 == null) {
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
          LogUtility.c("DownloadManager_", "getQQAppInterface>>>", localException);
        }
      }
      WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      return localWeakReference;
    }
    finally {}
  }
  
  protected List<DownloadInfo> a(int paramInt)
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
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public List<DownloadInfo> a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDownloadInfoById via == ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.a("DownloadManager_", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((!TextUtils.isEmpty(localDownloadInfo.jdField_h_of_type_JavaLangString)) && (localDownloadInfo.jdField_h_of_type_JavaLangString.equals(paramString))) {
        ((List)localObject).add(localDownloadInfo);
      }
    }
    paramString = new StringBuilder();
    paramString.append("getDownloadInfoByVia result =");
    paramString.append(localObject);
    LogUtility.a("DownloadManager_", paramString.toString());
    return localObject;
  }
  
  public ConcurrentLinkedQueue<DownloadListener> a()
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
    ThreadManager.getSubThreadHandler().post(new DownloadManager.1(this));
  }
  
  public void a(int paramInt, DownloadInfo paramDownloadInfo)
  {
    a(paramInt, paramDownloadInfo, 0, "");
  }
  
  public void a(int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2, String paramString)
  {
    if (paramDownloadInfo == null) {
      try
      {
        paramDownloadInfo = new StringBuilder();
        paramDownloadInfo.append("notifyListener info == null id=");
        paramDownloadInfo.append(paramInt1);
        LogUtility.e("DownloadManager_", paramDownloadInfo.toString());
        return;
      }
      finally
      {
        break label994;
      }
    }
    if (paramInt1 != -2)
    {
      if (paramInt1 != 6)
      {
        if (paramInt1 != 13)
        {
          if (paramInt1 != 20)
          {
            if (paramInt1 != 2)
            {
              if (paramInt1 != 3)
              {
                if (paramInt1 != 4)
                {
                  if (paramInt1 != 9)
                  {
                    if (paramInt1 == 10)
                    {
                      paramString = new StringBuilder();
                      paramString.append(HardCodeUtil.a(2131703660));
                      paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
                      LogUtility.a("DownloadManager_", paramString.toString());
                      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramDownloadInfo.jdField_c_of_type_JavaLangString);
                      DownloadDBHelper.a().a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
                      AppNotificationManager.a().a(paramDownloadInfo.jdField_g_of_type_JavaLangString);
                      paramDownloadInfo.a(10);
                      paramString = new StringBuilder();
                      paramString.append("downloadInfo.state = ");
                      paramString.append(paramDownloadInfo.a());
                      LogUtility.a("DownloadManager_", paramString.toString());
                      paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
                      while (paramString.hasNext()) {
                        ((DownloadListener)paramString.next()).onDownloadCancel(paramDownloadInfo);
                      }
                    }
                  }
                  else
                  {
                    paramString = new StringBuilder();
                    paramString.append(HardCodeUtil.a(2131703668));
                    paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
                    LogUtility.a("DownloadManager_", paramString.toString());
                    paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
                    while (paramString.hasNext()) {
                      ((DownloadListener)paramString.next()).uninstallSucceed(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_e_of_type_JavaLangString);
                    }
                  }
                }
                else
                {
                  paramString = new StringBuilder();
                  paramString.append(HardCodeUtil.a(2131703657));
                  paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
                  LogUtility.a("DownloadManager_", paramString.toString());
                  paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
                  while (paramString.hasNext()) {
                    ((DownloadListener)paramString.next()).onDownloadFinish(paramDownloadInfo);
                  }
                  DownloadInfoReport.a(2, null, 100, paramDownloadInfo);
                }
              }
              else
              {
                paramString = new StringBuilder();
                paramString.append(HardCodeUtil.a(2131703651));
                paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
                LogUtility.a("DownloadManager_", paramString.toString());
                paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
                while (paramString.hasNext()) {
                  ((DownloadListener)paramString.next()).onDownloadPause(paramDownloadInfo);
                }
              }
            }
            else if ((paramDownloadInfo.jdField_c_of_type_Int == 1) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L))
            {
              this.jdField_a_of_type_Long = System.currentTimeMillis();
              paramDownloadInfo = new StringBuilder();
              paramDownloadInfo.append(HardCodeUtil.a(2131703642));
              paramDownloadInfo.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
              LogUtility.a("DownloadManager_", paramDownloadInfo.toString());
              paramDownloadInfo = a(2);
              paramString = new StringBuilder();
              paramString.append(HardCodeUtil.a(2131703650));
              paramString.append(paramDownloadInfo.size());
              LogUtility.a("DownloadManager_", paramString.toString());
              paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
              while (paramString.hasNext())
              {
                DownloadListener localDownloadListener = (DownloadListener)paramString.next();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("###下载1 listner name");
                localStringBuilder.append(localDownloadListener.getClass().getName());
                LogUtility.a("DownloadManager_", localStringBuilder.toString());
                localDownloadListener.onDownloadUpdate(paramDownloadInfo);
              }
            }
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append(HardCodeUtil.a(2131703663));
            paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
            LogUtility.a("DownloadManager_", paramString.toString());
            paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
            while (paramString.hasNext()) {
              ((DownloadListener)paramString.next()).onDownloadWait(paramDownloadInfo);
            }
          }
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append(HardCodeUtil.a(2131703647));
          paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
          LogUtility.a("DownloadManager_", paramString.toString());
          paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
          while (paramString.hasNext()) {
            ((DownloadListener)paramString.next()).packageReplaced(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_e_of_type_JavaLangString);
          }
        }
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(HardCodeUtil.a(2131703661));
        paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        LogUtility.a("DownloadManager_", paramString.toString());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).installSucceed(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_e_of_type_JavaLangString);
        }
      }
    }
    else {
      a(paramDownloadInfo, paramInt2, paramString);
    }
    return;
    for (;;)
    {
      label994:
      throw paramDownloadInfo;
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadManager.17(this, paramBundle, paramActivity, paramString, paramApkUpdateDetail, paramInt));
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
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    try
    {
      h(paramDownloadInfo);
      return;
    }
    finally
    {
      paramDownloadInfo = finally;
      throw paramDownloadInfo;
    }
  }
  
  protected void a(DownloadInfo paramDownloadInfo, int paramInt, String paramString)
  {
    this.jdField_b_of_type_Boolean = false;
    if (paramDownloadInfo == null)
    {
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("handleDownloadErrorCallBack info == null code = ");
      paramDownloadInfo.append(paramInt);
      paramDownloadInfo.append(" msg = ");
      paramDownloadInfo.append(paramString);
      LogUtility.d("DownloadManager_", paramDownloadInfo.toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleDownloadErrorCallBack code = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.d("DownloadManager_", ((StringBuilder)localObject).toString());
    int i = 3;
    localObject = paramString;
    if (paramInt >= 400)
    {
      localObject = paramString;
      if (paramInt > 599) {}
    }
    for (;;)
    {
      try
      {
        localObject = CommonDataAdapter.a().a().getString(2131694621);
      }
      catch (Exception paramDownloadInfo)
      {
        int j;
        String str;
        continue;
      }
      paramString = CommonDataAdapter.a().a().getString(2131694616);
      continue;
      paramString = CommonDataAdapter.a().a().getString(2131694623);
      continue;
      paramString = CommonDataAdapter.a().a().getString(2131694628);
      continue;
      paramString = CommonDataAdapter.a().a().getString(2131694625);
      continue;
      LogUtility.a("DownloadManager_", HardCodeUtil.a(2131703645));
      if ((paramDownloadInfo.jdField_e_of_type_JavaLangString != null) && ("com.tencent.mobileqq".equals(paramDownloadInfo.jdField_e_of_type_JavaLangString)) && (paramDownloadInfo.jdField_a_of_type_Int != 1) && (b()))
      {
        LogUtility.a("DownloadManager_", HardCodeUtil.a(2131703646));
        ThreadManager.getSubThreadHandler().post(new DownloadManager.6(this, paramDownloadInfo));
        return;
      }
      paramDownloadInfo.a(4);
      if (paramDownloadInfo.jdField_a_of_type_Int == 1)
      {
        i(paramDownloadInfo);
        return;
      }
      ThreadManager.excute(new DownloadManager.7(this, paramDownloadInfo), 32, null, true);
      return;
      paramString = CommonDataAdapter.a().a().getString(2131694616);
      continue;
      paramString = CommonDataAdapter.a().a().getString(2131694626);
      continue;
      paramString = CommonDataAdapter.a().a().getString(2131694621);
      continue;
      LogUtility.a("DownloadManager_", HardCodeUtil.a(2131703669));
      paramString = (String)localObject;
      continue;
      if (paramInt == 712) {
        localObject = CommonDataAdapter.a().a().getString(2131694618);
      } else {
        localObject = CommonDataAdapter.a().a().getString(2131694619);
      }
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
      if (paramDownloadInfo != null)
      {
        if (paramDownloadInfo.jdField_a_of_type_Int == 1) {
          str = paramDownloadInfo.jdField_i_of_type_JavaLangString;
        } else {
          str = paramDownloadInfo.jdField_d_of_type_JavaLangString;
        }
        i = j;
        paramString = (String)localObject;
        if (str != null)
        {
          ThreadManager.excute(new DownloadManager.8(this, str, paramDownloadInfo), 32, null, true);
          paramString = (String)localObject;
          i = j;
        }
      }
      paramDownloadInfo.a(i);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131703656));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
      LogUtility.a("DownloadManager_", ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      if (((Iterator)localObject).hasNext())
      {
        ((DownloadListener)((Iterator)localObject).next()).onDownloadError(paramDownloadInfo, paramInt, paramString, i);
      }
      else
      {
        if (!TextUtils.isEmpty(paramString))
        {
          b(paramString);
          return;
          paramDownloadInfo.printStackTrace();
        }
        return;
        if (paramInt != -51) {
          if ((paramInt != -40) && (paramInt != -30)) {
            if (paramInt != -24) {
              if ((paramInt != -20) && (paramInt != -10)) {
                switch (paramInt)
                {
                case 4: 
                case 3: 
                case 2: 
                case 1: 
                case -1: 
                default: 
                  switch (paramInt)
                  {
                  }
                  switch (paramInt)
                  {
                  }
                  switch (paramInt)
                  {
                  }
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong)
  {
    if (a() != null)
    {
      if (a().get() == null) {
        return;
      }
      if ((AppInterface)a().get() != null)
      {
        int i = 14;
        if (!"biz_src_yyb".equals(paramDownloadInfo.m)) {
          if ("biz_src_zf_games".equals(paramDownloadInfo.m))
          {
            i = 15;
          }
          else if ("biz_src_jc_update".equals(paramDownloadInfo.m))
          {
            i = 17;
          }
          else if ("biz_src_news".equals(paramDownloadInfo.m))
          {
            i = 18;
          }
          else
          {
            "biz_src_jc_vip".equals(paramDownloadInfo.m);
            i = 40;
          }
        }
        Bundle localBundle1 = null;
        if (!TextUtils.isEmpty(paramDownloadInfo.jdField_f_of_type_JavaLangString))
        {
          localBundle1 = new Bundle();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramDownloadInfo.jdField_f_of_type_JavaLangString);
          ((StringBuilder)localObject).append(".apk");
          localBundle1.putString("appname", ((StringBuilder)localObject).toString());
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportDownloadResult info.packageName = ");
        ((StringBuilder)localObject).append(paramDownloadInfo.jdField_e_of_type_JavaLangString);
        ((StringBuilder)localObject).append(",info.urlStr = ");
        ((StringBuilder)localObject).append(paramDownloadInfo.jdField_d_of_type_JavaLangString);
        ((StringBuilder)localObject).append(",info.filePath = ");
        ((StringBuilder)localObject).append(paramDownloadInfo.l);
        LogUtility.c("DownloadManager_", ((StringBuilder)localObject).toString());
        localObject = new Intent("com.opensdk.downloadmanager.renameFilename");
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("filePath", paramDownloadInfo.l);
        localBundle2.putLong("dataLength", paramLong);
        localBundle2.putInt("fileSourceId", i);
        localBundle2.putBundle("otherData", localBundle1);
        localBundle2.putInt("peerType", -1);
        ((Intent)localObject).putExtra("extraBundle", localBundle2);
        CommonDataAdapter.a().a().sendBroadcast((Intent)localObject);
      }
    }
  }
  
  protected void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramDownloadInfo == null)
    {
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("trafficReport info == null code = ");
      paramDownloadInfo.append(paramInt);
      LogUtility.c("DownloadManager_", paramDownloadInfo.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("trafficReport code = ");
    localStringBuilder.append(paramInt);
    LogUtility.c("DownloadManager_", localStringBuilder.toString());
    if ((paramInt >= 400) && (paramInt <= 599)) {
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "open appstore network error");
    }
    if (paramInt != -24)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 3) {
            if (paramInt != 4) {
              if (paramInt == 5) {
                break label301;
              }
            }
          }
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              return;
            case 703: 
              a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "write file error");
              return;
              a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "DownloadSDK_START_FAILED_EXISTED");
              return;
            }
          case 600: 
          case 604: 
            a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "download error");
            return;
          }
        }
        a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "network error");
        return;
      }
      label301:
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "do not need to handle error");
      return;
    }
    a(paramDownloadInfo, 0L, paramLong1 - paramDownloadInfo.jdField_b_of_type_Long, "package invalid");
  }
  
  protected void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, String paramString)
  {
    if (paramLong2 > 0L)
    {
      paramDownloadInfo.jdField_b_of_type_Long = paramLong1;
      e(paramDownloadInfo);
      a(paramString, paramLong2, paramDownloadInfo.m);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    if (paramApkUpdateDetail != null) {}
    try
    {
      int i = paramApkUpdateDetail.updatemethod;
      if (i == 4)
      {
        try
        {
          String str = paramApkUpdateDetail.url;
          long l = paramApkUpdateDetail.patchsize;
          paramApkUpdateDetail = paramApkUpdateDetail.fileMd5;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131703665));
          localStringBuilder.append(l / 1048576L);
          localStringBuilder.append("MB  fileMd5=");
          localStringBuilder.append(paramApkUpdateDetail);
          localStringBuilder.append(" urlPatch=");
          localStringBuilder.append(str);
          LogUtility.c("DownloadManager_", localStringBuilder.toString());
          paramDownloadInfo.jdField_i_of_type_JavaLangString = str;
          paramDownloadInfo.jdField_a_of_type_Int = 1;
          if (l > 0L) {
            paramDownloadInfo.jdField_d_of_type_Long = l;
          }
          a(paramDownloadInfo);
        }
        catch (Exception paramApkUpdateDetail)
        {
          LogUtility.c("DownloadManager_", "statrDownloadWithUpdateData jsonException>>>", paramApkUpdateDetail);
          a(paramDownloadInfo);
        }
      }
      else
      {
        LogUtility.c("DownloadManager_", "statrDownloadWithUpdateData updateJson empty");
        a(paramDownloadInfo);
      }
      return;
    }
    finally {}
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
    if (paramITMAssistantDownloadLogListener == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DownloadManager_", 2, "unregisterLogListener logListener == null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DownloadManager_", 2, "unregisterLogListener");
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
      LogUtility.c("DownloadManager_", "unregisterLogListener Exception:", paramITMAssistantDownloadLogListener);
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      AppNotificationManager.a().a(paramString);
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1)
    {
      if ("biz_src_yyb".equals(paramString2))
      {
        paramString2 = new String[3];
        paramString2[0] = "param_WIFIAppCenterDefaultDownloadFlow";
        paramString2[1] = "param_WIFIFlow";
        paramString2[2] = "param_Flow";
        break label341;
      }
      if ("biz_src_jc_update".equals(paramString2))
      {
        paramString2 = new String[3];
        paramString2[0] = "param_WIFIAppCenterQQUpdateDownloadFlow";
        paramString2[1] = "param_WIFIFlow";
        paramString2[2] = "param_Flow";
        break label341;
      }
      if ("biz_src_zf_games".equals(paramString2))
      {
        paramString2 = new String[3];
        paramString2[0] = "param_WIFIAppCenterGameCenterDownloadFlow";
        paramString2[1] = "param_WIFIFlow";
        paramString2[2] = "param_Flow";
        break label341;
      }
      if ("biz_src_jc_vip".equals(paramString2))
      {
        paramString2 = new String[3];
        paramString2[0] = "param_WIFIAppCenterOthersDownloadFlow";
        paramString2[1] = "param_WIFIFlow";
        paramString2[2] = "param_Flow";
        break label341;
      }
    }
    else
    {
      if ("biz_src_yyb".equals(paramString2))
      {
        paramString2 = new String[3];
        paramString2[0] = "param_XGAppCenterDefaultDownloadFlow";
        paramString2[1] = "param_XGFlow";
        paramString2[2] = "param_Flow";
        break label341;
      }
      if ("biz_src_jc_update".equals(paramString2))
      {
        paramString2 = new String[3];
        paramString2[0] = "param_XGAppCenterQQUpdateDownloadFlow";
        paramString2[1] = "param_XGFlow";
        paramString2[2] = "param_Flow";
        break label341;
      }
      if ("biz_src_zf_games".equals(paramString2))
      {
        paramString2 = new String[3];
        paramString2[0] = "param_XGAppCenterGameCenterDownloadFlow";
        paramString2[1] = "param_XGFlow";
        paramString2[2] = "param_Flow";
        break label341;
      }
      if ("biz_src_jc_vip".equals(paramString2))
      {
        paramString2 = new String[3];
        paramString2[0] = "param_XGAppCenterOthersDownloadFlow";
        paramString2[1] = "param_XGFlow";
        paramString2[2] = "param_Flow";
        break label341;
      }
    }
    paramString2 = null;
    label341:
    if ((a() != null) && (paramString2 != null))
    {
      paramString2 = (AppInterface)a().get();
      if (paramString2 == null)
      {
        LogUtility.c("DownloadManager_", "appinterface is null");
        return;
      }
      try
      {
        paramString2.getCurrentAccountUin();
        paramString2 = new StringBuilder();
        paramString2.append("sendAppDataIncerment logMsg: ");
        paramString2.append(paramString1);
        paramString2.append(" ,fileSize : ");
        paramString2.append(paramLong);
        LogUtility.c("DownloadManager_", paramString2.toString());
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    LogUtility.c("DownloadManager_", "application or tags is null");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      LogUtility.d("DownloadManager_", "appid is empty");
      return;
    }
    Object localObject = a(paramString);
    if (localObject == null)
    {
      LogUtility.d("DownloadManager_", "clearDownloadInfo info == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearDownloadInfo info =");
    localStringBuilder.append(((DownloadInfo)localObject).toString());
    LogUtility.a("DownloadManager_", localStringBuilder.toString());
    if (((DownloadInfo)localObject).jdField_c_of_type_Int == 0)
    {
      if (((DownloadInfo)localObject).jdField_a_of_type_Int == 1) {
        localObject = ((DownloadInfo)localObject).jdField_i_of_type_JavaLangString;
      } else {
        localObject = ((DownloadInfo)localObject).jdField_d_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.getSubThreadHandler().post(new DownloadManager.9(this, paramBoolean, (String)localObject));
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    DownloadDBHelper.a().a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject3 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    ArrayList localArrayList = new ArrayList();
    String str = "";
    Object localObject1 = "";
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)((Iterator)localObject3).next();
      if ((localDownloadInfo != null) && (localDownloadInfo.jdField_e_of_type_Int != 4) && (localDownloadInfo.jdField_e_of_type_Int != 1) && (localDownloadInfo.jdField_c_of_type_Int == 1))
      {
        localArrayList.add(localDownloadInfo);
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (!AppUtil.a(localDownloadInfo.jdField_e_of_type_JavaLangString)) {
            localObject2 = localDownloadInfo.jdField_f_of_type_JavaLangString;
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    if (localArrayList.size() > 0)
    {
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (DownloadInfo)((Iterator)localObject2).next();
        ((DownloadInfo)localObject3).a(10);
        a(10, (DownloadInfo)localObject3);
      }
    }
    boolean bool = QAppCenterPluginProxyActivityTools.jdField_a_of_type_Boolean;
    if ((paramBoolean) && (i > 0))
    {
      localObject3 = new StringBuilder();
      localObject2 = str;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131703658));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131703643));
      localObject1 = ((StringBuilder)localObject3).toString();
      if (bool)
      {
        ToastUtil.a().a((String)localObject1, 1);
        return;
      }
      MyAppApi.a().a(true, (String)localObject1);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshDownloadInfo DownloadInfo=");
    ((StringBuilder)localObject).append(paramDownloadInfo);
    LogUtility.a("DownloadManager_", ((StringBuilder)localObject).toString());
    DownloadInfo localDownloadInfo = a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    if (localDownloadInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshDownloadInfo cacheInfo =");
      ((StringBuilder)localObject).append(localDownloadInfo);
      LogUtility.a("DownloadManager_", ((StringBuilder)localObject).toString());
      if (localDownloadInfo.jdField_c_of_type_Int == 0)
      {
        LogUtility.a("DownloadManager_", "refreshDownloadInfo DownloadInfo.DOWNLOAD_TYPE_DOWNLOADSDK......");
        paramDownloadInfo.jdField_h_of_type_Int = localDownloadInfo.jdField_h_of_type_Int;
        if (localDownloadInfo.jdField_a_of_type_Int == 1) {
          localObject = localDownloadInfo.jdField_i_of_type_JavaLangString;
        } else {
          localObject = localDownloadInfo.jdField_d_of_type_JavaLangString;
        }
        localObject = a().a((String)localObject);
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshDownloadInfo sdk getReceiveDataLen=");
          localStringBuilder.append(((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen);
          localStringBuilder.append(" getTotalDataLen=");
          localStringBuilder.append(((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen);
          LogUtility.a("DownloadManager_", localStringBuilder.toString());
          paramDownloadInfo.jdField_f_of_type_Int = ((int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen * 100.0F / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen));
          paramDownloadInfo.a(a(((TMAssistantDownloadTaskInfo)localObject).mState));
          paramDownloadInfo.jdField_c_of_type_Int = 0;
          if (localDownloadInfo.jdField_a_of_type_Int == 1)
          {
            if (TextUtils.isEmpty(localDownloadInfo.l)) {
              paramDownloadInfo.l = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
            } else {
              paramDownloadInfo.l = localDownloadInfo.l;
            }
          }
          else {
            paramDownloadInfo.l = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          }
          if (paramDownloadInfo.jdField_e_of_type_Int == 4)
          {
            paramDownloadInfo.jdField_j_of_type_Int = localDownloadInfo.jdField_j_of_type_Int;
            if (paramDownloadInfo.jdField_j_of_type_Int != 0)
            {
              paramDownloadInfo.jdField_e_of_type_Int = 3;
              e(localDownloadInfo);
            }
          }
          return true;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
        DownloadDBHelper.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
        paramDownloadInfo.jdField_e_of_type_Int = -100;
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
          paramDownloadInfo.l = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          long l1 = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
          long l2 = ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen;
          paramDownloadInfo.jdField_f_of_type_Int = ((int)((float)l1 * 100.0F / (float)l2));
          if (!MyAppApi.a().e()) {
            paramDownloadInfo.jdField_f_of_type_Int = 0;
          }
          return true;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
        DownloadDBHelper.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
      }
    }
    return false;
  }
  
  protected boolean a(DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2)
  {
    paramDownloadInfo1.jdField_a_of_type_Boolean = paramDownloadInfo2.jdField_a_of_type_Boolean;
    paramDownloadInfo1.jdField_b_of_type_Boolean = paramDownloadInfo2.jdField_b_of_type_Boolean;
    paramDownloadInfo1.jdField_c_of_type_Int = paramDownloadInfo2.jdField_c_of_type_Int;
    paramDownloadInfo1.jdField_h_of_type_JavaLangString = paramDownloadInfo2.jdField_h_of_type_JavaLangString;
    if (!TextUtils.isEmpty(paramDownloadInfo1.jdField_d_of_type_JavaLangString))
    {
      if (!paramDownloadInfo1.jdField_d_of_type_JavaLangString.equals(paramDownloadInfo2.jdField_d_of_type_JavaLangString))
      {
        a(paramDownloadInfo2.jdField_c_of_type_JavaLangString, false);
        return false;
      }
    }
    else {
      paramDownloadInfo1.jdField_d_of_type_JavaLangString = paramDownloadInfo2.jdField_d_of_type_JavaLangString;
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
    if (paramString2 != null) {
      if (paramBoolean) {
        a(10, paramString2);
      } else {
        try
        {
          AppNotificationManager.a().a(paramString2.jdField_g_of_type_JavaLangString);
        }
        catch (Exception paramString1)
        {
          LogUtility.c("DownloadManager_", "downloadSDKClient>>>", paramString1);
        }
      }
    }
    return true;
  }
  
  public DownloadInfo b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (localIterator.hasNext())
        {
          DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
          boolean bool = paramString.equals(localDownloadInfo.jdField_e_of_type_JavaLangString);
          if (bool) {
            return localDownloadInfo;
          }
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
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
  
  public String b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.m;
    }
    return "";
  }
  
  public List<DownloadInfo> b(String paramString)
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
            if (localDownloadInfo.jdField_a_of_type_Int == 1) {
              paramString = localDownloadInfo.jdField_i_of_type_JavaLangString;
            } else {
              paramString = localDownloadInfo.jdField_d_of_type_JavaLangString;
            }
            paramString = a().a(paramString);
            if (paramString != null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("queryDownloadInfosByVia sdk getReceiveDataLen=");
              localStringBuilder.append(paramString.mReceiveDataLen);
              localStringBuilder.append(" getTotalDataLen=");
              localStringBuilder.append(paramString.mTotalDataLen);
              LogUtility.a("DownloadManager_", localStringBuilder.toString());
              localDownloadInfo.jdField_f_of_type_Int = ((int)((float)paramString.mReceiveDataLen * 100.0F / (float)paramString.mTotalDataLen));
              localDownloadInfo.a(a(paramString.mState));
              if (localDownloadInfo.jdField_a_of_type_Int == 1)
              {
                if (TextUtils.isEmpty(localDownloadInfo.l)) {
                  localDownloadInfo.l = paramString.mSavePath;
                }
              }
              else {
                localDownloadInfo.l = paramString.mSavePath;
              }
              localArrayList.add(localDownloadInfo);
            }
            else
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
              DownloadDBHelper.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
            DownloadDBHelper.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected void b()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadManager.3(this), 5000L);
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadManager.4(this), 10000L);
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    try
    {
      LogUtility.c("DownloadManager_", "complete info == null ");
      return;
    }
    finally {}
    if (((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) && ("com.tencent.mobileqq".equals(paramDownloadInfo.jdField_e_of_type_JavaLangString)) && (ConfigHandler.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      paramDownloadInfo.jdField_a_of_type_Boolean = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownload complete, info = ");
    localStringBuilder.append(paramDownloadInfo.toString());
    LogUtility.a("DownloadManager_", localStringBuilder.toString());
    if (paramDownloadInfo.jdField_c_of_type_Int == 0)
    {
      if (paramDownloadInfo.jdField_a_of_type_Int == 1) {
        i(paramDownloadInfo);
      } else {
        ThreadManager.getSubThreadHandler().post(new DownloadManager.13(this, paramDownloadInfo));
      }
    }
    else {
      ThreadManager.excute(new DownloadManager.14(this, paramDownloadInfo), 32, null, true);
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
        return;
      }
    }
    catch (Exception paramString)
    {
      LogUtility.c("DownloadManager_", "showToast>>>", paramString);
    }
  }
  
  public boolean b()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  public boolean b(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    if (paramApkWriteCodeListener == null) {
      return false;
    }
    ApkWriteCodeListener localApkWriteCodeListener = this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener;
    if ((localApkWriteCodeListener != null) && (paramApkWriteCodeListener == localApkWriteCodeListener))
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = null;
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = a(paramString1);
    if (paramString2 != null) {
      a(paramString1, true);
    }
    if (paramString2 != null)
    {
      if (paramBoolean)
      {
        a(10, paramString2);
        return true;
      }
      try
      {
        AppNotificationManager.a().a(paramString2.jdField_g_of_type_JavaLangString);
        return true;
      }
      catch (Exception paramString1)
      {
        LogUtility.c("DownloadManager_", "downloadSDKClient>>>", paramString1);
      }
    }
    return true;
  }
  
  protected DownloadInfo c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (((localDownloadInfo.jdField_a_of_type_Int == 0) && (paramString.equals(localDownloadInfo.jdField_d_of_type_JavaLangString))) || ((localDownloadInfo.jdField_a_of_type_Int == 1) && (paramString.equals(localDownloadInfo.jdField_i_of_type_JavaLangString))) || ((localDownloadInfo.jdField_a_of_type_Int == 2) && (paramString.equals(localDownloadInfo.jdField_d_of_type_JavaLangString)))) {
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
      paramString.jdField_f_of_type_Int = paramInt;
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
        if ((localDownloadInfo != null) && ((localDownloadInfo.a() == 2) || (localDownloadInfo.a() == 20))) {
          a(localDownloadInfo.jdField_c_of_type_JavaLangString);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null)
    {
      LogUtility.a("DownloadManager_", "installDownload info == null");
      return;
    }
    if (!paramDownloadInfo.jdField_c_of_type_Boolean)
    {
      LogUtility.a("DownloadManager_", "installDownload info is not apk");
      return;
    }
    Object localObject1;
    if (TextUtils.isEmpty(paramDownloadInfo.l))
    {
      int i = paramDownloadInfo.jdField_c_of_type_Int;
      localObject3 = null;
      if (i == 0)
      {
        localObject1 = a(paramDownloadInfo.jdField_d_of_type_JavaLangString);
        if ((localObject1 != null) && (((TMAssistantDownloadTaskInfo)localObject1).mState == 4)) {
          localObject2 = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        } else {
          localObject2 = "";
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = a(paramDownloadInfo);
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = a(paramDownloadInfo);
        if ((localObject1 != null) && (((TMAssistantDownloadTaskInfo)localObject1).mState == 4)) {
          localObject2 = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        } else {
          localObject2 = "";
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = a(paramDownloadInfo.jdField_d_of_type_JavaLangString);
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((TMAssistantDownloadTaskInfo)localObject3).mState == 4) {
          localObject2 = ((TMAssistantDownloadTaskInfo)localObject3).mSavePath;
        }
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramDownloadInfo.l = ((String)localObject2);
        paramDownloadInfo.a(4);
        e(paramDownloadInfo);
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = paramDownloadInfo.l;
    }
    Object localObject2 = AppUtil.a((String)localObject1);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("installDownload localAPKPath=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", apkPackageName=");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(" updateType=");
    ((StringBuilder)localObject3).append(paramDownloadInfo.jdField_a_of_type_Int);
    LogUtility.a("DownloadManager_", ((StringBuilder)localObject3).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("installDownload localAPKPath=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", apkPackageName=");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(" updateType=");
    ((StringBuilder)localObject3).append(paramDownloadInfo.jdField_a_of_type_Int);
    Log.v("DownloadManager_", ((StringBuilder)localObject3).toString());
    if (localObject2 != null)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[installDownload] begin sendCheckDownloadReq pkgname=");
      ((StringBuilder)localObject3).append((String)localObject2);
      LogUtility.c("DownloadManager_", ((StringBuilder)localObject3).toString());
      a(paramDownloadInfo, (String)localObject1, (String)localObject2);
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      LogUtility.a("DownloadManager_", "package invaild del file");
    }
    try
    {
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      label464:
      a(-2, paramDownloadInfo, -24, "");
      return;
    }
    catch (Exception localException)
    {
      break label464;
    }
  }
  
  public void d()
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
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReveiveInstallIntent info=");
    localStringBuilder.append(paramDownloadInfo);
    LogUtility.c("DownloadManager_", localStringBuilder.toString());
    if (paramDownloadInfo.jdField_c_of_type_Int == 0) {
      StaticAnalyz.a("310", paramDownloadInfo.jdField_h_of_type_JavaLangString, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.o);
    }
    if (!"5".equals(paramDownloadInfo.m)) {
      a(paramDownloadInfo.jdField_c_of_type_JavaLangString, false);
    }
    AppNotificationManager.a().a(paramDownloadInfo.jdField_g_of_type_JavaLangString);
  }
  
  public void e()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext()) {
        b((DownloadListener)localIterator.next());
      }
      ThreadManager.getSubThreadHandler().post(new DownloadManager.16(this));
    }
    catch (Exception localException)
    {
      LogUtility.a("DownloadManager_", "onDestroy>>>", localException);
    }
    try
    {
      jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager = null;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void e(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramDownloadInfo.jdField_c_of_type_JavaLangString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addDownloadInfo info.appId = ");
        localStringBuilder.append(paramDownloadInfo.jdField_c_of_type_JavaLangString);
        localStringBuilder.append(",info.packageName = ");
        localStringBuilder.append(paramDownloadInfo.jdField_e_of_type_JavaLangString);
        localStringBuilder.append(",info.filePath = ");
        localStringBuilder.append(paramDownloadInfo.l);
        LogUtility.c("DownloadManager_", localStringBuilder.toString());
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo);
        DownloadDBHelper.a().a(paramDownloadInfo);
      }
    }
    finally {}
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 200) {
      ThreadManager.getSubThreadHandler().postDelayed(new DownloadManager.18(this), 3000L);
    }
  }
  
  public void f(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    ApkWriteCodeListener localApkWriteCodeListener = this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener;
    if (localApkWriteCodeListener != null)
    {
      localApkWriteCodeListener.a(paramDownloadInfo.jdField_e_of_type_JavaLangString, paramDownloadInfo.jdField_b_of_type_Int, null);
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = null;
  }
  
  public void g(DownloadInfo paramDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("patchNewApkSuccess DownloadInfo|");
    localStringBuilder.append(paramDownloadInfo);
    LogUtility.c("DownloadManager_", localStringBuilder.toString());
    j(paramDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager
 * JD-Core Version:    0.7.0.1
 */