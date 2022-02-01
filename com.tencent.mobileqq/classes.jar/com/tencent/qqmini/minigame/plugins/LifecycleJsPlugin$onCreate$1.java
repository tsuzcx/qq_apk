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
    if (paramMiniAppStateMessage != null)
    {
      paramMiniAppStateMessage = Integer.valueOf(paramMiniAppStateMessage.what);
      if (paramMiniAppStateMessage != null) {
        break label30;
      }
      label16:
      if (paramMiniAppStateMessage != null) {
        break label157;
      }
      label20:
      if (paramMiniAppStateMessage != null) {
        break label219;
      }
    }
    label30:
    label219:
    do
    {
      do
      {
        do
        {
          Object localObject;
          do
          {
            return;
            paramMiniAppStateMessage = null;
            break;
            if (paramMiniAppStateMessage.intValue() != 2051) {
              break label16;
            }
            localObject = (RequestEvent)LifecycleJsPlugin.access$getLifeCycleMap$p(this.this$0).get("onAppEnterForeground");
          } while (!(this.$miniAppContext instanceof GameRuntime));
          paramMiniAppStateMessage = ((GameRuntime)this.$miniAppContext).getGameInfoManager();
          if (paramMiniAppStateMessage != null)
          {
            paramMiniAppStateMessage = paramMiniAppStateMessage.getOnShowParam();
            if (paramMiniAppStateMessage == null) {}
          }
          for (paramMiniAppStateMessage = paramMiniAppStateMessage.toString();; paramMiniAppStateMessage = null)
          {
            if (localObject != null)
            {
              localObject = ((RequestEvent)localObject).jsService;
              if (localObject != null) {
                ((IJsService)localObject).evaluateSubscribeJS("onAppEnterForeground", paramMiniAppStateMessage, 0);
              }
            }
            GameLog.getInstance().w("LifecycleJsPlugin", "--onShow--onAppEnterForeground, " + "params:" + paramMiniAppStateMessage);
            return;
          }
          if (paramMiniAppStateMessage.intValue() != 2052) {
            break label20;
          }
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
        } while (paramMiniAppStateMessage.intValue() != 2053);
        GameLog.getInstance().i("LifecycleJsPlugin", "onAppStop");
        paramMiniAppStateMessage = (RequestEvent)LifecycleJsPlugin.access$getLifeCycleMap$p(this.this$0).get("onAppStop");
      } while (paramMiniAppStateMessage == null);
      paramMiniAppStateMessage = paramMiniAppStateMessage.jsService;
    } while (paramMiniAppStateMessage == null);
    label157:
    paramMiniAppStateMessage.evaluateSubscribeJS("onAppStop", "", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.LifecycleJsPlugin.onCreate.1
 * JD-Core Version:    0.7.0.1
 */