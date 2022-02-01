package com.tencent.mtt.hippy.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import java.net.Socket;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class d
{
  private static TrustManager[] a;
  private final Object b = new Object();
  private final URI c;
  private final d.a d;
  private Socket e;
  private Thread f;
  private final HandlerThread g;
  private final Handler h;
  private final List<a> i;
  private final b j;
  private boolean k;
  
  public d(URI paramURI, d.a parama, List<a> paramList)
  {
    this.c = paramURI;
    this.d = parama;
    this.i = paramList;
    this.k = false;
    this.j = new b(this);
    this.g = new HandlerThread("websocket-thread");
    this.g.start();
    this.h = new Handler(this.g.getLooper());
  }
  
  private String a(b.a parama)
  {
    int m = parama.read();
    if (m == -1) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    while (m != 10)
    {
      if (m != 13) {
        localStringBuilder.append((char)m);
      }
      int n = parama.read();
      m = n;
      if (n == -1) {
        return null;
      }
    }
    return localStringBuilder.toString();
  }
  
  private c b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return c.a(paramString);
  }
  
  private a c(String paramString)
  {
    int m = paramString.indexOf(":");
    if (m != -1) {
      return new a(paramString.substring(0, m).trim(), paramString.substring(m + 1));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebSocketClient Unexpected header: ");
    localStringBuilder.append(paramString);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private String d(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
      paramString = localStringBuilder.toString();
      paramString = Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(paramString.getBytes()), 0).trim();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label48:
      break label48;
    }
    return null;
  }
  
  private String e()
  {
    byte[] arrayOfByte = new byte[16];
    int m = 0;
    while (m < 16)
    {
      arrayOfByte[m] = ((byte)(int)(Math.random() * 256.0D));
      m += 1;
    }
    return Base64.encodeToString(arrayOfByte, 0).trim();
  }
  
  private SSLSocketFactory f()
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLS");
    localSSLContext.init(null, a, null);
    return localSSLContext.getSocketFactory();
  }
  
  public void a()
  {
    Thread localThread = this.f;
    if ((localThread != null) && (localThread.isAlive())) {
      return;
    }
    this.f = new Thread(new d.1(this));
    this.f.start();
  }
  
  public void a(int paramInt, String paramString)
  {
    this.j.a(paramInt, paramString);
    b();
  }
  
  public void a(String paramString)
  {
    b(this.j.a(paramString));
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    b(this.j.a(paramArrayOfByte));
  }
  
  public void b()
  {
    if (this.e != null) {
      this.h.post(new d.2(this));
    }
  }
  
  void b(byte[] paramArrayOfByte)
  {
    this.h.post(new d.3(this, paramArrayOfByte));
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public d.a d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.b.d
 * JD-Core Version:    0.7.0.1
 */