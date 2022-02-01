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
  protected int a;
  ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  ScrolledTabHost jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost;
  SearchResultViewPagerAdapter jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter;
  
  public SearchResultFragment()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a()
  {
    ScrolledTabHost localScrolledTabHost = this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost;
    if (localScrolledTabHost != null) {
      localScrolledTabHost.b();
    }
  }
  
  public void a(String paramString, int paramInt, OCRTextSearchInfo.SearchResult paramSearchResult)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter.a(paramString, paramInt, paramSearchResult);
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.a();
    paramInt = 0;
    while (paramInt < paramString.size())
    {
      paramSearchResult = (TabItem)paramString.get(paramInt);
      this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.a(paramSearchResult.a);
      paramInt += 1;
    }
    if (paramString.size() == 1) {
      this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.setVisibility(8);
    } else {
      this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.setCurrentTab(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ReportController.b(null, "dc00898", "", "", "0X80082E6", "0X80082E6", 0, 0, "", "", "", "");
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559807, null);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = ((ViewPager)paramLayoutInflater.findViewById(2131380907));
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost = ((ScrolledTabHost)paramLayoutInflater.findViewById(2131378246));
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter = new SearchResultViewPagerAdapter(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface, this, this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter);
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.setOnTabSelectedListener(new SearchResultFragment.1(this));
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOnPageChangeListener(new SearchResultFragment.2(this));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultFragment
 * JD-Core Version:    0.7.0.1
 */