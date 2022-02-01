package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.MiniAppStateMessage;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qqmini/minigame/plugins/LifecycleJsPlugin$onCreate$1", "Lcom/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter$RuntimeStateObserver;", "onStateChange", "", "msg", "Lcom/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter$MiniAppStateMessage;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class LifecycleJsPlugin$onCreate$1
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  LifecycleJsPlugin$onCreate$1(IMiniAppContext paramIMiniAppContext) {}
  
  public void onStateChange(@Nullable AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    Object localObject1 = null;
    if (paramMiniAppStateMessage != null) {
      paramMiniAppStateMessage = Integer.valueOf(paramMiniAppStateMessage.what);
    } else {
      paramMiniAppStateMessage = null;
    }
    if ((paramMiniAppStateMessage != null) && (paramMiniAppStateMessage.intValue() == 2051))
    {
      Object localObject2 = (RequestEvent)LifecycleJsPlugin.access$getLifeCycleMap$p(this.this$0).get("onAppEnterForeground");
      paramMiniAppStateMessage = this.$miniAppContext;
      if ((paramMiniAppStateMessage instanceof GameRuntime))
      {
        Object localObject3 = ((GameRuntime)paramMiniAppStateMessage).getGameInfoManager();
        paramMiniAppStateMessage = (AppRuntimeEventCenter.MiniAppStateMessage)localObject1;
        if (localObject3 != null)
        {
          localObject3 = ((GameInfoManager)localObject3).getOnShowParam();
          paramMiniAppStateMessage = (AppRuntimeEventCenter.MiniAppStateMessage)localObject1;
          if (localObject3 != null) {
            paramMiniAppStateMessage = ((JSONObject)localObject3).toString();
          }
        }
        if (localObject2 != null)
        {
          localObject1 = ((RequestEvent)localObject2).jsService;
          if (localObject1 != null) {
            ((IJsService)localObject1).evaluateSubscribeJS("onAppEnterForeground", paramMiniAppStateMessage, 0);
          }
        }
        localObject1 = GameLog.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("--onShow--onAppEnterForeground, ");
        ((StringBuilder)localObject2).append("params:");
        ((StringBuilder)localObject2).append(paramMiniAppStateMessage);
        ((GameLog)localObject1).w("LifecycleJsPlugin", ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      if ((paramMiniAppStateMessage != null) && (paramMiniAppStateMessage.intValue() == 2052))
      {
        paramMiniAppStateMessage = (RequestEvent)LifecycleJsPlugin.access$getLifeCycleMap$p(this.this$0).get("onAppEnterBackground");
        if (paramMiniAppStateMessage != null)
        {
          paramMiniAppStateMessage = paramMiniAppStateMessage.jsService;
          if (paramMiniAppStateMessage != null) {
            paramMiniAppStateMessage.evaluateSubscribeJS("onAppEnterBackground", "", 0);
          }
        }
        GameLog.getInstance().w("LifecycleJsPlugin", "--onHide--onAppEnterBackground");
        return;
      }
      if (paramMiniAppStateMessage == null) {
        return;
      }
      if (paramMiniAppStateMessage.intValue() == 2053)
      {
        GameLog.getInstance().i("LifecycleJsPlugin", "onAppStop");
        paramMiniAppStateMessage = (RequestEvent)LifecycleJsPlugin.access$getLifeCycleMap$p(this.this$0).get("onAppStop");
        if (paramMiniAppStateMessage != null)
        {
          paramMiniAppStateMessage = paramMiniAppStateMessage.jsService;
          if (paramMiniAppStateMessage != null) {
            paramMiniAppStateMessage.evaluateSubscribeJS("onAppStop", "", 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.LifecycleJsPlugin.onCreate.1
 * JD-Core Version:    0.7.0.1
 */