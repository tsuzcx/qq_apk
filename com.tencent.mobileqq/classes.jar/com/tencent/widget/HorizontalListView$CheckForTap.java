package com.tencent.widget;

import android.view.View;
import android.view.ViewConfiguration;

final class HorizontalListView$CheckForTap
  implements Runnable
{
  HorizontalListView$CheckForTap(HorizontalListView paramHorizontalListView) {}
  
  public void run()
  {
    View localView;
    int i;
    if (this.this$0.mTouchMode == 0)
    {
      this.this$0.mTouchMode = 1;
      if (!this.this$0.needTtransTouchStateToParen()) {
        break label169;
      }
      localView = (View)this.this$0.getParent();
      if ((this.this$0.needTtransTouchStateToParen()) || ((localView != null) && (!localView.hasFocusable())))
      {
        if ((this.this$0.mDataChanged) && (!this.this$0.needTtransTouchStateToParen())) {
          break label215;
        }
        HorizontalListView.access$600(this.this$0, localView);
        i = ViewConfiguration.getLongPressTimeout();
        if (!this.this$0.needTtransTouchStateToParen()) {
          break label195;
        }
      }
    }
    label169:
    label195:
    for (boolean bool = localView.isLongClickable();; bool = this.this$0.isLongClickable())
    {
      if (!bool) {
        break label206;
      }
      if (HorizontalListView.access$700(this.this$0) == null) {
        HorizontalListView.access$702(this.this$0, new HorizontalListView.CheckForLongPress(this.this$0, null));
      }
      HorizontalListView.access$700(this.this$0).rememberWindowAttachCount();
      this.this$0.postDelayed(HorizontalListView.access$700(this.this$0), i);
      return;
      localView = this.this$0.getChildAt(HorizontalListView.access$500(this.this$0) - this.this$0.getFirstVisiblePosition());
      break;
    }
    label206:
    this.this$0.mTouchMode = 2;
    return;
    label215:
    this.this$0.mTouchMode = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.CheckForTap
 * JD-Core Version:    0.7.0.1
 */