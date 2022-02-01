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
    if ((this.d) || (TextUtils.isEmpty(this.a)) || ((parama.i != null) && (!parama.i.equals(this.b))))
    {
      this.d = false;
      this.b = parama.i;
      parama.a();
      this.a = j.a(parama);
      this.c = new j.i(true, parama);
      boolean bool;
      if ((parama.g != null) && (parama.g.startsWith("HTTP/1"))) {
        bool = true;
      } else {
        bool = false;
      }
      this.e = bool;
      if ((parama.g != null) && (parama.g.startsWith("HTTP/2"))) {
        bool = true;
      } else {
        bool = false;
      }
      this.f = bool;
    }
    parama.w += paramInt2;
    Object localObject;
    j.a locala;
    if ((TrafficMonitor.a().a()) && (paramInt2 > 0) && (this.e))
    {
      localObject = this.c.a;
      locala = this.c.b;
      if (!((j.g)localObject).h)
      {
        ((j.g)localObject).a(paramArrayOfByte, paramInt1, paramInt2);
        if (((j.g)localObject).h)
        {
          this.a = j.a(parama);
          locala.a = parama.A;
          parama = ((j.g)localObject).j.toByteArray();
          locala.a(parama, ((j.g)localObject).i, parama.length - ((j.g)localObject).i);
        }
      }
      else
      {
        locala.a(paramArrayOfByte, paramInt1, paramInt2);
      }
      if ((((j.g)localObject).h) && (locala.h) && (this.e))
      {
        Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "http1 write finish >>>> ", this.a });
        this.d = true;
      }
    }
    if ((TrafficMonitor.a().a()) && (paramInt2 > 0) && (this.f))
    {
      parama = new com.tencent.qapmsdk.socket.b.a(new ByteArrayInputStream(paramArrayOfByte));
      localObject = this.c.a;
      locala = this.c.b;
    }
    try
    {
      parama.a(new j.h(this.c));
      if ((!((j.g)localObject).h) || (!locala.h) || (!this.f)) {
        break label502;
      }
      Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "http2 write finish >>>> ", this.a });
      this.d = true;
    }
    catch (Exception parama)
    {
      label475:
      break label475;
    }
    Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficOutputStream", "http2 write failed >>> ", this.a });
    label502:
    e.a(this.g.a(paramInt2), 500L);
    if ((TrafficMonitor.a().b()) && (!this.e))
    {
      parama = this.c;
      if ((parama != null) && (parama.a() > 0) && (!this.f))
      {
        paramArrayOfByte = this.c.c();
        this.c.b();
      }
      else
      {
        parama = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte, paramInt1, parama, 0, paramInt2);
        paramArrayOfByte = parama;
      }
      parama = paramArrayOfByte;
      if (!new c().a(paramArrayOfByte))
      {
        parama = new StringBuilder();
        parama.append("binary ");
        parama.append(paramArrayOfByte.length);
        parama.append("-bytes body omitted");
        parama = parama.toString().getBytes();
      }
      paramArrayOfByte = Logger.INSTANCE;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("]\n");
      paramArrayOfByte.d(new String[] { "QAPM_Socket_TrafficOutputStream", "write >>> [", ((StringBuilder)localObject).toString(), new String(parama) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j.e
 * JD-Core Version:    0.7.0.1
 */