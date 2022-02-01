package com.tencent.mobileqq.qqlive.push;

import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo.MsgSpeed;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class LiveRoomPushManager$PushNotifyRunnable
  implements Runnable
{
  int a;
  byte[] b;
  int c;
  long d;
  LiveMsgExtInfo.MsgSpeed e;
  
  LiveRoomPushManager$PushNotifyRunnable(LiveRoomPushManager paramLiveRoomPushManager, int paramInt1, byte[] paramArrayOfByte, int paramInt2, long paramLong, LiveMsgExtInfo.MsgSpeed paramMsgSpeed)
  {
    this.a = paramInt1;
    this.b = paramArrayOfByte;
    this.c = paramInt2;
    this.d = paramLong;
    this.e = paramMsgSpeed;
  }
  
  public void run()
  {
    Iterator localIterator = LiveRoomPushManager.c(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      LiveRoomPushReceiver localLiveRoomPushReceiver = (LiveRoomPushReceiver)localIterator.next();
      if (localLiveRoomPushReceiver.c() == this.a)
      {
        LiveMsgExtInfo localLiveMsgExtInfo = new LiveMsgExtInfo();
        localLiveMsgExtInfo.msgType = this.c;
        localLiveMsgExtInfo.msgSpeed = this.e;
        localLiveMsgExtInfo.msgUid = this.d;
        localLiveRoomPushReceiver.b().onRecv(this.a, this.b, localLiveMsgExtInfo);
      }
    }
    LiveRoomPushManager.a(this.this$0, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.push.LiveRoomPushManager.PushNotifyRunnable
 * JD-Core Version:    0.7.0.1
 */