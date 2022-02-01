package com.tencent.qqmini.minigame;

import android.webkit.ValueCallback;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.qqmini.minigame.utils.PluginLogger;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qqmini/minigame/GameJsPluginEngine$cacheCommonJsService$jsService$1", "Lcom/tencent/qqmini/sdk/launcher/core/IJsService;", "createNativeBuffer", "", "buffer", "", "offset", "", "length", "evaluateCallbackJs", "", "callbackId", "result", "", "evaluateJs", "js", "valueCallback", "Landroid/webkit/ValueCallback;", "evaluateSubscribeJS", "eventName", "data", "webviweId", "getNativeBuffer", "bufferId", "onInvokeForbiddenMethod", "method", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class GameJsPluginEngine$cacheCommonJsService$jsService$1
  implements IJsService
{
  GameJsPluginEngine$cacheCommonJsService$jsService$1(Argument paramArgument) {}
  
  public int createNativeBuffer(@NotNull byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "buffer");
    return this.$arguments.createBuffer(paramArrayOfByte, paramLong1, paramLong2);
  }
  
  public void evaluateCallbackJs(int paramInt, @Nullable String paramString)
  {
    onInvokeForbiddenMethod("evaluateCallbackJs");
  }
  
  public void evaluateJs(@Nullable String paramString, @Nullable ValueCallback<?> paramValueCallback)
  {
    onInvokeForbiddenMethod("evaluateJs");
  }
  
  public void evaluateSubscribeJS(@NotNull String paramString1, @Nullable String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "eventName");
    GameJsPluginEngine.access$getLogger$p(this.this$0).printEndLog(paramString1, paramString2);
    this.$arguments.subscribe(paramString1, paramString2);
  }
  
  @Nullable
  public byte[] getNativeBuffer(int paramInt)
  {
    return this.$arguments.getBuffer(paramInt);
  }
  
  public final void onInvokeForbiddenMethod(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "method");
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    Intrinsics.checkExpressionValueIsNotNull(localMiniAppProxy, "proxy");
    if (localMiniAppProxy.isDebugVersion()) {
      throw ((Throwable)new RuntimeException("can not invoke " + paramString + " on minigame common JsService"));
    }
    QMLog.e("GameJsPluginEngine", "can not invoke " + paramString + " on minigame common JsService");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameJsPluginEngine.cacheCommonJsService.jsService.1
 * JD-Core Version:    0.7.0.1
 */