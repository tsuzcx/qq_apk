package cooperation.qzone.webviewplugin;

import ancb;
import ancc;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.util.QzoneAuthorizeConfig;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneWebViewJsHandleLogic
{
  private static int a(Context paramContext, String paramString, int paramInt, WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    int i = 2;
    if (paramContext == null) {
      return 5;
    }
    if (a(paramString)) {
      if (a(paramContext, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "simpleSchemeJump");
        }
        a(paramContext, Uri.parse(paramString));
        paramInt = 1;
      }
    }
    for (;;)
    {
      return paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "showQzoneAppDownloadDialog");
      }
      a(paramContext, paramPluginRuntime);
      paramInt = i;
      continue;
      if (URLUtil.isNetworkUrl(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "isNetworkUrl do nothing");
        }
        paramInt = 5;
      }
      else
      {
        paramInt = 5;
      }
    }
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        String str = Uri.parse(paramString).getQueryParameter("_wv");
        if (str == null) {
          return a(paramString, "_wv", String.valueOf(paramInt));
        }
        if (paramBoolean)
        {
          str = a(paramString, "_wv", String.valueOf(Integer.valueOf(str).intValue() | paramInt));
          return str;
        }
      }
      catch (Exception localException) {}
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    String str = paramString2 + '=';
    int i = paramString1.indexOf(str);
    int j;
    if (i != -1)
    {
      if (i == 0) {}
      do
      {
        i = paramString1.indexOf(str, str.length() + i);
        break;
        j = paramString1.charAt(i - 1);
      } while ((j != 63) && (j != 35) && (j != 38));
    }
    int k;
    if (i > -1)
    {
      k = i + str.length();
      j = k;
      if (j < paramString1.length())
      {
        int m = paramString1.charAt(j);
        if ((m != 38) && (m != 35)) {}
      }
      else
      {
        if ((!paramString2.equals("_wv")) || (i <= paramString1.indexOf('#'))) {
          break label188;
        }
        paramString1 = Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
      }
    }
    for (;;)
    {
      return paramString1;
      j += 1;
      break;
      label188:
      paramString1 = paramString1.substring(0, k) + paramString3 + paramString1.substring(j);
      continue;
      paramString1 = Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
    }
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("SignInSbumited");
    if (paramActivity != null) {
      paramActivity.sendBroadcast(localIntent);
    }
  }
  
  private static void a(Context paramContext)
  {
    Intent localIntent;
    if (paramContext != null)
    {
      String str1 = QzoneConfig.getInstance().getConfig("MiniVideo", "DownloadWeishiFromMarket", "market://details?id=com.tencent.weishi");
      if (!TextUtils.isEmpty(str1))
      {
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(str1));
      }
    }
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      String str2;
      do
      {
        str2 = QzoneConfig.getInstance().getConfig("MiniVideo", "DownloadWeishiFromURL", "http://android.myapp.com/myapp/detail.htm?apkName=com.tencent.weishi");
      } while (TextUtils.isEmpty(str2));
      localIntent.setData(Uri.parse(str2));
      try
      {
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("QZoneWebViewJsHandleLogic", 1, "goToDownloadWeishi catch an exception.", paramContext);
      }
    }
  }
  
  static void a(Context paramContext, Uri paramUri)
  {
    Intent localIntent = new Intent();
    localIntent.setData(paramUri);
    localIntent.setPackage("com.qzone");
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    paramPluginRuntime = DialogUtil.a(paramContext, 0);
    paramPluginRuntime.setMessage(paramContext.getString(2131434607));
    paramPluginRuntime.setPositiveButton(paramContext.getString(2131434609), new ancb(paramContext));
    paramPluginRuntime.setNegativeButton(paramContext.getString(2131435886), new ancc(paramPluginRuntime));
    try
    {
      if (!paramPluginRuntime.isShowing()) {
        paramPluginRuntime.show();
      }
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("showQzoneAppDownloadDialog", 2, "mDialog.show() exception", paramContext);
    }
  }
  
  /* Error */
  private static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aload_0
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: new 247	org/json/JSONObject
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 248	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: aload 5
    //   19: ldc 250
    //   21: invokevirtual 253	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   24: istore_2
    //   25: aload 5
    //   27: ldc 255
    //   29: invokevirtual 258	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_1
    //   33: aload 5
    //   35: ldc_w 260
    //   38: invokevirtual 253	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   41: istore 4
    //   43: iload 4
    //   45: istore_3
    //   46: new 143	android/content/Intent
    //   49: dup
    //   50: invokespecial 144	android/content/Intent:<init>	()V
    //   53: astore 5
    //   55: aload 5
    //   57: ldc_w 262
    //   60: invokevirtual 150	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   63: pop
    //   64: aload 5
    //   66: ldc 250
    //   68: iload_2
    //   69: invokevirtual 266	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   72: pop
    //   73: aload 5
    //   75: ldc 255
    //   77: aload_1
    //   78: invokestatic 272	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: invokevirtual 275	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   84: pop
    //   85: aload 5
    //   87: ldc_w 277
    //   90: ldc_w 279
    //   93: invokevirtual 282	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   96: pop
    //   97: aload 5
    //   99: ldc_w 260
    //   102: iload_3
    //   103: invokevirtual 266	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   106: pop
    //   107: aload_0
    //   108: invokevirtual 287	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   111: astore_0
    //   112: aload_0
    //   113: ifnull -107 -> 6
    //   116: aload_0
    //   117: aload 5
    //   119: invokevirtual 156	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   122: return
    //   123: astore 5
    //   125: ldc_w 289
    //   128: astore_1
    //   129: iconst_m1
    //   130: istore_2
    //   131: aload 5
    //   133: invokevirtual 292	org/json/JSONException:printStackTrace	()V
    //   136: goto -90 -> 46
    //   139: astore 5
    //   141: ldc_w 289
    //   144: astore_1
    //   145: goto -14 -> 131
    //   148: astore 5
    //   150: goto -19 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramPluginRuntime	WebViewPlugin.PluginRuntime
    //   0	153	1	paramString	String
    //   24	107	2	i	int
    //   1	102	3	j	int
    //   41	3	4	k	int
    //   15	103	5	localObject	Object
    //   123	9	5	localJSONException1	JSONException
    //   139	1	5	localJSONException2	JSONException
    //   148	1	5	localJSONException3	JSONException
    // Exception table:
    //   from	to	target	type
    //   7	25	123	org/json/JSONException
    //   25	33	139	org/json/JSONException
    //   33	43	148	org/json/JSONException
  }
  
  private static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramPluginRuntime != null) && (paramPluginRuntime.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      int i = new JSONObject(paramVarArgs[0]).optInt("isSpecialFollow", -1);
      paramPluginRuntime = new Intent("updateIsSpecialFollow");
      paramPluginRuntime.putExtra("isSpecialFollow", i);
      BaseApplicationImpl.getApplication().sendBroadcast(paramPluginRuntime);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewJsHandleLogic", 1, "followStatus = " + i);
      }
      return;
    }
    catch (Exception paramPluginRuntime)
    {
      QLog.e("QZoneWebViewJsHandleLogic", 1, "handleUpdateIsSpecialFollow catch an exception. ", paramPluginRuntime);
    }
  }
  
  private static void a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramPluginRuntime == null) || (paramVarArgs.length <= 0)) {}
    label168:
    Object localObject4;
    label383:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            localObject1 = new JSONObject(paramVarArgs[0]);
            paramVarArgs = ((JSONObject)localObject1).optString("schema");
            if (TextUtils.isEmpty(paramVarArgs)) {
              continue;
            }
            localObject2 = paramPluginRuntime.a().getUrl();
            if (!QzoneAuthorizeConfig.a().a((String)localObject2, paramVarArgs))
            {
              QLog.e("QZoneWebViewJsHandleLogic", 1, "has no right handle this jsapi");
              return;
            }
          }
          catch (JSONException paramWebViewPlugin)
          {
            paramWebViewPlugin.printStackTrace();
            QLog.e("QZoneWebViewJsHandleLogic", 1, "handleSchema", paramWebViewPlugin);
            return;
          }
          localObject1 = ((JSONObject)localObject1).optJSONObject("dealparam");
          if (localObject1 == null) {
            break label974;
          }
          localObject2 = ((JSONObject)localObject1).optString("url");
          localObject1 = ((JSONObject)localObject1).optString("blogurl", "");
          if ((TextUtils.isEmpty(paramVarArgs)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
            break label971;
          }
          paramVarArgs = paramVarArgs + "&url=" + (String)localObject2;
          if (QLog.isColorLevel()) {
            QLog.d("QZoneWebViewPlugin", 2, " handleSchema scheme:" + paramVarArgs);
          }
          localObject4 = null;
          if (paramPluginRuntime != null) {
            localObject4 = paramPluginRuntime.a();
          }
          localObject3 = localObject4;
          if (localObject4 != null)
          {
            localObject3 = localObject4;
            if ((localObject4 instanceof BasePluginActivity)) {
              localObject3 = ((BasePluginActivity)localObject4).getOutActivity();
            }
          }
          localObject4 = localObject3;
          if (localObject3 != null)
          {
            localObject4 = localObject3;
            if ((localObject3 instanceof BasePluginActivity)) {
              localObject4 = ((BasePluginActivity)localObject3).getOutActivity();
            }
          }
          boolean bool = paramVarArgs.startsWith("mqzone://arouse/userhome");
          if (bool)
          {
            if (localObject4 == null) {
              continue;
            }
            try
            {
              if (paramVarArgs.indexOf("uin=") != -1)
              {
                paramWebViewPlugin = paramVarArgs.substring(paramVarArgs.indexOf("uin=") + 4, paramVarArgs.length());
                QZoneHelper.a((Activity)localObject4, QZoneHelper.UserInfo.a(), paramWebViewPlugin, 0, 0, 0);
                return;
              }
            }
            catch (Exception paramWebViewPlugin)
            {
              paramWebViewPlugin.printStackTrace();
              return;
            }
          }
        }
        if (!paramVarArgs.startsWith("mqzone://arouse/webtofeeddetail")) {
          break;
        }
      } while (localObject4 == null);
      paramPluginRuntime = paramPluginRuntime.a((Activity)localObject4);
      if (!(paramPluginRuntime instanceof WebViewPluginContainer)) {
        break label983;
      }
      i = ((WebViewPluginContainer)paramPluginRuntime).a(paramWebViewPlugin, (byte)3);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QZoneHelper.a((Activity)localObject4, QZoneHelper.UserInfo.a(), (String)localObject2, i);
        return;
      }
      QZoneHelper.a((Activity)localObject4, QZoneHelper.UserInfo.a(), (String)localObject2, i, (String)localObject1);
      return;
      if (!paramVarArgs.startsWith("mqzone://arouse/detail")) {
        break;
      }
    } while (localObject4 == null);
    paramVarArgs = Uri.parse(paramVarArgs);
    Object localObject1 = paramVarArgs.getQueryParameter("uin");
    Object localObject2 = paramVarArgs.getQueryParameter("appid");
    Object localObject3 = paramVarArgs.getQueryParameter("cellid");
    String str1 = paramVarArgs.getQueryParameter("subid");
    Object localObject5 = paramVarArgs.getQueryParameter("source");
    String str2 = paramVarArgs.getQueryParameter("cookie");
    String str3 = paramVarArgs.getQueryParameter("local_city_feedindex");
    String str4 = paramVarArgs.getQueryParameter("ugckey");
    String str5 = paramVarArgs.getQueryParameter("feedData");
    Bundle localBundle = new Bundle();
    if (localObject5 != null) {
      localBundle.putString("source", (String)localObject5);
    }
    if (str2 != null) {
      localBundle.putString("cookie", str2);
    }
    if (str3 != null) {
      localBundle.putString("local_city_feedindex", str3);
    }
    if (str4 != null) {
      localBundle.putString("ugckey", str4);
    }
    if (str5 != null) {
      localBundle.putString("local_city_feedData", str5);
    }
    localObject5 = paramPluginRuntime.a((Activity)localObject4);
    if ((localObject5 instanceof WebViewPluginContainer)) {}
    for (int i = ((WebViewPluginContainer)localObject5).a(paramWebViewPlugin, (byte)3);; i = 3)
    {
      paramWebViewPlugin = QZoneHelper.UserInfo.a();
      paramWebViewPlugin.a = paramPluginRuntime.a().getAccount();
      paramPluginRuntime = new Bundle();
      paramPluginRuntime.putString("source", paramVarArgs.getQueryParameter("source"));
      paramPluginRuntime.putString("bypassparam", paramVarArgs.getQueryParameter("bypassparam"));
      paramPluginRuntime.putAll(localBundle);
      QZoneHelper.a((Activity)localObject4, paramWebViewPlugin, (String)localObject1, (String)localObject2, (String)localObject3, str1, i, paramPluginRuntime);
      return;
      if ("mqzone://arouse/dynamicnickname".equalsIgnoreCase(paramVarArgs))
      {
        if ((paramPluginRuntime == null) || (paramPluginRuntime.a() == null) || (paramPluginRuntime.a() == null)) {
          break;
        }
        QZoneHelper.a(paramPluginRuntime.a(), paramPluginRuntime.a().getAccount());
        return;
      }
      if (paramVarArgs.startsWith("mqzone://arouse/uploadphoto"))
      {
        QZoneHelper.a(paramWebViewPlugin, paramPluginRuntime, paramPluginRuntime.a(), paramPluginRuntime.a().getAccount(), paramVarArgs);
        return;
      }
      if ((paramVarArgs.startsWith("mqzone://arouse/facade")) || (paramVarArgs.startsWith("mqzonev2://arouse/facade")))
      {
        a(paramPluginRuntime.a(), paramVarArgs, 81, paramPluginRuntime);
        return;
      }
      if (paramVarArgs.startsWith("mqzone://arouse/moodVoiceRecord"))
      {
        QZoneHelper.b(paramWebViewPlugin, paramPluginRuntime, paramPluginRuntime.a(), paramPluginRuntime.a().getAccount(), paramVarArgs);
        return;
      }
      localObject1 = new Intent("action_js2qzone");
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("cmd", "Schema");
      ((Bundle)localObject2).putString("schema", paramVarArgs);
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "handleSchema actionString: " + ((Intent)localObject1).getAction() + "scheme:" + paramVarArgs);
      }
      if (paramVarArgs.startsWith("mqzone://arouse/openvideolayer"))
      {
        i = QZoneWebViewPlugin.a(paramWebViewPlugin, paramPluginRuntime, 4);
        QZoneHelper.a((Activity)localObject4, QZoneHelper.UserInfo.a(), (Intent)localObject1, i);
        return;
      }
      QZoneHelper.a((Activity)localObject4, QZoneHelper.UserInfo.a(), (Intent)localObject1);
      return;
      label971:
      break label168;
      label974:
      localObject2 = null;
      localObject1 = null;
      break label168;
      label983:
      i = 3;
      break label383;
    }
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("handleUrl", 2, "browse url fail:" + paramString);
      }
    }
    do
    {
      return;
      paramString = a(paramString, 7, false);
      Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("fromQZone", true);
      localIntent.putExtra("injectrecommend", true);
      localIntent.setData(Uri.parse(paramString));
      localIntent.addFlags(268435456);
      localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131432876));
      paramContext.startActivity(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("handleurl", 2, "jump to browser: " + paramString);
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    boolean bool2 = false;
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.qzone", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.versionCode >= paramInt) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public static boolean a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String paramString, String... paramVarArgs)
  {
    if ("SendGiftFinished".equalsIgnoreCase(paramString)) {
      d(paramPluginRuntime, paramVarArgs);
    }
    do
    {
      return true;
      if ("openAppDetail".equalsIgnoreCase(paramString))
      {
        e(paramPluginRuntime, paramVarArgs);
        return true;
      }
      if ("Schema".equalsIgnoreCase(paramString))
      {
        a(paramWebViewPlugin, paramPluginRuntime, paramVarArgs);
        return true;
      }
      if (!"refreshFeeds".equals(paramString)) {
        break;
      }
    } while (paramPluginRuntime.a() == null);
    a(paramPluginRuntime.a());
    return true;
    if ("UpdateFamousSpaceVpageOptions".equalsIgnoreCase(paramString))
    {
      a(paramPluginRuntime, paramVarArgs[0]);
      return true;
    }
    if ("clickWeiShiWidget".equalsIgnoreCase(paramString))
    {
      c(paramPluginRuntime, paramVarArgs);
      return true;
    }
    if ("showFamousSpaceVpageOptions".equalsIgnoreCase(paramString))
    {
      b(paramPluginRuntime, paramVarArgs);
      return true;
    }
    if ("updateNativeIsSpecialFollow".equalsIgnoreCase(paramString))
    {
      a(paramPluginRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString).getScheme();
      if (("mqzone".equals(paramString)) || ("mqzonev2".equals(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private static void b(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramPluginRuntime != null) && (paramPluginRuntime.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      int i = new JSONObject(paramVarArgs[0]).optInt("followStatus");
      paramPluginRuntime = new Intent("showFollowActionSheet");
      paramPluginRuntime.putExtra("followStatus", i);
      BaseApplicationImpl.getApplication().sendBroadcast(paramPluginRuntime);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewJsHandleLogic", 1, "followStatus = " + i);
      }
      return;
    }
    catch (Exception paramPluginRuntime)
    {
      QLog.e("QZoneWebViewJsHandleLogic", 1, "handleShowFollowActionSheet catch an exception. ", paramPluginRuntime);
    }
  }
  
  private static void c(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    Activity localActivity;
    if ((paramPluginRuntime != null) && (paramPluginRuntime.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localActivity = paramPluginRuntime.a();
      if (PackageUtil.a(localActivity, "com.tencent.weishi"))
      {
        paramPluginRuntime = "";
        try
        {
          paramVarArgs = new JSONObject(paramVarArgs[0]).optString("schema");
          paramPluginRuntime = paramVarArgs;
          if (!TextUtils.isEmpty(paramVarArgs))
          {
            paramPluginRuntime = paramVarArgs;
            Intent localIntent = new Intent();
            paramPluginRuntime = paramVarArgs;
            localIntent.setAction("android.intent.action.VIEW");
            paramPluginRuntime = paramVarArgs;
            localIntent.setData(Uri.parse(paramVarArgs));
            paramPluginRuntime = paramVarArgs;
            List localList = localActivity.getPackageManager().queryIntentActivities(localIntent, 65536);
            if (localList == null) {
              break label171;
            }
            paramPluginRuntime = paramVarArgs;
            if (localList.size() <= 0) {
              break label171;
            }
            paramPluginRuntime = paramVarArgs;
            localActivity.startActivity(localIntent);
          }
          for (;;)
          {
            paramPluginRuntime = paramVarArgs;
            if (!QLog.isColorLevel()) {
              break;
            }
            paramPluginRuntime = paramVarArgs;
            QLog.d("QZoneWebViewJsHandleLogic", 1, "weishi schema is " + paramVarArgs);
            return;
            label171:
            paramPluginRuntime = paramVarArgs;
            a(localActivity);
          }
          a(localActivity);
        }
        catch (Exception paramVarArgs)
        {
          QLog.e("QZoneWebViewJsHandleLogic", 1, "handleClickWeiShiWidget catch an exception. weishi schema is " + paramPluginRuntime, paramVarArgs);
          return;
        }
      }
    }
  }
  
  private static void d(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new JSONObject(paramVarArgs[0]);
        if (((JSONObject)localObject).getInt("success") == 1)
        {
          paramVarArgs = ((JSONObject)localObject).getJSONArray("uins");
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("birthdays");
          String str = ((JSONObject)localObject).getString("giftmessage");
          int j = ((JSONObject)localObject).optInt("giftid");
          if ((paramVarArgs != null) && (paramVarArgs.length() > 0) && (localJSONArray != null) && (localJSONArray.length() == paramVarArgs.length()))
          {
            if ((((JSONObject)localObject).has("toast")) && (((JSONObject)localObject).getBoolean("toast"))) {
              QQToast.a(paramPluginRuntime.a(), 2, 2131437252, 0).a();
            }
            localObject = new long[paramVarArgs.length()];
            long[] arrayOfLong = new long[localJSONArray.length()];
            while (i < paramVarArgs.length())
            {
              localObject[i] = paramVarArgs.getLong(i);
              arrayOfLong[i] = localJSONArray.getLong(i);
              i += 1;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("key_msg_type", 2);
            localIntent.putExtra("key_friend_list", (long[])localObject);
            localIntent.putExtra("key_time_list", arrayOfLong);
            localIntent.putExtra("key_msg_content", str);
            localIntent.putExtra("key_gift_id", j);
            paramPluginRuntime.a().setResult(-1, localIntent);
            paramPluginRuntime.a().finish();
            if (QLog.isColorLevel())
            {
              QLog.d("QZoneWebViewJsHandleLogic", 2, "the giftid is " + j + "\n the giftmessage is" + str + "\n the uins are: " + paramVarArgs.toString() + "\n the birthdays are: " + localJSONArray.toString());
              return;
            }
          }
        }
      }
      catch (JSONException paramPluginRuntime)
      {
        paramPluginRuntime.printStackTrace();
      }
    }
  }
  
  private static void e(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject2).getString("packName");
        Object localObject1 = ((JSONObject)localObject2).getString("taskAppId");
        String str1 = ((JSONObject)localObject2).getString("appId");
        String str2 = ((JSONObject)localObject2).getString("taskApkId");
        String str3 = ((JSONObject)localObject2).getString("via");
        String str4 = ((JSONObject)localObject2).getString("versionCode");
        String str5 = ((JSONObject)localObject2).getString("channel");
        localObject2 = ((JSONObject)localObject2).getString("from");
        int j = 3;
        int i = j;
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            i = Integer.parseInt((String)localObject2);
          }
          localObject2 = new StringBuilder();
          if (!TextUtils.isEmpty(str1)) {
            ((StringBuilder)localObject2).append(DownloadConstants.a).append("=").append(str1);
          }
          if (!TextUtils.isEmpty(paramVarArgs)) {
            ((StringBuilder)localObject2).append("&").append(DownloadConstants.e).append("=").append(paramVarArgs);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((StringBuilder)localObject2).append("&").append(DownloadConstants.b).append("=").append((String)localObject1);
          }
          if (!TextUtils.isEmpty(str2)) {
            ((StringBuilder)localObject2).append("&").append(DownloadConstants.c).append("=").append(str2);
          }
          if (!TextUtils.isEmpty(str3)) {
            ((StringBuilder)localObject2).append("&").append(DownloadConstants.h).append("=").append(str3);
          }
          if (!TextUtils.isEmpty(str4)) {
            ((StringBuilder)localObject2).append("&").append(DownloadConstants.d).append("=").append(str4);
          }
          if (!TextUtils.isEmpty(str5)) {
            ((StringBuilder)localObject2).append("&").append(DownloadConstants.A).append("=").append(str5);
          }
          paramVarArgs = ((StringBuilder)localObject2).toString();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("from", i);
          ((Bundle)localObject1).putString("schemaUrl", paramVarArgs);
          AppClient.a(paramPluginRuntime.a(), (Bundle)localObject1);
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.e("QZoneWebViewJsHandleLogic", 2, "from 错误", localNumberFormatException);
              i = j;
            }
          }
        }
        return;
      }
      catch (JSONException paramPluginRuntime)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZoneWebViewJsHandleLogic", 2, "json 解析异常", paramPluginRuntime);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */