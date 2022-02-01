package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ICacheInterface;", "", "addThumbnail", "", "startTimeUs", "", "bitmap", "Landroid/graphics/Bitmap;", "getCacheSize", "getThumbnail", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/BitmapPoint;", "timeUs", "release", "releaseLowMemory", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ICacheInterface
{
  @Nullable
  public abstract BitmapPoint a(long paramLong);
  
  public abstract void a();
  
  public abstract void a(long paramLong, @NotNull Bitmap paramBitmap);
  
  public abstract void b(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ICacheInterface
 * JD-Core Version:    0.7.0.1
 */