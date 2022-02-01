package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel;

import android.content.Context;
import android.view.ScaleGestureDetector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/view/ScaleGestureDetector;", "invoke"}, k=3, mv={1, 1, 16})
final class TimelinePanel$scaleGestureDetector$2
  extends Lambda
  implements Function0<ScaleGestureDetector>
{
  TimelinePanel$scaleGestureDetector$2(TimelinePanel paramTimelinePanel, Context paramContext)
  {
    super(0);
  }
  
  @NotNull
  public final ScaleGestureDetector invoke()
  {
    ScaleGestureDetector localScaleGestureDetector = new ScaleGestureDetector(this.$context, TimelinePanel.b(this.this$0));
    TimelinePanel.a(this.this$0, localScaleGestureDetector);
    return localScaleGestureDetector;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel.scaleGestureDetector.2
 * JD-Core Version:    0.7.0.1
 */