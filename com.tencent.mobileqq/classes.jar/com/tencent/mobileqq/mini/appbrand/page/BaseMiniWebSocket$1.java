package com.tencent.mobileqq.mini.appbrand.page;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ws.WebSocket;
import com.tencent.TMG.utils.QLog;

class BaseMiniWebSocket$1
  implements Runnable
{
  BaseMiniWebSocket$1(BaseMiniWebSocket paramBaseMiniWebSocket, String paramString) {}
  
  public void run()
  {
    try
    {
      MediaType localMediaType = MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
      this.this$0.mWebSocket.sendMessage(RequestBody.create(localMediaType, this.val$message));
      QLog.e("ServiceRemoteRuntime", 0, "[sendStringMessage]:" + this.val$message);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.BaseMiniWebSocket.1
 * JD-Core Version:    0.7.0.1
 */