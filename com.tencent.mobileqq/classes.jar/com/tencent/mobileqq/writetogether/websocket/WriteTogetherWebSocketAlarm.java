package com.tencent.mobileqq.writetogether.websocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.writetogether.websocket.msg.BaseToWriteTogetherMsg;
import java.util.concurrent.ConcurrentHashMap;

public class WriteTogetherWebSocketAlarm
{
  private volatile Handler a;
  private WriteTogetherWebSocketSender b;
  private ConcurrentHashMap<Integer, WriteTogetherWebSocketAlarm.TimeoutChecker> c = new ConcurrentHashMap();
  
  public WriteTogetherWebSocketAlarm(WriteTogetherWebSocketSender paramWriteTogetherWebSocketSender)
  {
    this.b = paramWriteTogetherWebSocketSender;
    paramWriteTogetherWebSocketSender = new HandlerThread("WriteTogetherWebSocketAlarm", 5);
    paramWriteTogetherWebSocketSender.start();
    this.a = new Handler(paramWriteTogetherWebSocketSender.getLooper());
  }
  
  public void a(@NonNull BaseToWriteTogetherMsg paramBaseToWriteTogetherMsg, long paramLong)
  {
    WriteTogetherWebSocketAlarm.TimeoutChecker localTimeoutChecker = new WriteTogetherWebSocketAlarm.TimeoutChecker(this, paramBaseToWriteTogetherMsg);
    this.c.put(Integer.valueOf(paramBaseToWriteTogetherMsg.getSeq()), localTimeoutChecker);
    this.a.postDelayed(localTimeoutChecker, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketAlarm
 * JD-Core Version:    0.7.0.1
 */