package com.tencent.mobileqq.vas.qvip.util;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ReportAmsAdvHelper$1
  implements EIPCResultCallback
{
  ReportAmsAdvHelper$1(int paramInt, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult.isSuccess()) && (QLog.isColorLevel()))
    {
      paramEIPCResult = new StringBuilder();
      paramEIPCResult.append("reportAmsAdv success. reportType =");
      paramEIPCResult.append(this.jdField_a_of_type_Int);
      paramEIPCResult.append(" reportUrl =");
      paramEIPCResult.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ReportAmsAdvHelper", 2, paramEIPCResult.toString());
      return;
    }
    paramEIPCResult = new StringBuilder();
    paramEIPCResult.append("reportAmsAdv failed. reportType =");
    paramEIPCResult.append(this.jdField_a_of_type_Int);
    paramEIPCResult.append(" reportUrl =");
    paramEIPCResult.append(this.jdField_a_of_type_JavaLangString);
    QLog.e("ReportAmsAdvHelper", 2, paramEIPCResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.util.ReportAmsAdvHelper.1
 * JD-Core Version:    0.7.0.1
 */