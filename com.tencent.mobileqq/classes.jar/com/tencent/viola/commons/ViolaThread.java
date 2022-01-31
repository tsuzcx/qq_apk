package com.tencent.viola.commons;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;

public class ViolaThread
  extends HandlerThread
{
  private Handler mHandler;
  
  public ViolaThread(String paramString, Handler.Callback paramCallback)
  {
    super(paramString);
    start();
    this.mHandler = new Handler(getLooper(), secure(paramCallback));
  }
  
  public static Handler.Callback secure(Handler.Callback paramCallback)
  {
    if ((paramCallback == null) || ((paramCallback instanceof ViolaThread.SafeCallback))) {
      return paramCallback;
    }
    return new ViolaThread.SafeCallback(paramCallback);
  }
  
  public static Runnable secure(Runnable paramRunnable)
  {
    if ((paramRunnable == null) || ((paramRunnable instanceof ViolaThread.SafeRunnable))) {
      return paramRunnable;
    }
    return new ViolaThread.SafeRunnable(paramRunnable);
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public boolean isThreadAlive()
  {
    return (this.mHandler != null) && (getLooper() != null) && (isAlive());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.commons.ViolaThread
 * JD-Core Version:    0.7.0.1
 */