package com.tencent.tavcut.render.rendernode;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.LightEngine;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/rendernode/LightRenderNode;", "Lcom/tencent/tavcut/render/rendernode/BaseEffectNode;", "lightEngine", "Lorg/light/LightEngine;", "lightAsset", "Lorg/light/LightAsset;", "(Lorg/light/LightEngine;Lorg/light/LightAsset;)V", "createFilter", "Lcom/tencent/tavcut/render/rendernode/BaseEffectNode$Filter;", "getReportKey", "", "LightFilter", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class LightRenderNode
  extends BaseEffectNode
{
  private LightEngine b;
  private LightAsset c;
  
  public LightRenderNode(@Nullable LightEngine paramLightEngine, @Nullable LightAsset paramLightAsset)
  {
    this.b = paramLightEngine;
    this.c = paramLightAsset;
  }
  
  @NotNull
  public BaseEffectNode.Filter c()
  {
    return (BaseEffectNode.Filter)new LightRenderNode.LightFilter(this.b, this.c);
  }
  
  @NotNull
  public String getReportKey()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.rendernode.LightRenderNode
 * JD-Core Version:    0.7.0.1
 */