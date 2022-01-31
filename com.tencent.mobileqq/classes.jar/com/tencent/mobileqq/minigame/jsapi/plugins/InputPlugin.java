package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.callbacks.PluginResultCallback;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import java.lang.ref.WeakReference;
import java.util.Set;

public class InputPlugin
  extends BaseJsPlugin
  implements PluginResultCallback
{
  public static final String EVENT_HIDE_KEYBOARD = "hideKeyboard";
  public static final String EVENT_SHOW_KEYBOARD = "showKeyboard";
  public static final String EVENT_UPDATE_KEYBOARD = "updateKeyboard";
  public static final String ON_KEYBOARD_COMPLETE_CALLBACK = "onKeyboardComplete";
  public static final String ON_KEYBOARD_CONFIRM_CALLBACK = "onKeyboardConfirm";
  public static final String ON_KEYBOARD_INPUT_CALLBACK = "onKeyboardInput";
  private static final Set<String> S_EVENT_MAP = new InputPlugin.1();
  private static final String TAG = "[minigame] InputPlugin";
  private long lastShowInputTime;
  private WeakReference<JsRuntime> mJsRuntimeRef;
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if (!(this.jsPluginEngine.getActivityContext() instanceof GameActivity))
    {
      QLog.e("[minigame] InputPlugin", 1, "handleNativeRequest activity not GameActivity, keyboard called fail");
      return "{}";
    }
    GameActivity localGameActivity = (GameActivity)this.jsPluginEngine.getActivityContext();
    this.mJsRuntimeRef = new WeakReference(paramJsRuntime);
    if ("showKeyboard".equals(paramString1)) {
      if (System.currentTimeMillis() - this.lastShowInputTime > 1000L)
      {
        this.lastShowInputTime = System.currentTimeMillis();
        localGameActivity.runOnUiThread(new InputPlugin.2(this, localGameActivity, paramString2, paramInt));
      }
    }
    for (;;)
    {
      return "{}";
      if ("hideKeyboard".equals(paramString1)) {
        localGameActivity.runOnUiThread(new InputPlugin.3(this, localGameActivity, paramInt));
      } else if ("updateKeyboard".equals(paramString1)) {
        localGameActivity.runOnUiThread(new InputPlugin.4(this, localGameActivity, paramString2, paramInt));
      }
    }
  }
  
  public void invokeCallback(int paramInt, String paramString)
  {
    ((JsRuntime)this.mJsRuntimeRef.get()).evaluateCallbackJs(paramInt, paramString);
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void subscribeCallback(String paramString1, String paramString2)
  {
    ((JsRuntime)this.mJsRuntimeRef.get()).evaluateSubcribeJS(paramString1, paramString2, -1);
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.InputPlugin
 * JD-Core Version:    0.7.0.1
 */