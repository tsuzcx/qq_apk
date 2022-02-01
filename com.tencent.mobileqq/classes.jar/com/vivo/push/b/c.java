package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.a;
import com.vivo.push.util.s;

public class c
  extends com.vivo.push.o
{
  private String a = null;
  private String b;
  private long c = -1L;
  private int d = -1;
  private int e;
  private String f;
  
  public c(int paramInt, String paramString)
  {
    super(paramInt);
    this.b = paramString;
  }
  
  public final int a(Context paramContext)
  {
    if (this.d == -1)
    {
      String str2 = this.b;
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        com.vivo.push.util.o.a("BaseAppCommand", "pkg name is null");
        str1 = a();
        if (TextUtils.isEmpty(str1))
        {
          com.vivo.push.util.o.a("BaseAppCommand", "src is null");
          return -1;
        }
      }
      this.d = s.b(paramContext, str1);
      if (!TextUtils.isEmpty(this.f)) {
        this.d = 2;
      }
    }
    return this.d;
  }
  
  public final void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void b(String paramString)
  {
    this.a = paramString;
  }
  
  protected void c(a parama)
  {
    parama.a("req_id", this.a);
    parama.a("package_name", this.b);
    parama.a("sdk_version", 800L);
    parama.a("PUSH_APP_STATUS", this.d);
    if (!TextUtils.isEmpty(this.f)) {
      parama.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f);
    }
  }
  
  protected void d(a parama)
  {
    this.a = parama.a("req_id");
    this.b = parama.a("package_name");
    this.c = parama.b("sdk_version", 0L);
    this.d = parama.b("PUSH_APP_STATUS", 0);
    this.f = parama.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
  }
  
  public final int f()
  {
    return this.e;
  }
  
  public final void g()
  {
    this.f = null;
  }
  
  public final String h()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "BaseAppCommand";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.c
 * JD-Core Version:    0.7.0.1
 */