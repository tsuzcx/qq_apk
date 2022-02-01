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
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.a.a).troopuin.equals(HomeWorkTroopSelectorFragment.HwTroopAdapter.a(this.b)))) {
      this.a.b = Boolean.valueOf(paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment.HwTroopAdapter.1
 * JD-Core Version:    0.7.0.1
 */