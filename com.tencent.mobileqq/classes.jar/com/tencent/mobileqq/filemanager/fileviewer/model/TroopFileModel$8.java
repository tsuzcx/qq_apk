package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;

class TroopFileModel$8
  implements Runnable
{
  TroopFileModel$8(TroopFileModel paramTroopFileModel, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, FileManagerEntity paramFileManagerEntity1, TroopFileStatusInfo paramTroopFileStatusInfo, FileManagerEntity paramFileManagerEntity2, Rect paramRect) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForTroopFile))) {
      QFileUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForTroopFile)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo, this.b.selfUin, this.b.lastTime, 3, 3, this.jdField_a_of_type_AndroidGraphicsRect, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.8
 * JD-Core Version:    0.7.0.1
 */