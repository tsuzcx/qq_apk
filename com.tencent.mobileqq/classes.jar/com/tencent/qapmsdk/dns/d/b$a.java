package com.tencent.qapmsdk.dns.d;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qapmsdk.dns.a.a;
import com.tencent.qapmsdk.dns.a.b;
import java.net.InetAddress;

class b$a
  implements a.a
{
  private a.a a;
  private Handler b;
  
  void a(a.a parama)
  {
    try
    {
      this.a = parama;
      if ((parama != null) && (this.b == null))
      {
        parama = new HandlerThread("httpdns-callback");
        parama.start();
        this.b = new Handler(parama.getLooper());
      }
      return;
    }
    finally {}
  }
  
  public void a(a.b paramb, String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong)
  {
    a.a locala = this.a;
    Handler localHandler = this.b;
    if ((locala != null) && (localHandler != null)) {
      localHandler.post(new b.a.2(this, locala, paramb, paramString, paramArrayOfInetAddress, paramLong));
    }
  }
  
  public void a(boolean paramBoolean, Throwable paramThrowable)
  {
    a.a locala = this.a;
    Handler localHandler = this.b;
    if ((locala != null) && (localHandler != null)) {
      localHandler.post(new b.a.1(this, locala, paramBoolean, paramThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.d.b.a
 * JD-Core Version:    0.7.0.1
 */