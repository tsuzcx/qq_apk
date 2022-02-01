package com.tencent.widget;

import android.database.DataSetObserver;

class HorizontalListView$HorizontalAdapterDataObserver
  extends DataSetObserver
{
  HorizontalListView$HorizontalAdapterDataObserver(HorizontalListView paramHorizontalListView) {}
  
  public void onChanged()
  {
    HorizontalListView localHorizontalListView = this.this$0;
    localHorizontalListView.mDataChanged = true;
    HorizontalListView.access$402(localHorizontalListView, false);
    HorizontalListView.access$100(this.this$0);
    this.this$0.invalidate();
    this.this$0.requestLayout();
  }
  
  public void onInvalidated()
  {
    HorizontalListView.access$402(this.this$0, false);
    HorizontalListView.access$100(this.this$0);
    this.this$0.reset(true);
    this.this$0.invalidate();
    this.this$0.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.HorizontalListView.HorizontalAdapterDataObserver
 * JD-Core Version:    0.7.0.1
 */