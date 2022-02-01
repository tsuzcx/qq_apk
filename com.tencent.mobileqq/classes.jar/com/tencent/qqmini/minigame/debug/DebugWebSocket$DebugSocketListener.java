package com.tencent.qqmini.minigame.debug;

public abstract interface DebugWebSocket$DebugSocketListener
{
  public abstract void onSocketClose(DebugWebSocket paramDebugWebSocket, int paramInt);
  
  public abstract void onSocketFailure(DebugWebSocket paramDebugWebSocket, int paramInt);
  
  public abstract void onSocketMessage(DebugWebSocket paramDebugWebSocket, String paramString);
  
  public abstract void onSocketOpened(DebugWebSocket paramDebugWebSocket);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.debug.DebugWebSocket.DebugSocketListener
 * JD-Core Version:    0.7.0.1
 */