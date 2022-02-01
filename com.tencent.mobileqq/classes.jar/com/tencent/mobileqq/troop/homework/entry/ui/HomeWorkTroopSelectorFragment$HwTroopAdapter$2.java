package com.tencent.mobileqq.troop.homework.entry.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HomeWorkTroopSelectorFragment$HwTroopAdapter$2
  implements View.OnClickListener
{
  HomeWorkTroopSelectorFragment$HwTroopAdapter$2(HomeWorkTroopSelectorFragment.HwTroopAdapter paramHwTroopAdapter, CheckBox paramCheckBox) {}
  
  public void onClick(View paramView)
  {
    CheckBox localCheckBox = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment.HwTroopAdapter.2
 * JD-Core Version:    0.7.0.1
 */