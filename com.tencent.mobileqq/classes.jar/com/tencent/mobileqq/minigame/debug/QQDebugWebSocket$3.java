package com.tencent.mobileqq.minigame.debug;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.DebugInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class QQDebugWebSocket$3
  implements Runnable
{
  QQDebugWebSocket$3(QQDebugWebSocket paramQQDebugWebSocket, DebugWebSocket.DebuggerStateListener paramDebuggerStateListener, boolean paramBoolean) {}
  
  public void run()
  {
    QQDebugWebSocket.access$202(this.this$0, this.val$listener);
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    String str2 = QQDebugWebSocket.access$400(this.this$0).wsUrl + "?roomId=" + QQDebugWebSocket.access$400(this.this$0).roomId + "&appId=" + QQDebugWebSocket.access$500(this.this$0) + "&uin=" + l;
    String str1 = str2;
    if (this.val$reconnect) {
      str1 = str2 + "&sessionId=" + QQDebugWebSocket.access$600(this.this$0);
    }
    QQDebugWebSocket.access$702(this.this$0, false);
    QLog.i(this.this$0.TAG, 1, "qq startConnectIDE " + str1);
    this.this$0.connect(str1, QQDebugWebSocket.access$800(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.debug.QQDebugWebSocket.3
 * JD-Core Version:    0.7.0.1
 */