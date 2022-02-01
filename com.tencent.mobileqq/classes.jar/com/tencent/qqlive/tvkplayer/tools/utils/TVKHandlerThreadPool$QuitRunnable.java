package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.HandlerThread;

class TVKHandlerThreadPool$QuitRunnable
  implements Runnable
{
  HandlerThread mHandlerThread;
  
  public TVKHandlerThreadPool$QuitRunnable(HandlerThread paramHandlerThread)
  {
    this.mHandlerThread = paramHandlerThread;
  }
  
  public void run()
  {
    TVKHandlerThreadPool.getInstance().quitThread(this.mHandlerThread);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handlerThread obtain:");
    localStringBuilder.append(this.mHandlerThread.getName());
    localStringBuilder.append("::quit");
    TVKLogUtil.i("TVKHandlerThreadPool", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKHandlerThreadPool.QuitRunnable
 * JD-Core Version:    0.7.0.1
 */