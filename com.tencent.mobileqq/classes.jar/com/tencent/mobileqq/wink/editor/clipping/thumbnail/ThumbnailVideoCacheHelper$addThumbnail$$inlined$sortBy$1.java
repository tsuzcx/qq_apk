package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 1, 16})
public final class ThumbnailVideoCacheHelper$addThumbnail$$inlined$sortBy$1<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    return ComparisonsKt.compareValues((Comparable)Long.valueOf(((BitmapPoint)paramT1).b()), (Comparable)Long.valueOf(((BitmapPoint)paramT2).b()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailVideoCacheHelper.addThumbnail..inlined.sortBy.1
 * JD-Core Version:    0.7.0.1
 */