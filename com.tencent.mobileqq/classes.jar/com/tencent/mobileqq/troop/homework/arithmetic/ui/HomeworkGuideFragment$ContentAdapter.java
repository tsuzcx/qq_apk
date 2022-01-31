package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bbzb;
import java.util.ArrayList;
import java.util.List;

public class HomeworkGuideFragment$ContentAdapter
  extends PagerAdapter
{
  protected LayoutInflater a;
  
  public HomeworkGuideFragment$ContentAdapter(HomeworkGuideFragment paramHomeworkGuideFragment, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiHomeworkGuideFragment.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560459, paramViewGroup, false);
    bbzb localbbzb = new bbzb(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiHomeworkGuideFragment);
    localbbzb.a(paramInt, localView);
    localView.setTag(localbbzb);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiHomeworkGuideFragment.jdField_a_of_type_JavaUtilList.add(localbbzb);
    paramViewGroup.addView(localView, 0);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.HomeworkGuideFragment.ContentAdapter
 * JD-Core Version:    0.7.0.1
 */