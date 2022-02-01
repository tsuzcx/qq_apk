package com.tencent.mobileqq.minigame.debug;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class DebugWebSocket
{
  private static final int maxMessageCount = 64;
  protected static Handler sDebuggerHandler;
  protected static HandlerThread sDebuggerHandlerThread;
  protected static Handler sHandler;
  protected static HandlerThread sHandlerThread;
  private static final ThreadFactory sThreadFactory = new DebugWebSocket.2();
  private static Dispatcher sWebSocketDispatcher;
  private static ExecutorService sWebSocketExecutor;
  protected String TAG = "[debugger].DebugWebSocket";
  private boolean canSendMsg;
  private WebSocketListener listener = new DebugWebSocket.1(this);
  private OkHttpClient mOkHttpClient;
  protected DebugWebSocket.DebugSocketListener mOutListener;
  private WebSocket mWebSocket;
  private ArrayList<String> sendingMessages = new ArrayList();
  private Runnable socketMsgRunnable = new DebugWebSocket.4(this);
  
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
    if (this.mWebSocket != null) {}
    try
    {
      this.mWebSocket.close(paramInt, paramString);
      this.mWebSocket = null;
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void connect(String paramString, DebugWebSocket.DebugSocketListener paramDebugSocketListener)
  {
    if (this.mOkHttpClient == null)
    {
      OkHttpClient.Builder localBuilder = new OkHttpClient().newBuilder().retryOnConnectionFailure(true).connectTimeout(120L, TimeUnit.SECONDS).writeTimeout(120L, TimeUnit.SECONDS).readTimeout(120L, TimeUnit.SECONDS);
      if (sWebSocketExecutor == null) {
        sWebSocketExecutor = new ThreadPoolExecutor(0, 2147483647, 300L, TimeUnit.SECONDS, new SynchronousQueue(), sThreadFactory);
      }
      if (sWebSocketDispatcher == null) {
        sWebSocketDispatcher = new Dispatcher(sWebSocketExecutor);
      }
      localBuilder.dispatcher(sWebSocketDispatcher);
      this.mOkHttpClient = localBuilder.build();
    }
    paramString = new Request.Builder().url(paramString).build();
    this.mOkHttpClient.newWebSocket(paramString, this.listener);
    this.mOutListener = paramDebugSocketListener;
  }
  
  public void destroy()
  {
    if (this.mOkHttpClient != null)
    {
      this.mOkHttpClient.dispatcher().executorService().shutdown();
      this.mOkHttpClient = null;
    }
  }
  
  protected void excuteSocketMsg()
  {
    if (this.sendingMessages.size() > 0)
    {
      Iterator localIterator = this.sendingMessages.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        WebSocket localWebSocket = this.mWebSocket;
        if ((localWebSocket != null) && (this.canSendMsg))
        {
          try
          {
            MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
            localWebSocket.send(str);
            localIterator.remove();
          }
          catch (Exception localException)
          {
            QLog.e(this.TAG, 1, "sendStringMessage", localException);
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
    if (TextUtils.isEmpty(paramString)) {}
    Handler localHandler;
    do
    {
      return;
      localHandler = getSocketHandler();
    } while (localHandler == null);
    localHandler.post(new DebugWebSocket.3(this, paramString));
  }
  
  public void setCanSendMsg(boolean paramBoolean)
  {
    this.canSendMsg = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.debug.DebugWebSocket
 * JD-Core Version:    0.7.0.1
 */