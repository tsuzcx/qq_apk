package com.tencent.mobileqq.troop.filemanager.download;

import arso;
import bbvl;
import bbwj;
import bdhe;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;

public class TroopFileDownloadWorker$1
  implements Runnable
{
  public TroopFileDownloadWorker$1(bbwj parambbwj) {}
  
  public void run()
  {
    if (this.this$0.b)
    {
      bbvl.b("TroopFileDownloadWorker", bbvl.a, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] start. had stoped");
      return;
    }
    this.this$0.c();
    String str = MD5.toMD5(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath);
    this.this$0.d = (this.this$0.c + str);
    str = this.this$0.c + bdhe.a(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath.getBytes()) + ".tmp";
    if (arso.a(str) > 0L)
    {
      bbvl.b("TroopFileDownloadWorker", bbvl.a, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] start. use oldVerTmpPath to resume.");
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