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
    if ((localObject1 == null) || (((MiniAppInfo)localObject1).debugInfo == null) || (!((MiniAppInfo)localObject1).debugInfo.valid())) {
      return;
    }
    QQDebugWebSocket.access$202(this.this$0, this.val$listener);
    long l = QQDebugWebSocket.access$500(this.this$0);
    Object localObject2 = new StringBuilder().append(((MiniAppInfo)localObject1).debugInfo.wsUrl).append("?roomId=");
    if ((QQDebugWebSocket.access$400(this.this$0) != null) && (QQDebugWebSocket.access$400(this.this$0).debugInfo != null))
    {
      localObject1 = QQDebugWebSocket.access$400(this.this$0).debugInfo.roomId;
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("&appId=");
      if (QQDebugWebSocket.access$400(this.this$0) == null) {
        break label266;
      }
    }
    label266:
    for (localObject1 = QQDebugWebSocket.access$400(this.this$0).appId;; localObject1 = "")
    {
      localObject2 = (String)localObject1 + "&uin=" + l;
      localObject1 = localObject2;
      if (this.val$reconnect) {
        localObject1 = (String)localObject2 + "&sessionId=" + QQDebugWebSocket.access$600(this.this$0);
      }
      QQDebugWebSocket.access$702(this.this$0, false);
      QMLog.i(this.this$0.TAG, "qq startConnectIDE " + (String)localObject1);
      this.this$0.connect((String)localObject1, QQDebugWebSocket.access$800(this.this$0));
      return;
      localObject1 = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.debug.QQDebugWebSocket.3
 * JD-Core Version:    0.7.0.1
 */