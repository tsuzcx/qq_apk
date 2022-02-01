package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PresetWordsListAdapter$ViewHolder
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  
  public PresetWordsListAdapter$ViewHolder(PresetWordsListAdapter paramPresetWordsListAdapter) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.a.a(paramView, this.jdField_a_of_type_Int, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PresetWordsListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */