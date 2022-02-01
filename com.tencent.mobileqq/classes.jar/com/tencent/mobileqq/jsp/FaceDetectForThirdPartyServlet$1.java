package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class FaceDetectForThirdPartyServlet$1
  extends LoginVerifyObserver
{
  FaceDetectForThirdPartyServlet$1(BusinessObserver paramBusinessObserver, int paramInt) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(paramInt, false, null);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = FaceDetectForThirdPartyServlet.a(paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(17, false, null);
      QLog.e("FaceDetectForThirdPartyServlet", 1, "getAppConfigSuccess, but appconf is null");
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("app_id", this.jdField_a_of_type_Int);
      localBundle.putSerializable("FaceRecognition.AppConf", paramArrayOfByte);
      this.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(17, true, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("FaceDetectForThirdPartyServlet", 2, new Object[] { "handleFaceDetectResponse succsss=", paramArrayOfByte });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.FaceDetectForThirdPartyServlet.1
 * JD-Core Version:    0.7.0.1
 */