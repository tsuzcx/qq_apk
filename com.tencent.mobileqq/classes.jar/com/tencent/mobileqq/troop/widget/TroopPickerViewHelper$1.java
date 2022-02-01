package com.tencent.mobileqq.troop.widget;

import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;

class TroopPickerViewHelper$1
  implements WheelPickerLayout.WheelPickListener
{
  TroopPickerViewHelper$1(TroopPickerViewHelper paramTroopPickerViewHelper) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (TroopPickerViewHelper.a(this.a) != null)
    {
      if (paramInt1 == 0)
      {
        if (TroopPickerViewHelper.b(this.a) != null)
        {
          paramInt1 = TroopPickerViewHelper.c(this.a).a(TroopPickerViewHelper.b(this.a), paramInt2);
          paramInt2 = TroopPickerViewHelper.c(this.a).a(TroopPickerViewHelper.b(this.a), paramInt2, paramInt1);
        }
        else
        {
          paramInt1 = 0;
          paramInt2 = 0;
        }
        TroopPickerViewHelper.a(this.a).setSelection(1, paramInt1);
        TroopPickerViewHelper.a(this.a).a(1);
        TroopPickerViewHelper.a(this.a).setSelection(2, paramInt2);
        TroopPickerViewHelper.a(this.a).a(2);
      }
      else if (paramInt1 == 1)
      {
        if (TroopPickerViewHelper.b(this.a) != null) {
          paramInt1 = TroopPickerViewHelper.c(this.a).a(TroopPickerViewHelper.b(this.a), TroopPickerViewHelper.a(this.a).b(0), paramInt2);
        } else {
          paramInt1 = 0;
        }
        TroopPickerViewHelper.a(this.a).setSelection(2, paramInt1);
        TroopPickerViewHelper.a(this.a).a(2);
      }
      TroopPickerViewHelper localTroopPickerViewHelper = this.a;
      TroopPickerViewHelper.a(localTroopPickerViewHelper, TroopPickerViewHelper.c(localTroopPickerViewHelper).a(new int[] { TroopPickerViewHelper.a(this.a).b(0), TroopPickerViewHelper.a(this.a).b(1), TroopPickerViewHelper.a(this.a).b(2) }));
      if (QLog.isColorLevel()) {
        QLog.i("TroopPickerViewHelper", 2, Arrays.toString(TroopPickerViewHelper.c(this.a).a(TroopPickerViewHelper.b(this.a).getTimeInMillis())));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopPickerViewHelper.1
 * JD-Core Version:    0.7.0.1
 */