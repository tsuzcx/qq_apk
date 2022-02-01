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
    SoLoadInfo localSoLoadInfo = SoLoadInfo.sDefault;
    Object localObject = localSoLoadInfo;
    if (paramEIPCResult != null)
    {
      localObject = localSoLoadInfo;
      if (paramEIPCResult.isSuccess())
      {
        localObject = localSoLoadInfo;
        if (paramEIPCResult.data != null) {
          try
          {
            localObject = (SoLoadInfo)paramEIPCResult.data.getSerializable("res");
            paramEIPCResult = (EIPCResult)localObject;
            if (localObject == null) {
              try
              {
                paramEIPCResult = SoLoadInfo.sDefault;
              }
              catch (Throwable paramEIPCResult)
              {
                break label66;
              }
            }
            localObject = paramEIPCResult;
          }
          catch (Throwable paramEIPCResult)
          {
            localObject = localSoLoadInfo;
            label66:
            QLog.e("SoLoadWidget.IPC", 1, paramEIPCResult, new Object[0]);
          }
        }
      }
    }
    paramEIPCResult = this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnGetSoLoadInfoListener;
    if (paramEIPCResult != null) {
      paramEIPCResult.onGetLoadInfo((SoLoadInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoConfigServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */