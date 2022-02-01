package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class OnlineStatusPagerAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
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
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
  }
  
  private List<OnlineStatusItem> a(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Int * paramInt;
    int i = Math.min(this.jdField_b_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_Int + paramInt);
    return this.jdField_b_of_type_JavaUtilArrayList.subList(paramInt, i);
  }
  
  public int a()
  {
    int k = 0;
    if (this.jdField_a_of_type_Boolean) {
      return 0;
    }
    int j = k;
    OnlineStatusItem localOnlineStatusItem;
    int i;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      localOnlineStatusItem = (OnlineStatusItem)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        if (((OnlineStatusItem)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a == localOnlineStatusItem.a) {
          j = i;
        }
      }
      else {
        return j / this.jdField_a_of_type_Int;
      }
      i += 1;
    }
  }
  
  public ArrayList<OnlineStatusItem> a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) {
      return;
    }
    int j = getCount();
    int k = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount();
    int i = 0;
    label23:
    OnlineStatusListLayout localOnlineStatusListLayout;
    if (i < k)
    {
      localOnlineStatusListLayout = (OnlineStatusListLayout)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildAt(i);
      if (localOnlineStatusListLayout != null) {
        break label53;
      }
    }
    for (;;)
    {
      i += 1;
      break label23;
      break;
      label53:
      int m = localOnlineStatusListLayout.a();
      if ((m >= 0) && (m < j)) {
        localOnlineStatusListLayout.a(a(m), this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem, View paramView)
  {
    OnlineStatusItem localOnlineStatusItem = null;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        localOnlineStatusItem = (OnlineStatusItem)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramOnlineStatusItem);
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener.a(localOnlineStatusItem, paramOnlineStatusItem, paramView);
      }
    }
    do
    {
      do
      {
        return;
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramOnlineStatusItem)) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramOnlineStatusItem);
      } while (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener == null);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener.a(paramOnlineStatusItem, null, paramView);
      return;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramOnlineStatusItem);
    } while (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener == null);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener.a(null, paramOnlineStatusItem, paramView);
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
    int j = i / this.jdField_a_of_type_Int;
    if (i % this.jdField_a_of_type_Int > 0) {}
    for (i = 1;; i = 0) {
      return i + j;
    }
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
    if ((paramView instanceof OnlineStatusListLayout)) {
      if ((((OnlineStatusListLayout)paramView).a()) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPagerAdapter$OnStatusItemClickListener.a(paramView);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof OnlineStatusItem))
      {
        a((OnlineStatusItem)localObject, paramView);
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter
 * JD-Core Version:    0.7.0.1
 */