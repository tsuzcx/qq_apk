package com.tencent.qmsp.sdk.g.g;

import android.content.Context;
import com.tencent.qmsp.sdk.base.IVendorCallback;

public class c
  implements com.tencent.qmsp.sdk.base.b
{
  private Context a = null;
  private IVendorCallback b = null;
  
  public String a()
  {
    return "";
  }
  
  public void a(Context paramContext, IVendorCallback paramIVendorCallback)
  {
    this.a = paramContext;
    this.b = paramIVendorCallback;
    b.c(paramContext);
  }
  
  public String b()
  {
    return "";
  }
  
  public void c()
  {
    new Thread(new c.a(this)).start();
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return b.a();
  }
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.g.c
 * JD-Core Version:    0.7.0.1
 */