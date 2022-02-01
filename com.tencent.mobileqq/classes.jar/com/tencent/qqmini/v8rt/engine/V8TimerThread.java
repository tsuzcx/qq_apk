package com.tencent.qqmini.v8rt.engine;

import java.util.concurrent.atomic.AtomicInteger;

public class V8TimerThread
  extends Thread
{
  public static final String LOG_TAG = "V8Timer";
  private V8TimerThread.IListener mListener;
  private final AtomicInteger mPendingVSyncCount = new AtomicInteger();
  
  public V8TimerThread(V8TimerThread.IListener paramIListener)
  {
    this.mListener = paramIListener;
    setPriority(10);
  }
  
  public void run()
  {
    if (this.mListener == null) {
      return;
    }
    this.mListener.onPrepare();
    try
    {
      boolean bool;
      do
      {
        bool = Engine.runLoop();
      } while (!bool);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("V8Timer", "run error " + localException.getMessage());
      }
    }
    Logger.e("V8Timer", "run exit");
    this.mListener.onExit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.V8TimerThread
 * JD-Core Version:    0.7.0.1
 */