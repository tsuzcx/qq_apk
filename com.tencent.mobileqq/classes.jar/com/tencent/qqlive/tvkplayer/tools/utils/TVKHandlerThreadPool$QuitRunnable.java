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
    TVKLogUtil.i("TVKHandlerThreadPool", "handlerThread obtain:" + this.mHandlerThread.getName() + "::quit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKHandlerThreadPool.QuitRunnable
 * JD-Core Version:    0.7.0.1
 */