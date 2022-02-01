package com.tencent.qqmini.minigame.debug;

import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import java.util.Map;

class DebugWebSocket$1
  implements WebSocketProxy.WebSocketListener
{
  DebugWebSocket$1(DebugWebSocket paramDebugWebSocket) {}
  
  public void onClose(int paramInt1, int paramInt2, String paramString)
  {
    if (this.this$0.mOutListener != null) {
      this.this$0.mOutListener.onSocketClose(this.this$0, paramInt2);
    }
    QMLog.e(this.this$0.TAG, "---onClose---code: " + paramInt2 + ",reason:" + paramString);
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.e(this.this$0.TAG, "onFailure " + paramString);
    if (this.this$0.mOutListener != null) {
      this.this$0.mOutListener.onSocketFailure(this.this$0, paramInt2);
    }
  }
  
  public void onMessage(int paramInt, String paramString)
  {
    if (this.this$0.mOutListener != null) {
      this.this$0.mOutListener.onSocketMessage(this.this$0, paramString);
    }
  }
  
  public void onMessage(int paramInt, byte[] paramArrayOfByte) {}
  
  public void onOpen(int paramInt1, int paramInt2, Map<String, List<String>> paramMap)
  {
    if (this.this$0.mOutListener != null) {
      this.this$0.mOutListener.onSocketOpened(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.debug.DebugWebSocket.1
 * JD-Core Version:    0.7.0.1
 */