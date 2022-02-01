package com.tencent.mobileqq.microapp.appbrand.ui;

import com.tencent.mobileqq.microapp.app.b.a;
import com.tencent.mobileqq.microapp.app.b.b;
import com.tencent.mobileqq.microapp.app.b.c;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.j;

final class d
  extends b.b
{
  d(AppBrandUI paramAppBrandUI) {}
  
  public void a(b.a parama)
  {
    super.a(parama);
    this.a.runOnUiThread(new e(this, parama));
  }
  
  public void a(b.c paramc)
  {
    if (paramc == null) {
      return;
    }
    a locala = this.a.a.a(paramc.a, paramc.b);
    if (locala != null) {
      locala.a(paramc.c, paramc.d, paramc.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.ui.d
 * JD-Core Version:    0.7.0.1
 */