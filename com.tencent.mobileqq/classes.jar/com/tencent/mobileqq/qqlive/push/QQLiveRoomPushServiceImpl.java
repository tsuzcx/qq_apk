package com.tencent.mobileqq.qqlive.push;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;

public class QQLiveRoomPushServiceImpl
  implements IQQLiveRoomPushService
{
  private LiveRoomPushManager a;
  private IQQLiveSDK b;
  
  public PushReceiver a()
  {
    return new LiveRoomPushReceiver(this.a);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.a.a(paramLong1, paramLong2);
  }
  
  public long b()
  {
    return this.a.b();
  }
  
  public void destroy()
  {
    this.a.a();
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.b = paramIQQLiveSDK;
    this.a = new LiveRoomPushManager();
    this.a.a(paramIQQLiveSDK);
  }
  
  public void reset()
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.push.QQLiveRoomPushServiceImpl
 * JD-Core Version:    0.7.0.1
 */