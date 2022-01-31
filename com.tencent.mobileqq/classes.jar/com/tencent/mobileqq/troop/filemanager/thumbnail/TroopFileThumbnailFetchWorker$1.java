package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.text.TextUtils;
import aysb;
import aytq;
import azle;
import bace;
import badq;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopFileThumbnailFetchWorker$1
  implements Runnable
{
  public TroopFileThumbnailFetchWorker$1(aytq paramaytq) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      aysb.b("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] start. had stoped");
      return;
    }
    this.this$0.c();
    this.this$0.e = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.this$0.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_Int);
    this.this$0.d = (this.this$0.e + ".ttmp");
    if (bace.b(this.this$0.e))
    {
      aysb.b("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] thumb had exsited");
      this.this$0.a(true);
      return;
    }
    if (!badq.g(BaseApplication.getContext()))
    {
      aysb.a("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] no network");
      this.this$0.c(azle.k);
      return;
    }
    if (TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath))
    {
      aysb.a("TroopFileDownloadWorker", aysb.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] filepath is null");
      this.this$0.c(azle.w);
      return;
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.1
 * JD-Core Version:    0.7.0.1
 */