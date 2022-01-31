package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicReference;

public class switch$do
  extends Handler
{
  public Context mContext;
  
  public switch$do(switch paramswitch, Looper paramLooper, Context paramContext)
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
      ??? = switch.a(this.this$0, this.mContext, true, false, true);
      switch.a(this.this$0, ???, false);
      synchronized (switch.b(this.this$0))
      {
        switch.b(this.this$0).set(Boolean.valueOf(false));
        switch.b(this.this$0).notifyAll();
        return;
      }
    }
    switch.a(this.this$0, this.mContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.switch.do
 * JD-Core Version:    0.7.0.1
 */