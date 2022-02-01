package com.tencent.mobileqq.msf.core.net.d;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.net.d.a.b;
import com.tencent.mobileqq.msf.core.net.d.a.c;
import com.tencent.mobileqq.msf.core.net.d.b.e;
import com.tencent.mobileqq.msf.core.net.d.b.f;
import com.tencent.mobileqq.msf.core.net.d.b.i;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.DatagramPacket;
import java.util.List;

final class a$b
  implements f
{
  ToServiceMsg a;
  a.a b;
  
  a$b(ToServiceMsg paramToServiceMsg, a.a parama)
  {
    this.a = paramToServiceMsg;
    this.b = parama;
  }
  
  public void a(e parame, i parami)
  {
    parami = parami.a();
    parame = parami.getData();
    if (parame == null)
    {
      QLog.d("MsfQuickUdpClient", 1, "[onResponse] receive empty message.");
      return;
    }
    if (parame.length > parami.getLength())
    {
      parami = new byte[parami.getLength()];
      System.arraycopy(parame, 0, parami, 0, parami.length);
      parame = parami;
    }
    parame = com.tencent.mobileqq.msf.core.net.utils.a.a(parame, MsfCore.sCore);
    int i = a.b().size() - 1;
    while (i >= 0)
    {
      c localc = (c)a.b().get(i);
      parami = parame;
      if ((localc instanceof b)) {
        parami = ((b)localc).a(this.a, parame);
      }
      i -= 1;
      parame = parami;
    }
    parami = this.b;
    if (parami != null) {
      parami.a(this.a, parame);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsfQuickUdpClient", 1, new Object[] { "[onResponse] message after filter: ", com.tencent.mobileqq.msf.core.b.a.a(parame) });
    }
  }
  
  public void a(e parame, Exception paramException)
  {
    parame = this.b;
    if (parame != null) {
      parame.a(this.a, paramException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.a.b
 * JD-Core Version:    0.7.0.1
 */