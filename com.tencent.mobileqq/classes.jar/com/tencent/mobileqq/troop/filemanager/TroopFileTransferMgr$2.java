package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

class TroopFileTransferMgr$2
  implements Runnable
{
  TroopFileTransferMgr$2(TroopFileTransferMgr paramTroopFileTransferMgr, TroopFileTransferManager.Item paramItem, UUID paramUUID) {}
  
  public void run()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Status)
    {
    default: 
      return;
    case 11: 
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile != null) {
        new VFSFile(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile).delete();
      }
      break;
    case 9: 
    case 10: 
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile != null) {
        new VFSFile(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile).delete();
      }
      break;
    }
    this.this$0.a(this.jdField_a_of_type_JavaUtilUUID, true);
    TroopFileTransferManager.Item localItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item;
    localItem.StatusUpdateTimeMs = 0L;
    localItem.ErrorCode = 0;
    localItem.LocalFile = null;
    this.this$0.a(localItem, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.2
 * JD-Core Version:    0.7.0.1
 */