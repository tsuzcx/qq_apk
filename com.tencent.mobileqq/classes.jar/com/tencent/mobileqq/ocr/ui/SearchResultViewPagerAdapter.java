package com.tencent.mobileqq.ocr.ui;

import ajyc;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import aubd;
import aubf;
import aucm;
import audc;
import audd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchResultViewPagerAdapter
  extends PagerAdapter
{
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public aucm a;
  SearchResultFragment jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment;
  public List<audd> a;
  Map<String, audc> jdField_a_of_type_JavaUtilMap = new HashMap();
  List<aubd> b;
  
  public SearchResultViewPagerAdapter(aucm paramaucm, SearchResultFragment paramSearchResultFragment, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aucm = paramaucm;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = paramSearchResultFragment;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  public List<audd> a(String paramString, int paramInt, aubf paramaubf)
  {
    if (paramaubf != null) {}
    for (this.b = paramaubf.jdField_a_of_type_JavaUtilList;; this.b = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramaubf != null) && (paramaubf.b != null)) {
        this.jdField_a_of_type_JavaUtilList = paramaubf.b;
      }
      if ((paramInt != 0) || (paramaubf == null) || (paramaubf.b == null) || (paramaubf.b.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        audd localaudd = (audd)localIterator.next();
        if (localaudd.jdField_a_of_type_Int == 0)
        {
          localaudd.jdField_a_of_type_JavaUtilList = paramaubf.jdField_a_of_type_JavaUtilList;
          localaudd.jdField_a_of_type_Boolean = paramaubf.jdField_a_of_type_Boolean;
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      paramaubf = new audd();
      paramaubf.jdField_a_of_type_JavaLangString = ajyc.a(2131713644);
      paramaubf.jdField_a_of_type_Int = 0;
      paramaubf.jdField_a_of_type_JavaUtilList = this.b;
      if ((paramaubf.jdField_a_of_type_JavaUtilList == null) || (paramaubf.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label241;
      }
    }
    label241:
    for (paramaubf.jdField_b_of_type_Int = paramInt;; paramaubf.jdField_b_of_type_Int = -1)
    {
      paramaubf.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilList.add(0, paramaubf);
      a(this.jdField_a_of_type_Aucm.a());
      super.notifyDataSetChanged();
      return this.jdField_a_of_type_JavaUtilList;
    }
  }
  
  public void a(int paramInt)
  {
    audd localaudd = (audd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((audc)this.jdField_a_of_type_JavaUtilMap.get(localaudd.jdField_a_of_type_JavaLangString)).a();
  }
  
  void a(Context paramContext)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      audd localaudd = (audd)this.jdField_a_of_type_JavaUtilList.get(i);
      audc localaudc;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localaudd.jdField_a_of_type_JavaLangString)) {
        localaudc = (audc)this.jdField_a_of_type_JavaUtilMap.get(localaudd.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        localaudc.a(localaudd.jdField_a_of_type_Boolean);
        localaudc.a(paramContext, localaudd);
        i += 1;
        break;
        localaudc = new audc(this.jdField_a_of_type_Aucm, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
        this.jdField_a_of_type_JavaUtilMap.put(localaudd.jdField_a_of_type_JavaLangString, localaudc);
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
    Object localObject = (audd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localObject = ((audc)this.jdField_a_of_type_JavaUtilMap.get(((audd)localObject).jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_Aucm.a(), (audd)localObject);
    paramViewGroup.removeView((View)localObject);
    paramViewGroup.addView((View)localObject);
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */