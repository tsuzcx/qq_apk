package com.tencent.mobileqq.hotpic;

import adgp;
import adgr;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class HotPicPanelViewPagerAdapter
  extends PagerAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  HotPicIndexAndIDMap jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap;
  HotPicMainPanel jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
  protected HotPicPageView.OnHotPicItemClickListener a;
  
  public HotPicPanelViewPagerAdapter(HotPicMainPanel paramHotPicMainPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = paramHotPicMainPanel;
    this.jdField_a_of_type_AndroidContentContext = paramHotPicMainPanel.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap = paramHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = null;
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a()) {}
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.b(paramInt);
      localObject = (HotPicPageView)this.jdField_a_of_type_AndroidUtilSparseArray.get(((HotPicTagInfo)localObject).tagId);
    } while (localObject == null);
    ((HotPicPageView)localObject).a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject2 = HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    HotPicPageView localHotPicPageView = (HotPicPageView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if ((localHotPicPageView != null) && (localHotPicPageView.c)) {
      localHotPicPageView.jdField_a_of_type_Adgr.a(false);
    }
    switch (paramInt2)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 7: 
      localHotPicPageView.k();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.h();
      return;
    case 3: 
      try
      {
        localHotPicPageView.jdField_a_of_type_AndroidSupportV7WidgetStaggeredGridLayoutManager.mClearSpanOnItemsChanged = false;
        paramInt2 = localHotPicPageView.jdField_a_of_type_Adgp.a.size();
        localObject2 = ((HotPicManager)localObject2).a(paramInt1);
        localHotPicPageView.jdField_a_of_type_Adgp.a((List)localObject2);
        int i = ((List)localObject2).size();
        paramInt1 = paramInt2;
        while (paramInt1 < i - paramInt2)
        {
          localHotPicPageView.jdField_a_of_type_Adgp.notifyItemInserted(paramInt1);
          paramInt1 += 1;
        }
        localHotPicPageView.jdField_a_of_type_Adgp.notifyItemRangeChanged(paramInt2, ((List)localObject2).size());
        localHotPicPageView.m();
        return;
      }
      finally {}
    case 6: 
      if (((HotPicManager)localObject2).c(paramInt1)) {}
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        localObject1.jdField_a_of_type_Adgr.a(paramInt1);
        localObject1.jdField_a_of_type_Adgr.a(false);
        localObject1.jdField_a_of_type_Adgp.notifyItemChanged(localObject1.jdField_a_of_type_Adgp.getItemCount());
        return;
      }
    }
    localObject1.k();
  }
  
  public void a(HotPicPageView.OnHotPicItemClickListener paramOnHotPicItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener = paramOnHotPicItemClickListener;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a() <= paramInt) {}
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.b(paramInt).tagId;
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        HotPicPageView localHotPicPageView = (HotPicPageView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(1);
        if (localHotPicPageView.jdField_a_of_type_Int != i) {
          localHotPicPageView.b();
        }
        paramInt += 1;
      }
    }
  }
  
  public void c(int paramInt)
  {
    int i = 0;
    HotPicPageView localHotPicPageView;
    if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localHotPicPageView = (HotPicPageView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher != null) {}
    }
    else
    {
      return;
    }
    if (localHotPicPageView.b == paramInt)
    {
      localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.b(true);
      localHotPicPageView.o();
    }
    for (;;)
    {
      i += 1;
      break;
      localHotPicPageView.jdField_a_of_type_ComTencentMobileqqHotpicHotpicDownloadDispatcher.b(false);
      localHotPicPageView.j();
    }
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.size() > paramInt) && (paramInt >= 0))
    {
      HotPicPageView localHotPicPageView = (HotPicPageView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt);
      if (localHotPicPageView != null) {
        localHotPicPageView.d();
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    HotPicPageView localHotPicPageView = (HotPicPageView)paramObject;
    localHotPicPageView.l();
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(localHotPicPageView.jdField_a_of_type_Int);
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    HotPicTagInfo localHotPicTagInfo = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.b(paramInt);
    HotPicPageView localHotPicPageView = (HotPicPageView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968647, null);
    localHotPicPageView.setOnHotPicItemClickListener(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener);
    if (localHotPicTagInfo != null)
    {
      localHotPicPageView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel, localHotPicTagInfo);
      if (((ViewPager)paramViewGroup).getCurrentItem() == paramInt) {
        localHotPicPageView.a();
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(localHotPicTagInfo.tagId, localHotPicPageView);
      paramViewGroup.addView(localHotPicPageView);
    }
    return localHotPicPageView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPanelViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */