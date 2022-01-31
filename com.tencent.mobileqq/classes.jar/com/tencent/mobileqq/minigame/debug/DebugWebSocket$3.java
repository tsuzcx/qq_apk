package com.tencent.mobileqq.minigame.debug;

import java.util.ArrayList;

class DebugWebSocket$3
  implements Runnable
{
  DebugWebSocket$3(DebugWebSocket paramDebugWebSocket, String paramString) {}
  
  public void run()
  {
    if (DebugWebSocket.access$100(this.this$0).size() < 64) {
      DebugWebSocket.access$100(this.this$0).add(this.val$message);
    }
    this.this$0.excuteSocketMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.debug.DebugWebSocket.3
 * JD-Core Version:    0.7.0.1
 */