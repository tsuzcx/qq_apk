package com.tencent.qmsp.sdk.g.h;

import android.content.Context;
import com.tencent.qmsp.sdk.base.IVendorCallback;

public class c
  implements com.tencent.qmsp.sdk.base.b, b.b
{
  public IVendorCallback a;
  private b b;
  
  public String a()
  {
    if (!e()) {
      return "";
    }
    String str2 = this.b.b();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public void a(Context paramContext, IVendorCallback paramIVendorCallback)
  {
    this.a = paramIVendorCallback;
    this.b = new b(paramContext, this);
    this.b.c();
  }
  
  public void a(b paramb)
  {
    paramb = this.a;
    if (paramb != null) {
      paramb.onResult(e(), b(), a());
    }
  }
  
  public String b()
  {
    if (!e()) {
      return "";
    }
    String str2 = this.b.a();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public void c() {}
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    b localb = this.b;
    if (localb != null) {
      return localb.d();
    }
    return false;
  }
  
  public void f()
  {
    b localb = this.b;
    if (localb != null) {
      localb.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.h.c
 * JD-Core Version:    0.7.0.1
 */