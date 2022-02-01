package com.tencent.mobileqq.troop.homework.entry.ui.utils;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;

class HwkTimePicker$1
  implements IphonePickerView.IphonePickListener
{
  HwkTimePicker$1(HwkTimePicker paramHwkTimePicker) {}
  
  public void onConfirmBtClicked()
  {
    if (HwkTimePicker.a(this.a) != null) {
      HwkTimePicker.a(this.a).a(HwkTimePicker.b(this.a), HwkTimePicker.c(this.a), HwkTimePicker.a(this.a));
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          HwkTimePicker.c(this.a, paramInt2);
        }
      }
      else {
        HwkTimePicker.b(this.a, paramInt2);
      }
    }
    else {
      HwkTimePicker.a(this.a, paramInt2);
    }
    if (HwkTimePicker.a(this.a) != null) {
      HwkTimePicker.a(this.a).a(paramInt1, paramInt2);
    }
    if ((HwkTimePicker.a(this.a) != null) && ((paramInt1 == 0) || (paramInt1 == 1)))
    {
      HwkTimePicker.a(this.a).a(2);
      if (HwkTimePicker.a(this.a) >= HwkTimePicker.a(this.a).getRowCount(2))
      {
        HwkTimePicker localHwkTimePicker = this.a;
        HwkTimePicker.c(localHwkTimePicker, HwkTimePicker.a(localHwkTimePicker).getRowCount(2) - 1);
      }
    }
    if (HwkTimePicker.b(this.a) != null) {
      HwkTimePicker.b(this.a).a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimePicker.1
 * JD-Core Version:    0.7.0.1
 */