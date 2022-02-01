package com.tencent.mobileqq.identification;

import android.os.Bundle;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

class IdentificationIpcServer$3
  implements BusinessObserver
{
  IdentificationIpcServer$3(IdentificationIpcServer paramIdentificationIpcServer, int paramInt, AppRuntime paramAppRuntime) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 17) && (paramBoolean) && (paramBundle != null))
    {
      paramInt = paramBundle.getInt("app_id", 0);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive appid = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("qqidentification_server", 1, ((StringBuilder)localObject).toString());
      if (paramInt == 0) {
        return;
      }
      localObject = (AppConf)paramBundle.getSerializable("FaceRecognition.AppConf");
      this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(0, paramBundle));
      return;
    }
    if (paramInt != 15) {
      this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(-102, null));
    } else {
      this.jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(15, null));
    }
    if (paramInt == 17)
    {
      if (paramBundle == null) {
        paramBundle = "1";
      } else {
        paramBundle = "2";
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8009D63", "0X8009D63", 0, 0, paramBundle, "", "", "");
      return;
    }
    QLog.e("qqidentification_server", 1, "requestThirdPartyInfo unexpected error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationIpcServer.3
 * JD-Core Version:    0.7.0.1
 */