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
    if ((TroopPickerViewHelper.d(this.b) != null) && (TroopPickerViewHelper.d(this.b).isShowing())) {
      TroopPickerViewHelper.d(this.b).dismiss();
    }
    if ((this.a != null) && (TroopPickerViewHelper.b(this.b) != null)) {
      this.a.a(TroopPickerViewHelper.b(this.b).getTimeInMillis());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopPickerViewHelper.2
 * JD-Core Version:    0.7.0.1
 */