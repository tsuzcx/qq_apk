package com.tencent.mobileqq.guild.audio;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class TRTCAudioRoomRemote$3
  implements EIPCResultCallback
{
  TRTCAudioRoomRemote$3(TRTCAudioRoomRemote paramTRTCAudioRoomRemote, ITRTCAudioRoom.ITRTCAudioRoomCallback paramITRTCAudioRoomCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("exitRoom has result: ");
        ((StringBuilder)localObject).append(paramEIPCResult.code);
        QLog.d("TRTCAudioRoomRemote", 4, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.a;
      if (localObject != null) {
        ((ITRTCAudioRoom.ITRTCAudioRoomCallback)localObject).a(paramEIPCResult.code, "");
      }
    }
    else
    {
      QLog.e("TRTCAudioRoomRemote", 4, "exitRoom fail.");
      paramEIPCResult = this.a;
      if (paramEIPCResult != null) {
        paramEIPCResult.a(-1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCAudioRoomRemote.3
 * JD-Core Version:    0.7.0.1
 */