package com.tencent.mobileqq.writetogether.websocket;

import com.tencent.mobileqq.writetogether.websocket.msg.BaseToWriteTogetherMsg;
import java.util.concurrent.ConcurrentHashMap;

class WriteTogetherWebSocketAlarm$TimeoutChecker
  implements Runnable
{
  private BaseToWriteTogetherMsg a;
  
  public WriteTogetherWebSocketAlarm$TimeoutChecker(WriteTogetherWebSocketAlarm paramWriteTogetherWebSocketAlarm, BaseToWriteTogetherMsg paramBaseToWriteTogetherMsg)
  {
    this.a = paramBaseToWriteTogetherMsg;
  }
  
  public void run()
  {
    BaseToWriteTogetherMsg localBaseToWriteTogetherMsg = (BaseToWriteTogetherMsg)WriteTogetherWebSocketAlarm.a(this.this$0).b().remove(Integer.valueOf(this.a.getSeq()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketAlarm.TimeoutChecker
 * JD-Core Version:    0.7.0.1
 */