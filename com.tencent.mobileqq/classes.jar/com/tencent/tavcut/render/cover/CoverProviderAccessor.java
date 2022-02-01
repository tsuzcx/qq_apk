package com.tencent.tavcut.render.cover;

import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.rendermodel.RenderModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/cover/CoverProviderAccessor;", "", "()V", "accessCoverProvider", "Lcom/tencent/tavcut/render/cover/ICoverProvider;", "templateDir", "", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "size", "Lcom/tencent/tavcut/composition/model/component/Size;", "CoverProvider", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class CoverProviderAccessor
{
  public static final CoverProviderAccessor a = new CoverProviderAccessor();
  
  @JvmStatic
  @NotNull
  public static final ICoverProvider a(@NotNull String paramString, @NotNull RenderModel paramRenderModel, @NotNull Size paramSize)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "templateDir");
    Intrinsics.checkParameterIsNotNull(paramRenderModel, "renderModel");
    Intrinsics.checkParameterIsNotNull(paramSize, "size");
    return (ICoverProvider)new CoverProviderAccessor.CoverProvider(paramString, paramRenderModel, paramSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.cover.CoverProviderAccessor
 * JD-Core Version:    0.7.0.1
 */