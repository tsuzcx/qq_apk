package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineStatusBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OnlineStatusPagerAdapter
  extends PagerAdapter
  implements View.OnClickListener, ViewPager.OnPageChangeListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private OnlineStatusPagerAdapter.OnStatusItemClickListener jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener;
  private OnlineStatusPanelParams jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams;
  private OnlineStatusRecycleBin jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusRecycleBin = new OnlineStatusRecycleBin();
  public ArrayList<OnlineStatusItem> a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private ArrayList<OnlineStatusItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  
  OnlineStatusPagerAdapter(Context paramContext, OnlineStatusPanelParams paramOnlineStatusPanelParams, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = (paramOnlineStatusPanelParams.jdField_b_of_type_Int * paramOnlineStatusPanelParams.c);
    this.jdField_a_of_type_Boolean = paramOnlineStatusPanelParams.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams = paramOnlineStatusPanelParams;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = paramViewPager;
  }
  
  private List<OnlineStatusItem> a(int paramInt)
  {
    paramInt *= this.jdField_a_of_type_Int;
    int i = Math.min(this.jdField_b_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_Int + paramInt);
    return this.jdField_b_of_type_JavaUtilArrayList.subList(paramInt, i);
  }
  
  public int a()
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    int k = 0;
    if (bool) {
      return 0;
    }
    int j = k;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_b_of_type_JavaUtilArrayList.size()) {
          break;
        }
        if (((OnlineStatusItem)this.jdField_b_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long == localOnlineStatusItem.jdField_a_of_type_Long)
        {
          j = i;
          break;
        }
        i += 1;
      }
    }
    return j / this.jdField_a_of_type_Int;
  }
  
  public ArrayList<OnlineStatusItem> a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager == null) {
      return;
    }
    int j = getCount();
    int k = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getChildCount();
    int i = 0;
    while (i < k)
    {
      OnlineStatusListLayout localOnlineStatusListLayout = (OnlineStatusListLayout)this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getChildAt(i);
      if (localOnlineStatusListLayout != null)
      {
        int m = localOnlineStatusListLayout.a();
        if ((m >= 0) && (m < j)) {
          localOnlineStatusListLayout.a(a(m), this.jdField_a_of_type_JavaUtilArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem)
  {
    OnlineStatusBean localOnlineStatusBean = (OnlineStatusBean)QConfigManager.a().a(578);
    boolean bool = localOnlineStatusBean.a(paramOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusItem.jdField_a_of_type_Long);
    int k = 0;
    int i = 0;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_b_of_type_JavaUtilArrayList.size()) {
        break label109;
      }
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      if ((localOnlineStatusItem.jdField_a_of_type_Long == paramOnlineStatusItem.jdField_a_of_type_Long) || ((bool) && (localOnlineStatusBean.a(localOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status, localOnlineStatusItem.jdField_a_of_type_Long)))) {
        break;
      }
      i += 1;
    }
    int j = i;
    label109:
    i = j / this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(i);
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem, View paramView)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    Object localObject = null;
    if (!bool)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        localObject = (OnlineStatusItem)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramOnlineStatusItem);
      OnlineStatusPagerAdapter.OnStatusItemClickListener localOnStatusItemClickListener = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener;
      if (localOnStatusItemClickListener != null) {
        localOnStatusItemClickListener.a((OnlineStatusItem)localObject, paramOnlineStatusItem, paramView);
      }
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramOnlineStatusItem))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramOnlineStatusItem);
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener;
      if (localObject != null) {
        ((OnlineStatusPagerAdapter.OnStatusItemClickListener)localObject).a(paramOnlineStatusItem, null, paramView);
      }
    }
    else
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramOnlineStatusItem);
      localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener;
      if (localObject != null) {
        ((OnlineStatusPagerAdapter.OnStatusItemClickListener)localObject).a(null, paramOnlineStatusItem, paramView);
      }
    }
  }
  
  void a(OnlineStatusPagerAdapter.OnStatusItemClickListener paramOnStatusItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener = paramOnStatusItemClickListener;
  }
  
  public void a(ArrayList<OnlineStatusItem> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof OnlineStatusListLayout))
    {
      OnlineStatusListLayout localOnlineStatusListLayout = (OnlineStatusListLayout)paramObject;
      localOnlineStatusListLayout.setPageIndex(-1);
      paramViewGroup.removeView(localOnlineStatusListLayout);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusRecycleBin.a(paramInt, (View)paramObject);
    }
  }
  
  public int getCount()
  {
    int i = this.jdField_b_of_type_JavaUtilArrayList.size();
    int k = this.jdField_a_of_type_Int;
    int j = i / k;
    if (i % k > 0) {
      i = 1;
    } else {
      i = 0;
    }
    return j + i;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    List localList = a(paramInt);
    OnlineStatusListLayout localOnlineStatusListLayout2 = (OnlineStatusListLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusRecycleBin.a(paramInt);
    OnlineStatusListLayout localOnlineStatusListLayout1 = localOnlineStatusListLayout2;
    if (localOnlineStatusListLayout2 == null)
    {
      localOnlineStatusListLayout1 = new OnlineStatusListLayout(this.jdField_a_of_type_AndroidContentContext);
      localOnlineStatusListLayout1.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams);
      localOnlineStatusListLayout1.setItemWidth(this.jdField_b_of_type_Int);
      localOnlineStatusListLayout1.setOnClickListener(this);
      localOnlineStatusListLayout1.a(this.jdField_a_of_type_Int, this);
    }
    localOnlineStatusListLayout1.a(localList, this.jdField_a_of_type_JavaUtilArrayList);
    localOnlineStatusListLayout1.setPageIndex(paramInt);
    if ((localOnlineStatusListLayout1.getParent() != paramViewGroup) && (paramInt < getCount())) {
      paramViewGroup.addView(localOnlineStatusListLayout1);
    }
    return localOnlineStatusListLayout1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((paramView instanceof OnlineStatusListLayout))
    {
      if (((OnlineStatusListLayout)paramView).a())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener;
        if (localObject != null) {
          ((OnlineStatusPagerAdapter.OnStatusItemClickListener)localObject).c(paramView);
        }
      }
    }
    else if ((localObject instanceof OnlineStatusItem))
    {
      a((OnlineStatusItem)localObject, paramView);
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = a(paramInt).iterator();
    while (localIterator.hasNext()) {
      ReportHelperKt.a("0X800BB58", (int)((OnlineStatusItem)localIterator.next()).jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter
 * JD-Core Version:    0.7.0.1
 */