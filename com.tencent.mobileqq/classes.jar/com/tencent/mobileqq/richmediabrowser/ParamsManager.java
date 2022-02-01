package com.tencent.mobileqq.richmediabrowser;

import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;

public class ParamsManager
{
  protected int a = -1;
  boolean b = true;
  public boolean c;
  public boolean d = true;
  public Rect e;
  private boolean f = false;
  private boolean g = false;
  private String h;
  private String i;
  private boolean j = false;
  private long k = 0L;
  private int l;
  private String m;
  private String n;
  private boolean o;
  private boolean p = false;
  private boolean q = false;
  private int r;
  private boolean s;
  private int t;
  private int u;
  
  public static ParamsManager a()
  {
    return ParamsManager.SingletonHolder.a();
  }
  
  public void a(Intent paramIntent)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(Rect paramRect)
  {
    this.e = paramRect;
  }
  
  public boolean b()
  {
    return this.q;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  public boolean d()
  {
    return this.g;
  }
  
  public String e()
  {
    if (TextUtils.isEmpty(this.h)) {
      this.h = this.m;
    }
    return this.h;
  }
  
  public String f()
  {
    return this.i;
  }
  
  public boolean g()
  {
    return this.j;
  }
  
  public long h()
  {
    return this.k;
  }
  
  public int i()
  {
    return this.l;
  }
  
  public String j()
  {
    return this.m;
  }
  
  public String k()
  {
    return this.n;
  }
  
  public boolean l()
  {
    return this.p;
  }
  
  public int m()
  {
    return this.r;
  }
  
  public boolean n()
  {
    return this.s;
  }
  
  public int o()
  {
    return this.a;
  }
  
  public int p()
  {
    return this.t;
  }
  
  public int q()
  {
    return this.u;
  }
  
  public boolean r()
  {
    return (this.b) && (this.l != -1);
  }
  
  public boolean s()
  {
    return this.b;
  }
  
  public Rect t()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.ParamsManager
 * JD-Core Version:    0.7.0.1
 */