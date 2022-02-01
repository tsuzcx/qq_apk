package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.listener.heart.OnReceiveFloatHeartListener;

public abstract interface ILiveRoomMessage
{
  public abstract void registerAnnounceMessageListener(IQQLiveAnnouncePushListener paramIQQLiveAnnouncePushListener);
  
  public abstract void registerAudienceInfoListener(RoomAudienceInfoListener paramRoomAudienceInfoListener);
  
  public abstract void registerFollowMessageListener(IQQLiveReceiveFollowListener paramIQQLiveReceiveFollowListener);
  
  public abstract void registerHighPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback);
  
  public abstract void registerLowPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback);
  
  public abstract void registerOnReceiveFloatHeartListener(OnReceiveFloatHeartListener paramOnReceiveFloatHeartListener);
  
  public abstract void registerReceiveGiftMessageListener(ReceiveGiftMessageListener paramReceiveGiftMessageListener);
  
  public abstract void registerRoomChatMsgListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener);
  
  public abstract void registerRoomStatusListener(LiveRoomStatusListener paramLiveRoomStatusListener);
  
  public abstract void registerSystemMsgListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener);
  
  public abstract void unRegisterAnnounceMessageListener(IQQLiveAnnouncePushListener paramIQQLiveAnnouncePushListener);
  
  public abstract void unRegisterAudienceInfoListener(RoomAudienceInfoListener paramRoomAudienceInfoListener);
  
  public abstract void unRegisterFollowMessageListener(IQQLiveReceiveFollowListener paramIQQLiveReceiveFollowListener);
  
  public abstract void unRegisterHighPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback);
  
  public abstract void unRegisterLowPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback);
  
  public abstract void unRegisterOnReceiveFloatHeartListener(OnReceiveFloatHeartListener paramOnReceiveFloatHeartListener);
  
  public abstract void unRegisterReceiveGiftMessageListener(ReceiveGiftMessageListener paramReceiveGiftMessageListener);
  
  public abstract void unRegisterRoomChatMsgListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener);
  
  public abstract void unRegisterRoomStatusListener(LiveRoomStatusListener paramLiveRoomStatusListener);
  
  public abstract void unRegisterSystemMsgListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage
 * JD-Core Version:    0.7.0.1
 */