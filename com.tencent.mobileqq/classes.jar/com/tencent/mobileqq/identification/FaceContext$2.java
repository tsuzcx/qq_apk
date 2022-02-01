package com.tencent.mobileqq.identification;

import android.os.Bundle;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class FaceContext$2
  implements EIPCResultCallback
{
  FaceContext$2(FaceContext paramFaceContext, LoginVerifyObserver paramLoginVerifyObserver) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i = 11;
    if ((paramEIPCResult == null) || (paramEIPCResult.data == null))
    {
      FaceContext.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext, 11);
      QLog.e("FaceContext", 1, "refreshIpStateOnSubProcess error, eipcResult is null or data is null");
      this.jdField_a_of_type_ComTencentMobileqqObserverLoginVerifyObserver.a(null, -1, "eipcResult is null");
      return;
    }
    Object localObject;
    if (paramEIPCResult.code == 0)
    {
      boolean bool = paramEIPCResult.data.getBoolean("usable", false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext;
      if (bool) {}
      for (;;)
      {
        FaceContext.a((FaceContext)localObject, i);
        paramEIPCResult = paramEIPCResult.data.getString("msg");
        this.jdField_a_of_type_ComTencentMobileqqObserverLoginVerifyObserver.a(bool, paramEIPCResult);
        return;
        i = 10;
      }
    }
    if (paramEIPCResult.code == -102)
    {
      FaceContext.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext, 11);
      i = paramEIPCResult.data.getInt("code");
      localObject = paramEIPCResult.data.getString("cmd");
      paramEIPCResult = paramEIPCResult.data.getString("msg");
      this.jdField_a_of_type_ComTencentMobileqqObserverLoginVerifyObserver.a((String)localObject, i, paramEIPCResult);
      return;
    }
    FaceContext.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext, 11);
    QLog.e("FaceContext", 1, new Object[] { "refreshIpStateOnSubProcess error, unknown code : ", Integer.valueOf(paramEIPCResult.code) });
    this.jdField_a_of_type_ComTencentMobileqqObserverLoginVerifyObserver.a(null, -1, "unknown code");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceContext.2
 * JD-Core Version:    0.7.0.1
 */