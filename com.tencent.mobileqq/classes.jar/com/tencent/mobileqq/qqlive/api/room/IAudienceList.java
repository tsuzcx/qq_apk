package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.room.AudienceListCallback;

public abstract interface IAudienceList
  extends IQQLiveModule
{
  public abstract void getRankUserList(long paramLong, String paramString, AudienceListCallback paramAudienceListCallback);
  
  public abstract void getUserList(long paramLong, int paramInt1, int paramInt2, AudienceListCallback paramAudienceListCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.room.IAudienceList
 * JD-Core Version:    0.7.0.1
 */