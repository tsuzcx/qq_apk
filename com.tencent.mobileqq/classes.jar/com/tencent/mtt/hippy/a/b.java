package com.tencent.mtt.hippy.a;

import com.tencent.mtt.hippy.b.d;
import com.tencent.mtt.hippy.b.d.a;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class b
  implements d.a
{
  d a;
  private final ConcurrentHashMap<Integer, b.a> b = new ConcurrentHashMap();
  private b.a c;
  private f.a d;
  
  private void a(Throwable paramThrowable)
  {
    a();
    Object localObject = this.c;
    if (localObject != null)
    {
      ((b.a)localObject).a(paramThrowable);
      this.c = null;
    }
    localObject = this.b.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.a)((Iterator)localObject).next()).a(paramThrowable);
    }
    this.b.clear();
  }
  
  public void a()
  {
    d locald = this.a;
    if (locald != null) {
      locald.b();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a = null;
  }
  
  public void a(f.a parama)
  {
    this.d = parama;
  }
  
  public void a(Exception paramException)
  {
    a(paramException);
  }
  
  public void a(String paramString)
  {
    d locald = this.a;
    if (locald == null)
    {
      LogUtils.e("sendMessage", "mWebSocket is null");
      return;
    }
    locald.a(paramString);
  }
  
  public void a(String paramString, b.a parama)
  {
    this.c = parama;
    this.a = new d(URI.create(paramString), this, null);
    this.a.a();
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void b()
  {
    b.a locala = this.c;
    if (locala != null) {
      locala.a(null);
    }
    this.c = null;
  }
  
  public void b(String paramString)
  {
    this.d.onReceiveData(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.b
 * JD-Core Version:    0.7.0.1
 */