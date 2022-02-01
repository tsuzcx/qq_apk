package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.business.base.appreport.AppReportReceiver;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppActivity;
import mqq.app.Foreground;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyAppApi
  extends BaseMyAppApi
{
  protected static MyAppApi c;
  protected TMAssistantBaseCallYYB a;
  protected ITMAssistantCallBackListener b = new MyAppApi.QQDownloadListener(this);
  protected boolean d = false;
  protected boolean e = false;
  protected long f;
  protected long g = -1L;
  protected final long h = 180000L;
  protected DialogInterface.OnClickListener i;
  protected MyAppApi.InstallParams j;
  protected MyAppDialog k;
  protected boolean l = false;
  protected long m;
  boolean n = false;
  String o = "";
  protected boolean p = false;
  protected TMAssistantCallYYBParamStruct q;
  TMAssistantCallYYBParamStruct r;
  protected MyAppApi.YYBDownloadListener s = null;
  private boolean t = false;
  private boolean u = false;
  private final int v = 7090000;
  
  protected MyAppApi()
  {
    try
    {
      b();
    }
    catch (Throwable localThrowable)
    {
      LogUtility.c("MyAppApi", "MyAppApi init>>>", localThrowable);
    }
    i();
    C();
  }
  
  private void C()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    CommonDataAdapter.a().b().registerReceiver(new AppReportReceiver(), localIntentFilter);
  }
  
  private static boolean D()
  {
    return (E()) && (ControlPolicyUtil.q()) && (F());
  }
  
  private static boolean E()
  {
    return GlobalUtil.getInstance().getQQDownloaderVersionCode() >= 7512130;
  }
  
  private static boolean F()
  {
    return (Foreground.isCurrentProcessForeground()) || (ControlPolicyUtil.s());
  }
  
  private static void G()
  {
    YybWakeManager.a().b();
    OuterCallReportModel localOuterCallReportModel = I();
    localOuterCallReportModel.mComponentName = "com.live.watermelon.Instrumentation";
    b(localOuterCallReportModel);
  }
  
  private static void H()
  {
    if (!ControlPolicyUtil.r())
    {
      LogUtility.b("TAMST_WAKE", "preInit==not TmastWake");
      return;
    }
    LogUtility.b("TAMST_WAKE", "preInit==allow TmastWake");
    ThreadManager.executeOnSubThread(new MyAppApi.3());
  }
  
  @NonNull
  private static OuterCallReportModel I()
  {
    OuterCallReportModel localOuterCallReportModel = OuterCallReportModel.getDefaultModel();
    localOuterCallReportModel.mOuterCallMode = 0;
    localOuterCallReportModel.mOuterCallType = 1;
    localOuterCallReportModel.mOuterCallTime = System.currentTimeMillis();
    localOuterCallReportModel.mComponentName = "SplashActivity";
    return localOuterCallReportModel;
  }
  
  private static boolean J()
  {
    return (ControlPolicyUtil.m()) && (TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().b()) >= 7);
  }
  
  private boolean a(DownloadInfo paramDownloadInfo)
  {
    return (paramDownloadInfo != null) && (paramDownloadInfo.c.startsWith("1101070898"));
  }
  
  @NotNull
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "1101070898";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("1101070898_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static void b(OuterCallReportModel paramOuterCallReportModel)
  {
    GlobalUtil.getInstance().setContext(CommonDataAdapter.a().b());
    SDKReportManager2.getInstance().postReport(15, paramOuterCallReportModel.toString());
  }
  
  public static void e() {}
  
  public static void f()
  {
    e();
    ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.1(), 5000L);
  }
  
  public static void g()
  {
    ThreadManager.executeOnSubThread(new MyAppApi.2());
  }
  
  public static int h()
  {
    Object localObject = CommonDataAdapter.a().b();
    if (localObject == null) {
      return 1;
    }
    localObject = ((Context)localObject).getPackageManager();
    if (localObject == null) {
      return 1;
    }
    try
    {
      if (((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0) == null) {
        return 1;
      }
      int i1 = GlobalUtil.getInstance().getQQDownloaderAPILevel();
      if (2 > i1) {
        return 2;
      }
      return 0;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("yyb installed check error:");
      localStringBuilder.append(localNameNotFoundException.getMessage());
      LogUtility.e("TAMST_WAKE", localStringBuilder.toString());
    }
    return 1;
  }
  
  public static MyAppApi l()
  {
    try
    {
      if (c == null) {
        c = new MyAppApi();
      }
      g();
      MyAppApi localMyAppApi = c;
      return localMyAppApi;
    }
    finally {}
  }
  
  public static boolean m()
  {
    boolean bool = false;
    try
    {
      int i1 = h();
      if (i1 == 2) {
        return false;
      }
      if (i1 != 1) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      LogUtility.c("MyAppApi", "hasValidQQDownloader>>>", localException);
    }
    return false;
  }
  
  public static int n()
  {
    return TMAssistantCallYYB_V2.getQQDownloadApiLevel(BaseApplicationImpl.getApplication());
  }
  
  public static boolean r()
  {
    try
    {
      MyAppApi localMyAppApi = c;
      boolean bool;
      if (localMyAppApi != null) {
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
  
  protected int a()
  {
    int i1 = TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().b());
    if (!ApkUtils.a("com.tencent.android.qqdownloader", BaseActivity.sTopActivity)) {
      i1 = 3;
    }
    return i1;
  }
  
  protected long a(Bundle paramBundle)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--addDownloadTaskFromTmast--params = ");
      localStringBuilder.append(paramBundle);
      LogUtility.c("MyAppApi", localStringBuilder.toString());
      if (paramBundle == null) {
        return -1L;
      }
      paramBundle.getString("url");
      long l1 = d().addDownloadTaskFromTmast(paramBundle);
      return l1;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return -1L;
  }
  
  protected long a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--addDownloadTaskFromTaskList--params = ");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append("autoDownload = ");
    localStringBuilder.append(paramBoolean1);
    LogUtility.c("MyAppApi", localStringBuilder.toString());
    if (paramBundle == null) {
      return -1L;
    }
    paramBundle = d(paramBundle);
    this.r = paramBundle;
    return d().addDownloadTaskFromTaskList(paramBundle, paramBoolean1, paramBoolean1);
  }
  
  public DownloadInfo a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, Bundle paramBundle)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.o = 1;
    localDownloadInfo.c = paramTMAssistantCallYYBParamStruct.SNGAppId;
    localDownloadInfo.l = paramTMAssistantCallYYBParamStruct.taskAppId;
    localDownloadInfo.e = paramTMAssistantCallYYBParamStruct.taskPackageName;
    localDownloadInfo.m = paramTMAssistantCallYYBParamStruct.taskApkId;
    localDownloadInfo.n = paramTMAssistantCallYYBParamStruct.taskVersion;
    localDownloadInfo.J = paramTMAssistantCallYYBParamStruct.recommendId;
    localDownloadInfo.L = paramTMAssistantCallYYBParamStruct.channelId;
    if (paramBundle != null)
    {
      localDownloadInfo.h = paramBundle.getString(DownloadConstants.i);
      localDownloadInfo.f = paramBundle.getString(DownloadConstants.l);
      localDownloadInfo.d = paramBundle.getString(DownloadConstants.j);
      localDownloadInfo.p = paramBundle.getInt(DownloadConstants.G);
    }
    return localDownloadInfo;
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new MyAppApi.5(this, paramActivity));
  }
  
  protected void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString(DownloadConstants.p);
    int i2 = paramBundle.getInt("dialogType");
    int i3 = paramBundle.getInt("auto_start_yyb_download");
    LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog");
    LogUtility.c("MyAppApi", "-showTipDialog-");
    if (paramActivity == null) {
      return;
    }
    Resources localResources = paramActivity.getResources();
    int i1 = 1;
    if (paramInt2 == 1)
    {
      if (paramInt1 == 2) {
        paramInt1 = i1;
      } else if ((paramInt1 == 12) && (!TextUtils.isEmpty(paramString1))) {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      }
    }
    else
    {
      if (paramInt1 == 2) {}
      while ((paramInt1 != 12) || (TextUtils.isEmpty(paramString1)))
      {
        paramInt1 = 3;
        break;
      }
      paramInt1 = 4;
    }
    if (TextUtils.isEmpty(str)) {
      paramString2 = ControlPolicyUtil.a(paramInt1, paramString2);
    } else {
      paramString2 = str;
    }
    Object localObject = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4)
            {
              localObject = localResources.getString(2131888576);
            }
            else
            {
              paramString2 = localResources.getString(2131888579, new Object[] { paramString1 });
              break label269;
            }
          }
          else
          {
            paramString2 = localResources.getString(2131888578);
            break label269;
          }
        }
        else
        {
          paramString2 = localResources.getString(2131888577, new Object[] { paramString1 });
          break label269;
        }
      }
      else
      {
        paramString2 = localResources.getString(2131888576);
        break label269;
      }
    }
    paramString2 = (String)localObject;
    label269:
    if (paramInt1 != 2)
    {
      localObject = paramString2;
      if (paramInt1 != 4) {}
    }
    else
    {
      localObject = paramString2;
      if (TextUtils.isEmpty(str)) {
        try
        {
          localObject = String.format(paramString2, new Object[] { paramString1 });
        }
        catch (Exception paramString2)
        {
          if (paramInt1 == 2) {
            paramString1 = localResources.getString(2131888576);
          } else {
            paramString1 = localResources.getString(2131888578);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" errorMsg = ");
          ((StringBuilder)localObject).append(paramString2.getMessage());
          LogUtility.c("MyAppApi", ((StringBuilder)localObject).toString());
          localObject = paramString1;
        }
      }
    }
    str = localResources.getString(2131888596);
    paramString2 = (String)localObject;
    paramString1 = str;
    if (paramInt2 == 1)
    {
      paramString2 = (String)localObject;
      paramString1 = str;
      if (i2 == 1)
      {
        paramString1 = localResources.getString(2131888597);
        paramString2 = localResources.getString(2131888580);
      }
    }
    localObject = new MyAppDialog(paramActivity);
    ((MyAppDialog)localObject).b(2131888591, paramOnClickListener2, true);
    ((MyAppDialog)localObject).a(2131888594, paramOnClickListener1, paramBoolean ^ true);
    ((MyAppDialog)localObject).a(paramString1);
    ((MyAppDialog)localObject).b(paramString2);
    if (i2 == 1)
    {
      ((MyAppDialog)localObject).b(2131888591, Color.parseColor("#D2D1D1"), paramOnClickListener2, true);
      ((MyAppDialog)localObject).a(2131888594, Color.parseColor("#3AC8FF"), paramOnClickListener1, paramBoolean ^ true);
      ((MyAppDialog)localObject).a(paramActivity.getResources().getDrawable(2130842853));
      ((MyAppDialog)localObject).a(Color.parseColor("#848484"));
    }
    ((MyAppDialog)localObject).setCancelable(true);
    ((MyAppDialog)localObject).setOnCancelListener(paramOnCancelListener);
    ((MyAppDialog)localObject).setOnDismissListener(new MyAppApi.14(this));
    if (((paramActivity instanceof AppActivity)) && (!((AppActivity)paramActivity).isResume()))
    {
      LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog---cancel !isResume");
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        ((MyAppDialog)localObject).show();
        ReportController.b(null, "dc00898", "", "", "0X8008F7A", "0X8008F7A", 0, 0, "", "", "", "");
        if (i2 == 1)
        {
          paramActivity = paramBundle.getString(DownloadConstants.i);
          paramString1 = new StringBuilder();
          paramString1.append(paramBundle.getString("pageId"));
          paramString1.append("_");
          paramString1.append(paramBundle.getString("moduleId"));
          paramString1.append("_");
          paramString1.append(paramBundle.getString(DownloadConstants.f));
          paramString1.append("_");
          paramString1.append(paramBundle.getString(DownloadConstants.c));
          paramString1.append("_");
          paramString1.append(paramBundle.getString(DownloadConstants.d));
          AppCenterReporter.a("6006", "0", "0", paramActivity, paramString1.toString());
          if (i3 == 1) {
            ThreadManager.getUIHandler().post(new MyAppApi.15(this, paramOnClickListener1, (MyAppDialog)localObject));
          }
        }
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog---complete");
    this.k = ((MyAppDialog)localObject);
  }
  
  protected void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    boolean bool = ControlPolicyUtil.g();
    long l1 = CommonDataAdapter.a().c();
    int i1;
    if ((bool) && (l1 > 0L) && (l1 != this.m)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      if (this.q != null)
      {
        if (a() <= 2) {
          ((TMAssistantCallYYB_V1)d()).startToAuthorized(paramActivity, this.q, "2");
        } else {
          ((TMAssistantCallYYB_V2)d()).startToAuthorized(paramActivity, this.q, "2");
        }
        this.q = null;
        return;
      }
      LogUtility.e("MyAppApi", "startToAuthorizedDirect mLastAuthorizeParam = null, needCarryQQIdentity = false");
      return;
    }
    TicketUtils localTicketUtils = new TicketUtils();
    localTicketUtils.a(new MyAppApi.17(this, localTicketUtils, l1, paramActivity, paramOnClickListener));
    if ((paramActivity instanceof BaseActivity)) {
      localTicketUtils.a(((BaseActivity)paramActivity).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--handleDownloadAction");
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_HandleDownloadAction", System.currentTimeMillis());
    }
    int i1;
    try
    {
      i1 = d().checkQQDownloaderInstalled();
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      i1 = -1;
    }
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.g, false);
    boolean bool3 = paramBundle.getBoolean(DownloadConstants.h, true);
    int i3 = paramBundle.getInt(DownloadConstants.n);
    int i2 = paramBundle.getInt(DownloadConstants.k);
    String str2 = paramBundle.getString(DownloadConstants.i);
    String str1 = paramBundle.getString(DownloadConstants.b);
    int i4 = paramBundle.getInt("dialogType");
    int i5 = paramBundle.getInt(DownloadConstants.u, 0);
    int i6 = paramBundle.getInt(DownloadConstants.v, 0);
    boolean bool4 = ControlPolicyUtil.h();
    boolean bool5 = ControlPolicyUtil.k();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" useMyAppFlag = ");
    ((StringBuilder)localObject).append(bool4);
    LogUtility.c("OpenConfig-MyAppApi", ((StringBuilder)localObject).toString());
    localObject = DownloadManager.b().d(str1);
    boolean bool1;
    if ((localObject != null) && (((DownloadInfo)localObject).o == 1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (((!bool4) || (!bool5)) && (!bool1))
    {
      if (paramOnClickListener != null)
      {
        paramActivity = new StringBuilder();
        paramActivity.append("allowMyApp=");
        paramActivity.append(bool4);
        paramActivity.append(" allowMyAppDownload=");
        paramActivity.append(bool5);
        paramActivity.append(" taskExist=");
        paramActivity.append(bool1);
        LogUtility.a("MyAppApi", paramActivity.toString());
        paramOnClickListener.onClick(null, 0);
      }
      StaticAnalyz.a("200", str2, str1);
      return;
    }
    if ((i1 != 2) && (i1 != 1))
    {
      if (i1 == 0)
      {
        if ((!ControlPolicyUtil.l()) && (!bool1))
        {
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(null, 0);
          }
          StaticAnalyz.a("200", str2, str1);
          return;
        }
        paramOnClickListener = StaticAnalyz.a(str2, "YYB");
        if (i3 == 0) {
          a(paramActivity, paramBundle, bool2, bool3);
        } else {
          b(paramActivity, paramBundle, bool2, bool3);
        }
        if ((localObject == null) && ((i2 == 2) || (i2 == 12)))
        {
          StaticAnalyz.a("202", paramOnClickListener, str1);
          return;
        }
        StaticAnalyz.a("200", paramOnClickListener, str1);
      }
    }
    else
    {
      localObject = this.k;
      if ((localObject != null) && (((MyAppDialog)localObject).isShowing())) {
        if (this.k.a() == paramActivity)
        {
          LogUtility.a("MyAppApi", "mTipDialog is showing return");
          return;
        }
      }
    }
    try
    {
      this.k.dismiss();
      label494:
      this.k = null;
      break label507;
      this.k = null;
      label507:
      if ((ControlPolicyUtil.i()) && ((i2 == 2) || (i2 == 12)))
      {
        ThreadManager.getSubThreadHandler().post(new MyAppApi.7(this, str2, str1));
        bool4 = ControlPolicyUtil.a();
        MyAppApi.8 local8 = new MyAppApi.8(this, bool2, paramOnClickListener, paramBundle, i3, bool4, paramActivity, str2, str1, bool1, bool3, i4);
        MyAppApi.ClickListenerProxy localClickListenerProxy = new MyAppApi.ClickListenerProxy(this, paramOnClickListener, str2, str1);
        MyAppApi.BackListener localBackListener = new MyAppApi.BackListener(this, str2, str1);
        if ((i6 > 0) && (i5 > 0))
        {
          i3 = i6 - i5;
          if (i3 > 0)
          {
            localObject = YybHandleUtil.a(i3);
            break label646;
          }
        }
        localObject = null;
        String str3 = paramBundle.getString("source");
        ThreadManager.getUIHandler().post(new MyAppApi.9(this, paramActivity, i2, i1, (String)localObject, local8, localClickListenerProxy, localBackListener, str3, bool4, paramBundle));
        ThreadManager.getSubThreadHandler().post(new MyAppApi.10(this, str2, str1));
        this.i = paramOnClickListener;
        return;
      }
      label646:
      paramActivity = new StringBuilder();
      paramActivity.append("not allowShowDialog return actionCode = ");
      paramActivity.append(i2);
      LogUtility.a("MyAppApi", paramActivity.toString());
      if (paramOnClickListener != null) {
        paramOnClickListener.onClick(null, 0);
      }
      StaticAnalyz.a("200", str2, str1);
      return;
    }
    catch (Exception localException2)
    {
      break label494;
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    LogUtility.c("NewUpgradeDialog", "preDownload called,get updateDetail info");
    ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.20(this, paramActivity), 0L);
  }
  
  protected void a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    LogUtility.c("MyAppApi", "downloadYyb");
    if (paramInt == 1) {
      DownloadApi.a("_1101070898");
    }
    if (this.s == null)
    {
      this.s = new MyAppApi.YYBDownloadListener(this);
      DownloadManager.b().a(this.s);
    }
    Object localObject = b(paramString2);
    localObject = DownloadManager.b().d((String)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("---startDownloadYYB---");
    localStringBuilder.append(localObject);
    LogUtility.c("MyAppApi", localStringBuilder.toString());
    if (localObject != null)
    {
      if (paramInt == 1)
      {
        ((DownloadInfo)localObject).w = false;
        ((DownloadInfo)localObject).x = true;
        ((DownloadInfo)localObject).z = 1;
      }
      else
      {
        ((DownloadInfo)localObject).w = true;
        ((DownloadInfo)localObject).x = false;
        ((DownloadInfo)localObject).z = 0;
      }
      ((DownloadInfo)localObject).h = paramString1;
      DownloadManager.b().f((DownloadInfo)localObject);
      DownloadManager.b().a((DownloadInfo)localObject);
      return;
    }
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = ControlPolicyUtil.c();
    }
    localObject = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      localObject = "https://a.app.qq.com/o/myapp-down?g_f=991310";
    }
    a(paramActivity, (String)localObject, paramString1, paramInt, paramString2, false);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2)
  {
    boolean bool = "biz_src_yyb".equals(paramString2);
    long l1 = 0L;
    if (!bool)
    {
      l1 = ControlPolicyUtil.e();
      if (l1 <= 0L) {
        l1 = 2000L;
      }
    }
    ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.19(this, paramActivity, paramString1), l1);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    LogUtility.c("MyAppApi", "startDownloadYyb");
    Bundle localBundle = new Bundle();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "https://a.app.qq.com/o/myapp-down?g_f=991310";
    }
    localBundle.putString(DownloadConstants.b, b(paramString3));
    localBundle.putString(DownloadConstants.j, str);
    localBundle.putString(DownloadConstants.f, "com.tencent.android.qqdownloader");
    localBundle.putInt(DownloadConstants.k, 2);
    localBundle.putString(DownloadConstants.i, paramString2);
    localBundle.putString(DownloadConstants.l, YybHandleUtil.d);
    if (paramInt == 1) {
      localBundle.putBoolean(DownloadConstants.y, true);
    } else {
      localBundle.putBoolean(DownloadConstants.y, false);
    }
    localBundle.putInt(DownloadConstants.E, paramInt);
    localBundle.putString(DownloadConstants.m, "yyb");
    localBundle.putString(DownloadConstants.c, "5848");
    localBundle.putBoolean(DownloadConstants.g, true);
    localBundle.putBoolean(DownloadConstants.h, paramBoolean);
    localBundle.putInt(DownloadConstants.n, 1);
    DownloadApi.a(paramActivity, localBundle, "biz_src_yyb", null, 0);
  }
  
  public void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.21(this, paramBoolean, paramActivity, paramString), 0L);
  }
  
  public void a(Context paramContext, JSONArray paramJSONArray, int paramInt, String paramString1, String paramString2)
  {
    if (paramJSONArray == null) {
      return;
    }
    int i2 = paramJSONArray.length();
    if (i2 == 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < i2)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i1);
      if (localJSONObject != null)
      {
        TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = new TMAssistantCallYYBParamStruct();
        localTMAssistantCallYYBParamStruct.recommendId = localJSONObject.optString("recommendId");
        localTMAssistantCallYYBParamStruct.channelId = localJSONObject.optString(DownloadConstants.M);
        localTMAssistantCallYYBParamStruct.taskPackageName = localJSONObject.optString(DownloadConstants.f);
        localTMAssistantCallYYBParamStruct.taskVersion = localJSONObject.optInt(DownloadConstants.e);
        localTMAssistantCallYYBParamStruct.via = localJSONObject.optString(DownloadConstants.i);
        localTMAssistantCallYYBParamStruct.taskApkId = localJSONObject.optString(DownloadConstants.d);
        localTMAssistantCallYYBParamStruct.taskAppId = localJSONObject.optString(DownloadConstants.c);
        localTMAssistantCallYYBParamStruct.SNGAppId = localJSONObject.optString(DownloadConstants.c);
        if (TextUtils.isEmpty(localTMAssistantCallYYBParamStruct.SNGAppId)) {
          localTMAssistantCallYYBParamStruct.SNGAppId = localJSONObject.optString(DownloadConstants.b);
        }
        if (TextUtils.isEmpty(localTMAssistantCallYYBParamStruct.via)) {
          localTMAssistantCallYYBParamStruct.via = paramString1;
        }
        localTMAssistantCallYYBParamStruct.source = paramString2;
        localArrayList.add(localTMAssistantCallYYBParamStruct);
      }
      i1 += 1;
    }
    if (paramInt == 2) {
      paramInt = 3;
    } else {
      paramInt = 2;
    }
    ThreadManager.excute(new MyAppApi.11(this, paramContext, localArrayList, paramInt, paramString1), 16, null, true);
  }
  
  protected void a(String paramString)
  {
    DownloadManager localDownloadManager = DownloadManager.b();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString;
    localDownloadInfo.a(10);
    localDownloadManager.a(10, localDownloadInfo);
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new MyAppApi.16(this, paramString, paramOnClickListener, paramActivity));
  }
  
  public void a(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.n = paramBoolean;
    this.o = paramString;
    if (this.n)
    {
      SharedPreferences.Editor localEditor = CommonDataAdapter.a().b().getSharedPreferences("showTost_pf", 0).edit();
      localEditor.putBoolean("showToast", this.n);
      localEditor.putString("toast_msg", paramString);
      localEditor.commit();
    }
  }
  
  public boolean a(Context paramContext, Bundle paramBundle)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--startToWebView");
    if (paramBundle == null) {
      return false;
    }
    paramBundle = paramBundle.getString("url");
    LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
    d().startToWebView(paramContext, paramBundle);
    return true;
  }
  
  public boolean a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = paramBoolean1;
    LogUtility.c("TIME-STATISTIC", "MyAppApi--startToAppDetail ");
    if (paramBundle == null) {
      return false;
    }
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramContext) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_StartToAppDetail", System.currentTimeMillis());
    }
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = d(paramBundle);
    if (!DownloadApi.c(localTMAssistantCallYYBParamStruct.SNGAppId)) {
      return false;
    }
    boolean bool2 = ControlPolicyUtil.g();
    long l1 = CommonDataAdapter.a().c();
    int i1;
    if ((bool2) && (l1 > 0L) && (l1 != this.m)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 != 0) && (paramContext != null))
    {
      bool2 = paramContext instanceof BaseActivity;
      if (bool2)
      {
        localObject = new TicketUtils();
        ((TicketUtils)localObject).a(new MyAppApi.12(this, (TicketUtils)localObject, localTMAssistantCallYYBParamStruct, paramBundle, l1, paramContext, paramBoolean1, paramBoolean2));
        if (bool2) {
          ((TicketUtils)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
        }
        return true;
      }
    }
    Object localObject = a(localTMAssistantCallYYBParamStruct, paramBundle);
    DownloadManager.b().f((DownloadInfo)localObject);
    for (;;)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OpenSDK startToAppDetail param SNGAppId=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.SNGAppId);
        ((StringBuilder)localObject).append(" apkId=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.taskApkId);
        ((StringBuilder)localObject).append(" taskAppId=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.taskAppId);
        ((StringBuilder)localObject).append(" source=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.source);
        ((StringBuilder)localObject).append(" packageName=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.taskPackageName);
        ((StringBuilder)localObject).append(" version=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.taskVersion);
        ((StringBuilder)localObject).append(" uin=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.uin);
        ((StringBuilder)localObject).append(" via=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.via);
        ((StringBuilder)localObject).append(" autoDownload=");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" autoInstall=");
        ((StringBuilder)localObject).append(paramBoolean2);
        LogUtility.a("State_Log", ((StringBuilder)localObject).toString());
        LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
        if (a() <= 2)
        {
          ((TMAssistantCallYYB_V1)d()).startToAppDetail(paramContext, localTMAssistantCallYYBParamStruct, bool1, paramBoolean2);
        }
        else
        {
          i1 = paramBundle.getInt(DownloadConstants.k);
          int i2 = e(paramBundle);
          if (i1 != 3) {
            break label515;
          }
          paramBoolean1 = false;
          bool1 = false;
          ((TMAssistantCallYYB_V2)d()).startToAppDetail(paramContext, localTMAssistantCallYYBParamStruct, bool1, paramBoolean1, i2);
        }
      }
      catch (Exception paramContext)
      {
        LogUtility.b("MyAppApi", "startToAppDetail err", paramContext);
        return false;
      }
      return true;
      label515:
      paramBoolean1 = paramBoolean2;
    }
  }
  
  protected long b(Bundle paramBundle)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--addDownloadTaskFromAppDetail--params = ");
      ((StringBuilder)localObject).append(paramBundle);
      LogUtility.c("MyAppApi", ((StringBuilder)localObject).toString());
      if (paramBundle == null) {
        return -1L;
      }
      localObject = paramBundle.getString("url");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if ((!((String)localObject).startsWith("tmast")) && (!((String)localObject).startsWith("tpmast"))) {
          return d().addDownloadTaskFromWebview(paramBundle);
        }
        long l1 = d().addDownloadTaskFromTmast(paramBundle);
        return l1;
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return -1L;
  }
  
  protected long b(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--addDownloadTaskFromAppDetail--params = ");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append("autoDownload = ");
    localStringBuilder.append(paramBoolean1);
    LogUtility.c("MyAppApi", localStringBuilder.toString());
    if (paramBundle == null) {
      return -1L;
    }
    paramBundle = d(paramBundle);
    this.r = paramBundle;
    return d().addDownloadTaskFromAppDetail(paramBundle, paramBoolean1, paramBoolean1);
  }
  
  public void b()
  {
    if (a() <= 2) {
      this.a = TMAssistantCallYYB_V1.getInstance();
    } else {
      this.a = TMAssistantCallYYB_V2.getInstance();
    }
    this.a.initTMAssistantCallYYBApi(CommonDataAdapter.a().b());
    q();
  }
  
  protected void b(Activity paramActivity)
  {
    long l1 = System.currentTimeMillis() - this.g;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("judgeInstallFlag -- mInstalledFlag = ");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("mInstallTime = ");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append(" countTime =");
    ((StringBuilder)localObject).append(l1);
    LogUtility.c("MyAppApi", ((StringBuilder)localObject).toString());
    int i1;
    if (this.d)
    {
      if ((this.g != -1L) && (l1 <= 180000L)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (m())
      {
        if (!j()) {
          this.e = false;
        } else {
          this.e = true;
        }
        if ((this.e) || (i1 != 0)) {
          break label409;
        }
        if (this.f != -1L) {
          d().removeDownloadTask(this.f);
        }
        if (ControlPolicyUtil.l())
        {
          localObject = this.j;
          if (localObject != null) {
            if (((MyAppApi.InstallParams)localObject).e == 0) {
              a(paramActivity, this.j.a, this.j.b, this.j.c);
            } else {
              b(paramActivity, this.j.a, this.j.b, this.j.c);
            }
          }
        }
        else if (i1 == 0)
        {
          paramActivity = this.i;
          if (paramActivity != null) {
            paramActivity.onClick(null, 0);
          }
        }
      }
    }
    try
    {
      paramActivity = new StringBuilder();
      paramActivity.append(CommonDataAdapter.a().b().getFilesDir());
      paramActivity.append(File.separator);
      paramActivity.append("yyb_via_info.txt");
      if (new File(paramActivity.toString()).exists()) {
        CommonDataAdapter.a().b().deleteFile("yyb_via_info.txt");
      }
      label354:
      if ((!this.e) && (i1 == 0))
      {
        if (this.f != -1L) {
          d().removeDownloadTask(this.f);
        }
        if (i1 == 0)
        {
          paramActivity = this.i;
          if (paramActivity != null) {
            paramActivity.onClick(null, 0);
          }
        }
      }
      label409:
      k();
      if ((!this.n) && (!m()))
      {
        paramActivity = CommonDataAdapter.a().b().getSharedPreferences("showTost_pf", 0);
        this.n = paramActivity.getBoolean("showToast", false);
        this.o = paramActivity.getString("toast_msg", "");
      }
      if (this.n)
      {
        if (!m()) {
          new Handler(Looper.getMainLooper()).postDelayed(new MyAppApi.6(this), 2000L);
        }
        this.n = false;
        paramActivity = CommonDataAdapter.a().b().getSharedPreferences("showTost_pf", 0).edit();
        paramActivity.putBoolean("showToast", this.n);
        paramActivity.commit();
      }
      return;
    }
    catch (Exception paramActivity)
    {
      break label354;
    }
  }
  
  public void b(Activity paramActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_HandleDownloadAction", System.currentTimeMillis());
    }
    int i1 = -1;
    int i2;
    try
    {
      i2 = d().checkQQDownloaderInstalled();
      i1 = i2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    boolean bool1 = paramBundle.getBoolean(DownloadConstants.g, false);
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.h, true);
    int i3 = paramBundle.getInt(DownloadConstants.n);
    int i4 = paramBundle.getInt(DownloadConstants.k);
    boolean bool3 = ControlPolicyUtil.h();
    boolean bool4 = ControlPolicyUtil.k();
    String str1 = paramBundle.getString(DownloadConstants.b);
    String str2 = paramBundle.getString(DownloadConstants.i);
    DownloadInfo localDownloadInfo = DownloadManager.b().d(str1);
    if ((localDownloadInfo != null) && (localDownloadInfo.o == 1)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" useMyAppFlag = ");
    localStringBuilder.append(bool3);
    LogUtility.c("OpenConfig-MyAppApi", localStringBuilder.toString());
    if (((!bool3) || (!bool4)) && (i2 == 0))
    {
      if (paramOnClickListener != null) {
        paramOnClickListener.onClick(null, 0);
      }
      StaticAnalyz.a("200", str2, str1);
      return;
    }
    if ((i1 != 2) && (i1 != 1))
    {
      if ((!ControlPolicyUtil.l()) && (i2 == 0))
      {
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(null, 0);
        }
        StaticAnalyz.a("200", str2, str1);
        return;
      }
      if (i3 == 0) {
        a(paramActivity, paramBundle, bool1, bool2);
      } else {
        b(paramActivity, paramBundle, bool1, bool2);
      }
      paramActivity = StaticAnalyz.a(str2, "YYB");
      if ((localDownloadInfo == null) && ((i4 == 2) || (i4 == 12)))
      {
        StaticAnalyz.a("202", paramActivity, str1);
        return;
      }
      StaticAnalyz.a("200", paramActivity, str1);
      return;
    }
    if (paramOnClickListener != null) {
      paramOnClickListener.onClick(null, 0);
    }
    StaticAnalyz.a("202", str2, str1);
  }
  
  protected void b(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--startToDownloadTaskList");
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramContext) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_StartToDownloadList", System.currentTimeMillis());
    }
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct;
    int i1;
    Object localObject;
    if (paramBundle != null)
    {
      if (paramContext == null) {
        return;
      }
      localTMAssistantCallYYBParamStruct = d(paramBundle);
      boolean bool = ControlPolicyUtil.g();
      long l1 = CommonDataAdapter.a().c();
      if ((bool) && (l1 > 0L) && (l1 != this.m)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((i1 != 0) && (paramContext != null))
      {
        bool = paramContext instanceof BaseActivity;
        if (bool)
        {
          localObject = new TicketUtils();
          ((TicketUtils)localObject).a(new MyAppApi.13(this, (TicketUtils)localObject, localTMAssistantCallYYBParamStruct, paramBundle, l1, paramContext, paramBoolean1, paramBoolean2));
          if (!bool) {
            break label460;
          }
          ((TicketUtils)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
          return;
        }
      }
      localObject = a(localTMAssistantCallYYBParamStruct, paramBundle);
      DownloadManager.b().f((DownloadInfo)localObject);
    }
    label460:
    label461:
    for (;;)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OpenSDK startToDownloadTaskList param SNGAppId=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.SNGAppId);
        ((StringBuilder)localObject).append(" apkId=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.taskApkId);
        ((StringBuilder)localObject).append(" taskAppId=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.taskAppId);
        ((StringBuilder)localObject).append(" packageName=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.taskPackageName);
        ((StringBuilder)localObject).append(" version=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.taskVersion);
        ((StringBuilder)localObject).append(" uin=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.uin);
        ((StringBuilder)localObject).append(" via=");
        ((StringBuilder)localObject).append(localTMAssistantCallYYBParamStruct.via);
        LogUtility.a("State_Log", ((StringBuilder)localObject).toString());
        LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
        if (a() <= 2)
        {
          ((TMAssistantCallYYB_V1)d()).startToDownloadTaskList(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2);
          return;
        }
        i1 = paramBundle.getInt(DownloadConstants.k);
        int i2 = e(paramBundle);
        if (i1 != 3) {
          break label461;
        }
        paramBoolean1 = false;
        paramBoolean2 = false;
        ((TMAssistantCallYYB_V2)d()).startToDownloadTaskList(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, i2);
        return;
      }
      catch (Exception paramContext)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("--startToDownloadTaskList--Exception = ");
        paramBundle.append(paramContext);
        LogUtility.e("MyAppApi", paramBundle.toString());
      }
      return;
    }
  }
  
  protected void b(String paramString, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      String str1 = localJSONObject.optString("appid", "");
      localJSONObject.optString("myAppid", "");
      localJSONObject.optString("apkId", "");
      Object localObject2 = localJSONObject.optString("versionCode", "");
      String str2 = localJSONObject.optString("via", "");
      localJSONObject.optString("appPackageName", "");
      String str3 = localJSONObject.optString("appName", HardCodeUtil.a(2131904922));
      localJSONObject.optString("channelId", "");
      Object localObject1 = localJSONObject.optString("appAuthorizedStr", "");
      Bundle localBundle = new Bundle();
      paramString = (String)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        paramString = "1";
      }
      int i1 = Integer.parseInt(paramString);
      localBundle.putString(DownloadConstants.b, localJSONObject.optString("appid", ""));
      localBundle.putString(DownloadConstants.c, localJSONObject.optString("myAppid", ""));
      localBundle.putString(DownloadConstants.d, localJSONObject.optString("apkId"));
      localBundle.putInt(DownloadConstants.e, i1);
      localBundle.putString(DownloadConstants.f, localJSONObject.optString("appPackageName"));
      localBundle.putString(DownloadConstants.i, localJSONObject.optString("via"));
      localBundle.putString(DownloadConstants.l, localJSONObject.optString("appName"));
      localBundle.putString(DownloadConstants.B, localJSONObject.optString("channelId"));
      localBundle.putString(DownloadConstants.D, localJSONObject.optString("channel"));
      localBundle.putString(DownloadConstants.w, localJSONObject.optString("uin"));
      this.q = d(localBundle);
      this.q.actionFlag = "2";
      if (m())
      {
        a(paramActivity, paramOnClickListener);
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramString = (String)localObject1;
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(str3);
        paramString.append(HardCodeUtil.a(2131904919));
        paramString = paramString.toString();
      }
      boolean bool = ControlPolicyUtil.a();
      localObject1 = new MyAppApi.18(this, localBundle, bool, paramActivity, str2, paramOnClickListener, str1);
      paramOnClickListener = new MyAppApi.ClickListenerProxy(this, paramOnClickListener, str2, str1);
      localObject2 = new MyAppApi.BackListener(this, str2, str1);
      localBundle.putString(DownloadConstants.p, paramString);
      a(paramActivity, 1, 1, "0", (DialogInterface.OnClickListener)localObject1, paramOnClickListener, (DialogInterface.OnCancelListener)localObject2, "biz_src_yyb", bool, localBundle);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean b(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return false;
    }
    LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToDownloadListWithParams");
    d().startToDownloadTaskListWithParams(paramContext, paramBundle);
    return true;
  }
  
  public TMAssistantDownloadTaskInfo c(Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramBundle != null)
    {
      if (!m()) {
        return null;
      }
      paramBundle = d(paramBundle);
      if (a() <= 2)
      {
        localObject1 = ((TMAssistantCallYYB_V1)d()).getDownloadTaskState(paramBundle);
        paramBundle = localObject2;
        if (localObject1 != null) {
          paramBundle = new TMAssistantDownloadTaskInfo(((TMAssistantCallYYBTaskInfo)localObject1).mUrl, ((TMAssistantCallYYBTaskInfo)localObject1).mSavePath, ((TMAssistantCallYYBTaskInfo)localObject1).mState, ((TMAssistantCallYYBTaskInfo)localObject1).mReceiveDataLen, ((TMAssistantCallYYBTaskInfo)localObject1).mTotalDataLen, ((TMAssistantCallYYBTaskInfo)localObject1).mContentType);
        }
        return paramBundle;
      }
      paramBundle = ((TMAssistantCallYYB_V2)d()).getDownloadTaskState(paramBundle);
      localObject1 = localObject3;
      if (paramBundle != null) {
        localObject1 = new TMAssistantDownloadTaskInfo(paramBundle.mUrl, paramBundle.mSavePath, paramBundle.mState, paramBundle.mReceiveDataLen, paramBundle.mTotalDataLen, paramBundle.mContentType);
      }
    }
    return localObject1;
  }
  
  public void c()
  {
    this.a = TMAssistantCallYYB_V2.getInstance();
    this.a.initTMAssistantCallYYBApi(CommonDataAdapter.a().b());
    q();
  }
  
  public void c(Activity paramActivity)
  {
    new YybHandleUtil.InstallBaseTask(paramActivity, null).execute(new Void[0]);
  }
  
  protected TMAssistantCallYYBParamStruct d(Bundle paramBundle)
  {
    String str2 = paramBundle.getString(DownloadConstants.b);
    String str3 = paramBundle.getString(DownloadConstants.c);
    String str4 = paramBundle.getString(DownloadConstants.d);
    String str5 = paramBundle.getString(DownloadConstants.f);
    Object localObject1 = paramBundle.getString(DownloadConstants.i);
    int i2 = paramBundle.getInt(DownloadConstants.e);
    int i1 = i2;
    if (i2 == 0) {}
    try
    {
      i1 = Integer.valueOf(paramBundle.getString(DownloadConstants.e)).intValue();
      String str1;
      if (this.d) {
        str1 = StaticAnalyz.a((String)localObject1, "NEWYYB");
      } else {
        str1 = StaticAnalyz.a((String)localObject1, "YYB");
      }
      paramBundle.getString(DownloadConstants.B);
      Object localObject2 = paramBundle.getString(DownloadConstants.D);
      i2 = paramBundle.getInt(DownloadConstants.C);
      if (i2 == 1) {
        localObject2 = "ANDROIDQQ-gray";
      }
      Object localObject3;
      for (localObject1 = "1";; localObject1 = ((StringBuilder)localObject1).toString())
      {
        localObject3 = localObject1;
        localObject1 = localObject2;
        break;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(i2);
          ((StringBuilder)localObject1).append("");
          localObject3 = ((StringBuilder)localObject1).toString();
          localObject1 = "ANDROIDQQ";
          break;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(i2);
        ((StringBuilder)localObject1).append("");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" channelId:");
      ((StringBuilder)localObject2).append((String)localObject1);
      LogUtility.b("State_Log", ((StringBuilder)localObject2).toString());
      localObject1 = new TMAssistantCallYYBParamStruct(str2, str3, str4, i1, str1, str5, "", "", (String)localObject1, (String)localObject3);
      if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().b()) >= 6)
      {
        ((TMAssistantCallYYBParamStruct)localObject1).timePointMap.put("OuterCall_JS_DoDownloadAction", Long.valueOf(paramBundle.getLong("OuterCall_JS_DoDownloadAction", 0L)));
        ((TMAssistantCallYYBParamStruct)localObject1).timePointMap.put("OuterCall_DownloadApi_DoDownloadAction", Long.valueOf(paramBundle.getLong("OuterCall_DownloadApi_DoDownloadAction", 0L)));
        ((TMAssistantCallYYBParamStruct)localObject1).timePointMap.put("OuterCall_DownloadApi_DoDownloadActionByMyApp", Long.valueOf(paramBundle.getLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", 0L)));
        ((TMAssistantCallYYBParamStruct)localObject1).timePointMap.put("OuterCall_MyAppApi_HandleDownloadAction", Long.valueOf(paramBundle.getLong("OuterCall_MyAppApi_HandleDownloadAction", 0L)));
        ((TMAssistantCallYYBParamStruct)localObject1).timePointMap.put("OuterCall_MyAppApi_StartToAppDetail", Long.valueOf(paramBundle.getLong("OuterCall_MyAppApi_StartToAppDetail", 0L)));
        ((TMAssistantCallYYBParamStruct)localObject1).timePointMap.put("OuterCall_MyAppApi_StartToDownloadList", Long.valueOf(paramBundle.getLong("OuterCall_MyAppApi_StartToDownloadList", 0L)));
      }
      ((TMAssistantCallYYBParamStruct)localObject1).source = paramBundle.getString("big_brother_source_key");
      ((TMAssistantCallYYBParamStruct)localObject1).recommendId = paramBundle.getString("recommendId");
      paramBundle = new StringBuilder();
      paramBundle.append("recommendId:");
      paramBundle.append(((TMAssistantCallYYBParamStruct)localObject1).recommendId);
      LogUtility.b("MyAppApi", paramBundle.toString());
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
  }
  
  protected TMAssistantBaseCallYYB d()
  {
    try
    {
      if (this.a == null) {
        b();
      }
      TMAssistantBaseCallYYB localTMAssistantBaseCallYYB = this.a;
      return localTMAssistantBaseCallYYB;
    }
    finally {}
  }
  
  protected void d(Activity paramActivity)
  {
    if ((this.p) && (this.q != null))
    {
      if (!j())
      {
        l();
        if (m())
        {
          if (this.f != -1L) {
            d().removeDownloadTask(this.f);
          }
          a(paramActivity, null);
        }
      }
      this.p = false;
      k();
      return;
    }
    this.p = false;
    this.q = null;
    k();
  }
  
  protected int e(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt(DownloadConstants.k) == 3)) {
      return 2;
    }
    return 1;
  }
  
  protected void i()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    MyAppApi.4 local4 = new MyAppApi.4(this);
    CommonDataAdapter.a().b().registerReceiver(local4, localIntentFilter);
  }
  
  protected boolean j()
  {
    return TMAssistantCallYYB_V1.isExistActoin(this.f) ^ true;
  }
  
  protected void k()
  {
    LogUtility.c("MyAppApi", "clearInstallParam");
    this.i = null;
    this.j = null;
    this.d = false;
    this.e = false;
    this.r = null;
  }
  
  public void o()
  {
    this.m = 0L;
  }
  
  public boolean p()
  {
    return (m()) && (ControlPolicyUtil.h()) && (ControlPolicyUtil.l());
  }
  
  protected void q()
  {
    d().registerListener(this.b);
  }
  
  public void s()
  {
    try
    {
      this.a.unregisterListener(this.b);
      this.a.destroyQQDownloaderOpenSDK();
    }
    catch (Exception localException)
    {
      LogUtility.a("MyAppApi", "onDestroy>>>", localException);
    }
    try
    {
      c = null;
      return;
    }
    finally {}
  }
  
  public String t()
  {
    MyAppApi.InstallParams localInstallParams = this.j;
    if ((localInstallParams != null) && (localInstallParams.a != null)) {
      return this.j.a.getString(DownloadConstants.b);
    }
    return "";
  }
  
  public boolean u()
  {
    return a() > 2;
  }
  
  public boolean v()
  {
    return this.u;
  }
  
  public boolean w()
  {
    Object localObject = BaseActivity.sTopActivity.getPackageManager();
    boolean bool = false;
    if (localObject != null) {
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0);
        if (localObject != null)
        {
          int i1 = ((PackageInfo)localObject).versionCode;
          if (i1 >= 7090000) {
            bool = true;
          }
          return bool;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi
 * JD-Core Version:    0.7.0.1
 */