package com.tencent.mobileqq.troop.filemanager.upload;

import aysb;
import aytz;
import java.util.LinkedList;
import java.util.Map;

public class TroopFileScaner$1
  implements Runnable
{
  public TroopFileScaner$1(aytz paramaytz, long paramLong, TroopFileScanTask paramTroopFileScanTask, String paramString) {}
  
  public void run()
  {
    aytz.a(this.this$0).put(Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileScanTask);
    aytz.a(this.this$0).add(Long.valueOf(this.jdField_a_of_type_Long));
    aysb.c("TroopFileScaner", aysb.a, "[" + this.jdField_a_of_type_Long + "] startScan filePath. " + this.jdField_a_of_type_JavaLangString + aytz.a(this.this$0));
    aytz.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileScaner.1
 * JD-Core Version:    0.7.0.1
 */