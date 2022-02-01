package com.tencent.mobileqq.troop.filemanager.thumbnail;

import bevx;
import bgmg;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

class TroopFileThumbnailGenTask$1
  implements Runnable
{
  TroopFileThumbnailGenTask$1(TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      bevx.b("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] passiveEnd. but had stop");
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.this$0.a(this.jdField_a_of_type_Int, true);
      return;
    }
    this.this$0.e = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.this$0.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_Int);
    if (this.this$0.e.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      bevx.b("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] passiveSuc thumbpath is same.");
      this.this$0.a(true, true);
      return;
    }
    bevx.c("TroopFileThumbnailGenTask", bevx.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] passiveSuc copy file.");
    this.this$0.d = (this.this$0.e + ".ttmp");
    bgmg.d(this.jdField_a_of_type_JavaLangString, this.this$0.d);
    this.this$0.a(false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask.1
 * JD-Core Version:    0.7.0.1
 */