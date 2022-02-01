package com.tencent.rfw.barrage.core;

import android.graphics.Canvas;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.render.IRFWViewOverlayDrawer;
import com.tencent.rfw.barrage.render.RFWBarrageDrawer;
import com.tencent.rfw.barrage.render.RFWBaseBarrageRender;
import com.tencent.rfw.barrage.tool.RFWBarrageDrawTimer;
import com.tencent.rfw.barrage.tool.RFWBasePlayerTimer;
import com.tencent.rfw.barrage.tool.RFWTouchPoint;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public abstract class RFWAbsWindow
{
  protected int a;
  protected final TreeSet<RFWBaseBarrage> b;
  protected final List<RFWBaseBarrage> c;
  protected final RFWBarrageDrawer d;
  protected RFWBarrageContext e;
  protected RFWCacheDrawManager f;
  protected RFWBasePlayerTimer g;
  protected RFWBarrageDrawTimer h;
  private ArrayList<IRFWViewOverlayDrawer> i;
  
  protected RFWAbsWindow(RFWBarrageContext paramRFWBarrageContext, RFWCacheDrawManager paramRFWCacheDrawManager, Comparator<RFWBaseBarrage> paramComparator, RFWBasePlayerTimer paramRFWBasePlayerTimer, RFWBarrageDrawTimer paramRFWBarrageDrawTimer)
  {
    this.e = paramRFWBarrageContext;
    this.f = paramRFWCacheDrawManager;
    this.g = paramRFWBasePlayerTimer;
    this.h = paramRFWBarrageDrawTimer;
    this.d = new RFWBarrageDrawer(paramRFWCacheDrawManager);
    this.b = new TreeSet(paramComparator);
    this.c = new ArrayList();
    c();
  }
  
  public static RFWAbsWindow a(RFWBarrageContext paramRFWBarrageContext, RFWCacheDrawManager paramRFWCacheDrawManager, Comparator<RFWBaseBarrage> paramComparator, RFWBasePlayerTimer paramRFWBasePlayerTimer, RFWBarrageDrawTimer paramRFWBarrageDrawTimer)
  {
    return paramRFWBarrageContext.a(paramRFWBarrageContext, paramRFWCacheDrawManager, paramComparator, paramRFWBasePlayerTimer, paramRFWBarrageDrawTimer);
  }
  
  private void a(Canvas paramCanvas, RFWBarrageContext paramRFWBarrageContext, long paramLong)
  {
    Object localObject = this.i;
    if (localObject == null) {
      return;
    }
    if (paramCanvas == null) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IRFWViewOverlayDrawer)((Iterator)localObject).next()).a(paramCanvas, paramRFWBarrageContext, paramLong);
    }
  }
  
  public abstract RFWBaseBarrage a(RFWTouchPoint paramRFWTouchPoint);
  
  public List<RFWBaseBarrage> a()
  {
    return this.c;
  }
  
  public final void a(Canvas paramCanvas, long paramLong)
  {
    b(paramCanvas, paramLong);
    a(paramCanvas, this.e, paramLong);
  }
  
  protected void a(Canvas paramCanvas, RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (paramCanvas == null) {
      return;
    }
    if (paramRFWBaseBarrage == null) {
      return;
    }
    if (paramRFWBaseBarrage.p()) {
      return;
    }
    RFWBaseBarrageRender localRFWBaseBarrageRender = this.e.a(paramRFWBaseBarrage);
    this.d.a(paramCanvas, paramRFWBaseBarrage, this.e, localRFWBaseBarrageRender);
    paramRFWBaseBarrage.k();
  }
  
  public void a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (paramRFWBaseBarrage == null) {
      return;
    }
    this.b.add(paramRFWBaseBarrage);
  }
  
  public void b()
  {
    List localList = this.c;
    if (localList == null) {
      return;
    }
    localList.clear();
  }
  
  public abstract void b(Canvas paramCanvas, long paramLong);
  
  public void b(RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (paramRFWBaseBarrage == null) {
      return;
    }
    paramRFWBaseBarrage.d(true);
    paramRFWBaseBarrage.e(true);
    float f1 = paramRFWBaseBarrage.A();
    RFWBarrageMeasureManager.a(this.e, paramRFWBaseBarrage);
    paramRFWBaseBarrage.c((paramRFWBaseBarrage.A() + paramRFWBaseBarrage.H()) / (f1 + paramRFWBaseBarrage.H()));
  }
  
  public void c() {}
  
  public abstract void d();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWAbsWindow
 * JD-Core Version:    0.7.0.1
 */