package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailAssetProvider$defaultVideoThumbListener$1", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IThumbnailGeneratedListener;", "onThumbnailGenerated", "", "tag", "", "startTimeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbnailAssetProvider$defaultVideoThumbListener$1
  implements IThumbnailGeneratedListener
{
  public void a(@Nullable Object paramObject, long paramLong, @Nullable Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ThumbnailAssetProvider.a(this.a).a(paramLong, paramBitmap);
    }
    Object localObject = String.valueOf(paramLong);
    paramObject = (List)ThumbnailAssetProvider.b(this.a).get(localObject);
    if (paramObject != null)
    {
      ThumbnailAssetProvider.b(this.a).remove(localObject);
      localObject = ThumbnailAssetProvider.c(this.a);
      if (localObject != null)
      {
        paramObject = ((Iterable)paramObject).iterator();
        while (paramObject.hasNext()) {
          ((IThumbnailGeneratedListener)localObject).a(paramObject.next(), paramLong, paramBitmap);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailAssetProvider.defaultVideoThumbListener.1
 * JD-Core Version:    0.7.0.1
 */