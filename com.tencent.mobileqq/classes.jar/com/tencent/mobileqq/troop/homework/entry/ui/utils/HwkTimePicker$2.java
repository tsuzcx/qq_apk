package com.tencent.mobileqq.troop.homework.entry.ui.utils;

import com.tencent.widget.ActionSheet.WatchDismissActions;

class HwkTimePicker$2
  implements ActionSheet.WatchDismissActions
{
  HwkTimePicker$2(HwkTimePicker paramHwkTimePicker) {}
  
  public void onDismissOperations()
  {
    if (HwkTimePicker.i(this.a) != null) {
      HwkTimePicker.i(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimePicker.2
 * JD-Core Version:    0.7.0.1
 */