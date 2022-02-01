package com.tencent.mobileqq.flutter.ipc;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class FlutterMainQIPCModule$1$1
  implements EIPCResultCallback
{
  FlutterMainQIPCModule$1$1(FlutterMainQIPCModule.1 param1) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool;
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess())) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool) {
      if (paramEIPCResult == null)
      {
        QLog.d("FlutterMainQIPCModule", 1, "ipc callback, result == null");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ipc callback, errCode: ");
        localStringBuilder.append(paramEIPCResult.code);
        QLog.d("FlutterMainQIPCModule", 1, localStringBuilder.toString());
      }
    }
    QLog.d("FlutterMainQIPCModule", 1, new Object[] { "ipc callback , isSuccess: %s", Boolean.valueOf(bool) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.ipc.FlutterMainQIPCModule.1.1
 * JD-Core Version:    0.7.0.1
 */