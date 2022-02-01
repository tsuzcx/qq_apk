package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.observer.LoginVerifyObserver;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class FaceAreaManager$2
  implements EIPCResultCallback
{
  FaceAreaManager$2(FaceAreaManager paramFaceAreaManager, LoginVerifyObserver paramLoginVerifyObserver) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceAreaManager.a(paramEIPCResult, this.jdField_a_of_type_ComTencentMobileqqObserverLoginVerifyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceAreaManager.2
 * JD-Core Version:    0.7.0.1
 */