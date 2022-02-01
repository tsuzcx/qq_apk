package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicReference;

public class UrsaMajor$do
  extends Handler
{
  public Context mContext;
  
  public UrsaMajor$do(UrsaMajor paramUrsaMajor, Looper paramLooper, Context paramContext)
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
      ??? = UrsaMajor.a(this.this$0, this.mContext, true, false, true);
      UrsaMajor.a(this.this$0, ???, false);
      synchronized (UrsaMajor.c(this.this$0))
      {
        UrsaMajor.c(this.this$0).set(Boolean.valueOf(false));
        UrsaMajor.c(this.this$0).notifyAll();
        return;
      }
    }
    UrsaMajor.a(this.this$0, this.mContext, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.UrsaMajor.do
 * JD-Core Version:    0.7.0.1
 */