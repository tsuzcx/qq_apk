package com.tencent.mobileqq.minigame.publicaccount.hippy;

import com.tencent.mobileqq.minigame.publicaccount.hippy.module.MiniGamePANativeModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/minigame/publicaccount/hippy/module/MiniGamePANativeModule;", "get"}, k=3, mv={1, 1, 16})
final class MiniGamePAApiProvider$getNativeModules$1<T>
  implements Provider<MiniGamePANativeModule>
{
  MiniGamePAApiProvider$getNativeModules$1(HippyEngineContext paramHippyEngineContext) {}
  
  @NotNull
  public final MiniGamePANativeModule get()
  {
    return new MiniGamePANativeModule(this.$hippyEngineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAApiProvider.getNativeModules.1
 * JD-Core Version:    0.7.0.1
 */