package com.tencent.mobileqq.ocr.ui;

import ajjy;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import ateh;
import atej;
import atfl;
import atgb;
import atgc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchResultViewPagerAdapter
  extends PagerAdapter
{
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public atfl a;
  SearchResultFragment jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment;
  public List<atgc> a;
  Map<String, atgb> jdField_a_of_type_JavaUtilMap = new HashMap();
  List<ateh> b;
  
  public SearchResultViewPagerAdapter(atfl paramatfl, SearchResultFragment paramSearchResultFragment, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Atfl = paramatfl;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = paramSearchResultFragment;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  public List<atgc> a(String paramString, int paramInt, atej paramatej)
  {
    if (paramatej != null) {}
    for (this.b = paramatej.jdField_a_of_type_JavaUtilList;; this.b = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramatej != null) && (paramatej.b != null)) {
        this.jdField_a_of_type_JavaUtilList = paramatej.b;
      }
      if ((paramInt != 0) || (paramatej == null) || (paramatej.b == null) || (paramatej.b.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        atgc localatgc = (atgc)localIterator.next();
        if (localatgc.jdField_a_of_type_Int == 0)
        {
          localatgc.jdField_a_of_type_JavaUtilList = paramatej.jdField_a_of_type_JavaUtilList;
          localatgc.jdField_a_of_type_Boolean = paramatej.jdField_a_of_type_Boolean;
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      paramatej = new atgc();
      paramatej.jdField_a_of_type_JavaLangString = ajjy.a(2131647857);
      paramatej.jdField_a_of_type_Int = 0;
      paramatej.jdField_a_of_type_JavaUtilList = this.b;
      if ((paramatej.jdField_a_of_type_JavaUtilList == null) || (paramatej.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label241;
      }
    }
    label241:
    for (paramatej.jdField_b_of_type_Int = paramInt;; paramatej.jdField_b_of_type_Int = -1)
    {
      paramatej.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilList.add(0, paramatej);
      a(this.jdField_a_of_type_Atfl.a());
      super.notifyDataSetChanged();
      return this.jdField_a_of_type_JavaUtilList;
    }
  }
  
  public void a(int paramInt)
  {
    atgc localatgc = (atgc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((atgb)this.jdField_a_of_type_JavaUtilMap.get(localatgc.jdField_a_of_type_JavaLangString)).a();
  }
  
  void a(Context paramContext)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      atgc localatgc = (atgc)this.jdField_a_of_type_JavaUtilList.get(i);
      atgb localatgb;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localatgc.jdField_a_of_type_JavaLangString)) {
        localatgb = (atgb)this.jdField_a_of_type_JavaUtilMap.get(localatgc.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        localatgb.a(localatgc.jdField_a_of_type_Boolean);
        localatgb.a(paramContext, localatgc);
        i += 1;
        break;
        localatgb = new atgb(this.jdField_a_of_type_Atfl, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
        this.jdField_a_of_type_JavaUtilMap.put(localatgc.jdField_a_of_type_JavaLangString, localatgb);
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
    Object localObject = (atgc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localObject = ((atgb)this.jdField_a_of_type_JavaUtilMap.get(((atgc)localObject).jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_Atfl.a(), (atgc)localObject);
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