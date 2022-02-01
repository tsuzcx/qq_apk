package com.tencent.mobileqq.troop.data;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.Map;

class TroopFileItemOperation$8
  implements DialogInterface.OnClickListener
{
  TroopFileItemOperation$8(TroopFileItemOperation paramTroopFileItemOperation, TroopFileInfo paramTroopFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.jdField_a_of_type_Long).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
      paramDialogInterface = (TroopFileInfo)TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.jdField_a_of_type_Long).c.get(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.g);
      if (paramDialogInterface != null) {
        paramDialogInterface.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.b);
      }
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.jdField_a_of_type_Long);
      localStringBuilder.append("");
      ReportController.b(paramDialogInterface, "CliOper", "", "", "Grp", "Cancel_pause_download", 0, 0, "", localStringBuilder.toString(), "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.8
 * JD-Core Version:    0.7.0.1
 */