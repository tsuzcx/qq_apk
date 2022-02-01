package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.text.TextUtils;
import bfmf;
import bfnt;
import bgme;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopFileThumbnailFetchWorker$1
  implements Runnable
{
  public TroopFileThumbnailFetchWorker$1(bfnt parambfnt) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      bfmf.b("TroopFileDownloadWorker", bfmf.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] start. had stoped");
      return;
    }
    this.this$0.c();
    this.this$0.e = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getThumbnailFile(this.this$0.jdField_a_of_type_Long, this.this$0.jdField_a_of_type_Int);
    this.this$0.d = (this.this$0.e + ".ttmp");
    if (FileUtils.fileExistsAndNotEmpty(this.this$0.e))
    {
      bfmf.b("TroopFileDownloadWorker", bfmf.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] thumb had exsited");
      this.this$0.a(true);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      bfmf.a("TroopFileDownloadWorker", bfmf.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] no network");
      this.this$0.c(bgme.k);
      return;
    }
    if (TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath))
    {
      bfmf.a("TroopFileDownloadWorker", bfmf.jdField_a_of_type_Int, "[" + this.this$0.jdField_a_of_type_JavaLangString + "] filepath is null");
      this.this$0.c(bgme.w);
      return;
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.1
 * JD-Core Version:    0.7.0.1
 */