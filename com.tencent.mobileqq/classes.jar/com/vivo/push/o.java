package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

public abstract class o
{
  private int a = -1;
  private String b;
  
  public o(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.a = paramInt;
      return;
    }
    throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
  }
  
  private void e(a parama)
  {
    parama.a("command", this.a);
    parama.a("client_pkgname", this.b);
    c(parama);
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final void a(Intent paramIntent)
  {
    Object localObject = a.a(paramIntent);
    if (localObject == null)
    {
      com.vivo.push.util.o.b("PushCommand", "bundleWapper is null");
      return;
    }
    a((a)localObject);
    localObject = ((a)localObject).b();
    if (localObject != null) {
      paramIntent.putExtras((Bundle)localObject);
    }
  }
  
  public final void a(a parama)
  {
    String str2 = p.a(this.a);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    parama.a("method", str1);
    e(parama);
  }
  
  public final void a(String paramString)
  {
    this.b = paramString;
  }
  
  public final int b()
  {
    return this.a;
  }
  
  public final void b(Intent paramIntent)
  {
    Object localObject = a.a(paramIntent);
    if (localObject == null)
    {
      com.vivo.push.util.o.b("PushCommand", "bundleWapper is null");
      return;
    }
    ((a)localObject).a("method", this.a);
    e((a)localObject);
    localObject = ((a)localObject).b();
    if (localObject != null) {
      paramIntent.putExtras((Bundle)localObject);
    }
  }
  
  public final void b(a parama)
  {
    String str = parama.a();
    if (!TextUtils.isEmpty(str)) {
      this.b = str;
    } else {
      this.b = parama.a("client_pkgname");
    }
    d(parama);
  }
  
  protected abstract void c(a parama);
  
  public boolean c()
  {
    return false;
  }
  
  protected abstract void d(a parama);
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.o
 * JD-Core Version:    0.7.0.1
 */