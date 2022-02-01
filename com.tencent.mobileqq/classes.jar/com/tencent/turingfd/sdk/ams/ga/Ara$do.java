package com.tencent.turingfd.sdk.ams.ga;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicReference;

public class Ara$do
  extends Handler
{
  public Context mContext;
  
  public Ara$do(Ara paramAra, Looper paramLooper, Context paramContext)
  {
    super(paramLooper);
    this.mContext = paramContext;
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
      ??? = Ara.a(this.this$0, this.mContext, true, false, i);
      Ara.a(this.this$0, ???, false);
      synchronized (Ara.b(this.this$0))
      {
        Ara.b(this.this$0).set(Boolean.valueOf(false));
        Ara.b(this.this$0).notifyAll();
        return;
      }
    }
    Ara.b(this.this$0, this.mContext, true, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Ara.do
 * JD-Core Version:    0.7.0.1
 */