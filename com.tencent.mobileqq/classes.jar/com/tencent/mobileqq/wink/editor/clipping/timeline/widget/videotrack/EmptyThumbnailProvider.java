package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/EmptyThumbnailProvider;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IThumbnailProvider;", "()V", "getBitmapByTime", "Landroid/graphics/Bitmap;", "timeMs", "", "tag", "", "assetPath", "", "getDefaultBitmap", "registerListener", "", "listener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IViewThumbnailGeneratedListener;", "unRegisterListener", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class EmptyThumbnailProvider
  implements IThumbnailProvider
{
  @Nullable
  public Bitmap a()
  {
    return null;
  }
  
  @Nullable
  public Bitmap a(long paramLong, @Nullable Object paramObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "assetPath");
    return null;
  }
  
  public void a(@NotNull IViewThumbnailGeneratedListener paramIViewThumbnailGeneratedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIViewThumbnailGeneratedListener, "listener");
  }
  
  public void b(@NotNull IViewThumbnailGeneratedListener paramIViewThumbnailGeneratedListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIViewThumbnailGeneratedListener, "listener");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.EmptyThumbnailProvider
 * JD-Core Version:    0.7.0.1
 */