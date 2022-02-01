package com.vivo.push;

import android.os.Handler.Callback;
import android.os.Message;
import com.vivo.push.util.o;
import java.util.concurrent.atomic.AtomicInteger;

final class c
  implements Handler.Callback
{
  c(b paramb) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      o.a("AidlManager", "handleMessage error : msg is null");
      return false;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        StringBuilder localStringBuilder = new StringBuilder("unknow msg what [");
        localStringBuilder.append(paramMessage.what);
        localStringBuilder.append("]");
        o.b("AidlManager", localStringBuilder.toString());
        return true;
      }
      if (b.a(this.a).get() == 4) {
        b.c(this.a);
      }
      b.b(this.a);
      return true;
    }
    o.a("AidlManager", "In connect, bind core service time out");
    if (b.a(this.a).get() == 2) {
      b.b(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c
 * JD-Core Version:    0.7.0.1
 */