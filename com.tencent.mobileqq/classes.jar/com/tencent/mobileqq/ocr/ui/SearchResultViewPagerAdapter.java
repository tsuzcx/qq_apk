package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import anvx;
import aysu;
import aysw;
import ayud;
import ayut;
import ayuu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchResultViewPagerAdapter
  extends PagerAdapter
{
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public ayud a;
  SearchResultFragment jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment;
  public List<ayuu> a;
  Map<String, ayut> jdField_a_of_type_JavaUtilMap = new HashMap();
  List<aysu> b;
  
  public SearchResultViewPagerAdapter(ayud paramayud, SearchResultFragment paramSearchResultFragment, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ayud = paramayud;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = paramSearchResultFragment;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  public List<ayuu> a(String paramString, int paramInt, aysw paramaysw)
  {
    if (paramaysw != null) {}
    for (this.b = paramaysw.jdField_a_of_type_JavaUtilList;; this.b = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramaysw != null) && (paramaysw.b != null)) {
        this.jdField_a_of_type_JavaUtilList = paramaysw.b;
      }
      if ((paramInt != 0) || (paramaysw == null) || (paramaysw.b == null) || (paramaysw.b.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ayuu localayuu = (ayuu)localIterator.next();
        if (localayuu.jdField_a_of_type_Int == 0)
        {
          localayuu.jdField_a_of_type_JavaUtilList = paramaysw.jdField_a_of_type_JavaUtilList;
          localayuu.jdField_a_of_type_Boolean = paramaysw.jdField_a_of_type_Boolean;
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      paramaysw = new ayuu();
      paramaysw.jdField_a_of_type_JavaLangString = anvx.a(2131713106);
      paramaysw.jdField_a_of_type_Int = 0;
      paramaysw.jdField_a_of_type_JavaUtilList = this.b;
      if ((paramaysw.jdField_a_of_type_JavaUtilList == null) || (paramaysw.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label241;
      }
    }
    label241:
    for (paramaysw.jdField_b_of_type_Int = paramInt;; paramaysw.jdField_b_of_type_Int = -1)
    {
      paramaysw.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilList.add(0, paramaysw);
      a(this.jdField_a_of_type_Ayud.a());
      super.notifyDataSetChanged();
      return this.jdField_a_of_type_JavaUtilList;
    }
  }
  
  public void a(int paramInt)
  {
    ayuu localayuu = (ayuu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((ayut)this.jdField_a_of_type_JavaUtilMap.get(localayuu.jdField_a_of_type_JavaLangString)).a();
  }
  
  void a(Context paramContext)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ayuu localayuu = (ayuu)this.jdField_a_of_type_JavaUtilList.get(i);
      ayut localayut;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localayuu.jdField_a_of_type_JavaLangString)) {
        localayut = (ayut)this.jdField_a_of_type_JavaUtilMap.get(localayuu.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        localayut.a(localayuu.jdField_a_of_type_Boolean);
        localayut.a(paramContext, localayuu);
        i += 1;
        break;
        localayut = new ayut(this.jdField_a_of_type_Ayud, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
        this.jdField_a_of_type_JavaUtilMap.put(localayuu.jdField_a_of_type_JavaLangString, localayut);
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
    Object localObject = (ayuu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localObject = ((ayut)this.jdField_a_of_type_JavaUtilMap.get(((ayuu)localObject).jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_Ayud.a(), (ayuu)localObject);
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