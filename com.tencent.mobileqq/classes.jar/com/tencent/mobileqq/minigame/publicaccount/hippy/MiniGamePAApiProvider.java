package com.tencent.mobileqq.minigame.publicaccount.hippy;

import com.tencent.mobileqq.minigame.publicaccount.hippy.module.MiniGamePANativeModule;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/hippy/MiniGamePAApiProvider;", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "()V", "getControllers", "", "Ljava/lang/Class;", "Lcom/tencent/mtt/hippy/uimanager/HippyViewController;", "getJavaScriptModules", "Lcom/tencent/mtt/hippy/modules/javascriptmodules/HippyJavaScriptModule;", "getNativeModules", "", "Lcom/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleBase;", "Lcom/tencent/mtt/hippy/common/Provider;", "hippyEngineContext", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGamePAApiProvider
  implements HippyAPIProvider
{
  @Nullable
  public List<Class<? extends HippyViewController<?>>> getControllers()
  {
    return null;
  }
  
  @Nullable
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    return null;
  }
  
  @NotNull
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(@NotNull HippyEngineContext paramHippyEngineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyEngineContext, "hippyEngineContext");
    return MapsKt.mutableMapOf(new Pair[] { TuplesKt.to(MiniGamePANativeModule.class, new MiniGamePAApiProvider.getNativeModules.1(paramHippyEngineContext)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAApiProvider
 * JD-Core Version:    0.7.0.1
 */