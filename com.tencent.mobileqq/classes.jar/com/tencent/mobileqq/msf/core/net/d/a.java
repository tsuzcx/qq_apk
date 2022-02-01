package com.tencent.mobileqq.msf.core.net.d;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.net.d.a.c;
import com.tencent.mobileqq.msf.core.net.d.a.d;
import com.tencent.mobileqq.msf.core.net.d.a.i;
import com.tencent.mobileqq.msf.core.net.d.a.k;
import com.tencent.mobileqq.msf.core.net.d.a.m;
import com.tencent.mobileqq.msf.core.net.d.a.n;
import com.tencent.mobileqq.msf.core.net.d.b.g;
import com.tencent.mobileqq.msf.core.net.d.b.h.a;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static final String a = "MsfQuickUdpClient";
  private static final List b = new ArrayList();
  
  private a()
  {
    b.add(k.a());
    b.add(new m());
    b.add(new i());
    b.add(com.tencent.mobileqq.msf.core.net.d.a.e.a());
    b.add(n.a());
    b.add(new com.tencent.mobileqq.msf.core.net.d.a.a());
  }
  
  public static a a()
  {
    return a.c.a();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, a.a parama)
  {
    QLog.d("MsfQuickUdpClient", 2, new Object[] { "[sendMessage] message before filter: ", com.tencent.mobileqq.msf.core.b.a.a(paramToServiceMsg) });
    Iterator localIterator = b.iterator();
    Object localObject;
    do
    {
      do
      {
        localObject = paramToServiceMsg;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (c)localIterator.next();
      } while (!(localObject instanceof d));
      localObject = ((d)localObject).a(paramToServiceMsg);
      paramToServiceMsg = (ToServiceMsg)localObject;
    } while (localObject != null);
    if (localObject == null)
    {
      QLog.d("MsfQuickUdpClient", 1, "[sendMessage] after filter message is null.");
      return;
    }
    QLog.d("MsfQuickUdpClient", 2, new Object[] { "[sendMessage] send message after filter: ", ((ToServiceMsg)localObject).toString() });
    paramToServiceMsg = com.tencent.mobileqq.msf.core.net.utils.a.a((ToServiceMsg)localObject, MsfCore.sCore);
    paramToServiceMsg = new h.a().a(paramToServiceMsg).a(paramToServiceMsg.length).a();
    g.a().a(paramToServiceMsg).a(new a.b((ToServiceMsg)localObject, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.a
 * JD-Core Version:    0.7.0.1
 */