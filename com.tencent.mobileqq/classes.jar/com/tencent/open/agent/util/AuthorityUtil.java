package com.tencent.open.agent.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.qconn.protofile.appType.LoginSig;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONObject;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqConnectLogin;

public class AuthorityUtil
{
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f2 = paramContext.getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < paramInt1 * f2) {
        f1 = i / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
    return ImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("platform", "1");
    localBundle.putString("result", paramString1);
    localBundle.putString("code", paramString2);
    localBundle.putString("tmcost", paramString3);
    localBundle.putString("rate", paramString4);
    localBundle.putString("cmd", paramString5);
    localBundle.putString("uin", paramString6);
    localBundle.putString("appid", paramString7);
    localBundle.putString("share_type", paramString8);
    localBundle.putString("detail", paramString9);
    localBundle.putString("os_ver", Build.VERSION.RELEASE);
    localBundle.putString("network", APNUtil.a(CommonDataAdapter.a().a()));
    localBundle.putString("apn", APNUtil.b(CommonDataAdapter.a().a()));
    localBundle.putString("model_name", Build.MODEL);
    localBundle.putString("qq_ver", CommonDataAdapter.a().c());
    return localBundle;
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString1);
    localBundle.putString("openid", paramString2);
    localBundle.putString("report_type", paramString3);
    localBundle.putString("act_type", paramString4);
    localBundle.putString("via", "2");
    localBundle.putString("app_id", paramString5);
    localBundle.putString("result", paramString6);
    localBundle.putString("type", paramString7);
    localBundle.putString("login_status", paramString8);
    localBundle.putString("need_user_auth", paramString9);
    localBundle.putString("to_uin", paramString10);
    localBundle.putString("to_type", paramString11);
    localBundle.putString("platform", "4");
    localBundle.putString("app_type", Integer.toString(1));
    return localBundle;
  }
  
  public static String a(Activity paramActivity)
  {
    if (paramActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorityUtil", 2, "getSrcPackageName activity is null");
      }
    }
    do
    {
      return null;
      paramActivity = paramActivity.getIntent().getBundleExtra("key_params");
      if (paramActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AuthorityUtil", 2, "getSrcPackageName bundle is null");
    return null;
    return paramActivity.getString("packagename");
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    LogUtility.b("AuthorityUtil", "getOpenId uin = " + paramString1 + ", appid = " + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return OpensdkPreference.a(paramContext, "uin_openid_store").getString(paramString2 + ":" + paramString1, null);
  }
  
  public static String a(Intent paramIntent, String paramString)
  {
    try
    {
      paramIntent = paramIntent.getStringExtra(paramString);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      QLog.e("AuthorityUtil", 1, "getStringExtra :", paramIntent);
    }
    return null;
  }
  
  public static String a(Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramBundle == null)
    {
      QLog.e("AuthorityUtil", 1, "getString error, params==null");
      return paramString2;
    }
    if (!paramBundle.containsKey(paramString1))
    {
      QLog.e("AuthorityUtil", 1, "getString error, not comtain : " + paramString1);
      return paramString2;
    }
    paramBundle = paramBundle.get(paramString1);
    if ((paramBundle instanceof String)) {}
    for (paramBundle = (String)paramBundle;; paramBundle = paramString2) {
      return paramBundle;
    }
  }
  
  public static String a(Bundle paramBundle, String paramString1, String paramString2, String paramString3)
  {
    Object localObject2 = paramBundle.getString("key_proxy_appid");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramBundle.getString("client_id");
    }
    String str = paramBundle.getString("scope");
    localObject2 = str;
    if (TextUtils.isEmpty(str)) {
      localObject2 = "all";
    }
    return "https://openmobile.qq.com/oauth2.0/m_authorize?_wv=16777218&status_os=" + Build.VERSION.RELEASE + "&client_id=" + (String)localObject1 + "&format=json&switch=1&status_version=" + Build.VERSION.SDK + "&status_machine=" + Build.MODEL + "&pf=openmobile_android&sdkp=a&sdkv=" + paramBundle.getString("sdkv") + "&sign=" + paramString1 + "&time=" + paramString2 + "&scope=" + (String)localObject2 + "&style=qr&redirect_uri=auth%3A%2F%2Ftauth.qq.com%2F&display=mobile&response_type=token&loginfrom=" + paramString3 + "&cancel_display=1";
  }
  
  public static String a(AuthResponse paramAuthResponse, Resources paramResources, int paramInt)
  {
    String str2 = HardCodeUtil.a(2131694678);
    String str1 = str2;
    if (paramAuthResponse != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramAuthResponse.a.get())) {
        str1 = paramAuthResponse.a.get();
      }
    }
    return String.format(paramResources.getString(2131696476), new Object[] { str1, Integer.valueOf(paramInt) });
  }
  
  public static String a(OpenSDKAppInterface paramOpenSDKAppInterface, List<String> paramList, Intent paramIntent)
  {
    String str = null;
    if (paramOpenSDKAppInterface.isLogin())
    {
      str = paramOpenSDKAppInterface.getAccount();
      QLog.d("AuthorityUtil", 1, new Object[] { "--> getCurrentUin isLogin currentUin=", a(str) });
    }
    paramOpenSDKAppInterface = str;
    if (str == null)
    {
      paramOpenSDKAppInterface = str;
      if (paramList != null)
      {
        paramOpenSDKAppInterface = str;
        if (!paramList.isEmpty())
        {
          paramOpenSDKAppInterface = (String)paramList.get(0);
          QLog.d("AuthorityUtil", 1, new Object[] { "--> getCurrentUin sdkHistories currentUin=", a(paramOpenSDKAppInterface) });
        }
      }
    }
    paramIntent = a(paramIntent, "login_success_uin");
    paramList = paramOpenSDKAppInterface;
    if (!TextUtils.isEmpty(paramIntent))
    {
      paramList = paramOpenSDKAppInterface;
      if (!paramIntent.equals(paramOpenSDKAppInterface))
      {
        QLog.d("AuthorityUtil", 1, new Object[] { "--> getCurrentUin set currentUin=", a(paramIntent) });
        paramList = paramIntent;
      }
    }
    return paramList;
  }
  
  public static String a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return "0";
      }
      paramString = paramString.substring(paramString.length() - 4);
      return paramString;
    }
    catch (Exception paramString) {}
    return "0";
  }
  
  public static String a(AppRuntime paramAppRuntime, AccountInfo paramAccountInfo, appType.LoginSig paramLoginSig, String paramString1, String paramString2)
  {
    Object localObject = paramAppRuntime.getAccount();
    String str = paramAccountInfo.a;
    boolean bool2 = ((OpenSDKAppInterface)paramAppRuntime).a().a(str);
    boolean bool1;
    if ((!bool2) && (TextUtils.equals((CharSequence)localObject, str))) {
      if (a(paramAccountInfo.a, paramAppRuntime, true) != null)
      {
        bool1 = true;
        boolean bool3 = a(paramAccountInfo.a, paramAppRuntime);
        QLog.d("AuthorityUtil", 1, new Object[] { "getMsfCommand qq current account hasA2=", Boolean.valueOf(bool1), ", hasD2=", Boolean.valueOf(bool3) });
        if ((!bool1) || (!bool3)) {
          break label124;
        }
        paramAppRuntime = paramString1;
      }
    }
    label124:
    do
    {
      return paramAppRuntime;
      bool1 = false;
      break;
      paramString1 = new appType.LoginSig();
      paramString1.type.set(8);
      localObject = a(paramAccountInfo.a, paramAppRuntime, true);
      if ((!bool2) && (localObject != null) && (a(paramAccountInfo.a, paramAppRuntime)))
      {
        QLog.d("AuthorityUtil", 1, "getMsfCommand use qq cache");
        paramString1.appid.set(16);
        paramString1.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
        paramLoginSig.set(paramString1);
        return paramString2;
      }
      paramAccountInfo = a(paramAccountInfo.a, paramAppRuntime, false);
      paramAppRuntime = paramString2;
    } while (paramAccountInfo == null);
    QLog.d("AuthorityUtil", 1, "getMsfCommand use opensdk cache");
    paramString1.appid.set(1600001540);
    paramString1.sig.set(ByteStringMicro.copyFrom(paramAccountInfo));
    paramLoginSig.set(paramString1);
    return paramString2;
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      paramString = new URL(paramString.replace("auth://", "https://"));
      JSONObject localJSONObject = a(new JSONObject(), paramString.getQuery());
      a(localJSONObject, paramString.getRef());
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QLog.d("AuthorityUtil", 1, "parseUrlToJson", paramString);
    }
    return new JSONObject();
  }
  
  private static JSONObject a(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramJSONObject;
      try
      {
        paramString = paramString.split("&");
        int j = paramString.length;
        while (i < j)
        {
          String[] arrayOfString = paramString[i].split("=");
          if (arrayOfString.length == 2)
          {
            arrayOfString[0] = URLDecoder.decode(arrayOfString[0]);
            arrayOfString[1] = URLDecoder.decode(arrayOfString[1]);
            paramJSONObject.put(arrayOfString[0], arrayOfString[1]);
          }
          i += 1;
        }
        return paramJSONObject;
      }
      catch (Exception paramString)
      {
        QLog.e("AuthorityUtil", 1, "JSONException", paramString);
      }
    }
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong, int paramInt2, int paramInt3, String paramString5)
  {
    try
    {
      OpenSdkStatic.a().a(paramInt1, paramString1, paramString2, paramString3, paramString4, paramLong, paramInt2, paramInt3, paramString5);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("AuthorityUtil", 1, "Exception", paramString1);
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localObject = new SystemBarCompact(paramActivity, true, paramActivity.getResources().getColor(2131167374));
      ((SystemBarCompact)localObject).setStatusBarColor(paramActivity.getResources().getColor(2131167374));
      ((SystemBarCompact)localObject).init();
    }
    Object localObject = Build.MANUFACTURER + Build.MODEL;
    if ((((String)localObject).equals("MeizuPRO 7-S")) || (((String)localObject).equalsIgnoreCase("MeizuM711C"))) {
      ImmersiveUtils.clearCoverForStatus(paramActivity.getWindow(), true);
    }
    for (;;)
    {
      ImmersiveUtils.setStatusTextColor(true, paramActivity.getWindow());
      return;
      ImmersiveUtils.trySetImmersiveStatusBar(paramActivity.getWindow());
    }
  }
  
  public static void a(Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed())))
    {
      QLog.e("AuthorityUtil", 1, "showDialog activity is null/finished. sdk_int: " + Build.VERSION.SDK_INT);
      return;
    }
    DialogUtil.b(paramActivity, 230).setMessageWithUrl(paramString).setTitle(paramActivity.getString(2131718689)).setPositiveButton(17039370, paramOnClickListener).show();
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("AuthorityUtil", 1, "showToast activity is null/finished");
      return;
    }
    paramActivity.runOnUiThread(new AuthorityUtil.1(paramActivity, paramBoolean, paramString));
  }
  
  public static void a(Intent paramIntent, Context paramContext)
  {
    paramIntent = new Intent(paramIntent);
    paramIntent.setClass(paramContext, QQBrowserActivity.class);
    paramIntent.setAction("android.intent.action.VIEW");
    paramIntent.putExtra("process", "com.tencent.mobileqq:openSdk");
    paramIntent.setData(Uri.parse("mqqverifycode://puzzle_verify_code/PUZZLEVERIFYCODE?"));
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(PBStringField paramPBStringField, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramPBStringField.set("support_110537=1");
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    try
    {
      ReportCenter.a().a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("AuthorityUtil", 1, "Exception", paramString1);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    QLog.d("AuthorityUtil", 1, new Object[] { "syncLoginAccount-", a(paramString) });
    Object localObject = paramAppRuntime.getApplication().getAllAccounts();
    if (localObject != null) {
      if (((List)localObject).size() >= 8) {
        QLog.d("AuthorityUtil", 1, new Object[] { "syncLoginAccount-max count=", Integer.valueOf(((List)localObject).size()) });
      }
    }
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((SimpleAccount)((Iterator)localObject).next()).getUin()))
        {
          QLog.d("AuthorityUtil", 1, "syncLoginAccount-exist!!!");
          return;
        }
      }
      ReportController.b(null, "dc00898", "", "", "0X800AC2F", "0X800AC2F", 0, 0, "", "", "", "");
      QLog.d("AuthorityUtil", 1, new Object[] { "sync opensdk account 0X800AC2F uin=", a(paramString) });
      MsfSdkUtils.addLoginSimpleAccount(paramString, false);
      paramAppRuntime.getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      paramAppRuntime = paramAppRuntime.getApplication().getAllAccounts();
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.iterator();
        while (paramAppRuntime.hasNext())
        {
          paramString = (SimpleAccount)paramAppRuntime.next();
          QLog.d("AuthorityUtil", 1, "after syncLoginAccount " + a(paramString.getUin()));
        }
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null)
    {
      ReportController.b(paramAppRuntime, "dc00898", "", "", paramString, paramString, 0, paramInt, "", "", "", "");
      return;
    }
    if (paramArrayOfString.length == 4)
    {
      String str1;
      String str2;
      label62:
      String str3;
      if (paramArrayOfString[0] == null)
      {
        str1 = "";
        if (paramArrayOfString[1] != null) {
          break label116;
        }
        str2 = "";
        if (paramArrayOfString[2] != null) {
          break label124;
        }
        str3 = "";
        label73:
        if (paramArrayOfString[3] != null) {
          break label132;
        }
      }
      label132:
      for (paramArrayOfString = "";; paramArrayOfString = paramArrayOfString[3])
      {
        ReportController.b(paramAppRuntime, "dc00898", "", "", paramString, paramString, 0, paramInt, str1, str2, str3, paramArrayOfString);
        return;
        str1 = paramArrayOfString[0];
        break;
        label116:
        str2 = paramArrayOfString[1];
        break label62;
        label124:
        str3 = paramArrayOfString[2];
        break label73;
      }
    }
    QLog.e("AuthorityUtil", 1, "reportT invalid param");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, String[] paramArrayOfString)
  {
    a(paramAppRuntime, paramString, 0, paramArrayOfString);
  }
  
  public static boolean a(Activity paramActivity)
  {
    return ((paramActivity instanceof AuthorityActivity)) || ((paramActivity instanceof PublicFragmentActivityForOpenSDK));
  }
  
  public static boolean a(Activity paramActivity, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramActivity == null)) {
      QLog.d("AuthorityUtil", 1, "onQrCodeLoginFinish activity invalid");
    }
    while (!paramIntent.getBooleanExtra("param_is_qr_code_login", false)) {
      return false;
    }
    QLog.d("AuthorityUtil", 1, "onActivityResult qrcode finish");
    Intent localIntent = new Intent();
    localIntent.putExtra("param_qr_code_url", paramIntent.getStringExtra("param_qr_code_url"));
    localIntent.putExtra("param_is_qr_code_login", true);
    paramActivity.setResult(-1, localIntent);
    paramActivity.finish();
    return true;
  }
  
  public static boolean a(String paramString, AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("AuthorityUtil", 1, "getDA2 false, currentAccount empty");
    }
    do
    {
      return false;
      if (paramAppRuntime == null)
      {
        QLog.e("AuthorityUtil", 1, "getDA2 false appInterface is null");
        return false;
      }
      paramAppRuntime = (TicketManager)paramAppRuntime.getManager(2);
      if (paramAppRuntime == null)
      {
        QLog.e("AuthorityUtil", 1, "getDA2 false TicketManager is null");
        return false;
      }
      paramString = paramAppRuntime.getLocalTicket(paramString, 262144);
    } while (paramString == null);
    paramString = paramString._sig;
    if ((paramString != null) && (paramString.length != 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject = paramAppRuntime.getAccount();
    boolean bool2 = ((OpenSDKAppInterface)paramAppRuntime).a().a(paramString);
    if ((!bool2) && (TextUtils.equals((CharSequence)localObject, paramString)))
    {
      if (a(paramString, paramAppRuntime, true) != null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool3 = a(paramString, paramAppRuntime);
        QLog.d("AuthorityUtil", 1, new Object[] { "isUse540Ticket qq current account hasA2=", Boolean.valueOf(bool1), ", hasD2=", Boolean.valueOf(bool3) });
        if ((!bool1) || (!bool3)) {
          break;
        }
        return false;
      }
    }
    localObject = a(paramString, paramAppRuntime, true);
    if ((!bool2) && (localObject != null) && (a(paramString, paramAppRuntime)))
    {
      QLog.d("AuthorityUtil", 1, "isUse540Ticket use qq cache");
      return false;
    }
    if (a(paramString, paramAppRuntime, false) != null)
    {
      QLog.d("AuthorityUtil", 1, "isUse540Ticket use opensdk cache");
      return true;
    }
    QLog.d("AuthorityUtil", 1, "isUse540Ticket use qq skey cache");
    return false;
  }
  
  public static boolean a(WtloginManager paramWtloginManager, String paramString)
  {
    if (paramWtloginManager.isNeedLoginWithPasswd(paramString, 16))
    {
      QLog.d("AuthorityUtil", 1, "IsNeedLoginWithPasswd appid=16, uin=" + a(paramString));
      if (paramWtloginManager.isNeedLoginWithPasswd(paramString, 1600001540))
      {
        QLog.d("AuthorityUtil", 1, "IsNeedLoginWithPasswd appid=1600001540, uin=" + a(paramString));
        return true;
      }
    }
    QLog.d("AuthorityUtil", 1, "IsNeedLoginWithPasswd false uin=" + a(paramString));
    return false;
  }
  
  public static byte[] a(String paramString)
  {
    GatewayVerify.ReqBody localReqBody = new GatewayVerify.ReqBody();
    GatewayVerify.ReqConnectLogin localReqConnectLogin = new GatewayVerify.ReqConnectLogin();
    localReqConnectLogin.str_connect_data.set("appid=" + paramString + "&sdkp=a");
    localReqBody.msg_req_connect_login.set(localReqConnectLogin);
    QLog.e("AuthorityUtil", 1, "getConnectData appid=" + paramString + "&sdkp=a");
    return localReqBody.toByteArray();
  }
  
  public static byte[] a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AuthorityUtil", 1, "getA2 false, currentAccount empty");
      return null;
    }
    if (paramAppRuntime == null)
    {
      QLog.e("AuthorityUtil", 1, "getA2 false appInterface is null");
      return null;
    }
    paramAppRuntime = (TicketManager)paramAppRuntime.getManager(2);
    if (paramAppRuntime == null)
    {
      QLog.e("AuthorityUtil", 1, "getA2 false TicketManager is null");
      return null;
    }
    String str;
    if (paramBoolean)
    {
      paramAppRuntime = paramAppRuntime.getA2(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      if (!paramBoolean) {
        break label151;
      }
      str = "host";
      label86:
      QLog.d("AuthorityUtil", 1, str + " getA2 uin=" + a(paramString) + "  " + a(paramAppRuntime));
      if (!TextUtils.isEmpty(paramAppRuntime)) {
        break label158;
      }
    }
    label151:
    label158:
    for (paramString = null;; paramString = HexUtil.hexStr2Bytes(paramAppRuntime))
    {
      return paramString;
      paramAppRuntime = paramAppRuntime.getOpenSdkKey(paramString, 64);
      break;
      str = "opensdk";
      break label86;
    }
  }
  
  public static String[] a(SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = paramSharedPreferences.getString("accList", null);
    if (paramSharedPreferences == null) {
      return null;
    }
    return paramSharedPreferences.split(",");
  }
  
  public static boolean b(WtloginManager paramWtloginManager, String paramString)
  {
    if (paramWtloginManager == null)
    {
      QLog.d("AuthorityUtil", 1, "isUserHaveA1 null == wtManager, uin=" + a(paramString));
      return false;
    }
    if (paramWtloginManager.isUserHaveA1(paramString, 16L))
    {
      QLog.d("AuthorityUtil", 1, "isUserHaveA1 appid=16, uin=" + a(paramString));
      return true;
    }
    if (paramWtloginManager.isUserHaveA1(paramString, 1600001540L))
    {
      QLog.d("AuthorityUtil", 1, "isUserHaveA1 appid=*540, uin=" + a(paramString));
      return true;
    }
    QLog.d("AuthorityUtil", 1, "isUserHaveA1 false uin=" + a(paramString));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthorityUtil
 * JD-Core Version:    0.7.0.1
 */