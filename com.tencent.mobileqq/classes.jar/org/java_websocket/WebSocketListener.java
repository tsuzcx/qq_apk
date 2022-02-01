package org.java_websocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import org.java_websocket.drafts.Draft;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;

public abstract interface WebSocketListener
{
  public abstract InetSocketAddress getLocalSocketAddress(WebSocket paramWebSocket);
  
  public abstract InetSocketAddress getRemoteSocketAddress(WebSocket paramWebSocket);
  
  public abstract void onWebsocketClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void onWebsocketCloseInitiated(WebSocket paramWebSocket, int paramInt, String paramString);
  
  public abstract void onWebsocketClosing(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void onWebsocketError(WebSocket paramWebSocket, Exception paramException);
  
  public abstract void onWebsocketHandshakeReceivedAsClient(WebSocket paramWebSocket, ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake);
  
  public abstract ServerHandshakeBuilder onWebsocketHandshakeReceivedAsServer(WebSocket paramWebSocket, Draft paramDraft, ClientHandshake paramClientHandshake);
  
  public abstract void onWebsocketHandshakeSentAsClient(WebSocket paramWebSocket, ClientHandshake paramClientHandshake);
  
  public abstract void onWebsocketMessage(WebSocket paramWebSocket, String paramString);
  
  public abstract void onWebsocketMessage(WebSocket paramWebSocket, ByteBuffer paramByteBuffer);
  
  public abstract void onWebsocketOpen(WebSocket paramWebSocket, Handshakedata paramHandshakedata);
  
  public abstract void onWebsocketPing(WebSocket paramWebSocket, Framedata paramFramedata);
  
  public abstract void onWebsocketPong(WebSocket paramWebSocket, Framedata paramFramedata);
  
  public abstract void onWriteDemand(WebSocket paramWebSocket);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.WebSocketListener
 * JD-Core Version:    0.7.0.1
 */