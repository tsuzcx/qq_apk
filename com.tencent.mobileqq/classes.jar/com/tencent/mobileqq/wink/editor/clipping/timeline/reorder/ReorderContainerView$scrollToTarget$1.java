package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.graphics.Point;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ReorderContainerView$scrollToTarget$1
  implements Runnable
{
  ReorderContainerView$scrollToTarget$1(ReorderContainerView paramReorderContainerView, int paramInt, Point paramPoint) {}
  
  public final void run()
  {
    int i = ReorderContainerView.e(this.this$0).findFirstVisibleItemPosition();
    View localView = ReorderContainerView.e(this.this$0).getChildAt(this.a + 1 - i);
    if (localView != null)
    {
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      i = arrayOfInt[0];
      int j = this.b.x;
      this.this$0.scrollBy(i - j, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderContainerView.scrollToTarget.1
 * JD-Core Version:    0.7.0.1
 */