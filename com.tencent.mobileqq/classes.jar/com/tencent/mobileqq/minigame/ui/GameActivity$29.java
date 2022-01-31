package com.tencent.mobileqq.minigame.ui;

import alpo;
import com.tencent.mobileqq.minigame.debug.DebugWebSocket.DebuggerStateListener;
import com.tencent.qphone.base.util.QLog;

class GameActivity$29
  implements DebugWebSocket.DebuggerStateListener
{
  GameActivity$29(GameActivity paramGameActivity) {}
  
  public void onDebuggerBreakPointPaused()
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger BreakPointPaused");
    GameActivity.access$5000(this.this$0, alpo.a(2131705389), null, true);
  }
  
  public void onDebuggerConnectedNormal()
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger connected ");
    GameActivity.access$5000(this.this$0, alpo.a(2131705383), null, false);
    GameActivity.access$5100(this.this$0);
  }
  
  public void onDebuggerDisconnect(String paramString)
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger Disconnect");
    GameActivity.access$5000(this.this$0, alpo.a(2131705388), alpo.a(2131705393), false);
  }
  
  public void onDebuggerReconnecting(String paramString)
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger Reconnecting");
    GameActivity.access$5000(this.this$0, alpo.a(2131705385), alpo.a(2131705384), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.29
 * JD-Core Version:    0.7.0.1
 */