package com.tencent.mobileqq.msf.core.net.d.b;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.c;
import com.tencent.mobileqq.msf.core.a.c.a;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.net.utils.h;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class k
{
  private static final String a = "UdpSsoEndpointManager";
  private final ConcurrentMap b = new ConcurrentHashMap();
  
  public static k a()
  {
    return k.a.a();
  }
  
  private CopyOnWriteArrayList c()
  {
    if (NetConnInfoCenter.isWifiConn()) {
      return MsfService.getCore().getSsoListManager().a(c.a.a("Socket", "Wifi", "Ipv4"), true);
    }
    return MsfService.getCore().getSsoListManager().a(c.a.a("Socket", "Mobile", "Ipv4"), true);
  }
  
  public void a(e parame) {}
  
  public d b()
  {
    if (QLog.isDebugVersion())
    {
      localObject = new d();
      ((d)localObject).c("14.18.180.90");
      ((d)localObject).a(21000);
      return localObject;
    }
    Object localObject = c();
    localObject = (d)((CopyOnWriteArrayList)localObject).get(h.a(0, ((CopyOnWriteArrayList)localObject).size()));
    d locald = new d();
    locald.c(((d)localObject).c());
    locald.a(21000);
    return locald;
  }
  
  public void b(e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.b.k
 * JD-Core Version:    0.7.0.1
 */