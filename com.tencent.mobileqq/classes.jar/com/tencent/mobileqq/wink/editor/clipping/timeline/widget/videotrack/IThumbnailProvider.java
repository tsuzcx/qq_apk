package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IThumbnailProvider;", "", "getBitmapByTime", "Landroid/graphics/Bitmap;", "timeMs", "", "tag", "assetPath", "", "getDefaultBitmap", "registerListener", "", "listener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IViewThumbnailGeneratedListener;", "unRegisterListener", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IThumbnailProvider
{
  @Nullable
  public abstract Bitmap a();
  
  @Nullable
  public abstract Bitmap a(long paramLong, @Nullable Object paramObject, @NotNull String paramString);
  
  public abstract void a(@NotNull IViewThumbnailGeneratedListener paramIViewThumbnailGeneratedListener);
  
  public abstract void b(@NotNull IViewThumbnailGeneratedListener paramIViewThumbnailGeneratedListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.IThumbnailProvider
 * JD-Core Version:    0.7.0.1
 */