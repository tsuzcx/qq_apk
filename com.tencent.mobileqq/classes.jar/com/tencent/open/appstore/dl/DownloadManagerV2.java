package com.tencent.open.appstore.dl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.download.unite.core.DownloadManagerInterceptor;
import com.tencent.mobileqq.download.unite.core.UniteDownloadDbOperator;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appstore.db.DownloadInfoDB;
import com.tencent.open.appstore.notice.NoticeListener;
import com.tencent.open.appstore.notice.NoticeReceiver;
import com.tencent.open.appstore.receiver.InstallStateReceiver;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.ApkGetCodeListener;
import com.tencent.open.downloadnew.ApkWriteCodeListener;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.DownloaderGetCodeClient;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.WebViewDownloadListener;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.open.downloadnew.common.IntentFactory;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
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
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class DownloadManagerV2
  implements ITMAssistantDownloadClientListener
{
  private static volatile DownloadManagerV2 jdField_a_of_type_ComTencentOpenAppstoreDlDownloadManagerV2;
  private final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long = 0L;
  private NoticeReceiver jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeReceiver;
  private InstallStateReceiver jdField_a_of_type_ComTencentOpenAppstoreReceiverInstallStateReceiver;
  private ApkGetCodeListener jdField_a_of_type_ComTencentOpenDownloadnewApkGetCodeListener = new DownloadManagerV2.1(this);
  private ApkWriteCodeListener jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener;
  private DownloaderGetCodeClient jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient;
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentHashMap<String, DownloadInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentLinkedQueue<DownloadListener> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  
  private DownloadManagerV2()
  {
    LogUtility.b("DownloadManagerV2", "DownloadManagerV2 init");
    this.jdField_a_of_type_JavaLangString = "com.tencent.open.appstore.dl.DownloadManagerV2";
    Object localObject = new HashMap();
    ReplaceMonitor.get().init(CommonDataAdapter.a().a(), (Map)localObject);
    this.jdField_a_of_type_ComTencentOpenAppstoreReceiverInstallStateReceiver = new InstallStateReceiver();
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addDataScheme("package");
    ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_ADDED");
    ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_REMOVED");
    ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_REPLACED");
    this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeReceiver = new NoticeReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    String str = Common.r();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".");
    localStringBuilder.append(str.replace(":", "."));
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(str);
    localIntentFilter.addAction(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(str);
    localIntentFilter.addAction(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(str);
    localIntentFilter.addAction(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(str);
    localIntentFilter.addAction(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.e);
    localStringBuilder.append(str);
    localIntentFilter.addAction(localStringBuilder.toString());
    ThreadManager.excute(new DownloadManagerV2.2(this, (IntentFilter)localObject, localIntentFilter), 16, null, true);
    NoticeListener.a().a(ThreadManager.getSubThreadHandler().getLooper());
    a(NoticeListener.a());
    a(WebViewDownloadListener.a());
    ThreadManager.excute(new DownloadManagerV2.3(this), 32, null, true);
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient = DownloaderGetCodeClient.a();
  }
  
  private int a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return -30;
    }
    ApkWriteCodeListener localApkWriteCodeListener = this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener;
    if (localApkWriteCodeListener != null) {
      return localApkWriteCodeListener.a(paramDownloadInfo.e, paramDownloadInfo.jdField_b_of_type_Int, paramDownloadInfo.l, null);
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = null;
    return -40;
  }
  
  public static DownloadManagerV2 a()
  {
    if (jdField_a_of_type_ComTencentOpenAppstoreDlDownloadManagerV2 == null) {
      try
      {
        if (jdField_a_of_type_ComTencentOpenAppstoreDlDownloadManagerV2 == null)
        {
          jdField_a_of_type_ComTencentOpenAppstoreDlDownloadManagerV2 = new DownloadManagerV2();
          jdField_a_of_type_ComTencentOpenAppstoreDlDownloadManagerV2.c();
          jdField_a_of_type_ComTencentOpenAppstoreDlDownloadManagerV2.b();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentOpenAppstoreDlDownloadManagerV2;
  }
  
  private DownloadInfo a(String paramString, int paramInt)
  {
    paramString = b(paramString);
    if ((paramString != null) && (paramInt != -2)) {
      paramString.a(paramInt);
    }
    return paramString;
  }
  
  private DownloadInfo a(String paramString, long paramLong1, long paramLong2)
  {
    paramString = b(paramString);
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString != null)
    {
      paramString.a(2);
      paramString.jdField_f_of_type_Int = i;
      paramString.jdField_c_of_type_Long = paramLong2;
    }
    return paramString;
  }
  
  private TMAssistantDownloadClient a()
  {
    TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.jdField_a_of_type_JavaLangString).registerDownloadTaskListener(this);
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
        LogUtility.e("DownloadManagerV2", localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().a()).getDownloadSDKClient(this.jdField_a_of_type_JavaLangString);
    return this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  }
  
  private void a(int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2, String paramString)
  {
    if (paramDownloadInfo == null) {
      try
      {
        paramDownloadInfo = new StringBuilder();
        paramDownloadInfo.append("notifyListener info == null id=");
        paramDownloadInfo.append(paramInt1);
        LogUtility.e("DownloadManagerV2", paramDownloadInfo.toString());
        return;
      }
      finally
      {
        break label1048;
      }
    }
    int i = 0;
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
                    if (paramInt1 != 10) {
                      break label1058;
                    }
                    paramString = new StringBuilder();
                    paramString.append("[notifyListener] STATE_CANCEL:");
                    paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
                    LogUtility.b("DownloadManagerV2", paramString.toString());
                    m(paramDownloadInfo);
                    AppNotificationManager.a().a(paramDownloadInfo.g);
                    paramDownloadInfo.a(10);
                    paramString = new StringBuilder();
                    paramString.append("downloadInfo.state = ");
                    paramString.append(paramDownloadInfo.a());
                    LogUtility.b("DownloadManagerV2", paramString.toString());
                    paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
                    while (paramString.hasNext()) {
                      ((DownloadListener)paramString.next()).onDownloadCancel(paramDownloadInfo);
                    }
                    paramInt1 = i;
                    if (paramDownloadInfo.jdField_c_of_type_Int == 0)
                    {
                      AppCenterReporter.f(paramDownloadInfo);
                      paramInt1 = i;
                    }
                  }
                  else
                  {
                    paramString = new StringBuilder();
                    paramString.append("[notifyListener] PACKAGE_UNINSTALLED:");
                    paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
                    LogUtility.b("DownloadManagerV2", paramString.toString());
                    paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
                    while (paramString.hasNext()) {
                      ((DownloadListener)paramString.next()).uninstallSucceed(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e);
                    }
                  }
                }
                else
                {
                  paramString = new StringBuilder();
                  paramString.append("[notifyListener] STATE_COMPLETE:");
                  paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
                  LogUtility.b("DownloadManagerV2", paramString.toString());
                  paramDownloadInfo.jdField_f_of_type_Int = 100;
                  if (paramDownloadInfo.jdField_c_of_type_Int == 0) {
                    AppCenterReporter.e(paramDownloadInfo);
                  }
                  paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
                  while (paramString.hasNext()) {
                    ((DownloadListener)paramString.next()).onDownloadFinish(paramDownloadInfo);
                  }
                  DownloadInfoReport.a(12, null, 100, paramDownloadInfo);
                  break label1058;
                }
              }
              else
              {
                paramString = new StringBuilder();
                paramString.append("[notifyListener] STATE_PAUSE:");
                paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
                LogUtility.b("DownloadManagerV2", paramString.toString());
                paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
                while (paramString.hasNext()) {
                  ((DownloadListener)paramString.next()).onDownloadPause(paramDownloadInfo);
                }
              }
            }
            else if (paramDownloadInfo.jdField_c_of_type_Int != 1)
            {
              paramInt1 = i;
              if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L) {}
            }
            else
            {
              this.jdField_a_of_type_Long = System.currentTimeMillis();
              paramString = new StringBuilder();
              paramString.append("[notifyListener] STATE_DOWNLOADING:");
              paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
              LogUtility.b("DownloadManagerV2", paramString.toString());
              paramString = a(2);
              Object localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[notifyListener] STATE_DOWNLOADING: infos size= ");
              ((StringBuilder)localObject).append(paramString.size());
              LogUtility.a("DownloadManagerV2", ((StringBuilder)localObject).toString());
              localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
              while (((Iterator)localObject).hasNext())
              {
                DownloadListener localDownloadListener = (DownloadListener)((Iterator)localObject).next();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("[notifyListener] DownloadConstants.STATE_DOWNLOADING: listener name:");
                localStringBuilder.append(localDownloadListener.getClass().getName());
                LogUtility.a("DownloadManagerV2", localStringBuilder.toString());
                localDownloadListener.onDownloadUpdate(paramString);
              }
            }
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append("[notifyListener] STATE_WAIT:");
            paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
            LogUtility.b("DownloadManagerV2", paramString.toString());
            paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
            while (paramString.hasNext()) {
              ((DownloadListener)paramString.next()).onDownloadWait(paramDownloadInfo);
            }
          }
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append("[notifyListener] PACKAGE_REPLACED:");
          paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
          LogUtility.b("DownloadManagerV2", paramString.toString());
          paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
          while (paramString.hasNext()) {
            ((DownloadListener)paramString.next()).packageReplaced(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e);
          }
        }
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("[notifyListener] PACKAGE_INSTALLED:");
        paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        LogUtility.b("DownloadManagerV2", paramString.toString());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).installSucceed(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e);
        }
      }
    }
    else
    {
      a(paramDownloadInfo, paramInt2, paramString);
      break label1058;
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramString = new StringBuilder();
        paramString.append("[notifyListener] Need Save Info:");
        paramString.append(paramDownloadInfo);
        LogUtility.b("DownloadManagerV2", paramString.toString());
        c(paramDownloadInfo);
      }
      return;
      for (;;)
      {
        label1048:
        throw paramDownloadInfo;
      }
      label1058:
      paramInt1 = 1;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    LogUtility.b("DownloadManagerV2", "[writeApkCodeAsync] ");
    if (paramBundle == null)
    {
      LogUtility.b("DownloadManagerV2", "[writeApkCodeAsync] data is null......");
      return;
    }
    ThreadManager.excute(new DownloadManagerV2.22(this, paramBundle), 32, null, true);
  }
  
  private void a(DownloadInfo paramDownloadInfo, int paramInt, String paramString)
  {
    this.jdField_b_of_type_Boolean = false;
    if (paramDownloadInfo == null)
    {
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("[onDownloadError] info == null code = ");
      paramDownloadInfo.append(paramInt);
      paramDownloadInfo.append(" msg = ");
      paramDownloadInfo.append(paramString);
      LogUtility.b("DownloadManagerV2", paramDownloadInfo.toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onDownloadError] errorCode = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject).toString());
    int j = 3;
    int i;
    if (paramInt != -51)
    {
      i = j;
      localObject = paramString;
      if (paramInt == -40) {
        break label628;
      }
      i = j;
      localObject = paramString;
      if (paramInt == -30) {
        break label628;
      }
      if (paramInt != -24)
      {
        i = j;
        localObject = paramString;
        if (paramInt == -20) {
          break label628;
        }
        i = j;
        localObject = paramString;
        if (paramInt == -10) {
          break label628;
        }
        i = j;
        localObject = paramString;
      }
    }
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          }
          break;
        }
        break;
      }
    case 4: 
    case 3: 
    case 2: 
    case 1: 
    case -1: 
      try
      {
        localObject = CommonDataAdapter.a().a().getString(2131694616);
        i = j;
        break label628;
        localObject = CommonDataAdapter.a().a().getString(2131694623);
        i = j;
        break label628;
        localObject = CommonDataAdapter.a().a().getString(2131694628);
        i = j;
        break label628;
        localObject = CommonDataAdapter.a().a().getString(2131694625);
        i = j;
        break label628;
        if ((paramDownloadInfo.e != null) && ("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (paramDownloadInfo.jdField_a_of_type_Int != 1) && (a()))
        {
          j(paramDownloadInfo);
          return;
        }
        paramDownloadInfo.a(4);
        if (paramDownloadInfo.jdField_a_of_type_Int == 1)
        {
          l(paramDownloadInfo);
          return;
        }
        i(paramDownloadInfo);
        return;
        localObject = CommonDataAdapter.a().a().getString(2131694616);
        i = j;
        break label628;
        localObject = CommonDataAdapter.a().a().getString(2131694626);
        i = j;
        break label628;
        localObject = CommonDataAdapter.a().a().getString(2131694621);
        i = j;
        break label628;
        if (paramInt == 712) {
          localObject = CommonDataAdapter.a().a().getString(2131694618);
        } else {
          localObject = CommonDataAdapter.a().a().getString(2131694619);
        }
        i = 10;
        h(paramDownloadInfo);
        label628:
        paramDownloadInfo.a(i);
        paramString = new StringBuilder();
        paramString.append("[onDownloadError] ListenerSize:");
        paramString.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size());
        LogUtility.b("DownloadManagerV2", paramString.toString());
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).onDownloadError(paramDownloadInfo, paramInt, (String)localObject, i);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramInt != 6)) {
          b((String)localObject);
        }
        if (paramDownloadInfo.jdField_c_of_type_Int == 0)
        {
          AppCenterReporter.a(paramDownloadInfo, paramInt, (String)localObject);
          return;
        }
        LogUtility.e("DownloadManagerV2", "[onDownloadError] downloadType=DOWNLOAD_TYPE_MYAPP, shouldn't report!");
        return;
      }
      catch (Exception paramDownloadInfo)
      {
        label755:
        break label755;
      }
      paramDownloadInfo.printStackTrace();
      return;
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramDownloadInfo.a() != 4) && (paramDownloadInfo.jdField_d_of_type_Boolean))
    {
      LogUtility.b("DownloadManagerV2", "isAutoInstallBySDK is true");
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      if (new File(paramString1).exists())
      {
        if (paramBoolean)
        {
          paramDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
          a(paramDownloadInfo, true);
        }
        paramBoolean = AppUtil.a(CommonDataAdapter.a().a(), paramString1, paramDownloadInfo.m, paramDownloadInfo.a("big_brother_ref_source_key"), paramDownloadInfo.a("hideInstallSuccessPage"));
        AppCenterReporter.c(paramDownloadInfo);
      }
    }
    else
    {
      if (paramBoolean)
      {
        paramDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
        a(paramDownloadInfo, true);
      }
      paramBoolean = AppUtil.a(CommonDataAdapter.a().a(), paramString1, paramDownloadInfo.m, paramDownloadInfo.a("big_brother_ref_source_key"), paramDownloadInfo.a("hideInstallSuccessPage"));
      AppCenterReporter.c(paramDownloadInfo);
    }
    if ((paramBoolean) && ("com.tencent.android.qqdownloader".equals(paramString2)) && ("1101070898".equals(paramDownloadInfo.jdField_c_of_type_JavaLangString)))
    {
      LogUtility.a("DownloadManagerV2", "report yyb start install");
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
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      LogUtility.d("DownloadManagerV2", "appid is empty");
      return;
    }
    DownloadInfo localDownloadInfo = a(paramString);
    if (localDownloadInfo == null)
    {
      LogUtility.d("DownloadManagerV2", "clearDownloadInfo info == null");
      return;
    }
    paramString = new StringBuilder();
    paramString.append("clearDownloadInfo info =");
    paramString.append(localDownloadInfo.toString());
    LogUtility.a("DownloadManagerV2", paramString.toString());
    if (localDownloadInfo.jdField_c_of_type_Int == 0)
    {
      if (localDownloadInfo.jdField_a_of_type_Int == 1) {
        paramString = localDownloadInfo.jdField_i_of_type_JavaLangString;
      } else {
        paramString = localDownloadInfo.jdField_d_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(paramString)) {
        ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.15(this, paramBoolean, paramString));
      }
    }
    m(localDownloadInfo);
  }
  
  private static int b(int paramInt)
  {
    return DownloadManager.a(paramInt);
  }
  
  private int b(String paramString)
  {
    Object localObject = a(paramString);
    if (localObject != null)
    {
      if (((DownloadInfo)localObject).jdField_a_of_type_Int == 1) {
        localObject = ((DownloadInfo)localObject).jdField_i_of_type_JavaLangString;
      } else {
        localObject = ((DownloadInfo)localObject).jdField_d_of_type_JavaLangString;
      }
      ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.14(this, (String)localObject));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pause url=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", ticket=");
      localStringBuilder.append(paramString);
      LogUtility.a("DownloadManagerV2", localStringBuilder.toString());
    }
    return 0;
  }
  
  private DownloadInfo b(String paramString, int paramInt)
  {
    paramString = d(paramString);
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
  
  private void c()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadManagerV2.5(this), 1000L);
  }
  
  private boolean c(String paramString, boolean paramBoolean)
  {
    DownloadInfo localDownloadInfo = a(paramString);
    if (localDownloadInfo != null) {
      a(paramString, false);
    }
    if (localDownloadInfo != null) {
      if (paramBoolean) {
        a(10, localDownloadInfo);
      } else {
        try
        {
          AppNotificationManager.a().a(localDownloadInfo.g);
        }
        catch (Exception paramString)
        {
          LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", paramString);
        }
      }
    }
    return true;
  }
  
  private DownloadInfo d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (TextUtils.equals(localDownloadInfo.jdField_c_of_type_JavaLangString, paramString)) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  private boolean d(String paramString, boolean paramBoolean)
  {
    DownloadInfo localDownloadInfo = a(paramString);
    if (localDownloadInfo != null) {
      a(paramString, true);
    }
    if (localDownloadInfo != null)
    {
      if (paramBoolean)
      {
        a(10, localDownloadInfo);
        return true;
      }
      try
      {
        AppNotificationManager.a().a(localDownloadInfo.g);
        return true;
      }
      catch (Exception paramString)
      {
        LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", paramString);
      }
    }
    return true;
  }
  
  private void g(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.7(this, paramDownloadInfo));
  }
  
  private void h(DownloadInfo paramDownloadInfo)
  {
    Object localObject;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
    {
      localObject = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class);
      if ((localObject != null) && (UpgradeController.a().a() == 4)) {
        ((MqqHandler)localObject).obtainMessage(1134019).sendToTarget();
      }
    }
    if (paramDownloadInfo.jdField_a_of_type_Int == 1) {
      localObject = paramDownloadInfo.jdField_i_of_type_JavaLangString;
    } else {
      localObject = paramDownloadInfo.jdField_d_of_type_JavaLangString;
    }
    if (localObject != null) {
      ThreadManager.excute(new DownloadManagerV2.8(this, (String)localObject, paramDownloadInfo), 32, null, true);
    }
  }
  
  private void i(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.excute(new DownloadManagerV2.9(this, paramDownloadInfo), 32, null, true);
  }
  
  private void j(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.10(this, paramDownloadInfo));
  }
  
  private void k(DownloadInfo paramDownloadInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(">>startDownload downloadInfo:");
    ((StringBuilder)localObject1).append(paramDownloadInfo);
    LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject1).toString());
    localObject1 = a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = DownloadInfoDB.a().a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(">>startDownload get from DB:");
      ((StringBuilder)localObject1).append(localObject2);
      LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject1).toString());
    }
    localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((DownloadInfo)localObject2).a() == 4)
      {
        localObject1 = localObject2;
        if (!new File(((DownloadInfo)localObject2).l).exists())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[startDownload] info succeed, but file is deleted!info=");
          ((StringBuilder)localObject1).append(localObject2);
          LogUtility.e("DownloadManagerV2", ((StringBuilder)localObject1).toString());
          ((DownloadInfo)localObject2).b();
          localObject1 = null;
        }
      }
    }
    if (localObject1 != null)
    {
      ((DownloadInfo)localObject1).jdField_c_of_type_Int = 0;
      ((DownloadInfo)localObject1).jdField_h_of_type_JavaLangString = paramDownloadInfo.jdField_h_of_type_JavaLangString;
      ((DownloadInfo)localObject1).m = paramDownloadInfo.m;
      ((DownloadInfo)localObject1).jdField_a_of_type_Boolean = paramDownloadInfo.jdField_a_of_type_Boolean;
      ((DownloadInfo)localObject1).y = paramDownloadInfo.y;
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("startDownload() downloadInfo != null>>>downloadInfo.url=");
      paramDownloadInfo.append(((DownloadInfo)localObject1).jdField_d_of_type_JavaLangString);
      paramDownloadInfo.append("downloadInfo.isAutoInstall");
      paramDownloadInfo.append(((DownloadInfo)localObject1).jdField_a_of_type_Boolean);
      paramDownloadInfo.append("+++++downloadInfo.downloadType=");
      paramDownloadInfo.append(((DownloadInfo)localObject1).jdField_a_of_type_Int);
      paramDownloadInfo.append("  test");
      paramDownloadInfo.append(a(((DownloadInfo)localObject1).jdField_b_of_type_JavaLangString));
      LogUtility.a("DownloadManagerV2", paramDownloadInfo.toString());
      paramDownloadInfo = (DownloadInfo)localObject1;
    }
    else
    {
      AppCenterReporter.a(paramDownloadInfo);
    }
    paramDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(">>startDownload record download start process flag:");
    ((StringBuilder)localObject2).append(paramDownloadInfo.w);
    LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject2).toString());
    a(paramDownloadInfo, true);
    if (("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (a())) {
      n(paramDownloadInfo);
    }
    if (paramDownloadInfo.jdField_a_of_type_Int == 1) {
      localObject2 = paramDownloadInfo.jdField_i_of_type_JavaLangString;
    } else {
      localObject2 = paramDownloadInfo.jdField_d_of_type_JavaLangString;
    }
    int i = paramDownloadInfo.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    localHashMap.put(TMAssistantDownloadConst.PARAM_APPID, paramDownloadInfo.jdField_c_of_type_JavaLangString);
    localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, paramDownloadInfo.e);
    localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(paramDownloadInfo.jdField_b_of_type_Int));
    localHashMap.put(TMAssistantDownloadConst.PARAM_VIA, paramDownloadInfo.jdField_h_of_type_JavaLangString);
    localHashMap.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, "qqNumber");
    localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
    localHashMap.put(TMAssistantDownloadConst.PARAM_ICON_URL, paramDownloadInfo.n);
    localHashMap.put(TMAssistantDownloadConst.PARAM_APP_NAME, paramDownloadInfo.jdField_f_of_type_JavaLangString);
    localHashMap.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(paramDownloadInfo.jdField_i_of_type_Int));
    localHashMap.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(paramDownloadInfo.jdField_d_of_type_Boolean));
    localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(paramDownloadInfo.jdField_d_of_type_Long));
    localHashMap.put(TMAssistantDownloadConst.PARAM_QQ_SOURCE_ID, paramDownloadInfo.m);
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.13(this, (String)localObject2, localHashMap, i, paramDownloadInfo, (DownloadInfo)localObject1));
    try
    {
      DownloadInfoReport.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramDownloadInfo);
      return;
    }
    catch (Throwable paramDownloadInfo) {}
  }
  
  private void l(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.16(this, paramDownloadInfo));
  }
  
  private void m(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramDownloadInfo.jdField_b_of_type_JavaLangString);
      DownloadInfoDB.a().a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void n(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    ApkWriteCodeListener localApkWriteCodeListener = this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener;
    if (localApkWriteCodeListener != null)
    {
      localApkWriteCodeListener.a(paramDownloadInfo.e, paramDownloadInfo.jdField_b_of_type_Int, null);
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkWriteCodeListener = null;
  }
  
  private void o(DownloadInfo paramDownloadInfo)
  {
    LogUtility.b("DownloadManagerV2", "[getApkCodeAsync]");
    if (paramDownloadInfo == null)
    {
      LogUtility.b("DownloadManagerV2", "[getApkCodeAsync] info is null......");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.21(this, paramDownloadInfo));
  }
  
  public int a(String paramString)
  {
    return b(DownloadInfo.b(paramString));
  }
  
  public DownloadInfo a(String paramString)
  {
    if (paramString == null)
    {
      LogUtility.a("DownloadManagerV2", "getDownloadInfoByTicket ticket == null");
      return null;
    }
    DownloadInfo localDownloadInfo = (DownloadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localDownloadInfo == null) {
      ThreadManager.excute(new DownloadManagerV2.11(this, paramString), 16, null, true);
    }
    return localDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(DownloadInfo paramDownloadInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, paramDownloadInfo.jdField_c_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_j_of_type_JavaLangString);
    localBundle.putString(DownloadConstants.jdField_d_of_type_JavaLangString, paramDownloadInfo.k);
    localBundle.putString(DownloadConstants.jdField_f_of_type_JavaLangString, paramDownloadInfo.e);
    localBundle.putInt(DownloadConstants.e, paramDownloadInfo.jdField_b_of_type_Int);
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
      localStringBuilder2.append(paramDownloadInfo.e);
      localObject = localStringBuilder1;
      localStringBuilder2.append(" version=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.jdField_b_of_type_Int);
      localObject = localStringBuilder1;
      localStringBuilder2.append(" via=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.jdField_h_of_type_JavaLangString);
      localObject = localStringBuilder1;
      LogUtility.a("DownloadManagerV2", localStringBuilder2.toString());
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
        LogUtility.a("DownloadManagerV2", localStringBuilder1.toString());
        return paramDownloadInfo;
      }
      localObject = paramDownloadInfo;
      LogUtility.a("DownloadManagerV2", "OpenSDK getTaskInfoFromMyApp result taskInfo is null");
      return paramDownloadInfo;
    }
    catch (Exception paramDownloadInfo)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getTaskInfoFromMyApp>>>");
      localStringBuilder1.append(paramDownloadInfo.getMessage());
      LogUtility.b("DownloadManagerV2", localStringBuilder1.toString());
    }
    return localObject;
  }
  
  public TMAssistantDownloadTaskInfo a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = null;
    if (!bool)
    {
      localObject1 = localTMAssistantDownloadTaskInfo;
      try
      {
        long l1 = System.currentTimeMillis();
        localObject1 = localTMAssistantDownloadTaskInfo;
        Object localObject2 = a();
        localObject1 = localTMAssistantDownloadTaskInfo;
        long l2 = System.currentTimeMillis();
        localObject1 = localTMAssistantDownloadTaskInfo;
        localTMAssistantDownloadTaskInfo = ((TMAssistantDownloadClient)localObject2).getDownloadTaskState(paramString);
        localObject1 = localTMAssistantDownloadTaskInfo;
        long l3 = System.currentTimeMillis();
        localObject1 = localTMAssistantDownloadTaskInfo;
        localObject2 = new StringBuilder();
        localObject1 = localTMAssistantDownloadTaskInfo;
        ((StringBuilder)localObject2).append("step1=");
        localObject1 = localTMAssistantDownloadTaskInfo;
        ((StringBuilder)localObject2).append(l2 - l1);
        localObject1 = localTMAssistantDownloadTaskInfo;
        ((StringBuilder)localObject2).append(",step2=");
        localObject1 = localTMAssistantDownloadTaskInfo;
        ((StringBuilder)localObject2).append(l3 - l2);
        localObject1 = localTMAssistantDownloadTaskInfo;
        LogUtility.e("NEW_QAPP_TIME_COST", ((StringBuilder)localObject2).toString());
        localObject1 = localTMAssistantDownloadTaskInfo;
      }
      catch (Exception localException)
      {
        LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
      }
    }
    if (localObject1 == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTaskInfoFromSDK null url=");
      localStringBuilder.append(paramString);
      LogUtility.a("DownloadManagerV2", localStringBuilder.toString());
    }
    return localObject1;
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
          LogUtility.c("DownloadManagerV2", "getQQAppInterface>>>", localException);
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
  
  public List<DownloadInfo> a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((paramString.equals(localDownloadInfo.e)) && (localDownloadInfo.a() == paramInt)) {
        localArrayList.add(localDownloadInfo);
      }
    }
    return localArrayList;
  }
  
  public ConcurrentHashMap<String, DownloadInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.4(this));
  }
  
  public void a(int paramInt, DownloadInfo paramDownloadInfo)
  {
    a(paramInt, paramDownloadInfo, 0, "");
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadManagerV2.19(this, paramBundle, paramActivity, paramString, paramApkUpdateDetail, paramInt));
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
    if (paramDownloadInfo == null) {}
    try
    {
      LogUtility.b("DownloadManagerV2", "[onDownloadComplete] info == null ");
      return;
    }
    finally {}
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (((localAppRuntime instanceof QQAppInterface)) && ("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (ConfigHandler.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      paramDownloadInfo.jdField_a_of_type_Boolean = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onDownloadComplete] complete, info = ");
    localStringBuilder.append(paramDownloadInfo.toString());
    LogUtility.b("DownloadManagerV2", localStringBuilder.toString());
    if (paramDownloadInfo.jdField_c_of_type_Int == 0)
    {
      if (paramDownloadInfo.jdField_a_of_type_Int == 1) {
        l(paramDownloadInfo);
      } else {
        g(paramDownloadInfo);
      }
    }
    else {
      ThreadManager.excute(new DownloadManagerV2.6(this, paramDownloadInfo), 32, null, true);
    }
    UniteDownloadDbOperator.a().a(localAppRuntime.getAccount(), paramDownloadInfo);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReveiveInstallIntent info=");
    localStringBuilder.append(paramDownloadInfo);
    LogUtility.b("DownloadManagerV2", localStringBuilder.toString());
    if (paramDownloadInfo.jdField_c_of_type_Int == 0) {
      AppCenterReporter.a(paramDownloadInfo, paramInt);
    }
    if (!"5".equals(paramDownloadInfo.m)) {
      a(paramDownloadInfo.jdField_b_of_type_JavaLangString, false);
    }
    AppNotificationManager.a().a(paramDownloadInfo.g);
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
        ((StringBuilder)localObject).append(paramDownloadInfo.e);
        ((StringBuilder)localObject).append(",info.urlStr = ");
        ((StringBuilder)localObject).append(paramDownloadInfo.jdField_d_of_type_JavaLangString);
        ((StringBuilder)localObject).append(",info.filePath = ");
        ((StringBuilder)localObject).append(paramDownloadInfo.l);
        LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject).toString());
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
  
  public void a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    if (paramDownloadInfo != null) {
      try
      {
        paramDownloadInfo.a();
        boolean bool = TextUtils.isEmpty(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        if (bool) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addDownloadInfo info.appId = ");
        localStringBuilder.append(paramDownloadInfo.jdField_c_of_type_JavaLangString);
        localStringBuilder.append(",info.packageName = ");
        localStringBuilder.append(paramDownloadInfo.e);
        localStringBuilder.append(",info.filePath = ");
        localStringBuilder.append(paramDownloadInfo.l);
        LogUtility.b("DownloadManagerV2", localStringBuilder.toString());
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramDownloadInfo.jdField_b_of_type_JavaLangString, paramDownloadInfo);
        ThreadManager.excute(new DownloadManagerV2.17(this, paramDownloadInfo, paramBoolean), 32, null, true);
      }
      finally {}
    }
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
  
  public void a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt)
  {
    DownloadInfo localDownloadInfo2 = d(paramTMAssistantCallYYBParamStruct.SNGAppId);
    DownloadInfo localDownloadInfo1 = localDownloadInfo2;
    if (localDownloadInfo2 == null)
    {
      localDownloadInfo1 = MyAppApi.a().a(paramTMAssistantCallYYBParamStruct, null);
      c(localDownloadInfo1);
    }
    localDownloadInfo1.jdField_f_of_type_Int = paramInt;
    localDownloadInfo1.a(2);
    a(2, localDownloadInfo1);
  }
  
  public void a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, TMAssistantCallYYBTaskInfo paramTMAssistantCallYYBTaskInfo, int paramInt2, String paramString)
  {
    int i = b(paramInt1);
    DownloadInfo localDownloadInfo = b(paramTMAssistantCallYYBParamStruct.SNGAppId, i);
    if ((localDownloadInfo == null) && (paramInt1 != 6))
    {
      paramTMAssistantCallYYBTaskInfo = MyAppApi.a().a(paramTMAssistantCallYYBParamStruct, null);
      c(paramTMAssistantCallYYBTaskInfo);
      b(paramTMAssistantCallYYBParamStruct.SNGAppId, i);
      paramTMAssistantCallYYBParamStruct = paramTMAssistantCallYYBTaskInfo;
    }
    else if (paramInt1 != 2)
    {
      paramTMAssistantCallYYBParamStruct = localDownloadInfo;
      if (paramInt1 != 3) {}
    }
    else
    {
      paramTMAssistantCallYYBParamStruct = localDownloadInfo;
      if (MyAppApi.a().e())
      {
        paramTMAssistantCallYYBParamStruct = localDownloadInfo;
        if (paramTMAssistantCallYYBTaskInfo != null) {
          try
          {
            long l1 = paramTMAssistantCallYYBTaskInfo.mReceiveDataLen;
            long l2 = paramTMAssistantCallYYBTaskInfo.mTotalDataLen;
            paramInt1 = (int)((float)l1 * 100.0F / (float)l2);
            localDownloadInfo.jdField_f_of_type_Int = paramInt1;
            paramTMAssistantCallYYBParamStruct = new StringBuilder();
            paramTMAssistantCallYYBParamStruct.append("onYYBDownloadTaskStateChanged info progress = ");
            paramTMAssistantCallYYBParamStruct.append(paramInt1);
            LogUtility.b("DownloadManagerV2", paramTMAssistantCallYYBParamStruct.toString());
            paramTMAssistantCallYYBParamStruct = localDownloadInfo;
          }
          catch (Exception paramTMAssistantCallYYBParamStruct)
          {
            LogUtility.c("DownloadManagerV2", "onYYBDownloadTaskStateChanged>>>", paramTMAssistantCallYYBParamStruct);
            paramTMAssistantCallYYBParamStruct = localDownloadInfo;
          }
        }
      }
    }
    if (paramTMAssistantCallYYBParamStruct != null)
    {
      paramTMAssistantCallYYBTaskInfo = new StringBuilder();
      paramTMAssistantCallYYBTaskInfo.append("onYYBDownloadTaskStateChanged notifyListener localState=");
      paramTMAssistantCallYYBTaskInfo.append(i);
      paramTMAssistantCallYYBTaskInfo.append(" dlInfo=");
      paramTMAssistantCallYYBTaskInfo.append(paramTMAssistantCallYYBParamStruct.toString());
      LogUtility.b("DownloadManagerV2", paramTMAssistantCallYYBTaskInfo.toString());
      a(i, paramTMAssistantCallYYBParamStruct, paramInt2, paramString);
      return;
    }
    LogUtility.b("DownloadManagerV2", "onYYBDownloadTaskStateChanged notifyListener error dlInfo == null");
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      AppNotificationManager.a().a(paramString);
    }
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
      if ((localDownloadInfo != null) && (localDownloadInfo.a() != 4) && (localDownloadInfo.a() != 1) && (localDownloadInfo.jdField_c_of_type_Int == 1))
      {
        localArrayList.add(localDownloadInfo);
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (!AppUtil.a(localDownloadInfo.e)) {
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
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131703664));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131703675));
      localObject1 = ((StringBuilder)localObject3).toString();
      if (bool)
      {
        ToastUtil.a().a((String)localObject1, 1);
        return;
      }
      MyAppApi.a().a(true, (String)localObject1);
    }
  }
  
  public boolean a()
  {
    return BaseApplicationImpl.sProcessId == 1;
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
    return a(paramDownloadInfo, true);
  }
  
  public boolean a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    if (paramDownloadInfo == null)
    {
      LogUtility.a("DownloadManagerV2", "installDownload info == null");
      return false;
    }
    if (!paramDownloadInfo.jdField_c_of_type_Boolean)
    {
      LogUtility.a("DownloadManagerV2", "installDownload info is not apk");
      return false;
    }
    Object localObject1;
    if (TextUtils.isEmpty(paramDownloadInfo.l))
    {
      int i = paramDownloadInfo.jdField_c_of_type_Int;
      localObject2 = null;
      if (i == 0)
      {
        localObject1 = a(paramDownloadInfo.jdField_d_of_type_JavaLangString);
        if ((localObject1 != null) && (((TMAssistantDownloadTaskInfo)localObject1).mState == 4)) {
          localObject3 = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        } else {
          localObject3 = "";
        }
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = a(paramDownloadInfo);
          localObject1 = localObject3;
          localObject2 = localTMAssistantDownloadTaskInfo;
          if (localTMAssistantDownloadTaskInfo != null)
          {
            paramDownloadInfo.jdField_c_of_type_Int = 1;
            localObject1 = localObject3;
            localObject2 = localTMAssistantDownloadTaskInfo;
          }
        }
      }
      else
      {
        localObject1 = a(paramDownloadInfo);
        if ((localObject1 != null) && (((TMAssistantDownloadTaskInfo)localObject1).mState == 4)) {
          localObject3 = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        } else {
          localObject3 = "";
        }
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = a(paramDownloadInfo.jdField_d_of_type_JavaLangString);
          localObject1 = localObject3;
        }
      }
      localObject3 = localObject1;
      if (localObject2 != null)
      {
        localObject3 = localObject1;
        if (((TMAssistantDownloadTaskInfo)localObject2).mState == 4) {
          localObject3 = ((TMAssistantDownloadTaskInfo)localObject2).mSavePath;
        }
      }
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        paramDownloadInfo.l = ((String)localObject3);
        paramDownloadInfo.a(4);
        c(paramDownloadInfo);
        localObject1 = localObject3;
      }
    }
    else
    {
      localObject1 = paramDownloadInfo.l;
    }
    if (!new File((String)localObject1).canRead())
    {
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("can't read apk file. installDownload localAPKPath=");
      paramDownloadInfo.append((String)localObject1);
      LogUtility.b("DownloadManagerV2", paramDownloadInfo.toString());
      return false;
    }
    Object localObject2 = AppUtil.a((String)localObject1);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("installDownload localAPKPath=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", apkPackageName=");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(" updateType=");
    ((StringBuilder)localObject3).append(paramDownloadInfo.jdField_a_of_type_Int);
    LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject3).toString());
    if (localObject2 != null)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[installDownload] begin sendCheckDownloadReq pkgname=");
      ((StringBuilder)localObject3).append((String)localObject2);
      LogUtility.c("DownloadManagerV2", ((StringBuilder)localObject3).toString());
      a(paramDownloadInfo, (String)localObject1, (String)localObject2, paramBoolean);
      return true;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      LogUtility.a("DownloadManagerV2", "package invaild del file");
    }
    try
    {
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      label494:
      a(-2, paramDownloadInfo, -24, "");
      return false;
    }
    catch (Exception localException)
    {
      break label494;
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return c(DownloadInfo.b(paramString), paramBoolean);
  }
  
  public DownloadInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      LogUtility.a("DownloadManagerV2", "getDownloadInfoByTicket ticket == null");
      return null;
    }
    return a(DownloadInfo.b(paramString));
  }
  
  public List<DownloadInfo> b(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = DownloadInfoDB.a().a(paramString).iterator();
    while (paramString.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramString.next();
      if (localDownloadInfo.a() == paramInt) {
        localArrayList.add(localDownloadInfo);
      }
    }
    return localArrayList;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 200) {
      ThreadManager.getSubThreadHandler().postDelayed(new DownloadManagerV2.20(this), 3000L);
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    try
    {
      DownloadManagerV2.12 local12 = new DownloadManagerV2.12(this, paramDownloadInfo);
      DownloadManagerInterceptor.a().a(paramDownloadInfo, local12);
      return;
    }
    finally
    {
      paramDownloadInfo = finally;
      throw paramDownloadInfo;
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
      LogUtility.c("DownloadManagerV2", "showToast>>>", paramString);
    }
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
  
  public boolean b(DownloadInfo paramDownloadInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("refreshDownloadInfo DownloadInfo=");
    ((StringBuilder)localObject1).append(paramDownloadInfo);
    LogUtility.a("DownloadManagerV2", ((StringBuilder)localObject1).toString());
    Object localObject2 = a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = c(paramDownloadInfo.e);
    }
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshDownloadInfo cacheInfo =");
      ((StringBuilder)localObject2).append(localObject1);
      LogUtility.a("DownloadManagerV2", ((StringBuilder)localObject2).toString());
      if (((DownloadInfo)localObject1).jdField_c_of_type_Int == 0)
      {
        LogUtility.a("DownloadManagerV2", "refreshDownloadInfo DownloadInfo.DOWNLOAD_TYPE_DOWNLOADSDK......");
        paramDownloadInfo.jdField_h_of_type_Int = ((DownloadInfo)localObject1).jdField_h_of_type_Int;
        if (((DownloadInfo)localObject1).jdField_a_of_type_Int == 1) {
          localObject2 = ((DownloadInfo)localObject1).jdField_i_of_type_JavaLangString;
        } else {
          localObject2 = ((DownloadInfo)localObject1).jdField_d_of_type_JavaLangString;
        }
        localObject2 = a().a((String)localObject2);
        if (localObject2 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshDownloadInfo sdk getReceiveDataLen=");
          localStringBuilder.append(((TMAssistantDownloadTaskInfo)localObject2).mReceiveDataLen);
          localStringBuilder.append(" getTotalDataLen=");
          localStringBuilder.append(((TMAssistantDownloadTaskInfo)localObject2).mTotalDataLen);
          LogUtility.a("DownloadManagerV2", localStringBuilder.toString());
          paramDownloadInfo.jdField_f_of_type_Int = ((int)((float)((TMAssistantDownloadTaskInfo)localObject2).mReceiveDataLen * 100.0F / (float)((TMAssistantDownloadTaskInfo)localObject2).mTotalDataLen));
          paramDownloadInfo.a(b(((TMAssistantDownloadTaskInfo)localObject2).mState));
          paramDownloadInfo.jdField_c_of_type_Int = 0;
          if (((DownloadInfo)localObject1).jdField_a_of_type_Int == 1)
          {
            if (TextUtils.isEmpty(((DownloadInfo)localObject1).l)) {
              paramDownloadInfo.l = ((TMAssistantDownloadTaskInfo)localObject2).mSavePath;
            } else {
              paramDownloadInfo.l = ((DownloadInfo)localObject1).l;
            }
          }
          else {
            paramDownloadInfo.l = ((TMAssistantDownloadTaskInfo)localObject2).mSavePath;
          }
          if (paramDownloadInfo.a() == 4)
          {
            paramDownloadInfo.jdField_j_of_type_Int = ((DownloadInfo)localObject1).jdField_j_of_type_Int;
            if (paramDownloadInfo.jdField_j_of_type_Int != 0)
            {
              paramDownloadInfo.a(3);
              c((DownloadInfo)localObject1);
            }
          }
          return true;
        }
        m((DownloadInfo)localObject1);
        paramDownloadInfo.a(-100);
        return true;
      }
      if (((DownloadInfo)localObject1).jdField_c_of_type_Int == 1)
      {
        localObject2 = a((DownloadInfo)localObject1);
        if (localObject2 != null)
        {
          int j = b(((TMAssistantDownloadTaskInfo)localObject2).mState);
          int i = j;
          if (j == -2) {
            i = 3;
          }
          paramDownloadInfo.a(i);
          paramDownloadInfo.jdField_c_of_type_Int = 1;
          paramDownloadInfo.l = ((TMAssistantDownloadTaskInfo)localObject2).mSavePath;
          long l1 = ((TMAssistantDownloadTaskInfo)localObject2).mReceiveDataLen;
          long l2 = ((TMAssistantDownloadTaskInfo)localObject2).mTotalDataLen;
          paramDownloadInfo.jdField_f_of_type_Int = ((int)((float)l1 * 100.0F / (float)l2));
          if (!MyAppApi.a().e()) {
            paramDownloadInfo.jdField_f_of_type_Int = 0;
          }
          return true;
        }
        m((DownloadInfo)localObject1);
      }
    }
    return false;
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return d(DownloadInfo.b(paramString), paramBoolean);
  }
  
  public DownloadInfo c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (paramString.equals(localDownloadInfo.e)) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    a(paramDownloadInfo, false);
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a().a(9, paramDownloadInfo);
    }
  }
  
  public void e(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      a(paramDownloadInfo, 2);
      a().a(13, paramDownloadInfo);
    }
  }
  
  public void f(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      a(paramDownloadInfo, 1);
      a().a(6, paramDownloadInfo);
    }
  }
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.24(this, paramString, paramLong1, paramLong2));
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.23(this, paramTMAssistantDownloadClient, paramInt1, paramString1, paramInt2, paramString2));
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient)
  {
    LogUtility.e("DownloadManagerV2", "OnDwonloadSDKServiceInvalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2
 * JD-Core Version:    0.7.0.1
 */