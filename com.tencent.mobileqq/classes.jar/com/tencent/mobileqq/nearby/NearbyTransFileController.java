package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

public class NearbyTransFileController
  extends BaseTransFileController
{
  public BaseTransProcessor getProcessor(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest == null) {}
    do
    {
      return null;
      if ((paramTransferRequest.mFileType == 8) || (paramTransferRequest.mFileType == 64) || (paramTransferRequest.mFileType == 21)) {
        return new NearbyPeoplePhotoUploadProcessor(this, paramTransferRequest);
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.TransFileController", 2, paramTransferRequest.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTransFileController
 * JD-Core Version:    0.7.0.1
 */