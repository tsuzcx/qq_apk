package com.tencent.qqmini.minigame;

import android.webkit.ValueCallback;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.qqmini.minigame.utils.PluginLogger;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/GameJsService;", "Lcom/tencent/qqmini/sdk/launcher/core/IJsService;", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "logger", "Lcom/tencent/qqmini/minigame/utils/PluginLogger;", "(Lcom/tencent/mobileqq/triton/script/Argument;Lcom/tencent/qqmini/minigame/utils/PluginLogger;)V", "createNativeBuffer", "", "buffer", "", "offset", "", "length", "evaluateCallbackJs", "", "callbackId", "result", "", "evaluateJs", "js", "valueCallback", "Landroid/webkit/ValueCallback;", "evaluateSubscribeJS", "eventName", "data", "webviweId", "getContextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "getNativeBuffer", "bufferId", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class GameJsService
  implements IJsService
{
  private final Argument arguments;
  private final PluginLogger logger;
  
  public GameJsService(@NotNull Argument paramArgument, @NotNull PluginLogger paramPluginLogger)
  {
    this.arguments = paramArgument;
    this.logger = paramPluginLogger;
  }
  
  public int createNativeBuffer(@NotNull byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "buffer");
    return this.arguments.createBuffer(paramArrayOfByte, paramLong1, paramLong2);
  }
  
  public void evaluateCallbackJs(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "result");
    this.logger.printEndLog(paramInt, paramString);
    this.arguments.callback(paramString);
  }
  
  public void evaluateJs(@NotNull String paramString, @Nullable ValueCallback<?> paramValueCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "js");
  }
  
  public void evaluateSubscribeJS(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "eventName");
    Intrinsics.checkParameterIsNotNull(paramString2, "data");
    this.logger.printEndLog(paramString1, paramString2);
    this.arguments.subscribe(paramString1, paramString2);
  }
  
  @NotNull
  public final ScriptContextType getContextType()
  {
    return this.arguments.getContextType();
  }
  
  @Nullable
  public byte[] getNativeBuffer(int paramInt)
  {
    return this.arguments.getBuffer(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameJsService
 * JD-Core Version:    0.7.0.1
 */