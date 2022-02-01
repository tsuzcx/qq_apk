package com.tencent.mobileqq.guild.audio;

import com.tencent.mobileqq.guild.api.IGuildTRTCFocusApi.TRTCRequestFocusCallback;
import com.tencent.trtc.TRTCCloud;

class TRTCAudioRoomLocal$2
  implements IGuildTRTCFocusApi.TRTCRequestFocusCallback
{
  TRTCAudioRoomLocal$2(TRTCAudioRoomLocal paramTRTCAudioRoomLocal) {}
  
  public void a(boolean paramBoolean)
  {
    TRTCAudioRoomLocal.a(this.a).setListener(this.a);
    TRTCAudioRoomLocal.a(this.a).enableAudioVolumeEvaluation(TRTCAudioRoomLocal.b);
    TRTCAudioRoomLocal.a(this.a).enterRoom(TRTCAudioRoomLocal.b(this.a), TRTCAudioRoomLocal.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.TRTCAudioRoomLocal.2
 * JD-Core Version:    0.7.0.1
 */