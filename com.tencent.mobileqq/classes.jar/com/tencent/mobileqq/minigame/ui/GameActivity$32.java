package com.tencent.mobileqq.minigame.ui;

import anzj;
import com.tencent.mobileqq.minigame.debug.DebugWebSocket.DebuggerStateListener;
import com.tencent.qphone.base.util.QLog;

class GameActivity$32
  implements DebugWebSocket.DebuggerStateListener
{
  GameActivity$32(GameActivity paramGameActivity) {}
  
  public void onDebuggerBreakPointPaused()
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger BreakPointPaused");
    GameActivity.access$4400(this.this$0, anzj.a(2131703904), null, true);
  }
  
  public void onDebuggerConnectedNormal()
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger connected ");
    GameActivity.access$4400(this.this$0, anzj.a(2131703898), null, false);
    GameActivity.access$4500(this.this$0);
  }
  
  public void onDebuggerDisconnect(String paramString)
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger Disconnect");
    GameActivity.access$4400(this.this$0, anzj.a(2131703903), anzj.a(2131703908), false);
  }
  
  public void onDebuggerReconnecting(String paramString)
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger Reconnecting");
    GameActivity.access$4400(this.this$0, anzj.a(2131703900), anzj.a(2131703899), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.32
 * JD-Core Version:    0.7.0.1
 */