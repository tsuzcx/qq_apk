package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveGetAnnounceCallback;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveSetAnnounceCallback;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveLotteryCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.ExtData;
import java.util.ArrayList;
import java.util.Map;

public abstract interface ILiveRoomOperation
{
  public abstract void getLotteryPendant(long paramLong1, long paramLong2, String paramString, Map<String, String> paramMap, IQQLiveLotteryCallback paramIQQLiveLotteryCallback);
  
  public abstract void getRoomAnnounce(long paramLong, IQQLiveGetAnnounceCallback paramIQQLiveGetAnnounceCallback);
  
  public abstract void sendFloatHeart();
  
  public abstract void sendMessage(String paramString, ArrayList<LiveMessageData.ExtData> paramArrayList, IQQLiveMessageCallback paramIQQLiveMessageCallback);
  
  public abstract void setRoomAnnounce(long paramLong1, long paramLong2, String paramString, IQQLiveSetAnnounceCallback paramIQQLiveSetAnnounceCallback);
  
  public abstract void setRoomAnnounce(long paramLong1, long paramLong2, String paramString, Map<Integer, String> paramMap, IQQLiveSetAnnounceCallback paramIQQLiveSetAnnounceCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.room.ILiveRoomOperation
 * JD-Core Version:    0.7.0.1
 */