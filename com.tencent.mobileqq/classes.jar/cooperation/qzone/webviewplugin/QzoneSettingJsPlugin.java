package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneSettingJsPlugin
  extends QzoneInternalWebViewPlugin
{
  private boolean a(JsBridgeListener paramJsBridgeListener, WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramJsBridgeListener = paramWebViewPlugin.mRuntime.a();
    } while ((paramJsBridgeListener == null) || (paramJsBridgeListener.isFinishing()));
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfString[0]);
      int i = localJSONObject.optInt("iconID");
      paramJsBridgeListener = localJSONObject.optString("title");
      paramArrayOfString = localJSONObject.optString("callback");
      boolean bool = localJSONObject.optBoolean("hidden");
      localJSONObject.optBoolean("disable");
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a(paramWebViewPlugin.mRuntime.a());
      if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof WebUiUtils.WebTitleBarInterface))) {
        ((WebUiUtils.WebTitleBarInterface)paramWebViewPlugin).a(paramArrayOfString, paramJsBridgeListener, null, bool, i + 1000, 0, null);
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      label132:
      break label132;
    }
    return true;
  }
  
  private boolean a(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_barrage_effect_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowCommentBubbleGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean b(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      RemoteHandleManager.a().a().b(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowCommentBubbleSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean c(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = paramWebViewPlugin.mRuntime.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    long l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        continue;
      }
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowQzoneRemindfeedSetting-:" + bool);
      LocalMultiProcConfig.putBooleanAsync(localActivity.getString(2131434223) + l, bool);
      return true;
      bool = true;
    }
  }
  
  private boolean d(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = paramWebViewPlugin.mRuntime.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    long l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    paramWebViewPlugin = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      paramWebViewPlugin = paramArrayOfString;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        boolean bool;
        paramArrayOfString.printStackTrace();
      }
    }
    bool = LocalMultiProcConfig.getBool(localActivity.getString(2131434223) + l, true);
    if (bool) {
      i = 1;
    }
    paramWebViewPlugin = "window." + paramWebViewPlugin + "({new_value:" + i + "})";
    this.a.callJs(paramWebViewPlugin);
    QLog.i("QzoneSettingJsPlugin", 4, "---handleShowQzoneRemindfeedGet-:" + bool);
    return true;
  }
  
  private boolean e(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        bool = true;
        continue;
      }
      QLog.i("QzoneSettingJsPlugin", 4, "---handleVideoPlayModeSetting-:" + bool);
      LocalMultiProcConfig.putBool("QZ_setting", "Qzone_setVideoplay", bool);
      paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.VideoPlaySetting"));
      return true;
      bool = true;
    }
  }
  
  private boolean f(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("QZ_setting", "Qzone_setVideoplay", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleVideoPlayModeGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean g(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        bool = true;
        continue;
      }
      QLog.i("QzoneSettingJsPlugin", 4, "---handleGifPlayModeSetting-:" + bool);
      LocalMultiProcConfig.putBool("QZ_setting", "Qzone_setGifplay", bool);
      paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.GifPlaySetting"));
      return true;
      bool = true;
    }
  }
  
  private boolean h(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("QZ_setting", "Qzone_setGifplay", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleGifPlayModeGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean i(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    try
    {
      int j = new JSONObject(paramArrayOfString[0]).getInt("new_value");
      i = j;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
    paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.syncNoPhotoSetting"));
    QLog.i("QzoneSettingJsPlugin", 4, "---handlePictureModeSetting-:" + i);
    LocalMultiProcConfig.putInt(paramWebViewPlugin.getResources().getString(2131434226), i);
    return true;
  }
  
  private boolean j(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    Activity localActivity = paramWebViewPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return false;
    }
    String str = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      int i = LocalMultiProcConfig.getInt(localActivity.getResources().getString(2131434226), 0);
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handlePictureModeGet-:" + i);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = str;
      }
    }
  }
  
  private boolean k(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      RemoteHandleManager.a().a().a(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowFontSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean l(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_font_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowFontGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean m(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      RemoteHandleManager.a().a().c(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowSparkleFontSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean n(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_super_font_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowSparkleFontGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean o(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_passive_praise_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({isOpen:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handlePassivePraiseGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean p(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      LocalMultiProcConfig.putBool("qzone_passive_praise_enabled", bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowSparkleFontSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean q(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      LocalMultiProcConfig.putBool("qzone_feed_skin_enable", bool);
      RemoteHandleManager.a().a().a();
      QLog.i("QzoneSettingJsPlugin", 4, "---handlefeedSkinEnable-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean r(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_feed_skin_enable", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({isOpen:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleFeedSkinGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean s(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    RemoteHandleManager.a().a().a(paramArrayOfString[0]);
    QLog.i("QzoneSettingJsPlugin", 4, "---handleUpdateCustomPraise-:" + paramArrayOfString[0]);
    return true;
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("setShowRemindfeed"))
    {
      c(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setVideoPlayMode"))
    {
      e(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setGifPlayMode"))
    {
      g(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setPictureMode"))
    {
      i(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowFont"))
    {
      k(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getPictureMode"))
    {
      j(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowRemindfeed"))
    {
      d(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getVideoPlayMode"))
    {
      f(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getGifPlayMode"))
    {
      h(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowFont"))
    {
      l(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowSparkleFont"))
    {
      m(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowSparkleFont"))
    {
      n(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowCommentBubble"))
    {
      b(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowCommentBubble"))
    {
      a(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setPassivePraiseSwitch"))
    {
      p(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getPassivePraiseSwitch"))
    {
      o(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("updateCustomPraise"))
    {
      s(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setRightButton"))
    {
      a(paramJsBridgeListener, this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setFeedSkinSwitch"))
    {
      q(this.a, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getFeedSkinSwitch"))
    {
      r(this.a, paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneSettingJsPlugin
 * JD-Core Version:    0.7.0.1
 */