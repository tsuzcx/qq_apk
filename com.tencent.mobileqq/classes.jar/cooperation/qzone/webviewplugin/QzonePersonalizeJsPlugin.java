package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.font.DefaultBarrageEffectInfo;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.font.DefaultSuperFontInfo;
import cooperation.qzone.font.FontInterface.TrueTypeResult;
import cooperation.qzone.font.FontManager;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.personalize.QZoneFacadeJsHandleLogic;
import cooperation.qzone.webviewplugin.personalize.QZonePersonalizeH5Service;
import cooperation.qzone.webviewplugin.personalize.QZonePersonalizeJsHandleLogic;
import cooperation.qzone.webviewplugin.personalize.QZoneZebraAlbumJsHandleLogic;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QzonePersonalizeJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String NAMESPACE = "Qzone";
  private static final String TAG = "QzonePersonalizeJsPlugin";
  private FontInterface.TrueTypeResult mFontResult = new QzonePersonalizeJsPlugin.1(this);
  
  private void callJS(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, "callback is null");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    int i;
    if (Build.VERSION.SDK_INT < 11) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (Build.VERSION.SDK_INT > 20) {
      j = 1;
    } else {
      j = 0;
    }
    try
    {
      localJSONObject.put("ret", paramInt);
      localJSONObject.put("msg", paramString2);
      localJSONObject.put("noZip", i);
      localJSONObject.put("noCrossDomain", j);
      paramString2 = localJSONObject.toString();
      this.parentPlugin.mRuntime.a().callJs(paramString1, new String[] { paramString2 });
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, paramString1.getMessage());
    }
  }
  
  private void handleCustomTrack(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      Bundle localBundle = new Bundle();
      localBundle.putInt("itemId", paramArrayOfString.getInt("itemid"));
      QLog.i("QzonePersonalizeJsPlugin", 1, "handleCustomTrack  h5set ");
      RemoteHandleManager.getInstance().sendData("cmd.setCustomTrack", localBundle, false);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, "handleCustomTrack  ", paramArrayOfString);
    }
  }
  
  private static void handleCustomVipSetting(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length <= 0) {
        return;
      }
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        int i = paramVarArgs.getInt("CustomVipId");
        paramVarArgs = paramVarArgs.getString("zipUrl");
        Intent localIntent = new Intent("action_personalize_js2qzone");
        Bundle localBundle = new Bundle();
        localBundle.putString("cmd", "Custom_Vip_Setting");
        localBundle.putInt("CustomVipId", i);
        localBundle.putString("zipUrl", paramVarArgs);
        localIntent.putExtras(localBundle);
        QZoneHelper.forwardToQzoneTransluentActivity(paramPluginRuntime.a(), QZoneHelper.UserInfo.getInstance(), localIntent);
        return;
      }
      catch (JSONException paramPluginRuntime)
      {
        paramPluginRuntime.printStackTrace();
      }
    }
  }
  
  private void handleDIYData(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length == 1)) {
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]).optString("data");
        Bundle localBundle = new Bundle();
        localBundle.putString("cmd", "setDiyHomePage");
        localBundle.putString("layoutJson", paramArrayOfString);
        RemoteHandleManager.getInstance().sendData("cmd.setDIYData", localBundle, false);
        return;
      }
      catch (Exception paramArrayOfString)
      {
        QLog.w("QzonePersonalizeJsPlugin", 1, "handleDIYData  ", paramArrayOfString);
      }
    }
  }
  
  private void handleFriendNaviDeco(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setFriendNaviDeco");
      localBundle.putInt("itemId", paramArrayOfString.getInt("itemid"));
      localBundle.putString("friendNaviDecoUrl", paramArrayOfString.optString("friendnavidecoresurl", ""));
      localBundle.putString("textColor", paramArrayOfString.optString("fontcolor", ""));
      localIntent.putExtras(localBundle);
      QZoneHelper.forwardToQzoneTransluentActivity(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), localIntent);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "handleFriendNaviDeco  ", paramArrayOfString);
    }
  }
  
  private void handleGetDefaultFont(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        long l = paramArrayOfString.optLong("uin");
        paramArrayOfString = paramArrayOfString.optString("callback");
        if (TextUtils.isEmpty(paramArrayOfString))
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "callback is empty.");
          return;
        }
        DefaultFontInfo localDefaultFontInfo = FontManager.getInstance().getDefaultFont(l);
        DefaultSuperFontInfo localDefaultSuperFontInfo = FontManager.getInstance().getDefaultSuperFont(l);
        DefaultBarrageEffectInfo localDefaultBarrageEffectInfo = FontManager.getInstance().getDefaultBarrageEffectInfo(l);
        try
        {
          JSONObject localJSONObject = new JSONObject();
          int j = -1;
          int i;
          if (localDefaultFontInfo == null) {
            i = -1;
          } else {
            i = localDefaultFontInfo.fontId;
          }
          localJSONObject.put("id", i);
          if (localDefaultSuperFontInfo == null) {
            i = -1;
          } else {
            i = localDefaultSuperFontInfo.fontId;
          }
          localJSONObject.put("sparkle_id", i);
          if (localDefaultBarrageEffectInfo == null) {
            i = j;
          } else {
            i = localDefaultBarrageEffectInfo.itemId;
          }
          localJSONObject.put("bubble_iItemId", i);
          this.parentPlugin.mRuntime.a().callJs(paramArrayOfString, new String[] { localJSONObject.toString() });
          return;
        }
        catch (JSONException paramArrayOfString)
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, paramArrayOfString.getMessage());
          return;
        }
        return;
      }
      catch (Exception paramArrayOfString)
      {
        QLog.e("QzonePersonalizeJsPlugin", 1, paramArrayOfString.getMessage());
      }
    }
  }
  
  private void handleHighFive(String[] paramArrayOfString)
  {
    try
    {
      Object localObject = new JSONObject(paramArrayOfString[0]);
      int i = ((JSONObject)localObject).getInt("itemId");
      paramArrayOfString = ((JSONObject)localObject).getString("itemUrl");
      localObject = ((JSONObject)localObject).getString("itemText");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setResponsiveLike");
      localBundle.putInt("itemId", i);
      localBundle.putString("itemUrl", paramArrayOfString);
      localBundle.putString("itemText", (String)localObject);
      RemoteHandleManager.getInstance().sendData("cmd.setResponsiveLike", localBundle, false);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "handleHighFive  ", paramArrayOfString);
    }
  }
  
  private void handleNotifyWebviewJsReady()
  {
    QLog.i("QzonePersonalizeJsPlugin", 1, "tiantai handleNotifyWebviewJsReady");
    for (;;)
    {
      try
      {
        if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null))
        {
          CustomWebView localCustomWebView = this.parentPlugin.mRuntime.a();
          if (localCustomWebView == null)
          {
            QZLog.w("QzonePersonalizeJsPlugin", "tiantai webView == null");
            return;
          }
          localCustomWebView.setTag(2131375865, Boolean.TRUE);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("tiantai webview activity name: ");
          ((StringBuilder)localObject2).append(this.parentPlugin.mRuntime.a().getClass().getSimpleName());
          QLog.i("QzonePersonalizeJsPlugin", 1, ((StringBuilder)localObject2).toString());
          if (!(this.parentPlugin.mRuntime.a() instanceof QzoneTiantaiTranslucentBrowserActivity))
          {
            QZLog.i("QzonePersonalizeJsPlugin", "tiantai 非定制webview直接返回");
            notifyWebviewStartAnimation(localCustomWebView);
            return;
          }
          localObject2 = localCustomWebView.getTag(2131375862);
          if ((localObject2 == null) || (!((Boolean)localObject2).booleanValue())) {
            break label201;
          }
          i = 1;
          if (i == 0)
          {
            QZLog.i("QzonePersonalizeJsPlugin", "tiantai video not finish");
            return;
          }
          notifyWebviewStartAnimation(localCustomWebView);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.w("QzonePersonalizeJsPlugin", 1, "tiantai handleNotifyWebviewJsReady: ", localException);
        return;
      }
      Object localObject1 = null;
      continue;
      label201:
      int i = 0;
    }
  }
  
  private void handlePersonalizeFont(String... paramVarArgs)
  {
    int j;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        str1 = paramVarArgs.optString("url");
        i = paramVarArgs.optInt("id", -1);
        j = paramVarArgs.optInt("download");
        str2 = paramVarArgs.optString("callback");
        if ((j != 0) && (TextUtils.isEmpty(str1)))
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "url is empty.");
          return;
        }
        if (TextUtils.isEmpty(str2))
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "callback is empty.");
          return;
        }
        int k = Build.VERSION.SDK_INT;
        if (k < 11)
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("low android version system, so not to download font. sdk = ");
          paramVarArgs.append(Build.VERSION.SDK_INT);
          QLog.e("QzonePersonalizeJsPlugin", 1, paramVarArgs.toString());
          callJS(str2, -1, "font has not been cached.");
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        String str1;
        int i;
        String str2;
        QLog.e("QzonePersonalizeJsPlugin", 1, paramVarArgs.getMessage());
      }
    }
    for (paramVarArgs = this.mFontResult;; paramVarArgs = null)
    {
      if (!TextUtils.isEmpty(FontManager.getInstance().getTrueTypeFont(i, str1, str2, true, paramVarArgs)))
      {
        callJS(str2, 0, "success");
        return;
      }
      if (paramVarArgs == null)
      {
        callJS(str2, -1, "font has not been cached.");
        return;
      }
      return;
      if (j != 0) {
        break;
      }
    }
  }
  
  private static void handlePersonalizeSetting(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length <= 0) {
        return;
      }
      int i = 0;
      try
      {
        Object localObject = new JSONObject(paramVarArgs[0]);
        if (((JSONObject)localObject).getInt("success") == 1)
        {
          paramVarArgs = ((JSONObject)localObject).getJSONArray("uins");
          if ((paramVarArgs != null) && (paramVarArgs.length() > 0))
          {
            if ((((JSONObject)localObject).has("toast")) && (((JSONObject)localObject).getBoolean("toast"))) {
              QQToast.a(paramPluginRuntime.a(), 2, 2131689559, 0).a();
            }
            localObject = new long[paramVarArgs.length()];
            while (i < paramVarArgs.length())
            {
              localObject[i] = paramVarArgs.getLong(i);
              i += 1;
            }
            paramVarArgs = new Intent();
            paramVarArgs.putExtra("key_msg_type", 2);
            paramVarArgs.putExtra("key_friend_list", (long[])localObject);
            paramPluginRuntime.a().setResult(-1, paramVarArgs);
            paramPluginRuntime.a().finish();
            return;
          }
        }
      }
      catch (JSONException paramPluginRuntime)
      {
        paramPluginRuntime.printStackTrace();
      }
    }
  }
  
  private void handlePreloadFacade(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    Intent localIntent = new Intent("action_personalize_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "SetFacade");
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        localBundle.putInt("showonfridyn", new JSONObject(paramVarArgs[0]).getInt("showonfridyn"));
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
    localIntent.putExtras(localBundle);
    QZoneHelper.forwardToQzoneTransluentActivity(paramPluginRuntime.a(), QZoneHelper.UserInfo.getInstance(), localIntent);
  }
  
  private void handleReserveAdvertise(String[] paramArrayOfString)
  {
    try
    {
      Object localObject = new JSONObject(paramArrayOfString[0]);
      paramArrayOfString = new Bundle();
      localObject = ((JSONObject)localObject).getJSONObject("param");
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).getString("orderid");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramArrayOfString.putString("orderid", (String)localObject);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleReserveAdvertise  h5set +");
            localStringBuilder.append((String)localObject);
            QLog.i("QzonePersonalizeJsPlugin", 1, localStringBuilder.toString());
          }
          RemoteHandleManager.getInstance().sendData("cmd.reserveAdvertise", paramArrayOfString, false);
          return;
        }
        QLog.e("QzonePersonalizeJsPlugin", 1, "@orderAdv orderid  is null  ");
        return;
      }
      QLog.e("QzonePersonalizeJsPlugin", 1, "@orderAdv orderid  is null  ");
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, new Object[] { "@orderAdv handleReserveAdvertise  ", paramArrayOfString.toString() });
    }
  }
  
  private void handleSetDefaultCommentBubble(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        long l = ((JSONObject)localObject2).optLong("uin");
        int i = ((JSONObject)localObject2).optInt("bubble_iItemId", -2147483648);
        paramVarArgs = ((JSONObject)localObject2).optString("bubble_strTextColor");
        Object localObject1 = ((JSONObject)localObject2).optString("bubble_strAndBgUrl");
        String str1 = ((JSONObject)localObject2).optString("bubble_strIosBgUrl");
        String str2 = ((JSONObject)localObject2).optString("bubble_strFrameZip");
        int j = ((JSONObject)localObject2).optInt("bubble_iFrameRate");
        if (i == -2147483648)
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("CommentBubble id error , id = ");
          paramVarArgs.append(i);
          QLog.e("QzonePersonalizeJsPlugin", 1, paramVarArgs.toString());
          return;
        }
        localObject2 = new DefaultBarrageEffectInfo();
        ((DefaultBarrageEffectInfo)localObject2).itemId = i;
        ((DefaultBarrageEffectInfo)localObject2).jsonStr = DefaultBarrageEffectInfo.toJson(i, paramVarArgs, (String)localObject1, str1, str2, j);
        FontManager.getInstance().setDefaultBarrageEffect(l, (DefaultBarrageEffectInfo)localObject2);
        paramVarArgs = new Intent("action_personalize_js2qzone");
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("cmd", "refreshCommonList");
        paramVarArgs.putExtras((Bundle)localObject1);
        QZoneHelper.forwardToQzoneTransluentActivity(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), paramVarArgs);
        if (i > 0)
        {
          FontManager.getInstance().setDefaultFont(l, null);
          FontManager.getInstance().setDefaultSuperFont(l, null);
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  private void handleSetDefaultFont(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
        long l = localJSONObject.optLong("uin");
        String str = localJSONObject.optString("url");
        int i = localJSONObject.optInt("id", -1);
        int j = localJSONObject.optInt("formatType");
        if (localJSONObject.optInt("sparkle_id", -1) != -1) {
          handleSetDefaultSuperFont(paramVarArgs);
        }
        if (localJSONObject.optInt("bubble_iItemId", -2147483648) != -2147483648) {
          handleSetDefaultCommentBubble(paramVarArgs);
        }
        if (i < 0)
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("font id error , id = ");
          paramVarArgs.append(i);
          QLog.e("QzonePersonalizeJsPlugin", 1, paramVarArgs.toString());
          return;
        }
        if ((i > 0) && (TextUtils.isEmpty(str)))
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "url is empty.");
          return;
        }
        paramVarArgs = new DefaultFontInfo();
        paramVarArgs.fontId = i;
        paramVarArgs.formatType = j;
        paramVarArgs.fontUrl = str;
        FontManager.getInstance().setDefaultFont(l, paramVarArgs);
        if (i > 0)
        {
          FontManager.getInstance().setDefaultBarrageEffect(l, null);
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        QLog.e("QzonePersonalizeJsPlugin", 1, paramVarArgs.getMessage());
      }
    }
  }
  
  private void handleSetDefaultSuperFont(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        long l = paramVarArgs.optLong("uin");
        int i = paramVarArgs.optInt("sparkle_id");
        paramVarArgs = paramVarArgs.optString("sparkle_json");
        if (i < 0)
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("font id error , id = ");
          paramVarArgs.append(i);
          QLog.e("QzonePersonalizeJsPlugin", 1, paramVarArgs.toString());
          return;
        }
        DefaultSuperFontInfo localDefaultSuperFontInfo = new DefaultSuperFontInfo();
        localDefaultSuperFontInfo.fontId = i;
        localDefaultSuperFontInfo.jsonStr = paramVarArgs;
        FontManager.getInstance().setDefaultSuperFont(l, localDefaultSuperFontInfo);
        if (i > 0)
        {
          FontManager.getInstance().setDefaultBarrageEffect(l, null);
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  private void handleSetPlayerDeco(String... paramVarArgs)
  {
    try
    {
      localObject = new JSONObject(paramVarArgs[0]);
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "Custom_Player_Setting");
      localBundle.putInt("itemId", ((JSONObject)localObject).getInt("itemId"));
      localBundle.putString("playerDecoUrl", ((JSONObject)localObject).optString("playerDecoUrl"));
      localBundle.putLong("textColor", ((JSONObject)localObject).optLong("textColor"));
      localIntent.putExtras(localBundle);
      QZoneHelper.forwardToQzoneTransluentActivity(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), localIntent);
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      label106:
      break label106;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parse json error ");
    ((StringBuilder)localObject).append(paramVarArgs[0]);
    QLog.e("QzonePersonalizeJsPlugin", 1, ((StringBuilder)localObject).toString());
  }
  
  private static void handleUpdateMallClicktime(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length <= 0) {
        return;
      }
      try
      {
        int i = new JSONObject(paramVarArgs[0]).getInt("timestamp");
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("handleUpdateMallClicktime: ");
          paramVarArgs.append(i);
          QLog.d("QZoneWebViewPlugin", 2, paramVarArgs.toString());
        }
        QZonePersonalizeH5Service.updateCTime(Integer.valueOf(i), Long.valueOf(paramPluginRuntime.a().getLongAccountUin()));
        return;
      }
      catch (JSONException paramPluginRuntime)
      {
        paramPluginRuntime.printStackTrace();
      }
    }
  }
  
  private void handleYellowDiamondRedpocket(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      boolean bool = paramArrayOfString.getBoolean("isGet");
      paramArrayOfString = paramArrayOfString.getString("ugckey");
      if (bool)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("param.yellowdiamondRedpocketUgckey", paramArrayOfString);
        RemoteHandleManager.getInstance().sendData("cmd.getYellowDiamondRedPocket", localBundle, false);
        return;
      }
    }
    catch (Exception paramArrayOfString)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "handleYellowDiamondRedpocket  ", paramArrayOfString);
    }
  }
  
  private void hanleOpenWebview(String[] paramArrayOfString)
  {
    int i;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      i = 0;
    }
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      if (paramArrayOfString.optInt("transparent") == 1) {
        i = 1;
      }
      paramArrayOfString = paramArrayOfString.optString("url");
      Activity localActivity = this.parentPlugin.mRuntime.a();
      if (i != 0)
      {
        if ((localActivity instanceof BasePluginActivity))
        {
          QZoneHelper.startTranslucentBrowserActivityForResult(((BasePluginActivity)localActivity).getOutActivity(), paramArrayOfString, -1, null, null);
          return;
        }
        QZoneHelper.startTranslucentBrowserActivityForResult(localActivity, paramArrayOfString, -1, null, null);
        return;
      }
      if ((localActivity instanceof BasePluginActivity))
      {
        QZoneHelper.forwardToBrowser(((BasePluginActivity)localActivity).getOutActivity(), paramArrayOfString, -1, null, null);
        return;
      }
      QZoneHelper.forwardToBrowser(localActivity, paramArrayOfString, -1, null, null);
      return;
    }
    catch (Exception paramArrayOfString) {}
  }
  
  public static void notifyWebviewStartAnimation(CustomWebView paramCustomWebView)
  {
    try
    {
      QZLog.i("QzonePersonalizeJsPlugin", "tiantai notifyWebviewStartAnimation");
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("action", "startAnimation");
      JSONObject localJSONObject2 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("*.qzone.qq.com");
      localJSONObject2.put("echo", true);
      localJSONObject2.put("broadcast", true);
      localJSONObject2.put("domains", localJSONArray);
      dispatchEventImpl(paramCustomWebView, "qzRooftop", localJSONObject1, localJSONObject2);
      paramCustomWebView.setTag(2131375862, Boolean.FALSE);
      paramCustomWebView.setTag(2131375865, Boolean.FALSE);
      return;
    }
    catch (Exception paramCustomWebView)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "tiantai notifyWebviewStartAnimation: ", paramCustomWebView);
    }
  }
  
  private static void onHandleUpdateMallID(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if (paramVarArgs != null) {
      if (paramVarArgs.length <= 0) {
        return;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "handleUpdateMallID");
        }
        int j = 0;
        Object localObject = new JSONObject(paramVarArgs[0]).getJSONArray("id");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          paramVarArgs = new int[((JSONArray)localObject).length()];
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramVarArgs[i] = ((JSONArray)localObject).getInt(i);
            i += 1;
            continue;
          }
          if (paramVarArgs.length <= 0) {
            return;
          }
          new HashMap();
          localObject = QZonePersonalizeH5Service.getCTime(Long.valueOf(paramPluginRuntime.a().getLongAccountUin()));
          i = j;
          if (i < paramVarArgs.length)
          {
            if (((Map)localObject).containsKey(Integer.valueOf(paramVarArgs[i]))) {
              break label193;
            }
            ((Map)localObject).put(Integer.valueOf(paramVarArgs[i]), Long.valueOf(0L));
            break label193;
          }
          QZonePersonalizeH5Service.setCTime((Map)localObject, Long.valueOf(paramPluginRuntime.a().getLongAccountUin()));
          return;
        }
      }
      catch (JSONException paramPluginRuntime)
      {
        paramPluginRuntime.printStackTrace();
      }
      return;
      label193:
      i += 1;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if (QZoneJsConstants.isForce(paramString3))
      {
        LocalMultiProcConfig.putBool("qzone_force_refresh", true);
        LocalMultiProcConfig.putBool("qzone_force_refresh_passive", true);
      }
      if ("UpdateMallTimestamp".equalsIgnoreCase(paramString3))
      {
        handleUpdateMallClicktime(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ("UpdateMallid".equalsIgnoreCase(paramString3))
      {
        onHandleUpdateMallID(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ("Personalize".equalsIgnoreCase(paramString3))
      {
        handlePersonalizeSetting(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ("SetFacade".equalsIgnoreCase(paramString3))
      {
        handlePreloadFacade(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if (paramString3.equals("CleanZebraNum"))
      {
        QZoneZebraAlbumJsHandleLogic.handleCleanZebraNum(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if (paramString3.equals("SetPersonalizeFinished"))
      {
        QZonePersonalizeJsHandleLogic.handleSwitchFinished(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if (paramString3.equals("openNameplateSucc"))
      {
        QZoneFacadeJsHandleLogic.handleSetFacadeFinish(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ("downLoadFont".equalsIgnoreCase(paramString3))
      {
        handlePersonalizeFont(paramVarArgs);
        return true;
      }
      if ("OpenCustomVipSucc".equals(paramString3))
      {
        handleCustomVipSetting(this.parentPlugin.mRuntime, paramVarArgs);
        return true;
      }
      if ("setDefaultFont".equals(paramString3))
      {
        handleSetDefaultFont(paramVarArgs);
        return true;
      }
      if ("getDefaultFont".equals(paramString3))
      {
        handleGetDefaultFont(paramVarArgs);
        return true;
      }
      if ("SetPlayerDeco".equals(paramString3))
      {
        handleSetPlayerDeco(paramVarArgs);
        return true;
      }
      if ("qzRooftopPageReady".equals(paramString3))
      {
        handleNotifyWebviewJsReady();
        return true;
      }
      if ("OpenUrl".equals(paramString3))
      {
        hanleOpenWebview(paramVarArgs);
        return true;
      }
      if ("RefreshDeco".equals(paramString3))
      {
        RemoteHandleManager.getInstance().sendData("cmd.refeshDecoCustom", null, false);
        return true;
      }
      if ("GiftPlayAnimation".equals(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && (!TextUtils.isEmpty(paramVarArgs[0]))) {
          QzoneGiftManager.a().b(paramVarArgs[0]);
        }
        return true;
      }
      if ("GetRedpocket".equals(paramString3))
      {
        handleYellowDiamondRedpocket(paramVarArgs);
        return true;
      }
      if ("setFriendNaviDeco".equals(paramString3))
      {
        handleFriendNaviDeco(paramVarArgs);
        return true;
      }
      if ("setResponsiveLike".equals(paramString3))
      {
        handleHighFive(paramVarArgs);
        return true;
      }
      if ("setDiyHomePage".equals(paramString3))
      {
        handleDIYData(paramVarArgs);
        return true;
      }
      if ("setCustomTrack".equals(paramString3))
      {
        handleCustomTrack(paramVarArgs);
        return true;
      }
      if ("reserveAdvertise".equals(paramString3))
      {
        handleReserveAdvertise(paramVarArgs);
        return true;
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QzoneGiftManager.a().onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzonePersonalizeJsPlugin
 * JD-Core Version:    0.7.0.1
 */