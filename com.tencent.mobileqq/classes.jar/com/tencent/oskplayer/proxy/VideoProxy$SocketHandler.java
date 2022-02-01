package com.tencent.oskplayer.proxy;

import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

final class VideoProxy$SocketHandler
  implements Runnable
{
  CountDownLatch signal;
  Socket socket;
  Future<?> task;
  VideoRequest videoRequest;
  
  public VideoProxy$SocketHandler(VideoProxy paramVideoProxy, Socket paramSocket, CountDownLatch paramCountDownLatch)
  {
    this.socket = paramSocket;
    this.signal = paramCountDownLatch;
  }
  
  public void run()
  {
    try
    {
      this.signal.await();
      this.videoRequest = new VideoRequest();
      this.videoRequest.setTask(this.task);
      VideoProxy.access$200(this.this$0, this.socket, this.videoRequest);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public void setTask(Future<?> paramFuture)
  {
    this.task = paramFuture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoProxy.SocketHandler
 * JD-Core Version:    0.7.0.1
 */