package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicReference;

public class Cranberry$do
  extends Handler
{
  public Context a;
  
  public Cranberry$do(Cranberry paramCranberry, Looper paramLooper, Context paramContext)
  {
    super(paramLooper);
    this.a = paramContext;
  }
  
  public void handleMessage(Message arg1)
  {
    System.currentTimeMillis();
    int i = ???.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      i = ((Integer)???.obj).intValue();
      ??? = this.b.a(this.a, true, false, i);
      this.b.a(???, false);
      synchronized (this.b.j)
      {
        this.b.j.set(Boolean.FALSE);
        this.b.j.notifyAll();
        return;
      }
    }
    this.b.a(this.a, true, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Cranberry.do
 * JD-Core Version:    0.7.0.1
 */