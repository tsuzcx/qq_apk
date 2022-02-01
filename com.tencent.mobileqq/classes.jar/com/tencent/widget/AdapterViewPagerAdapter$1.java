package com.tencent.widget;

import android.database.DataSetObserver;

class AdapterViewPagerAdapter$1
  extends DataSetObserver
{
  AdapterViewPagerAdapter$1(AdapterViewPagerAdapter paramAdapterViewPagerAdapter) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AdapterViewPagerAdapter.1
 * JD-Core Version:    0.7.0.1
 */