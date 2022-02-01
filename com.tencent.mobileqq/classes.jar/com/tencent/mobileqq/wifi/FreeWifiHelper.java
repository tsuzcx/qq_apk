package com.tencent.mobileqq.wifi;

import MWIFI.SCGet3rdCloudCheck;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.WifiSdkHandler;
import com.tencent.mobileqq.app.WifiSdkObserver;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wifisdk.TMSDKCustomConfig;
import com.tencent.wifisdk.TMSDKWifiManager;
import com.wifisdk.ui.WifiSDKUIApi;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class FreeWifiHelper
{
  private static volatile boolean a = false;
  private static volatile boolean b = false;
  private static boolean c;
  private static boolean d;
  private static boolean e;
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, FreeWifiHelper.FreeWifiDialogListener paramFreeWifiDialogListener, int paramInt)
  {
    paramActivity = new FreeWifiHelper.5(paramActivity, paramString1, paramString2, paramString3, paramString4, new FreeWifiHelper.2(paramInt, paramActivity, paramFreeWifiDialogListener), new FreeWifiHelper.3(paramFreeWifiDialogListener, paramInt), new FreeWifiHelper.4(paramFreeWifiDialogListener, paramInt), paramInt);
    paramString1 = Looper.getMainLooper();
    if (Thread.currentThread() == paramString1.getThread())
    {
      paramActivity.run();
      return;
    }
    new Handler(paramString1).post(paramActivity);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    QLog.i("WifiSdk", 2, "gotoWifiListPage");
    if (a(paramContext))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("uiapi_k101", paramInt);
      localIntent.putExtra("big_brother_source_key", "biz_src_wifi");
      PublicFragmentActivity.a(paramContext, localIntent, QWifiListFragment.class);
    }
  }
  
  private static void a(Context paramContext, int paramInt, ArrayList<Integer> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "gotoWifiSecurityPage");
    }
    if (a(paramContext))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("uiapi_k101", paramInt);
      if (paramArrayList != null) {
        localIntent.putIntegerArrayListExtra("uiapi_k100", paramArrayList);
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_wifi");
      PublicFragmentActivity.a(paramContext, localIntent, QWifiSecurityFragment.class);
    }
  }
  
  public static void a(Context paramContext, SCGet3rdCloudCheck paramSCGet3rdCloudCheck)
  {
    try
    {
      if (a(paramContext.getApplicationContext()))
      {
        if (paramSCGet3rdCloudCheck.tipsType == 1)
        {
          c(paramContext, 3);
          b(paramContext, 398679);
          return;
        }
        if (paramSCGet3rdCloudCheck.tipsType == 2)
        {
          if (WifiSDKUIApi.isWiFiManagerExist()) {
            WifiSDKUIApi.gotoWifiAppSecurityPage(paramContext);
          } else {
            a(paramContext, 4, paramSCGet3rdCloudCheck.safeTypeList);
          }
          b(paramContext, 398681);
          return;
        }
        if (paramSCGet3rdCloudCheck.tipsType == 3)
        {
          if (!TextUtils.isEmpty(paramSCGet3rdCloudCheck.h5))
          {
            a(paramContext, paramSCGet3rdCloudCheck.h5);
            b(paramContext, 500147);
            return;
          }
          c(paramContext, 3);
          b(paramContext, 398679);
          return;
        }
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramSCGet3rdCloudCheck = new StringBuilder();
        paramSCGet3rdCloudCheck.append("onClickWifiSecurityBanner exception: ");
        paramSCGet3rdCloudCheck.append(paramContext.getMessage());
        QLog.i("WifiSdk", 2, paramSCGet3rdCloudCheck.toString());
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    QLog.i("WifiSdk", 2, "gotoH5");
    if (a(paramContext))
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.setFlags(268435456);
      localIntent.putExtra("big_brother_source_key", "biz_src_wifi");
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("registGuidIfNeed app: ");
      ((StringBuilder)localObject1).append(paramQQAppInterface);
      QLog.i("WifiSdk", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    Object localObject2 = WifiSdkSharedPreUtils.a(localBaseApplication, (String)localObject1);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("registGuidIfNeed uin: ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(" guid: ");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.i("WifiSdk", 2, ((StringBuilder)localObject3).toString());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("registGuidIfNeed uin: ");
        paramQQAppInterface.append((String)localObject1);
        paramQQAppInterface.append(" guid is not null, do not regist");
        QLog.i("WifiSdk", 2, paramQQAppInterface.toString());
      }
      return;
    }
    long l = WifiSdkSharedPreUtils.c(localBaseApplication, (String)localObject1);
    if ((l != -1L) && (System.currentTimeMillis() - l < 86400000L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WifiSdk", 2, "registGuidIfNeed, dont regit guid, time limit");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "registGuidIfNeed, start regist guid");
    }
    localObject2 = new WifiSdkHandler(paramQQAppInterface);
    Object localObject3 = new WifiSdkObserver(paramQQAppInterface);
    ((WifiSdkObserver)localObject3).a(new FreeWifiHelper.10(paramQQAppInterface, (WifiSdkObserver)localObject3));
    paramQQAppInterface.addObserver((BusinessObserver)localObject3);
    ((WifiSdkHandler)localObject2).a(2);
    WifiSdkSharedPreUtils.c(localBaseApplication, (String)localObject1, System.currentTimeMillis());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    Object localObject = paramQQAppInterface.getCurrentUin();
    int j = SharedPreUtils.a(paramQQAppInterface.getApp(), "wifi_connect_config_version", (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("FreeWifiHelper", 2, String.format(Locale.getDefault(), "received wifi Config remote version: %d, localVersion: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    if (i != j)
    {
      SharedPreUtils.a(paramQQAppInterface.getApp(), "wifi_connect_config_version", (String)localObject, i);
      paramConfig = ConfigServlet.b(paramConfig, j, paramInt);
      if (!TextUtils.isEmpty(paramConfig))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("receiveAllConfigs|type: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(",content: ");
        ((StringBuilder)localObject).append(paramConfig);
        ((StringBuilder)localObject).append(",version: ");
        ((StringBuilder)localObject).append(i);
        QLog.d("WifiSdk", 2, ((StringBuilder)localObject).toString());
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new JSONObject(paramConfig);
        if (paramConfig.optInt("Wifi_file_and", 0) != 1) {
          break label293;
        }
        bool = true;
        c = bool;
        if (paramConfig.optInt("Wifi_security_and", 0) != 1) {
          break label299;
        }
        bool = true;
        d = bool;
        if (paramConfig.optInt("Wifi_PDV_and", 0) != 1) {
          break label305;
        }
        bool = true;
        e = bool;
        SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), c, d, e);
        a(paramQQAppInterface, false);
        return;
      }
      catch (JSONException paramConfig)
      {
        QLog.e("WifiSdk", 2, paramConfig, new Object[0]);
      }
      a(paramQQAppInterface, true);
      return;
      label293:
      boolean bool = false;
      continue;
      label299:
      bool = false;
      continue;
      label305:
      bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Object localObject1;
    String str;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      str = paramQQAppInterface.getCurrentAccountUin();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("wifi_connect_switch_file_");
      ((StringBuilder)localObject2).append(str);
      c = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), false);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("wifi_connect_switch_security_");
      ((StringBuilder)localObject2).append(str);
      d = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), false);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("wifi_connect_switch_pdv_");
      ((StringBuilder)localObject2).append(str);
      e = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), false);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startCheck start, Conversation.sConversationResumeFlag: ");
      ((StringBuilder)localObject1).append(Conversation.b);
      ((StringBuilder)localObject1).append(", file switch: ");
      ((StringBuilder)localObject1).append(c);
      ((StringBuilder)localObject1).append(", security switch: ");
      ((StringBuilder)localObject1).append(d);
      ((StringBuilder)localObject1).append(", pdv switch: ");
      ((StringBuilder)localObject1).append(e);
      QLog.i("WifiSdk", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      if (((d) || (e)) && (Conversation.b > 0L))
      {
        localObject1 = paramQQAppInterface.getApp();
        str = paramQQAppInterface.getCurrentAccountUin();
        long l1 = System.currentTimeMillis();
        long l2 = WifiSdkSharedPreUtils.a((Context)localObject1, str);
        long l3 = WifiSdkSharedPreUtils.b((Context)localObject1, str) * 60 * 60 * 1000L;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startCheck, lastTime: ");
          ((StringBuilder)localObject2).append(l2);
          ((StringBuilder)localObject2).append(" frequency: ");
          ((StringBuilder)localObject2).append(l3);
          ((StringBuilder)localObject2).append(" nowTime: ");
          ((StringBuilder)localObject2).append(l1);
          QLog.i("WifiSdk", 2, ((StringBuilder)localObject2).toString());
        }
        if ((l2 != -1L) && (l1 - l2 < l3))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("WifiSdk", 2, "startCheck end, time limited");
          return;
        }
        WifiSdkSharedPreUtils.a((Context)localObject1, str, l1);
        localObject2 = new WifiSdkHandler(paramQQAppInterface);
        WifiSdkObserver localWifiSdkObserver = new WifiSdkObserver(paramQQAppInterface);
        localWifiSdkObserver.a(new FreeWifiHelper.1((Context)localObject1, str, paramQQAppInterface, localWifiSdkObserver));
        paramQQAppInterface.addObserver(localWifiSdkObserver);
        ((WifiSdkHandler)localObject2).a(1);
        return;
      }
      if (c)
      {
        b(paramQQAppInterface);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startCheck exception: ");
        ((StringBuilder)localObject1).append(paramQQAppInterface.getMessage());
        QLog.i("WifiSdk", 2, ((StringBuilder)localObject1).toString());
      }
    }
    return;
  }
  
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WL_DEBUG reportClickEvent actionName = ");
    localStringBuilder.append(paramString);
    QLog.d("WifiSdk", 2, localStringBuilder.toString());
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static boolean a(Activity paramActivity, int paramInt, FreeWifiHelper.FreeWifiDialogListener paramFreeWifiDialogListener)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("shouldOverrideDialog scene: ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(", file switch: ");
    ((StringBuilder)localObject1).append(c);
    QLog.i("WifiSdk", 2, ((StringBuilder)localObject1).toString());
    if (c)
    {
      if (!a(paramActivity)) {
        return true;
      }
      Object localObject2;
      if (paramInt == 1)
      {
        localObject1 = paramActivity.getString(2131692614);
        localObject2 = paramActivity.getString(2131692617);
      }
      int i;
      for (;;)
      {
        i = 1;
        break;
        if ((paramInt != 2) && (paramInt != 4))
        {
          if (paramInt == 3)
          {
            localObject1 = paramActivity.getString(2131692615);
            localObject2 = paramActivity.getString(2131692618);
          }
          else if (paramInt == 5)
          {
            localObject1 = paramActivity.getString(2131692564);
            localObject2 = paramActivity.getString(2131692619);
          }
          else
          {
            localObject1 = "";
            localObject2 = localObject1;
            i = 0;
            break;
          }
        }
        else
        {
          localObject1 = paramActivity.getString(2131692616);
          localObject2 = paramActivity.getString(2131692619);
        }
      }
      if (i != 0)
      {
        String str = paramActivity.getString(2131692620);
        Object localObject4 = WifiSdkSharedPreUtils.a(paramActivity);
        Object localObject3 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject3 = paramActivity.getString(2131692613);
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("shouldOverrideDialog btn1Text: ");
        ((StringBuilder)localObject4).append((String)localObject3);
        QLog.i("WifiSdk", 2, ((StringBuilder)localObject4).toString());
        a(paramActivity, str, (String)localObject1, (String)localObject3, (String)localObject2, paramFreeWifiDialogListener, paramInt);
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init wifisdk. was: ");
    localStringBuilder.append(a);
    QLog.i("WifiSdk", 2, localStringBuilder.toString());
    if (a) {
      return true;
    }
    boolean bool2 = b;
    boolean bool1 = false;
    if (bool2)
    {
      QLog.e("WifiSdk", 2, "wifisdk last init failed");
      return false;
    }
    try
    {
      if (QLog.isDebugVersion()) {
        TMSDKWifiManager.setEnableLog(true);
      }
      if (!TMSDKWifiManager.init(paramContext.getApplicationContext(), new TMSDKCustomConfig().setCustomToast(new FreeWifiHelper.9()).setCustomInstaller(new FreeWifiHelper.8()).setCustomThreadPool(new FreeWifiHelper.7()).setCustomReporter(new FreeWifiHelper.6()))) {
        bool1 = true;
      }
      b = bool1;
      WifiSDKUIApi.init(new QQRImpl(), new QWifiFragImplManager());
    }
    catch (Throwable paramContext)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("wifisdk init failed: ");
      localStringBuilder.append(paramContext.getMessage());
      QLog.e("WifiSdk", 2, localStringBuilder.toString());
      b = true;
    }
    if (!b) {
      a = true;
    }
    return a;
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    if (a(paramContext)) {
      WifiSDKUIApi.reportActionStat(paramInt);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestTargetJumpInfoIfNeed app: ");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      QLog.i("WifiSdk", 2, ((StringBuilder)localObject).toString());
    }
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.getCurrentAccountUin();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    long l = WifiSdkSharedPreUtils.b(localBaseApplication, (String)localObject);
    if ((l != -1L) && (System.currentTimeMillis() - l < 86400000L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WifiSdk", 2, "requestTargetJumpInfoIfNeed, dont request, time limit");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "requestTargetJumpInfoIfNeed, start request");
    }
    WifiSdkHandler localWifiSdkHandler = new WifiSdkHandler(paramQQAppInterface);
    WifiSdkObserver localWifiSdkObserver = new WifiSdkObserver(paramQQAppInterface);
    localWifiSdkObserver.a(new FreeWifiHelper.11(paramQQAppInterface, localWifiSdkObserver));
    paramQQAppInterface.addObserver(localWifiSdkObserver);
    localWifiSdkHandler.a(3);
    WifiSdkSharedPreUtils.b(localBaseApplication, (String)localObject, System.currentTimeMillis());
  }
  
  public static void c(Context paramContext, int paramInt)
  {
    if (!a(paramContext)) {
      return;
    }
    TargetJumpInfo localTargetJumpInfo = TargetJumpInfo.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dialog click, jumpType: ");
      localStringBuilder.append(localTargetJumpInfo.jdField_a_of_type_Int);
      localStringBuilder.append(" jumpUrl: ");
      localStringBuilder.append(localTargetJumpInfo.jdField_a_of_type_JavaLangString);
      QLog.i("WifiSdk", 2, localStringBuilder.toString());
    }
    if (WifiSDKUIApi.isWiFiManagerExist())
    {
      if (localTargetJumpInfo.jdField_a_of_type_Int == 4)
      {
        a(paramContext, paramInt);
        b(paramContext, 500105);
        return;
      }
      WifiSDKUIApi.gotoWifiAppConnectPage(paramContext);
      b(paramContext, 500101);
      return;
    }
    int i = localTargetJumpInfo.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 5)
          {
            a(paramContext, paramInt);
            b(paramContext, 500105);
            return;
          }
          QLog.i("WifiSdk", 2, "gotoWifiFloorPage");
          if (a(paramContext)) {
            PublicFragmentActivity.a(paramContext, new Intent(), QWifiFloorFragment.class);
          }
          b(paramContext, 500177);
          return;
        }
        a(paramContext, localTargetJumpInfo.jdField_a_of_type_JavaLangString);
        b(paramContext, 500103);
        return;
      }
      a(paramContext, paramInt);
      b(paramContext, 500104);
      return;
    }
    a(paramContext, localTargetJumpInfo.jdField_a_of_type_JavaLangString);
    b(paramContext, 500102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper
 * JD-Core Version:    0.7.0.1
 */