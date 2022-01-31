package com.tencent.mobileqq.ocr.ui;

import alpo;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import avsj;
import avsl;
import avts;
import avui;
import avuj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchResultViewPagerAdapter
  extends PagerAdapter
{
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public avts a;
  SearchResultFragment jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment;
  public List<avuj> a;
  Map<String, avui> jdField_a_of_type_JavaUtilMap = new HashMap();
  List<avsj> b;
  
  public SearchResultViewPagerAdapter(avts paramavts, SearchResultFragment paramSearchResultFragment, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Avts = paramavts;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = paramSearchResultFragment;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  public List<avuj> a(String paramString, int paramInt, avsl paramavsl)
  {
    if (paramavsl != null) {}
    for (this.b = paramavsl.jdField_a_of_type_JavaUtilList;; this.b = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramavsl != null) && (paramavsl.b != null)) {
        this.jdField_a_of_type_JavaUtilList = paramavsl.b;
      }
      if ((paramInt != 0) || (paramavsl == null) || (paramavsl.b == null) || (paramavsl.b.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        avuj localavuj = (avuj)localIterator.next();
        if (localavuj.jdField_a_of_type_Int == 0)
        {
          localavuj.jdField_a_of_type_JavaUtilList = paramavsl.jdField_a_of_type_JavaUtilList;
          localavuj.jdField_a_of_type_Boolean = paramavsl.jdField_a_of_type_Boolean;
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      paramavsl = new avuj();
      paramavsl.jdField_a_of_type_JavaLangString = alpo.a(2131714027);
      paramavsl.jdField_a_of_type_Int = 0;
      paramavsl.jdField_a_of_type_JavaUtilList = this.b;
      if ((paramavsl.jdField_a_of_type_JavaUtilList == null) || (paramavsl.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label241;
      }
    }
    label241:
    for (paramavsl.jdField_b_of_type_Int = paramInt;; paramavsl.jdField_b_of_type_Int = -1)
    {
      paramavsl.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilList.add(0, paramavsl);
      a(this.jdField_a_of_type_Avts.a());
      super.notifyDataSetChanged();
      return this.jdField_a_of_type_JavaUtilList;
    }
  }
  
  public void a(int paramInt)
  {
    avuj localavuj = (avuj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((avui)this.jdField_a_of_type_JavaUtilMap.get(localavuj.jdField_a_of_type_JavaLangString)).a();
  }
  
  void a(Context paramContext)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      avuj localavuj = (avuj)this.jdField_a_of_type_JavaUtilList.get(i);
      avui localavui;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localavuj.jdField_a_of_type_JavaLangString)) {
        localavui = (avui)this.jdField_a_of_type_JavaUtilMap.get(localavuj.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        localavui.a(localavuj.jdField_a_of_type_Boolean);
        localavui.a(paramContext, localavuj);
        i += 1;
        break;
        localavui = new avui(this.jdField_a_of_type_Avts, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
        this.jdField_a_of_type_JavaUtilMap.put(localavuj.jdField_a_of_type_JavaLangString, localavui);
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
    Object localObject = (avuj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localObject = ((avui)this.jdField_a_of_type_JavaUtilMap.get(((avuj)localObject).jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_Avts.a(), (avuj)localObject);
    paramViewGroup.removeView((View)localObject);
    paramViewGroup.addView((View)localObject);
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */