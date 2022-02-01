package com.tencent.tkd.topicsdk.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch", "com/tencent/tkd/topicsdk/widget/MediaDisplayLayout$initGridView$1$1"}, k=3, mv={1, 1, 16})
final class MediaDisplayLayout$initGridView$$inlined$also$lambda$1
  implements View.OnTouchListener
{
  MediaDisplayLayout$initGridView$$inlined$also$lambda$1(MediaDisplayLayout paramMediaDisplayLayout) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a.getOnScrollListener();
    if (paramView != null) {
      paramView = (Unit)paramView.invoke();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.MediaDisplayLayout.initGridView..inlined.also.lambda.1
 * JD-Core Version:    0.7.0.1
 */