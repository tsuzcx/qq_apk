package com.tencent.qmsp.sdk.c;

import android.text.TextUtils;
import com.tencent.qmsp.sdk.f.g;

class k$i
{
  protected boolean a = false;
  
  private k$i(k paramk) {}
  
  public void a()
  {
    if (this.a) {
      k.f(this.b).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    g.a("Qp.QLM", 1, String.format("visitQSecSFUItem libPath = %s libVer = %s libId = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) }));
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    j.a locala = k.f(this.b).a(paramInt1);
    if ((locala == null) || (!paramString1.equals(locala.e)) || (!paramString2.equals(locala.d)) || (paramInt2 != locala.b) || (paramInt3 != locala.c))
    {
      if (locala == null)
      {
        locala = new j.a();
      }
      else
      {
        k.f(this.b).a(paramInt1, false);
        g.a("Qp.QLM", 1, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
      }
      locala.a = paramInt1;
      locala.b = paramInt2;
      locala.c = paramInt3;
      locala.e = paramString1;
      locala.d = paramString2;
      g.a("Qp.QLM", 1, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(locala.a), Integer.valueOf(locala.b), Integer.valueOf(locala.c), locala.e }));
      k.f(this.b).a(locala, false);
      this.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.k.i
 * JD-Core Version:    0.7.0.1
 */