package com.tencent.mobileqq.troop.filemanager.upload;

import bfvr;
import bfxo;
import java.util.LinkedList;
import java.util.Map;

public class TroopFileScaner$1
  implements Runnable
{
  public TroopFileScaner$1(bfxo parambfxo, long paramLong, TroopFileScanTask paramTroopFileScanTask, String paramString) {}
  
  public void run()
  {
    bfxo.a(this.this$0).put(Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask);
    bfxo.a(this.this$0).add(Long.valueOf(this.jdField_a_of_type_Long));
    bfvr.c("TroopFileScaner", bfvr.a, "[" + this.jdField_a_of_type_Long + "] startScan filePath. " + this.jdField_a_of_type_JavaLangString + bfxo.a(this.this$0));
    bfxo.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileScaner.1
 * JD-Core Version:    0.7.0.1
 */