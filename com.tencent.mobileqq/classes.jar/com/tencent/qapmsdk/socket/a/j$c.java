package com.tencent.qapmsdk.socket.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.TrafficMonitor;
import com.tencent.qapmsdk.socket.TrafficMonitor.a;
import com.tencent.qapmsdk.socket.c.b;
import com.tencent.qapmsdk.socket.d.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

class j$c
  implements d
{
  private String a;
  private String b;
  private j.i c;
  private boolean d;
  private boolean e;
  private boolean f;
  private List<Byte> g = new ArrayList();
  private j.c.a h = new j.c.a(this);
  
  public void a()
  {
    if (this.g.size() > 0)
    {
      e.a(this.h.a(this.g.size()), 500L);
      if ((TrafficMonitor.a().a()) && (!this.e) && (this.c != null))
      {
        j.a locala = this.c.b;
        if (locala.j.size() > 0) {
          locala.j.reset();
        }
        Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "input stream close ", this.a });
      }
      this.g.clear();
    }
  }
  
  public void a(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, @Nullable com.tencent.qapmsdk.socket.c.a parama)
  {
    boolean bool;
    label141:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (parama != null)
    {
      if ((this.d) || (TextUtils.isEmpty(this.a)) || ((parama.i != null) && (!parama.i.equals(this.b))))
      {
        this.d = false;
        this.b = parama.i;
        parama.b();
        this.a = j.a(parama);
        this.c = new j.i(false, parama);
        if ((parama.g != null) && (parama.g.startsWith("HTTP/1")))
        {
          bool = true;
          this.e = bool;
          if ((parama.g == null) || (!parama.g.startsWith("HTTP/2"))) {
            break label582;
          }
          bool = true;
          this.f = bool;
        }
      }
      else
      {
        parama.x += paramInt2;
      }
    }
    else
    {
      if ((TrafficMonitor.a().a()) && (paramInt3 > 0) && (this.e) && (this.c != null))
      {
        localObject1 = this.c.a;
        localObject2 = this.c.b;
        if (((j.g)localObject1).h) {
          break label588;
        }
        ((j.g)localObject1).a(paramArrayOfByte, paramInt1, paramInt3);
        if (((j.g)localObject1).h)
        {
          if (parama != null)
          {
            this.a = j.a(parama);
            ((j.a)localObject2).a = parama.A;
          }
          localObject3 = ((j.g)localObject1).j.toByteArray();
          ((j.a)localObject2).a((byte[])localObject3, ((j.g)localObject1).i, localObject3.length - ((j.g)localObject1).i);
        }
        if ((((j.g)localObject1).h) && (((j.a)localObject2).h) && (this.e))
        {
          Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "http1 read finished <<< ", this.a });
          this.d = true;
        }
      }
      if ((TrafficMonitor.a().a()) && (paramInt2 > 0) && (this.f) && (this.c != null))
      {
        localObject1 = new com.tencent.qapmsdk.socket.b.a(new ByteArrayInputStream(paramArrayOfByte));
        localObject2 = this.c.a;
        localObject3 = this.c.b;
      }
    }
    label582:
    label588:
    byte[] arrayOfByte;
    label708:
    do
    {
      try
      {
        ((com.tencent.qapmsdk.socket.b.a)localObject1).a(new j.h(this.c));
        if ((((j.g)localObject2).h) && (((j.a)localObject3).h) && (this.f))
        {
          Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "http2 read finished <<< ", this.a });
          this.d = true;
        }
        if (paramInt3 == 1)
        {
          this.g.add(Byte.valueOf(paramArrayOfByte[0]));
          if ((this.d) && (parama != null))
          {
            if (!parama.G)
            {
              com.tencent.qapmsdk.impl.e.c.a().a(parama);
              parama.G = true;
            }
            b.a(parama.c + "://" + parama.d + parama.i, parama);
          }
          return;
          bool = false;
          break;
          bool = false;
          break label141;
          ((j.a)localObject2).a(paramArrayOfByte, paramInt1, paramInt3);
        }
      }
      catch (Exception localException)
      {
        do
        {
          for (;;)
          {
            Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficInputStream", "http2 read failed <<< ", this.a });
          }
        } while (paramInt3 <= 1);
        e.a(this.h.a(paramInt3), 500L);
        if (!TrafficMonitor.a().b()) {
          continue;
        }
      }
      if (!this.e)
      {
        if ((this.c == null) || (this.c.a() <= 0) || (this.f)) {
          break label999;
        }
        paramArrayOfByte = this.c.c();
        this.c.b();
        arrayOfByte = paramArrayOfByte;
        if (!new com.tencent.qapmsdk.socket.c.c().a(paramArrayOfByte)) {
          arrayOfByte = ("binary " + paramArrayOfByte.length + "-bytes body omitted").getBytes();
        }
        Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "read <<< [", this.a, "]\n", new String(arrayOfByte) });
      }
    } while (this.g.size() <= 0);
    e.a(this.h.a(this.g.size()), 500L);
    if ((TrafficMonitor.a().b()) && (!this.e))
    {
      if ((this.c == null) || (this.c.a() <= 0) || (this.f)) {
        break label1021;
      }
      paramArrayOfByte = this.c.c();
      this.c.b();
    }
    for (;;)
    {
      arrayOfByte = paramArrayOfByte;
      if (!new com.tencent.qapmsdk.socket.c.c().a(paramArrayOfByte)) {
        arrayOfByte = ("binary " + paramArrayOfByte.length + "-bytes body omitted").getBytes();
      }
      Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "read <<< [", this.a, "]\n", new String(arrayOfByte) });
      this.g.clear();
      break;
      label999:
      arrayOfByte = new byte[paramInt3];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt3);
      paramArrayOfByte = arrayOfByte;
      break label708;
      label1021:
      paramArrayOfByte = com.tencent.qapmsdk.socket.d.a.a((Byte[])this.g.toArray(new Byte[0]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j.c
 * JD-Core Version:    0.7.0.1
 */