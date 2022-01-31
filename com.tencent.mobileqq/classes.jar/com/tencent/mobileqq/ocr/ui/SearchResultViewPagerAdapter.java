package com.tencent.mobileqq.ocr.ui;

import alud;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import avws;
import avwu;
import avyb;
import avyr;
import avys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchResultViewPagerAdapter
  extends PagerAdapter
{
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public avyb a;
  SearchResultFragment jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment;
  public List<avys> a;
  Map<String, avyr> jdField_a_of_type_JavaUtilMap = new HashMap();
  List<avws> b;
  
  public SearchResultViewPagerAdapter(avyb paramavyb, SearchResultFragment paramSearchResultFragment, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Avyb = paramavyb;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = paramSearchResultFragment;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  public List<avys> a(String paramString, int paramInt, avwu paramavwu)
  {
    if (paramavwu != null) {}
    for (this.b = paramavwu.jdField_a_of_type_JavaUtilList;; this.b = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramavwu != null) && (paramavwu.b != null)) {
        this.jdField_a_of_type_JavaUtilList = paramavwu.b;
      }
      if ((paramInt != 0) || (paramavwu == null) || (paramavwu.b == null) || (paramavwu.b.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        avys localavys = (avys)localIterator.next();
        if (localavys.jdField_a_of_type_Int == 0)
        {
          localavys.jdField_a_of_type_JavaUtilList = paramavwu.jdField_a_of_type_JavaUtilList;
          localavys.jdField_a_of_type_Boolean = paramavwu.jdField_a_of_type_Boolean;
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      paramavwu = new avys();
      paramavwu.jdField_a_of_type_JavaLangString = alud.a(2131714039);
      paramavwu.jdField_a_of_type_Int = 0;
      paramavwu.jdField_a_of_type_JavaUtilList = this.b;
      if ((paramavwu.jdField_a_of_type_JavaUtilList == null) || (paramavwu.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label241;
      }
    }
    label241:
    for (paramavwu.jdField_b_of_type_Int = paramInt;; paramavwu.jdField_b_of_type_Int = -1)
    {
      paramavwu.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilList.add(0, paramavwu);
      a(this.jdField_a_of_type_Avyb.a());
      super.notifyDataSetChanged();
      return this.jdField_a_of_type_JavaUtilList;
    }
  }
  
  public void a(int paramInt)
  {
    avys localavys = (avys)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((avyr)this.jdField_a_of_type_JavaUtilMap.get(localavys.jdField_a_of_type_JavaLangString)).a();
  }
  
  void a(Context paramContext)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      avys localavys = (avys)this.jdField_a_of_type_JavaUtilList.get(i);
      avyr localavyr;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localavys.jdField_a_of_type_JavaLangString)) {
        localavyr = (avyr)this.jdField_a_of_type_JavaUtilMap.get(localavys.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        localavyr.a(localavys.jdField_a_of_type_Boolean);
        localavyr.a(paramContext, localavys);
        i += 1;
        break;
        localavyr = new avyr(this.jdField_a_of_type_Avyb, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
        this.jdField_a_of_type_JavaUtilMap.put(localavys.jdField_a_of_type_JavaLangString, localavyr);
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
    Object localObject = (avys)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localObject = ((avyr)this.jdField_a_of_type_JavaUtilMap.get(((avys)localObject).jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_Avyb.a(), (avys)localObject);
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