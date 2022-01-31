package com.tencent.mobileqq.ocr.ui;

import ajya;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import aubf;
import aubh;
import auco;
import aude;
import audf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchResultViewPagerAdapter
  extends PagerAdapter
{
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public auco a;
  SearchResultFragment jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment;
  public List<audf> a;
  Map<String, aude> jdField_a_of_type_JavaUtilMap = new HashMap();
  List<aubf> b;
  
  public SearchResultViewPagerAdapter(auco paramauco, SearchResultFragment paramSearchResultFragment, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Auco = paramauco;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = paramSearchResultFragment;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  public List<audf> a(String paramString, int paramInt, aubh paramaubh)
  {
    if (paramaubh != null) {}
    for (this.b = paramaubh.jdField_a_of_type_JavaUtilList;; this.b = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramaubh != null) && (paramaubh.b != null)) {
        this.jdField_a_of_type_JavaUtilList = paramaubh.b;
      }
      if ((paramInt != 0) || (paramaubh == null) || (paramaubh.b == null) || (paramaubh.b.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        audf localaudf = (audf)localIterator.next();
        if (localaudf.jdField_a_of_type_Int == 0)
        {
          localaudf.jdField_a_of_type_JavaUtilList = paramaubh.jdField_a_of_type_JavaUtilList;
          localaudf.jdField_a_of_type_Boolean = paramaubh.jdField_a_of_type_Boolean;
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      paramaubh = new audf();
      paramaubh.jdField_a_of_type_JavaLangString = ajya.a(2131713655);
      paramaubh.jdField_a_of_type_Int = 0;
      paramaubh.jdField_a_of_type_JavaUtilList = this.b;
      if ((paramaubh.jdField_a_of_type_JavaUtilList == null) || (paramaubh.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label241;
      }
    }
    label241:
    for (paramaubh.jdField_b_of_type_Int = paramInt;; paramaubh.jdField_b_of_type_Int = -1)
    {
      paramaubh.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilList.add(0, paramaubh);
      a(this.jdField_a_of_type_Auco.a());
      super.notifyDataSetChanged();
      return this.jdField_a_of_type_JavaUtilList;
    }
  }
  
  public void a(int paramInt)
  {
    audf localaudf = (audf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((aude)this.jdField_a_of_type_JavaUtilMap.get(localaudf.jdField_a_of_type_JavaLangString)).a();
  }
  
  void a(Context paramContext)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      audf localaudf = (audf)this.jdField_a_of_type_JavaUtilList.get(i);
      aude localaude;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localaudf.jdField_a_of_type_JavaLangString)) {
        localaude = (aude)this.jdField_a_of_type_JavaUtilMap.get(localaudf.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        localaude.a(localaudf.jdField_a_of_type_Boolean);
        localaude.a(paramContext, localaudf);
        i += 1;
        break;
        localaude = new aude(this.jdField_a_of_type_Auco, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
        this.jdField_a_of_type_JavaUtilMap.put(localaudf.jdField_a_of_type_JavaLangString, localaude);
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
    Object localObject = (audf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localObject = ((aude)this.jdField_a_of_type_JavaUtilMap.get(((audf)localObject).jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_Auco.a(), (audf)localObject);
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