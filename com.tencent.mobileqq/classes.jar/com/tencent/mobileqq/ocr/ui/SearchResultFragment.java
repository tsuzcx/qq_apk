package com.tencent.mobileqq.ocr.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import atej;
import atfy;
import atfz;
import atgc;
import awqx;
import com.tencent.biz.lebasearch.widget.ScrolledTabHost;
import java.util.List;

public class SearchResultFragment
  extends BaseOCRTextSearchFragment
{
  public int a;
  public ViewPager a;
  public ScrolledTabHost a;
  public SearchResultViewPagerAdapter a;
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost != null) {
      this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.b();
    }
  }
  
  public void a(String paramString, int paramInt, atej paramatej)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter.a(paramString, paramInt, paramatej);
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.a();
    paramInt = 0;
    while (paramInt < paramString.size())
    {
      paramatej = (atgc)paramString.get(paramInt);
      this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.a(paramatej.a);
      paramInt += 1;
    }
    if (paramString.size() == 1) {
      this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.setCurrentTab(0);
      return;
      this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    awqx.b(null, "dc00898", "", "", "0X80082E6", "0X80082E6", 0, 0, "", "", "", "");
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131494048, null);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramLayoutInflater.findViewById(2131313396));
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost = ((ScrolledTabHost)paramLayoutInflater.findViewById(2131311013));
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter = new SearchResultViewPagerAdapter(this.jdField_a_of_type_Atfl, this, this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultViewPagerAdapter);
    this.jdField_a_of_type_ComTencentBizLebasearchWidgetScrolledTabHost.setOnTabSelectedListener(new atfy(this));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new atfz(this));
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultFragment
 * JD-Core Version:    0.7.0.1
 */