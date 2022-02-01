package com.tencent.mtt.hippy.b;

import android.util.Log;
import java.net.Socket;

class d$2
  implements Runnable
{
  d$2(d paramd) {}
  
  public void run()
  {
    if (d.c(this.a) != null) {}
    try
    {
      d.c(this.a).close();
      d.f(this.a).a(0, "closed");
      d.a(this.a, null);
      d.a(this.a, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.d("WebSocketClient", "Error while disconnecting", localThrowable);
        d.f(this.a).a(new Exception(localThrowable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.b.d.2
 * JD-Core Version:    0.7.0.1
 */