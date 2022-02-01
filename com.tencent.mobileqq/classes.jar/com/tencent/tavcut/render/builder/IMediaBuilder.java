package com.tencent.tavcut.render.builder;

import com.tencent.tavcut.rendermodel.RenderModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/builder/IMediaBuilder;", "", "buildComposition", "", "templatePath", "", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "builderListener", "Lcom/tencent/tavcut/render/builder/IMediaBuilderListener;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IMediaBuilder
{
  public abstract void a(@NotNull String paramString, @NotNull RenderModel paramRenderModel, @Nullable IMediaBuilderListener paramIMediaBuilderListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.builder.IMediaBuilder
 * JD-Core Version:    0.7.0.1
 */