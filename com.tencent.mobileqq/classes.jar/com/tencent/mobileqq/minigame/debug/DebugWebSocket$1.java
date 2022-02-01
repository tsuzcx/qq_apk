package com.tencent.mobileqq.minigame.debug;

import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

class DebugWebSocket$1
  extends WebSocketListener
{
  DebugWebSocket$1(DebugWebSocket paramDebugWebSocket) {}
  
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    super.onClosed(paramWebSocket, paramInt, paramString);
    if (this.this$0.mOutListener != null) {
      this.this$0.mOutListener.onSocketClose(this.this$0, paramInt);
    }
    QLog.e(this.this$0.TAG, 1, "---onClose---code: " + paramInt + ",reason:" + paramString);
  }
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse)
  {
    if (paramResponse != null) {}
    for (int i = paramResponse.code();; i = 0)
    {
      QLog.e(this.this$0.TAG, 1, "onFailure", paramThrowable);
      if (this.this$0.mOutListener != null) {
        this.this$0.mOutListener.onSocketFailure(this.this$0, i);
      }
      return;
    }
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    if (this.this$0.mOutListener != null) {
      this.this$0.mOutListener.onSocketMessage(this.this$0, paramString);
    }
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    DebugWebSocket.access$002(this.this$0, paramWebSocket);
    if (this.this$0.mOutListener != null) {
      this.this$0.mOutListener.onSocketOpened(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.debug.DebugWebSocket.1
 * JD-Core Version:    0.7.0.1
 */