package com.tencent.mobileqq.microapp.appbrand;

import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.microapp.app.b.a;
import com.tencent.mobileqq.microapp.appbrand.utils.p;
import com.tencent.qphone.base.util.QLog;

final class d
  implements Runnable
{
  d(a parama) {}
  
  public void run()
  {
    p.a().a(this.a.d, this.a.c);
    b.a locala = new b.a(2, this.a.a, this.a.b, null);
    b.a().a(locala);
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppInterface", 2, "页面加载完成");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.d
 * JD-Core Version:    0.7.0.1
 */