package com.tencent.qqmini.minigame.debug;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class QQDebugWebSocket$3
  implements Runnable
{
  QQDebugWebSocket$3(QQDebugWebSocket paramQQDebugWebSocket, DebugWebSocket.DebuggerStateListener paramDebuggerStateListener, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = QQDebugWebSocket.access$400(this.this$0);
    if ((localObject1 != null) && (((MiniAppInfo)localObject1).debugInfo != null))
    {
      if (!((MiniAppInfo)localObject1).debugInfo.valid()) {
        return;
      }
      QQDebugWebSocket.access$202(this.this$0, this.val$listener);
      long l = QQDebugWebSocket.access$500(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((MiniAppInfo)localObject1).debugInfo.wsUrl);
      localStringBuilder.append("?roomId=");
      localObject1 = QQDebugWebSocket.access$400(this.this$0);
      Object localObject2 = "";
      if ((localObject1 != null) && (QQDebugWebSocket.access$400(this.this$0).debugInfo != null)) {
        localObject1 = QQDebugWebSocket.access$400(this.this$0).debugInfo.roomId;
      } else {
        localObject1 = "";
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("&appId=");
      localObject1 = localObject2;
      if (QQDebugWebSocket.access$400(this.this$0) != null) {
        localObject1 = QQDebugWebSocket.access$400(this.this$0).appId;
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("&uin=");
      localStringBuilder.append(l);
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
      if (this.val$reconnect)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("&sessionId=");
        ((StringBuilder)localObject1).append(QQDebugWebSocket.access$600(this.this$0));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      QQDebugWebSocket.access$702(this.this$0, false);
      localObject2 = DebugWebSocket.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("qq startConnectIDE ");
      localStringBuilder.append((String)localObject1);
      QMLog.i((String)localObject2, localStringBuilder.toString());
      localObject2 = this.this$0;
      ((QQDebugWebSocket)localObject2).connect((String)localObject1, QQDebugWebSocket.access$800((QQDebugWebSocket)localObject2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.debug.QQDebugWebSocket.3
 * JD-Core Version:    0.7.0.1
 */