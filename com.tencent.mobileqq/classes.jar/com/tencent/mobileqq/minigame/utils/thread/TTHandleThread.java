package com.tencent.mobileqq.minigame.utils.thread;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;

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
    if (instance == null) {}
    try
    {
      if (instance == null)
      {
        TTHandleThread localTTHandleThread = new TTHandleThread("TTIOThread");
        localTTHandleThread.start();
        handler = new Handler(localTTHandleThread.getLooper());
        instance = localTTHandleThread;
      }
      return instance;
    }
    finally {}
  }
  
  public final void execute(Runnable paramRunnable)
  {
    ThreadManager.excute(paramRunnable, 16, null, false);
  }
  
  public final void execute(Runnable paramRunnable, ThreadExcutor.IThreadListener paramIThreadListener)
  {
    ThreadManager.excute(paramRunnable, 128, paramIThreadListener, false);
  }
  
  public final void execute_FILE(Runnable paramRunnable)
  {
    ThreadManager.excute(paramRunnable, 64, null, false);
  }
  
  public final void execute_NETWORK(Runnable paramRunnable)
  {
    ThreadManager.excute(paramRunnable, 128, null, false);
  }
  
  public final void post(Runnable paramRunnable)
  {
    handler.post(paramRunnable);
  }
  
  public final void postDelayed(Runnable paramRunnable, long paramLong)
  {
    handler.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.thread.TTHandleThread
 * JD-Core Version:    0.7.0.1
 */