package com.tencent.tavcut.render.thumb;

import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.model.ClipSource;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/thumb/ThumbProviderAccessor;", "", "()V", "getThumbProvider", "Lcom/tencent/tavcut/render/thumb/IThumbProvider;", "clipSource", "Lcom/tencent/tavcut/model/ClipSource;", "size", "Lcom/tencent/tavcut/composition/model/component/Size;", "ThumbProvider", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class ThumbProviderAccessor
{
  public static final ThumbProviderAccessor a = new ThumbProviderAccessor();
  
  @JvmStatic
  @NotNull
  public static final IThumbProvider a(@NotNull ClipSource paramClipSource, @NotNull Size paramSize)
  {
    Intrinsics.checkParameterIsNotNull(paramClipSource, "clipSource");
    Intrinsics.checkParameterIsNotNull(paramSize, "size");
    return (IThumbProvider)new ThumbProviderAccessor.ThumbProvider(paramClipSource, paramSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.thumb.ThumbProviderAccessor
 * JD-Core Version:    0.7.0.1
 */