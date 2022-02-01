package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class FaceDetectForThirdPartyServlet$1
  extends LoginVerifyObserver
{
  FaceDetectForThirdPartyServlet$1(BusinessObserver paramBusinessObserver, int paramInt) {}
  
  public void getAppConfigSuccess(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = FaceDetectForThirdPartyServlet.a(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      this.a.onReceive(17, false, null);
      QLog.e("FaceDetectForThirdPartyServlet", 1, "getAppConfigSuccess, but appconf is null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("app_id", this.b);
    localBundle.putSerializable("FaceRecognition.AppConf", paramArrayOfByte);
    this.a.onReceive(17, true, localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("FaceDetectForThirdPartyServlet", 2, new Object[] { "handleFaceDetectResponse succsss=", paramArrayOfByte });
    }
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    this.a.onReceive(paramInt, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.FaceDetectForThirdPartyServlet.1
 * JD-Core Version:    0.7.0.1
 */