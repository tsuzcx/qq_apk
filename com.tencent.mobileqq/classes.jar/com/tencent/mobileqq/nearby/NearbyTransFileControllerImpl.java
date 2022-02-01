package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyTransFileController;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class NearbyTransFileControllerImpl
  extends BaseTransFileController
  implements INearbyTransFileController
{
  private INearbyAppInterface app;
  
  public NearbyTransFileControllerImpl() {}
  
  public NearbyTransFileControllerImpl(INearbyAppInterface paramINearbyAppInterface)
  {
    super((AppRuntime)paramINearbyAppInterface);
    this.app = paramINearbyAppInterface;
  }
  
  public BaseTransProcessor getProcessor(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest == null) {
      return null;
    }
    if ((paramTransferRequest.mFileType != 8) && (paramTransferRequest.mFileType != 64) && (paramTransferRequest.mFileType != 21))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.richmedia.TransFileController", 2, paramTransferRequest.toString());
      }
      return null;
    }
    return new NearbyPeoplePhotoUploadProcessor(null, paramTransferRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTransFileControllerImpl
 * JD-Core Version:    0.7.0.1
 */