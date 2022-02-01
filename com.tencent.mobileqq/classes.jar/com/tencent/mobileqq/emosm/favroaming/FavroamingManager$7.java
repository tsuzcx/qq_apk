package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class FavroamingManager$7
  implements Runnable
{
  FavroamingManager$7(FavroamingManager paramFavroamingManager, String[] paramArrayOfString, TransferRequest paramTransferRequest) {}
  
  public void run()
  {
    if (!FileUtils.a(this.jdField_a_of_type_ArrayOfJavaLangString[1]))
    {
      Object localObject = new File(this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      localObject = new DownloadTask(this.jdField_a_of_type_ArrayOfJavaLangString[0], (File)localObject);
      ((DownloadTask)localObject).n = true;
      if (DownloaderFactory.a((DownloadTask)localObject, FavroamingManager.o(this.this$0)) != 0)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mUpCallBack instanceof EmoBatchAddedCallback)) {
          EmoBatchAddedCallback.a((EmoBatchAddedCallback)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mUpCallBack);
        }
        QLog.e("FavroamingManager", 1, "collectEmoji fail to download thumbFile: " + this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      }
    }
    while (this.this$0.a == null) {
      return;
    }
    this.this$0.a.transferAsync(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.7
 * JD-Core Version:    0.7.0.1
 */