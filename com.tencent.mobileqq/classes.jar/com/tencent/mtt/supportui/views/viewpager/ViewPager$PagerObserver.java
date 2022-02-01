package com.tencent.mtt.supportui.views.viewpager;

import android.database.DataSetObserver;

class ViewPager$PagerObserver
  extends DataSetObserver
{
  ViewPager$PagerObserver(ViewPager paramViewPager) {}
  
  public void onChanged()
  {
    this.this$0.dataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.this$0.dataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.viewpager.ViewPager.PagerObserver
 * JD-Core Version:    0.7.0.1
 */