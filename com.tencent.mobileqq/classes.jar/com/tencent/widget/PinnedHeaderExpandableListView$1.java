package com.tencent.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class PinnedHeaderExpandableListView$1
  implements View.OnTouchListener
{
  PinnedHeaderExpandableListView$1(PinnedHeaderExpandableListView paramPinnedHeaderExpandableListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      long l = this.this$0.getExpandableListPosition(this.this$0.getFirstVisiblePosition());
      if ((ExpandableListView.getPackedPositionType(l) == 0) || (ExpandableListView.getPackedPositionType(l) == 1))
      {
        int i = ExpandableListView.getPackedPositionGroup(l);
        if ((PinnedHeaderExpandableListView.access$000(this.this$0) == null) || (!PinnedHeaderExpandableListView.access$000(this.this$0).onGroupClick(this.this$0, paramView, i, PinnedHeaderExpandableListView.access$100(this.this$0).getGroupId(i)))) {
          this.this$0.collapseGroup(i);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.PinnedHeaderExpandableListView.1
 * JD-Core Version:    0.7.0.1
 */