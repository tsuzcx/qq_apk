package com.tencent.securemodule.ui;

import android.os.Handler;
import android.os.Message;
import com.qq.jce.wup.UniAttribute;
import com.tencent.securemodule.service.IControlService;
import sm.ar;
import sm.az;

public class TransparentActivity$a
  extends Thread
  implements Runnable
{
  private int b;
  
  public TransparentActivity$a(TransparentActivity paramTransparentActivity, int paramInt)
  {
    this.b = paramInt;
  }
  
  private void a()
  {
    for (;;)
    {
      try
      {
        int i = this.b;
        if (i < 5) {
          try
          {
            Thread.sleep(2000L);
            Message localMessage1 = TransparentActivity.c(this.a).obtainMessage(4);
            localMessage1.arg1 = (this.b + 1);
            TransparentActivity.c(this.a).sendMessage(localMessage1);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            continue;
          }
        }
        localMessage2 = TransparentActivity.c(this.a).obtainMessage(2);
      }
      finally {}
      Message localMessage2;
      localMessage2.arg1 = 0;
      TransparentActivity.c(this.a).sendMessage(localMessage2);
    }
  }
  
  public void run()
  {
    j = 0;
    i = j;
    try
    {
      if (TransparentActivity.d(this.a) != null)
      {
        Object localObject = new UniAttribute();
        ((UniAttribute)localObject).setEncodeName("UTF-8");
        ((UniAttribute)localObject).put("data", TransparentActivity.e(this.a));
        localObject = ((UniAttribute)localObject).encode();
        if (localObject != null) {
          TransparentActivity.d(this.a).doRemoteTask(az.a((byte[])localObject), new ar(this));
        }
        i = 1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        i = j;
      }
    }
    if (i == 0) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.securemodule.ui.TransparentActivity.a
 * JD-Core Version:    0.7.0.1
 */