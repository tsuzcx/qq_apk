package com.tencent.mobileqq.nearby.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
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
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter;
    paramViewGroup.a(paramViewGroup.a(paramInt), paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (AvatarWallPagerAdapter.ViewHolder)((View)paramObject).getTag(2131378272);
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
      if (paramInt == 1)
      {
        if (paramViewGroup == null)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference.get() != null) && (((View)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference.get()).getParent() == null)) {
            return this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference.get();
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference.get() != null) && (((View)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference.get()).getParent() == null))
          {
            localObject = (View)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference.get();
          }
          else
          {
            localObject = (View)instantiateItem(null, paramInt);
            this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(localObject);
          }
          paramViewGroup.addView((View)localObject);
          return localObject;
        }
      }
      else if (paramInt == i - 2) {
        if (paramViewGroup == null)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b.get() != null) && (((View)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b.get()).getParent() == null)) {
            return this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b;
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b.get() != null) && (((View)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b.get()).getParent() == null))
          {
            localObject = (View)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b.get();
          }
          else
          {
            localObject = (View)instantiateItem(null, paramInt);
            this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b = new SoftReference(localObject);
          }
          paramViewGroup.addView((View)localObject);
          return localObject;
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter;
    localObject = ((AvatarWallPagerAdapter)localObject).a(((AvatarWallPagerAdapter)localObject).a(paramInt), this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaUtilList.get(paramInt));
    AvatarWallPagerAdapter localAvatarWallPagerAdapter = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter;
    ((View)localObject).setTag(2131378272, new AvatarWallPagerAdapter.ViewHolder(localAvatarWallPagerAdapter, localAvatarWallPagerAdapter.jdField_a_of_type_JavaUtilList.get(paramInt)));
    if (paramViewGroup != null)
    {
      paramViewGroup.addView((View)localObject);
      return localObject;
    }
    if (i > 1)
    {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(localObject);
        return localObject;
      }
      if (paramInt == i - 2) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.b = new SoftReference(localObject);
      }
    }
    return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter.InnerPagerAdapter
 * JD-Core Version:    0.7.0.1
 */