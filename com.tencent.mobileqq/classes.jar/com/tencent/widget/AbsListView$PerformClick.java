package com.tencent.widget;

import android.view.View;
import android.widget.ListAdapter;
import bkhj;

class AbsListView$PerformClick
  extends bkhj
  implements Runnable
{
  int a;
  
  private AbsListView$PerformClick(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    if (this.this$0.mDataChanged) {}
    ListAdapter localListAdapter;
    int i;
    boolean bool;
    View localView;
    do
    {
      do
      {
        return;
        localListAdapter = this.this$0.mAdapter;
        i = this.a;
        bool = AbsListView.access$500(this.this$0, i, this.this$0.mAdapter.getCount());
      } while ((localListAdapter == null) || ((!bool) && (!AbsListView.access$600(this.this$0))) || (!a()));
      localView = this.this$0.getChildAt(i - this.this$0.mFirstPosition);
    } while ((localView == null) && (!AbsListView.access$600(this.this$0)));
    AbsListView localAbsListView = this.this$0;
    if (bool) {}
    for (long l = localListAdapter.getItemId(i);; l = 0L)
    {
      localAbsListView.performItemClick(localView, i, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AbsListView.PerformClick
 * JD-Core Version:    0.7.0.1
 */