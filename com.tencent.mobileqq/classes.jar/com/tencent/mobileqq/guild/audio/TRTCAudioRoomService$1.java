package com.tencent.mobileqq.guild.audio;

import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class TRTCAudioRoomService$1
  implements EIPClientConnectListener
{
  TRTCAudioRoomService$1(TRTCAudioRoomService paramTRTCAudioRoomService) {}
  
  public void connectFailed()
  {
    this.a.c = false;
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCAudioRoomService.1
 * JD-Core Version:    0.7.0.1
 */