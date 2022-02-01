package com.tencent.timi.game.trtc;

import com.tencent.timi.game.trtc.roomservice.RoomParam;
import com.tencent.timi.game.trtc.roomservice.voiceroom.RoomCloudListener;
import com.tencent.timi.game.trtc.roomservice.voiceroom.TRTCRoom;
import com.tencent.timi.game.trtc.tools.Printer;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;

class TRTCInstance$1
  extends RoomCloudListener
{
  TRTCInstance$1(TRTCInstance paramTRTCInstance, TRTCRoom paramTRTCRoom, RoomParam paramRoomParam, TRTCCloudListener paramTRTCCloudListener)
  {
    super(paramTRTCRoom, paramRoomParam);
  }
  
  public void onEnterRoom(long paramLong)
  {
    super.onEnterRoom(paramLong);
    Object localObject = this.a;
    if (localObject != null) {
      ((TRTCCloudListener)localObject).onEnterRoom(paramLong);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("子房间耗时:");
    ((StringBuilder)localObject).append(paramLong);
    Printer.a("onEnterRoom", new Object[] { ((StringBuilder)localObject).toString() });
  }
  
  public void onExitRoom(int paramInt)
  {
    super.onExitRoom(paramInt);
    if (TRTCInstance.a(this.b) != null) {
      TRTCInstance.a(this.b).destroySubCloud(this.b.a);
    } else {
      Printer.a("onExitRoom", new Object[] { "子房间trtcCloud isNull" });
    }
    this.b.a = null;
    Object localObject = this.a;
    if (localObject != null) {
      ((TRTCCloudListener)localObject).onExitRoom(paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("子房间:");
    ((StringBuilder)localObject).append(paramInt);
    Printer.a("onExitRoom", new Object[] { ((StringBuilder)localObject).toString() });
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    super.onUserVoiceVolume(paramArrayList, paramInt);
    TRTCCloudListener localTRTCCloudListener = this.a;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onUserVoiceVolume(paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.TRTCInstance.1
 * JD-Core Version:    0.7.0.1
 */