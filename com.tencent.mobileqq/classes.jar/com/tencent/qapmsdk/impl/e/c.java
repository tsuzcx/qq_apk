package com.tencent.qapmsdk.impl.e;

import android.os.Handler;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.socket.c.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c
{
  static volatile boolean a = false;
  private static volatile c b = null;
  private final ConcurrentLinkedQueue<a> c = new ConcurrentLinkedQueue();
  private final ConcurrentLinkedQueue<a> d = new ConcurrentLinkedQueue();
  
  public static c a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new c();
      }
      return b;
    }
    finally {}
  }
  
  public void a(a parama)
  {
    if (this.d.size() > 40) {
      this.d.poll();
    }
    this.d.add(parama);
  }
  
  public ConcurrentLinkedQueue<a> b()
  {
    return this.d;
  }
  
  public void b(a parama)
  {
    if (this.c.size() > 40) {
      this.c.poll();
    }
    this.c.add(parama);
  }
  
  public ConcurrentLinkedQueue<a> c()
  {
    return this.c;
  }
  
  public void d()
  {
    if (!a)
    {
      new Handler(ThreadManager.getMonitorThreadLooper()).postDelayed(d.a(), 60000L);
      a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.e.c
 * JD-Core Version:    0.7.0.1
 */