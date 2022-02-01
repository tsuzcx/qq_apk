package com.tencent.qqmini.miniapp.core.service;

import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import java.util.Map;

class AppBrandWebSocket$1
  implements WebSocketProxy.WebSocketListener
{
  AppBrandWebSocket$1(AppBrandWebSocket paramAppBrandWebSocket) {}
  
  public void onClose(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.d("AppBrandRemoteService", "onClose ");
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.d("AppBrandRemoteService", "onError ");
  }
  
  public void onMessage(int paramInt, String paramString)
  {
    QMLog.d("AppBrandRemoteService", "<--- onMessage string" + paramString);
    if (this.this$0.mThreadHandler != null) {
      this.this$0.mThreadHandler.post(new AppBrandWebSocket.1.2(this, paramString));
    }
  }
  
  public void onMessage(int paramInt, byte[] paramArrayOfByte)
  {
    QMLog.d("AppBrandRemoteService", "<--- onMessage byte");
    if (this.this$0.mThreadHandler != null) {
      this.this$0.mThreadHandler.post(new AppBrandWebSocket.1.1(this, paramArrayOfByte));
    }
  }
  
  public void onOpen(int paramInt1, int paramInt2, Map<String, List<String>> paramMap)
  {
    QMLog.d("AppBrandRemoteService", "onOpen ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandWebSocket.1
 * JD-Core Version:    0.7.0.1
 */