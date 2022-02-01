package com.tencent.mobileqq.qqlive.push;

import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;

public class LiveRoomPushReceiver
  implements PushReceiver
{
  private int a;
  private IQQLivePushCallback b;
  private LiveRoomPushManager c;
  
  public LiveRoomPushReceiver(LiveRoomPushManager paramLiveRoomPushManager)
  {
    this.c = paramLiveRoomPushManager;
  }
  
  public PushReceiver a(int paramInt, IQQLivePushCallback paramIQQLivePushCallback)
  {
    this.a = paramInt;
    this.b = paramIQQLivePushCallback;
    this.c.a(this);
    return this;
  }
  
  public void a()
  {
    this.c.b(this);
    this.b = null;
  }
  
  public IQQLivePushCallback b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", RoomPush");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.push.LiveRoomPushReceiver
 * JD-Core Version:    0.7.0.1
 */