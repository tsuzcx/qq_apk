package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.TMG.utils.QLog;
import okhttp3.WebSocket;

class BaseMiniWebSocket$1
  implements Runnable
{
  BaseMiniWebSocket$1(BaseMiniWebSocket paramBaseMiniWebSocket, String paramString) {}
  
  public void run()
  {
    try
    {
      this.this$0.mWebSocket.send(this.val$message);
      QLog.e("ServiceRemoteRuntime", 0, "[sendStringMessage]:" + this.val$message);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.BaseMiniWebSocket.1
 * JD-Core Version:    0.7.0.1
 */