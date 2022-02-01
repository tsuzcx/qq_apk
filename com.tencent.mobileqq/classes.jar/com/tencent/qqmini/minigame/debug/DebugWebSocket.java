package com.tencent.qqmini.minigame.debug;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DebugWebSocket
{
  protected static String TAG = "[debugger].DebugWebSocket";
  private static final int maxMessageCount = 64;
  protected static Handler sDebuggerHandler;
  protected static HandlerThread sDebuggerHandlerThread;
  protected static Handler sHandler;
  protected static HandlerThread sHandlerThread;
  private boolean canSendMsg = false;
  private int currentWebSocketId;
  private WebSocketProxy.WebSocketListener listener = new DebugWebSocket.1(this);
  protected DebugWebSocket.DebugSocketListener mOutListener;
  private ArrayList<String> sendingMessages = new ArrayList();
  private Runnable socketMsgRunnable = new DebugWebSocket.3(this);
  private WebSocketProxy webSocketProxy = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
  
  private Handler getDebugHandler()
  {
    if ((sDebuggerHandler == null) || (!sDebuggerHandlerThread.isAlive()))
    {
      sDebuggerHandlerThread = new HandlerThread("minigame_debugger", 10);
      sDebuggerHandlerThread.start();
      sDebuggerHandler = new Handler(sDebuggerHandlerThread.getLooper());
    }
    return sDebuggerHandler;
  }
  
  private Handler getSocketHandler()
  {
    if ((sHandler == null) || (!sHandlerThread.isAlive()))
    {
      sHandlerThread = new HandlerThread("minigame_socket", 10);
      sHandlerThread.start();
      sHandler = new Handler(sHandlerThread.getLooper());
    }
    return sHandler;
  }
  
  public void closeWebSocket(int paramInt, String paramString)
  {
    this.webSocketProxy.closeSocket(999, paramInt, paramString);
  }
  
  public void connect(String paramString, DebugWebSocket.DebugSocketListener paramDebugSocketListener)
  {
    this.currentWebSocketId = WebSocketProxy.getWebSocketRequestId();
    this.webSocketProxy.connectSocket(this.currentWebSocketId, paramString, null, null, 120000, this.listener);
    this.mOutListener = paramDebugSocketListener;
  }
  
  public void destroy() {}
  
  protected void excuteSocketMsg()
  {
    if (this.sendingMessages.size() > 0)
    {
      Iterator localIterator = this.sendingMessages.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.canSendMsg)
        {
          try
          {
            this.webSocketProxy.send(this.currentWebSocketId, str);
            localIterator.remove();
          }
          catch (Exception localException)
          {
            QMLog.e(TAG, "sendStringMessage", localException);
            handleSocketException(localException);
          }
        }
        else
        {
          Handler localHandler = getSocketHandler();
          if (localHandler != null)
          {
            localHandler.removeCallbacks(this.socketMsgRunnable);
            localHandler.postDelayed(this.socketMsgRunnable, 1000L);
          }
        }
      }
    }
  }
  
  protected void handleSocketException(Exception paramException) {}
  
  public boolean isCanSendMsg()
  {
    return this.canSendMsg;
  }
  
  protected void post(Runnable paramRunnable)
  {
    Handler localHandler = getDebugHandler();
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  protected void postDelayed(Runnable paramRunnable, long paramLong)
  {
    Handler localHandler = getDebugHandler();
    if (localHandler != null) {
      localHandler.postDelayed(paramRunnable, paramLong);
    }
  }
  
  protected void removeCallbacks(Runnable paramRunnable)
  {
    Handler localHandler = getDebugHandler();
    if (localHandler != null) {
      localHandler.removeCallbacks(paramRunnable);
    }
  }
  
  protected void sendStringMessage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Handler localHandler = getSocketHandler();
    if (localHandler != null) {
      localHandler.post(new DebugWebSocket.2(this, paramString));
    }
  }
  
  public void setCanSendMsg(boolean paramBoolean)
  {
    this.canSendMsg = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.debug.DebugWebSocket
 * JD-Core Version:    0.7.0.1
 */