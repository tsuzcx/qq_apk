package com.tencent.mobileqq.troop.data;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

class TroopFileItemOperation$11
  implements DialogInterface.OnClickListener
{
  TroopFileItemOperation$11(TroopFileItemOperation paramTroopFileItemOperation, TroopFileInfo paramTroopFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (TroopFileItemOperation.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation) != 0) {
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.jdField_a_of_type_Long).c(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.11
 * JD-Core Version:    0.7.0.1
 */