package com.tencent.mobileqq.winkpublish.common;

import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.request.AUploadBaseUploadRequest;
import com.tencent.mobileqq.winkpublish.request.AUploadRequest;
import com.tencent.qphone.base.util.QLog;

public class AUploadProtocolService
{
  private static Object a = new Object();
  private static AUploadProtocolService b;
  
  public static AUploadProtocolService a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new AUploadProtocolService();
        }
      }
    }
    return b;
  }
  
  public int a(AUploadRequest paramAUploadRequest, IUploadProtocolListener paramIUploadProtocolListener)
  {
    if (paramAUploadRequest == null)
    {
      paramAUploadRequest = new StringBuilder();
      paramAUploadRequest.append(UploadConstants.a);
      paramAUploadRequest.append("QCircleProtocolService");
      QLog.e(paramAUploadRequest.toString(), 1, "request is null");
      return 1000004;
    }
    paramAUploadRequest.a(paramIUploadProtocolListener);
    if ((paramAUploadRequest instanceof AUploadBaseUploadRequest)) {
      ((AUploadBaseUploadRequest)paramAUploadRequest).a(LoginData.a().e());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.common.AUploadProtocolService
 * JD-Core Version:    0.7.0.1
 */