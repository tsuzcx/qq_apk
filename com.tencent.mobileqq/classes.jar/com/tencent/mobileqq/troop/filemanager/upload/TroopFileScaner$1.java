package com.tencent.mobileqq.troop.filemanager.upload;

import bbvl;
import bbxj;
import java.util.LinkedList;
import java.util.Map;

public class TroopFileScaner$1
  implements Runnable
{
  public TroopFileScaner$1(bbxj parambbxj, long paramLong, TroopFileScanTask paramTroopFileScanTask, String paramString) {}
  
  public void run()
  {
    bbxj.a(this.this$0).put(Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask);
    bbxj.a(this.this$0).add(Long.valueOf(this.jdField_a_of_type_Long));
    bbvl.c("TroopFileScaner", bbvl.a, "[" + this.jdField_a_of_type_Long + "] startScan filePath. " + this.jdField_a_of_type_JavaLangString + bbxj.a(this.this$0));
    bbxj.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileScaner.1
 * JD-Core Version:    0.7.0.1
 */