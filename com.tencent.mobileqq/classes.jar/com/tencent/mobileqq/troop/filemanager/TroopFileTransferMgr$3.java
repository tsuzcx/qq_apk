package com.tencent.mobileqq.troop.filemanager;

import bfvh;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class TroopFileTransferMgr$3
  implements Runnable
{
  public TroopFileTransferMgr$3(bfvh parambfvh, TroopFileTransferManager.Item paramItem, UUID paramUUID) {}
  
  public void run()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Status)
    {
    default: 
      return;
    case 9: 
    case 10: 
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile != null) {
        new VFSFile(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile).delete();
      }
      break;
    }
    for (;;)
    {
      this.this$0.a(this.jdField_a_of_type_JavaUtilUUID, true);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.StatusUpdateTimeMs = 0L;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile = null;
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 7);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile != null) {
        new VFSFile(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.3
 * JD-Core Version:    0.7.0.1
 */