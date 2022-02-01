package com.tencent.mobileqq.filemanager.bubble;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class TroopFileBubbleModel$1
  implements DialogInterface.OnClickListener
{
  TroopFileBubbleModel$1(TroopFileBubbleModel paramTroopFileBubbleModel, long paramLong, UUID paramUUID, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      new TroopFileItemOperation(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleTroopFileBubbleModel.a, this.jdField_a_of_type_AndroidAppActivity).b(this.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleTroopFileBubbleModel.a, this.jdField_a_of_type_Long).a(this.jdField_a_of_type_JavaUtilUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.TroopFileBubbleModel.1
 * JD-Core Version:    0.7.0.1
 */