package com.tencent.mobileqq.troop.filemanager.thumbnail;

import apdh;
import aytt;
import aytv;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.io.File;

public class TroopFileThumbnailMgr$2
  implements Runnable
{
  public TroopFileThumbnailMgr$2(aytv paramaytv, TroopFileTransferManager.Item paramItem, long paramLong, int paramInt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.jdField_a_of_type_Long, 640);
    if (apdh.b(str)) {
      aytv.a(this.this$0).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, str);
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile == null) || (!new File(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile).exists())) {
      return;
    }
    aytv.a(this.this$0).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Int, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.2
 * JD-Core Version:    0.7.0.1
 */