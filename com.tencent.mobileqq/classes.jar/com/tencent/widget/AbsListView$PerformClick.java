package com.tencent.widget;

import android.view.View;
import android.widget.ListAdapter;

class AbsListView$PerformClick
  extends AbsListView.WindowRunnnable
  implements Runnable
{
  int mClickMotionPosition;
  
  private AbsListView$PerformClick(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    if (this.this$0.mDataChanged) {
      return;
    }
    ListAdapter localListAdapter = this.this$0.mAdapter;
    int i = this.mClickMotionPosition;
    Object localObject = this.this$0;
    boolean bool = AbsListView.access$500((AbsListView)localObject, i, ((AbsListView)localObject).mAdapter.getCount());
    if ((localListAdapter != null) && ((bool) || (AbsListView.access$600(this.this$0))) && (sameWindow()))
    {
      localObject = this.this$0;
      localObject = ((AbsListView)localObject).getChildAt(i - ((AbsListView)localObject).mFirstPosition);
      if ((localObject != null) || (AbsListView.access$600(this.this$0)))
      {
        AbsListView localAbsListView = this.this$0;
        long l;
        if (bool) {
          l = localListAdapter.getItemId(i);
        } else {
          l = 0L;
        }
        localAbsListView.performItemClick((View)localObject, i, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsListView.PerformClick
 * JD-Core Version:    0.7.0.1
 */