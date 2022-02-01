package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar;

import android.content.Context;
import android.view.GestureDetector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/view/GestureDetector;", "invoke"}, k=3, mv={1, 1, 16})
final class TimeBarView$scrollGestureDetector$2
  extends Lambda
  implements Function0<GestureDetector>
{
  TimeBarView$scrollGestureDetector$2(TimeBarView paramTimeBarView, Context paramContext)
  {
    super(0);
  }
  
  @NotNull
  public final GestureDetector invoke()
  {
    return new GestureDetector(this.$context, TimeBarView.d(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.TimeBarView.scrollGestureDetector.2
 * JD-Core Version:    0.7.0.1
 */