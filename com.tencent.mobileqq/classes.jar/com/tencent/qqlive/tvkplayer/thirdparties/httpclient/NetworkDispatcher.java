package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher
  extends Thread
{
  private final ResponseDelivery mDelivery;
  private final Network mNetwork;
  private final BlockingQueue<Request> mQueue;
  private volatile boolean mQuit = false;
  
  public NetworkDispatcher(BlockingQueue<Request> paramBlockingQueue, Network paramNetwork, ResponseDelivery paramResponseDelivery)
  {
    this.mQueue = paramBlockingQueue;
    this.mNetwork = paramNetwork;
    this.mDelivery = paramResponseDelivery;
    setName("TVK_NetworkDispatcher");
  }
  
  @TargetApi(14)
  private void addTrafficStatsTag(Request paramRequest)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      TrafficStats.setThreadStatsTag(paramRequest.getTrafficStatsTag());
    }
  }
  
  private void processRequest()
  {
    processRequest((Request)this.mQueue.take());
  }
  
  @VisibleForTesting
  void processRequest(Request paramRequest)
  {
    try
    {
      if (paramRequest.isCanceled())
      {
        paramRequest.finish();
        return;
      }
      addTrafficStatsTag(paramRequest);
      Response localResponse = this.mNetwork.performRequest(paramRequest);
      this.mDelivery.postResponse(paramRequest, localResponse);
      return;
    }
    catch (IOException localIOException)
    {
      this.mDelivery.postError(paramRequest, localIOException);
    }
  }
  
  public void quit()
  {
    this.mQuit = true;
    interrupt();
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    try
    {
      for (;;)
      {
        processRequest();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      if (this.mQuit)
      {
        Thread.currentThread().interrupt();
        return;
      }
      Log.e("NetworkDispatcher", "Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.NetworkDispatcher
 * JD-Core Version:    0.7.0.1
 */