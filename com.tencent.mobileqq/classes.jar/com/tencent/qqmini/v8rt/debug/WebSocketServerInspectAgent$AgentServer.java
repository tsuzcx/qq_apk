package com.tencent.qqmini.v8rt.debug;

import com.tencent.qqmini.v8rt.engine.IInspectorAgent.IDebuggerMessageListener;
import com.tencent.qqmini.v8rt.engine.Logger;
import java.net.InetSocketAddress;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

class WebSocketServerInspectAgent$AgentServer
  extends WebSocketServer
{
  private final int mPort;
  
  WebSocketServerInspectAgent$AgentServer(WebSocketServerInspectAgent paramWebSocketServerInspectAgent, int paramInt)
  {
    super(new InetSocketAddress(paramInt));
    setReuseAddr(true);
    this.mPort = paramInt;
    setConnectionLostTimeout(2147483647);
  }
  
  public void onClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Debugger disconnected ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramWebSocket);
    Logger.w("WebSocketServerInspectAgent", localStringBuilder.toString());
    WebSocketServerInspectAgent.access$002(this.this$0, null);
  }
  
  public void onError(WebSocket paramWebSocket, Exception paramException)
  {
    WebSocketServerInspectAgent.access$002(this.this$0, null);
    Logger.w("WebSocketServerInspectAgent", "ScriptEngine Inspector Debugger server failed", paramException);
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    if (WebSocketServerInspectAgent.access$100(this.this$0) != null)
    {
      WebSocketServerInspectAgent.access$100(this.this$0).sendMessageToEngine(paramString);
      paramWebSocket = new StringBuilder();
      paramWebSocket.append("<< ");
      paramWebSocket.append(paramString);
      Logger.i("WebSocketServerInspectAgent", paramWebSocket.toString());
    }
  }
  
  public void onOpen(WebSocket paramWebSocket, ClientHandshake paramClientHandshake)
  {
    WebSocketServerInspectAgent.access$002(this.this$0, paramWebSocket);
    paramClientHandshake = new StringBuilder();
    paramClientHandshake.append("Debugger connected ");
    paramClientHandshake.append(paramWebSocket);
    Logger.w("WebSocketServerInspectAgent", paramClientHandshake.toString());
  }
  
  public void onStart()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScriptEngine Inspector Debugger server successfully started on port:");
    localStringBuilder.append(this.mPort);
    localStringBuilder.append("\nfollow the steps to start debug:\n1. adb forward tcp:");
    localStringBuilder.append(this.mPort);
    localStringBuilder.append(" tcp:");
    localStringBuilder.append(this.mPort);
    localStringBuilder.append("\n2. open chrome with url to start inspect\nchrome-devtools://devtools/bundled/js_app.html?ws=localhost:");
    localStringBuilder.append(this.mPort);
    Logger.i("WebSocketServerInspectAgent", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.debug.WebSocketServerInspectAgent.AgentServer
 * JD-Core Version:    0.7.0.1
 */