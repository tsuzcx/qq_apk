package com.tencent.qqmini.v8rt.debug;

import com.tencent.qqmini.v8rt.anno.NotNull;
import com.tencent.qqmini.v8rt.anno.Nullable;
import com.tencent.qqmini.v8rt.engine.IInspectorAgent;
import com.tencent.qqmini.v8rt.engine.IInspectorAgent.IDebuggerMessageListener;
import com.tencent.qqmini.v8rt.engine.Logger;
import java.io.IOException;
import org.java_websocket.WebSocket;

public class WebSocketServerInspectAgent
  implements IInspectorAgent
{
  private static final boolean DEBUG = true;
  private static final int DEFAULT_SERVER_PORT = 5678;
  private static final String TAG = "WebSocketServerInspectAgent";
  private final WebSocketServerInspectAgent.AgentServer mAgentServer = new WebSocketServerInspectAgent.AgentServer(this, 5678);
  private IInspectorAgent.IDebuggerMessageListener mDebuggerMessageListener;
  private boolean mWaitForDebugger = false;
  private WebSocket mWebSocket;
  
  public WebSocketServerInspectAgent(boolean paramBoolean)
  {
    this.mAgentServer.start();
    this.mWaitForDebugger = paramBoolean;
  }
  
  public boolean isWaitForDebugger()
  {
    return this.mWaitForDebugger;
  }
  
  public void sendMessageToDebugger(@NotNull String paramString)
  {
    if (this.mWebSocket != null)
    {
      this.mWebSocket.send(paramString);
      Logger.i("WebSocketServerInspectAgent", ">> " + paramString);
    }
  }
  
  public void setOnDebuggerMessageListener(@Nullable IInspectorAgent.IDebuggerMessageListener paramIDebuggerMessageListener)
  {
    this.mDebuggerMessageListener = paramIDebuggerMessageListener;
  }
  
  public void stop()
  {
    try
    {
      if (this.mWebSocket != null) {
        this.mWebSocket.close();
      }
      this.mAgentServer.stop();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.debug.WebSocketServerInspectAgent
 * JD-Core Version:    0.7.0.1
 */