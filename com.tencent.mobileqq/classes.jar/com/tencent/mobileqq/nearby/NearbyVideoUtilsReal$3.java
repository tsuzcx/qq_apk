package com.tencent.mobileqq.nearby;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;

final class NearbyVideoUtilsReal$3
  implements Runnable
{
  NearbyVideoUtilsReal$3(String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mIsUp = true;
      localTransferRequest.mLocalPath = this.jdField_a_of_type_JavaLangString;
      localTransferRequest.mFileType = 64;
      ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyVideoUtilsReal.3
 * JD-Core Version:    0.7.0.1
 */