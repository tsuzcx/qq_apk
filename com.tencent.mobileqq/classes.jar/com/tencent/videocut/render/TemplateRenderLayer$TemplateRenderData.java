package com.tencent.videocut.render;

import com.tencent.tavcut.rendermodel.RenderModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/TemplateRenderLayer$TemplateRenderData;", "", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "musics", "", "Lcom/tencent/videocut/render/RenderData;", "(Lcom/tencent/tavcut/rendermodel/RenderModel;Ljava/util/List;)V", "getMusics", "()Ljava/util/List;", "getRenderModel", "()Lcom/tencent/tavcut/rendermodel/RenderModel;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TemplateRenderLayer$TemplateRenderData
{
  @Nullable
  private final RenderModel a;
  @NotNull
  private final List<RenderData> b;
  
  public TemplateRenderLayer$TemplateRenderData(@Nullable RenderModel paramRenderModel, @NotNull List<RenderData> paramList)
  {
    this.a = paramRenderModel;
    this.b = paramList;
  }
  
  @Nullable
  public final RenderModel a()
  {
    return this.a;
  }
  
  @NotNull
  public final List<RenderData> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.TemplateRenderLayer.TemplateRenderData
 * JD-Core Version:    0.7.0.1
 */