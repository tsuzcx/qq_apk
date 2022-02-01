package com.tencent.mobileqq.widget;

import android.database.DataSetObserver;

class GridListView$1
  extends DataSetObserver
{
  GridListView$1(GridListView paramGridListView) {}
  
  public void onChanged()
  {
    if (this.a.a != null)
    {
      GridListView localGridListView = this.a;
      GridListView.a(localGridListView, localGridListView.a.getCount());
    }
    if (this.a.m != null) {
      this.a.m.notifyDataSetChanged();
    }
  }
  
  public void onInvalidated()
  {
    if (this.a.a != null)
    {
      GridListView localGridListView = this.a;
      GridListView.a(localGridListView, localGridListView.a.getCount());
    }
    if (this.a.m != null) {
      this.a.m.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GridListView.1
 * JD-Core Version:    0.7.0.1
 */