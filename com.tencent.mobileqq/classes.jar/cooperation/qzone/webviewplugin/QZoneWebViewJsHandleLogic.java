package cooperation.qzone.webviewplugin;

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
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener;
import com.tencent.qzonehub.api.impl.QZoneHelperProxyImpl;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneAuthorizeConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneWebViewJsHandleLogic
{
  public static final String ACTION_PICK_GAME_MATES = "qzone.pickgamemates";
  private static final String JS_CALL_CARE_SPECIAL_FAMOUS_SPACE_METHOD = "UpdateFamousSpaceVpageOptions";
  public static final String STR_GAMEMATES = "gamemates";
  public static final String TAG = "QZoneWebViewJsHandleLogic";
  static String mShareMsgCallback;
  static CustomWebView webview;
  static IQzoneShareApi.WXShareListener wxShareListener = new QZoneWebViewJsHandleLogic.1();
  
  public static String appendQueryParameter(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append('=');
    localObject = ((StringBuilder)localObject).toString();
    int j;
    for (int i = paramString1.indexOf((String)localObject); i != -1; i = paramString1.indexOf((String)localObject, i + ((String)localObject).length())) {
      if (i != 0)
      {
        j = paramString1.charAt(i - 1);
        if ((j == 63) || (j == 35) || (j == 38)) {
          break;
        }
      }
    }
    if (i > -1)
    {
      int k = ((String)localObject).length() + i;
      j = k;
      while (j < paramString1.length())
      {
        int m = paramString1.charAt(j);
        if ((m == 38) || (m == 35)) {
          break;
        }
        j += 1;
      }
      if ((paramString2.equals("_wv")) && (i > paramString1.indexOf('#'))) {
        return Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
      }
      paramString2 = new StringBuilder(paramString1.substring(0, k));
      paramString2.append(paramString3);
      paramString2.append(paramString1.substring(j));
      return paramString2.toString();
    }
    return Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
  }
  
  public static String appendWVParameter(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      String str2 = Uri.parse(paramString).getQueryParameter("_wv");
      if (str2 == null) {
        return appendQueryParameter(paramString, "_wv", String.valueOf(paramInt));
      }
      String str1 = paramString;
      if (paramBoolean) {
        str1 = appendQueryParameter(paramString, "_wv", String.valueOf(paramInt | Integer.valueOf(str2).intValue()));
      }
      return str1;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  private static boolean checkScheme(String paramString)
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
  
  public static boolean disPatchMethod(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String paramString, String... paramVarArgs)
  {
    if ("updateFeedContainer".equalsIgnoreCase(paramString))
    {
      updateFeedContainer(paramPluginRuntime, paramVarArgs);
      return true;
    }
    if ("SendGiftFinished".equalsIgnoreCase(paramString))
    {
      handleSendGift(paramPluginRuntime, paramVarArgs);
      return true;
    }
    if ("sendGiftSuccess".equalsIgnoreCase(paramString))
    {
      handleSendGiftSuccess(paramPluginRuntime, paramVarArgs);
      return true;
    }
    if ("openAppDetail".equalsIgnoreCase(paramString))
    {
      handleOpenAppDetail(paramPluginRuntime, paramVarArgs);
      return true;
    }
    if ("Schema".equalsIgnoreCase(paramString))
    {
      handleSchema(paramWebViewPlugin, paramPluginRuntime, paramVarArgs);
      return true;
    }
    if ("refreshFeeds".equals(paramString))
    {
      if (paramPluginRuntime.a() != null) {
        doRefreshFeed(paramPluginRuntime.a());
      }
      return true;
    }
    if ("UpdateFamousSpaceVpageOptions".equalsIgnoreCase(paramString))
    {
      handleCareSpecialFamousSpace(paramPluginRuntime, paramVarArgs[0]);
      return true;
    }
    if ("clickWeiShiWidget".equalsIgnoreCase(paramString))
    {
      handleClickWeiShiWidget(paramPluginRuntime, paramVarArgs);
      return true;
    }
    if ("showFamousSpaceVpageOptions".equalsIgnoreCase(paramString))
    {
      handleShowFollowActionSheet(paramPluginRuntime, paramVarArgs);
      return true;
    }
    if ("updateNativeIsSpecialFollow".equalsIgnoreCase(paramString))
    {
      handleUpdateIsSpecialFollow(paramPluginRuntime, paramVarArgs);
      return true;
    }
    if ("ShareToWXMiniProgram".equals(paramString))
    {
      shareMiniProgramFromQzone(paramPluginRuntime, paramVarArgs);
      return true;
    }
    if ("pickGameMates".equals(paramString))
    {
      handleGameMates(paramPluginRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
  
  public static void doRefreshFeed(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("SignInSbumited");
    if (paramActivity != null) {
      paramActivity.sendBroadcast(localIntent);
    }
  }
  
  private static void goToDownloadWeiShiApp(Context paramContext)
  {
    Intent localIntent;
    if (paramContext != null)
    {
      str = QzoneConfig.getInstance().getConfig("MiniVideo", "DownloadWeishiFromMarket", "market://details?id=com.tencent.weishi");
      if (!TextUtils.isEmpty(str))
      {
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(str));
        QZoneHelper.addSource(localIntent);
      }
    }
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      label53:
      break label53;
    }
    String str = QzoneConfig.getInstance().getConfig("MiniVideo", "DownloadWeishiFromURL", "https://isee.weishi.qq.com/iseev2/1/PSg56S8_e/index.html?_wwv=4096");
    if (!TextUtils.isEmpty(str))
    {
      localIntent.setData(Uri.parse(str));
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
  
  private static void handleCareSpecialFamousSpace(WebViewPlugin.PluginRuntime paramPluginRuntime, String paramString)
  {
    if (paramPluginRuntime == null) {
      return;
    }
    Object localObject = "0";
    int j = -1;
    int i;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      i = localJSONObject.optInt("isconcern");
      paramString = (String)localObject;
      try
      {
        localObject = localJSONObject.optString("uin");
        paramString = (String)localObject;
        int k = localJSONObject.optInt("noSpecialCareToast");
        paramString = (String)localObject;
        j = k;
      }
      catch (JSONException localJSONException1) {}
      localJSONException2.printStackTrace();
    }
    catch (JSONException localJSONException2)
    {
      i = -1;
      paramString = (String)localObject;
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("JsCallNativeAction");
    ((Intent)localObject).putExtra("isconcern", i);
    ((Intent)localObject).putExtra("uin", Long.parseLong(paramString));
    ((Intent)localObject).putExtra("key_jump_from", "key_from_h5_cover_user_home");
    ((Intent)localObject).putExtra("noSpecialCareToast", j);
    paramPluginRuntime = paramPluginRuntime.a();
    if (paramPluginRuntime != null) {
      paramPluginRuntime.sendBroadcast((Intent)localObject);
    }
  }
  
  private static void handleClickWeiShiWidget(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramPluginRuntime != null) && (paramPluginRuntime.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      Object localObject = paramPluginRuntime.a();
      if (PackageUtil.a((Context)localObject, "com.tencent.weishi"))
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
            QZoneHelper.addSource(localIntent);
            paramPluginRuntime = paramVarArgs;
            List localList = ((Context)localObject).getPackageManager().queryIntentActivities(localIntent, 65536);
            if (localList != null)
            {
              paramPluginRuntime = paramVarArgs;
              if (localList.size() > 0)
              {
                paramPluginRuntime = paramVarArgs;
                ((Context)localObject).startActivity(localIntent);
                break label149;
              }
            }
            paramPluginRuntime = paramVarArgs;
            goToDownloadWeiShiApp((Context)localObject);
          }
          label149:
          paramPluginRuntime = paramVarArgs;
          if (!QLog.isColorLevel()) {
            return;
          }
          paramPluginRuntime = paramVarArgs;
          localObject = new StringBuilder();
          paramPluginRuntime = paramVarArgs;
          ((StringBuilder)localObject).append("weishi schema is ");
          paramPluginRuntime = paramVarArgs;
          ((StringBuilder)localObject).append(paramVarArgs);
          paramPluginRuntime = paramVarArgs;
          QLog.d("QZoneWebViewJsHandleLogic", 1, ((StringBuilder)localObject).toString());
          return;
        }
        catch (Exception paramVarArgs)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleClickWeiShiWidget catch an exception. weishi schema is ");
          ((StringBuilder)localObject).append(paramPluginRuntime);
          QLog.e("QZoneWebViewJsHandleLogic", 1, ((StringBuilder)localObject).toString(), paramVarArgs);
          return;
        }
      }
      else
      {
        goToDownloadWeiShiApp((Context)localObject);
      }
    }
  }
  
  private static void handleGameMates(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramPluginRuntime != null) && (paramPluginRuntime.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      paramPluginRuntime = new Intent("qzone.pickgamemates");
      paramPluginRuntime.putExtra("gamemates", paramVarArgs[0]);
      BaseApplicationImpl.getApplication().sendBroadcast(paramPluginRuntime);
      if (QLog.isColorLevel())
      {
        paramPluginRuntime = new StringBuilder();
        paramPluginRuntime.append("handleGameMates = ");
        paramPluginRuntime.append(paramVarArgs[0]);
        QLog.d("QZoneWebViewJsHandleLogic", 1, paramPluginRuntime.toString());
      }
    }
  }
  
  private static void handleOpenAppDetail(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
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
        }
        catch (NumberFormatException localNumberFormatException)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.e("QZoneWebViewJsHandleLogic", 2, "from 错误", localNumberFormatException);
            i = j;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        boolean bool = TextUtils.isEmpty(str1);
        if (!bool)
        {
          localStringBuilder.append(DownloadConstants.b);
          localStringBuilder.append("=");
          localStringBuilder.append(str1);
        }
        bool = TextUtils.isEmpty(paramVarArgs);
        if (!bool)
        {
          localStringBuilder.append("&");
          localStringBuilder.append(DownloadConstants.f);
          localStringBuilder.append("=");
          localStringBuilder.append(paramVarArgs);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localStringBuilder.append("&");
          localStringBuilder.append(DownloadConstants.c);
          localStringBuilder.append("=");
          localStringBuilder.append((String)localObject1);
        }
        if (!TextUtils.isEmpty(str2))
        {
          localStringBuilder.append("&");
          localStringBuilder.append(DownloadConstants.d);
          localStringBuilder.append("=");
          localStringBuilder.append(str2);
        }
        if (!TextUtils.isEmpty(str3))
        {
          localStringBuilder.append("&");
          localStringBuilder.append(DownloadConstants.i);
          localStringBuilder.append("=");
          localStringBuilder.append(str3);
        }
        if (!TextUtils.isEmpty(str4))
        {
          localStringBuilder.append("&");
          localStringBuilder.append(DownloadConstants.e);
          localStringBuilder.append("=");
          localStringBuilder.append(str4);
        }
        if (!TextUtils.isEmpty(str5))
        {
          localStringBuilder.append("&");
          localStringBuilder.append(DownloadConstants.D);
          localStringBuilder.append("=");
          localStringBuilder.append(str5);
        }
        paramVarArgs = localStringBuilder.toString();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("from", i);
        ((Bundle)localObject1).putString("schemaUrl", paramVarArgs);
        QZoneHelper.addSource((Bundle)localObject1);
        AppClient.a(paramPluginRuntime.a(), (Bundle)localObject1);
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
  
  private static void handlePublishMoodSilently(WebViewPlugin.PluginRuntime paramPluginRuntime, String[] paramArrayOfString)
  {
    int i;
    if ((paramPluginRuntime != null) && (paramPluginRuntime.a() != null) && (paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      i = 0;
    }
    try
    {
      localObject3 = new JSONObject(paramArrayOfString[0]);
      str1 = (String)((JSONObject)localObject3).opt("content");
      str2 = (String)((JSONObject)localObject3).opt("videoPath");
      j = ((JSONObject)localObject3).optInt("issynctoweibo");
      ((JSONObject)localObject3).getJSONObject("lbsinfo");
      paramArrayOfString = ((JSONObject)localObject3).getJSONObject("source");
      if (paramArrayOfString == null) {
        break label373;
      }
      paramArrayOfString = paramArrayOfString.optString("subtype");
    }
    catch (Exception paramPluginRuntime)
    {
      for (;;)
      {
        Object localObject3;
        String str1;
        String str2;
        int j;
        HashMap localHashMap;
        Object localObject2;
        int k;
        ArrayList localArrayList;
        JSONArray localJSONArray;
        continue;
        paramArrayOfString = null;
        continue;
        Object localObject1 = null;
      }
    }
    localHashMap = new HashMap();
    localObject1 = ((JSONObject)localObject3).getJSONObject("extend_info");
    if (localObject1 != null)
    {
      localObject2 = ((JSONObject)localObject1).optString("checkinfall");
      k = ((JSONObject)localObject1).optInt("comm_self_define_tail_id");
      localHashMap.put("checkinfall", localObject2);
      localHashMap.put("comm_self_define_tail_id", String.valueOf(k));
    }
    localArrayList = new ArrayList();
    localObject1 = ((JSONObject)localObject3).getJSONObject("right_info");
    if (localObject1 != null)
    {
      localObject2 = ((JSONObject)localObject1).optString("ugc_right");
      localJSONArray = ((JSONObject)localObject1).optJSONArray("allow_uins");
      localObject1 = localObject2;
      if (localJSONArray != null) {
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= localJSONArray.length()) {
            break;
          }
          localArrayList.add((String)localJSONArray.get(i));
          i += 1;
        }
      }
      localObject2 = new HashMap();
      localObject3 = ((JSONObject)localObject3).getJSONObject("stored_extend_info");
      if (localObject3 != null) {
        ((HashMap)localObject2).put("event_tags", ((JSONObject)localObject3).optString("event_tags"));
      }
      localObject3 = new ArrayList();
      ((ArrayList)localObject3).add(str2);
      QZoneHelper.UserInfo.getInstance().qzone_uin = paramPluginRuntime.a().getCurrentAccountUin();
      QZoneHelper.publishPictureMoodSilently(str1, (ArrayList)localObject3, j, null, paramArrayOfString, (String)localObject1, localArrayList, (HashMap)localObject2, localHashMap, "value.videoSign", 2);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("QZoneWebViewJsHandleLogic", 2, "handlePickQzoneAlbum,decode param error");
      }
      return;
    }
  }
  
  private static void handleSchema(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramPluginRuntime != null)) {
      if (paramVarArgs.length <= 0) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject5 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject5).optString("schema");
        if (TextUtils.isEmpty(paramVarArgs)) {
          return;
        }
        localObject1 = paramPluginRuntime.a().getUrl();
        if (!QzoneAuthorizeConfig.getInstance().hasJsApiRight((String)localObject1, paramVarArgs))
        {
          QLog.e("QZoneWebViewJsHandleLogic", 1, "has no right handle this jsapi");
          return;
        }
        localObject2 = ((JSONObject)localObject5).optJSONObject("dealparam");
        if (localObject2 == null) {
          break label1165;
        }
        localObject1 = ((JSONObject)localObject2).optString("url");
        String str1 = ((JSONObject)localObject2).optString("blogurl", "");
        localObject2 = paramVarArgs;
        localObject3 = str1;
        localObject4 = localObject1;
        if (!TextUtils.isEmpty(paramVarArgs))
        {
          localObject2 = paramVarArgs;
          localObject3 = str1;
          localObject4 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramVarArgs);
            ((StringBuilder)localObject2).append("&url=");
            ((StringBuilder)localObject2).append((String)localObject1);
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject3 = str1;
            localObject4 = localObject1;
          }
        }
        bool = QLog.isColorLevel();
        if (bool)
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append(" handleSchema scheme:");
          paramVarArgs.append((String)localObject2);
          QLog.d("QZoneWebViewPlugin", 2, paramVarArgs.toString());
        }
        if (paramPluginRuntime == null) {
          break label1177;
        }
        localObject1 = paramPluginRuntime.a();
        paramVarArgs = (String[])localObject1;
        if (localObject1 != null)
        {
          paramVarArgs = (String[])localObject1;
          if ((localObject1 instanceof BasePluginActivity)) {
            paramVarArgs = ((BasePluginActivity)localObject1).getOutActivity();
          }
        }
        localObject1 = paramVarArgs;
        if (paramVarArgs != null)
        {
          localObject1 = paramVarArgs;
          if ((paramVarArgs instanceof BasePluginActivity)) {
            localObject1 = ((BasePluginActivity)paramVarArgs).getOutActivity();
          }
        }
        bool = ((String)localObject2).startsWith("mqzone://arouse/userhome");
        if ((bool) && (localObject1 == null)) {
          break label1164;
        }
        try
        {
          if (((String)localObject2).indexOf("uin=") == -1) {
            break label1164;
          }
          paramWebViewPlugin = ((String)localObject2).substring(((String)localObject2).indexOf("uin=") + 4, ((String)localObject2).length());
          QZoneHelper.forwardToUserHome((Context)localObject1, QZoneHelper.UserInfo.getInstance(), paramWebViewPlugin, 0, 0, 0);
          return;
        }
        catch (Exception paramWebViewPlugin)
        {
          paramWebViewPlugin.printStackTrace();
          return;
          bool = ((String)localObject2).startsWith("mqzone://arouse/webtofeeddetail");
          i = 3;
          if (bool)
          {
            if (localObject1 == null) {
              break label1164;
            }
            paramPluginRuntime = paramPluginRuntime.a((Activity)localObject1);
            if ((paramPluginRuntime instanceof WebViewPluginContainer)) {
              i = ((WebViewPluginContainer)paramPluginRuntime).switchRequestCode(paramWebViewPlugin, (byte)3);
            }
            if (TextUtils.isEmpty((CharSequence)localObject3))
            {
              QZoneHelper.forwardToDetail((Activity)localObject1, QZoneHelper.UserInfo.getInstance(), (String)localObject4, i);
              return;
            }
            QZoneHelper.forwardToDetail((Activity)localObject1, QZoneHelper.UserInfo.getInstance(), (String)localObject4, i, (String)localObject3);
            return;
          }
          if (((String)localObject2).startsWith("mqzone://arouse/detail"))
          {
            if (localObject1 == null) {
              break label1164;
            }
            paramVarArgs = Uri.parse((String)localObject2);
            localObject2 = paramVarArgs.getQueryParameter("uin");
            localObject3 = paramVarArgs.getQueryParameter("appid");
            localObject4 = paramVarArgs.getQueryParameter("cellid");
            str1 = paramVarArgs.getQueryParameter("subid");
            Object localObject6 = paramVarArgs.getQueryParameter("source");
            String str2 = paramVarArgs.getQueryParameter("cookie");
            String str3 = paramVarArgs.getQueryParameter("local_city_feedindex");
            String str4 = paramVarArgs.getQueryParameter("ugckey");
            String str5 = paramVarArgs.getQueryParameter("feedData");
            String str6 = paramVarArgs.getQueryParameter("needShowBottom");
            String str7 = paramVarArgs.getQueryParameter("urlForTodayInHistory");
            String str8 = paramVarArgs.getQueryParameter("buttonText");
            localObject5 = new Bundle();
            if (localObject6 != null) {
              ((Bundle)localObject5).putString("source", (String)localObject6);
            }
            if (str2 != null) {
              ((Bundle)localObject5).putString("cookie", str2);
            }
            if (str3 != null) {
              ((Bundle)localObject5).putString("local_city_feedindex", str3);
            }
            if (str4 != null) {
              ((Bundle)localObject5).putString("ugckey", str4);
            }
            if (str5 != null) {
              ((Bundle)localObject5).putString("local_city_feedData", str5);
            }
            if (str6 != null) {
              ((Bundle)localObject5).putString("show_share_btn", str6);
            }
            if (str7 != null) {
              ((Bundle)localObject5).putString("share_url", str7);
            }
            if (str8 != null) {
              ((Bundle)localObject5).putString("share_btn_text", str8);
            }
            localObject6 = paramPluginRuntime.a((Activity)localObject1);
            if (!(localObject6 instanceof WebViewPluginContainer)) {
              break label1183;
            }
            i = ((WebViewPluginContainer)localObject6).switchRequestCode(paramWebViewPlugin, (byte)3);
            paramWebViewPlugin = QZoneHelper.UserInfo.getInstance();
            paramWebViewPlugin.qzone_uin = paramPluginRuntime.a().getAccount();
            paramPluginRuntime = new Bundle();
            paramPluginRuntime.putString("source", paramVarArgs.getQueryParameter("source"));
            paramPluginRuntime.putString("bypassparam", paramVarArgs.getQueryParameter("bypassparam"));
            paramPluginRuntime.putAll((Bundle)localObject5);
            QZoneHelper.forwardToDetail((Activity)localObject1, paramWebViewPlugin, (String)localObject2, (String)localObject3, (String)localObject4, str1, i, paramPluginRuntime);
            return;
          }
          if ("mqzone://arouse/dynamicnickname".equalsIgnoreCase((String)localObject2))
          {
            if ((paramPluginRuntime == null) || (paramPluginRuntime.a() == null) || (paramPluginRuntime.a() == null)) {
              break label1164;
            }
            QZoneHelper.forwardToQZoneFlashNickNameSetting(paramPluginRuntime.a(), paramPluginRuntime.a().getAccount());
            return;
          }
          if (((String)localObject2).startsWith("mqzone://arouse/uploadphoto"))
          {
            QZoneHelperProxyImpl.forwardToUploadPhoto(paramWebViewPlugin, paramPluginRuntime, paramPluginRuntime.a(), paramPluginRuntime.a().getAccount(), (String)localObject2);
            return;
          }
          if ((!((String)localObject2).startsWith("mqzone://arouse/facade")) && (!((String)localObject2).startsWith("mqzonev2://arouse/facade")))
          {
            if (((String)localObject2).startsWith("mqzone://arouse/moodVoiceRecord"))
            {
              QZoneHelperProxyImpl.forwardToOpenRecordPanel(paramWebViewPlugin, paramPluginRuntime, paramPluginRuntime.a(), paramPluginRuntime.a().getAccount(), (String)localObject2);
              return;
            }
            paramVarArgs = new Intent("action_js2qzone");
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("cmd", "Schema");
            ((Bundle)localObject3).putString("schema", (String)localObject2);
            if (((JSONObject)localObject5).optInt("showQzoneProgressDialog", 1) == 0) {
              break label1188;
            }
            bool = true;
            paramVarArgs.putExtras((Bundle)localObject3);
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("handleSchema actionString: ");
              ((StringBuilder)localObject3).append(paramVarArgs.getAction());
              ((StringBuilder)localObject3).append("scheme:");
              ((StringBuilder)localObject3).append((String)localObject2);
              QLog.d("QZoneWebViewPlugin", 2, ((StringBuilder)localObject3).toString());
            }
            if (((String)localObject2).startsWith("mqzone://arouse/openvideolayer"))
            {
              i = QZoneWebViewPlugin.generateRequestCode(paramWebViewPlugin, paramPluginRuntime, 4);
              QZoneHelper.forwardToQzoneTransluentActivity((Activity)localObject1, QZoneHelper.UserInfo.getInstance(), paramVarArgs, i, bool);
              return;
            }
            QZoneHelper.forwardToQzoneTransluentActivity((Activity)localObject1, QZoneHelper.UserInfo.getInstance(), paramVarArgs, -1, bool);
            return;
          }
          jumpQzoneScheme(paramPluginRuntime.a(), (String)localObject2, 81, paramPluginRuntime);
          return;
        }
        catch (JSONException paramWebViewPlugin) {}
        paramWebViewPlugin.printStackTrace();
      }
      catch (JSONException paramWebViewPlugin) {}
      QLog.e("QZoneWebViewJsHandleLogic", 1, "handleSchema", paramWebViewPlugin);
      label1164:
      return;
      label1165:
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject2 = paramVarArgs;
      continue;
      label1177:
      Object localObject1 = null;
      continue;
      label1183:
      int i = 3;
      continue;
      label1188:
      boolean bool = false;
    }
  }
  
  private static void handleSendGift(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length <= 0) {
        return;
      }
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
              QQToast.a(paramPluginRuntime.a(), 2, 2131689559, 0).a();
            }
            localObject = new long[paramVarArgs.length()];
            long[] arrayOfLong = new long[localJSONArray.length()];
            int i = 0;
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
              paramPluginRuntime = new StringBuilder();
              paramPluginRuntime.append("the giftid is ");
              paramPluginRuntime.append(j);
              paramPluginRuntime.append("\n the giftmessage is");
              paramPluginRuntime.append(str);
              paramPluginRuntime.append("\n the uins are: ");
              paramPluginRuntime.append(paramVarArgs.toString());
              paramPluginRuntime.append("\n the birthdays are: ");
              paramPluginRuntime.append(localJSONArray.toString());
              QLog.d("QZoneWebViewJsHandleLogic", 2, paramPluginRuntime.toString());
              return;
            }
          }
        }
      }
      catch (JSONException paramPluginRuntime)
      {
        QLog.e("QZoneWebViewJsHandleLogic", 1, paramPluginRuntime, new Object[0]);
      }
    }
  }
  
  private static void handleSendGiftSuccess(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length <= 0) {
        return;
      }
      try
      {
        LocalMultiProcConfig.putString("BirthdayGiftSendSuccessList", new JSONObject(paramVarArgs[0]).optString("uins"));
        return;
      }
      catch (JSONException paramPluginRuntime)
      {
        QLog.e("QZoneWebViewJsHandleLogic", 1, paramPluginRuntime, new Object[0]);
      }
    }
  }
  
  private static void handleShowFollowActionSheet(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramPluginRuntime != null) && (paramPluginRuntime.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        int i = new JSONObject(paramVarArgs[0]).optInt("followStatus");
        paramPluginRuntime = new Intent("showFollowActionSheet");
        paramPluginRuntime.putExtra("followStatus", i);
        BaseApplicationImpl.getApplication().sendBroadcast(paramPluginRuntime);
        if (QLog.isColorLevel())
        {
          paramPluginRuntime = new StringBuilder();
          paramPluginRuntime.append("followStatus = ");
          paramPluginRuntime.append(i);
          QLog.d("QZoneWebViewJsHandleLogic", 1, paramPluginRuntime.toString());
          return;
        }
      }
      catch (Exception paramPluginRuntime)
      {
        QLog.e("QZoneWebViewJsHandleLogic", 1, "handleShowFollowActionSheet catch an exception. ", paramPluginRuntime);
      }
    }
  }
  
  private static void handleUpdateIsSpecialFollow(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramPluginRuntime != null) && (paramPluginRuntime.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        int i = new JSONObject(paramVarArgs[0]).optInt("isSpecialFollow", -1);
        paramPluginRuntime = new Intent("updateIsSpecialFollow");
        paramPluginRuntime.putExtra("isSpecialFollow", i);
        BaseApplicationImpl.getApplication().sendBroadcast(paramPluginRuntime);
        if (QLog.isColorLevel())
        {
          paramPluginRuntime = new StringBuilder();
          paramPluginRuntime.append("followStatus = ");
          paramPluginRuntime.append(i);
          QLog.d("QZoneWebViewJsHandleLogic", 1, paramPluginRuntime.toString());
          return;
        }
      }
      catch (Exception paramPluginRuntime)
      {
        QLog.e("QZoneWebViewJsHandleLogic", 1, "handleUpdateIsSpecialFollow catch an exception. ", paramPluginRuntime);
      }
    }
  }
  
  static void handleUrl(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("browse url fail:");
        paramContext.append(paramString);
        QLog.d("handleUrl", 2, paramContext.toString());
      }
      return;
    }
    paramString = appendWVParameter(paramString, 7, false);
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.setData(Uri.parse(paramString));
    localIntent.addFlags(268435456);
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717365));
    paramContext.startActivity(localIntent);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("jump to browser: ");
      paramContext.append(paramString);
      QLog.d("handleurl", 2, paramContext.toString());
    }
  }
  
  private static int jumpQzoneScheme(Context paramContext, String paramString, int paramInt, WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    if (paramContext == null) {
      return 5;
    }
    if (checkScheme(paramString))
    {
      if (supportJumpToQzone(paramContext, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "simpleSchemeJump");
        }
        simpleSchemeJump(paramContext, Uri.parse(paramString));
        return 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "showQzoneAppDownloadDialog");
      }
      showQzoneAppDownloadDialog(paramContext, paramPluginRuntime);
      return 2;
    }
    if ((URLUtil.isNetworkUrl(paramString)) && (QLog.isColorLevel())) {
      QLog.d("QZoneWebViewPlugin", 2, "isNetworkUrl do nothing");
    }
    return 5;
  }
  
  static void shareMiniProgramFromQzone(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramPluginRuntime != null) && (paramPluginRuntime.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject1 = paramPluginRuntime.a(paramPluginRuntime.a());
        if ((localObject1 != null) && ((localObject1 instanceof WebUiUtils.WebShareInterface)))
        {
          localObject1 = ((Share)((WebUiUtils.WebShareInterface)localObject1).getShare()).a();
          if ((localObject1 != null) && (((QQProgressDialog)localObject1).isShowing())) {
            ((QQProgressDialog)localObject1).dismiss();
          }
        }
        webview = paramPluginRuntime.a();
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        mShareMsgCallback = ((JSONObject)localObject2).optString("callback");
        paramVarArgs = ((JSONObject)localObject2).optString("webpageUrl");
        ((JSONObject)localObject2).optInt("miniprogramType");
        localObject1 = ((JSONObject)localObject2).optString("userName");
        String str1 = ((JSONObject)localObject2).optString("path");
        String str2 = ((JSONObject)localObject2).optString("title");
        String str3 = ((JSONObject)localObject2).optString("description");
        localObject2 = ((JSONObject)localObject2).optString("picUrl");
        HashMap localHashMap = new HashMap(1);
        paramVarArgs = new QZoneWebViewJsHandleLogic.2(paramPluginRuntime, localHashMap, str2, str3, paramVarArgs, str1, (String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramVarArgs.run();
          return;
        }
        ThreadManager.post(new QZoneWebViewJsHandleLogic.3((String)localObject2, localHashMap, paramPluginRuntime, paramVarArgs), 8, null, false);
        return;
      }
      catch (Exception paramPluginRuntime)
      {
        QZLog.e("QZoneWebViewJsHandleLogic", "shareMiniProgramFromQzone error", paramPluginRuntime);
      }
    }
  }
  
  public static void showQzoneAppDownloadDialog(Context paramContext, WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    paramPluginRuntime = DialogUtil.a(paramContext, 0);
    paramPluginRuntime.setMessage(paramContext.getString(2131719637));
    paramPluginRuntime.setPositiveButton(paramContext.getString(2131691827), new QZoneWebViewJsHandleLogic.4(paramContext));
    paramPluginRuntime.setNegativeButton(paramContext.getString(2131693250), new QZoneWebViewJsHandleLogic.5(paramPluginRuntime));
    try
    {
      if (!paramPluginRuntime.isShowing())
      {
        paramPluginRuntime.show();
        return;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("showQzoneAppDownloadDialog", 2, "mDialog.show() exception", paramContext);
      }
    }
  }
  
  static void simpleSchemeJump(Context paramContext, Uri paramUri)
  {
    Intent localIntent = new Intent();
    localIntent.setData(paramUri);
    localIntent.setPackage("com.qzone");
    paramContext.startActivity(localIntent);
  }
  
  public static boolean supportJumpToQzone(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.qzone", 0);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label15:
      break label15;
    }
    paramContext = null;
    return (paramContext != null) && (paramContext.versionCode >= paramInt);
  }
  
  private static void updateFeedContainer(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length <= 0) {
        return;
      }
      try
      {
        if (new JSONObject(paramVarArgs[0]).getInt("height") <= 0)
        {
          if ((paramPluginRuntime.a().getParent() instanceof RelativeLayout)) {
            ((RelativeLayout)paramPluginRuntime.a().getParent()).setVisibility(8);
          }
        }
        else if ((paramPluginRuntime.a().getParent() instanceof RelativeLayout))
        {
          ((RelativeLayout)paramPluginRuntime.a().getParent()).setVisibility(0);
          return;
        }
      }
      catch (JSONException paramPluginRuntime)
      {
        QLog.e("QZoneWebViewJsHandleLogic", 1, paramPluginRuntime, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */