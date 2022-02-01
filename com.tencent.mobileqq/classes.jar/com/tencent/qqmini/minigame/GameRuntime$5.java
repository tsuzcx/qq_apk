package com.tencent.qqmini.minigame;

import com.tencent.qqmini.minigame.debug.DebugWebSocket.DebuggerStateListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class GameRuntime$5
  implements DebugWebSocket.DebuggerStateListener
{
  GameRuntime$5(GameRuntime paramGameRuntime) {}
  
  public void onDebuggerBreakPointPaused()
  {
    QMLog.e("GameRuntime DebugSocket", "launchGame debugger BreakPointPaused");
    GameRuntime.access$100(this.this$0).updateDebuggerStatus("断点中", null, true);
  }
  
  public void onDebuggerConnectedNormal()
  {
    QMLog.e("GameRuntime DebugSocket", "launchGame debugger connected ");
    GameRuntime.access$100(this.this$0).updateDebuggerStatus("已连接", null, false);
    this.this$0.launchGame();
  }
  
  public void onDebuggerDisconnect(String paramString)
  {
    QMLog.e("GameRuntime DebugSocket", "launchGame debugger Disconnect");
    GameRuntime.access$100(this.this$0).updateDebuggerStatus("连接断开", "关闭调试连接", false);
  }
  
  public void onDebuggerReconnecting(String paramString)
  {
    QMLog.e("GameRuntime DebugSocket", "launchGame debugger Reconnecting");
    GameRuntime.access$100(this.this$0).updateDebuggerStatus("连接断开", "重新建立调试连接...", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.5
 * JD-Core Version:    0.7.0.1
 */