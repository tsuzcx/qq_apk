package com.tencent.widget;

import android.database.DataSetObserver;

class PagerBaseAdapterWrapper$1
  extends DataSetObserver
{
  PagerBaseAdapterWrapper$1(PagerBaseAdapterWrapper paramPagerBaseAdapterWrapper) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.PagerBaseAdapterWrapper.1
 * JD-Core Version:    0.7.0.1
 */