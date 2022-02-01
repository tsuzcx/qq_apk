package com.tencent.mtt.hippy.a;

import android.app.ProgressDialog;
import java.io.File;
import java.util.Stack;

class k$2
  implements a
{
  k$2(k paramk) {}
  
  public void a(File paramFile)
  {
    if (this.a.c != null) {
      this.a.c.dismiss();
    }
    if (this.a.b != null) {
      this.a.b.onDevBundleLoadReady(paramFile);
    }
  }
  
  public void a(Exception paramException)
  {
    if (k.b(this.a).isEmpty())
    {
      this.a.b.onInitDevError(paramException);
      return;
    }
    this.a.a(paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.k.2
 * JD-Core Version:    0.7.0.1
 */