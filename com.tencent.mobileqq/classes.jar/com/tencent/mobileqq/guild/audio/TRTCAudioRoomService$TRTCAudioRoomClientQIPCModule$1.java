package com.tencent.mobileqq.guild.audio;

import eipc.EIPCResult;

class TRTCAudioRoomService$TRTCAudioRoomClientQIPCModule$1
  implements ITRTCAudioRoom.ITRTCAudioRoomCallback
{
  TRTCAudioRoomService$TRTCAudioRoomClientQIPCModule$1(TRTCAudioRoomService.TRTCAudioRoomClientQIPCModule paramTRTCAudioRoomClientQIPCModule, int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    this.b.callbackResult(this.a, EIPCResult.createResult(paramInt, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCAudioRoomService.TRTCAudioRoomClientQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */