package com.tencent.mobileqq.nearby.widget;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import atbp;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class AvatarWallPagerAdapter$InnerPagerAdapter
  extends PagerAdapter
{
  List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  protected AvatarWallPagerAdapter$InnerPagerAdapter(AvatarWallPagerAdapter paramAvatarWallPagerAdapter) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a(paramInt), (View)paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (atbp)((View)paramObject).getTag(2131311032);
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaUtilList.size())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a(paramObject.a, this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaUtilList.get(i))) && (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(i))))
      {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(i));
        return i;
      }
      i += 1;
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    int i = getCount();
    if (i > 1) {
      if (paramInt == 1) {
        if (paramViewGroup == null)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference.get() == null) || (((View)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference.get()).getParent() != null)) {
            break label327;
          }
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference.get();
        }
      }
    }
    View localView;
    label327:
    do
    {
      do
      {
        return paramViewGroup;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference.get() == null) || (((View)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference.get()).getParent() != null))
        {
          localView = (View)instantiateItem(null, paramInt);
          this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(localView);
        }
        for (;;)
        {
          paramViewGroup.addView(localView);
          return localView;
          localView = (View)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference.get();
        }
        if (paramInt == i - 2) {
          if (paramViewGroup == null)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b.get() != null) && (((View)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b.get()).getParent() == null)) {
              return this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b;
            }
          }
          else
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b.get() == null) || (((View)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b.get()).getParent() != null))
            {
              localView = (View)instantiateItem(null, paramInt);
              this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b = new SoftReference(localView);
            }
            for (;;)
            {
              paramViewGroup.addView(localView);
              return localView;
              localView = (View)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b.get();
            }
          }
        }
        localView = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a(paramInt), this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaUtilList.get(paramInt));
        localView.setTag(2131311032, new atbp(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter, this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaUtilList.get(paramInt)));
        if (paramViewGroup != null)
        {
          paramViewGroup.addView(localView);
          return localView;
        }
        paramViewGroup = localView;
      } while (i <= 1);
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(localView);
        return localView;
      }
      paramViewGroup = localView;
    } while (paramInt != i - 2);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b = new SoftReference(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter.InnerPagerAdapter
 * JD-Core Version:    0.7.0.1
 */