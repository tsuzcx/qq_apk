package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.qphone.base.util.QLog;

class FaceAreaManager$1
  extends LoginVerifyObserver
{
  FaceAreaManager$1(FaceAreaManager paramFaceAreaManager, LoginVerifyObserver paramLoginVerifyObserver) {}
  
  public void ipJudgeSuccess(boolean paramBoolean, String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceAreaManager;
    int i;
    if (paramBoolean) {
      i = 11;
    } else {
      i = 10;
    }
    ((FaceAreaManager)localObject).a = i;
    QLog.d("FaceContext", 1, new Object[] { "ipJudgeSuccess ", Boolean.valueOf(paramBoolean), paramString });
    localObject = this.jdField_a_of_type_ComTencentMobileqqObserverLoginVerifyObserver;
    if (localObject != null) {
      ((LoginVerifyObserver)localObject).ipJudgeSuccess(paramBoolean, paramString);
    }
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QLog.d("FaceContext", 1, new Object[] { "refreshIpState onFailedResponse : ", paramString2 });
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceAreaManager.a = 11;
    LoginVerifyObserver localLoginVerifyObserver = this.jdField_a_of_type_ComTencentMobileqqObserverLoginVerifyObserver;
    if (localLoginVerifyObserver != null) {
      localLoginVerifyObserver.onFailedResponse(paramString1, paramInt, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceAreaManager.1
 * JD-Core Version:    0.7.0.1
 */