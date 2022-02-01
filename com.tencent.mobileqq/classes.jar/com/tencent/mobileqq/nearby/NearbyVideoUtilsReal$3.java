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
    if (!TextUtils.isEmpty(this.a))
    {
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mIsUp = true;
      localTransferRequest.mLocalPath = this.a;
      localTransferRequest.mFileType = 64;
      ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyVideoUtilsReal.3
 * JD-Core Version:    0.7.0.1
 */