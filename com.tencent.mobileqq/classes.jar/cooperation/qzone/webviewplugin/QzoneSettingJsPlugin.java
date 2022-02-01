package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneSettingJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final int ALWAYS_BIG = 1;
  public static final int ALWAYS_SMALL = 2;
  public static final int AUTO = 0;
  public static final String NAMESPACE = "Qzone";
  public static final String TAG = "QzoneSettingJsPlugin";
  private static boolean gIsInitSupportPerformance = false;
  private static boolean gIsSupportPerformanceDevice = false;
  private SharedPreferences sp = BaseApplicationImpl.sApplication.getSharedPreferences("qzone_detail_sp", 4);
  
  private boolean handleCustomBrowseInfoSwitchSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
        int i = new JSONObject(paramArrayOfString[0]).getInt("enable");
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
      RemoteHandleManager.getInstance().getSender().notifyCustomBrowserChanged(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---notifyCustomBrowserChanged-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean handleFeedSkinGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
  
  private boolean handleFeedSkinSet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
      RemoteHandleManager.getInstance().getSender().notifyFeedSkinSwitchChagned();
      QLog.i("QzoneSettingJsPlugin", 4, "---handlefeedSkinEnable-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean handleGetCustomBrowseInfoSwitch(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
      boolean bool = LocalMultiProcConfig.getBool("qzone_feed_custom_browser_deco_switch", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({enable:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---customBrowserInfoSwitch-:" + bool);
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
  
  private void handleGetInteractSoundMode(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    i = 1;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = paramWebViewPlugin.mRuntime.a();
      } while ((localObject == null) || (((Activity)localObject).isFinishing()));
      try
      {
        localObject = new JSONObject(paramArrayOfString[0]).getString("callback");
        paramArrayOfString = (String[])localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          boolean bool;
          QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { "handleGetInteractSoundMode: json error " + paramArrayOfString[0], localJSONException });
          paramArrayOfString = null;
          continue;
          i = 0;
        }
      }
    } while (paramArrayOfString == null);
    bool = this.sp.getBoolean("qzone_sound_effect_enabled", false);
    if (bool)
    {
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "handleGetInteractSoundMode: " + bool);
      return;
    }
  }
  
  private void handleGetWaterMark(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      do
      {
        return;
        localActivity = paramWebViewPlugin.mRuntime.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      Activity localActivity = null;
      try
      {
        String str = new JSONObject(paramArrayOfString[0]).getString("callback");
        paramArrayOfString = str;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          long l;
          QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { "handleGetWaterMark: json error " + paramArrayOfString[0], localJSONException });
          paramArrayOfString = localActivity;
          continue;
          boolean bool = LocalMultiProcConfig.getBool("QZ_setting", "WaterMark_" + l, false);
        }
      }
    } while (paramArrayOfString == null);
    l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    if (LocalMultiProcConfig.containKey("Qzone_multi_setting", "WaterMark_" + l))
    {
      bool = LocalMultiProcConfig.getBool("Qzone_multi_setting", "WaterMark_" + l, false);
      QLog.i("QzoneSettingJsPlugin", 1, "use new key");
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 1, "handleGetWaterMark: " + bool + " uin:" + l);
      return;
    }
  }
  
  private boolean handleGifPlayModeGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
      boolean bool = LocalMultiProcConfig.getBool("QZ_setting", "Qzone_playMode", true);
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
  
  @Deprecated
  private boolean handleGifPlayModeSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
      LocalMultiProcConfig.putBool("QZ_setting", "Qzone_playMode", bool);
      paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.GifPlaySetting"));
      return true;
      bool = true;
    }
  }
  
  private boolean handleIsSupportParticleEffect(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
      if (isSupportPerformanceDevice()) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({enable:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleIsSupportParticleEffect-:" + i);
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
  
  private boolean handlePassivePraiseGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
  
  private boolean handlePassivePraiseSet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
  
  private boolean handlePictureModeGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
      int i = LocalMultiProcConfig.getInt(localActivity.getResources().getString(2131718683), 0);
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
  
  private boolean handlePictureModeSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
    LocalMultiProcConfig.putInt(paramWebViewPlugin.getResources().getString(2131718683), i);
    return true;
  }
  
  private void handleSetInteractSoundMode(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i == 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { "handleSetInteractSoundMode: json error " + paramArrayOfString[0], paramWebViewPlugin });
        continue;
      }
      QLog.i("QzoneSettingJsPlugin", 4, "handleSetInteractSoundMode: " + bool);
      this.sp.edit().putBoolean("qzone_sound_effect_enabled", bool).apply();
      return;
      bool = false;
    }
  }
  
  private boolean handleSetRightButton(JsBridgeListener paramJsBridgeListener, WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
        ((WebUiUtils.WebTitleBarInterface)paramWebViewPlugin).setRightButton(paramArrayOfString, paramJsBridgeListener, null, bool, i + 1000, 0, null, null);
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      label137:
      break label137;
    }
    return true;
  }
  
  private void handleSetWaterMark(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = paramWebViewPlugin.mRuntime.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    try
    {
      int i = new JSONObject(paramArrayOfString[0]).getInt("value");
      if (i != 0) {
        bool = true;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        long l;
        QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { "handleSetWaterMark: json error " + paramArrayOfString[0], localJSONException });
        bool = true;
      }
    }
    l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    QLog.i("QzoneSettingJsPlugin", 1, "handleSetWaterMark: " + bool + " uin:" + l);
    LocalMultiProcConfig.putBool("Qzone_multi_setting", "WaterMark_" + l, bool);
    LocalMultiProcConfig.putBool("QZ_setting", "WaterMark_" + l, bool);
  }
  
  private boolean handleShowCommentBubbleGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
  
  private boolean handleShowCommentBubbleSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
      RemoteHandleManager.getInstance().getSender().notifyBarrageEffectChanged(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowCommentBubbleSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean handleShowFontGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
  
  private boolean handleShowFontSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
      RemoteHandleManager.getInstance().getSender().notifyFontChanged(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowFontSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean handleShowQzoneRemindfeedGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
    bool = LocalMultiProcConfig.getBool(localActivity.getString(2131718678) + l, true);
    if (bool) {
      i = 1;
    }
    paramWebViewPlugin = "window." + paramWebViewPlugin + "({new_value:" + i + "})";
    this.parentPlugin.callJs(paramWebViewPlugin);
    QLog.i("QzoneSettingJsPlugin", 4, "---handleShowQzoneRemindfeedGet-:" + bool);
    return true;
  }
  
  private boolean handleShowQzoneRemindfeedSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
      LocalMultiProcConfig.putBooleanAsync(localActivity.getString(2131718678) + l, bool);
      return true;
      bool = true;
    }
  }
  
  private boolean handleShowSparkleFontGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
  
  private boolean handleShowSparkleFontSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
      RemoteHandleManager.getInstance().getSender().notifySuperFontChanged(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowSparkleFontSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean handleUpdateCustomPraise(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    RemoteHandleManager.getInstance().getSender().updateCustomPraise(paramArrayOfString[0]);
    QLog.i("QzoneSettingJsPlugin", 4, "---handleUpdateCustomPraise-:" + paramArrayOfString[0]);
    return true;
  }
  
  private boolean handleUpdateFontList(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    if ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing())) {
      return false;
    }
    RemoteHandleManager.getInstance().getSender().handleUpdateFontList();
    QLog.i("QzoneSettingJsPlugin", 4, "---handleUpdateFontList-:");
    return true;
  }
  
  private boolean handleUpdatePloymorphicPraise(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    RemoteHandleManager.getInstance().getSender().UpdatePloymorphicPraise(paramArrayOfString[0]);
    QLog.i("QzoneSettingJsPlugin", 4, "---handleUpdatePloymorphicPraise-:" + paramArrayOfString[0]);
    return true;
  }
  
  private boolean handleVideoPlayModeGet(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    Object localObject = paramWebViewPlugin.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return false;
    }
    localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      if (!LocalMultiProcConfig.getBool("QZ_setting", "Qzone_setVideoplay", true))
      {
        i = 2;
        LocalMultiProcConfig.putBool("QZ_setting", "Qzone_setVideoplay", true);
        paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
        QLog.i("QzoneSettingJsPlugin", 4, "---handleVideoPlayModeGet-:" + i);
        return true;
      }
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
        continue;
        int i = LocalMultiProcConfig.getInt("QZ_setting", "Qzone_playMode", 0);
      }
    }
  }
  
  private boolean handleVideoPlayModeSetting(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
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
      reportConfigInfo(j);
      i = j;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
    QLog.i("QzoneSettingJsPlugin", 4, "---handleVideoPlayModeSetting-:" + i);
    LocalMultiProcConfig.putInt("QZ_setting", "Qzone_playMode", i);
    paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.VideoPlaySetting"));
    return true;
  }
  
  public static boolean isSupportPerformanceDevice()
  {
    if (!gIsSupportPerformanceDevice)
    {
      gIsInitSupportPerformance = ((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(1, 1);
      gIsSupportPerformanceDevice = true;
    }
    return gIsInitSupportPerformance;
  }
  
  private void reportConfigInfo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      if (paramInt != -1) {
        LpReportInfo_pf00064.allReport(593, 2, paramInt);
      }
      return;
      paramInt = 8;
      continue;
      paramInt = 7;
      continue;
      paramInt = 9;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.parentPlugin == null) || (this.parentPlugin.mRuntime == null)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("setShowRemindfeed"))
    {
      handleShowQzoneRemindfeedSetting(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setVideoPlayMode"))
    {
      handleVideoPlayModeSetting(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setGifPlayMode"))
    {
      handleGifPlayModeSetting(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setPictureMode"))
    {
      handlePictureModeSetting(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowFont"))
    {
      handleShowFontSetting(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getPictureMode"))
    {
      handlePictureModeGet(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowRemindfeed"))
    {
      handleShowQzoneRemindfeedGet(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getVideoPlayMode"))
    {
      handleVideoPlayModeGet(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getGifPlayMode"))
    {
      handleGifPlayModeGet(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowFont"))
    {
      handleShowFontGet(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowSparkleFont"))
    {
      handleShowSparkleFontSetting(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowSparkleFont"))
    {
      handleShowSparkleFontGet(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowCommentBubble"))
    {
      handleShowCommentBubbleSetting(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowCommentBubble"))
    {
      handleShowCommentBubbleGet(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setPassivePraiseSwitch"))
    {
      handlePassivePraiseSet(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getPassivePraiseSwitch"))
    {
      handlePassivePraiseGet(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("isSupportParticleEffect"))
    {
      handleIsSupportParticleEffect(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("updateCustomPraise"))
    {
      handleUpdateCustomPraise(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setRightButton"))
    {
      handleSetRightButton(paramJsBridgeListener, this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setFeedSkinSwitch"))
    {
      handleFeedSkinSet(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getFeedSkinSwitch"))
    {
      handleFeedSkinGet(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("updatePloymorphicPraise"))
    {
      handleUpdatePloymorphicPraise(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("updateFontList"))
    {
      handleUpdateFontList(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getCustomBrowseInfoSwitch"))
    {
      handleGetCustomBrowseInfoSwitch(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("enableCustomBrowseInfo"))
    {
      handleCustomBrowseInfoSwitchSetting(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setInteractSoundMode"))
    {
      handleSetInteractSoundMode(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getInteractSoundMode"))
    {
      handleGetInteractSoundMode(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getWaterMark"))
    {
      handleGetWaterMark(this.parentPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setWaterMark"))
    {
      handleSetWaterMark(this.parentPlugin, paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneSettingJsPlugin
 * JD-Core Version:    0.7.0.1
 */