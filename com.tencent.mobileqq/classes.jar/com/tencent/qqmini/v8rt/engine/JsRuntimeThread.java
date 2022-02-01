package com.tencent.qqmini.v8rt.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

public class JsRuntimeThread
  implements Handler.Callback
{
  private static final String HANDLER_THREAD_NAME = "JsRuntimeThread";
  public static final int MSG_EXEC = 2;
  public static final int MSG_RELEASE = 3;
  public final String LOG_TAG;
  private boolean isRelease = false;
  private Handler mHandler;
  private HandlerThread mHandlerThread = new HandlerThread("JsRuntimeThread");
  
  public JsRuntimeThread(int paramInt)
  {
    this.mHandlerThread.start();
    this.LOG_TAG = ("JsRT-" + paramInt);
    this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
  }
  
  private void releaseInternal()
  {
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandlerThread.quit();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      releaseInternal();
    }
  }
  
  public boolean isReleased()
  {
    return this.isRelease;
  }
  
  public void release()
  {
    Logger.i(this.LOG_TAG, "release");
    this.isRelease = true;
    this.mHandler.sendEmptyMessage(3);
  }
  
  public void run(V8JsContext paramV8JsContext, Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.JsRuntimeThread
 * JD-Core Version:    0.7.0.1
 */