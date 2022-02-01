package com.tencent.qmsp.sdk.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qmsp.sdk.f.g;

class f$c
  extends Handler
{
  f$c(f paramf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      long l = Long.parseLong((String)paramMessage.obj);
      int i = paramMessage.what;
      if ((i == 1) && (l != 0L))
      {
        g.a("Qp.QFW", 1, String.format("handle native msg for cookie: %08X", new Object[] { Long.valueOf(l) }));
        f.a(6L, l, 0L, 0L, null, null, null, null);
        return;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.f.c
 * JD-Core Version:    0.7.0.1
 */