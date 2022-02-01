package com.tencent.mobileqq.guild.audio;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class TRTCAudioRoomRemote$1$1
  implements EIPCOnGetConnectionListener
{
  TRTCAudioRoomRemote$1$1(TRTCAudioRoomRemote.1 param1, int paramInt) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection.procName.equals("com.tencent.mobileqq:guild_audio"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnectBind:");
      localStringBuilder.append(paramEIPCConnection.procName);
      QLog.i("TRTCAudioRoomRemote", 2, localStringBuilder.toString());
      TRTCAudioRoomRemote.a(this.b.c, true);
      if (this.b.a != null) {
        this.b.a.a(this.a, "");
      }
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection.procName.equals("com.tencent.mobileqq:guild_audio"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnectUnbind:");
      localStringBuilder.append(paramEIPCConnection.procName);
      QLog.i("TRTCAudioRoomRemote", 2, localStringBuilder.toString());
      TRTCAudioRoomRemote.a(this.b.c, false);
      TRTCAudioRoomRemote.a(this.b.c).b(-200000, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCAudioRoomRemote.1.1
 * JD-Core Version:    0.7.0.1
 */