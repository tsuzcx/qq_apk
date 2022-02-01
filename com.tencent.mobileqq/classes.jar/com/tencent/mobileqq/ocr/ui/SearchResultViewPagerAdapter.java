package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import anni;
import aygk;
import aygm;
import ayht;
import ayij;
import ayik;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchResultViewPagerAdapter
  extends PagerAdapter
{
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public ayht a;
  SearchResultFragment jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment;
  public List<ayik> a;
  Map<String, ayij> jdField_a_of_type_JavaUtilMap = new HashMap();
  List<aygk> b;
  
  public SearchResultViewPagerAdapter(ayht paramayht, SearchResultFragment paramSearchResultFragment, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ayht = paramayht;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = paramSearchResultFragment;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  public List<ayik> a(String paramString, int paramInt, aygm paramaygm)
  {
    if (paramaygm != null) {}
    for (this.b = paramaygm.jdField_a_of_type_JavaUtilList;; this.b = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramaygm != null) && (paramaygm.b != null)) {
        this.jdField_a_of_type_JavaUtilList = paramaygm.b;
      }
      if ((paramInt != 0) || (paramaygm == null) || (paramaygm.b == null) || (paramaygm.b.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ayik localayik = (ayik)localIterator.next();
        if (localayik.jdField_a_of_type_Int == 0)
        {
          localayik.jdField_a_of_type_JavaUtilList = paramaygm.jdField_a_of_type_JavaUtilList;
          localayik.jdField_a_of_type_Boolean = paramaygm.jdField_a_of_type_Boolean;
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      paramaygm = new ayik();
      paramaygm.jdField_a_of_type_JavaLangString = anni.a(2131712418);
      paramaygm.jdField_a_of_type_Int = 0;
      paramaygm.jdField_a_of_type_JavaUtilList = this.b;
      if ((paramaygm.jdField_a_of_type_JavaUtilList == null) || (paramaygm.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label241;
      }
    }
    label241:
    for (paramaygm.jdField_b_of_type_Int = paramInt;; paramaygm.jdField_b_of_type_Int = -1)
    {
      paramaygm.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilList.add(0, paramaygm);
      a(this.jdField_a_of_type_Ayht.a());
      super.notifyDataSetChanged();
      return this.jdField_a_of_type_JavaUtilList;
    }
  }
  
  public void a(int paramInt)
  {
    ayik localayik = (ayik)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((ayij)this.jdField_a_of_type_JavaUtilMap.get(localayik.jdField_a_of_type_JavaLangString)).a();
  }
  
  void a(Context paramContext)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ayik localayik = (ayik)this.jdField_a_of_type_JavaUtilList.get(i);
      ayij localayij;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localayik.jdField_a_of_type_JavaLangString)) {
        localayij = (ayij)this.jdField_a_of_type_JavaUtilMap.get(localayik.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        localayij.a(localayik.jdField_a_of_type_Boolean);
        localayij.a(paramContext, localayik);
        i += 1;
        break;
        localayij = new ayij(this.jdField_a_of_type_Ayht, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
        this.jdField_a_of_type_JavaUtilMap.put(localayik.jdField_a_of_type_JavaLangString, localayij);
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
    Object localObject = (ayik)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localObject = ((ayij)this.jdField_a_of_type_JavaUtilMap.get(((ayik)localObject).jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_Ayht.a(), (ayik)localObject);
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