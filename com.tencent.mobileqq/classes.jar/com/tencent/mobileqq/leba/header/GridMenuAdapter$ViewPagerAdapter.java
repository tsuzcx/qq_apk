package com.tencent.mobileqq.leba.header;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class GridMenuAdapter$ViewPagerAdapter
  extends PagerAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public GridMenuAdapter$ViewPagerAdapter(GridMenuAdapter paramGridMenuAdapter, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
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
    paramViewGroup.addView((View)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.header.GridMenuAdapter.ViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */