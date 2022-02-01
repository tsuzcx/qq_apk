package com.tencent.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class PinnedHeadAndFootExpandableListView$1
  implements View.OnTouchListener
{
  PinnedHeadAndFootExpandableListView$1(PinnedHeadAndFootExpandableListView paramPinnedHeadAndFootExpandableListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = this.a;
      long l = paramMotionEvent.getExpandableListPosition(paramMotionEvent.getFirstVisiblePosition());
      if ((ExpandableListView.getPackedPositionType(l) == 0) || (ExpandableListView.getPackedPositionType(l) == 1))
      {
        int i = ExpandableListView.getPackedPositionGroup(l);
        if (this.a.n != null)
        {
          paramMotionEvent = this.a.n;
          PinnedHeadAndFootExpandableListView localPinnedHeadAndFootExpandableListView = this.a;
          if (paramMotionEvent.onGroupClick(localPinnedHeadAndFootExpandableListView, paramView, i, localPinnedHeadAndFootExpandableListView.e.getGroupId(i))) {}
        }
        else
        {
          this.a.collapseGroup(i);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.PinnedHeadAndFootExpandableListView.1
 * JD-Core Version:    0.7.0.1
 */