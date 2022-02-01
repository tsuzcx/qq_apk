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
  public static final String a;
  protected static DownloadManager d;
  protected static final byte[] l = new byte[1];
  protected TMAssistantDownloadClient b;
  protected String c = "";
  protected WeakReference<AppInterface> e;
  protected boolean f = false;
  protected ConcurrentHashMap<String, DownloadInfo> g = new ConcurrentHashMap();
  protected ConcurrentLinkedQueue<DownloadListener> h = new ConcurrentLinkedQueue();
  protected PackageInstallReceiver i;
  protected boolean j = false;
  protected ITMAssistantDownloadClientListener k = new DownloadManager.5(this);
  protected long m = 0L;
  protected long n = 0L;
  protected final int o = 1000;
  protected ITMAssistantDownloadLogListener p = new DownloadManager.22(this);
  private DownloaderGetCodeClient q;
  private ApkWriteCodeListener r;
  private ApkGetCodeListener s = new DownloadManager.19(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(File.separator);
    localStringBuilder.append("tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(".qqdownload");
    localStringBuilder.append(File.separator);
    a = localStringBuilder.toString();
  }
  
  protected DownloadManager()
  {
    LogUtility.c("DownloadManager_", "DownloadManager create QQ5.0");
    this.q = DownloaderGetCodeClient.a();
    this.i = new PackageInstallReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addDataScheme("package");
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    CommonDataAdapter.a().b().registerReceiver(this.i, localIntentFilter);
    NoticeDownloadListener.a().a(ThreadManager.getSubThreadHandler().getLooper());
    a(WebViewDownloadListener.a());
    a(NoticeDownloadListener.a());
    ThreadManager.excute(new DownloadManager.2(this), 32, null, true);
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
    if ((paramDownloadInfo.s != 4) && (paramDownloadInfo.G))
    {
      LogUtility.b("DownloadManager_", "isAutoInstallBySDK is true");
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      if (new File(paramString1).exists())
      {
        bool = AppUtil.a(CommonDataAdapter.a().b(), paramString1, paramDownloadInfo.r, paramDownloadInfo.a("big_brother_ref_source_key"), paramDownloadInfo.a("hideInstallSuccessPage"));
        AppCircleReportManager.a().a(100, paramDownloadInfo);
      }
    }
    else
    {
      bool = AppUtil.a(CommonDataAdapter.a().b(), paramString1, paramDownloadInfo.r, paramDownloadInfo.a("big_brother_ref_source_key"), paramDownloadInfo.a("hideInstallSuccessPage"));
      AppCircleReportManager.a().a(100, paramDownloadInfo);
    }
    if ((bool) && (paramString2.equals("com.tencent.android.qqdownloader")) && (paramDownloadInfo.c.equals("1101070898")))
    {
      LogUtility.a("DownloadManager_", "report yyb start install");
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
  
  public static int b(int paramInt)
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
  
  public static DownloadManager b()
  {
    try
    {
      DownloadManager localDownloadManager1 = d;
      if (localDownloadManager1 == null) {
        try
        {
          d = new DownloadManager();
          d.c = "open_sdkcom.tencent.mobileqq:web";
          d.e();
          d.k();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      DownloadManager localDownloadManager2 = d;
      return localDownloadManager2;
    }
    finally {}
  }
  
  public static boolean c()
  {
    try
    {
      DownloadManager localDownloadManager = d;
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
  
  private void k(DownloadInfo paramDownloadInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(">>startDownload downloadInfo:");
    ((StringBuilder)localObject1).append(paramDownloadInfo);
    LogUtility.c("DownloadManager_", ((StringBuilder)localObject1).toString());
    if (paramDownloadInfo.A) {
      ImageCache.a("app", ImageUtil.a(paramDownloadInfo.c, 100), new DownloadManager.10(this, paramDownloadInfo));
    }
    DownloadInfo localDownloadInfo = d(paramDownloadInfo.c);
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
      ((StringBuilder)localObject2).append(paramDownloadInfo.d);
      ((StringBuilder)localObject2).append("downloadInfo.isAutoInstall");
      ((StringBuilder)localObject2).append(paramDownloadInfo.w);
      ((StringBuilder)localObject2).append("+++++downloadInfo.downloadType=");
      ((StringBuilder)localObject2).append(paramDownloadInfo.j);
      ((StringBuilder)localObject2).append("  test");
      ((StringBuilder)localObject2).append(d(paramDownloadInfo.c));
      LogUtility.a("DownloadManager_", ((StringBuilder)localObject2).toString());
    }
    else
    {
      if (paramDownloadInfo.v == 12) {
        localObject1 = "2000";
      } else {
        localObject1 = "900";
      }
      StaticAnalyz.a((String)localObject1, paramDownloadInfo.h, paramDownloadInfo.c, paramDownloadInfo.F);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("+++++startDownload()+++++ downloadInfo == null>>>downloadInfo.url=");
      ((StringBuilder)localObject1).append(paramDownloadInfo.d);
      ((StringBuilder)localObject1).append("+++++downloadInfo.downloadType=");
      ((StringBuilder)localObject1).append(paramDownloadInfo.j);
      LogUtility.a("DownloadManager_", ((StringBuilder)localObject1).toString());
      localObject1 = paramDownloadInfo;
    }
    f((DownloadInfo)localObject1);
    if (("com.tencent.mobileqq".equals(((DownloadInfo)localObject1).e)) && (l())) {
      i((DownloadInfo)localObject1);
    }
    if (((DownloadInfo)localObject1).j == 1) {
      localObject2 = ((DownloadInfo)localObject1).k;
    } else {
      localObject2 = ((DownloadInfo)localObject1).d;
    }
    int i1 = ((DownloadInfo)localObject1).j;
    HashMap localHashMap = new HashMap();
    localHashMap.put(TMAssistantDownloadConst.PARAM_APPID, ((DownloadInfo)localObject1).c);
    localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, ((DownloadInfo)localObject1).e);
    localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(((DownloadInfo)localObject1).n));
    localHashMap.put(TMAssistantDownloadConst.PARAM_VIA, ((DownloadInfo)localObject1).h);
    localHashMap.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, "qqNumber");
    localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
    localHashMap.put(TMAssistantDownloadConst.PARAM_ICON_URL, ((DownloadInfo)localObject1).B);
    localHashMap.put(TMAssistantDownloadConst.PARAM_APP_NAME, ((DownloadInfo)localObject1).f);
    localHashMap.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(((DownloadInfo)localObject1).C));
    localHashMap.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(((DownloadInfo)localObject1).G));
    localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(((DownloadInfo)localObject1).I));
    ThreadManager.getSubThreadHandler().post(new DownloadManager.11(this, (String)localObject2, localHashMap, i1, (DownloadInfo)localObject1, localDownloadInfo, paramDownloadInfo));
    try
    {
      DownloadInfoReport.a((AppInterface)this.e.get(), (DownloadInfo)localObject1);
      return;
    }
    catch (Throwable paramDownloadInfo) {}
  }
  
  private void l(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManager.15(this, paramDownloadInfo));
  }
  
  private void m(DownloadInfo paramDownloadInfo)
  {
    LogUtility.c("DownloadManager_", "receive get code msg......");
    if (paramDownloadInfo == null)
    {
      LogUtility.c("DownloadManager_", "receive get code msg but info is null......");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadManager.20(this, paramDownloadInfo));
  }
  
  public DownloadInfo a(String paramString, int paramInt)
  {
    paramString = i(paramString);
    if ((paramString != null) && (paramInt != -2)) {
      paramString.a(paramInt);
    }
    return paramString;
  }
  
  protected List<DownloadInfo> a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.g.values().iterator();
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
                      paramString.append(HardCodeUtil.a(2131901609));
                      paramString.append(this.h.size());
                      LogUtility.a("DownloadManager_", paramString.toString());
                      this.g.remove(paramDownloadInfo.c);
                      DownloadDBHelper.a().b(paramDownloadInfo.c);
                      AppNotificationManager.a().a(paramDownloadInfo.g);
                      paramDownloadInfo.a(10);
                      paramString = new StringBuilder();
                      paramString.append("downloadInfo.state = ");
                      paramString.append(paramDownloadInfo.a());
                      LogUtility.a("DownloadManager_", paramString.toString());
                      paramString = this.h.iterator();
                      while (paramString.hasNext()) {
                        ((DownloadListener)paramString.next()).onDownloadCancel(paramDownloadInfo);
                      }
                    }
                  }
                  else
                  {
                    paramString = new StringBuilder();
                    paramString.append(HardCodeUtil.a(2131901617));
                    paramString.append(this.h.size());
                    LogUtility.a("DownloadManager_", paramString.toString());
                    paramString = this.h.iterator();
                    while (paramString.hasNext()) {
                      ((DownloadListener)paramString.next()).uninstallSucceed(paramDownloadInfo.c, paramDownloadInfo.e);
                    }
                  }
                }
                else
                {
                  paramString = new StringBuilder();
                  paramString.append(HardCodeUtil.a(2131901606));
                  paramString.append(this.h.size());
                  LogUtility.a("DownloadManager_", paramString.toString());
                  paramString = this.h.iterator();
                  while (paramString.hasNext()) {
                    ((DownloadListener)paramString.next()).onDownloadFinish(paramDownloadInfo);
                  }
                  DownloadInfoReport.a(2, null, 100, paramDownloadInfo);
                }
              }
              else
              {
                paramString = new StringBuilder();
                paramString.append(HardCodeUtil.a(2131901600));
                paramString.append(this.h.size());
                LogUtility.a("DownloadManager_", paramString.toString());
                paramString = this.h.iterator();
                while (paramString.hasNext()) {
                  ((DownloadListener)paramString.next()).onDownloadPause(paramDownloadInfo);
                }
              }
            }
            else if ((paramDownloadInfo.o == 1) || (System.currentTimeMillis() - this.m > 1000L))
            {
              this.m = System.currentTimeMillis();
              paramDownloadInfo = new StringBuilder();
              paramDownloadInfo.append(HardCodeUtil.a(2131901591));
              paramDownloadInfo.append(this.h.size());
              LogUtility.a("DownloadManager_", paramDownloadInfo.toString());
              paramDownloadInfo = a(2);
              paramString = new StringBuilder();
              paramString.append(HardCodeUtil.a(2131901599));
              paramString.append(paramDownloadInfo.size());
              LogUtility.a("DownloadManager_", paramString.toString());
              paramString = this.h.iterator();
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
            paramString.append(HardCodeUtil.a(2131901612));
            paramString.append(this.h.size());
            LogUtility.a("DownloadManager_", paramString.toString());
            paramString = this.h.iterator();
            while (paramString.hasNext()) {
              ((DownloadListener)paramString.next()).onDownloadWait(paramDownloadInfo);
            }
          }
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append(HardCodeUtil.a(2131901596));
          paramString.append(this.h.size());
          LogUtility.a("DownloadManager_", paramString.toString());
          paramString = this.h.iterator();
          while (paramString.hasNext()) {
            ((DownloadListener)paramString.next()).packageReplaced(paramDownloadInfo.c, paramDownloadInfo.e);
          }
        }
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(HardCodeUtil.a(2131901610));
        paramString.append(this.h.size());
        LogUtility.a("DownloadManager_", paramString.toString());
        paramString = this.h.iterator();
        while (paramString.hasNext()) {
          ((DownloadListener)paramString.next()).installSucceed(paramDownloadInfo.c, paramDownloadInfo.e);
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
      this.e = new WeakReference(paramAppInterface);
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
      k(paramDownloadInfo);
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
    this.j = false;
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
    int i1 = 3;
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
        localObject = CommonDataAdapter.a().b().getString(2131892305);
      }
      catch (Exception paramDownloadInfo)
      {
        int i2;
        String str;
        continue;
      }
      paramString = CommonDataAdapter.a().b().getString(2131892300);
      continue;
      paramString = CommonDataAdapter.a().b().getString(2131892307);
      continue;
      paramString = CommonDataAdapter.a().b().getString(2131892312);
      continue;
      paramString = CommonDataAdapter.a().b().getString(2131892309);
      continue;
      LogUtility.a("DownloadManager_", HardCodeUtil.a(2131901594));
      if ((paramDownloadInfo.e != null) && ("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (paramDownloadInfo.j != 1) && (l()))
      {
        LogUtility.a("DownloadManager_", HardCodeUtil.a(2131901595));
        ThreadManager.getSubThreadHandler().post(new DownloadManager.6(this, paramDownloadInfo));
        return;
      }
      paramDownloadInfo.a(4);
      if (paramDownloadInfo.j == 1)
      {
        l(paramDownloadInfo);
        return;
      }
      ThreadManager.excute(new DownloadManager.7(this, paramDownloadInfo), 32, null, true);
      return;
      paramString = CommonDataAdapter.a().b().getString(2131892300);
      continue;
      paramString = CommonDataAdapter.a().b().getString(2131892310);
      continue;
      paramString = CommonDataAdapter.a().b().getString(2131892305);
      continue;
      LogUtility.a("DownloadManager_", HardCodeUtil.a(2131901618));
      paramString = (String)localObject;
      continue;
      if (paramInt == 712) {
        localObject = CommonDataAdapter.a().b().getString(2131892302);
      } else {
        localObject = CommonDataAdapter.a().b().getString(2131892303);
      }
      i2 = 10;
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
      {
        paramString = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class);
        if ((paramString != null) && (UpgradeController.a().b() == 4)) {
          paramString.obtainMessage(1134019).sendToTarget();
        }
      }
      i1 = i2;
      paramString = (String)localObject;
      if (paramDownloadInfo != null)
      {
        if (paramDownloadInfo.j == 1) {
          str = paramDownloadInfo.k;
        } else {
          str = paramDownloadInfo.d;
        }
        i1 = i2;
        paramString = (String)localObject;
        if (str != null)
        {
          ThreadManager.excute(new DownloadManager.8(this, str, paramDownloadInfo), 32, null, true);
          paramString = (String)localObject;
          i1 = i2;
        }
      }
      paramDownloadInfo.a(i1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131901605));
      ((StringBuilder)localObject).append(this.h.size());
      LogUtility.a("DownloadManager_", ((StringBuilder)localObject).toString());
      localObject = this.h.iterator();
      if (((Iterator)localObject).hasNext())
      {
        ((DownloadListener)((Iterator)localObject).next()).onDownloadError(paramDownloadInfo, paramInt, paramString, i1);
      }
      else
      {
        if (!TextUtils.isEmpty(paramString))
        {
          j(paramString);
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
    if (d() != null)
    {
      if (d().get() == null) {
        return;
      }
      if ((AppInterface)d().get() != null)
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
        LogUtility.c("DownloadManager_", ((StringBuilder)localObject).toString());
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
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.y, "open appstore network error");
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
              a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.y, "write file error");
              return;
              a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.y, "DownloadSDK_START_FAILED_EXISTED");
              return;
            }
          case 600: 
          case 604: 
            a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.y, "download error");
            return;
          }
        }
        a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.y, "network error");
        return;
      }
      label301:
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.y, "do not need to handle error");
      return;
    }
    a(paramDownloadInfo, 0L, paramLong1 - paramDownloadInfo.y, "package invalid");
  }
  
  protected void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, String paramString)
  {
    if (paramLong2 > 0L)
    {
      paramDownloadInfo.y = paramLong1;
      f(paramDownloadInfo);
      a(paramString, paramLong2, paramDownloadInfo.r);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    if (paramApkUpdateDetail != null) {}
    try
    {
      int i1 = paramApkUpdateDetail.updatemethod;
      if (i1 == 4)
      {
        try
        {
          String str = paramApkUpdateDetail.url;
          long l1 = paramApkUpdateDetail.patchsize;
          paramApkUpdateDetail = paramApkUpdateDetail.fileMd5;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131901614));
          localStringBuilder.append(l1 / 1048576L);
          localStringBuilder.append("MB  fileMd5=");
          localStringBuilder.append(paramApkUpdateDetail);
          localStringBuilder.append(" urlPatch=");
          localStringBuilder.append(str);
          LogUtility.c("DownloadManager_", localStringBuilder.toString());
          paramDownloadInfo.k = str;
          paramDownloadInfo.j = 1;
          if (l1 > 0L) {
            paramDownloadInfo.I = l1;
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
      if (!this.h.contains(paramDownloadListener)) {
        this.h.add(paramDownloadListener);
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
      if (this.b != null)
      {
        this.b.unRegisterLogListener(paramITMAssistantDownloadLogListener);
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
    if ((d() != null) && (paramString2 != null))
    {
      paramString2 = (AppInterface)d().get();
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
    Object localObject = d(paramString);
    if (localObject == null)
    {
      LogUtility.d("DownloadManager_", "clearDownloadInfo info == null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearDownloadInfo info =");
    localStringBuilder.append(((DownloadInfo)localObject).toString());
    LogUtility.a("DownloadManager_", localStringBuilder.toString());
    if (((DownloadInfo)localObject).o == 0)
    {
      if (((DownloadInfo)localObject).j == 1) {
        localObject = ((DownloadInfo)localObject).k;
      } else {
        localObject = ((DownloadInfo)localObject).d;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.getSubThreadHandler().post(new DownloadManager.9(this, paramBoolean, (String)localObject));
      }
    }
    this.g.remove(paramString);
    DownloadDBHelper.a().b(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject3 = this.g.values().iterator();
    ArrayList localArrayList = new ArrayList();
    String str = "";
    Object localObject1 = "";
    int i1 = 0;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)((Iterator)localObject3).next();
      if ((localDownloadInfo != null) && (localDownloadInfo.s != 4) && (localDownloadInfo.s != 1) && (localDownloadInfo.o == 1))
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
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901607));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131901592));
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
    this.r = paramApkWriteCodeListener;
    return true;
  }
  
  protected boolean a(DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2)
  {
    paramDownloadInfo1.w = paramDownloadInfo2.w;
    paramDownloadInfo1.x = paramDownloadInfo2.x;
    paramDownloadInfo1.o = paramDownloadInfo2.o;
    paramDownloadInfo1.h = paramDownloadInfo2.h;
    if (!TextUtils.isEmpty(paramDownloadInfo1.d))
    {
      if (!paramDownloadInfo1.d.equals(paramDownloadInfo2.d))
      {
        a(paramDownloadInfo2.c, false);
        return false;
      }
    }
    else {
      paramDownloadInfo1.d = paramDownloadInfo2.d;
    }
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = d(paramString1);
    if (paramString2 != null) {
      a(paramString1, false);
    }
    if (paramString2 != null) {
      if (paramBoolean) {
        a(10, paramString2);
      } else {
        try
        {
          AppNotificationManager.a().a(paramString2.g);
        }
        catch (Exception paramString1)
        {
          LogUtility.c("DownloadManager_", "downloadSDKClient>>>", paramString1);
        }
      }
    }
    return true;
  }
  
  public DownloadInfo b(String paramString, int paramInt)
  {
    paramString = d(paramString);
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
  
  public String b(String paramString)
  {
    paramString = d(paramString);
    if (paramString != null) {
      return paramString.q;
    }
    return "";
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
    if (((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) && ("com.tencent.mobileqq".equals(paramDownloadInfo.e)) && (ConfigHandler.d((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      paramDownloadInfo.w = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownload complete, info = ");
    localStringBuilder.append(paramDownloadInfo.toString());
    LogUtility.a("DownloadManager_", localStringBuilder.toString());
    if (paramDownloadInfo.o == 0)
    {
      if (paramDownloadInfo.j == 1) {
        l(paramDownloadInfo);
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
      if (this.h.contains(paramDownloadListener)) {
        this.h.remove(paramDownloadListener);
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
    ApkWriteCodeListener localApkWriteCodeListener = this.r;
    if ((localApkWriteCodeListener != null) && (paramApkWriteCodeListener == localApkWriteCodeListener))
    {
      this.r = null;
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = d(paramString1);
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
        AppNotificationManager.a().a(paramString2.g);
        return true;
      }
      catch (Exception paramString1)
      {
        LogUtility.c("DownloadManager_", "downloadSDKClient>>>", paramString1);
      }
    }
    return true;
  }
  
  public DownloadInfo c(String paramString, int paramInt)
  {
    paramString = i(paramString);
    if (paramString != null)
    {
      paramString.a(2);
      paramString.t = paramInt;
    }
    return paramString;
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
      LogUtility.a("State_Log", localStringBuilder2.toString());
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
  
  public String c(String paramString)
  {
    paramString = d(paramString);
    if (paramString != null) {
      return paramString.r;
    }
    return "";
  }
  
  public DownloadInfo d(String paramString)
  {
    if (paramString == null)
    {
      LogUtility.a("DownloadManager_", "getDownloadInfoById appId == null");
      return null;
    }
    return (DownloadInfo)this.g.get(paramString);
  }
  
  public WeakReference<AppInterface> d()
  {
    try
    {
      Object localObject1 = this.e;
      if (localObject1 == null) {
        try
        {
          if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
          {
            localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
            if (localObject1 != null) {
              this.e = new WeakReference(localObject1);
            }
          }
        }
        catch (Exception localException)
        {
          LogUtility.c("DownloadManager_", "getQQAppInterface>>>", localException);
        }
      }
      WeakReference localWeakReference = this.e;
      return localWeakReference;
    }
    finally {}
  }
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null)
    {
      LogUtility.a("DownloadManager_", "installDownload info == null");
      return;
    }
    if (!paramDownloadInfo.A)
    {
      LogUtility.a("DownloadManager_", "installDownload info is not apk");
      return;
    }
    Object localObject1;
    if (TextUtils.isEmpty(paramDownloadInfo.q))
    {
      int i1 = paramDownloadInfo.o;
      localObject3 = null;
      if (i1 == 0)
      {
        localObject1 = h(paramDownloadInfo.d);
        if ((localObject1 != null) && (((TMAssistantDownloadTaskInfo)localObject1).mState == 4)) {
          localObject2 = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        } else {
          localObject2 = "";
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = c(paramDownloadInfo);
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = c(paramDownloadInfo);
        if ((localObject1 != null) && (((TMAssistantDownloadTaskInfo)localObject1).mState == 4)) {
          localObject2 = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        } else {
          localObject2 = "";
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = h(paramDownloadInfo.d);
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
        paramDownloadInfo.q = ((String)localObject2);
        paramDownloadInfo.a(4);
        f(paramDownloadInfo);
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = paramDownloadInfo.q;
    }
    Object localObject2 = AppUtil.c((String)localObject1);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("installDownload localAPKPath=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", apkPackageName=");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(" updateType=");
    ((StringBuilder)localObject3).append(paramDownloadInfo.j);
    LogUtility.a("DownloadManager_", ((StringBuilder)localObject3).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("installDownload localAPKPath=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", apkPackageName=");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(" updateType=");
    ((StringBuilder)localObject3).append(paramDownloadInfo.j);
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
  
  public List<DownloadInfo> e(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDownloadInfoById via == ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.a("DownloadManager_", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((!TextUtils.isEmpty(localDownloadInfo.h)) && (localDownloadInfo.h.equals(paramString))) {
        ((List)localObject).add(localDownloadInfo);
      }
    }
    paramString = new StringBuilder();
    paramString.append("getDownloadInfoByVia result =");
    paramString.append(localObject);
    LogUtility.a("DownloadManager_", paramString.toString());
    return localObject;
  }
  
  protected void e()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadManager.3(this), 5000L);
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadManager.4(this), 10000L);
  }
  
  public void e(DownloadInfo paramDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReveiveInstallIntent info=");
    localStringBuilder.append(paramDownloadInfo);
    LogUtility.c("DownloadManager_", localStringBuilder.toString());
    if (paramDownloadInfo.o == 0) {
      StaticAnalyz.a("310", paramDownloadInfo.h, paramDownloadInfo.c, paramDownloadInfo.F);
    }
    if (!"5".equals(paramDownloadInfo.r)) {
      a(paramDownloadInfo.c, false);
    }
    AppNotificationManager.a().a(paramDownloadInfo.g);
  }
  
  public DownloadInfo f(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Iterator localIterator = this.g.values().iterator();
        while (localIterator.hasNext())
        {
          DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
          boolean bool = paramString.equals(localDownloadInfo.e);
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
  
  public TMAssistantDownloadClient f()
  {
    TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().b()).getDownloadSDKClient(this.c).registerDownloadTaskListener(this.k);
    if (QLog.isColorLevel())
    {
      QLog.i("DownloadManager_", 2, "registerLogListener!");
      TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().b()).getDownloadSDKClient(this.c).registerLogListener(this.p);
    }
    if (!this.j) {
      try
      {
        TMAssistantDownloadSettingClient localTMAssistantDownloadSettingClient = TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().b()).getDownloadSDKSettingClient();
        if (localTMAssistantDownloadSettingClient != null)
        {
          localTMAssistantDownloadSettingClient.setDownloadSDKMaxTaskNum(3);
          this.j = true;
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
    this.b = TMAssistantDownloadManager.getInstance(CommonDataAdapter.a().b()).getDownloadSDKClient(this.c);
    return this.b;
  }
  
  public void f(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramDownloadInfo.c))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addDownloadInfo info.appId = ");
        localStringBuilder.append(paramDownloadInfo.c);
        localStringBuilder.append(",info.packageName = ");
        localStringBuilder.append(paramDownloadInfo.e);
        localStringBuilder.append(",info.filePath = ");
        localStringBuilder.append(paramDownloadInfo.q);
        LogUtility.c("DownloadManager_", localStringBuilder.toString());
        this.g.put(paramDownloadInfo.c, paramDownloadInfo);
        DownloadDBHelper.a().a(paramDownloadInfo);
      }
    }
    finally {}
  }
  
  public int g(String paramString)
  {
    Object localObject = d(paramString);
    if (localObject != null)
    {
      if (((DownloadInfo)localObject).j == 1) {
        localObject = ((DownloadInfo)localObject).k;
      } else {
        localObject = ((DownloadInfo)localObject).d;
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
  
  public void g()
  {
    try
    {
      Iterator localIterator = this.g.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if ((localDownloadInfo != null) && ((localDownloadInfo.a() == 2) || (localDownloadInfo.a() == 20))) {
          g(localDownloadInfo.c);
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
  
  public boolean g(DownloadInfo paramDownloadInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshDownloadInfo DownloadInfo=");
    ((StringBuilder)localObject).append(paramDownloadInfo);
    LogUtility.a("DownloadManager_", ((StringBuilder)localObject).toString());
    DownloadInfo localDownloadInfo = d(paramDownloadInfo.c);
    if (localDownloadInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshDownloadInfo cacheInfo =");
      ((StringBuilder)localObject).append(localDownloadInfo);
      LogUtility.a("DownloadManager_", ((StringBuilder)localObject).toString());
      if (localDownloadInfo.o == 0)
      {
        LogUtility.a("DownloadManager_", "refreshDownloadInfo DownloadInfo.DOWNLOAD_TYPE_DOWNLOADSDK......");
        paramDownloadInfo.z = localDownloadInfo.z;
        if (localDownloadInfo.j == 1) {
          localObject = localDownloadInfo.k;
        } else {
          localObject = localDownloadInfo.d;
        }
        localObject = b().h((String)localObject);
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshDownloadInfo sdk getReceiveDataLen=");
          localStringBuilder.append(((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen);
          localStringBuilder.append(" getTotalDataLen=");
          localStringBuilder.append(((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen);
          LogUtility.a("DownloadManager_", localStringBuilder.toString());
          paramDownloadInfo.t = ((int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen * 100.0F / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen));
          paramDownloadInfo.a(b(((TMAssistantDownloadTaskInfo)localObject).mState));
          paramDownloadInfo.o = 0;
          if (localDownloadInfo.j == 1)
          {
            if (TextUtils.isEmpty(localDownloadInfo.q)) {
              paramDownloadInfo.q = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
            } else {
              paramDownloadInfo.q = localDownloadInfo.q;
            }
          }
          else {
            paramDownloadInfo.q = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          }
          if (paramDownloadInfo.s == 4)
          {
            paramDownloadInfo.D = localDownloadInfo.D;
            if (paramDownloadInfo.D != 0)
            {
              paramDownloadInfo.s = 3;
              f(localDownloadInfo);
            }
          }
          return true;
        }
        this.g.remove(localDownloadInfo.c);
        DownloadDBHelper.a().b(localDownloadInfo.c);
        paramDownloadInfo.s = -100;
        return true;
      }
      if (localDownloadInfo.o == 1)
      {
        localObject = c(localDownloadInfo);
        if (localObject != null)
        {
          int i2 = b(((TMAssistantDownloadTaskInfo)localObject).mState);
          int i1 = i2;
          if (i2 == -2) {
            i1 = 3;
          }
          paramDownloadInfo.a(i1);
          paramDownloadInfo.o = 1;
          paramDownloadInfo.q = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          long l1 = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
          long l2 = ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen;
          paramDownloadInfo.t = ((int)((float)l1 * 100.0F / (float)l2));
          if (!MyAppApi.l().u()) {
            paramDownloadInfo.t = 0;
          }
          return true;
        }
        this.g.remove(localDownloadInfo.c);
        DownloadDBHelper.a().b(localDownloadInfo.c);
      }
    }
    return false;
  }
  
  public int h(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return -30;
    }
    ApkWriteCodeListener localApkWriteCodeListener = this.r;
    if (localApkWriteCodeListener != null) {
      return localApkWriteCodeListener.a(paramDownloadInfo.e, paramDownloadInfo.n, paramDownloadInfo.q, null);
    }
    this.r = null;
    return -40;
  }
  
  public TMAssistantDownloadTaskInfo h(String paramString)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = f().getDownloadTaskState(paramString);
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
  
  public void h()
  {
    try
    {
      Iterator localIterator = this.g.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if ((localDownloadInfo != null) && (localDownloadInfo.o == 1) && ((localDownloadInfo.a() == 2) || (localDownloadInfo.a() == 20)))
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
  
  protected DownloadInfo i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.g.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (((localDownloadInfo.j == 0) && (paramString.equals(localDownloadInfo.d))) || ((localDownloadInfo.j == 1) && (paramString.equals(localDownloadInfo.k))) || ((localDownloadInfo.j == 2) && (paramString.equals(localDownloadInfo.d)))) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  public ConcurrentLinkedQueue<DownloadListener> i()
  {
    try
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue = this.h;
      return localConcurrentLinkedQueue;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void i(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    ApkWriteCodeListener localApkWriteCodeListener = this.r;
    if (localApkWriteCodeListener != null)
    {
      localApkWriteCodeListener.a(paramDownloadInfo.e, paramDownloadInfo.n, null);
      return;
    }
    this.r = null;
  }
  
  public void j()
  {
    try
    {
      Iterator localIterator = this.h.iterator();
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
      d = null;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void j(DownloadInfo paramDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("patchNewApkSuccess DownloadInfo|");
    localStringBuilder.append(paramDownloadInfo);
    LogUtility.c("DownloadManager_", localStringBuilder.toString());
    m(paramDownloadInfo);
  }
  
  public void j(String paramString)
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
      LogUtility.c("DownloadManager_", "showToast>>>", paramString);
    }
  }
  
  protected void k()
  {
    if (this.g.size() > 200) {
      ThreadManager.getSubThreadHandler().postDelayed(new DownloadManager.18(this), 3000L);
    }
  }
  
  public boolean k(String paramString)
  {
    paramString = b().d(paramString);
    return (paramString != null) && (paramString.a() == 4);
  }
  
  public List<DownloadInfo> l(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = e(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (localDownloadInfo != null) {
          if (localDownloadInfo.o == 0)
          {
            if (localDownloadInfo.j == 1) {
              paramString = localDownloadInfo.k;
            } else {
              paramString = localDownloadInfo.d;
            }
            paramString = b().h(paramString);
            if (paramString != null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("queryDownloadInfosByVia sdk getReceiveDataLen=");
              localStringBuilder.append(paramString.mReceiveDataLen);
              localStringBuilder.append(" getTotalDataLen=");
              localStringBuilder.append(paramString.mTotalDataLen);
              LogUtility.a("DownloadManager_", localStringBuilder.toString());
              localDownloadInfo.t = ((int)((float)paramString.mReceiveDataLen * 100.0F / (float)paramString.mTotalDataLen));
              localDownloadInfo.a(b(paramString.mState));
              if (localDownloadInfo.j == 1)
              {
                if (TextUtils.isEmpty(localDownloadInfo.q)) {
                  localDownloadInfo.q = paramString.mSavePath;
                }
              }
              else {
                localDownloadInfo.q = paramString.mSavePath;
              }
              localArrayList.add(localDownloadInfo);
            }
            else
            {
              this.g.remove(localDownloadInfo.c);
              DownloadDBHelper.a().b(localDownloadInfo.c);
            }
          }
          else
          {
            this.g.remove(localDownloadInfo.c);
            DownloadDBHelper.a().b(localDownloadInfo.c);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public boolean l()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager
 * JD-Core Version:    0.7.0.1
 */