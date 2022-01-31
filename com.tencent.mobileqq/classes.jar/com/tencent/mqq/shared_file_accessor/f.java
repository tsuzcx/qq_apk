package com.tencent.mqq.shared_file_accessor;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;

final class f
{
  private final HandlerThread a = new HandlerThread("pref-queue-work-thread", -2);
  private final Handler b;
  private final LinkedList c = new LinkedList();
  private final Object d = new Object();
  private final Object e = new Object();
  
  private f()
  {
    this.a.start();
    this.b = new h(this, this.a.getLooper());
  }
  
  public final void a(Runnable paramRunnable)
  {
    synchronized (this.d)
    {
      if (!this.c.contains(paramRunnable)) {
        this.c.add(paramRunnable);
      }
      this.b.sendEmptyMessage(0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.f
 * JD-Core Version:    0.7.0.1
 */