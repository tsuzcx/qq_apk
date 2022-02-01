package com.tencent.mobileqq.minigame.utils.thread;

import android.os.Handler;
import android.os.HandlerThread;

public class TTHandleThread
  extends HandlerThread
{
  private static Handler handler;
  private static volatile TTHandleThread instance;
  
  private TTHandleThread(String paramString)
  {
    super(paramString);
  }
  
  public static Handler getHandler()
  {
    return handler;
  }
  
  public static TTHandleThread getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null)
        {
          TTHandleThread localTTHandleThread = new TTHandleThread("TTIOThread");
          localTTHandleThread.start();
          handler = new Handler(localTTHandleThread.getLooper());
          instance = localTTHandleThread;
        }
      }
      finally {}
    }
    return instance;
  }
  
  public final void post(Runnable paramRunnable)
  {
    handler.post(paramRunnable);
  }
  
  public final void postDelayed(Runnable paramRunnable, long paramLong)
  {
    handler.postDelayed(paramRunnable, paramLong);
  }
  
  public final void remove(Runnable paramRunnable)
  {
    handler.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.thread.TTHandleThread
 * JD-Core Version:    0.7.0.1
 */