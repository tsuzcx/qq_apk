package com.tencent.mobileqq.troop.data;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileManager;

class TroopFileItemOperation$7
  implements DialogInterface.OnClickListener
{
  TroopFileItemOperation$7(TroopFileItemOperation paramTroopFileItemOperation, TroopFileInfo paramTroopFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (TroopFileItemOperation.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation) != 0) {
        TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.jdField_a_of_type_Long).b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo);
      }
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.jdField_a_of_type_Long);
      localStringBuilder.append("");
      ReportController.b(paramDialogInterface, "CliOper", "", "", "Grp", "Cancel_pause_upload", 0, 0, "", localStringBuilder.toString(), "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.7
 * JD-Core Version:    0.7.0.1
 */