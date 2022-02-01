package com.tencent.mobileqq.ocr.ui;

import amtj;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import axml;
import axmn;
import axnu;
import axok;
import axol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchResultViewPagerAdapter
  extends PagerAdapter
{
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public axnu a;
  SearchResultFragment jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment;
  public List<axol> a;
  Map<String, axok> jdField_a_of_type_JavaUtilMap = new HashMap();
  List<axml> b;
  
  public SearchResultViewPagerAdapter(axnu paramaxnu, SearchResultFragment paramSearchResultFragment, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Axnu = paramaxnu;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = paramSearchResultFragment;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  public List<axol> a(String paramString, int paramInt, axmn paramaxmn)
  {
    if (paramaxmn != null) {}
    for (this.b = paramaxmn.jdField_a_of_type_JavaUtilList;; this.b = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramaxmn != null) && (paramaxmn.b != null)) {
        this.jdField_a_of_type_JavaUtilList = paramaxmn.b;
      }
      if ((paramInt != 0) || (paramaxmn == null) || (paramaxmn.b == null) || (paramaxmn.b.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        axol localaxol = (axol)localIterator.next();
        if (localaxol.jdField_a_of_type_Int == 0)
        {
          localaxol.jdField_a_of_type_JavaUtilList = paramaxmn.jdField_a_of_type_JavaUtilList;
          localaxol.jdField_a_of_type_Boolean = paramaxmn.jdField_a_of_type_Boolean;
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      paramaxmn = new axol();
      paramaxmn.jdField_a_of_type_JavaLangString = amtj.a(2131712759);
      paramaxmn.jdField_a_of_type_Int = 0;
      paramaxmn.jdField_a_of_type_JavaUtilList = this.b;
      if ((paramaxmn.jdField_a_of_type_JavaUtilList == null) || (paramaxmn.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label241;
      }
    }
    label241:
    for (paramaxmn.jdField_b_of_type_Int = paramInt;; paramaxmn.jdField_b_of_type_Int = -1)
    {
      paramaxmn.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilList.add(0, paramaxmn);
      a(this.jdField_a_of_type_Axnu.a());
      super.notifyDataSetChanged();
      return this.jdField_a_of_type_JavaUtilList;
    }
  }
  
  public void a(int paramInt)
  {
    axol localaxol = (axol)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((axok)this.jdField_a_of_type_JavaUtilMap.get(localaxol.jdField_a_of_type_JavaLangString)).a();
  }
  
  void a(Context paramContext)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      axol localaxol = (axol)this.jdField_a_of_type_JavaUtilList.get(i);
      axok localaxok;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localaxol.jdField_a_of_type_JavaLangString)) {
        localaxok = (axok)this.jdField_a_of_type_JavaUtilMap.get(localaxol.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        localaxok.a(localaxol.jdField_a_of_type_Boolean);
        localaxok.a(paramContext, localaxol);
        i += 1;
        break;
        localaxok = new axok(this.jdField_a_of_type_Axnu, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
        this.jdField_a_of_type_JavaUtilMap.put(localaxol.jdField_a_of_type_JavaLangString, localaxok);
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = (axol)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localObject = ((axok)this.jdField_a_of_type_JavaUtilMap.get(((axol)localObject).jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_Axnu.a(), (axol)localObject);
    paramViewGroup.removeView((View)localObject);
    paramViewGroup.addView((View)localObject);
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */