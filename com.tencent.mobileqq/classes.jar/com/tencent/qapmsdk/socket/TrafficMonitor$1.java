package com.tencent.qapmsdk.socket;

import com.tencent.qapmsdk.impl.e.c;
import com.tencent.qapmsdk.socket.c.a;

class TrafficMonitor$1
  implements a.a
{
  TrafficMonitor$1(TrafficMonitor paramTrafficMonitor) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong, a parama)
  {
    parama.r = paramLong;
    if ((!paramBoolean) && (parama.E != null)) {
      parama.B = a.a(parama.E);
    }
    if (!parama.G)
    {
      c.a().a(parama);
      parama.G = true;
    }
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt, long paramLong, a parama)
  {
    if ((paramBoolean) && (parama != null)) {
      parama.p = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficMonitor.1
 * JD-Core Version:    0.7.0.1
 */