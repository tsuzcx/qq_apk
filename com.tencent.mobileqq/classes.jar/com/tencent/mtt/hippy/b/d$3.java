package com.tencent.mtt.hippy.b;

import java.io.OutputStream;
import java.net.Socket;

class d$3
  implements Runnable
{
  d$3(d paramd, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      synchronized (d.i(this.b))
      {
        OutputStream localOutputStream = d.c(this.b).getOutputStream();
        localOutputStream.write(this.a);
        localOutputStream.flush();
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      d.f(this.b).a(new Exception(localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.b.d.3
 * JD-Core Version:    0.7.0.1
 */