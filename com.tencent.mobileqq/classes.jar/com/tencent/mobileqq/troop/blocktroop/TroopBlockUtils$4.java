package com.tencent.mobileqq.troop.blocktroop;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

final class TroopBlockUtils$4
  implements DialogInterface.OnClickListener
{
  TroopBlockUtils$4(TroopBlockUtils.ConstantBlockDialogCallback paramConstantBlockDialogCallback, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqTroopBlocktroopTroopBlockUtils$ConstantBlockDialogCallback;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B224", "0X800B224", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B226", "0X800B226", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils.4
 * JD-Core Version:    0.7.0.1
 */