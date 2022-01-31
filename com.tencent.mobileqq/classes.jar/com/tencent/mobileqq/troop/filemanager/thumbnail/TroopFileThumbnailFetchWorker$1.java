package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.text.TextUtils;
import azst;
import azui;
import bamw;
import bbdx;
import bbfj;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopFileThumbnailFetchWorker$1
  implements Runnable
{
  public TroopFileThumbnailFetchWorker$1(azui paramazui) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      azst.b("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] start. had stoped");
      return;
    }
    this.this$0.c();
    this.this$0.e = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.this$0.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_Int);
    this.this$0.d = (this.this$0.e + ".ttmp");
    if (bbdx.b(this.this$0.e))
    {
      azst.b("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] thumb had exsited");
      this.this$0.a(true);
      return;
    }
    if (!bbfj.g(BaseApplication.getContext()))
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] no network");
      this.this$0.c(bamw.k);
      return;
    }
    if (TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath))
    {
      azst.a("TroopFileDownloadWorker", azst.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] filepath is null");
      this.this$0.c(bamw.w);
      return;
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.1
 * JD-Core Version:    0.7.0.1
 */