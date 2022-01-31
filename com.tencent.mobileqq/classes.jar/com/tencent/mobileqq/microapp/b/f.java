package com.tencent.mobileqq.microapp.b;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger a = new AtomicInteger(0);
  
  public static d a(d.a parama)
  {
    parama = new d(parama);
    if (a.get() > 30)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WxRequest", 2, "[httpRequest] too much request");
      }
      return parama;
    }
    ThreadManagerV2.excute(parama, 16, new g(), true);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.b.f
 * JD-Core Version:    0.7.0.1
 */