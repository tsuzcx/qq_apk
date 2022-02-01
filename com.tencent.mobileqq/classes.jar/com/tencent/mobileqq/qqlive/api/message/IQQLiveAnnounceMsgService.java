package com.tencent.mobileqq.qqlive.api.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveGetAnnounceCallback;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveSetAnnounceCallback;
import java.util.Map;

public abstract interface IQQLiveAnnounceMsgService
  extends IQQLiveModule
{
  public abstract void addAnnounceMessageListener(IQQLiveAnnouncePushListener paramIQQLiveAnnouncePushListener);
  
  public abstract void delAnnounceMessageListener(IQQLiveAnnouncePushListener paramIQQLiveAnnouncePushListener);
  
  public abstract void getRoomAnnounce(long paramLong, IQQLiveGetAnnounceCallback paramIQQLiveGetAnnounceCallback);
  
  public abstract void setRoomAnnounce(long paramLong1, long paramLong2, String paramString, IQQLiveSetAnnounceCallback paramIQQLiveSetAnnounceCallback);
  
  public abstract void setRoomAnnounce(long paramLong1, long paramLong2, String paramString, Map<Integer, String> paramMap, IQQLiveSetAnnounceCallback paramIQQLiveSetAnnounceCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.message.IQQLiveAnnounceMsgService
 * JD-Core Version:    0.7.0.1
 */