package com.tencent.qapmsdk.socket.c;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.Apn;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.instrumentation.i;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLException;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;

public class a
{
  public long A;
  public int B = 0;
  public int C = 0;
  public int D = NetworkWatcher.INSTANCE.getApn().getValue();
  public Exception E = null;
  public boolean F;
  public boolean G = false;
  public Map<String, String> H = new HashMap();
  public Map<String, String> I = new HashMap();
  public boolean a;
  public String b = "";
  public String c;
  public String d;
  public String e = "";
  public int f;
  public String g;
  public String h = "";
  public String i;
  public String j;
  public int k;
  public long l;
  public String m;
  public String n = "";
  public long o;
  public long p;
  public long q;
  public long r;
  public long s;
  public long t;
  public long u;
  public long v;
  public long w;
  public long x;
  public boolean y;
  public boolean z;
  
  public static int a(Exception paramException)
  {
    if ((paramException instanceof IOException))
    {
      if (i.a(paramException)) {
        return 911;
      }
      String str = paramException.getMessage();
      if ((paramException != null) && (str != null) && (str.contains("ftruncate failed: ENOENT (No such file or directory)"))) {
        return 917;
      }
    }
    if ((paramException instanceof UnknownHostException)) {
      return 901;
    }
    if ((!(paramException instanceof SocketTimeoutException)) && (!(paramException instanceof ConnectTimeoutException)))
    {
      if ((paramException instanceof ConnectException)) {
        return 902;
      }
      if ((paramException instanceof MalformedURLException)) {
        return 900;
      }
      if ((paramException instanceof SSLException)) {
        return 908;
      }
      if ((paramException instanceof HttpResponseException)) {
        return ((HttpResponseException)paramException).getStatusCode();
      }
      if ((paramException instanceof ClientProtocolException)) {
        return 904;
      }
      if ((paramException instanceof AuthenticationException)) {
        return 907;
      }
      return -1;
    }
    return 903;
  }
  
  public void a()
  {
    this.y = false;
    this.z = false;
    this.A = 0L;
    this.H = new HashMap();
    this.I = new HashMap();
  }
  
  public void a(long paramLong)
  {
    this.v = paramLong;
    this.F = false;
  }
  
  public void b()
  {
    this.y = false;
    this.z = false;
    this.A = 0L;
  }
  
  public void b(long paramLong)
  {
    long l1 = this.v;
    if (paramLong <= l1)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Socket_SocketInfo", "get first package", ", firstReadTime:", String.valueOf(paramLong), ", lastWriteStamp:", String.valueOf(this.v), ", hostName:", this.d });
      return;
    }
    if (paramLong - l1 >= 20000L)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Socket_SocketInfo", "first package is too big", ", firstReadTime:", String.valueOf(paramLong), ", lastWriteStamp:", String.valueOf(this.v), ", hostName:", this.d });
      return;
    }
    if (!this.F)
    {
      this.F = true;
      this.t = ((int)(paramLong - l1));
    }
    this.u = (paramLong - this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.c.a
 * JD-Core Version:    0.7.0.1
 */