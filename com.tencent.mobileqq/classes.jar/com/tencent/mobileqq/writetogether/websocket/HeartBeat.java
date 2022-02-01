package com.tencent.mobileqq.writetogether.websocket;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.writetogether.websocket.msg.HeartBeatMsg;
import mqq.os.MqqHandler;

public class HeartBeat
  implements Runnable
{
  private boolean a;
  private WriteTogetherWebSocketSender b;
  private HeartBeatMsg c;
  
  HeartBeat(WriteTogetherWebSocketSender paramWriteTogetherWebSocketSender)
  {
    this.b = paramWriteTogetherWebSocketSender;
  }
  
  HeartBeatMsg a()
  {
    return this.c;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c = new HeartBeatMsg(paramString1, paramString2);
  }
  
  void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void run()
  {
    if (!this.a)
    {
      HeartBeatMsg localHeartBeatMsg = this.c;
      if (localHeartBeatMsg == null) {
        return;
      }
      this.b.a(localHeartBeatMsg);
      ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.HeartBeat
 * JD-Core Version:    0.7.0.1
 */