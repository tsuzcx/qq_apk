package com.tencent.mobileqq.precover.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.List;

class PrecoverIPCClient$1
  implements EIPCResultCallback
{
  PrecoverIPCClient$1(PrecoverIPCClient paramPrecoverIPCClient) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "onCallback, result=" + paramEIPCResult);
    }
    if (paramEIPCResult == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "onCallback, result.isSuccess=" + paramEIPCResult.isSuccess());
      }
      Object localObject = paramEIPCResult.data;
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("", 2, "onCallback, data is null");
        }
      }
      else
      {
        paramEIPCResult = ((Bundle)localObject).getString("key_action");
        if (QLog.isColorLevel()) {
          QLog.d("", 2, "onCallback, action=" + paramEIPCResult);
        }
        if (PrecoverIPCConstans.b.equals(paramEIPCResult))
        {
          int j = ((Bundle)localObject).getInt("errCode", -1);
          paramEIPCResult = ((Bundle)localObject).getString("errDesc");
          localObject = (PrecoverResource)((Bundle)localObject).getParcelable("resource");
          if (QLog.isColorLevel()) {
            QLog.d("", 2, "onCallback, errCode=" + j + ", errDesc=" + paramEIPCResult + ", res=" + localObject);
          }
          int i = 0;
          while (i < PrecoverIPCClient.a(this.a).size())
          {
            PrecoverIPCListener localPrecoverIPCListener = (PrecoverIPCListener)PrecoverIPCClient.a(this.a).get(i);
            if (localPrecoverIPCListener != null) {
              localPrecoverIPCListener.a(j, paramEIPCResult, (PrecoverResource)localObject);
            }
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.precover.ipc.PrecoverIPCClient.1
 * JD-Core Version:    0.7.0.1
 */