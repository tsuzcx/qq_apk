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
  protected static MyAppApi a;
  private final int jdField_a_of_type_Int = 7090000;
  protected long a;
  protected DialogInterface.OnClickListener a;
  protected MyAppApi.InstallParams a;
  protected MyAppApi.YYBDownloadListener a;
  protected MyAppDialog a;
  protected ITMAssistantCallBackListener a;
  protected TMAssistantCallYYBParamStruct a;
  protected TMAssistantBaseCallYYB a;
  String jdField_a_of_type_JavaLangString = "";
  protected boolean a;
  protected long b;
  TMAssistantCallYYBParamStruct b;
  protected boolean b;
  protected final long c;
  protected boolean c;
  protected long d;
  boolean d;
  protected boolean e = false;
  private boolean f = false;
  private boolean g = false;
  
  protected MyAppApi()
  {
    this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener = new MyAppApi.QQDownloadListener(this);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Long = 180000L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = null;
    try
    {
      a();
    }
    catch (Throwable localThrowable)
    {
      LogUtility.c("MyAppApi", "MyAppApi init>>>", localThrowable);
    }
    f();
    m();
  }
  
  public static MyAppApi a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi == null) {
        jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi = new MyAppApi();
      }
      e();
      MyAppApi localMyAppApi = jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
      return localMyAppApi;
    }
    finally {}
  }
  
  @NotNull
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "1101070898";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("1101070898_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private boolean a(DownloadInfo paramDownloadInfo)
  {
    return (paramDownloadInfo != null) && (paramDownloadInfo.jdField_c_of_type_JavaLangString.startsWith("1101070898"));
  }
  
  public static int b()
  {
    Object localObject = CommonDataAdapter.a().a();
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
      int i = GlobalUtil.getInstance().getQQDownloaderAPILevel();
      if (2 > i) {
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
  
  @NonNull
  private static OuterCallReportModel b()
  {
    OuterCallReportModel localOuterCallReportModel = OuterCallReportModel.getDefaultModel();
    localOuterCallReportModel.mOuterCallMode = 0;
    localOuterCallReportModel.mOuterCallType = 1;
    localOuterCallReportModel.mOuterCallTime = System.currentTimeMillis();
    localOuterCallReportModel.mComponentName = "SplashActivity";
    return localOuterCallReportModel;
  }
  
  private static void b(OuterCallReportModel paramOuterCallReportModel)
  {
    GlobalUtil.getInstance().setContext(CommonDataAdapter.a().a());
    SDKReportManager2.getInstance().postReport(15, paramOuterCallReportModel.toString());
  }
  
  public static boolean b()
  {
    boolean bool = false;
    try
    {
      int i = b();
      if (i == 2) {
        return false;
      }
      if (i != 1) {
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
  
  public static int c()
  {
    return TMAssistantCallYYB_V2.getQQDownloadApiLevel(BaseApplicationImpl.getApplication());
  }
  
  public static void c() {}
  
  public static void d()
  {
    c();
    ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.1(), 5000L);
  }
  
  public static boolean d()
  {
    try
    {
      MyAppApi localMyAppApi = jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
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
  
  public static void e()
  {
    ThreadManager.executeOnSubThread(new MyAppApi.2());
  }
  
  private static boolean j()
  {
    return (k()) && (ControlPolicyUtil.l()) && (l());
  }
  
  private static boolean k()
  {
    return GlobalUtil.getInstance().getQQDownloaderVersionCode() >= 7512130;
  }
  
  private static boolean l()
  {
    return (Foreground.isCurrentProcessForeground()) || (ControlPolicyUtil.n());
  }
  
  private void m()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    CommonDataAdapter.a().a().registerReceiver(new AppReportReceiver(), localIntentFilter);
  }
  
  private static boolean m()
  {
    return (ControlPolicyUtil.i()) && (TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().a()) >= 7);
  }
  
  private static void n()
  {
    YybWakeManager.a().a();
    OuterCallReportModel localOuterCallReportModel = b();
    localOuterCallReportModel.mComponentName = "com.live.watermelon.Instrumentation";
    b(localOuterCallReportModel);
  }
  
  private static void o()
  {
    if (!ControlPolicyUtil.m())
    {
      LogUtility.b("TAMST_WAKE", "preInit==not TmastWake");
      return;
    }
    LogUtility.b("TAMST_WAKE", "preInit==allow TmastWake");
    ThreadManager.executeOnSubThread(new MyAppApi.3());
  }
  
  protected int a()
  {
    int i = TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().a());
    if (!ApkUtils.a("com.tencent.android.qqdownloader", BaseActivity.sTopActivity)) {
      i = 3;
    }
    return i;
  }
  
  protected int a(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt(DownloadConstants.k) == 3)) {
      return 2;
    }
    return 1;
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
      long l = a().addDownloadTaskFromTmast(paramBundle);
      return l;
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
    paramBundle = a(paramBundle);
    this.jdField_b_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = paramBundle;
    return a().addDownloadTaskFromTaskList(paramBundle, paramBoolean1, paramBoolean1);
  }
  
  public DownloadInfo a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, Bundle paramBundle)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_Int = 1;
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramTMAssistantCallYYBParamStruct.SNGAppId;
    localDownloadInfo.j = paramTMAssistantCallYYBParamStruct.taskAppId;
    localDownloadInfo.e = paramTMAssistantCallYYBParamStruct.taskPackageName;
    localDownloadInfo.k = paramTMAssistantCallYYBParamStruct.taskApkId;
    localDownloadInfo.jdField_b_of_type_Int = paramTMAssistantCallYYBParamStruct.taskVersion;
    localDownloadInfo.q = paramTMAssistantCallYYBParamStruct.recommendId;
    localDownloadInfo.s = paramTMAssistantCallYYBParamStruct.channelId;
    if (paramBundle != null)
    {
      localDownloadInfo.jdField_h_of_type_JavaLangString = paramBundle.getString(DownloadConstants.i);
      localDownloadInfo.f = paramBundle.getString(DownloadConstants.l);
      localDownloadInfo.jdField_d_of_type_JavaLangString = paramBundle.getString(DownloadConstants.j);
      localDownloadInfo.jdField_d_of_type_Int = paramBundle.getInt(DownloadConstants.G);
    }
    return localDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(Bundle paramBundle)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramBundle != null)
    {
      if (!b()) {
        return null;
      }
      paramBundle = a(paramBundle);
      if (a() <= 2)
      {
        localObject1 = ((TMAssistantCallYYB_V1)a()).getDownloadTaskState(paramBundle);
        paramBundle = localObject2;
        if (localObject1 != null) {
          paramBundle = new TMAssistantDownloadTaskInfo(((TMAssistantCallYYBTaskInfo)localObject1).mUrl, ((TMAssistantCallYYBTaskInfo)localObject1).mSavePath, ((TMAssistantCallYYBTaskInfo)localObject1).mState, ((TMAssistantCallYYBTaskInfo)localObject1).mReceiveDataLen, ((TMAssistantCallYYBTaskInfo)localObject1).mTotalDataLen, ((TMAssistantCallYYBTaskInfo)localObject1).mContentType);
        }
        return paramBundle;
      }
      paramBundle = ((TMAssistantCallYYB_V2)a()).getDownloadTaskState(paramBundle);
      localObject1 = localObject3;
      if (paramBundle != null) {
        localObject1 = new TMAssistantDownloadTaskInfo(paramBundle.mUrl, paramBundle.mSavePath, paramBundle.mState, paramBundle.mReceiveDataLen, paramBundle.mTotalDataLen, paramBundle.mContentType);
      }
    }
    return localObject1;
  }
  
  protected TMAssistantCallYYBParamStruct a(Bundle paramBundle)
  {
    String str2 = paramBundle.getString(DownloadConstants.b);
    String str3 = paramBundle.getString(DownloadConstants.jdField_c_of_type_JavaLangString);
    String str4 = paramBundle.getString(DownloadConstants.jdField_d_of_type_JavaLangString);
    String str5 = paramBundle.getString(DownloadConstants.f);
    Object localObject1 = paramBundle.getString(DownloadConstants.i);
    int j = paramBundle.getInt(DownloadConstants.e);
    int i = j;
    if (j == 0) {}
    try
    {
      i = Integer.valueOf(paramBundle.getString(DownloadConstants.e)).intValue();
      String str1;
      if (this.jdField_a_of_type_Boolean) {
        str1 = StaticAnalyz.a((String)localObject1, "NEWYYB");
      } else {
        str1 = StaticAnalyz.a((String)localObject1, "YYB");
      }
      paramBundle.getString(DownloadConstants.B);
      Object localObject2 = paramBundle.getString(DownloadConstants.D);
      j = paramBundle.getInt(DownloadConstants.C);
      if (j == 1) {
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
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append("");
          localObject3 = ((StringBuilder)localObject1).toString();
          localObject1 = "ANDROIDQQ";
          break;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append("");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" channelId:");
      ((StringBuilder)localObject2).append((String)localObject1);
      LogUtility.b("State_Log", ((StringBuilder)localObject2).toString());
      localObject1 = new TMAssistantCallYYBParamStruct(str2, str3, str4, i, str1, str5, "", "", (String)localObject1, (String)localObject3);
      if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().a()) >= 6)
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
        i = j;
      }
    }
  }
  
  protected TMAssistantBaseCallYYB a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB == null) {
        a();
      }
      TMAssistantBaseCallYYB localTMAssistantBaseCallYYB = this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB;
      return localTMAssistantBaseCallYYB;
    }
    finally {}
  }
  
  public String a()
  {
    MyAppApi.InstallParams localInstallParams = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams;
    if ((localInstallParams != null) && (localInstallParams.jdField_a_of_type_AndroidOsBundle != null)) {
      return this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.b);
    }
    return "";
  }
  
  public void a()
  {
    if (a() <= 2) {
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V1.getInstance();
    } else {
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V2.getInstance();
    }
    this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.initTMAssistantCallYYBApi(CommonDataAdapter.a().a());
    i();
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new MyAppApi.5(this, paramActivity));
  }
  
  protected void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString(DownloadConstants.p);
    int j = paramBundle.getInt("dialogType");
    int k = paramBundle.getInt("auto_start_yyb_download");
    LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog");
    LogUtility.c("MyAppApi", "-showTipDialog-");
    if (paramActivity == null) {
      return;
    }
    Resources localResources = paramActivity.getResources();
    int i = 1;
    if (paramInt2 == 1)
    {
      if (paramInt1 == 2) {
        paramInt1 = i;
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
              localObject = localResources.getString(2131691614);
            }
            else
            {
              paramString2 = localResources.getString(2131691617, new Object[] { paramString1 });
              break label269;
            }
          }
          else
          {
            paramString2 = localResources.getString(2131691616);
            break label269;
          }
        }
        else
        {
          paramString2 = localResources.getString(2131691615, new Object[] { paramString1 });
          break label269;
        }
      }
      else
      {
        paramString2 = localResources.getString(2131691614);
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
            paramString1 = localResources.getString(2131691614);
          } else {
            paramString1 = localResources.getString(2131691616);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" errorMsg = ");
          ((StringBuilder)localObject).append(paramString2.getMessage());
          LogUtility.c("MyAppApi", ((StringBuilder)localObject).toString());
          localObject = paramString1;
        }
      }
    }
    str = localResources.getString(2131691634);
    paramString2 = (String)localObject;
    paramString1 = str;
    if (paramInt2 == 1)
    {
      paramString2 = (String)localObject;
      paramString1 = str;
      if (j == 1)
      {
        paramString1 = localResources.getString(2131691635);
        paramString2 = localResources.getString(2131691618);
      }
    }
    localObject = new MyAppDialog(paramActivity);
    ((MyAppDialog)localObject).b(2131691629, paramOnClickListener2, true);
    ((MyAppDialog)localObject).a(2131691632, paramOnClickListener1, paramBoolean ^ true);
    ((MyAppDialog)localObject).a(paramString1);
    ((MyAppDialog)localObject).b(paramString2);
    if (j == 1)
    {
      ((MyAppDialog)localObject).b(2131691629, Color.parseColor("#D2D1D1"), paramOnClickListener2, true);
      ((MyAppDialog)localObject).a(2131691632, Color.parseColor("#3AC8FF"), paramOnClickListener1, paramBoolean ^ true);
      ((MyAppDialog)localObject).a(paramActivity.getResources().getDrawable(2130841936));
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
        if (j == 1)
        {
          paramActivity = paramBundle.getString(DownloadConstants.i);
          paramString1 = new StringBuilder();
          paramString1.append(paramBundle.getString("pageId"));
          paramString1.append("_");
          paramString1.append(paramBundle.getString("moduleId"));
          paramString1.append("_");
          paramString1.append(paramBundle.getString(DownloadConstants.f));
          paramString1.append("_");
          paramString1.append(paramBundle.getString(DownloadConstants.jdField_c_of_type_JavaLangString));
          paramString1.append("_");
          paramString1.append(paramBundle.getString(DownloadConstants.jdField_d_of_type_JavaLangString));
          AppCenterReporter.a("6006", "0", "0", paramActivity, paramString1.toString());
          if (k == 1) {
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
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog = ((MyAppDialog)localObject);
  }
  
  protected void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    boolean bool = ControlPolicyUtil.d();
    long l = CommonDataAdapter.a().a();
    int i;
    if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
      {
        if (a() <= 2) {
          ((TMAssistantCallYYB_V1)a()).startToAuthorized(paramActivity, this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
        } else {
          ((TMAssistantCallYYB_V2)a()).startToAuthorized(paramActivity, this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
        }
        this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
        return;
      }
      LogUtility.e("MyAppApi", "startToAuthorizedDirect mLastAuthorizeParam = null, needCarryQQIdentity = false");
      return;
    }
    TicketUtils localTicketUtils = new TicketUtils();
    localTicketUtils.a(new MyAppApi.17(this, localTicketUtils, l, paramActivity, paramOnClickListener));
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
    int i;
    try
    {
      i = a().checkQQDownloaderInstalled();
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      i = -1;
    }
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.g, false);
    boolean bool3 = paramBundle.getBoolean(DownloadConstants.jdField_h_of_type_JavaLangString, true);
    int k = paramBundle.getInt(DownloadConstants.n);
    int j = paramBundle.getInt(DownloadConstants.k);
    String str2 = paramBundle.getString(DownloadConstants.i);
    String str1 = paramBundle.getString(DownloadConstants.b);
    int m = paramBundle.getInt("dialogType");
    int n = paramBundle.getInt(DownloadConstants.u, 0);
    int i1 = paramBundle.getInt(DownloadConstants.v, 0);
    boolean bool4 = ControlPolicyUtil.e();
    boolean bool5 = ControlPolicyUtil.g();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" useMyAppFlag = ");
    ((StringBuilder)localObject).append(bool4);
    LogUtility.c("OpenConfig-MyAppApi", ((StringBuilder)localObject).toString());
    localObject = DownloadManager.a().a(str1);
    boolean bool1;
    if ((localObject != null) && (((DownloadInfo)localObject).jdField_c_of_type_Int == 1)) {
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
    if ((i != 2) && (i != 1))
    {
      if (i == 0)
      {
        if ((!ControlPolicyUtil.h()) && (!bool1))
        {
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(null, 0);
          }
          StaticAnalyz.a("200", str2, str1);
          return;
        }
        paramOnClickListener = StaticAnalyz.a(str2, "YYB");
        if (k == 0) {
          a(paramActivity, paramBundle, bool2, bool3);
        } else {
          a(paramActivity, paramBundle, bool2, bool3);
        }
        if ((localObject == null) && ((j == 2) || (j == 12)))
        {
          StaticAnalyz.a("202", paramOnClickListener, str1);
          return;
        }
        StaticAnalyz.a("200", paramOnClickListener, str1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog;
      if ((localObject != null) && (((MyAppDialog)localObject).isShowing())) {
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a() == paramActivity)
        {
          LogUtility.a("MyAppApi", "mTipDialog is showing return");
          return;
        }
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
      label494:
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog = null;
      break label507;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog = null;
      label507:
      if ((ControlPolicyUtil.f()) && ((j == 2) || (j == 12)))
      {
        ThreadManager.getSubThreadHandler().post(new MyAppApi.7(this, str2, str1));
        bool4 = ControlPolicyUtil.a();
        MyAppApi.8 local8 = new MyAppApi.8(this, bool2, paramOnClickListener, paramBundle, k, bool4, paramActivity, str2, str1, bool1, bool3, m);
        MyAppApi.ClickListenerProxy localClickListenerProxy = new MyAppApi.ClickListenerProxy(this, paramOnClickListener, str2, str1);
        MyAppApi.BackListener localBackListener = new MyAppApi.BackListener(this, str2, str1);
        if ((i1 > 0) && (n > 0))
        {
          k = i1 - n;
          if (k > 0)
          {
            localObject = YybHandleUtil.a(k);
            break label646;
          }
        }
        localObject = null;
        String str3 = paramBundle.getString("source");
        ThreadManager.getUIHandler().post(new MyAppApi.9(this, paramActivity, j, i, (String)localObject, local8, localClickListenerProxy, localBackListener, str3, bool4, paramBundle));
        ThreadManager.getSubThreadHandler().post(new MyAppApi.10(this, str2, str1));
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
        return;
      }
      label646:
      paramActivity = new StringBuilder();
      paramActivity.append("not allowShowDialog return actionCode = ");
      paramActivity.append(j);
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
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener == null)
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = new MyAppApi.YYBDownloadListener(this);
      DownloadManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener);
    }
    Object localObject = a(paramString2);
    localObject = DownloadManager.a().a((String)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("---startDownloadYYB---");
    localStringBuilder.append(localObject);
    LogUtility.c("MyAppApi", localStringBuilder.toString());
    if (localObject != null)
    {
      if (paramInt == 1)
      {
        ((DownloadInfo)localObject).jdField_a_of_type_Boolean = false;
        ((DownloadInfo)localObject).jdField_b_of_type_Boolean = true;
        ((DownloadInfo)localObject).jdField_h_of_type_Int = 1;
      }
      else
      {
        ((DownloadInfo)localObject).jdField_a_of_type_Boolean = true;
        ((DownloadInfo)localObject).jdField_b_of_type_Boolean = false;
        ((DownloadInfo)localObject).jdField_h_of_type_Int = 0;
      }
      ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString = paramString1;
      DownloadManager.a().e((DownloadInfo)localObject);
      DownloadManager.a().a((DownloadInfo)localObject);
      return;
    }
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = ControlPolicyUtil.a();
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
    long l = 0L;
    if (!bool)
    {
      l = ControlPolicyUtil.a();
      if (l <= 0L) {
        l = 2000L;
      }
    }
    ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.19(this, paramActivity, paramString1), l);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    LogUtility.c("MyAppApi", "startDownloadYyb");
    Bundle localBundle = new Bundle();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "https://a.app.qq.com/o/myapp-down?g_f=991310";
    }
    localBundle.putString(DownloadConstants.b, a(paramString3));
    localBundle.putString(DownloadConstants.j, str);
    localBundle.putString(DownloadConstants.f, "com.tencent.android.qqdownloader");
    localBundle.putInt(DownloadConstants.k, 2);
    localBundle.putString(DownloadConstants.i, paramString2);
    localBundle.putString(DownloadConstants.l, YybHandleUtil.jdField_d_of_type_JavaLangString);
    if (paramInt == 1) {
      localBundle.putBoolean(DownloadConstants.y, true);
    } else {
      localBundle.putBoolean(DownloadConstants.y, false);
    }
    localBundle.putInt(DownloadConstants.E, paramInt);
    localBundle.putString(DownloadConstants.m, "yyb");
    localBundle.putString(DownloadConstants.jdField_c_of_type_JavaLangString, "5848");
    localBundle.putBoolean(DownloadConstants.g, true);
    localBundle.putBoolean(DownloadConstants.jdField_h_of_type_JavaLangString, paramBoolean);
    localBundle.putInt(DownloadConstants.n, 1);
    DownloadApi.a(paramActivity, localBundle, "biz_src_yyb", null, 0);
  }
  
  public void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.21(this, paramBoolean, paramActivity, paramString), 0L);
  }
  
  protected void a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--startToDownloadTaskList");
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramContext) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_StartToDownloadList", System.currentTimeMillis());
    }
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct;
    int i;
    Object localObject;
    if (paramBundle != null)
    {
      if (paramContext == null) {
        return;
      }
      localTMAssistantCallYYBParamStruct = a(paramBundle);
      boolean bool = ControlPolicyUtil.d();
      long l = CommonDataAdapter.a().a();
      if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (paramContext != null))
      {
        bool = paramContext instanceof BaseActivity;
        if (bool)
        {
          localObject = new TicketUtils();
          ((TicketUtils)localObject).a(new MyAppApi.13(this, (TicketUtils)localObject, localTMAssistantCallYYBParamStruct, paramBundle, l, paramContext, paramBoolean1, paramBoolean2));
          if (!bool) {
            break label459;
          }
          ((TicketUtils)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
          return;
        }
      }
      localObject = a(localTMAssistantCallYYBParamStruct, paramBundle);
      DownloadManager.a().e((DownloadInfo)localObject);
    }
    label459:
    label460:
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
          ((TMAssistantCallYYB_V1)a()).startToDownloadTaskList(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2);
          return;
        }
        i = paramBundle.getInt(DownloadConstants.k);
        int j = a(paramBundle);
        if (i != 3) {
          break label460;
        }
        paramBoolean1 = false;
        paramBoolean2 = false;
        ((TMAssistantCallYYB_V2)a()).startToDownloadTaskList(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, j);
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
  
  public void a(Context paramContext, JSONArray paramJSONArray, int paramInt, String paramString1, String paramString2)
  {
    if (paramJSONArray == null) {
      return;
    }
    int j = paramJSONArray.length();
    if (j == 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject != null)
      {
        TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = new TMAssistantCallYYBParamStruct();
        localTMAssistantCallYYBParamStruct.recommendId = localJSONObject.optString("recommendId");
        localTMAssistantCallYYBParamStruct.channelId = localJSONObject.optString(DownloadConstants.M);
        localTMAssistantCallYYBParamStruct.taskPackageName = localJSONObject.optString(DownloadConstants.f);
        localTMAssistantCallYYBParamStruct.taskVersion = localJSONObject.optInt(DownloadConstants.e);
        localTMAssistantCallYYBParamStruct.via = localJSONObject.optString(DownloadConstants.i);
        localTMAssistantCallYYBParamStruct.taskApkId = localJSONObject.optString(DownloadConstants.jdField_d_of_type_JavaLangString);
        localTMAssistantCallYYBParamStruct.taskAppId = localJSONObject.optString(DownloadConstants.jdField_c_of_type_JavaLangString);
        localTMAssistantCallYYBParamStruct.SNGAppId = localJSONObject.optString(DownloadConstants.jdField_c_of_type_JavaLangString);
        if (TextUtils.isEmpty(localTMAssistantCallYYBParamStruct.SNGAppId)) {
          localTMAssistantCallYYBParamStruct.SNGAppId = localJSONObject.optString(DownloadConstants.b);
        }
        if (TextUtils.isEmpty(localTMAssistantCallYYBParamStruct.via)) {
          localTMAssistantCallYYBParamStruct.via = paramString1;
        }
        localTMAssistantCallYYBParamStruct.source = paramString2;
        localArrayList.add(localTMAssistantCallYYBParamStruct);
      }
      i += 1;
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
    DownloadManager localDownloadManager = DownloadManager.a();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramString;
    localDownloadInfo.a(10);
    localDownloadManager.a(10, localDownloadInfo);
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new MyAppApi.16(this, paramString, paramOnClickListener, paramActivity));
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_d_of_type_Boolean)
    {
      SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("showTost_pf", 0).edit();
      localEditor.putBoolean("showToast", this.jdField_d_of_type_Boolean);
      localEditor.putString("toast_msg", paramString);
      localEditor.commit();
    }
  }
  
  protected boolean a()
  {
    return TMAssistantCallYYB_V1.isExistActoin(this.jdField_a_of_type_Long) ^ true;
  }
  
  public boolean a(Context paramContext, Bundle paramBundle)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--startToWebView");
    if (paramBundle == null) {
      return false;
    }
    paramBundle = paramBundle.getString("url");
    LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
    a().startToWebView(paramContext, paramBundle);
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
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramBundle);
    if (!DownloadApi.b(localTMAssistantCallYYBParamStruct.SNGAppId)) {
      return false;
    }
    boolean bool2 = ControlPolicyUtil.d();
    long l = CommonDataAdapter.a().a();
    int i;
    if ((bool2) && (l > 0L) && (l != this.jdField_d_of_type_Long)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (paramContext != null))
    {
      bool2 = paramContext instanceof BaseActivity;
      if (bool2)
      {
        localObject = new TicketUtils();
        ((TicketUtils)localObject).a(new MyAppApi.12(this, (TicketUtils)localObject, localTMAssistantCallYYBParamStruct, paramBundle, l, paramContext, paramBoolean1, paramBoolean2));
        if (bool2) {
          ((TicketUtils)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
        }
        return true;
      }
    }
    Object localObject = a(localTMAssistantCallYYBParamStruct, paramBundle);
    DownloadManager.a().e((DownloadInfo)localObject);
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
          ((TMAssistantCallYYB_V1)a()).startToAppDetail(paramContext, localTMAssistantCallYYBParamStruct, bool1, paramBoolean2);
        }
        else
        {
          i = paramBundle.getInt(DownloadConstants.k);
          int j = a(paramBundle);
          if (i != 3) {
            break label514;
          }
          paramBoolean1 = false;
          bool1 = false;
          ((TMAssistantCallYYB_V2)a()).startToAppDetail(paramContext, localTMAssistantCallYYBParamStruct, bool1, paramBoolean1, j);
        }
      }
      catch (Exception paramContext)
      {
        LogUtility.b("MyAppApi", "startToAppDetail err", paramContext);
        return false;
      }
      return true;
      label514:
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
          return a().addDownloadTaskFromWebview(paramBundle);
        }
        long l = a().addDownloadTaskFromTmast(paramBundle);
        return l;
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
    paramBundle = a(paramBundle);
    this.jdField_b_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = paramBundle;
    return a().addDownloadTaskFromAppDetail(paramBundle, paramBoolean1, paramBoolean1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V2.getInstance();
    this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.initTMAssistantCallYYBApi(CommonDataAdapter.a().a());
    i();
  }
  
  protected void b(Activity paramActivity)
  {
    long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("judgeInstallFlag -- mInstalledFlag = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject).append("mInstallTime = ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
    ((StringBuilder)localObject).append(" countTime =");
    ((StringBuilder)localObject).append(l);
    LogUtility.c("MyAppApi", ((StringBuilder)localObject).toString());
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Long != -1L) && (l <= 180000L)) {
        i = 0;
      } else {
        i = 1;
      }
      if (b())
      {
        if (!a()) {
          this.jdField_b_of_type_Boolean = false;
        } else {
          this.jdField_b_of_type_Boolean = true;
        }
        if ((this.jdField_b_of_type_Boolean) || (i != 0)) {
          break label409;
        }
        if (this.jdField_a_of_type_Long != -1L) {
          a().removeDownloadTask(this.jdField_a_of_type_Long);
        }
        if (ControlPolicyUtil.h())
        {
          localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams;
          if (localObject != null) {
            if (((MyAppApi.InstallParams)localObject).jdField_a_of_type_Int == 0) {
              a(paramActivity, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
            } else {
              a(paramActivity, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
            }
          }
        }
        else if (i == 0)
        {
          paramActivity = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
          if (paramActivity != null) {
            paramActivity.onClick(null, 0);
          }
        }
      }
    }
    try
    {
      paramActivity = new StringBuilder();
      paramActivity.append(CommonDataAdapter.a().a().getFilesDir());
      paramActivity.append(File.separator);
      paramActivity.append("yyb_via_info.txt");
      if (new File(paramActivity.toString()).exists()) {
        CommonDataAdapter.a().a().deleteFile("yyb_via_info.txt");
      }
      label354:
      if ((!this.jdField_b_of_type_Boolean) && (i == 0))
      {
        if (this.jdField_a_of_type_Long != -1L) {
          a().removeDownloadTask(this.jdField_a_of_type_Long);
        }
        if (i == 0)
        {
          paramActivity = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
          if (paramActivity != null) {
            paramActivity.onClick(null, 0);
          }
        }
      }
      label409:
      g();
      if ((!this.jdField_d_of_type_Boolean) && (!b()))
      {
        paramActivity = CommonDataAdapter.a().a().getSharedPreferences("showTost_pf", 0);
        this.jdField_d_of_type_Boolean = paramActivity.getBoolean("showToast", false);
        this.jdField_a_of_type_JavaLangString = paramActivity.getString("toast_msg", "");
      }
      if (this.jdField_d_of_type_Boolean)
      {
        if (!b()) {
          new Handler(Looper.getMainLooper()).postDelayed(new MyAppApi.6(this), 2000L);
        }
        this.jdField_d_of_type_Boolean = false;
        paramActivity = CommonDataAdapter.a().a().getSharedPreferences("showTost_pf", 0).edit();
        paramActivity.putBoolean("showToast", this.jdField_d_of_type_Boolean);
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
    int i = -1;
    int j;
    try
    {
      j = a().checkQQDownloaderInstalled();
      i = j;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    boolean bool1 = paramBundle.getBoolean(DownloadConstants.g, false);
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.jdField_h_of_type_JavaLangString, true);
    int k = paramBundle.getInt(DownloadConstants.n);
    int m = paramBundle.getInt(DownloadConstants.k);
    boolean bool3 = ControlPolicyUtil.e();
    boolean bool4 = ControlPolicyUtil.g();
    String str1 = paramBundle.getString(DownloadConstants.b);
    String str2 = paramBundle.getString(DownloadConstants.i);
    DownloadInfo localDownloadInfo = DownloadManager.a().a(str1);
    if ((localDownloadInfo != null) && (localDownloadInfo.jdField_c_of_type_Int == 1)) {
      j = 1;
    } else {
      j = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" useMyAppFlag = ");
    localStringBuilder.append(bool3);
    LogUtility.c("OpenConfig-MyAppApi", localStringBuilder.toString());
    if (((!bool3) || (!bool4)) && (j == 0))
    {
      if (paramOnClickListener != null) {
        paramOnClickListener.onClick(null, 0);
      }
      StaticAnalyz.a("200", str2, str1);
      return;
    }
    if ((i != 2) && (i != 1))
    {
      if ((!ControlPolicyUtil.h()) && (j == 0))
      {
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(null, 0);
        }
        StaticAnalyz.a("200", str2, str1);
        return;
      }
      if (k == 0) {
        a(paramActivity, paramBundle, bool1, bool2);
      } else {
        a(paramActivity, paramBundle, bool1, bool2);
      }
      paramActivity = StaticAnalyz.a(str2, "YYB");
      if ((localDownloadInfo == null) && ((m == 2) || (m == 12)))
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
      String str3 = localJSONObject.optString("appName", HardCodeUtil.a(2131707084));
      localJSONObject.optString("channelId", "");
      Object localObject1 = localJSONObject.optString("appAuthorizedStr", "");
      Bundle localBundle = new Bundle();
      paramString = (String)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        paramString = "1";
      }
      int i = Integer.parseInt(paramString);
      localBundle.putString(DownloadConstants.b, localJSONObject.optString("appid", ""));
      localBundle.putString(DownloadConstants.jdField_c_of_type_JavaLangString, localJSONObject.optString("myAppid", ""));
      localBundle.putString(DownloadConstants.jdField_d_of_type_JavaLangString, localJSONObject.optString("apkId"));
      localBundle.putInt(DownloadConstants.e, i);
      localBundle.putString(DownloadConstants.f, localJSONObject.optString("appPackageName"));
      localBundle.putString(DownloadConstants.i, localJSONObject.optString("via"));
      localBundle.putString(DownloadConstants.l, localJSONObject.optString("appName"));
      localBundle.putString(DownloadConstants.B, localJSONObject.optString("channelId"));
      localBundle.putString(DownloadConstants.D, localJSONObject.optString("channel"));
      localBundle.putString(DownloadConstants.w, localJSONObject.optString("uin"));
      this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = a(localBundle);
      this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.actionFlag = "2";
      if (b())
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
        paramString.append(HardCodeUtil.a(2131707081));
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
    a().startToDownloadTaskListWithParams(paramContext, paramBundle);
    return true;
  }
  
  public void c(Activity paramActivity)
  {
    new YybHandleUtil.InstallBaseTask(paramActivity, null).execute(new Void[0]);
  }
  
  public boolean c()
  {
    return (b()) && (ControlPolicyUtil.e()) && (ControlPolicyUtil.h());
  }
  
  protected void d(Activity paramActivity)
  {
    if ((this.e) && (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null))
    {
      if (!a())
      {
        a();
        if (b())
        {
          if (this.jdField_a_of_type_Long != -1L) {
            a().removeDownloadTask(this.jdField_a_of_type_Long);
          }
          a(paramActivity, null);
        }
      }
      this.e = false;
      g();
      return;
    }
    this.e = false;
    this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
    g();
  }
  
  public boolean e()
  {
    return a() > 2;
  }
  
  protected void f()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    MyAppApi.4 local4 = new MyAppApi.4(this);
    CommonDataAdapter.a().a().registerReceiver(local4, localIntentFilter);
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  protected void g()
  {
    LogUtility.c("MyAppApi", "clearInstallParam");
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
  }
  
  public boolean g()
  {
    Object localObject = BaseActivity.sTopActivity.getPackageManager();
    boolean bool = false;
    if (localObject != null) {
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0);
        if (localObject != null)
        {
          int i = ((PackageInfo)localObject).versionCode;
          if (i >= 7090000) {
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
  
  public void h()
  {
    this.jdField_d_of_type_Long = 0L;
  }
  
  protected void i()
  {
    a().registerListener(this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener);
  }
  
  public void j()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.unregisterListener(this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener);
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.destroyQQDownloaderOpenSDK();
    }
    catch (Exception localException)
    {
      LogUtility.a("MyAppApi", "onDestroy>>>", localException);
    }
    try
    {
      jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi
 * JD-Core Version:    0.7.0.1
 */