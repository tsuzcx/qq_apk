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
  private static volatile DownloadManagerV2 p;
  private TMAssistantDownloadClient a;
  private DownloaderGetCodeClient b;
  private String c;
  private WeakReference<AppInterface> d;
  private boolean e = false;
  private ApkWriteCodeListener f;
  private boolean g = false;
  private ConcurrentHashMap<String, DownloadInfo> h = new ConcurrentHashMap();
  private ConcurrentLinkedQueue<DownloadListener> i = new ConcurrentLinkedQueue();
  private InstallStateReceiver j;
  private NoticeReceiver k;
  private ApkGetCodeListener l = new DownloadManagerV2.1(this);
  private long m = 0L;
  private long n = 0L;
  private final int o = 1000;
  
  private DownloadManagerV2()
  {
    LogUtility.b("DownloadManagerV2", "DownloadManagerV2 init");
    this.c = "com.tencent.open.appstore.dl.DownloadManagerV2";
    Object localObject = new HashMap();
    ReplaceMonitor.get().init(CommonDataAdapter.a().b(), (Map)localObject);
    this.j = new InstallStateReceiver();
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addDataScheme("package");
    ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_ADDED");
    ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_REMOVED");
    ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_REPLACED");
    this.k = new NoticeReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    String str = Common.x();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".");
    localStringBuilder.append(str.replace(":", "."));
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.a);
    localStringBuilder.append(str);
    localIntentFilter.addAction(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.b);
    localStringBuilder.append(str);
    localIntentFilter.addAction(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.c);
    localStringBuilder.append(str);
    localIntentFilter.addAction(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(IntentFactory.d);
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
    this.b = DownloaderGetCodeClient.a();
  }
  
  public static DownloadManagerV2 a()
  {
    if (p == null) {
      try
      {
        if (p == null)
        {
          p = new DownloadManagerV2();
          p.g();
          p.e();
        }
      }
      finally {}
    }
    return p;
  }
  
  private DownloadInfo a(String paramString, long paramLong1, long paramLong2)
  {
    paramString = b(paramString);
    int i1 = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString != null)
    {
      paramString.a(2);
      paramString.t = i1;
      paramString.E = paramLong2;
    }
    return paramString;
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
    int i1 = 0;
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
                    paramString.append(this.i.size());
                    LogUtility.b("DownloadManagerV2", paramString.toString());
                    p(paramDownloadInfo);
                    AppNotificationManager.a().a(paramDownloadInfo.g);
                    paramDownloadInfo.a(10);
                    paramString = new StringBuilder();
                    paramString.append("downloadInfo.state = ");
                    paramString.append(paramDownloadInfo.a());
                    LogUtility.b("DownloadManagerV2", paramString.toString());
                    paramString = this.i.iterator();
                    while (paramString.hasNext()) {
                      ((DownloadListener)paramString.next()).onDownloadCancel(paramDownloadInfo);
                    }
                    paramInt1 = i1;
                    if (paramDownloadInfo.o == 0)
                    {
                      AppCenterReporter.f(paramDownloadInfo);
                      paramInt1 = i1;
                    }
                  }
                  else
                  {
                    paramString = new StringBuilder();
                    paramString.append("[notifyListener] PACKAGE_UNINSTALLED:");
                    paramString.append(this.i.size());
                    LogUtility.b("DownloadManagerV2", paramString.toString());
                    paramString = this.i.iterator();
                    while (paramString.hasNext()) {
                      ((DownloadListener)paramString.next()).uninstallSucceed(paramDownloadInfo.c, paramDownloadInfo.e);
                    }
                  }
                }
                else
                {
                  paramString = new StringBuilder();
                  paramString.append("[notifyListener] STATE_COMPLETE:");
                  paramString.append(this.i.size());
                  LogUtility.b("DownloadManagerV2", paramString.toString());
                  paramDownloadInfo.t = 100;
                  if (paramDownloadInfo.o == 0) {
                    AppCenterReporter.e(paramDownloadInfo);
                  }
                  paramString = this.i.iterator();
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
                paramString.append(this.i.size());
                LogUtility.b("DownloadManagerV2", paramString.toString());
                paramString = this.i.iterator();
                while (paramString.hasNext()) {
                  ((DownloadListener)paramString.next()).onDownloadPause(paramDownloadInfo);
                }
              }
            }
            else if (paramDownloadInfo.o != 1)
            {
              paramInt1 = i1;
              if (System.currentTimeMillis() - this.m <= 1000L) {}
            }
            else
            {
              this.m = System.currentTimeMillis();
              paramString = new StringBuilder();
              paramString.append("[notifyListener] STATE_DOWNLOADING:");
              paramString.append(this.i.size());
              LogUtility.b("DownloadManagerV2", paramString.toString());
              paramString = a(2);
              Object localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[notifyListener] STATE_DOWNLOADING: infos size= ");
              ((StringBuilder)localObject).append(paramString.size());
              LogUtility.a("DownloadManagerV2", ((StringBuilder)localObject).toString());
              localObject = this.i.iterator();
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
            paramString.append(this.i.size());
            LogUtility.b("DownloadManagerV2", paramString.toString());
            paramString = this.i.iterator();
            while (paramString.hasNext()) {
              ((DownloadListener)paramString.next()).onDownloadWait(paramDownloadInfo);
            }
          }
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append("[notifyListener] PACKAGE_REPLACED:");
          paramString.append(this.i.size());
          LogUtility.b("DownloadManagerV2", paramString.toString());
          paramString = this.i.iterator();
          while (paramString.hasNext()) {
            ((DownloadListener)paramString.next()).packageReplaced(paramDownloadInfo.c, paramDownloadInfo.e);
          }
        }
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("[notifyListener] PACKAGE_INSTALLED:");
        paramString.append(this.i.size());
        LogUtility.b("DownloadManagerV2", paramString.toString());
        paramString = this.i.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).installSucceed(paramDownloadInfo.c, paramDownloadInfo.e);
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
        e(paramDownloadInfo);
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
    this.g = false;
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
    int i2 = 3;
    int i1;
    if (paramInt != -51)
    {
      i1 = i2;
      localObject = paramString;
      if (paramInt == -40) {
        break label628;
      }
      i1 = i2;
      localObject = paramString;
      if (paramInt == -30) {
        break label628;
      }
      if (paramInt != -24)
      {
        i1 = i2;
        localObject = paramString;
        if (paramInt == -20) {
          break label628;
        }
        i1 = i2;
        localObject = paramString;
        if (paramInt == -10) {
          break label628;
        }
        i1 = i2;
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
        localObject = CommonDataAdapter.a().b().getString(2131892300);
        i1 = i2;
        break label628;
        localObject = CommonDataAdapter.a().b().getString(2131892307);
        i1 = i2;
        break label628;
        localObject = CommonDataAdapter.a().b().getString(2131892312);
        i1 = i2;
        break label628;
        localObject = CommonDataAdapter.a().b().getString(2131892309);
        i1 = i2;
        break label628;
        if ((paramDownloadInfo.e != null) && ("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (paramDownloadInfo.j != 1) && (f()))
        {
          m(paramDownloadInfo);
          return;
        }
        paramDownloadInfo.a(4);
        if (paramDownloadInfo.j == 1)
        {
          o(paramDownloadInfo);
          return;
        }
        l(paramDownloadInfo);
        return;
        localObject = CommonDataAdapter.a().b().getString(2131892300);
        i1 = i2;
        break label628;
        localObject = CommonDataAdapter.a().b().getString(2131892310);
        i1 = i2;
        break label628;
        localObject = CommonDataAdapter.a().b().getString(2131892305);
        i1 = i2;
        break label628;
        if (paramInt == 712) {
          localObject = CommonDataAdapter.a().b().getString(2131892302);
        } else {
          localObject = CommonDataAdapter.a().b().getString(2131892303);
        }
        i1 = 10;
        k(paramDownloadInfo);
        label628:
        paramDownloadInfo.a(i1);
        paramString = new StringBuilder();
        paramString.append("[onDownloadError] ListenerSize:");
        paramString.append(this.i.size());
        LogUtility.b("DownloadManagerV2", paramString.toString());
        paramString = this.i.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).onDownloadError(paramDownloadInfo, paramInt, (String)localObject, i1);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramInt != 6)) {
          h((String)localObject);
        }
        if (paramDownloadInfo.o == 0)
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
    if ((paramDownloadInfo.a() != 4) && (paramDownloadInfo.G))
    {
      LogUtility.b("DownloadManagerV2", "isAutoInstallBySDK is true");
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      if (new File(paramString1).exists())
      {
        if (paramBoolean)
        {
          paramDownloadInfo.R = BaseApplicationImpl.getApplication().getQQProcessName();
          b(paramDownloadInfo, true);
        }
        paramBoolean = AppUtil.a(CommonDataAdapter.a().b(), paramString1, paramDownloadInfo.r, paramDownloadInfo.a("big_brother_ref_source_key"), paramDownloadInfo.a("hideInstallSuccessPage"));
        AppCenterReporter.c(paramDownloadInfo);
      }
    }
    else
    {
      if (paramBoolean)
      {
        paramDownloadInfo.R = BaseApplicationImpl.getApplication().getQQProcessName();
        b(paramDownloadInfo, true);
      }
      paramBoolean = AppUtil.a(CommonDataAdapter.a().b(), paramString1, paramDownloadInfo.r, paramDownloadInfo.a("big_brother_ref_source_key"), paramDownloadInfo.a("hideInstallSuccessPage"));
      AppCenterReporter.c(paramDownloadInfo);
    }
    if ((paramBoolean) && ("com.tencent.android.qqdownloader".equals(paramString2)) && ("1101070898".equals(paramDownloadInfo.c)))
    {
      LogUtility.a("DownloadManagerV2", "report yyb start install");
      String str = StaticAnalyz.a(paramDownloadInfo.h, "NEWYYB");
      MyAppApi.l().c();
      paramString2 = MyAppApi.l().t();
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = paramDownloadInfo.c;
      }
      StaticAnalyz.a("311", str, paramString1, paramDownloadInfo.F);
      paramDownloadInfo = CommonDataAdapter.a().b();
      if (paramDownloadInfo != null) {
        StaticAnalyz.a(paramDownloadInfo, "312", str, paramString1);
      }
    }
  }
  
  private static int c(int paramInt)
  {
    return DownloadManager.b(paramInt);
  }
  
  private DownloadInfo c(String paramString, int paramInt)
  {
    paramString = b(paramString);
    if ((paramString != null) && (paramInt != -2)) {
      paramString.a(paramInt);
    }
    return paramString;
  }
  
  private boolean c(String paramString, boolean paramBoolean)
  {
    DownloadInfo localDownloadInfo = a(paramString);
    if (localDownloadInfo != null) {
      e(paramString, false);
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
  
  private DownloadInfo d(String paramString, int paramInt)
  {
    paramString = i(paramString);
    if (paramString != null)
    {
      int i1 = paramInt;
      if (paramInt == -2) {
        i1 = 3;
      }
      paramString.a(i1);
    }
    return paramString;
  }
  
  private boolean d(String paramString, boolean paramBoolean)
  {
    DownloadInfo localDownloadInfo = a(paramString);
    if (localDownloadInfo != null) {
      e(paramString, true);
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
  
  private void e(String paramString, boolean paramBoolean)
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
    if (localDownloadInfo.o == 0)
    {
      if (localDownloadInfo.j == 1) {
        paramString = localDownloadInfo.k;
      } else {
        paramString = localDownloadInfo.d;
      }
      if (!TextUtils.isEmpty(paramString)) {
        ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.15(this, paramBoolean, paramString));
      }
    }
    p(localDownloadInfo);
  }
  
  private void g()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadManagerV2.5(this), 1000L);
  }
  
  private TMAssistantDownloadClient h()
  {
    TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().b()).getDownloadSDKClient(this.c).registerDownloadTaskListener(this);
    if (!this.g) {
      try
      {
        TMAssistantDownloadSettingClient localTMAssistantDownloadSettingClient = TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().b()).getDownloadSDKSettingClient();
        if (localTMAssistantDownloadSettingClient != null)
        {
          localTMAssistantDownloadSettingClient.setDownloadSDKMaxTaskNum(3);
          this.g = true;
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
    this.a = TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().b()).getDownloadSDKClient(this.c);
    return this.a;
  }
  
  private DownloadInfo i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.h.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (TextUtils.equals(localDownloadInfo.c, paramString)) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  private int j(String paramString)
  {
    Object localObject = a(paramString);
    if (localObject != null)
    {
      if (((DownloadInfo)localObject).j == 1) {
        localObject = ((DownloadInfo)localObject).k;
      } else {
        localObject = ((DownloadInfo)localObject).d;
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
  
  private void j(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.7(this, paramDownloadInfo));
  }
  
  private void k(DownloadInfo paramDownloadInfo)
  {
    Object localObject;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
    {
      localObject = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class);
      if ((localObject != null) && (UpgradeController.a().b() == 4)) {
        ((MqqHandler)localObject).obtainMessage(1134019).sendToTarget();
      }
    }
    if (paramDownloadInfo.j == 1) {
      localObject = paramDownloadInfo.k;
    } else {
      localObject = paramDownloadInfo.d;
    }
    if (localObject != null) {
      ThreadManager.excute(new DownloadManagerV2.8(this, (String)localObject, paramDownloadInfo), 32, null, true);
    }
  }
  
  private void l(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.excute(new DownloadManagerV2.9(this, paramDownloadInfo), 32, null, true);
  }
  
  private void m(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.10(this, paramDownloadInfo));
  }
  
  private void n(DownloadInfo paramDownloadInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(">>startDownload downloadInfo:");
    ((StringBuilder)localObject1).append(paramDownloadInfo);
    LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject1).toString());
    localObject1 = a(paramDownloadInfo.b);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = DownloadInfoDB.a().b(paramDownloadInfo.b);
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
        if (!new File(((DownloadInfo)localObject2).q).exists())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[startDownload] info succeed, but file is deleted!info=");
          ((StringBuilder)localObject1).append(localObject2);
          LogUtility.e("DownloadManagerV2", ((StringBuilder)localObject1).toString());
          ((DownloadInfo)localObject2).c();
          localObject1 = null;
        }
      }
    }
    if (localObject1 != null)
    {
      ((DownloadInfo)localObject1).o = 0;
      ((DownloadInfo)localObject1).h = paramDownloadInfo.h;
      ((DownloadInfo)localObject1).r = paramDownloadInfo.r;
      ((DownloadInfo)localObject1).w = paramDownloadInfo.w;
      ((DownloadInfo)localObject1).T = paramDownloadInfo.T;
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("startDownload() downloadInfo != null>>>downloadInfo.url=");
      paramDownloadInfo.append(((DownloadInfo)localObject1).d);
      paramDownloadInfo.append("downloadInfo.isAutoInstall");
      paramDownloadInfo.append(((DownloadInfo)localObject1).w);
      paramDownloadInfo.append("+++++downloadInfo.downloadType=");
      paramDownloadInfo.append(((DownloadInfo)localObject1).j);
      paramDownloadInfo.append("  test");
      paramDownloadInfo.append(a(((DownloadInfo)localObject1).b));
      LogUtility.a("DownloadManagerV2", paramDownloadInfo.toString());
      paramDownloadInfo = (DownloadInfo)localObject1;
    }
    else
    {
      AppCenterReporter.a(paramDownloadInfo);
    }
    paramDownloadInfo.R = BaseApplicationImpl.getApplication().getQQProcessName();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(">>startDownload record download start process flag:");
    ((StringBuilder)localObject2).append(paramDownloadInfo.R);
    LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject2).toString());
    b(paramDownloadInfo, true);
    if (("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (f())) {
      r(paramDownloadInfo);
    }
    if (paramDownloadInfo.j == 1) {
      localObject2 = paramDownloadInfo.k;
    } else {
      localObject2 = paramDownloadInfo.d;
    }
    int i1 = paramDownloadInfo.j;
    HashMap localHashMap = new HashMap();
    localHashMap.put(TMAssistantDownloadConst.PARAM_APPID, paramDownloadInfo.c);
    localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, paramDownloadInfo.e);
    localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(paramDownloadInfo.n));
    localHashMap.put(TMAssistantDownloadConst.PARAM_VIA, paramDownloadInfo.h);
    localHashMap.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, "qqNumber");
    localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
    localHashMap.put(TMAssistantDownloadConst.PARAM_ICON_URL, paramDownloadInfo.B);
    localHashMap.put(TMAssistantDownloadConst.PARAM_APP_NAME, paramDownloadInfo.f);
    localHashMap.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(paramDownloadInfo.C));
    localHashMap.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(paramDownloadInfo.G));
    localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(paramDownloadInfo.I));
    localHashMap.put(TMAssistantDownloadConst.PARAM_QQ_SOURCE_ID, paramDownloadInfo.r);
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.13(this, (String)localObject2, localHashMap, i1, paramDownloadInfo, (DownloadInfo)localObject1));
    try
    {
      DownloadInfoReport.a((AppInterface)this.d.get(), paramDownloadInfo);
      return;
    }
    catch (Throwable paramDownloadInfo) {}
  }
  
  private void o(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.16(this, paramDownloadInfo));
  }
  
  private void p(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      this.h.remove(paramDownloadInfo.b);
      DownloadInfoDB.a().c(paramDownloadInfo.b);
    }
  }
  
  private int q(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return -30;
    }
    ApkWriteCodeListener localApkWriteCodeListener = this.f;
    if (localApkWriteCodeListener != null) {
      return localApkWriteCodeListener.a(paramDownloadInfo.e, paramDownloadInfo.n, paramDownloadInfo.q, null);
    }
    this.f = null;
    return -40;
  }
  
  private void r(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    ApkWriteCodeListener localApkWriteCodeListener = this.f;
    if (localApkWriteCodeListener != null)
    {
      localApkWriteCodeListener.a(paramDownloadInfo.e, paramDownloadInfo.n, null);
      return;
    }
    this.f = null;
  }
  
  private void s(DownloadInfo paramDownloadInfo)
  {
    LogUtility.b("DownloadManagerV2", "[getApkCodeAsync]");
    if (paramDownloadInfo == null)
    {
      LogUtility.b("DownloadManagerV2", "[getApkCodeAsync] info is null......");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.21(this, paramDownloadInfo));
  }
  
  public DownloadInfo a(String paramString)
  {
    if (paramString == null)
    {
      LogUtility.a("DownloadManagerV2", "getDownloadInfoByTicket ticket == null");
      return null;
    }
    DownloadInfo localDownloadInfo = (DownloadInfo)this.h.get(paramString);
    if (localDownloadInfo == null) {
      ThreadManager.excute(new DownloadManagerV2.11(this, paramString), 16, null, true);
    }
    return localDownloadInfo;
  }
  
  protected List<DownloadInfo> a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.h.values().iterator();
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
    Iterator localIterator = this.h.values().iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((paramString.equals(localDownloadInfo.e)) && (localDownloadInfo.a() == paramInt)) {
        localArrayList.add(localDownloadInfo);
      }
    }
    return localArrayList;
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
      this.d = new WeakReference(paramAppInterface);
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
    if (((localAppRuntime instanceof QQAppInterface)) && ("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (ConfigHandler.d((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      paramDownloadInfo.w = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onDownloadComplete] complete, info = ");
    localStringBuilder.append(paramDownloadInfo.toString());
    LogUtility.b("DownloadManagerV2", localStringBuilder.toString());
    if (paramDownloadInfo.o == 0)
    {
      if (paramDownloadInfo.j == 1) {
        o(paramDownloadInfo);
      } else {
        j(paramDownloadInfo);
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
    if (paramDownloadInfo.o == 0) {
      AppCenterReporter.a(paramDownloadInfo, paramInt);
    }
    if (!"5".equals(paramDownloadInfo.r)) {
      e(paramDownloadInfo.b, false);
    }
    AppNotificationManager.a().a(paramDownloadInfo.g);
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong)
  {
    if (c() != null)
    {
      if (c().get() == null) {
        return;
      }
      if ((AppInterface)c().get() != null)
      {
        int i1 = 14;
        if (!"biz_src_yyb".equals(paramDownloadInfo.r)) {
          if ("biz_src_zf_games".equals(paramDownloadInfo.r))
          {
            i1 = 15;
          }
          else if ("biz_src_jc_update".equals(paramDownloadInfo.r))
          {
            i1 = 17;
          }
          else if ("biz_src_news".equals(paramDownloadInfo.r))
          {
            i1 = 18;
          }
          else
          {
            "biz_src_jc_vip".equals(paramDownloadInfo.r);
            i1 = 40;
          }
        }
        Bundle localBundle1 = null;
        if (!TextUtils.isEmpty(paramDownloadInfo.f))
        {
          localBundle1 = new Bundle();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramDownloadInfo.f);
          ((StringBuilder)localObject).append(".apk");
          localBundle1.putString("appname", ((StringBuilder)localObject).toString());
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportDownloadResult info.packageName = ");
        ((StringBuilder)localObject).append(paramDownloadInfo.e);
        ((StringBuilder)localObject).append(",info.urlStr = ");
        ((StringBuilder)localObject).append(paramDownloadInfo.d);
        ((StringBuilder)localObject).append(",info.filePath = ");
        ((StringBuilder)localObject).append(paramDownloadInfo.q);
        LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject).toString());
        localObject = new Intent("com.opensdk.downloadmanager.renameFilename");
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("filePath", paramDownloadInfo.q);
        localBundle2.putLong("dataLength", paramLong);
        localBundle2.putInt("fileSourceId", i1);
        localBundle2.putBundle("otherData", localBundle1);
        localBundle2.putInt("peerType", -1);
        ((Intent)localObject).putExtra("extraBundle", localBundle2);
        CommonDataAdapter.a().b().sendBroadcast((Intent)localObject);
      }
    }
  }
  
  public void a(DownloadListener paramDownloadListener)
  {
    try
    {
      if (!this.i.contains(paramDownloadListener)) {
        this.i.add(paramDownloadListener);
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
    DownloadInfo localDownloadInfo2 = i(paramTMAssistantCallYYBParamStruct.SNGAppId);
    DownloadInfo localDownloadInfo1 = localDownloadInfo2;
    if (localDownloadInfo2 == null)
    {
      localDownloadInfo1 = MyAppApi.l().a(paramTMAssistantCallYYBParamStruct, null);
      e(localDownloadInfo1);
    }
    localDownloadInfo1.t = paramInt;
    localDownloadInfo1.a(2);
    a(2, localDownloadInfo1);
  }
  
  public void a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, TMAssistantCallYYBTaskInfo paramTMAssistantCallYYBTaskInfo, int paramInt2, String paramString)
  {
    int i1 = c(paramInt1);
    DownloadInfo localDownloadInfo = d(paramTMAssistantCallYYBParamStruct.SNGAppId, i1);
    if ((localDownloadInfo == null) && (paramInt1 != 6))
    {
      paramTMAssistantCallYYBTaskInfo = MyAppApi.l().a(paramTMAssistantCallYYBParamStruct, null);
      e(paramTMAssistantCallYYBTaskInfo);
      d(paramTMAssistantCallYYBParamStruct.SNGAppId, i1);
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
      if (MyAppApi.l().u())
      {
        paramTMAssistantCallYYBParamStruct = localDownloadInfo;
        if (paramTMAssistantCallYYBTaskInfo != null) {
          try
          {
            long l1 = paramTMAssistantCallYYBTaskInfo.mReceiveDataLen;
            long l2 = paramTMAssistantCallYYBTaskInfo.mTotalDataLen;
            paramInt1 = (int)((float)l1 * 100.0F / (float)l2);
            localDownloadInfo.t = paramInt1;
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
      paramTMAssistantCallYYBTaskInfo.append(i1);
      paramTMAssistantCallYYBTaskInfo.append(" dlInfo=");
      paramTMAssistantCallYYBTaskInfo.append(paramTMAssistantCallYYBParamStruct.toString());
      LogUtility.b("DownloadManagerV2", paramTMAssistantCallYYBTaskInfo.toString());
      a(i1, paramTMAssistantCallYYBParamStruct, paramInt2, paramString);
      return;
    }
    LogUtility.b("DownloadManagerV2", "onYYBDownloadTaskStateChanged notifyListener error dlInfo == null");
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject3 = this.h.values().iterator();
    ArrayList localArrayList = new ArrayList();
    String str = "";
    Object localObject1 = "";
    int i1 = 0;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)((Iterator)localObject3).next();
      if ((localDownloadInfo != null) && (localDownloadInfo.a() != 4) && (localDownloadInfo.a() != 1) && (localDownloadInfo.o == 1))
      {
        localArrayList.add(localDownloadInfo);
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (!AppUtil.a(localDownloadInfo.e)) {
            localObject2 = localDownloadInfo.f;
          }
        }
        i1 += 1;
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
    boolean bool = QAppCenterPluginProxyActivityTools.a;
    if ((paramBoolean) && (i1 > 0))
    {
      localObject3 = new StringBuilder();
      localObject2 = str;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901613));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131901624));
      localObject1 = ((StringBuilder)localObject3).toString();
      if (bool)
      {
        ToastUtil.a().a((String)localObject1, 1);
        return;
      }
      MyAppApi.l().a(true, (String)localObject1);
    }
  }
  
  public boolean a(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    if (paramApkWriteCodeListener == null) {
      return false;
    }
    this.f = paramApkWriteCodeListener;
    return true;
  }
  
  public boolean a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    if (paramDownloadInfo == null)
    {
      LogUtility.a("DownloadManagerV2", "installDownload info == null");
      return false;
    }
    if (!paramDownloadInfo.A)
    {
      LogUtility.a("DownloadManagerV2", "installDownload info is not apk");
      return false;
    }
    Object localObject1;
    if (TextUtils.isEmpty(paramDownloadInfo.q))
    {
      int i1 = paramDownloadInfo.o;
      localObject2 = null;
      if (i1 == 0)
      {
        localObject1 = g(paramDownloadInfo.d);
        if ((localObject1 != null) && (((TMAssistantDownloadTaskInfo)localObject1).mState == 4)) {
          localObject3 = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        } else {
          localObject3 = "";
        }
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = c(paramDownloadInfo);
          localObject1 = localObject3;
          localObject2 = localTMAssistantDownloadTaskInfo;
          if (localTMAssistantDownloadTaskInfo != null)
          {
            paramDownloadInfo.o = 1;
            localObject1 = localObject3;
            localObject2 = localTMAssistantDownloadTaskInfo;
          }
        }
      }
      else
      {
        localObject1 = c(paramDownloadInfo);
        if ((localObject1 != null) && (((TMAssistantDownloadTaskInfo)localObject1).mState == 4)) {
          localObject3 = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        } else {
          localObject3 = "";
        }
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = g(paramDownloadInfo.d);
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
        paramDownloadInfo.q = ((String)localObject3);
        paramDownloadInfo.a(4);
        e(paramDownloadInfo);
        localObject1 = localObject3;
      }
    }
    else
    {
      localObject1 = paramDownloadInfo.q;
    }
    if (!new File((String)localObject1).canRead())
    {
      paramDownloadInfo = new StringBuilder();
      paramDownloadInfo.append("can't read apk file. installDownload localAPKPath=");
      paramDownloadInfo.append((String)localObject1);
      LogUtility.b("DownloadManagerV2", paramDownloadInfo.toString());
      return false;
    }
    Object localObject2 = AppUtil.c((String)localObject1);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("installDownload localAPKPath=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", apkPackageName=");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(" updateType=");
    ((StringBuilder)localObject3).append(paramDownloadInfo.j);
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
  
  public void b()
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.4(this));
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
  
  public void b(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    if (paramDownloadInfo != null) {
      try
      {
        paramDownloadInfo.b();
        boolean bool = TextUtils.isEmpty(paramDownloadInfo.b);
        if (bool) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addDownloadInfo info.appId = ");
        localStringBuilder.append(paramDownloadInfo.c);
        localStringBuilder.append(",info.packageName = ");
        localStringBuilder.append(paramDownloadInfo.e);
        localStringBuilder.append(",info.filePath = ");
        localStringBuilder.append(paramDownloadInfo.q);
        LogUtility.b("DownloadManagerV2", localStringBuilder.toString());
        this.h.put(paramDownloadInfo.b, paramDownloadInfo);
        ThreadManager.excute(new DownloadManagerV2.17(this, paramDownloadInfo, paramBoolean), 32, null, true);
      }
      finally {}
    }
  }
  
  public void b(DownloadListener paramDownloadListener)
  {
    try
    {
      if (this.i.contains(paramDownloadListener)) {
        this.i.remove(paramDownloadListener);
      }
      return;
    }
    finally
    {
      paramDownloadListener = finally;
      throw paramDownloadListener;
    }
  }
  
  public boolean b(ApkWriteCodeListener paramApkWriteCodeListener)
  {
    if (paramApkWriteCodeListener == null) {
      return false;
    }
    ApkWriteCodeListener localApkWriteCodeListener = this.f;
    if ((localApkWriteCodeListener != null) && (paramApkWriteCodeListener == localApkWriteCodeListener))
    {
      this.f = null;
      return true;
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
      Iterator localIterator = this.h.values().iterator();
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
  
  public TMAssistantDownloadTaskInfo c(DownloadInfo paramDownloadInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.b, paramDownloadInfo.c);
    localBundle.putString(DownloadConstants.c, paramDownloadInfo.l);
    localBundle.putString(DownloadConstants.d, paramDownloadInfo.m);
    localBundle.putString(DownloadConstants.f, paramDownloadInfo.e);
    localBundle.putInt(DownloadConstants.e, paramDownloadInfo.n);
    localBundle.putString(DownloadConstants.i, paramDownloadInfo.h);
    StringBuilder localStringBuilder1 = null;
    Object localObject = localStringBuilder1;
    try
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localObject = localStringBuilder1;
      localStringBuilder2.append("OpenSDK getTaskInfoFromMyApp param SNGAppId=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.c);
      localObject = localStringBuilder1;
      localStringBuilder2.append(" apkId=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.m);
      localObject = localStringBuilder1;
      localStringBuilder2.append(" taskAppId=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.l);
      localObject = localStringBuilder1;
      localStringBuilder2.append(" packageName=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.e);
      localObject = localStringBuilder1;
      localStringBuilder2.append(" version=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.n);
      localObject = localStringBuilder1;
      localStringBuilder2.append(" via=");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramDownloadInfo.h);
      localObject = localStringBuilder1;
      LogUtility.a("DownloadManagerV2", localStringBuilder2.toString());
      localObject = localStringBuilder1;
      paramDownloadInfo = MyAppApi.l().c(localBundle);
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
  
  public WeakReference<AppInterface> c()
  {
    try
    {
      Object localObject1 = this.d;
      if (localObject1 == null) {
        try
        {
          if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
          {
            localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
            if (localObject1 != null) {
              this.d = new WeakReference(localObject1);
            }
          }
        }
        catch (Exception localException)
        {
          LogUtility.c("DownloadManagerV2", "getQQAppInterface>>>", localException);
        }
      }
      WeakReference localWeakReference = this.d;
      return localWeakReference;
    }
    finally {}
  }
  
  public String d(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.q;
    }
    return "";
  }
  
  public ConcurrentHashMap<String, DownloadInfo> d()
  {
    return this.h;
  }
  
  public boolean d(DownloadInfo paramDownloadInfo)
  {
    return a(paramDownloadInfo, true);
  }
  
  public int e(String paramString)
  {
    return j(DownloadInfo.b(paramString));
  }
  
  protected void e()
  {
    if (this.h.size() > 200) {
      ThreadManager.getSubThreadHandler().postDelayed(new DownloadManagerV2.20(this), 3000L);
    }
  }
  
  public void e(DownloadInfo paramDownloadInfo)
  {
    b(paramDownloadInfo, false);
  }
  
  public void f(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a().a(9, paramDownloadInfo);
    }
  }
  
  public void f(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      AppNotificationManager.a().a(paramString);
    }
  }
  
  public boolean f()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  public TMAssistantDownloadTaskInfo g(String paramString)
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
        Object localObject2 = h();
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
  
  public void g(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      a(paramDownloadInfo, 2);
      a().a(13, paramDownloadInfo);
    }
  }
  
  public void h(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      a(paramDownloadInfo, 1);
      a().a(6, paramDownloadInfo);
    }
  }
  
  public void h(String paramString)
  {
    try
    {
      if ((BaseActivity.sTopActivity.isResume()) && (System.currentTimeMillis() - this.n > 1000L))
      {
        this.n = System.currentTimeMillis();
        ToastUtil.a().a(paramString);
        return;
      }
    }
    catch (Exception paramString)
    {
      LogUtility.c("DownloadManagerV2", "showToast>>>", paramString);
    }
  }
  
  public boolean i(DownloadInfo paramDownloadInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("refreshDownloadInfo DownloadInfo=");
    ((StringBuilder)localObject1).append(paramDownloadInfo);
    LogUtility.a("DownloadManagerV2", ((StringBuilder)localObject1).toString());
    Object localObject2 = a(paramDownloadInfo.b);
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
      if (((DownloadInfo)localObject1).o == 0)
      {
        LogUtility.a("DownloadManagerV2", "refreshDownloadInfo DownloadInfo.DOWNLOAD_TYPE_DOWNLOADSDK......");
        paramDownloadInfo.z = ((DownloadInfo)localObject1).z;
        if (((DownloadInfo)localObject1).j == 1) {
          localObject2 = ((DownloadInfo)localObject1).k;
        } else {
          localObject2 = ((DownloadInfo)localObject1).d;
        }
        localObject2 = a().g((String)localObject2);
        if (localObject2 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshDownloadInfo sdk getReceiveDataLen=");
          localStringBuilder.append(((TMAssistantDownloadTaskInfo)localObject2).mReceiveDataLen);
          localStringBuilder.append(" getTotalDataLen=");
          localStringBuilder.append(((TMAssistantDownloadTaskInfo)localObject2).mTotalDataLen);
          LogUtility.a("DownloadManagerV2", localStringBuilder.toString());
          paramDownloadInfo.t = ((int)((float)((TMAssistantDownloadTaskInfo)localObject2).mReceiveDataLen * 100.0F / (float)((TMAssistantDownloadTaskInfo)localObject2).mTotalDataLen));
          paramDownloadInfo.a(c(((TMAssistantDownloadTaskInfo)localObject2).mState));
          paramDownloadInfo.o = 0;
          if (((DownloadInfo)localObject1).j == 1)
          {
            if (TextUtils.isEmpty(((DownloadInfo)localObject1).q)) {
              paramDownloadInfo.q = ((TMAssistantDownloadTaskInfo)localObject2).mSavePath;
            } else {
              paramDownloadInfo.q = ((DownloadInfo)localObject1).q;
            }
          }
          else {
            paramDownloadInfo.q = ((TMAssistantDownloadTaskInfo)localObject2).mSavePath;
          }
          if (paramDownloadInfo.a() == 4)
          {
            paramDownloadInfo.D = ((DownloadInfo)localObject1).D;
            if (paramDownloadInfo.D != 0)
            {
              paramDownloadInfo.a(3);
              e((DownloadInfo)localObject1);
            }
          }
          return true;
        }
        p((DownloadInfo)localObject1);
        paramDownloadInfo.a(-100);
        return true;
      }
      if (((DownloadInfo)localObject1).o == 1)
      {
        localObject2 = c((DownloadInfo)localObject1);
        if (localObject2 != null)
        {
          int i2 = c(((TMAssistantDownloadTaskInfo)localObject2).mState);
          int i1 = i2;
          if (i2 == -2) {
            i1 = 3;
          }
          paramDownloadInfo.a(i1);
          paramDownloadInfo.o = 1;
          paramDownloadInfo.q = ((TMAssistantDownloadTaskInfo)localObject2).mSavePath;
          long l1 = ((TMAssistantDownloadTaskInfo)localObject2).mReceiveDataLen;
          long l2 = ((TMAssistantDownloadTaskInfo)localObject2).mTotalDataLen;
          paramDownloadInfo.t = ((int)((float)l1 * 100.0F / (float)l2));
          if (!MyAppApi.l().u()) {
            paramDownloadInfo.t = 0;
          }
          return true;
        }
        p((DownloadInfo)localObject1);
      }
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2
 * JD-Core Version:    0.7.0.1
 */