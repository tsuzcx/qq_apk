package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.graphics.Bitmap;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView$videoThumbProvider$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IVideoTrackBitmapProvider;", "getBitmap", "Landroid/graphics/Bitmap;", "offset", "", "tag", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackTimelineView$videoThumbProvider$1
  implements IVideoTrackBitmapProvider
{
  @Nullable
  public Bitmap a(int paramInt, @Nullable Object paramObject)
  {
    paramObject = VideoTrackTimelineView.a(this.a);
    if (paramObject != null)
    {
      Object localObject = VideoTrackTimelineView.c(this.a);
      if (localObject != null)
      {
        long l = ((ScaleCalculator)localObject).a(paramInt);
        localObject = paramObject.n().d();
        l = ((float)l / ((TimeData)localObject).a());
        return VideoTrackTimelineView.b(this.a).a(l, paramObject.b(), paramObject.d());
      }
      return VideoTrackTimelineView.b(this.a).a();
    }
    return VideoTrackTimelineView.b(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackTimelineView.videoThumbProvider.1
 * JD-Core Version:    0.7.0.1
 */