package com.tencent.qapmsdk.socket.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.TrafficMonitor;
import com.tencent.qapmsdk.socket.TrafficMonitor.a;
import com.tencent.qapmsdk.socket.c.c;
import com.tencent.qapmsdk.socket.d.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

class j$e
  implements f
{
  private String a;
  private String b;
  private j.i c;
  private boolean d;
  private boolean e;
  private boolean f;
  private j.e.a g = new j.e.a(this);
  
  public void a(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, com.tencent.qapmsdk.socket.c.a parama)
  {
    boolean bool;
    if ((this.d) || (TextUtils.isEmpty(this.a)) || ((parama.i != null) && (!parama.i.equals(this.b))))
    {
      this.d = false;
      this.b = parama.i;
      parama.a();
      this.a = j.a(parama);
      this.c = new j.i(true, parama);
      if ((parama.g == null) || (!parama.g.startsWith("HTTP/1"))) {
        break label623;
      }
      bool = true;
    }
    for (;;)
    {
      this.e = bool;
      label136:
      j.g localg;
      j.a locala;
      if ((parama.g != null) && (parama.g.startsWith("HTTP/2")))
      {
        bool = true;
        this.f = bool;
        parama.w += paramInt2;
        if ((TrafficMonitor.a().a()) && (paramInt2 > 0) && (this.e))
        {
          localg = this.c.a;
          locala = this.c.b;
          if (localg.h) {
            break label635;
          }
          localg.a(paramArrayOfByte, paramInt1, paramInt2);
          if (localg.h)
          {
            this.a = j.a(parama);
            locala.a = parama.A;
            parama = localg.j.toByteArray();
            locala.a(parama, localg.i, parama.length - localg.i);
          }
          if ((localg.h) && (locala.h) && (this.e))
          {
            Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "http1 write finish >>>> ", this.a });
            this.d = true;
          }
        }
        if ((TrafficMonitor.a().a()) && (paramInt2 > 0) && (this.f))
        {
          parama = new com.tencent.qapmsdk.socket.b.a(new ByteArrayInputStream(paramArrayOfByte));
          localg = this.c.a;
          locala = this.c.b;
        }
      }
      try
      {
        parama.a(new j.h(this.c));
        if ((localg.h) && (locala.h) && (this.f))
        {
          Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "http2 write finish >>>> ", this.a });
          this.d = true;
        }
        e.a(this.g.a(paramInt2), 500L);
        if ((TrafficMonitor.a().b()) && (!this.e))
        {
          if ((this.c != null) && (this.c.a() > 0) && (!this.f))
          {
            paramArrayOfByte = this.c.c();
            this.c.b();
            parama = paramArrayOfByte;
            if (!new c().a(paramArrayOfByte)) {
              parama = ("binary " + paramArrayOfByte.length + "-bytes body omitted").getBytes();
            }
            Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "write >>> [", this.a + "]\n", new String(parama) });
          }
        }
        else
        {
          return;
          label623:
          bool = false;
          continue;
          bool = false;
          break label136;
          label635:
          locala.a(paramArrayOfByte, paramInt1, paramInt2);
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficOutputStream", "http2 write failed >>> ", this.a });
          continue;
          parama = new byte[paramInt2];
          System.arraycopy(paramArrayOfByte, paramInt1, parama, 0, paramInt2);
          paramArrayOfByte = parama;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j.e
 * JD-Core Version:    0.7.0.1
 */