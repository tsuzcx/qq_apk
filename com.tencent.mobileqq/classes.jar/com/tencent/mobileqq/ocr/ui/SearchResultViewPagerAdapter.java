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
  public List<TabItem> a = new ArrayList();
  public BaseOCRTextSearchFragment.SearchActivityInterface b;
  SearchResultFragment c;
  Map<String, SearchResultPageView> d = new HashMap();
  ViewPager e;
  List<OCRTextSearchInfo.Group> f;
  
  public SearchResultViewPagerAdapter(BaseOCRTextSearchFragment.SearchActivityInterface paramSearchActivityInterface, SearchResultFragment paramSearchResultFragment, ViewPager paramViewPager)
  {
    this.b = paramSearchActivityInterface;
    this.c = paramSearchResultFragment;
    this.e = paramViewPager;
  }
  
  public List<TabItem> a(String paramString, int paramInt, OCRTextSearchInfo.SearchResult paramSearchResult)
  {
    if (paramSearchResult != null) {
      this.f = paramSearchResult.a;
    } else {
      this.f = null;
    }
    this.a.clear();
    if ((paramSearchResult != null) && (paramSearchResult.b != null)) {
      this.a = paramSearchResult.b;
    }
    if ((paramInt == 0) && (paramSearchResult != null) && (paramSearchResult.b != null) && (paramSearchResult.b.size() > 0))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        TabItem localTabItem = (TabItem)localIterator.next();
        if (localTabItem.a == 0)
        {
          localTabItem.c = paramSearchResult.a;
          localTabItem.f = paramSearchResult.c;
        }
      }
    }
    if (this.a.size() == 0)
    {
      paramSearchResult = new TabItem();
      paramSearchResult.b = HardCodeUtil.a(2131911115);
      paramSearchResult.a = 0;
      paramSearchResult.c = this.f;
      if ((paramSearchResult.c != null) && (paramSearchResult.c.size() > 0)) {
        paramSearchResult.d = paramInt;
      } else {
        paramSearchResult.d = -1;
      }
      paramSearchResult.e = paramString;
      this.a.add(0, paramSearchResult);
    }
    a(this.b.a());
    super.notifyDataSetChanged();
    return this.a;
  }
  
  public void a(int paramInt)
  {
    TabItem localTabItem = (TabItem)this.a.get(paramInt);
    ((SearchResultPageView)this.d.get(localTabItem.b)).a();
  }
  
  void a(Context paramContext)
  {
    int i = 0;
    while (i < this.a.size())
    {
      TabItem localTabItem = (TabItem)this.a.get(i);
      SearchResultPageView localSearchResultPageView;
      if (this.d.containsKey(localTabItem.b))
      {
        localSearchResultPageView = (SearchResultPageView)this.d.get(localTabItem.b);
      }
      else
      {
        localSearchResultPageView = new SearchResultPageView(this.b, this.c);
        this.d.put(localTabItem.b, localSearchResultPageView);
      }
      localSearchResultPageView.a(localTabItem.f);
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
    List localList = this.a;
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
    Object localObject = (TabItem)this.a.get(paramInt);
    localObject = ((SearchResultPageView)this.d.get(((TabItem)localObject).b)).a(this.b.a(), (TabItem)localObject);
    paramViewGroup.removeView((View)localObject);
    paramViewGroup.addView((View)localObject);
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchResultViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */