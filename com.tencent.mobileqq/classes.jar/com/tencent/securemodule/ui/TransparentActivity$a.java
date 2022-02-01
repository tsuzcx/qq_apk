package com.tencent.securemodule.ui;

import android.os.Handler;
import android.os.Message;
import com.qq.jce.wup.UniAttribute;
import com.tencent.securemodule.ar;
import com.tencent.securemodule.az;
import com.tencent.securemodule.service.IControlService;

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
    try
    {
      int i = this.b;
      Message localMessage;
      if (i < 5)
      {
        try
        {
          Thread.sleep(2000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        localMessage = TransparentActivity.c(this.a).obtainMessage(4);
        localMessage.arg1 = (this.b + 1);
      }
      for (Handler localHandler = TransparentActivity.c(this.a);; localHandler = TransparentActivity.c(this.a))
      {
        localHandler.sendMessage(localMessage);
        break;
        localMessage = TransparentActivity.c(this.a).obtainMessage(2);
        localMessage.arg1 = 0;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void run()
  {
    int j = 0;
    int i = j;
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
      localThrowable.printStackTrace();
      i = j;
    }
    if (i == 0) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.ui.TransparentActivity.a
 * JD-Core Version:    0.7.0.1
 */