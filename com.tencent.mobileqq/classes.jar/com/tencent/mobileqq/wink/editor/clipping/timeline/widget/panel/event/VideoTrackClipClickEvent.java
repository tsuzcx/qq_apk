package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event;

import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/VideoTrackClipClickEvent;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelClickEvent;", "id", "", "selectedStatus", "", "data", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;", "(Ljava/lang/String;ILcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;)V", "getData", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;", "getId", "()Ljava/lang/String;", "getSelectedStatus", "()I", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackClipClickEvent
  extends PanelClickEvent
{
  @NotNull
  private final String a;
  private final int b;
  @Nullable
  private final ClipModel c;
  
  public VideoTrackClipClickEvent(@NotNull String paramString, int paramInt, @Nullable ClipModel paramClipModel)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramClipModel;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  @Nullable
  public final ClipModel c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoTrackClipClickEvent
 * JD-Core Version:    0.7.0.1
 */