package com.tencent.timi.game.trtc.roomservice.voiceroom;

import androidx.lifecycle.MutableLiveData;
import com.tencent.timi.game.trtc.roomservice.RoomParam;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.HashMapLiveData;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.HashSetLiveData;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.RoomState;
import com.tencent.timi.game.trtc.roomservice.voiceroom.info.SubRoomWrapper;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;

public class RoomCloudListener
  extends TRTCCloudListener
{
  private final TRTCRoom a;
  private final RoomParam b;
  
  public RoomCloudListener(TRTCRoom paramTRTCRoom, RoomParam paramRoomParam)
  {
    this.a = paramTRTCRoom;
    this.b = paramRoomParam;
  }
  
  public void onConnectionLost()
  {
    ((RoomState)this.a.d.getValue()).a = 1;
    this.a.d.setValue(this.a.d.getValue());
  }
  
  public void onConnectionRecovery()
  {
    ((RoomState)this.a.d.getValue()).a = 0;
    this.a.d.setValue(this.a.d.getValue());
  }
  
  public void onEnterRoom(long paramLong)
  {
    this.a.e.a(this.b.a);
    ((RoomState)this.a.d.getValue()).a = 0;
    this.a.d.setValue(this.a.d.getValue());
  }
  
  public void onExitRoom(int paramInt)
  {
    this.a.e.b(this.b.a);
    ((RoomState)this.a.d.getValue()).a = 4;
    this.a.d.setValue(this.a.d.getValue());
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    this.a.e.a(paramString);
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    this.a.e.b(paramString);
  }
  
  public void onTryToReconnect()
  {
    ((RoomState)this.a.d.getValue()).a = 2;
    this.a.d.setValue(this.a.d.getValue());
  }
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    this.a.f.a(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    HashMapLiveData localHashMapLiveData = this.a.g;
    paramInt = 0;
    localHashMapLiveData.a(false);
    this.a.g.a();
    while (paramInt < paramArrayList.size())
    {
      this.a.g.a(((TRTCCloudDef.TRTCVolumeInfo)paramArrayList.get(paramInt)).userId, Integer.valueOf(((TRTCCloudDef.TRTCVolumeInfo)paramArrayList.get(paramInt)).volume));
      if ((((TRTCCloudDef.TRTCVolumeInfo)paramArrayList.get(paramInt)).userId.equals(this.a.b.a)) && (this.a.c != null) && (this.a.c.a != null)) {
        this.a.c.a.g.a(((TRTCCloudDef.TRTCVolumeInfo)paramArrayList.get(paramInt)).userId, Integer.valueOf(((TRTCCloudDef.TRTCVolumeInfo)paramArrayList.get(paramInt)).volume));
      }
      paramInt += 1;
    }
    this.a.g.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.voiceroom.RoomCloudListener
 * JD-Core Version:    0.7.0.1
 */