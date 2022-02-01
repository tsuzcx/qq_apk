package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import anzj;
import ayzd;
import ayzf;
import azam;
import azbc;
import azbd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchResultViewPagerAdapter
  extends PagerAdapter
{
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public azam a;
  SearchResultFragment jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment;
  public List<azbd> a;
  Map<String, azbc> jdField_a_of_type_JavaUtilMap = new HashMap();
  List<ayzd> b;
  
  public SearchResultViewPagerAdapter(azam paramazam, SearchResultFragment paramSearchResultFragment, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Azam = paramazam;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = paramSearchResultFragment;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  public List<azbd> a(String paramString, int paramInt, ayzf paramayzf)
  {
    if (paramayzf != null) {}
    for (this.b = paramayzf.jdField_a_of_type_JavaUtilList;; this.b = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((paramayzf != null) && (paramayzf.b != null)) {
        this.jdField_a_of_type_JavaUtilList = paramayzf.b;
      }
      if ((paramInt != 0) || (paramayzf == null) || (paramayzf.b == null) || (paramayzf.b.size() <= 0)) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        azbd localazbd = (azbd)localIterator.next();
        if (localazbd.jdField_a_of_type_Int == 0)
        {
          localazbd.jdField_a_of_type_JavaUtilList = paramayzf.jdField_a_of_type_JavaUtilList;
          localazbd.jdField_a_of_type_Boolean = paramayzf.jdField_a_of_type_Boolean;
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      paramayzf = new azbd();
      paramayzf.jdField_a_of_type_JavaLangString = anzj.a(2131712527);
      paramayzf.jdField_a_of_type_Int = 0;
      paramayzf.jdField_a_of_type_JavaUtilList = this.b;
      if ((paramayzf.jdField_a_of_type_JavaUtilList == null) || (paramayzf.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label241;
      }
    }
    label241:
    for (paramayzf.jdField_b_of_type_Int = paramInt;; paramayzf.jdField_b_of_type_Int = -1)
    {
      paramayzf.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilList.add(0, paramayzf);
      a(this.jdField_a_of_type_Azam.a());
      super.notifyDataSetChanged();
      return this.jdField_a_of_type_JavaUtilList;
    }
  }
  
  public void a(int paramInt)
  {
    azbd localazbd = (azbd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((azbc)this.jdField_a_of_type_JavaUtilMap.get(localazbd.jdField_a_of_type_JavaLangString)).a();
  }
  
  void a(Context paramContext)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      azbd localazbd = (azbd)this.jdField_a_of_type_JavaUtilList.get(i);
      azbc localazbc;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localazbd.jdField_a_of_type_JavaLangString)) {
        localazbc = (azbc)this.jdField_a_of_type_JavaUtilMap.get(localazbd.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        localazbc.a(localazbd.jdField_a_of_type_Boolean);
        localazbc.a(paramContext, localazbd);
        i += 1;
        break;
        localazbc = new azbc(this.jdField_a_of_type_Azam, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
        this.jdField_a_of_type_JavaUtilMap.put(localazbd.jdField_a_of_type_JavaLangString, localazbc);
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
    Object localObject = (azbd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localObject = ((azbc)this.jdField_a_of_type_JavaUtilMap.get(((azbd)localObject).jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_Azam.a(), (azbd)localObject);
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