package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.IViewThumbnailGeneratedListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderImpl$ListenerWrapper;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/IThumbnailGeneratedListener;", "listener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IViewThumbnailGeneratedListener;", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IViewThumbnailGeneratedListener;)V", "getListener", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IViewThumbnailGeneratedListener;", "onThumbnailGenerated", "", "tag", "", "startTimeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ThumbnailProviderImpl$ListenerWrapper
  implements IThumbnailGeneratedListener
{
  @NotNull
  private final IViewThumbnailGeneratedListener a;
  
  public ThumbnailProviderImpl$ListenerWrapper(@NotNull IViewThumbnailGeneratedListener paramIViewThumbnailGeneratedListener)
  {
    this.a = paramIViewThumbnailGeneratedListener;
  }
  
  public void a(@Nullable Object paramObject, long paramLong, @Nullable Bitmap paramBitmap)
  {
    this.a.a(paramObject, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderImpl.ListenerWrapper
 * JD-Core Version:    0.7.0.1
 */