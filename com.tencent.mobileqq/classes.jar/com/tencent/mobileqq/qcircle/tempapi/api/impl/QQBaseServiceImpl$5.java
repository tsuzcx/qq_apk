package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import com.tencent.mobileqq.qcircle.tempapi.interfaces.IAEKitResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.TAVCut.Callback;

class QQBaseServiceImpl$5
  implements TAVCut.Callback
{
  QQBaseServiceImpl$5(QQBaseServiceImpl paramQQBaseServiceImpl, IAEKitResult paramIAEKitResult) {}
  
  public void onDone(int paramInt)
  {
    QLog.d("[upload2]QQBaseServiceImpl", 1, "TAVCut init ret code = " + paramInt);
    this.jdField_a_of_type_ComTencentMobileqqQcircleTempapiInterfacesIAEKitResult.onDone(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QQBaseServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */