package com.tencent.mobileqq.minigame.debug;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.triton.sdk.debug.GameDebugInfo;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class QQDebugWebSocket$3
  implements Runnable
{
  QQDebugWebSocket$3(QQDebugWebSocket paramQQDebugWebSocket, DebugWebSocket.DebuggerStateListener paramDebuggerStateListener, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = QQDebugWebSocket.access$400(this.this$0);
    if ((localObject1 == null) || (!((MiniGameInfo)localObject1).needOpenDebugSocket())) {
      return;
    }
    QQDebugWebSocket.access$202(this.this$0, this.val$listener);
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    Object localObject2 = new StringBuilder().append(((MiniGameInfo)localObject1).debugInfo.wsUrl).append("?roomId=");
    if ((QQDebugWebSocket.access$400(this.this$0) != null) && (QQDebugWebSocket.access$400(this.this$0).debugInfo != null))
    {
      localObject1 = QQDebugWebSocket.access$400(this.this$0).debugInfo.roomId;
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("&appId=");
      if (QQDebugWebSocket.access$400(this.this$0) == null) {
        break label259;
      }
    }
    label259:
    for (localObject1 = QQDebugWebSocket.access$400(this.this$0).gameId;; localObject1 = "")
    {
      localObject2 = (String)localObject1 + "&uin=" + l;
      localObject1 = localObject2;
      if (this.val$reconnect) {
        localObject1 = (String)localObject2 + "&sessionId=" + QQDebugWebSocket.access$500(this.this$0);
      }
      QQDebugWebSocket.access$602(this.this$0, false);
      QLog.i(this.this$0.TAG, 1, "qq startConnectIDE " + (String)localObject1);
      this.this$0.connect((String)localObject1, QQDebugWebSocket.access$700(this.this$0));
      return;
      localObject1 = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.debug.QQDebugWebSocket.3
 * JD-Core Version:    0.7.0.1
 */