package com.tencent.mobileqq.emosm.view;

import android.database.DataSetObserver;

class DragSortListView$AdapterWrapper$1
  extends DataSetObserver
{
  DragSortListView$AdapterWrapper$1(DragSortListView.AdapterWrapper paramAdapterWrapper, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.b.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.b.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.AdapterWrapper.1
 * JD-Core Version:    0.7.0.1
 */