package com.tencent.open.agent.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.base.APNUtil;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qconn.protofile.appType.LoginSig;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqConnectLogin;

public class AuthorityUtil
{
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return BaseImageUtil.a(paramContext, paramBitmap, paramInt1, paramInt2);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = MobileQQ.sMobileQQ.getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      float f3 = i;
      float f4 = paramInt1;
      f1 = f2;
      if (f3 < f2 * f4) {
        f1 = f3 / f4;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(paramInt2 * f1);
    return BaseImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      Object localObject = (HttpURLConnection)new URL(paramString).openConnection();
      ((HttpURLConnection)localObject).setDoInput(true);
      ((HttpURLConnection)localObject).connect();
      localObject = ((HttpURLConnection)localObject).getInputStream();
      Bitmap localBitmap = SafeBitmapFactory.decodeStream((InputStream)localObject);
      ((InputStream)localObject).close();
      return localBitmap;
    }
    catch (Exception localException)
    {
      SSOLog.b("AuthorityUtil", new Object[] { "-->getbitmap Exception, url = ", paramString, ", exception message : ", localException.getMessage() });
      return null;
      SSOLog.b("AuthorityUtil", new Object[] { "-->getbitmap decodeStream oom, url = ", paramString });
      return null;
    }
    catch (IOException localIOException)
    {
      SSOLog.b("AuthorityUtil", new Object[] { "-->getbitmap IOException, url = ", paramString, ", exception message : ", localIOException.getMessage() });
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label73:
      break label73;
    }
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
  
  public static Bundle a(Object... paramVarArgs)
  {
    Bundle localBundle = new Bundle();
    if (paramVarArgs == null) {
      return localBundle;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j - 1)
    {
      if (paramVarArgs[i] != null)
      {
        int k = i + 1;
        if (paramVarArgs[k] != null) {
          localBundle.putString(paramVarArgs[i].toString(), paramVarArgs[k].toString());
        }
      }
      i += 2;
    }
    return localBundle;
  }
  
