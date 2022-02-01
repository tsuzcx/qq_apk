package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.Group;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SearchResult;
import com.tencent.mobileqq.ocr.TabItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchResultViewPagerAdapter
  extends PagerAdapter
{
  ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  public BaseOCRTextSearchFragment.SearchActivityInterface a;
  SearchResultFragment jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment;
  public List<TabItem> a;
  Map<String, SearchResultPageView> jdField_a_of_type_JavaUtilMap = new HashMap();
  List<OCRTextSearchInfo.Group> b;
  
  public SearchResultViewPagerAdapter(BaseOCRTextSearchFragment.SearchActivityInterface paramSearchActivityInterface, SearchResultFragment paramSearchResultFragment, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface = paramSearchActivityInterface;
    this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment = paramSearchResultFragment;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = paramViewPager;
  }
  
  public List<TabItem> a(String paramString, int paramInt, OCRTextSearchInfo.SearchResult paramSearchResult)
  {
    if (paramSearchResult != null) {
      this.b = paramSearchResult.jdField_a_of_type_JavaUtilList;
    } else {
      this.b = null;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramSearchResult != null) && (paramSearchResult.b != null)) {
      this.jdField_a_of_type_JavaUtilList = paramSearchResult.b;
    }
    if ((paramInt == 0) && (paramSearchResult != null) && (paramSearchResult.b != null) && (paramSearchResult.b.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        TabItem localTabItem = (TabItem)localIterator.next();
        if (localTabItem.jdField_a_of_type_Int == 0)
        {
          localTabItem.jdField_a_of_type_JavaUtilList = paramSearchResult.jdField_a_of_type_JavaUtilList;
          localTabItem.jdField_a_of_type_Boolean = paramSearchResult.jdField_a_of_type_Boolean;
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      paramSearchResult = new TabItem();
      paramSearchResult.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713569);
      paramSearchResult.jdField_a_of_type_Int = 0;
      paramSearchResult.jdField_a_of_type_JavaUtilList = this.b;
      if ((paramSearchResult.jdField_a_of_type_JavaUtilList != null) && (paramSearchResult.jdField_a_of_type_JavaUtilList.size() > 0)) {
        paramSearchResult.jdField_b_of_type_Int = paramInt;
      } else {
        paramSearchResult.jdField_b_of_type_Int = -1;
      }
      paramSearchResult.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilList.add(0, paramSearchResult);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface.a());
    super.notifyDataSetChanged();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    TabItem localTabItem = (TabItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((SearchResultPageView)this.jdField_a_of_type_JavaUtilMap.get(localTabItem.jdField_a_of_type_JavaLangString)).a();
  }
  
  void a(Context paramContext)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      TabItem localTabItem = (TabItem)this.jdField_a_of_type_JavaUtilList.get(i);
      SearchResultPageView localSearchResultPageView;
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localTabItem.jdField_a_of_type_JavaLangString))
      {
        localSearchResultPageView = (SearchResultPageView)this.jdField_a_of_type_JavaUtilMap.get(localTabItem.jdField_a_of_type_JavaLangString);
      }
      else
      {
        localSearchResultPageView = new SearchResultPageView(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface, this.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment);
        this.jdField_a_of_type_JavaUtilMap.put(localTabItem.jdField_a_of_type_JavaLangString, localSearchResultPageView);
      }
      localSearchResultPageView.a(localTabItem.jdField_a_of_type_Boolean);
      localSearchResultPageView.a(paramContext, localTabItem);
      i += 1;
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = (TabItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localObject = ((SearchResultPageView)this.jdField_a_of_type_JavaUtilMap.get(((TabItem)localObject).jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface.a(), (TabItem)localObject);
    paramViewGroup.removeView((View)localObject);
    paramViewGroup.addView((View)localObject);
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */