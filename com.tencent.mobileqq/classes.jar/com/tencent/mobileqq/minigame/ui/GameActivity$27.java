package com.tencent.mobileqq.minigame.ui;

import ajya;
import com.tencent.mobileqq.minigame.debug.DebugWebSocket.DebuggerStateListener;
import com.tencent.qphone.base.util.QLog;

class GameActivity$27
  implements DebugWebSocket.DebuggerStateListener
{
  GameActivity$27(GameActivity paramGameActivity) {}
  
  public void onDebuggerBreakPointPaused()
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger BreakPointPaused");
    GameActivity.access$4200(this.this$0, ajya.a(2131705017), null, true);
  }
  
  public void onDebuggerConnectedNormal()
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger connected ");
    GameActivity.access$4200(this.this$0, ajya.a(2131705011), null, false);
    GameActivity.access$4300(this.this$0);
  }
  
  public void onDebuggerDisconnect(String paramString)
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger Disconnect");
    GameActivity.access$4200(this.this$0, ajya.a(2131705016), ajya.a(2131705021), false);
  }
  
  public void onDebuggerReconnecting(String paramString)
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger Reconnecting");
    GameActivity.access$4200(this.this$0, ajya.a(2131705013), ajya.a(2131705012), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.27
 * JD-Core Version:    0.7.0.1
 */