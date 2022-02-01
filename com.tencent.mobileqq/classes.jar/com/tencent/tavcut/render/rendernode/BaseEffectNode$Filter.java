package com.tencent.tavcut.render.rendernode;

import com.tencent.tavkit.composition.video.RenderInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/rendernode/BaseEffectNode$Filter;", "", "apply", "", "imageParams", "Lcom/tencent/tavcut/render/rendernode/ImageParams;", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "isNeedApply", "", "release", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface BaseEffectNode$Filter
{
  public abstract void a();
  
  public abstract void a(@NotNull ImageParams paramImageParams, @NotNull RenderInfo paramRenderInfo);
  
  public abstract boolean a(@Nullable RenderInfo paramRenderInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.rendernode.BaseEffectNode.Filter
 * JD-Core Version:    0.7.0.1
 */