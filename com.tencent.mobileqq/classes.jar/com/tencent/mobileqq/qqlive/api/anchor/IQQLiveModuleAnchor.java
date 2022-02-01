package com.tencent.mobileqq.qqlive.api.anchor;

import android.content.Context;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;

public abstract interface IQQLiveModuleAnchor
  extends IQQLiveModule
{
  public abstract IQQLiveAnchorRoom createFastResumeRoom(QQLiveAnchorRecord paramQQLiveAnchorRecord, IQQLiveAnchorRoomCallback paramIQQLiveAnchorRoomCallback);
  
  public abstract IQQLiveAnchorPrepareWrapper createPrepareWrapper();
  
  public abstract IQQLiveAnchorRoom createRoom(Context paramContext, QQLiveAnchorRoomConfig paramQQLiveAnchorRoomConfig, IQQLiveAnchorRoomCallback paramIQQLiveAnchorRoomCallback);
  
  public abstract void destroyRoom();
  
  public abstract IQQLiveAnchorRoom getCurRoom();
  
  public abstract QQLiveAnchorRecord getValidAnchorRecord(String paramString);
  
  public abstract void removeAnchorRecord(String paramString);
  
  public abstract int tryCloseIsolatedRoom(long paramLong, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor
 * JD-Core Version:    0.7.0.1
 */