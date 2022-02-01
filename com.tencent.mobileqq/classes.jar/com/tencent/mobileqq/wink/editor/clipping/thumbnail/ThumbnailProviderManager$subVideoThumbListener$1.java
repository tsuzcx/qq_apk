package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager$subVideoThumbListener$1", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IThumbnailGeneratedListener;", "onThumbnailGenerated", "", "tag", "", "startTimeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbnailProviderManager$subVideoThumbListener$1
  implements IThumbnailGeneratedListener
{
  public void a(@Nullable Object paramObject, long paramLong, @Nullable Bitmap paramBitmap)
  {
    Iterator localIterator = ((Iterable)ThumbnailProviderManager.b(ThumbnailProviderManager.a)).iterator();
    while (localIterator.hasNext()) {
      ((IThumbnailGeneratedListener)localIterator.next()).a(paramObject, paramLong, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager.subVideoThumbListener.1
 * JD-Core Version:    0.7.0.1
 */