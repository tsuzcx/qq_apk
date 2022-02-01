package com.tencent.mobileqq.ocr.ui;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.lebasearch.widget.ScrolledTabHost;

class SearchResultFragment$2
  implements ViewPager.OnPageChangeListener
{
  SearchResultFragment$2(SearchResultFragment paramSearchResultFragment) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.a.d.setCurrentTab(paramInt);
    if (this.a.f != paramInt) {
      this.a.e.a(paramInt);
    }
    this.a.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultFragment.2
 * JD-Core Version:    0.7.0.1
 */