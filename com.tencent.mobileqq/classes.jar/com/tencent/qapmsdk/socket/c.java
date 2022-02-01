package com.tencent.qapmsdk.socket;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.a.k;
import com.tencent.qapmsdk.socket.c.a;
import java.io.OutputStream;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class c
  extends OutputStream
{
  private static final String[] a = { "GET", "POST", "PATCH", "PUT", "DELETE", "MOVE", "PROPPATCH", "REPORT", "HEAD", "PROPFIND", "CONNECT", "OPTIONS", "TRACE", "PRI" };
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
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    this.e.a = paramBoolean;
    this.e.d = paramString1;
    this.e.e = paramString2;
    this.e.f = paramInt1;
    this.e.j = paramString3;
    this.e.k = paramInt2;
    this.e.l = Thread.currentThread().getId();
    this.e.m = com.tencent.qapmsdk.socket.d.c.a();
    this.d = new k();
  }
  
  public void close()
  {
    this.c.close();
  }
  
  public void flush()
  {
    this.c.flush();
  }
  
  public void write(int paramInt)
  {
    this.b[0] = ((byte)paramInt);
    write(this.b, 0, 1);
  }
  
  public void write(@NonNull byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = SystemClock.elapsedRealtime();
    String str = new String(paramArrayOfByte, 0, paramInt2);
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (!str.startsWith(arrayOfString[i])) {
          break label281;
        }
        i = str.indexOf(" ");
        if (i != -1)
        {
          this.e.h = str.substring(0, i);
          i += 1;
          j = str.indexOf(" ", i);
          if (j != -1)
          {
            this.e.i = str.substring(i, j);
            i = j + 1;
            j = "HTTP/1.1".length();
            this.e.g = str.substring(i, j + i);
          }
        }
      }
      if (TrafficMonitor.a().a()) {
        Logger.INSTANCE.v(new String[] { "QAPM_Socket_TrafficOutputStream", "finish match, cost: ", SystemClock.elapsedRealtime() - l + "ms", ", method: ", this.e.h, ", version: ", this.e.g, ", path: ", this.e.i });
      }
      this.d.a(paramArrayOfByte, paramInt1, paramInt2, this.e);
      this.c.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
      label281:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.c
 * JD-Core Version:    0.7.0.1
 */