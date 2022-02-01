package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.g;
import com.vivo.push.util.o;
import com.vivo.push.util.w;
import com.vivo.push.util.y;
import java.util.ArrayList;
import java.util.List;

public abstract class c<T>
{
  protected static final Object a = new Object();
  protected List<T> b = new ArrayList();
  protected Context c;
  private byte[] d;
  private byte[] e;
  
  protected c(Context paramContext)
  {
    this.c = ContextDelegate.getContext(paramContext);
    paramContext = w.b();
    paramContext.a(this.c);
    this.d = paramContext.c();
    this.e = paramContext.d();
    c();
  }
  
  private String b()
  {
    return y.b(this.c).a(a(), null);
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder("ClientManager init ");
      paramString.append(a());
      paramString.append(" strApps empty.");
      o.d("CacheSettings", paramString.toString());
      return;
    }
    if (paramString.length() > 10000)
    {
      paramString = new StringBuilder("sync ");
      paramString.append(a());
      paramString.append(" strApps lenght too large");
      o.d("CacheSettings", paramString.toString());
      d();
      return;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("ClientManager init ");
      localStringBuilder.append(a());
      localStringBuilder.append(" strApps : ");
      localStringBuilder.append(paramString);
      o.d("CacheSettings", localStringBuilder.toString());
      paramString = a(b(paramString));
      if (paramString != null) {
        this.b.addAll(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      d();
      o.d("CacheSettings", o.a(paramString));
    }
  }
  
  private void d(String paramString)
  {
    y.b(this.c).b(a(), paramString);
  }
  
  protected abstract String a();
  
  protected abstract List<T> a(String paramString);
  
  abstract String b(String paramString);
  
  public final void c()
  {
    synchronized (a)
    {
      g.a(a());
      this.b.clear();
      c(b());
      return;
    }
  }
  
  public final void d()
  {
    synchronized (a)
    {
      this.b.clear();
      d("");
      StringBuilder localStringBuilder = new StringBuilder("clear ");
      localStringBuilder.append(a());
      localStringBuilder.append(" strApps");
      o.d("CacheSettings", localStringBuilder.toString());
      return;
    }
  }
  
  protected final byte[] e()
  {
    byte[] arrayOfByte = this.d;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      return arrayOfByte;
    }
    return w.b().c();
  }
  
  protected final byte[] f()
  {
    byte[] arrayOfByte = this.e;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      return arrayOfByte;
    }
    return w.b().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.cache.c
 * JD-Core Version:    0.7.0.1
 */