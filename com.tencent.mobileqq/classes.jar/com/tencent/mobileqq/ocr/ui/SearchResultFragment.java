package com.tencent.mobileqq.ocr.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.lebasearch.widget.ScrolledTabHost;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SearchResult;
import com.tencent.mobileqq.ocr.TabItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;

public class SearchResultFragment
  extends BaseOCRTextSearchFragment
{
  ViewPager c;
  ScrolledTabHost d;
  SearchResultViewPagerAdapter e;
  protected int f = 0;
  
  public void a()
  {
    ScrolledTabHost localScrolledTabHost = this.d;
    if (localScrolledTabHost != null) {
      localScrolledTabHost.b();
    }
  }
  
  public void a(String paramString, int paramInt, OCRTextSearchInfo.SearchResult paramSearchResult)
  {
    paramString = this.e.a(paramString, paramInt, paramSearchResult);
    this.d.a();
    paramInt = 0;
    while (paramInt < paramString.size())
    {
      paramSearchResult = (TabItem)paramString.get(paramInt);
      this.d.a(paramSearchResult.b);
      paramInt += 1;
    }
    if (paramString.size() == 1) {
      this.d.setVisibility(8);
    } else {
      this.d.setVisibility(0);
    }
    this.d.setCurrentTab(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ReportController.b(null, "dc00898", "", "", "0X80082E6", "0X80082E6", 0, 0, "", "", "", "");
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131625850, null);
    this.c = ((ViewPager)paramLayoutInflater.findViewById(2131449896));
    this.d = ((ScrolledTabHost)paramLayoutInflater.findViewById(2131446765));
    this.e = new SearchResultViewPagerAdapter(this.a, this, this.c);
    this.c.setAdapter(this.e);
    this.d.setOnTabSelectedListener(new SearchResultFragment.1(this));
    this.c.setOnPageChangeListener(new SearchResultFragment.2(this));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultFragment
 * JD-Core Version:    0.7.0.1
 */