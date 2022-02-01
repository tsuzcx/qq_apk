package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.graphics.Bitmap;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackController$thumbListener$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IViewThumbnailGeneratedListener;", "onThumbnailGenerated", "", "tag", "", "startTimeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackController$thumbListener$1
  implements IViewThumbnailGeneratedListener
{
  @RequiresApi(17)
  public void a(@Nullable Object paramObject, long paramLong, @Nullable Bitmap paramBitmap)
  {
    if ((paramObject instanceof String))
    {
      paramBitmap = (VideoTrackContainerView)this.a.d();
      if (paramBitmap != null) {
        paramBitmap.a((String)paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackController.thumbListener.1
 * JD-Core Version:    0.7.0.1
 */