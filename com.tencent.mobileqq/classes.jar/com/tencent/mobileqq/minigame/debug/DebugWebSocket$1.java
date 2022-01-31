package com.tencent.mobileqq.minigame.debug;

import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketListener;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okio.Buffer;

class DebugWebSocket$1
  implements WebSocketListener
{
  DebugWebSocket$1(DebugWebSocket paramDebugWebSocket) {}
  
  public void onClose(int paramInt, String paramString)
  {
    if (this.this$0.mOutListener != null) {
      this.this$0.mOutListener.onSocketClose(this.this$0, paramInt);
    }
    QLog.e(this.this$0.TAG, 1, "---onClose---code: " + paramInt + ",reason:" + paramString);
  }
  
  public void onFailure(IOException paramIOException, Response paramResponse)
  {
    if (paramResponse != null) {}
    for (int i = paramResponse.code();; i = 0)
    {
      QLog.e(this.this$0.TAG, 1, "onFailure", paramIOException);
      if (this.this$0.mOutListener != null) {
        this.this$0.mOutListener.onSocketFailure(this.this$0, i);
      }
      return;
    }
  }
  
  public void onMessage(ResponseBody paramResponseBody)
  {
    if (paramResponseBody != null) {}
    for (paramResponseBody = paramResponseBody.string() + "";; paramResponseBody = "")
    {
      if (this.this$0.mOutListener != null) {
        this.this$0.mOutListener.onSocketMessage(this.this$0, paramResponseBody);
      }
      return;
    }
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    DebugWebSocket.access$002(this.this$0, paramWebSocket);
    if (this.this$0.mOutListener != null) {
      this.this$0.mOutListener.onSocketOpened(this.this$0);
    }
  }
  
  public void onPong(Buffer paramBuffer)
  {
    QLog.e(this.this$0.TAG, 1, "onPong");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.debug.DebugWebSocket.1
 * JD-Core Version:    0.7.0.1
 */