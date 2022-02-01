package com.tencent.mobileqq.troop.homework.entry.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HomeWorkTroopSelectorFragment$HwTroopAdapter$1
  implements CompoundButton.OnCheckedChangeListener
{
  HomeWorkTroopSelectorFragment$HwTroopAdapter$1(HomeWorkTroopSelectorFragment.HwTroopAdapter paramHwTroopAdapter, HomeWorkTroopSelectorFragment.MyPair paramMyPair) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiHomeWorkTroopSelectorFragment$MyPair.a).troopuin.equals(HomeWorkTroopSelectorFragment.HwTroopAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiHomeWorkTroopSelectorFragment$HwTroopAdapter)))) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiHomeWorkTroopSelectorFragment$MyPair.b = Boolean.valueOf(paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment.HwTroopAdapter.1
 * JD-Core Version:    0.7.0.1
 */