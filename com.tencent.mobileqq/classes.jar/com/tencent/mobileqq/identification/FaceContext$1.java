package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.qphone.base.util.QLog;

class FaceContext$1
  extends LoginVerifyObserver
{
  FaceContext$1(FaceContext paramFaceContext, LoginVerifyObserver paramLoginVerifyObserver) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.d("FaceContext", 1, new Object[] { "refreshIpState onFailedResponse : ", paramString2 });
    FaceContext.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext, 11);
    if (this.jdField_a_of_type_ComTencentMobileqqObserverLoginVerifyObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqObserverLoginVerifyObserver.a(paramString1, paramInt, paramString2);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    FaceContext localFaceContext = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceContext;
    if (paramBoolean) {}
    for (int i = 11;; i = 10)
    {
      FaceContext.a(localFaceContext, i);
      QLog.d("FaceContext", 1, new Object[] { "ipJudgeSuccess ", Boolean.valueOf(paramBoolean), paramString });
      if (this.jdField_a_of_type_ComTencentMobileqqObserverLoginVerifyObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqObserverLoginVerifyObserver.a(paramBoolean, paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceContext.1
 * JD-Core Version:    0.7.0.1
 */