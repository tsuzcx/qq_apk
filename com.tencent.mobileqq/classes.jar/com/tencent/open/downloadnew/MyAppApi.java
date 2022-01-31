package com.tencent.open.downloadnew;

import alhs;
import alht;
import alhw;
import alhx;
import alhy;
import alib;
import alic;
import alie;
import alif;
import alig;
import alih;
import alii;
import alij;
import alik;
import alil;
import alim;
import alin;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.business.base.OpenConfig;
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
import java.util.Map;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class MyAppApi
{
  protected static MyAppApi a;
  private final int a;
  protected long a;
  protected DialogInterface.OnClickListener a;
  public MyAppApi.InstallParams a;
  protected MyAppApi.YYBDownloadListener a;
  public MyAppDialog a;
  protected ITMAssistantCallBackListener a;
  public TMAssistantCallYYBParamStruct a;
  protected TMAssistantBaseCallYYB a;
  public String a;
  protected boolean a;
  protected long b;
  TMAssistantCallYYBParamStruct b;
  protected boolean b;
  protected final long c = 180000L;
  public boolean c;
  public long d;
  boolean d;
  public boolean e;
  private boolean f;
  private boolean g;
  
  protected MyAppApi()
  {
    this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener = new MyAppApi.QQDownloadListener(this);
    this.jdField_b_of_type_Long = -1L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 7090000;
    try
    {
      a();
      d();
      i();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        LogUtility.c("MyAppApi", "MyAppApi init>>>", localThrowable);
      }
    }
  }
  
  private static Uri a(OuterCallReportModel paramOuterCallReportModel)
  {
    return Uri.parse("tmast://sdk_wake?jump_code=" + OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_jump_code") + "&outerCallTime=" + paramOuterCallReportModel.mOuterCallTime + "&outerCallType=" + paramOuterCallReportModel.mOuterCallType + "&outerCallMode=" + paramOuterCallReportModel.mOuterCallMode + "&hostpname=com.tencent.mobileqq&hostversion=" + GlobalUtil.getAppVersionCode(CommonDataAdapter.a().a()));
  }
  
  public static MyAppApi a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi == null) {
        jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi = new MyAppApi();
      }
      c();
      MyAppApi localMyAppApi = jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
      return localMyAppApi;
    }
    finally {}
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
  
  public static void c()
  {
    ThreadManager.executeOnSubThread(new alhs());
  }
  
  private static void c(OuterCallReportModel paramOuterCallReportModel)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setPackage("com.tencent.android.qqdownloader");
    localIntent.setData(a(paramOuterCallReportModel));
    localIntent.addFlags(32768);
    if (!(CommonDataAdapter.a().a() instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    try
    {
      CommonDataAdapter.a().a().startActivity(localIntent);
      return;
    }
    catch (SecurityException paramOuterCallReportModel)
    {
      paramOuterCallReportModel.printStackTrace();
    }
  }
  
  private static void d(OuterCallReportModel paramOuterCallReportModel)
  {
    GlobalUtil.getInstance().setContext(CommonDataAdapter.a().a());
    SDKReportManager2.getInstance().postReport(15, paramOuterCallReportModel.toString());
  }
  
  /* Error */
  public static boolean d()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 142	com/tencent/open/downloadnew/MyAppApi:jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi	Lcom/tencent/open/downloadnew/MyAppApi;
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
    //   6	2	1	localMyAppApi	MyAppApi
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  private void i()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    CommonDataAdapter.a().a().registerReceiver(new AppReportReceiver(), localIntentFilter);
  }
  
  private static boolean i()
  {
    return (ControlPolicyUtil.i()) && (TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().a()) >= 7);
  }
  
  public int a()
  {
    int i = TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().a());
    if (!ApkUtils.a("com.tencent.android.qqdownloader", BaseActivity.sTopActivity)) {
      i = 3;
    }
    return i;
  }
  
  public int a(Bundle paramBundle)
  {
    int j = 1;
    int i = j;
    if (paramBundle != null)
    {
      i = j;
      if (paramBundle.getInt(DownloadConstants.j) == 3) {
        i = 2;
      }
    }
    return i;
  }
  
  public long a(Bundle paramBundle)
  {
    try
    {
      LogUtility.c("MyAppApi", "--addDownloadTaskFromTmast--params = " + paramBundle);
      if (paramBundle == null) {
        return -1L;
      }
      paramBundle = paramBundle.getString("url");
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
    LogUtility.c("MyAppApi", "--addDownloadTaskFromTaskList--params = " + paramBundle + "autoDownload = " + paramBoolean1);
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
    localDownloadInfo.jdField_b_of_type_JavaLangString = paramTMAssistantCallYYBParamStruct.SNGAppId;
    localDownloadInfo.jdField_i_of_type_JavaLangString = paramTMAssistantCallYYBParamStruct.taskAppId;
    localDownloadInfo.jdField_d_of_type_JavaLangString = paramTMAssistantCallYYBParamStruct.taskPackageName;
    localDownloadInfo.j = paramTMAssistantCallYYBParamStruct.taskApkId;
    localDownloadInfo.jdField_b_of_type_Int = paramTMAssistantCallYYBParamStruct.taskVersion;
    if (paramBundle != null)
    {
      localDownloadInfo.g = paramBundle.getString(DownloadConstants.h);
      localDownloadInfo.e = paramBundle.getString(DownloadConstants.k);
      localDownloadInfo.jdField_c_of_type_JavaLangString = paramBundle.getString(DownloadConstants.jdField_i_of_type_JavaLangString);
      localDownloadInfo.jdField_d_of_type_Int = paramBundle.getInt(DownloadConstants.D);
    }
    return localDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!b())) {
      return null;
    }
    paramBundle = a(paramBundle);
    if (a() <= 2)
    {
      paramBundle = ((TMAssistantCallYYB_V1)a()).getDownloadTaskState(paramBundle);
      if (paramBundle != null) {
        return new TMAssistantDownloadTaskInfo(paramBundle.mUrl, paramBundle.mSavePath, paramBundle.mState, paramBundle.mReceiveDataLen, paramBundle.mTotalDataLen, paramBundle.mContentType);
      }
      return null;
    }
    paramBundle = ((TMAssistantCallYYB_V2)a()).getDownloadTaskState(paramBundle);
    if (paramBundle != null) {
      return new TMAssistantDownloadTaskInfo(paramBundle.mUrl, paramBundle.mSavePath, paramBundle.mState, paramBundle.mReceiveDataLen, paramBundle.mTotalDataLen, paramBundle.mContentType);
    }
    return null;
  }
  
  protected TMAssistantCallYYBParamStruct a(Bundle paramBundle)
  {
    String str4 = paramBundle.getString(DownloadConstants.jdField_a_of_type_JavaLangString);
    String str5 = paramBundle.getString(DownloadConstants.jdField_b_of_type_JavaLangString);
    String str6 = paramBundle.getString(DownloadConstants.jdField_c_of_type_JavaLangString);
    String str7 = paramBundle.getString(DownloadConstants.e);
    Object localObject1 = paramBundle.getString(DownloadConstants.h);
    int j = paramBundle.getInt(DownloadConstants.jdField_d_of_type_JavaLangString);
    int i = j;
    if (j == 0) {}
    try
    {
      i = Integer.valueOf(paramBundle.getString(DownloadConstants.jdField_d_of_type_JavaLangString)).intValue();
      String str2;
      String str1;
      String str3;
      Object localObject2;
      if (this.jdField_a_of_type_Boolean)
      {
        str2 = StaticAnalyz.a((String)localObject1, "NEWYYB");
        str1 = paramBundle.getString(DownloadConstants.u);
        localObject1 = paramBundle.getString(DownloadConstants.v);
        str3 = str1;
        if (TextUtils.isEmpty(str1)) {
          str3 = Long.valueOf(CommonDataAdapter.a().a()).toString();
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = "qqNumber";
        }
        paramBundle.getString(DownloadConstants.y);
        localObject1 = paramBundle.getString(DownloadConstants.A);
        j = paramBundle.getInt(DownloadConstants.z);
        if (j != 1) {
          break label426;
        }
        localObject1 = "ANDROIDQQ-gray";
        str1 = "1";
      }
      for (;;)
      {
        LogUtility.b("State_Log", " channelId:" + (String)localObject1);
        localObject1 = new TMAssistantCallYYBParamStruct(str4, str5, str6, i, str2, str7, str3, (String)localObject2, (String)localObject1, str1);
        if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(CommonDataAdapter.a().a()) >= 6)
        {
          ((TMAssistantCallYYBParamStruct)localObject1).timePointMap.put("OuterCall_JS_DoDownloadAction", Long.valueOf(paramBundle.getLong("OuterCall_JS_DoDownloadAction", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject1).timePointMap.put("OuterCall_DownloadApi_DoDownloadAction", Long.valueOf(paramBundle.getLong("OuterCall_DownloadApi_DoDownloadAction", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject1).timePointMap.put("OuterCall_DownloadApi_DoDownloadActionByMyApp", Long.valueOf(paramBundle.getLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject1).timePointMap.put("OuterCall_MyAppApi_HandleDownloadAction", Long.valueOf(paramBundle.getLong("OuterCall_MyAppApi_HandleDownloadAction", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject1).timePointMap.put("OuterCall_MyAppApi_StartToAppDetail", Long.valueOf(paramBundle.getLong("OuterCall_MyAppApi_StartToAppDetail", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject1).timePointMap.put("OuterCall_MyAppApi_StartToDownloadList", Long.valueOf(paramBundle.getLong("OuterCall_MyAppApi_StartToDownloadList", 0L)));
        }
        return localObject1;
        str2 = StaticAnalyz.a((String)localObject1, "YYB");
        break;
        label426:
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = "ANDROIDQQ";
          str1 = j + "";
        }
        else
        {
          str1 = j + "";
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public TMAssistantBaseCallYYB a()
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
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle != null)) {
      return this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.jdField_a_of_type_JavaLangString);
    }
    return "";
  }
  
  public void a()
  {
    if (a() <= 2) {}
    for (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V1.getInstance();; this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V2.getInstance())
    {
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.initTMAssistantCallYYBApi(CommonDataAdapter.a().a());
      g();
      return;
    }
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new alih(this, paramActivity));
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    LogUtility.c("NewUpgradeDialog", "preDownload called,get updateDetail info");
    ThreadManager.getSubThreadHandler().postDelayed(new alie(this, paramActivity), 0L);
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener, int paramInt3, boolean paramBoolean, String paramString2)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog");
    LogUtility.c("MyAppApi", "-showTipDialog-");
    if (paramActivity == null) {
      return;
    }
    Resources localResources = paramActivity.getResources();
    String str2;
    label56:
    String str1;
    if (paramInt2 == 1) {
      if (paramInt1 == 2)
      {
        paramInt1 = 1;
        if (!TextUtils.isEmpty(paramString2)) {
          break label324;
        }
        str2 = ControlPolicyUtil.a(paramInt1, paramInt3);
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {}
        switch (paramInt1)
        {
        default: 
          str1 = localResources.getString(2131428536);
          label110:
          if (((paramInt1 != 2) && (paramInt1 != 4)) || (!TextUtils.isEmpty(paramString2))) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = String.format(str1, new Object[] { paramString1 });
        str1 = localResources.getString(2131428532);
        paramString2 = new MyAppDialog(paramActivity);
        paramString2.b(2131428533, paramOnClickListener2, true);
        if (!paramBoolean)
        {
          paramBoolean = true;
          paramString2.a(2131428534, paramOnClickListener1, paramBoolean);
          paramString2.a(str1);
          paramString2.b(paramString1);
          paramString2.setCancelable(true);
          paramString2.setOnCancelListener(paramOnCancelListener);
          paramString2.setOnDismissListener(new alhw(this));
          if ((!(paramActivity instanceof AppActivity)) || (((AppActivity)paramActivity).isResume())) {
            break label469;
          }
          LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog---cancel !isResume");
          return;
          if ((paramInt1 == 12) && (!TextUtils.isEmpty(paramString1)))
          {
            paramInt1 = 2;
            break;
          }
          paramInt1 = 1;
          break;
          if (paramInt1 == 2)
          {
            paramInt1 = 3;
            break;
          }
          if ((paramInt1 == 12) && (!TextUtils.isEmpty(paramString1)))
          {
            paramInt1 = 4;
            break;
          }
          paramInt1 = 3;
          break;
          label324:
          str2 = paramString2;
          break label56;
          str1 = localResources.getString(2131428536);
          break label110;
          str1 = localResources.getString(2131428537, new Object[] { paramString1 });
          break label110;
          str1 = localResources.getString(2131428538);
          break label110;
          str1 = localResources.getString(2131428539, new Object[] { paramString1 });
        }
      }
      catch (Exception paramString2)
      {
        if (paramInt1 == 2)
        {
          paramString1 = localResources.getString(2131428536);
          LogUtility.c("MyAppApi", " errorMsg = " + paramString2.getMessage());
          continue;
        }
        paramString1 = localResources.getString(2131428538);
        continue;
        paramBoolean = false;
        continue;
      }
      try
      {
        label469:
        if (!paramActivity.isFinishing())
        {
          paramString2.show();
          ReportController.b(null, "dc00898", "", "", "0X8008F7A", "0X8008F7A", 0, 0, "", "", "", "");
        }
        LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog---complete");
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog = paramString2;
        return;
      }
      catch (Exception paramActivity)
      {
        for (;;)
        {
          paramActivity.printStackTrace();
        }
      }
      paramString1 = str1;
    }
  }
  
  public void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    boolean bool = ControlPolicyUtil.d();
    long l = CommonDataAdapter.a().a();
    int i;
    if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long))
    {
      i = 1;
      if (i != 0) {
        break label115;
      }
      if (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct == null) {
        break label106;
      }
      if (a() > 2) {
        break label85;
      }
      ((TMAssistantCallYYB_V1)a()).startToAuthorized(paramActivity, this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
      label74:
      this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
    }
    label85:
    label106:
    label115:
    TicketUtils localTicketUtils;
    do
    {
      return;
      i = 0;
      break;
      ((TMAssistantCallYYB_V2)a()).startToAuthorized(paramActivity, this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
      break label74;
      LogUtility.e("MyAppApi", "startToAuthorizedDirect mLastAuthorizeParam = null, needCarryQQIdentity = false");
      return;
      localTicketUtils = new TicketUtils();
      localTicketUtils.a(new alhy(this, localTicketUtils, l, paramActivity, paramOnClickListener));
    } while (!(paramActivity instanceof BaseActivity));
    localTicketUtils.a(((BaseActivity)paramActivity).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--handleDownloadAction");
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_HandleDownloadAction", System.currentTimeMillis());
    }
    int i = -1;
    try
    {
      j = a().checkQQDownloaderInstalled();
      i = j;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        boolean bool5;
        DownloadInfo localDownloadInfo;
        localException1.printStackTrace();
        continue;
        bool1 = false;
      }
      if (i == 2) {
        break label298;
      }
    }
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.f, false);
    boolean bool3 = paramBundle.getBoolean(DownloadConstants.g, true);
    int k = paramBundle.getInt(DownloadConstants.m);
    int j = paramBundle.getInt(DownloadConstants.j);
    String str2 = paramBundle.getString(DownloadConstants.h);
    String str1 = paramBundle.getString(DownloadConstants.jdField_a_of_type_JavaLangString);
    int m = paramBundle.getInt(DownloadConstants.s, 0);
    int n = paramBundle.getInt(DownloadConstants.t, 0);
    boolean bool4 = ControlPolicyUtil.e();
    bool5 = ControlPolicyUtil.g();
    LogUtility.c("OpenConfig-MyAppApi", " useMyAppFlag = " + bool4);
    localDownloadInfo = DownloadManager.a().a(str1);
    boolean bool1;
    if ((localDownloadInfo != null) && (localDownloadInfo.jdField_c_of_type_Int == 1))
    {
      bool1 = true;
      if (((bool4) && (bool5)) || (bool1)) {
        break label286;
      }
      if (paramOnClickListener != null)
      {
        LogUtility.a("MyAppApi", "allowMyApp=" + bool4 + " allowMyAppDownload=" + bool5 + " taskExist=" + bool1);
        paramOnClickListener.onClick(null, 0);
      }
      StaticAnalyz.a("200", str2, str1);
    }
    for (;;)
    {
      return;
      label286:
      if (i == 1) {
        label298:
        if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
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
        label342:
        for (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog = null; (!ControlPolicyUtil.f()) || ((j != 2) && (j != 12)); this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog = null)
        {
          LogUtility.a("MyAppApi", "not allowShowDialog return actionCode = " + j);
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(null, 0);
          }
          StaticAnalyz.a("200", str2, str1);
          return;
        }
        ThreadManager.getSubThreadHandler().post(new alij(this, str2, str1));
        bool4 = ControlPolicyUtil.a();
        alik localalik = new alik(this, bool2, paramOnClickListener, paramBundle, k, bool4, paramActivity, str2, bool1, bool3, str1);
        MyAppApi.ClickListenerProxy localClickListenerProxy = new MyAppApi.ClickListenerProxy(this, paramOnClickListener, str2, str1);
        MyAppApi.BackListener localBackListener = new MyAppApi.BackListener(this, str2, str1);
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (n > 0)
        {
          localObject1 = localObject2;
          if (m > 0)
          {
            k = n - m;
            localObject1 = localObject2;
            if (k > 0) {
              localObject1 = YybHandleUtil.a(k);
            }
          }
        }
        k = paramBundle.getInt("source");
        ThreadManager.getUIHandler().post(new alil(this, paramActivity, j, i, (String)localObject1, localalik, localClickListenerProxy, localBackListener, k, bool4, paramBundle));
        ThreadManager.getSubThreadHandler().post(new alim(this, str2, str1));
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
        return;
        if (i != 0) {
          continue;
        }
        if ((ControlPolicyUtil.h()) || (bool1))
        {
          paramOnClickListener = StaticAnalyz.a(str2, "YYB");
          if (k == 0) {
            a(paramActivity, paramBundle, bool2, bool3);
          }
          while ((localObject1 == null) && ((j == 2) || (j == 12)))
          {
            StaticAnalyz.a("202", paramOnClickListener, str1);
            return;
            a(paramActivity, paramBundle, bool2, bool3);
          }
          StaticAnalyz.a("200", paramOnClickListener, str1);
          return;
        }
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(null, 0);
        }
        StaticAnalyz.a("200", str2, str1);
        return;
      }
      catch (Exception localException2)
      {
        break label342;
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString, int paramInt)
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
    Object localObject = DownloadManager.a().a("1101070898");
    LogUtility.c("MyAppApi", "---startDownloadYYB---");
    if (localObject != null)
    {
      if (paramInt == 1)
      {
        ((DownloadInfo)localObject).jdField_a_of_type_Boolean = false;
        ((DownloadInfo)localObject).jdField_b_of_type_Boolean = true;
      }
      for (((DownloadInfo)localObject).jdField_i_of_type_Int = 1;; ((DownloadInfo)localObject).jdField_i_of_type_Int = 0)
      {
        ((DownloadInfo)localObject).g = paramString;
        DownloadManager.a().e((DownloadInfo)localObject);
        DownloadManager.a().a((DownloadInfo)localObject);
        return;
        ((DownloadInfo)localObject).jdField_a_of_type_Boolean = true;
        ((DownloadInfo)localObject).jdField_b_of_type_Boolean = false;
      }
    }
    String str = ControlPolicyUtil.a();
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "http://a.app.qq.com/o/myapp-down?g_f=991310";
    }
    a(paramActivity, (String)localObject, paramString, paramInt, false);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    LogUtility.c("MyAppApi", "startDownloadYyb");
    Bundle localBundle = new Bundle();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "http://a.app.qq.com/o/myapp-down?g_f=991310";
    }
    localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, "1101070898");
    localBundle.putString(DownloadConstants.jdField_i_of_type_JavaLangString, str);
    localBundle.putString(DownloadConstants.e, "com.tencent.android.qqdownloader");
    localBundle.putInt(DownloadConstants.j, 2);
    localBundle.putString(DownloadConstants.h, paramString2);
    localBundle.putString(DownloadConstants.k, "应用宝");
    if (paramInt == 1) {
      localBundle.putBoolean(DownloadConstants.w, true);
    }
    for (;;)
    {
      localBundle.putInt(DownloadConstants.B, paramInt);
      localBundle.putString(DownloadConstants.l, "yyb");
      localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, "5848");
      localBundle.putBoolean(DownloadConstants.f, true);
      localBundle.putBoolean(DownloadConstants.g, paramBoolean);
      localBundle.putInt(DownloadConstants.m, 1);
      DownloadApi.a(paramActivity, localBundle, 0, null, 0);
      return;
      localBundle.putBoolean(DownloadConstants.w, false);
    }
  }
  
  public void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new alif(this, paramBoolean, paramActivity, paramString), 0L);
  }
  
  public void a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--startToDownloadTaskList");
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramContext) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_StartToDownloadList", System.currentTimeMillis());
    }
    if ((paramBundle == null) || (paramContext == null)) {
      return;
    }
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramBundle);
    boolean bool = ControlPolicyUtil.d();
    long l = CommonDataAdapter.a().a();
    int i;
    if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long)) {
      i = 1;
    }
    Object localObject;
    label296:
    int j;
    while ((i == 0) || (paramContext == null) || (!(paramContext instanceof BaseActivity)))
    {
      localObject = a(localTMAssistantCallYYBParamStruct, paramBundle);
      DownloadManager.a().e((DownloadInfo)localObject);
      try
      {
        LogUtility.a("State_Log", "OpenSDK startToDownloadTaskList param SNGAppId=" + localTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + localTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + localTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + localTMAssistantCallYYBParamStruct.taskPackageName + " version=" + localTMAssistantCallYYBParamStruct.taskVersion + " uin=" + localTMAssistantCallYYBParamStruct.uin + " via=" + localTMAssistantCallYYBParamStruct.via);
        LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
        if (a() > 2) {
          break label296;
        }
        ((TMAssistantCallYYB_V1)a()).startToDownloadTaskList(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2);
        return;
      }
      catch (Exception paramContext)
      {
        LogUtility.e("MyAppApi", "--startToDownloadTaskList--Exception = " + paramContext);
        return;
      }
      i = 0;
      continue;
      i = paramBundle.getInt(DownloadConstants.j);
      j = a(paramBundle);
      if (i != 3) {
        break label400;
      }
      paramBoolean1 = false;
      paramBoolean2 = false;
    }
    label400:
    for (;;)
    {
      ((TMAssistantCallYYB_V2)a()).startToDownloadTaskList(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, j);
      return;
      localObject = new TicketUtils();
      ((TicketUtils)localObject).a(new alht(this, (TicketUtils)localObject, localTMAssistantCallYYBParamStruct, paramBundle, l, paramContext, paramBoolean1, paramBoolean2));
      if (!(paramContext instanceof BaseActivity)) {
        break;
      }
      ((TicketUtils)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
      return;
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new alhx(this, paramString, paramOnClickListener, paramActivity));
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_JavaLangString = paramString;
    } while (!this.jdField_d_of_type_Boolean);
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("showTost_pf", 0).edit();
    localEditor.putBoolean("showToast", this.jdField_d_of_type_Boolean);
    localEditor.putString("toast_msg", paramString);
    localEditor.commit();
  }
  
  protected boolean a()
  {
    return !TMAssistantCallYYB_V1.isExistActoin(this.jdField_a_of_type_Long);
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
    boolean bool = ControlPolicyUtil.d();
    long l = CommonDataAdapter.a().a();
    if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long)) {}
    for (int i = 1;; i = 0)
    {
      Object localObject;
      if ((i == 0) || (paramContext == null) || (!(paramContext instanceof BaseActivity)))
      {
        localObject = a(localTMAssistantCallYYBParamStruct, paramBundle);
        DownloadManager.a().e((DownloadInfo)localObject);
      }
      for (;;)
      {
        try
        {
          LogUtility.a("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + localTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + localTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + localTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + localTMAssistantCallYYBParamStruct.taskPackageName + " version=" + localTMAssistantCallYYBParamStruct.taskVersion + " uin=" + localTMAssistantCallYYBParamStruct.uin + " via=" + localTMAssistantCallYYBParamStruct.via + " autoDownload=" + paramBoolean1 + " autoInstall=" + paramBoolean2);
          LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
          if (a() <= 2)
          {
            ((TMAssistantCallYYB_V1)a()).startToAppDetail(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2);
          }
          else
          {
            i = paramBundle.getInt(DownloadConstants.j);
            int j = a(paramBundle);
            if (i == 3)
            {
              paramBoolean1 = false;
              paramBoolean2 = false;
              ((TMAssistantCallYYB_V2)a()).startToAppDetail(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, j);
            }
          }
        }
        catch (Exception paramContext)
        {
          LogUtility.b("MyAppApi", "startToAppDetail err", paramContext);
          return false;
        }
        localObject = new TicketUtils();
        ((TicketUtils)localObject).a(new alin(this, (TicketUtils)localObject, localTMAssistantCallYYBParamStruct, paramBundle, l, paramContext, paramBoolean1, paramBoolean2));
        if ((paramContext instanceof BaseActivity)) {
          ((TicketUtils)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
        }
        return true;
      }
      return true;
    }
  }
  
  public long b(Bundle paramBundle)
  {
    try
    {
      LogUtility.c("MyAppApi", "--addDownloadTaskFromAppDetail--params = " + paramBundle);
      if (paramBundle == null) {
        return -1L;
      }
      paramBundle = paramBundle.getString("url");
      if (!TextUtils.isEmpty(paramBundle))
      {
        if ((paramBundle.startsWith("tmast")) || (paramBundle.startsWith("tpmast"))) {
          return a().addDownloadTaskFromTmast(paramBundle);
        }
        long l = a().addDownloadTaskFromWebview(paramBundle);
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
    LogUtility.c("MyAppApi", "--addDownloadTaskFromAppDetail--params = " + paramBundle + "autoDownload = " + paramBoolean1);
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
    g();
  }
  
  public void b(Activity paramActivity)
  {
    long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    LogUtility.c("MyAppApi", "judgeInstallFlag -- mInstalledFlag = " + this.jdField_a_of_type_Boolean + "mInstallTime = " + this.jdField_b_of_type_Long + " countTime =" + l);
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Long != -1L) && (l <= 180000L)) {
        break label337;
      }
      i = 1;
      if (!b()) {
        break label404;
      }
      if (a()) {
        break label342;
      }
      this.jdField_b_of_type_Boolean = false;
      label107:
      if ((!this.jdField_b_of_type_Boolean) && (i == 0))
      {
        if (this.jdField_a_of_type_Long != -1L) {
          a().removeDownloadTask(this.jdField_a_of_type_Long);
        }
        if (!ControlPolicyUtil.h()) {
          break label379;
        }
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams != null)
        {
          if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Int != 0) {
            break label350;
          }
          a(paramActivity, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
        }
      }
    }
    for (;;)
    {
      e();
      if ((!this.jdField_d_of_type_Boolean) && (!b()))
      {
        paramActivity = CommonDataAdapter.a().a().getSharedPreferences("showTost_pf", 0);
        this.jdField_d_of_type_Boolean = paramActivity.getBoolean("showToast", false);
        this.jdField_a_of_type_JavaLangString = paramActivity.getString("toast_msg", "");
      }
      if (this.jdField_d_of_type_Boolean)
      {
        if (!b()) {
          new Handler(Looper.getMainLooper()).postDelayed(new alii(this), 2000L);
        }
        this.jdField_d_of_type_Boolean = false;
        paramActivity = CommonDataAdapter.a().a().getSharedPreferences("showTost_pf", 0).edit();
        paramActivity.putBoolean("showToast", this.jdField_d_of_type_Boolean);
        paramActivity.commit();
      }
      return;
      label337:
      i = 0;
      break;
      label342:
      this.jdField_b_of_type_Boolean = true;
      break label107;
      label350:
      a(paramActivity, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
      continue;
      label379:
      if ((i != 0) || (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
        continue;
      }
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      continue;
      try
      {
        label404:
        if (new File(CommonDataAdapter.a().a().getFilesDir() + File.separator + "yyb_via_info.txt").exists()) {
          CommonDataAdapter.a().a().deleteFile("yyb_via_info.txt");
        }
        label464:
        if ((this.jdField_b_of_type_Boolean) || (i != 0)) {
          continue;
        }
        if (this.jdField_a_of_type_Long != -1L) {
          a().removeDownloadTask(this.jdField_a_of_type_Long);
        }
        if ((i != 0) || (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
          continue;
        }
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      catch (Exception paramActivity)
      {
        break label464;
      }
    }
  }
  
  public void b(Activity paramActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_HandleDownloadAction", System.currentTimeMillis());
    }
    int i = -1;
    try
    {
      j = a().checkQQDownloaderInstalled();
      i = j;
    }
    catch (Exception localException)
    {
      int j;
      boolean bool1;
      boolean bool2;
      int k;
      int m;
      String str2;
      DownloadInfo localDownloadInfo;
      for (;;)
      {
        boolean bool3;
        boolean bool4;
        String str1;
        localException.printStackTrace();
        continue;
        j = 0;
      }
      if ((i != 2) && (i != 1)) {
        break label244;
      }
      if (paramOnClickListener == null) {
        break label233;
      }
      paramOnClickListener.onClick(null, 0);
      StaticAnalyz.a("202", str2, localException);
      return;
      if ((!ControlPolicyUtil.h()) && (j == 0)) {
        break label331;
      }
      if (k != 0) {
        break label308;
      }
      a(paramActivity, paramBundle, bool1, bool2);
      for (;;)
      {
        paramActivity = StaticAnalyz.a(str2, "YYB");
        if ((localDownloadInfo != null) || ((m != 2) && (m != 12))) {
          break;
        }
        StaticAnalyz.a("202", paramActivity, localException);
        return;
        a(paramActivity, paramBundle, bool1, bool2);
      }
      StaticAnalyz.a("200", paramActivity, localException);
      return;
      if (paramOnClickListener == null) {
        break label343;
      }
      paramOnClickListener.onClick(null, 0);
      StaticAnalyz.a("200", str2, localException);
    }
    bool1 = paramBundle.getBoolean(DownloadConstants.f, false);
    bool2 = paramBundle.getBoolean(DownloadConstants.g, true);
    k = paramBundle.getInt(DownloadConstants.m);
    m = paramBundle.getInt(DownloadConstants.j);
    bool3 = ControlPolicyUtil.e();
    bool4 = ControlPolicyUtil.g();
    str1 = paramBundle.getString(DownloadConstants.jdField_a_of_type_JavaLangString);
    str2 = paramBundle.getString(DownloadConstants.h);
    localDownloadInfo = DownloadManager.a().a(str1);
    if ((localDownloadInfo != null) && (localDownloadInfo.jdField_c_of_type_Int == 1))
    {
      j = 1;
      LogUtility.c("OpenConfig-MyAppApi", " useMyAppFlag = " + bool3);
      if (((bool3) && (bool4)) || (j != 0)) {
        break label209;
      }
      if (paramOnClickListener != null) {
        paramOnClickListener.onClick(null, 0);
      }
      StaticAnalyz.a("200", str2, str1);
    }
    label209:
    label233:
    label244:
    return;
  }
  
  public void b(Activity paramActivity, String paramString, int paramInt)
  {
    if (paramInt != 0)
    {
      long l2 = ControlPolicyUtil.a();
      l1 = l2;
      if (l2 > 0L) {}
    }
    for (long l1 = 2000L;; l1 = 0L)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new alic(this, paramActivity, paramString), l1);
      return;
    }
  }
  
  public void b(String paramString, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity)
  {
    for (;;)
    {
      String str5;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        String str3 = localJSONObject.optString("appid", "");
        localJSONObject.optString("myAppid", "");
        localJSONObject.optString("apkId", "");
        String str2 = localJSONObject.optString("versionCode", "");
        String str4 = localJSONObject.optString("via", "");
        localJSONObject.optString("appPackageName", "");
        str5 = localJSONObject.optString("appName", "该游戏");
        localJSONObject.optString("channelId", "");
        String str1 = localJSONObject.optString("appAuthorizedStr", "");
        Bundle localBundle = new Bundle();
        paramString = str2;
        if (TextUtils.isEmpty(str2)) {
          paramString = "1";
        }
        int i = Integer.parseInt(paramString);
        localBundle.putString(DownloadConstants.jdField_a_of_type_JavaLangString, localJSONObject.optString("appid", ""));
        localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, localJSONObject.optString("myAppid", ""));
        localBundle.putString(DownloadConstants.jdField_c_of_type_JavaLangString, localJSONObject.optString("apkId"));
        localBundle.putInt(DownloadConstants.jdField_d_of_type_JavaLangString, i);
        localBundle.putString(DownloadConstants.e, localJSONObject.optString("appPackageName"));
        localBundle.putString(DownloadConstants.h, localJSONObject.optString("via"));
        localBundle.putString(DownloadConstants.k, localJSONObject.optString("appName"));
        localBundle.putString(DownloadConstants.y, localJSONObject.optString("channelId"));
        localBundle.putString(DownloadConstants.A, localJSONObject.optString("channel"));
        localBundle.putString(DownloadConstants.u, localJSONObject.optString("uin"));
        this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = a(localBundle);
        this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.actionFlag = "2";
        if (b())
        {
          a(paramActivity, paramOnClickListener);
          return;
        }
        if (!TextUtils.isEmpty(str1))
        {
          paramString = str1;
          boolean bool = ControlPolicyUtil.a();
          a(paramActivity, 1, 1, "0", new alib(this, localBundle, bool, paramActivity, str4, paramOnClickListener, str3), new MyAppApi.ClickListenerProxy(this, paramOnClickListener, str4, str3), new MyAppApi.BackListener(this, str4, str3), 0, bool, paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = str5 + "限量内测中，可以到应用宝抢号并下载游戏哦~";
    }
  }
  
  public boolean b()
  {
    boolean bool = true;
    try
    {
      int i = a().checkQQDownloaderInstalled();
      if ((i == 2) || (i == 1)) {
        bool = false;
      }
      return bool;
    }
    catch (Exception localException)
    {
      LogUtility.c("MyAppApi", "hasValidQQDownloader>>>", localException);
    }
    return false;
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
  
  protected void d()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    alig localalig = new alig(this);
    CommonDataAdapter.a().a().registerReceiver(localalig, localIntentFilter);
  }
  
  public void d(Activity paramActivity)
  {
    if ((this.e) && (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null))
    {
      if ((!a()) && (a().b()))
      {
        if (this.jdField_a_of_type_Long != -1L) {
          a().removeDownloadTask(this.jdField_a_of_type_Long);
        }
        a(paramActivity, null);
      }
      this.e = false;
      e();
      return;
    }
    this.e = false;
    this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
    e();
  }
  
  protected void e()
  {
    LogUtility.c("MyAppApi", "clearInstallParam");
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
  }
  
  public boolean e()
  {
    return a() > 2;
  }
  
  public void f()
  {
    this.jdField_d_of_type_Long = 0L;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  protected void g()
  {
    a().registerListener(this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener);
  }
  
  public boolean g()
  {
    boolean bool2 = false;
    Object localObject = BaseActivity.sTopActivity.getPackageManager();
    boolean bool1 = bool2;
    if (localObject != null) {}
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0);
      bool1 = bool2;
      if (localObject != null)
      {
        int i = ((PackageInfo)localObject).versionCode;
        bool1 = bool2;
        if (i >= 7090000) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return false;
  }
  
  public void h()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.unregisterListener(this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener);
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.destroyQQDownloaderOpenSDK();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi = null;
          return;
        }
        finally {}
        localException = localException;
        LogUtility.a("MyAppApi", "onDestroy>>>", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi
 * JD-Core Version:    0.7.0.1
 */