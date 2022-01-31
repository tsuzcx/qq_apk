package com.tencent.mobileqq.troop.filemanager.download;

import apdh;
import aysb;
import aysz;
import bach;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;

public class TroopFileDownloadWorker$1
  implements Runnable
{
  public TroopFileDownloadWorker$1(aysz paramaysz) {}
  
  public void run()
  {
    if (this.this$0.b)
    {
      aysb.b("TroopFileDownloadWorker", aysb.a, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] start. had stoped");
      return;
    }
    this.this$0.c();
    String str = MD5.toMD5(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.this$0.d = (this.this$0.c + str);
    str = this.this$0.c + bach.a(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath.getBytes()) + ".tmp";
    if (apdh.a(str) > 0L)
    {
      aysb.b("TroopFileDownloadWorker", aysb.a, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] start. use oldVerTmpPath to resume.");
      this.this$0.d = str;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile = this.this$0.d;
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.1
 * JD-Core Version:    0.7.0.1
 */