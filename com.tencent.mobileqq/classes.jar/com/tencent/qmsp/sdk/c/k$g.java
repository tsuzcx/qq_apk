package com.tencent.qmsp.sdk.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

class k$g
  extends Handler
{
  public k$g(k paramk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            paramMessage = paramMessage.obj;
            if (paramMessage != null) {
              k.a(this.a, (k.e)paramMessage);
            }
          }
          else
          {
            k.d(this.a);
          }
        }
        else {
          k.c(this.a);
        }
      }
      else
      {
        paramMessage = paramMessage.obj;
        if (paramMessage != null) {
          k.a(this.a, (List)paramMessage);
        }
      }
    }
    else {
      k.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.k.g
 * JD-Core Version:    0.7.0.1
 */