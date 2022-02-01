package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.callbacks.IGameUI;
import com.tencent.mobileqq.minigame.jsapi.manager.CustomButtonManager;
import com.tencent.mobileqq.minigame.jsapi.widgets.CustomButton.ButtonParam;
import com.tencent.mobileqq.minigame.jsapi.widgets.CustomButton.OnClickListener;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.utils.GameLog;
import java.lang.ref.WeakReference;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomButtonPlugin
  extends BaseJsPlugin
  implements CustomButton.OnClickListener
{
  private static final String API_OPERATE_CUSTOM_BUTTON = "operateCustomButton";
  private static final String COMPONENT_ID = "compId";
  private static final String LANG = "lang";
  private static final String ON_CUSTOM_BUTTON_CLICK = "onCustomButtonTap";
  private static final String OPERATE_CREATE = "create";
  private static final String OPERATE_DESTROY = "destroy";
  private static final String OPERATE_HIDE = "hide";
  private static final String OPERATE_SHOW = "show";
  private static final String OPERATE_TYPE = "operateType";
  private static final String OPERATE_UPDATE = "update";
  private static final Set<String> S_EVENT_MAP = new CustomButtonPlugin.1();
  private static final String TAG = "CustomButtonPlugin";
  private static final String WITH_CREDENTIALS = "withCredentials";
  private WeakReference<Context> mContextRef;
  private CustomButtonManager mCustomButtonManager;
  private WeakReference<JsRuntime> mJsRuntimeRef;
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if ((this.mContextRef == null) || (this.mContextRef.get() == null) || (!(this.mContextRef.get() instanceof GameActivity))) {
      return "{}";
    }
    Object localObject = (GameActivity)this.mContextRef.get();
    if (this.mCustomButtonManager == null) {
      this.mCustomButtonManager = new CustomButtonManager((Activity)localObject, (IGameUI)localObject, DisplayUtil.getDisplayMetrics((Context)localObject).density);
    }
    this.mJsRuntimeRef = new WeakReference(paramJsRuntime);
    if (("operateCustomButton".equals(paramString1)) && (this.mCustomButtonManager != null) && (!TextUtils.isEmpty(paramString2))) {
      for (;;)
      {
        try
        {
          localObject = new JSONObject(paramString2);
          String str = ((JSONObject)localObject).optString("operateType");
          long l = ((JSONObject)localObject).optLong("compId");
          if ("create".equals(str))
          {
            bool = this.mCustomButtonManager.createCustomButton((JSONObject)localObject, this);
            if (bool)
            {
              this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, null, paramInt);
              break;
            }
          }
          else
          {
            if ("show".equals(str))
            {
              bool = this.mCustomButtonManager.setCustomButtonVisible(l, true);
              continue;
            }
            if ("hide".equals(str))
            {
              bool = this.mCustomButtonManager.setCustomButtonVisible(l, false);
              continue;
            }
            if ("destroy".equals(str))
            {
              bool = this.mCustomButtonManager.destroyCustomButton(l);
              continue;
            }
            if (!"update".equals(str)) {
              break label349;
            }
            bool = this.mCustomButtonManager.updateCustomButton((JSONObject)localObject, this);
            continue;
          }
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "button not found", paramInt);
        }
        catch (JSONException localJSONException)
        {
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "json parse error", paramInt);
          GameLog.getInstance().e("CustomButtonPlugin", paramString1 + " parse json exception " + paramString2, localJSONException);
        }
        label349:
        boolean bool = false;
      }
    }
    return "{}";
  }
  
  public void onClick(CustomButton.ButtonParam paramButtonParam)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("compId", paramButtonParam.componentId);
      localJSONObject.put("withCredentials", paramButtonParam.withCredentials);
      localJSONObject.put("lang", paramButtonParam.lang);
      if ((this.mJsRuntimeRef != null) && (this.mJsRuntimeRef.get() != null)) {
        ((JsRuntime)this.mJsRuntimeRef.get()).evaluateSubcribeJS("onCustomButtonTap", localJSONObject.toString(), -1);
      }
      return;
    }
    catch (JSONException paramButtonParam)
    {
      GameLog.getInstance().e("CustomButtonPlugin", "onClick callback exception", paramButtonParam);
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.mContextRef = new WeakReference(paramBaseJsPluginEngine.getActivityContext());
  }
  
  public void onDestroy()
  {
    this.mContextRef = null;
    this.mJsRuntimeRef = null;
    super.onDestroy();
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.CustomButtonPlugin
 * JD-Core Version:    0.7.0.1
 */