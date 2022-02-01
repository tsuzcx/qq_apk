package com.tencent.mobileqq.troop.filemanager.thumbnail;

import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.FileUtils;

class TroopFileThumbnailGenTask$1
  implements Runnable
{
  TroopFileThumbnailGenTask$1(TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] passiveEnd. but had stop");
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", i, ((StringBuilder)localObject).toString());
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.this$0.a(this.jdField_a_of_type_Int, true);
      return;
    }
    Object localObject = this.this$0;
    ((TroopFileThumbnailGenTask)localObject).e = ((TroopFileThumbnailGenTask)localObject).jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.this$0.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_Int);
    if (this.this$0.e.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] passiveSuc thumbpath is same.");
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenTask", i, ((StringBuilder)localObject).toString());
      this.this$0.a(true, true);
      return;
    }
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] passiveSuc copy file.");
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenTask", i, ((StringBuilder)localObject).toString());
    localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.e);
    localStringBuilder.append(".ttmp");
    ((TroopFileThumbnailGenTask)localObject).d = localStringBuilder.toString();
    FileUtils.copyFile(this.jdField_a_of_type_JavaLangString, this.this$0.d);
    this.this$0.a(false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask.1
 * JD-Core Version:    0.7.0.1
 */