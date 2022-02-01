package com.tencent.mobileqq.filemanager.uftwrapper;

import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

class QFileTroopTransferWrapper$TroopUploadWrapper$1
  implements Runnable
{
  QFileTroopTransferWrapper$TroopUploadWrapper$1(QFileTroopTransferWrapper.TroopUploadWrapper paramTroopUploadWrapper) {}
  
  public void run()
  {
    if (!this.this$0.jdField_a_of_type_Boolean)
    {
      TroopFileError.SimpleErrorInfo localSimpleErrorInfo = new TroopFileError.SimpleErrorInfo(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.this$0.jdField_a_of_type_Long, 3, 210);
      TroopFileDataCenter.a(this.this$0.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 3, localSimpleErrorInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper.TroopUploadWrapper.1
 * JD-Core Version:    0.7.0.1
 */