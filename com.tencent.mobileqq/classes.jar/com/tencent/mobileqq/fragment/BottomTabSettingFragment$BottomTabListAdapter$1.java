package com.tencent.mobileqq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BottomTabSettingFragment$BottomTabListAdapter$1
  implements View.OnClickListener
{
  BottomTabSettingFragment$BottomTabListAdapter$1(BottomTabSettingFragment.BottomTabListAdapter paramBottomTabListAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (BottomTabSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentBottomTabSettingFragment$BottomTabListAdapter.a) != ((Integer)paramView.getTag()).intValue()) {
      BottomTabSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentBottomTabSettingFragment$BottomTabListAdapter.a, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.BottomTabSettingFragment.BottomTabListAdapter.1
 * JD-Core Version:    0.7.0.1
 */