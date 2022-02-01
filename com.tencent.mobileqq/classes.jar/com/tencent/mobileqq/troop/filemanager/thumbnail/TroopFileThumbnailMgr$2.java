package com.tencent.mobileqq.troop.filemanager.thumbnail;

import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

class TroopFileThumbnailMgr$2
  implements Runnable
{
  TroopFileThumbnailMgr$2(TroopFileThumbnailMgr paramTroopFileThumbnailMgr, TroopFileTransferManager.Item paramItem, long paramLong, int paramInt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_a_of_type_Long, 640);
    if (FileUtil.a(str))
    {
      TroopFileThumbnailMgr.a(this.this$0).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, str);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile != null) && (new VFSFile(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile).exists())) {
      TroopFileThumbnailMgr.a(this.this$0).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.2
 * JD-Core Version:    0.7.0.1
 */