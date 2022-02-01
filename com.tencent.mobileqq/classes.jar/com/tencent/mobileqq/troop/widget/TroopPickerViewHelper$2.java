package com.tencent.mobileqq.troop.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.Calendar;

class TroopPickerViewHelper$2
  implements View.OnClickListener
{
  TroopPickerViewHelper$2(TroopPickerViewHelper paramTroopPickerViewHelper, TroopPickerViewHelper.OnConfirmListener paramOnConfirmListener) {}
  
  public void onClick(View paramView)
  {
    if ((TroopPickerViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper) != null) && (TroopPickerViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper).isShowing())) {
      TroopPickerViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper).dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper$OnConfirmListener != null) && (TroopPickerViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper) != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper$OnConfirmListener.a(TroopPickerViewHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopPickerViewHelper).getTimeInMillis());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopPickerViewHelper.2
 * JD-Core Version:    0.7.0.1
 */