package com.tencent.mobileqq.soload.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class SoConfigServiceImpl$1
  implements EIPCResultCallback
{
  SoConfigServiceImpl$1(SoConfigServiceImpl paramSoConfigServiceImpl, OnGetSoLoadInfoListener paramOnGetSoLoadInfoListener) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    SoLoadInfo localSoLoadInfo2 = SoLoadInfo.sDefault;
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null)) {}
    for (;;)
    {
      try
      {
        SoLoadInfo localSoLoadInfo1 = (SoLoadInfo)paramEIPCResult.data.getSerializable("res");
        paramEIPCResult = localSoLoadInfo1;
        if (localSoLoadInfo1 == null) {}
        QLog.e("SoLoadWidget.IPC", 1, localThrowable1, new Object[0]);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          paramEIPCResult = SoLoadInfo.sDefault;
          if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnGetSoLoadInfoListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnGetSoLoadInfoListener.a(paramEIPCResult);
          }
          return;
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            paramEIPCResult = localThrowable1;
            Throwable localThrowable2 = localThrowable3;
          }
        }
        localThrowable1 = localThrowable1;
        paramEIPCResult = localSoLoadInfo2;
      }
      continue;
      paramEIPCResult = localThrowable3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoConfigServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */