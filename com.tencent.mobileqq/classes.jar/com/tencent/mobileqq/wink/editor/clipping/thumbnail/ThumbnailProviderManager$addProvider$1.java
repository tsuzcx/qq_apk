package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailAssetProvider;", "invoke"}, k=3, mv={1, 1, 16})
final class ThumbnailProviderManager$addProvider$1
  extends Lambda
  implements Function1<ThumbnailAssetProvider, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  ThumbnailProviderManager$addProvider$1()
  {
    super(1);
  }
  
  public final void invoke(@NotNull ThumbnailAssetProvider paramThumbnailAssetProvider)
  {
    Intrinsics.checkParameterIsNotNull(paramThumbnailAssetProvider, "it");
    paramThumbnailAssetProvider.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager.addProvider.1
 * JD-Core Version:    0.7.0.1
 */