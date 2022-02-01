package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class Carambola$do
  extends Handler
{
  public Context a;
  
  public Carambola$do(Looper paramLooper, Context paramContext)
  {
    super(paramLooper);
    this.a = paramContext;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    try
    {
      Carambola.a(this.a);
      label16:
      sendEmptyMessageDelayed(1, Carambola.f);
      return;
    }
    finally
    {
      break label16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Carambola.do
 * JD-Core Version:    0.7.0.1
 */