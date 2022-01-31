package com.tencent.mobileqq.minigame.ui;

import ajjy;
import com.tencent.mobileqq.minigame.debug.DebugWebSocket.DebuggerStateListener;
import com.tencent.qphone.base.util.QLog;

class GameActivity$25
  implements DebugWebSocket.DebuggerStateListener
{
  GameActivity$25(GameActivity paramGameActivity) {}
  
  public void onDebuggerBreakPointPaused()
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger BreakPointPaused");
    GameActivity.access$4000(this.this$0, ajjy.a(2131639221), null, true);
  }
  
  public void onDebuggerConnectedNormal()
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger connected ");
    GameActivity.access$4000(this.this$0, ajjy.a(2131639215), null, false);
    GameActivity.access$4100(this.this$0);
  }
  
  public void onDebuggerDisconnect(String paramString)
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger Disconnect");
    GameActivity.access$4000(this.this$0, ajjy.a(2131639220), ajjy.a(2131639225), false);
  }
  
  public void onDebuggerReconnecting(String paramString)
  {
    QLog.e("[minigame] GameActivity DebugSocket", 1, "launchGame debugger Reconnecting");
    GameActivity.access$4000(this.this$0, ajjy.a(2131639217), ajjy.a(2131639216), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.25
 * JD-Core Version:    0.7.0.1
 */