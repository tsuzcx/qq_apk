package com.tencent.tavcut.render.builder.light;

import com.tencent.tavcut.render.EffectDispatcher.EffectDispatchListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/builder/light/LightRenderChainManager$EffectDispatchListener;", "Lcom/tencent/tavcut/render/EffectDispatcher$EffectDispatchListener;", "renderManager", "Lcom/tencent/tavcut/render/builder/light/LightRenderChainManager;", "(Lcom/tencent/tavcut/render/builder/light/LightRenderChainManager;)V", "reference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getReference", "()Ljava/lang/ref/WeakReference;", "onAfterApply", "", "onBeforeApply", "releaseAfterAllNode", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
final class LightRenderChainManager$EffectDispatchListener
  implements EffectDispatcher.EffectDispatchListener
{
  @NotNull
  private final WeakReference<LightRenderChainManager> a;
  
  public LightRenderChainManager$EffectDispatchListener(@NotNull LightRenderChainManager paramLightRenderChainManager)
  {
    this.a = new WeakReference(paramLightRenderChainManager);
  }
  
  public void a()
  {
    LightRenderChainManager localLightRenderChainManager = (LightRenderChainManager)this.a.get();
    if (localLightRenderChainManager != null) {
      LightRenderChainManager.a(localLightRenderChainManager);
    }
  }
  
  public void b()
  {
    LightRenderChainManager localLightRenderChainManager = (LightRenderChainManager)this.a.get();
    if (localLightRenderChainManager != null) {
      LightRenderChainManager.b(localLightRenderChainManager);
    }
  }
  
  public void c()
  {
    LightRenderChainManager localLightRenderChainManager = (LightRenderChainManager)this.a.get();
    if (localLightRenderChainManager != null) {
      LightRenderChainManager.c(localLightRenderChainManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.builder.light.LightRenderChainManager.EffectDispatchListener
 * JD-Core Version:    0.7.0.1
 */