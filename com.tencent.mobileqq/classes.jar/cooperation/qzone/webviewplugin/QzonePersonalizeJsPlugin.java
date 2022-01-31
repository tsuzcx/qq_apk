package cooperation.qzone.webviewplugin;

import anct;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.font.FontInterface;
import cooperation.qzone.font.FontInterface.TrueTypeResult;
import cooperation.qzone.font.FontManager.DefaultBarrageEffectInfo;
import cooperation.qzone.font.FontManager.DefaultFontInfo;
import cooperation.qzone.font.FontManager.DefaultSuperFontInfo;
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
  private FontInterface.TrueTypeResult a;
  
  QzonePersonalizeJsPlugin()
  {
    this.jdField_a_of_type_CooperationQzoneFontFontInterface$TrueTypeResult = new anct(this);
  }
  
  public static void a(CustomWebView paramCustomWebView)
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
      a(paramCustomWebView, "qzRooftop", localJSONObject1, localJSONObject2);
      paramCustomWebView.setTag(2131361917, Boolean.FALSE);
      paramCustomWebView.setTag(2131361916, Boolean.FALSE);
      return;
    }
    catch (Exception paramCustomWebView)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "tiantai notifyWebviewStartAnimation: ", paramCustomWebView);
    }
  }
  
  private static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    try
    {
      int i = new JSONObject(paramVarArgs[0]).getInt("timestamp");
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "handleUpdateMallClicktime: " + i);
      }
      QZonePersonalizeH5Service.a(Integer.valueOf(i), Long.valueOf(paramPluginRuntime.a().getLongAccountUin()));
      return;
    }
    catch (JSONException paramPluginRuntime)
    {
      paramPluginRuntime.printStackTrace();
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, "callback is null");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    if (Build.VERSION.SDK_INT < 11) {}
    for (int i = 1;; i = 0)
    {
      if (Build.VERSION.SDK_INT > 20) {
        j = 1;
      }
      try
      {
        localJSONObject.put("ret", paramInt);
        localJSONObject.put("msg", paramString2);
        localJSONObject.put("noZip", i);
        localJSONObject.put("noCrossDomain", j);
        paramString2 = localJSONObject.toString();
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().a(paramString1, new String[] { paramString2 });
        return;
      }
      catch (JSONException paramString1)
      {
        QLog.e("QzonePersonalizeJsPlugin", 1, paramString1.getMessage());
        return;
      }
    }
  }
  
  private void a(String... paramVarArgs)
  {
    String str1;
    int i;
    int j;
    String str2;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        str1 = paramVarArgs.optString("url");
        i = paramVarArgs.optInt("id");
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
      }
      catch (Exception paramVarArgs)
      {
        QLog.e("QzonePersonalizeJsPlugin", 1, paramVarArgs.getMessage());
        return;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        break label192;
      }
      QLog.e("QzonePersonalizeJsPlugin", 1, "low android version system, so not to download font. sdk = " + Build.VERSION.SDK_INT);
      a(str2, -1, "font has not been cached.");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(FontInterface.a(i, str1, str2, paramVarArgs)))
      {
        a(str2, 0, "success");
        return;
      }
      label192:
      do
      {
        paramVarArgs = this.jdField_a_of_type_CooperationQzoneFontFontInterface$TrueTypeResult;
        break;
        if (paramVarArgs == null) {
          a(str2, -1, "font has not been cached.");
        }
        return;
      } while (j != 0);
      paramVarArgs = null;
    }
  }
  
  private void b()
  {
    QLog.i("QzonePersonalizeJsPlugin", 1, "tiantai handleNotifyWebviewJsReady");
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
        break label179;
      }
      CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if (localCustomWebView == null)
      {
        QZLog.w("QzonePersonalizeJsPlugin", "tiantai webView == null");
        return;
      }
      localCustomWebView.setTag(2131361916, Boolean.TRUE);
      QLog.i("QzonePersonalizeJsPlugin", 1, "tiantai webview activity name: " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getClass().getSimpleName());
      if (!(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() instanceof QzoneTiantaiTranslucentBrowserActivity))
      {
        QZLog.i("QzonePersonalizeJsPlugin", "tiantai 非定制webview直接返回");
        a(localCustomWebView);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "tiantai handleNotifyWebviewJsReady: ", localException);
      return;
    }
    Object localObject2 = localException.getTag(2131361917);
    if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        QZLog.i("QzonePersonalizeJsPlugin", "tiantai video not finish");
        return;
      }
      a(localException);
      return;
      label179:
      Object localObject1 = null;
      break;
    }
  }
  
  private static void b(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    int j = 0;
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "handleUpdateMallID");
        }
        localObject = new JSONObject(paramVarArgs[0]).getJSONArray("id");
        if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
          break;
        }
        paramVarArgs = new int[((JSONArray)localObject).length()];
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          paramVarArgs[i] = ((JSONArray)localObject).getInt(i);
          i += 1;
          continue;
        }
        if (paramVarArgs.length <= 0) {
          break;
        }
        new HashMap();
        localObject = QZonePersonalizeH5Service.a(Long.valueOf(paramPluginRuntime.a().getLongAccountUin()));
        i = j;
        if (i < paramVarArgs.length)
        {
          if (((Map)localObject).containsKey(Integer.valueOf(paramVarArgs[i]))) {
            break label190;
          }
          ((Map)localObject).put(Integer.valueOf(paramVarArgs[i]), Long.valueOf(0L));
        }
      }
      catch (JSONException paramPluginRuntime)
      {
        paramPluginRuntime.printStackTrace();
        return;
      }
      QZonePersonalizeH5Service.a((Map)localObject, Long.valueOf(paramPluginRuntime.a().getLongAccountUin()));
      return;
      label190:
      i += 1;
    }
  }
  
  private void b(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      long l;
      String str;
      int i;
      int j;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
        l = localJSONObject.optLong("uin");
        str = localJSONObject.optString("url");
        i = localJSONObject.optInt("id");
        j = localJSONObject.optInt("formatType");
        if (localJSONObject.optInt("sparkle_id", -1) != -1) {
          d(paramVarArgs);
        }
        if (localJSONObject.optInt("bubble_iItemId", -2147483648) != -2147483648) {
          c(paramVarArgs);
        }
        if (i < 0)
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "font id error , id = " + i);
          return;
        }
        if ((i > 0) && (TextUtils.isEmpty(str)))
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "url is empty.");
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        QLog.e("QzonePersonalizeJsPlugin", 1, paramVarArgs.getMessage());
        return;
      }
      paramVarArgs = new FontManager.DefaultFontInfo();
      paramVarArgs.jdField_a_of_type_Int = i;
      paramVarArgs.b = j;
      paramVarArgs.jdField_a_of_type_JavaLangString = str;
      FontInterface.a(l, paramVarArgs);
      if (i > 0) {
        FontInterface.a(l, null);
      }
    }
  }
  
  private static void c(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
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
      QZoneHelper.a(paramPluginRuntime.a(), QZoneHelper.UserInfo.a(), localIntent);
      return;
    }
    catch (JSONException paramPluginRuntime)
    {
      paramPluginRuntime.printStackTrace();
    }
  }
  
  private void c(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject = new JSONObject(paramVarArgs[0]);
        long l = ((JSONObject)localObject).optLong("uin");
        int i = ((JSONObject)localObject).optInt("bubble_iItemId", -2147483648);
        paramVarArgs = ((JSONObject)localObject).optString("bubble_strTextColor");
        String str = ((JSONObject)localObject).optString("bubble_strAndBgUrl");
        localObject = ((JSONObject)localObject).optString("bubble_strIosBgUrl");
        if (i == -2147483648)
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, "CommentBubble id error , id = " + i);
          return;
        }
        FontManager.DefaultBarrageEffectInfo localDefaultBarrageEffectInfo = new FontManager.DefaultBarrageEffectInfo();
        localDefaultBarrageEffectInfo.jdField_a_of_type_Int = i;
        localDefaultBarrageEffectInfo.jdField_a_of_type_JavaLangString = FontManager.DefaultBarrageEffectInfo.a(i, paramVarArgs, str, (String)localObject);
        FontInterface.a(l, localDefaultBarrageEffectInfo);
        if (i > 0)
        {
          FontInterface.a(l, null);
          FontInterface.a(l, null);
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
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
          if ((paramVarArgs != null) && (paramVarArgs.length() > 0))
          {
            if ((((JSONObject)localObject).has("toast")) && (((JSONObject)localObject).getBoolean("toast"))) {
              QQToast.a(paramPluginRuntime.a(), 2, 2131437252, 0).a();
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
  
  private void d(String... paramVarArgs)
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
          QLog.e("QzonePersonalizeJsPlugin", 1, "font id error , id = " + i);
          return;
        }
        FontManager.DefaultSuperFontInfo localDefaultSuperFontInfo = new FontManager.DefaultSuperFontInfo();
        localDefaultSuperFontInfo.jdField_a_of_type_Int = i;
        localDefaultSuperFontInfo.jdField_a_of_type_JavaLangString = paramVarArgs;
        FontInterface.a(l, localDefaultSuperFontInfo);
        if (i > 0)
        {
          FontInterface.a(l, null);
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  private void e(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    Intent localIntent = new Intent("action_personalize_js2qzone");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", "SetFacade");
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      localBundle.putInt("showonfridyn", new JSONObject(paramVarArgs[0]).getInt("showonfridyn"));
      localIntent.putExtras(localBundle);
      QZoneHelper.a(paramPluginRuntime.a(), QZoneHelper.UserInfo.a(), localIntent);
      return;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
      }
    }
  }
  
  private void e(String[] paramArrayOfString)
  {
    int j = -1;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      for (;;)
      {
        FontManager.DefaultSuperFontInfo localDefaultSuperFontInfo;
        FontManager.DefaultBarrageEffectInfo localDefaultBarrageEffectInfo;
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
          FontManager.DefaultFontInfo localDefaultFontInfo = FontInterface.a(l);
          localDefaultSuperFontInfo = FontInterface.a(l);
          localDefaultBarrageEffectInfo = FontInterface.a(l);
          try
          {
            JSONObject localJSONObject = new JSONObject();
            if (localDefaultFontInfo == null)
            {
              i = -1;
              localJSONObject.put("id", i);
              if (localDefaultSuperFontInfo != null) {
                break label194;
              }
              i = -1;
              localJSONObject.put("sparkle_id", i);
              if (localDefaultBarrageEffectInfo != null) {
                break label203;
              }
              i = j;
              localJSONObject.put("bubble_iItemId", i);
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().a(paramArrayOfString, new String[] { localJSONObject.toString() });
              return;
            }
          }
          catch (JSONException paramArrayOfString)
          {
            QLog.e("QzonePersonalizeJsPlugin", 1, paramArrayOfString.getMessage());
            return;
          }
          i = localDefaultFontInfo.jdField_a_of_type_Int;
        }
        catch (Exception paramArrayOfString)
        {
          QLog.e("QzonePersonalizeJsPlugin", 1, paramArrayOfString.getMessage());
          return;
        }
        continue;
        label194:
        int i = localDefaultSuperFontInfo.jdField_a_of_type_Int;
        continue;
        label203:
        i = localDefaultBarrageEffectInfo.jdField_a_of_type_Int;
      }
    }
  }
  
  private void f(String... paramVarArgs)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "Custom_Player_Setting");
      localBundle.putInt("itemId", localJSONObject.getInt("itemId"));
      localBundle.putString("playerDecoUrl", localJSONObject.optString("playerDecoUrl"));
      localBundle.putLong("textColor", localJSONObject.optLong("textColor"));
      localIntent.putExtras(localBundle);
      QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), QZoneHelper.UserInfo.a(), localIntent);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzonePersonalizeJsPlugin", 1, "parse json error " + paramVarArgs[0]);
    }
  }
  
  private void g(String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {}
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      if (paramArrayOfString.optInt("transparent") == 1) {
        i = 1;
      }
      paramArrayOfString = paramArrayOfString.optString("url");
      Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      if (i != 0)
      {
        if ((localActivity instanceof BasePluginActivity))
        {
          QZoneHelper.a(((BasePluginActivity)localActivity).getOutActivity(), paramArrayOfString, -1, null, null);
          return;
        }
        QZoneHelper.a(localActivity, paramArrayOfString, -1, null, null);
        return;
      }
      if ((localActivity instanceof BasePluginActivity))
      {
        QZoneHelper.a(((BasePluginActivity)localActivity).getOutActivity(), paramArrayOfString, -1, null, null);
        return;
      }
      QZoneHelper.a(localActivity, paramArrayOfString, -1, null, null);
      return;
    }
    catch (Exception paramArrayOfString) {}
  }
  
  private void h(String[] paramArrayOfString)
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
        RemoteHandleManager.a().a("cmd.getYellowDiamondRedPocket", localBundle, false);
      }
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.w("QzonePersonalizeJsPlugin", 1, "handleYellowDiamondRedpocket  ", paramArrayOfString);
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if (QZoneJsConstants.a(paramString3)) {
      LocalMultiProcConfig.putBool("qzone_force_refresh", true);
    }
    if ("UpdateMallTimestamp".equalsIgnoreCase(paramString3))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("UpdateMallid".equalsIgnoreCase(paramString3))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("Personalize".equalsIgnoreCase(paramString3))
    {
      d(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("SetFacade".equalsIgnoreCase(paramString3))
    {
      e(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if (paramString3.equals("CleanZebraNum"))
    {
      QZoneZebraAlbumJsHandleLogic.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if (paramString3.equals("SetPersonalizeFinished"))
    {
      QZonePersonalizeJsHandleLogic.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if (paramString3.equals("openNameplateSucc"))
    {
      QZoneFacadeJsHandleLogic.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("downLoadFont".equalsIgnoreCase(paramString3))
    {
      a(paramVarArgs);
      return true;
    }
    if ("OpenCustomVipSucc".equals(paramString3))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("setDefaultFont".equals(paramString3))
    {
      b(paramVarArgs);
      return true;
    }
    if ("getDefaultFont".equals(paramString3))
    {
      e(paramVarArgs);
      return true;
    }
    if ("SetPlayerDeco".equals(paramString3))
    {
      f(paramVarArgs);
      return true;
    }
    if ("qzRooftopPageReady".equals(paramString3))
    {
      b();
      return true;
    }
    if ("OpenUrl".equals(paramString3))
    {
      g(paramVarArgs);
      return true;
    }
    if ("RefreshDeco".equals(paramString3))
    {
      RemoteHandleManager.a().a("cmd.refeshDecoCustom", null, false);
      return true;
    }
    if ("GetRedpocket".equals(paramString3))
    {
      h(paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzonePersonalizeJsPlugin
 * JD-Core Version:    0.7.0.1
 */