package com.tencent.rfw.barrage.core;

import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.tool.RFWBasePlayerTimer;
import com.tencent.rfw.barrage.tool.RFWSortedLinkedList;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class RFWBarrageDataSource
{
  private final List<RFWBaseBarrage> a;
  private final RFWSortedLinkedList<RFWBaseBarrage> b;
  private final RFWBasePlayerTimer c;
  private final AtomicBoolean d;
  private volatile long e = -1L;
  
  public RFWBarrageDataSource(RFWBasePlayerTimer paramRFWBasePlayerTimer, RFWBarrageComparator paramRFWBarrageComparator)
  {
    this.c = paramRFWBasePlayerTimer;
    this.b = new RFWSortedLinkedList(paramRFWBarrageComparator, new RFWBarrageDataSource.1(this));
    this.a = new LinkedList();
    this.d = new AtomicBoolean(false);
  }
  
  private void a(List<RFWBaseBarrage> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      RFWBaseBarrage localRFWBaseBarrage = (RFWBaseBarrage)paramList.get(i);
      if ((localRFWBaseBarrage != null) && (localRFWBaseBarrage.x() <= this.e)) {
        localRFWBaseBarrage.a();
      }
      i -= 1;
    }
  }
  
  private void e()
  {
    while (!this.d.compareAndSet(false, true))
    {
      RFWBarrageLogger.b("RFWBarrageDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void f()
  {
    while (!this.d.compareAndSet(true, false))
    {
      RFWBarrageLogger.d("RFWBarrageDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  List<RFWBaseBarrage> a()
  {
    if (this.b == null) {
      return null;
    }
    e();
    this.b.a(this.c.a(), this.a, 3);
    a(this.a);
    f();
    return this.a;
  }
  
  public void a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    e();
    RFWSortedLinkedList localRFWSortedLinkedList = this.b;
    if (localRFWSortedLinkedList != null) {
      localRFWSortedLinkedList.a(paramRFWBaseBarrage);
    }
    f();
  }
  
  public void b()
  {
    RFWBarrageLogger.a("RFWBarrageDataSource", "[clear] clear barrage queue.");
    e();
    RFWSortedLinkedList localRFWSortedLinkedList = this.b;
    if (localRFWSortedLinkedList != null) {
      localRFWSortedLinkedList.a();
    }
    f();
  }
  
  public int c()
  {
    RFWSortedLinkedList localRFWSortedLinkedList = this.b;
    if (localRFWSortedLinkedList == null) {
      return 0;
    }
    return localRFWSortedLinkedList.d();
  }
  
  public void d()
  {
    e();
    Object localObject = this.b;
    if (localObject == null)
    {
      RFWBarrageLogger.b("RFWBarrageDataSource", "[notifyConfigDirty] barrage sorted queue should not be null.");
      return;
    }
    localObject = (RFWBaseBarrage)((RFWSortedLinkedList)localObject).c();
    if (localObject == null) {
      this.e = -1L;
    } else {
      this.e = ((RFWBaseBarrage)localObject).x();
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWBarrageDataSource
 * JD-Core Version:    0.7.0.1
 */