package com.tencent.timi.game.trtc.roomservice.voiceroom;

import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;

class TRTCRoom$2
  extends TRTCCloudListener
{
  TRTCRoom$2(TRTCRoom paramTRTCRoom) {}
  
  public void onEnterRoom(long paramLong)
  {
    TRTCRoom.a(this.a);
    TRTCRoom.b(this.a);
    this.a.h = true;
  }
  
  public void onExitRoom(int paramInt)
  {
    super.onExitRoom(paramInt);
    this.a.h = false;
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    super.onUserVoiceVolume(paramArrayList, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.voiceroom.TRTCRoom.2
 * JD-Core Version:    0.7.0.1
 */