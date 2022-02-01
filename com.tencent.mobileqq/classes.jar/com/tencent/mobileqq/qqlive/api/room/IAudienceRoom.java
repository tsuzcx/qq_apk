package com.tencent.mobileqq.qqlive.api.room;

import android.os.Bundle;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;

public abstract interface IAudienceRoom
  extends ILiveTPPlayerRoom
{
  public abstract void enterRoom(EnterRoomInfo paramEnterRoomInfo, boolean paramBoolean, EnterAudienceRoomCallback paramEnterAudienceRoomCallback);
  
  public abstract LiveInfo getRoomLiveInfo();
  
  public abstract void setExtraData(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.room.IAudienceRoom
 * JD-Core Version:    0.7.0.1
 */