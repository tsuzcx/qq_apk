package com.tencent.mobileqq.minigame.debug;

public abstract interface DebugWebSocket$DebuggerStateListener
{
  public abstract void onDebuggerBreakPointPaused();
  
  public abstract void onDebuggerConnectedNormal();
  
  public abstract void onDebuggerDisconnect(String paramString);
  
  public abstract void onDebuggerReconnecting(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.debug.DebugWebSocket.DebuggerStateListener
 * JD-Core Version:    0.7.0.1
 */