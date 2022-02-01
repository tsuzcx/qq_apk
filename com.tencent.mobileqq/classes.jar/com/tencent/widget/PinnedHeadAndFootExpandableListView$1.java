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
      long l = this.a.getExpandableListPosition(this.a.getFirstVisiblePosition());
      if ((ExpandableListView.getPackedPositionType(l) == 0) || (ExpandableListView.getPackedPositionType(l) == 1))
      {
        int i = ExpandableListView.getPackedPositionGroup(l);
        if ((this.a.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener == null) || (!this.a.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupClickListener.onGroupClick(this.a, paramView, i, this.a.jdField_a_of_type_ComTencentWidgetPinnedHeadAndFootExpandableListView$ExpandableListAdapter.getGroupId(i)))) {
          this.a.collapseGroup(i);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.PinnedHeadAndFootExpandableListView.1
 * JD-Core Version:    0.7.0.1
 */