package org.java_websocket;

import java.util.List;
import org.java_websocket.drafts.Draft;

public abstract interface WebSocketFactory
{
  public abstract WebSocket createWebSocket(WebSocketAdapter paramWebSocketAdapter, List<Draft> paramList);
  
  public abstract WebSocket createWebSocket(WebSocketAdapter paramWebSocketAdapter, Draft paramDraft);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.WebSocketFactory
 * JD-Core Version:    0.7.0.1
 */