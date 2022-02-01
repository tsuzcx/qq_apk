package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.o;

public final class m
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  private static final HandlerThread b;
  private static final Handler c = new n(b.getLooper());
  
  static
  {
    HandlerThread localHandlerThread = new HandlerThread("push_client_thread");
    b = localHandlerThread;
    localHandlerThread.start();
  }
  
  public static void a(l paraml)
  {
    if (paraml == null)
    {
      o.a("PushClientThread", "client thread error, task is null!");
      return;
    }
    int i = paraml.a();
    Message localMessage = new Message();
    localMessage.what = i;
    localMessage.obj = paraml;
    c.sendMessageDelayed(localMessage, 0L);
  }
  
  public static void a(Runnable paramRunnable)
  {
    c.removeCallbacks(paramRunnable);
    c.postDelayed(paramRunnable, 15000L);
  }
  
  public static void b(Runnable paramRunnable)
  {
    a.post(paramRunnable);
  }
  
  public static void c(Runnable paramRunnable)
  {
    Handler localHandler = c;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.m
 * JD-Core Version:    0.7.0.1
 */