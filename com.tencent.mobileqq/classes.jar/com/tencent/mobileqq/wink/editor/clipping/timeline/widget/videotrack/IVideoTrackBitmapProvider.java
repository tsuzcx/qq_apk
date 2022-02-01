package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IVideoTrackBitmapProvider;", "", "getBitmap", "Landroid/graphics/Bitmap;", "offset", "", "tag", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoTrackBitmapProvider
{
  @Nullable
  public abstract Bitmap a(int paramInt, @Nullable Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.IVideoTrackBitmapProvider
 * JD-Core Version:    0.7.0.1
 */