package com.tencent.mobileqq.nearby.widget;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public abstract class AvatarWallPagerAdapter<T>
{
  protected AvatarWallPagerAdapter<T>.InnerPagerAdapter a;
  protected AvatarWallViewPager a;
  protected SoftReference<View> a;
  protected final List<T> a;
  protected boolean a;
  protected SoftReference<View> b;
  
  public AvatarWallPagerAdapter(AvatarWallViewPager paramAvatarWallViewPager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager = paramAvatarWallViewPager;
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter$InnerPagerAdapter = new AvatarWallPagerAdapter.InnerPagerAdapter(this);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  protected int a(int paramInt)
  {
    int i = a();
    if (i <= 1) {}
    do
    {
      return 0;
      if (paramInt == 0) {
        return i - 3;
      }
    } while (paramInt == i - 1);
    return paramInt - 1;
  }
  
  protected PagerAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter$InnerPagerAdapter;
  }
  
  public abstract View a(int paramInt, T paramT);
  
  public abstract View a(boolean paramBoolean, int paramInt);
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager = null;
    this.b = null;
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
  }
  
  public void a(int paramInt, View paramView) {}
  
  public void a(List<T> paramList)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.b = null;
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() > 1) || ((this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.d)))
    {
      int i = paramList.size();
      this.jdField_a_of_type_JavaUtilList.add(paramList.get(0));
      this.jdField_a_of_type_JavaUtilList.add(0, paramList.get(i - 1));
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.d();
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter$InnerPagerAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.a().setCurrentItem(1);
  }
  
  public boolean a(T paramT1, T paramT2)
  {
    if ((paramT1 == null) || (paramT2 == null)) {
      return false;
    }
    return paramT1.equals(paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter
 * JD-Core Version:    0.7.0.1
 */