package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.api.ApiUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.utils.GameLog;
import java.util.Set;
import org.json.JSONObject;

public class ImmersivePlugin
  extends BaseJsPlugin
{
  public static final String API_SET_MEUN_STYLE = "setMenuStyle";
  public static final String API_SET_STATUS_BAR_STYLE = "setStatusBarStyle";
  public static final String MENU_STYLE_DARK = "dark";
  public static final String MENU_STYLE_LIGHT = "light";
  private static final String STATUS_BAR_STYLE_BLACK = "black";
  private static final String STATUS_BAR_STYLE_WHITE = "white";
  private static final String STYLE_TAG = "style";
  private static final Set<String> S_EVENT_MAP = new ImmersivePlugin.1();
  private static final String TAG = "ImmersivePlugin";
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    GameLog.getInstance().i("ImmersivePlugin", "handleNativeRequest event=" + paramString1 + ", jsonParams=" + paramString2 + ", callbackId=" + paramInt);
    if ((this.jsPluginEngine == null) || (!(this.jsPluginEngine.getActivityContext() instanceof GameActivity))) {
      return ApiUtil.wrapCallbackFail(paramString1, null).toString();
    }
    GameActivity localGameActivity;
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString2);
      localGameActivity = (GameActivity)this.jsPluginEngine.getActivityContext();
      if ("setStatusBarStyle".equals(paramString1))
      {
        paramString2 = localJSONObject1.optString("style", null);
        if ((!TextUtils.isEmpty(paramString2)) && (("white".equals(paramString2)) || ("black".equals(paramString2))))
        {
          localGameActivity.runOnUiThread(new ImmersivePlugin.2(this, localGameActivity, paramString2));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
          return ApiUtil.wrapCallbackOk(paramString1, null).toString();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localJSONObject2 = new JSONObject();
      }
      GameLog.vconsoleLog("setStatusBarStyle:fail invalid style " + paramString2);
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "invalid style " + paramString2, paramInt);
      return ApiUtil.wrapCallbackFail(paramString1, null, "invalid style " + paramString2).toString();
    }
    if ("setMenuStyle".equals(paramString1))
    {
      paramString2 = localJSONObject2.optString("style", null);
      if ((!TextUtils.isEmpty(paramString2)) && (("light".equals(paramString2)) || ("dark".equals(paramString2))))
      {
        localGameActivity.setMenuStyle(paramString2);
        this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
        return ApiUtil.wrapCallbackOk(paramString1, null).toString();
      }
      GameLog.vconsoleLog("setMenuStyle:fail invalid style " + paramString2);
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "invalid style " + paramString2, paramInt);
      return ApiUtil.wrapCallbackFail(paramString1, null, "invalid style " + paramString2).toString();
    }
    return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.ImmersivePlugin
 * JD-Core Version:    0.7.0.1
 */