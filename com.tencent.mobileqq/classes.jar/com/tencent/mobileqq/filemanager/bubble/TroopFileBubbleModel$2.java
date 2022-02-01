package com.tencent.mobileqq.filemanager.bubble;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.UUID;

class TroopFileBubbleModel$2
  implements DialogInterface.OnClickListener
{
  TroopFileBubbleModel$2(TroopFileBubbleModel paramTroopFileBubbleModel, long paramLong, UUID paramUUID, ChatMessage paramChatMessage, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      new TroopFileItemOperation(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleTroopFileBubbleModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity).a(this.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    paramDialogInterface = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleTroopFileBubbleModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    paramDialogInterface.b(paramDialogInterface.a(this.jdField_a_of_type_JavaUtilUUID));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleTroopFileBubbleModel.c(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleTroopFileBubbleModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleTroopFileBubbleModel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleTroopFileBubbleModel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.TroopFileBubbleModel.2
 * JD-Core Version:    0.7.0.1
 */