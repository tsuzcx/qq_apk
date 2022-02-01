package com.tencent.qapmsdk.socket;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.a.k;
import com.tencent.qapmsdk.socket.c.a;
import java.io.OutputStream;
import java.util.HashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class c
  extends OutputStream
{
  private static final String[] a = { "GET", "POST", "PATCH", "PUT", "DELETE", "MOVE", "PROPPATCH", "REPORT", "HEAD", "PROPFIND", "CONNECT", "OPTIONS", "TRACE", "PRI" };
  private static HashMap<Integer, Long> f;
  private byte[] b = new byte[1];
  private OutputStream c;
  private k d;
  private a e;
  
  public c(OutputStream paramOutputStream, a parama)
  {
    this.c = paramOutputStream;
    if (parama != null) {
      this.e = parama;
    }
    if (f == null) {
      f = new HashMap();
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    a locala = this.e;
    locala.a = paramBoolean;
    locala.d = paramString1;
    locala.e = paramString2;
    locala.f = paramInt1;
    locala.j = paramString3;
    locala.k = paramInt2;
    locala.l = Thread.currentThread().getId();
    this.e.m = com.tencent.qapmsdk.socket.d.c.a();
    this.d = new k();
    if (!paramBoolean)
    {
      f.put(Integer.valueOf(paramInt2), Long.valueOf(this.e.r));
      return;
    }
    if (f.containsKey(Integer.valueOf(paramInt2)))
    {
      this.e.r = ((Long)f.get(Integer.valueOf(paramInt2))).longValue();
      f.remove(Integer.valueOf(paramInt2));
    }
  }
  
  public void close()
  {
    this.c.close();
  }
  
  public void flush()
  {
    this.c.flush();
    f.remove(Integer.valueOf(this.e.k));
  }
  
  public void write(int paramInt)
  {
    byte[] arrayOfByte = this.b;
    arrayOfByte[0] = ((byte)paramInt);
    write(arrayOfByte, 0, 1);
  }
  
  public void write(@NonNull byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = new String(paramArrayOfByte, 0, paramInt2);
    Object localObject2 = a;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      if (((String)localObject1).startsWith(localObject2[i]))
      {
        i = ((String)localObject1).indexOf(" ");
        if (i == -1) {
          break;
        }
        this.e.h = ((String)localObject1).substring(0, i);
        i += 1;
        j = ((String)localObject1).indexOf(" ", i);
        if (j == -1) {
          break;
        }
        this.e.i = ((String)localObject1).substring(i, j);
        i = j + 1;
        this.e.g = ((String)localObject1).substring(i, i + 8);
        break;
      }
      i += 1;
    }
    if (TrafficMonitor.a().a())
    {
      localObject1 = Logger.INSTANCE;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(SystemClock.elapsedRealtime() - l);
      ((StringBuilder)localObject2).append("ms");
      ((Logger)localObject1).v(new String[] { "QAPM_Socket_TrafficOutputStream", "finish match, cost: ", ((StringBuilder)localObject2).toString(), ", method: ", this.e.h, ", version: ", this.e.g, ", path: ", this.e.i });
    }
    this.d.a(paramArrayOfByte, paramInt1, paramInt2, this.e);
    this.c.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.c
 * JD-Core Version:    0.7.0.1
 */