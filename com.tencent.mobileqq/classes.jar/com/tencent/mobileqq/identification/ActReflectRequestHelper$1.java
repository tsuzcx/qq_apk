package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.statistics.ReportController;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ActReflectRequestHelper$1
  implements EIPCResultCallback
{
  ActReflectRequestHelper$1(ActReflectRequestHelper paramActReflectRequestHelper, long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    switch (paramEIPCResult.code)
    {
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AC2D", "0X800AC2D", 0, 0, String.valueOf(System.currentTimeMillis() - ActReflectRequestHelper.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationActReflectRequestHelper)), String.valueOf(this.jdField_a_of_type_Long), "", "");
      return;
      ActReflectRequestHelper.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationActReflectRequestHelper).a(2, paramEIPCResult.data);
      continue;
      ActReflectRequestHelper.a(this.jdField_a_of_type_ComTencentMobileqqIdentificationActReflectRequestHelper).a(1, paramEIPCResult.data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.ActReflectRequestHelper.1
 * JD-Core Version:    0.7.0.1
 */