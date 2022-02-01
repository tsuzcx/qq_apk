package com.tencent.mtt.hippy.a;

import android.app.ProgressDialog;
import java.io.InputStream;
import java.util.Stack;

class k$2
  implements a
{
  k$2(k paramk, g paramg) {}
  
  public void a(InputStream paramInputStream)
  {
    if (this.b.c != null) {
      this.b.c.dismiss();
    }
    g localg = this.a;
    if (localg != null) {
      localg.onDevBundleLoadReady(paramInputStream);
    }
  }
  
  public void a(Exception paramException)
  {
    g localg = this.a;
    if (localg != null) {
      localg.onInitDevError(paramException);
    }
    if (k.b(this.b).isEmpty())
    {
      this.b.b.onInitDevError(paramException);
      return;
    }
    this.b.a(paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.k.2
 * JD-Core Version:    0.7.0.1
 */