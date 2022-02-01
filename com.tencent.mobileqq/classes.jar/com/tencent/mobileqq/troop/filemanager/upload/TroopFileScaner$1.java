package com.tencent.mobileqq.troop.filemanager.upload;

import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import java.util.LinkedList;
import java.util.Map;

class TroopFileScaner$1
  implements Runnable
{
  TroopFileScaner$1(TroopFileScaner paramTroopFileScaner, long paramLong, TroopFileScanTask paramTroopFileScanTask, String paramString) {}
  
  public void run()
  {
    TroopFileScaner.a(this.this$0).put(Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask);
    TroopFileScaner.a(this.this$0).add(Long.valueOf(this.jdField_a_of_type_Long));
    TroopFileTransferUtil.Log.c("TroopFileScaner", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_Long + "] startScan filePath. " + this.jdField_a_of_type_JavaLangString + TroopFileScaner.a(this.this$0));
    TroopFileScaner.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileScaner.1
 * JD-Core Version:    0.7.0.1
 */