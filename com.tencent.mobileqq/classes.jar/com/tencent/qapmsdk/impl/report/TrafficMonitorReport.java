package com.tencent.qapmsdk.impl.report;

import android.os.Handler;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TrafficMonitorReport
{
  private static final int QUEUELEN = 40;
  static volatile boolean hasReport = false;
  private static volatile TrafficMonitorReport instance = null;
  private final ConcurrentLinkedQueue<SocketInfo> httpQueue = new ConcurrentLinkedQueue();
  private final ConcurrentLinkedQueue<SocketInfo> socketQueue = new ConcurrentLinkedQueue();
  
  public static TrafficMonitorReport getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new TrafficMonitorReport();
      }
      return instance;
    }
    finally {}
  }
  
  public void addHttpToQueue(SocketInfo paramSocketInfo)
  {
    if (this.httpQueue.size() > 40) {
      this.httpQueue.poll();
    }
    this.httpQueue.add(paramSocketInfo);
  }
  
  public void addSocketToQueue(SocketInfo paramSocketInfo)
  {
    if (this.socketQueue.size() > 40) {
      this.socketQueue.poll();
    }
    this.socketQueue.add(paramSocketInfo);
  }
  
  public void doReport()
  {
    if (!hasReport)
    {
      new Handler(ThreadManager.getMonitorThreadLooper()).postDelayed(TrafficReportRunnable.getInstance(), 60000L);
      hasReport = true;
    }
  }
  
  public ConcurrentLinkedQueue<SocketInfo> getHttpQueue()
  {
    return this.httpQueue;
  }
  
  public ConcurrentLinkedQueue<SocketInfo> getSocketToQueue()
  {
    return this.socketQueue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.report.TrafficMonitorReport
 * JD-Core Version:    0.7.0.1
 */