  public static String a(Activity paramActivity)
  {
    Object localObject1 = "";
    int i = 0;
    while (i < 3)
    {
      localObject1 = paramActivity.getCallingPackage();
      SSOLog.a("AuthorityUtil", new Object[] { "getPkgName=", localObject1 });
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        return localObject1;
      }
      Object localObject2 = paramActivity.getCallingActivity();
      if (localObject2 == null)
      {
        SSOLog.b("AuthorityUtil", "getPkgName component=null");
      }
      else
      {
        localObject2 = ((ComponentName)localObject2).getPackageName();
        SSOLog.a("AuthorityUtil", new Object[] { "getPkgName getPackageName=", localObject2 });
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          return localObject2;
        }
      }
      i += 1;
    }
    return localObject1;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject = str;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString1, 64).signatures;
      localObject = str;
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localObject = str;
      localMessageDigest.update(paramContext[0].toByteArray());
      localObject = str;
      paramContext = HexUtil.bytes2HexStr(localMessageDigest.digest());
      if (paramContext == null) {
        return "";
      }
      localObject = str;
      paramContext = paramContext.toLowerCase();
      localObject = str;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = str;
      localStringBuilder.append("-->getAppSignatureMD5, sign: ");
      localObject = str;
      localStringBuilder.append(paramContext);
      localObject = str;
      SSOLog.b("AuthorityUtil", localStringBuilder.toString());
      localObject = str;
      localMessageDigest.reset();
      localObject = str;
      localStringBuilder = new StringBuilder();
      localObject = str;
      localStringBuilder.append(paramString1);
      localObject = str;
      localStringBuilder.append("_");
      localObject = str;
      localStringBuilder.append(paramContext);
      localObject = str;
      localStringBuilder.append("_");
      localObject = str;
      localStringBuilder.append(paramString2);
      localObject = str;
      localStringBuilder.append("");
      localObject = str;
      localMessageDigest.update(localStringBuilder.toString().getBytes());
      localObject = str;
      paramContext = HexUtil.bytes2HexStr(localMessageDigest.digest());
      localObject = paramContext;
      localMessageDigest.reset();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      SSOLog.b("AuthorityUtil", "Exception", paramContext);
    }
    return localObject;
  }
  
  public static String a(Bundle paramBundle, String[] paramArrayOfString, String paramString)
  {
    Object localObject2 = paramBundle.getString("key_proxy_appid");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramBundle.getString("client_id");
    }
    Object localObject3 = paramBundle.getString("scope");
    localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = "all";
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("https://openmobile.qq.com/oauth2.0/m_authorize?_wv=16777218&status_os=");
    ((StringBuilder)localObject3).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject3).append("&client_id=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("&format=json&switch=1&status_version=");
    ((StringBuilder)localObject3).append(Build.VERSION.SDK);
    ((StringBuilder)localObject3).append("&status_machine=");
    ((StringBuilder)localObject3).append(Build.MODEL);
    ((StringBuilder)localObject3).append("&pf=openmobile_android&sdkp=a&sdkv=");
    ((StringBuilder)localObject3).append(paramBundle.getString("sdkv"));
    ((StringBuilder)localObject3).append("&sign=");
    ((StringBuilder)localObject3).append(paramArrayOfString[0]);
    ((StringBuilder)localObject3).append("&time=");
    ((StringBuilder)localObject3).append(paramArrayOfString[1]);
    ((StringBuilder)localObject3).append("&scope=");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("&style=qr&redirect_uri=auth%3A%2F%2Ftauth.qq.com%2F&display=mobile&response_type=token&loginfrom=");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append("&cancel_display=1");
    return ((StringBuilder)localObject3).toString();
  }
  
  public static String a(AuthResponse paramAuthResponse, Resources paramResources, int paramInt)
  {
    String str2 = HardCodeUtil.a(2131694647);
    String str1 = str2;
    if (paramAuthResponse != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get())) {
        str1 = paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get();
      }
    }
    return String.format(paramResources.getString(2131696495), new Object[] { str1, Integer.valueOf(paramInt) });
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
  
  public static String a(List<String> paramList, Intent paramIntent)
  {
    Object localObject = MobileQQ.sMobileQQ;
    String str = null;
    localObject = ((MobileQQ)localObject).waitAppRuntime(null);
    if (((AppRuntime)localObject).isLogin())
    {
      str = ((AppRuntime)localObject).getAccount();
      SSOLog.a("AuthorityUtil", new Object[] { "--> getCurrentUin isLogin currentUin=", a(str) });
    }
    localObject = str;
    if (str == null)
    {
      localObject = str;
      if (paramList != null)
      {
        localObject = str;
        if (!paramList.isEmpty())
        {
          localObject = (String)paramList.get(0);
          SSOLog.a("AuthorityUtil", new Object[] { "--> getCurrentUin sdkHistories currentUin=", a((String)localObject) });
        }
      }
    }
    paramList = AuthParamUtil.a(paramIntent, "login_success_uin");
    if ((!TextUtils.isEmpty(paramList)) && (!paramList.equals(localObject)))
    {
      SSOLog.a("AuthorityUtil", new Object[] { "--> getCurrentUin set currentUin=", a(paramList) });
      return paramList;
    }
    return localObject;
  }
  
  public static String a(Object... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs != null) && (paramVarArgs.length % 2 == 0))
    {
      int j = paramVarArgs.length;
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        if (i < j - 1) {
          try
          {
            localJSONObject.put(String.valueOf(paramVarArgs[i]), paramVarArgs[(i + 1)]);
            i += 2;
          }
          catch (JSONException paramVarArgs)
          {
            SSOLog.a("AuthorityUtil", "JSONException", paramVarArgs);
          }
        }
      }
      return localJSONObject.toString();
    }
    SSOLog.a("AuthorityUtil", new Object[] { "toJSONString invalid params" });
    return "";
  }
  
  public static HashMap<String, String> a(String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    if (paramVarArgs == null) {
      return localHashMap;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j - 1)
    {
      localHashMap.put(paramVarArgs[i], paramVarArgs[(i + 1)]);
      i += 2;
    }
    return localHashMap;
  }
  
  public static JSONObject a(AuthResponse paramAuthResponse, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ret", paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get());
    localJSONObject.put("openid", paramAuthResponse.c.get());
    localJSONObject.put("access_token", paramAuthResponse.jdField_b_of_type_ComTencentMobileqqPbPBStringField.get());
    localJSONObject.put("pay_token", paramAuthResponse.d.get());
    localJSONObject.put("expires_in", paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field.get());
    if (paramBoolean)
    {
      localJSONObject.put("code", paramAuthResponse.n.get());
      localJSONObject.put("proxy_code", paramAuthResponse.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse.code.get());
      localJSONObject.put("proxy_expires_in", paramAuthResponse.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse.expires_in.get());
    }
    localJSONObject.put("pf", paramAuthResponse.f.get());
    localJSONObject.put("pfkey", paramAuthResponse.g.get());
    localJSONObject.put("msg", paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get());
    if (paramAuthResponse.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field.has()) {
      localJSONObject.put("sendinstall", paramAuthResponse.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field.get());
    }
    if ((paramAuthResponse.j.has()) && (!TextUtils.isEmpty(paramAuthResponse.j.get()))) {
      localJSONObject.put("installwording", paramAuthResponse.j.get());
    }
    if ((paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.has()) && (paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.size() > 0))
    {
      paramAuthResponse = paramAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.get().iterator();
      while (paramAuthResponse.hasNext())
      {
        appType.PassData localPassData = (appType.PassData)paramAuthResponse.next();
        localJSONObject.put(localPassData.key.get(), localPassData.value.get());
      }
    }
    localJSONObject.put("login_cost", paramLong1);
    localJSONObject.put("query_authority_cost", paramLong2);
    localJSONObject.put("authority_cost", paramLong3);
    return localJSONObject;
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
      SSOLog.a("AuthorityUtil", "parseUrlToJson", paramString);
    }
    return new JSONObject();
  }
  
  private static JSONObject a(JSONObject paramJSONObject, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramJSONObject;
    }
    try
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
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
      SSOLog.c("AuthorityUtil", "JSONException", paramString);
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int i = paramActivity.getResources().getColor(2131167394);
      localObject = new SystemBarCompact(paramActivity, true, i);
      ((SystemBarCompact)localObject).setStatusBarColor(i);
      ((SystemBarCompact)localObject).init();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    if ((!((String)localObject).equals("MeizuPRO 7-S")) && (!((String)localObject).equalsIgnoreCase("MeizuM711C"))) {
      ImmersiveUtils.trySetImmersiveStatusBar(paramActivity.getWindow());
    } else {
      ImmersiveUtils.clearCoverForStatus(paramActivity.getWindow(), true);
    }
    ImmersiveUtils.setStatusTextColor(true, paramActivity.getWindow());
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_gesture_from_authority", true);
    RouteUtils.a(paramContext, localIntent, "/base/gesturePwdUnlock", 100);
  }
  
  public static void a(Intent paramIntent, Context paramContext)
  {
    paramIntent = new Intent(paramIntent);
    paramIntent.setAction("android.intent.action.VIEW");
    paramIntent.putExtra("process", "com.tencent.mobileqq:openSdk");
    paramIntent.setData(Uri.parse("mqqverifycode://puzzle_verify_code/PUZZLEVERIFYCODE?"));
    RouteUtils.a(paramContext, paramIntent, "/base/browser");
  }
  
  public static void a(PBStringField paramPBStringField, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramPBStringField.set("support_110537=1");
    }
  }
  
  public static void a(String paramString)
  {
    a(null, paramString, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    SSOLog.a("AuthorityUtil", new Object[] { "syncLoginAccount-", a(paramString) });
    Object localObject = paramAppRuntime.getApplication().getAllAccounts();
    if (localObject != null)
    {
      if (((List)localObject).size() >= 8)
      {
        SSOLog.a("AuthorityUtil", new Object[] { "syncLoginAccount-max count=", Integer.valueOf(((List)localObject).size()) });
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((SimpleAccount)((Iterator)localObject).next()).getUin()))
        {
          SSOLog.a("AuthorityUtil", new Object[] { "syncLoginAccount-exist!!!" });
          return;
        }
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X800AC2F", "0X800AC2F", 0, 0, "", "", "", "");
    SSOLog.a("AuthorityUtil", new Object[] { "sync opensdk account 0X800AC2F uin=", a(paramString) });
    MsfSdkUtils.addLoginSimpleAccount(paramString, false);
    paramAppRuntime.getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    paramAppRuntime = paramAppRuntime.getApplication().getAllAccounts();
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.iterator();
      while (paramAppRuntime.hasNext())
      {
        paramString = (SimpleAccount)paramAppRuntime.next();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("after syncLoginAccount ");
        ((StringBuilder)localObject).append(a(paramString.getUin()));
        SSOLog.a("AuthorityUtil", new Object[] { ((StringBuilder)localObject).toString() });
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null)
    {
      ReportController.b(paramAppRuntime, "dc00898", "", "", paramString, paramString, paramInt2, paramInt1, "", "", "", "");
      return;
    }
    if (paramArrayOfString.length == 4)
    {
      String str1 = paramArrayOfString[0];
      String str4 = "";
      if (str1 == null) {
        str1 = "";
      } else {
        str1 = paramArrayOfString[0];
      }
      String str2;
      if (paramArrayOfString[1] == null) {
        str2 = "";
      } else {
        str2 = paramArrayOfString[1];
      }
      String str3;
      if (paramArrayOfString[2] == null) {
        str3 = "";
      } else {
        str3 = paramArrayOfString[2];
      }
      if (paramArrayOfString[3] == null) {
        paramArrayOfString = str4;
      } else {
        paramArrayOfString = paramArrayOfString[3];
      }
      ReportController.b(paramAppRuntime, "dc00898", "", "", paramString, paramString, paramInt2, paramInt1, str1, str2, str3, paramArrayOfString);
      return;
    }
    SSOLog.b("AuthorityUtil", new Object[] { "reportT invalid param" });
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt, String[] paramArrayOfString)
  {
    a(paramAppRuntime, paramString, paramInt, 0, paramArrayOfString);
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
    if ((paramIntent != null) && (paramActivity != null))
    {
      if (!paramIntent.getBooleanExtra("param_is_qr_code_login", false)) {
        return false;
      }
      SSOLog.a("AuthorityUtil", new Object[] { "onActivityResult qrcode finish" });
      Intent localIntent = new Intent();
      localIntent.putExtra("param_qr_code_url", paramIntent.getStringExtra("param_qr_code_url"));
      localIntent.putExtra("param_is_qr_code_login", true);
      paramActivity.setResult(-1, localIntent);
      paramActivity.finish();
      return true;
    }
    SSOLog.a("AuthorityUtil", new Object[] { "onQrCodeLoginFinish activity invalid" });
    return false;
  }
  
  public static boolean a(String paramString, AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SSOLog.b("AuthorityUtil", new Object[] { "getDA2 false, currentAccount empty" });
      return false;
    }
    if (paramAppRuntime == null)
    {
      SSOLog.b("AuthorityUtil", new Object[] { "getDA2 false appInterface is null" });
      return false;
    }
    paramAppRuntime = (TicketManager)paramAppRuntime.getManager(2);
    if (paramAppRuntime == null)
    {
      SSOLog.b("AuthorityUtil", new Object[] { "getDA2 false TicketManager is null" });
      return false;
    }
    paramString = paramAppRuntime.getLocalTicket(paramString, 262144);
    if (paramString == null) {
      return false;
    }
    paramString = paramString._sig;
    return (paramString != null) && (paramString.length != 0);
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    Object localObject = paramAppRuntime.getAccount();
    if ((!paramBoolean) && (TextUtils.equals((CharSequence)localObject, paramString)))
    {
      boolean bool1;
      if (a(paramString, paramAppRuntime, true) != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2 = a(paramString, paramAppRuntime);
      SSOLog.a("AuthorityUtil", new Object[] { "isUse540Ticket qq current account hasA2=", Boolean.valueOf(bool1), ", hasD2=", Boolean.valueOf(bool2) });
      if ((bool1) && (bool2)) {
        return false;
      }
    }
    localObject = a(paramString, paramAppRuntime, true);
    if ((!paramBoolean) && (localObject != null) && (a(paramString, paramAppRuntime)))
    {
      SSOLog.a("AuthorityUtil", new Object[] { "isUse540Ticket use qq cache" });
      return false;
    }
    if (a(paramString, paramAppRuntime, false) != null)
    {
      SSOLog.a("AuthorityUtil", new Object[] { "isUse540Ticket use opensdk cache" });
      return true;
    }
    SSOLog.a("AuthorityUtil", new Object[] { "isUse540Ticket use qq skey cache" });
    return false;
  }
  
  public static boolean a(WtloginManager paramWtloginManager, String paramString)
  {
    if (paramWtloginManager == null)
    {
      SSOLog.a("AuthorityUtil", new Object[] { "IsNeedLoginWithPasswd null == wtManager" });
      return true;
    }
    if (paramWtloginManager.isNeedLoginWithPasswd(paramString, 16))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IsNeedLoginWithPasswd appid=16, uin=");
      localStringBuilder.append(a(paramString));
      SSOLog.a("AuthorityUtil", new Object[] { localStringBuilder.toString() });
      if (paramWtloginManager.isNeedLoginWithPasswd(paramString, 1600001540))
      {
        paramWtloginManager = new StringBuilder();
        paramWtloginManager.append("IsNeedLoginWithPasswd appid=1600001540, uin=");
        paramWtloginManager.append(a(paramString));
        SSOLog.a("AuthorityUtil", new Object[] { paramWtloginManager.toString() });
        return true;
      }
    }
    paramWtloginManager = new StringBuilder();
    paramWtloginManager.append("IsNeedLoginWithPasswd false uin=");
    paramWtloginManager.append(a(paramString));
    SSOLog.a("AuthorityUtil", new Object[] { paramWtloginManager.toString() });
    return false;
  }
  
  public static byte[] a(Bundle paramBundle, boolean paramBoolean, AccountInfo paramAccountInfo)
  {
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    paramBundle = arrayOfByte;
    if (paramBoolean) {
      paramBundle = OpenSdkVirtualUtil.a(arrayOfByte, paramAccountInfo);
    }
    return paramBundle;
  }
  
  public static byte[] a(MessageMicro paramMessageMicro, boolean paramBoolean, AccountInfo paramAccountInfo)
  {
    byte[] arrayOfByte = paramMessageMicro.toByteArray();
    paramMessageMicro = arrayOfByte;
    if (paramBoolean) {
      paramMessageMicro = OpenSdkVirtualUtil.b(arrayOfByte, paramAccountInfo);
    }
    return paramMessageMicro;
  }
  
  public static byte[] a(String paramString)
  {
    GatewayVerify.ReqBody localReqBody = new GatewayVerify.ReqBody();
    Object localObject = new GatewayVerify.ReqConnectLogin();
    PBStringField localPBStringField = ((GatewayVerify.ReqConnectLogin)localObject).str_connect_data;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appid=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("&sdkp=a");
    localPBStringField.set(localStringBuilder.toString());
    localReqBody.msg_req_connect_login.set((MessageMicro)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getConnectData appid=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&sdkp=a");
    SSOLog.b("AuthorityUtil", new Object[] { ((StringBuilder)localObject).toString() });
    return localReqBody.toByteArray();
  }
  
  public static byte[] a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SSOLog.b("AuthorityUtil", new Object[] { "getA2 false, currentAccount empty" });
      return null;
    }
    if (paramAppRuntime == null)
    {
      SSOLog.b("AuthorityUtil", new Object[] { "getA2 false appInterface is null" });
      return null;
    }
    paramAppRuntime = (TicketManager)paramAppRuntime.getManager(2);
    if (paramAppRuntime == null)
    {
      SSOLog.b("AuthorityUtil", new Object[] { "getA2 false TicketManager is null" });
      return null;
    }
    if (paramBoolean) {
      paramAppRuntime = paramAppRuntime.getA2(paramString);
    } else {
      paramAppRuntime = paramAppRuntime.getOpenSdkKey(paramString, 64);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (paramBoolean) {
      str = "host";
    } else {
      str = "opensdk";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" getA2 uin=");
    localStringBuilder.append(a(paramString));
    localStringBuilder.append("  ");
    localStringBuilder.append(a(paramAppRuntime));
    SSOLog.a("AuthorityUtil", new Object[] { localStringBuilder.toString() });
    if (TextUtils.isEmpty(paramAppRuntime)) {
      return null;
    }
    return HexUtil.hexStr2Bytes(paramAppRuntime);
  }
  
  public static Object[] a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = AuthMemoryCache.a().a(paramString1);
    Object localObject = paramAppRuntime.getAccount();
    if ((!bool2) && (TextUtils.equals((CharSequence)localObject, paramString1)))
    {
      boolean bool1;
      if (a(paramString1, paramAppRuntime, true) != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool3 = a(paramString1, paramAppRuntime);
      SSOLog.a("AuthorityUtil", new Object[] { "getMsfCommand qq current account hasA2=", Boolean.valueOf(bool1), ", hasD2=", Boolean.valueOf(bool3) });
      if ((bool1) && (bool3)) {
        return new Object[] { paramString2, null };
      }
    }
    localObject = new appType.LoginSig();
    ((appType.LoginSig)localObject).type.set(8);
    byte[] arrayOfByte = a(paramString1, paramAppRuntime, true);
    if ((!bool2) && (arrayOfByte != null) && (a(paramString1, paramAppRuntime)))
    {
      SSOLog.a("AuthorityUtil", new Object[] { "getMsfCommand use qq cache" });
      ((appType.LoginSig)localObject).appid.set(16);
      ((appType.LoginSig)localObject).sig.set(ByteStringMicro.copyFrom(arrayOfByte));
      return new Object[] { paramString3, localObject };
    }
    paramAppRuntime = a(paramString1, paramAppRuntime, false);
    if (paramAppRuntime != null)
    {
      SSOLog.a("AuthorityUtil", new Object[] { "getMsfCommand use opensdk cache" });
      ((appType.LoginSig)localObject).appid.set(1600001540);
      ((appType.LoginSig)localObject).sig.set(ByteStringMicro.copyFrom(paramAppRuntime));
      return new Object[] { paramString3, localObject };
    }
    return new Object[] { paramString2, null };
  }
  
  public static String[] a(SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = paramSharedPreferences.getString("accList", null);
    if (paramSharedPreferences == null) {
      return null;
    }
    return paramSharedPreferences.split(",");
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getOpenId uin = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", appid = ");
    localStringBuilder.append(paramString2);
    SSOLog.b("AuthorityUtil", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      paramContext = OpensdkPreference.a(paramContext, "uin_openid_store");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(":");
      localStringBuilder.append(paramString1);
      return paramContext.getString(localStringBuilder.toString(), null);
    }
    return null;
  }
  
  public static boolean b(WtloginManager paramWtloginManager, String paramString)
  {
    if (paramWtloginManager == null)
    {
      paramWtloginManager = new StringBuilder();
      paramWtloginManager.append("isUserHaveA1 null == wtManager, uin=");
      paramWtloginManager.append(a(paramString));
      SSOLog.a("AuthorityUtil", new Object[] { paramWtloginManager.toString() });
      return false;
    }
    if (paramWtloginManager.isUserHaveA1(paramString, 16L))
    {
      paramWtloginManager = new StringBuilder();
      paramWtloginManager.append("isUserHaveA1 appid=16, uin=");
      paramWtloginManager.append(a(paramString));
      SSOLog.a("AuthorityUtil", new Object[] { paramWtloginManager.toString() });
      return true;
    }
    if (paramWtloginManager.isUserHaveA1(paramString, 1600001540L))
    {
      paramWtloginManager = new StringBuilder();
      paramWtloginManager.append("isUserHaveA1 appid=*540, uin=");
      paramWtloginManager.append(a(paramString));
      SSOLog.a("AuthorityUtil", new Object[] { paramWtloginManager.toString() });
      return true;
    }
    paramWtloginManager = new StringBuilder();
    paramWtloginManager.append("isUserHaveA1 false uin=");
    paramWtloginManager.append(a(paramString));
    SSOLog.a("AuthorityUtil", new Object[] { paramWtloginManager.toString() });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthorityUtil
 * JD-Core Version:    0.7.0.1
 */