package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event;

import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/VideoTrackCutEvent;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEvent;", "data", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;", "isLeft", "", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;Z)V", "getData", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;", "()Z", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackCutEvent
  extends PanelEvent
{
  @Nullable
  private final ClipModel a;
  private final boolean b;
  
  public VideoTrackCutEvent(@Nullable ClipModel paramClipModel, boolean paramBoolean)
  {
    this.a = paramClipModel;
    this.b = paramBoolean;
  }
  
  @Nullable
  public final ClipModel a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoTrackCutEvent
 * JD-Core Version:    0.7.0.1
 */