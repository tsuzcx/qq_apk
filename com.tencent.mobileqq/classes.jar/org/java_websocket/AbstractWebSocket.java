package org.java_websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractWebSocket
  extends WebSocketAdapter
{
  private static final Logger log = LoggerFactory.getLogger(AbstractWebSocket.class);
  private int connectionLostTimeout = 60;
  private Timer connectionLostTimer;
  private TimerTask connectionLostTimerTask;
  private boolean reuseAddr;
  private final Object syncConnectionLost = new Object();
  private boolean tcpNoDelay;
  private boolean websocketRunning = false;
  
  private void cancelConnectionLostTimer()
  {
    if (this.connectionLostTimer != null)
    {
      this.connectionLostTimer.cancel();
      this.connectionLostTimer = null;
    }
    if (this.connectionLostTimerTask != null)
    {
      this.connectionLostTimerTask.cancel();
      this.connectionLostTimerTask = null;
    }
  }
  
  private void executeConnectionLostDetection(WebSocket paramWebSocket, long paramLong)
  {
    if (!(paramWebSocket instanceof WebSocketImpl)) {
      return;
    }
    paramWebSocket = (WebSocketImpl)paramWebSocket;
    if (paramWebSocket.getLastPong() < paramLong)
    {
      log.trace("Closing connection due to no pong received: {}", paramWebSocket);
      paramWebSocket.closeConnection(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
      return;
    }
    if (paramWebSocket.isOpen())
    {
      paramWebSocket.sendPing();
      return;
    }
    log.trace("Trying to ping a non open connection: {}", paramWebSocket);
  }
  
  private void restartConnectionLostTimer()
  {
    cancelConnectionLostTimer();
    this.connectionLostTimer = new Timer("WebSocketTimer");
    this.connectionLostTimerTask = new AbstractWebSocket.1(this);
    this.connectionLostTimer.scheduleAtFixedRate(this.connectionLostTimerTask, this.connectionLostTimeout * 1000L, this.connectionLostTimeout * 1000L);
  }
  
  public int getConnectionLostTimeout()
  {
    synchronized (this.syncConnectionLost)
    {
      int i = this.connectionLostTimeout;
      return i;
    }
  }
  
  protected abstract Collection<WebSocket> getConnections();
  
  public boolean isReuseAddr()
  {
    return this.reuseAddr;
  }
  
  public boolean isTcpNoDelay()
  {
    return this.tcpNoDelay;
  }
  
  public void setConnectionLostTimeout(int paramInt)
  {
    synchronized (this.syncConnectionLost)
    {
      this.connectionLostTimeout = paramInt;
      if (this.connectionLostTimeout <= 0)
      {
        log.trace("Connection lost timer stopped");
        cancelConnectionLostTimer();
        return;
      }
      if (this.websocketRunning)
      {
        log.trace("Connection lost timer restarted");
        try
        {
          Iterator localIterator = new ArrayList(getConnections()).iterator();
          while (localIterator.hasNext())
          {
            WebSocket localWebSocket = (WebSocket)localIterator.next();
            if ((localWebSocket instanceof WebSocketImpl)) {
              ((WebSocketImpl)localWebSocket).updateLastPong();
            }
          }
        }
        catch (Exception localException)
        {
          log.error("Exception during connection lost restart", localException);
          restartConnectionLostTimer();
        }
      }
      return;
    }
  }
  
  public void setReuseAddr(boolean paramBoolean)
  {
    this.reuseAddr = paramBoolean;
  }
  
  public void setTcpNoDelay(boolean paramBoolean)
  {
    this.tcpNoDelay = paramBoolean;
  }
  
  protected void startConnectionLostTimer()
  {
    synchronized (this.syncConnectionLost)
    {
      if (this.connectionLostTimeout <= 0)
      {
        log.trace("Connection lost timer deactivated");
        return;
      }
      log.trace("Connection lost timer started");
      this.websocketRunning = true;
      restartConnectionLostTimer();
      return;
    }
  }
  
  protected void stopConnectionLostTimer()
  {
    synchronized (this.syncConnectionLost)
    {
      if ((this.connectionLostTimer != null) || (this.connectionLostTimerTask != null))
      {
        this.websocketRunning = false;
        log.trace("Connection lost timer stopped");
        cancelConnectionLostTimer();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.java_websocket.AbstractWebSocket
 * JD-Core Version:    0.7.0.1
 */