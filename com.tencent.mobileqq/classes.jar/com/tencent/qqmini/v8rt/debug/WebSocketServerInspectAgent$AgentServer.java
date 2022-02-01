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
    Logger.w("WebSocketServerInspectAgent", "Debugger disconnected " + paramString + " " + paramWebSocket);
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
      Logger.i("WebSocketServerInspectAgent", "<< " + paramString);
    }
  }
  
  public void onOpen(WebSocket paramWebSocket, ClientHandshake paramClientHandshake)
  {
    WebSocketServerInspectAgent.access$002(this.this$0, paramWebSocket);
    Logger.w("WebSocketServerInspectAgent", "Debugger connected " + paramWebSocket);
  }
  
  public void onStart()
  {
    Logger.i("WebSocketServerInspectAgent", "ScriptEngine Inspector Debugger server successfully started on port:" + this.mPort + "\nfollow the steps to start debug:\n1. adb forward tcp:" + this.mPort + " tcp:" + this.mPort + "\n2. open chrome with url to start inspect\nchrome-devtools://devtools/bundled/js_app.html?ws=localhost:" + this.mPort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.debug.WebSocketServerInspectAgent.AgentServer
 * JD-Core Version:    0.7.0.1
 */