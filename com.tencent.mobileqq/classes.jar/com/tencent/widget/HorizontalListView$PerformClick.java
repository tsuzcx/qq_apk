package com.tencent.widget;

import android.view.View;
import android.widget.ListAdapter;
import blmk;

class HorizontalListView$PerformClick
  extends blmk
  implements Runnable
{
  int a;
  
  private HorizontalListView$PerformClick(HorizontalListView paramHorizontalListView)
  {
    super(paramHorizontalListView, null);
  }
  
  public void run()
  {
    if (this.this$0.needTtransTouchStateToParen()) {}
    ListAdapter localListAdapter;
    int i;
    View localView;
    do
    {
      do
      {
        ((View)this.this$0.getParent()).performClick();
        do
        {
          return;
        } while (this.this$0.mDataChanged);
        localListAdapter = this.this$0.mAdapter;
        i = this.a;
      } while ((localListAdapter == null) || (i == -1) || (i >= localListAdapter.getCount()) || (!a()));
      localView = this.this$0.getChildAt(i - this.this$0.getFirstVisiblePosition());
    } while (localView == null);
    this.this$0.performItemClick(localView, i, localListAdapter.getItemId(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.PerformClick
 * JD-Core Version:    0.7.0.1
 */