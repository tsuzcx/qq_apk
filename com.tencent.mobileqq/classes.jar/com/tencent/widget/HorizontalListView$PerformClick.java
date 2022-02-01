package com.tencent.widget;

import android.view.View;
import android.widget.ListAdapter;

class HorizontalListView$PerformClick
  extends HorizontalListView.WindowRunnnable
  implements Runnable
{
  int mClickMotionPosition;
  
  private HorizontalListView$PerformClick(HorizontalListView paramHorizontalListView)
  {
    super(paramHorizontalListView, null);
  }
  
  public void run()
  {
    if (this.this$0.needTtransTouchStateToParen())
    {
      ((View)this.this$0.getParent()).performClick();
      return;
    }
    if (this.this$0.mDataChanged) {
      return;
    }
    ListAdapter localListAdapter = this.this$0.mAdapter;
    int i = this.mClickMotionPosition;
    if ((localListAdapter != null) && (i != -1) && (i < localListAdapter.getCount()) && (sameWindow()))
    {
      Object localObject = this.this$0;
      localObject = ((HorizontalListView)localObject).getChildAt(i - ((HorizontalListView)localObject).getFirstVisiblePosition());
      if (localObject != null) {
        this.this$0.performItemClick((View)localObject, i, localListAdapter.getItemId(i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.PerformClick
 * JD-Core Version:    0.7.0.1
 */