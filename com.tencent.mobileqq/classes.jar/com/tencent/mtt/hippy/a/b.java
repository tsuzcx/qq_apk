package com.tencent.mtt.hippy.a;

import com.tencent.mtt.hippy.b.d;
import com.tencent.mtt.hippy.b.d.a;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class b
  implements d.a
{
  d a;
  private final AtomicInteger b = new AtomicInteger();
  private final ConcurrentHashMap<Integer, b.a> c = new ConcurrentHashMap();
  private b.a d;
  private f.a e;
  
  private void a(String paramString, Throwable paramThrowable)
  {
    a();
    if (this.d != null)
    {
      this.d.a(paramThrowable);
      this.d = null;
    }
    paramString = this.c.values().iterator();
    while (paramString.hasNext()) {
      ((b.a)paramString.next()).a(paramThrowable);
    }
    this.c.clear();
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a = null;
  }
  
  public void a(f.a parama)
  {
    this.e = parama;
  }
  
  public void a(Exception paramException)
  {
    a("Websocket exception", paramException);
  }
  
  public void a(String paramString)
  {
    if (this.a == null)
    {
      LogUtils.e("sendMessage", "mWebSocket is null");
      return;
    }
    this.a.a(paramString);
  }
  
  public void a(String paramString, b.a parama)
  {
    this.d = parama;
    this.a = new d(URI.create(paramString), this, null);
    this.a.a();
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void b()
  {
    if (this.d != null) {
      this.d.a(null);
    }
    this.d = null;
  }
  
  public void b(String paramString)
  {
    this.e.onReceiveData(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.b
 * JD-Core Version:    0.7.0.1
 */