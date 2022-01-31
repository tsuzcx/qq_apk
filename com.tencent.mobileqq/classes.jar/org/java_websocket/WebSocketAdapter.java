package org.java_websocket;

import org.java_websocket.drafts.Draft;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.PingFrame;
import org.java_websocket.framing.PongFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;

public abstract class WebSocketAdapter
  implements WebSocketListener
{
  public void onWebsocketHandshakeReceivedAsClient(WebSocket paramWebSocket, ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake) {}
  
  public ServerHandshakeBuilder onWebsocketHandshakeReceivedAsServer(WebSocket paramWebSocket, Draft paramDraft, ClientHandshake paramClientHandshake)
  {
    return new HandshakeImpl1Server();
  }
  
  public void onWebsocketHandshakeSentAsClient(WebSocket paramWebSocket, ClientHandshake paramClientHandshake) {}
  
  public void onWebsocketPing(WebSocket paramWebSocket, Framedata paramFramedata)
  {
    paramWebSocket.sendFrame(new PongFrame((PingFrame)paramFramedata));
  }
  
  public void onWebsocketPong(WebSocket paramWebSocket, Framedata paramFramedata) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.java_websocket.WebSocketAdapter
 * JD-Core Version:    0.7.0.1
 */