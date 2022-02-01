package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.MiniAppStateMessage;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qqmini/minigame/plugins/ProfileJsPlugin$onCreate$1", "Lcom/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter$RuntimeStateObserver;", "onStateChange", "", "msg", "Lcom/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter$MiniAppStateMessage;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class ProfileJsPlugin$onCreate$1
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  public void onStateChange(@Nullable AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    if (paramMiniAppStateMessage != null)
    {
      localObject = Integer.valueOf(paramMiniAppStateMessage.what);
      if (localObject != null) {
        break label26;
      }
      label16:
      if (localObject != null) {
        break label74;
      }
    }
    label26:
    label74:
    while (((Integer)localObject).intValue() != 2057)
    {
      return;
      localObject = null;
      break;
      if (((Integer)localObject).intValue() != 2056) {
        break label16;
      }
      localObject = this.this$0;
      paramMiniAppStateMessage = paramMiniAppStateMessage.obj;
      if (paramMiniAppStateMessage == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
      ProfileJsPlugin.access$notifyProfileCmd((ProfileJsPlugin)localObject, "start", ((Integer)paramMiniAppStateMessage).intValue());
      return;
    }
    Object localObject = this.this$0;
    paramMiniAppStateMessage = paramMiniAppStateMessage.obj;
    if (paramMiniAppStateMessage == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    ProfileJsPlugin.access$notifyProfileCmd((ProfileJsPlugin)localObject, "end", ((Integer)paramMiniAppStateMessage).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.ProfileJsPlugin.onCreate.1
 * JD-Core Version:    0.7.0.1
 */