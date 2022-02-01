package com.tencent.mtt.hippy.a;

import java.io.File;
import java.io.InputStream;

class l$1
  implements a
{
  l$1(l paraml, g paramg) {}
  
  public void a(File paramFile) {}
  
  public void a(InputStream paramInputStream)
  {
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.l.1
 * JD-Core Version:    0.7.0.1
 */