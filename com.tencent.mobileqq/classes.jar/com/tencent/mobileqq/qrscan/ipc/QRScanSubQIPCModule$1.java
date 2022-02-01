package com.tencent.mobileqq.qrscan.ipc;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class QRScanSubQIPCModule$1
  implements EIPCResultCallback
{
  QRScanSubQIPCModule$1(QRScanSubQIPCModule paramQRScanSubQIPCModule) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEIPCResult != null)
    {
      bool1 = bool2;
      if (paramEIPCResult.isSuccess()) {
        bool1 = true;
      }
    }
    QLog.d("MiniRecog.QRScanSubQIPCModule", 1, String.format("callServer_%s result=%b", new Object[] { "action_call_download_res", Boolean.valueOf(bool1) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ipc.QRScanSubQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */