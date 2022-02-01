package com.tencent.qmsp.sdk.g.c;

import android.content.Context;
import com.tencent.qmsp.sdk.base.IVendorCallback;

public class b
  implements com.tencent.qmsp.sdk.base.b, c.b
{
  private c a;
  private IVendorCallback b;
  
  public String a()
  {
    if (!e()) {
      return "";
    }
    String str2 = this.a.a();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public void a(Context paramContext, IVendorCallback paramIVendorCallback)
  {
    this.b = paramIVendorCallback;
    this.a = new c(paramContext, this);
  }
  
  public void a(c paramc)
  {
    try
    {
      if (this.b == null) {
        break label47;
      }
      this.b.onResult(e(), b(), a());
      return;
    }
    catch (Exception paramc)
    {
      label29:
      label47:
      break label29;
    }
    paramc = this.b;
    if (paramc != null) {
      paramc.onResult(false, null, null);
    }
  }
  
  public String b()
  {
    if (!e()) {
      return "";
    }
    String str2 = this.a.c();
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
    c localc = this.a;
    if (localc != null) {
      return localc.b();
    }
    return false;
  }
  
  public void f()
  {
    c localc = this.a;
    if (localc != null) {
      localc.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.c.b
 * JD-Core Version:    0.7.0.1
 */