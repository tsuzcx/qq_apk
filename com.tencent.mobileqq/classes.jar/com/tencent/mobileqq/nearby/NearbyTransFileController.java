package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

public class NearbyTransFileController
  extends BaseTransFileController
{
  private NearbyAppInterface a;
  
  public NearbyTransFileController(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    this.a = paramNearbyAppInterface;
  }
  
  public BaseTransProcessor a(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest == null) {}
    do
    {
      return null;
      if ((paramTransferRequest.b == 8) || (paramTransferRequest.b == 64) || (paramTransferRequest.b == 21)) {
        return new NearbyPeoplePhotoUploadProcessor(this, paramTransferRequest);
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.TransFileController", 2, paramTransferRequest.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTransFileController
 * JD-Core Version:    0.7.0.1
 */