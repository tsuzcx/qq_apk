package com.tencent.qqmini.minigame.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.minigame.action.DebugSocketAction;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(lazyLoad=false)
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/plugins/ProfileJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "()V", "jsService", "Lcom/tencent/qqmini/sdk/launcher/core/IJsService;", "observer", "Lcom/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter$RuntimeStateObserver;", "covertProfileToIdeData", "", "v8Message", "notifyProfileCmd", "", "cmd", "id", "", "onCreate", "miniAppContext", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "onDestroy", "registerProfile", "req", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "timePerformanceResult", "Companion", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class ProfileJsPlugin
  extends BaseJsPlugin
{
  private static final String API_REGISTER_PROFILE = "registerProfile";
  private static final String API_TIME_PERFORMANCE_RESULT = "timePerformanceResult";
  public static final ProfileJsPlugin.Companion Companion = new ProfileJsPlugin.Companion(null);
  private static final String EVENT_PROFILE_CMD = "onProfileCmd";
  private static final String TAG = "ProfileJsPlugin";
  private IJsService jsService;
  private AppRuntimeEventCenter.RuntimeStateObserver observer;
  
  private final String covertProfileToIdeData(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"debug_message\":[{\"seq\":1,\"category\":\"performance\",\"data\":");
    localStringBuilder.append(paramString);
    localStringBuilder.append("}]}");
    return localStringBuilder.toString();
  }
  
  private final void notifyProfileCmd(String paramString, int paramInt)
  {
    if (this.jsService != null)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", paramString);
      localJSONObject.put("id", paramInt);
      GameLog localGameLog = GameLog.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyProfileCmd cmd:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", id:");
      localStringBuilder.append(paramInt);
      localGameLog.w("ProfileJsPlugin", localStringBuilder.toString());
      paramString = this.jsService;
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      paramString.evaluateSubscribeJS("onProfileCmd", localJSONObject.toString(), -1);
    }
  }
  
  public void onCreate(@Nullable IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    paramIMiniAppContext = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
    if (paramIMiniAppContext != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramIMiniAppContext, "AppRuntimeLoaderManager.…r(mMiniAppInfo) ?: return");
      this.observer = ((AppRuntimeEventCenter.RuntimeStateObserver)new ProfileJsPlugin.onCreate.1(this));
      paramIMiniAppContext.addRuntimeStateObserver(this.observer);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    BaseRuntimeLoader localBaseRuntimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
    AppRuntimeEventCenter.RuntimeStateObserver localRuntimeStateObserver = this.observer;
    if ((localRuntimeStateObserver != null) && (localBaseRuntimeLoader != null)) {
      localBaseRuntimeLoader.removeRuntimeStateObserver(localRuntimeStateObserver);
    }
  }
  
  @JsEvent({"registerProfile"})
  public final void registerProfile(@NotNull RequestEvent paramRequestEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramRequestEvent, "req");
    this.jsService = paramRequestEvent.jsService;
  }
  
  @JsEvent({"timePerformanceResult"})
  public final void timePerformanceResult(@NotNull RequestEvent paramRequestEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramRequestEvent, "req");
    try
    {
      paramRequestEvent = new JSONObject(paramRequestEvent.jsonParams);
      Object localObject = paramRequestEvent.optString("result", "");
      int i = paramRequestEvent.optInt("id", -1);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramRequestEvent = new JSONArray((String)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("id", i);
        ((JSONObject)localObject).put("result", paramRequestEvent);
        paramRequestEvent = ((JSONObject)localObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(paramRequestEvent, "ret.toString()");
        paramRequestEvent = covertProfileToIdeData(paramRequestEvent);
        DebugSocketAction.obtain(this.mMiniAppContext).sendQQDebugMethodMsg("DebugMessageClient", paramRequestEvent);
        return;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("ProfileJsPlugin", "qq API_TIME_PERFORMANCE_REAULT:", (Throwable)paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.ProfileJsPlugin
 * JD-Core Version:    0.7.0.1
 */