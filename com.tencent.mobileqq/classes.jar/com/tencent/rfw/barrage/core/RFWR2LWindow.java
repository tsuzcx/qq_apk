package com.tencent.rfw.barrage.core;

import android.graphics.Canvas;
import android.graphics.Point;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.data.RFWR2LBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.inject.RFWWindowConfig;
import com.tencent.rfw.barrage.tool.RFWBarrageDrawTimer;
import com.tencent.rfw.barrage.tool.RFWBasePlayerTimer;
import com.tencent.rfw.barrage.tool.RFWTouchPoint;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;
import com.tencent.rfw.barrage.util.RFWBarrageUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class RFWR2LWindow
  extends RFWAbsWindow
{
  protected int i;
  protected List<List<RFWBaseBarrage>> j;
  private int k;
  private int[] l;
  private RFWBaseBarrage[] m;
  
  public RFWR2LWindow(RFWBarrageContext paramRFWBarrageContext, RFWCacheDrawManager paramRFWCacheDrawManager, Comparator<RFWBaseBarrage> paramComparator, RFWBasePlayerTimer paramRFWBasePlayerTimer, RFWBarrageDrawTimer paramRFWBarrageDrawTimer)
  {
    super(paramRFWBarrageContext, paramRFWCacheDrawManager, paramComparator, paramRFWBasePlayerTimer, paramRFWBarrageDrawTimer);
  }
  
  private void a(RFWBaseBarrage paramRFWBaseBarrage, int paramInt1, int paramInt2)
  {
    if (paramRFWBaseBarrage == null) {
      return;
    }
    if (this.g == null) {
      return;
    }
    if (this.h == null) {
      return;
    }
    paramRFWBaseBarrage.a(paramInt2, paramInt1, this.g.a(), this.h.b());
  }
  
  private void a(RFWWindowConfig paramRFWWindowConfig)
  {
    if ((this.l == null) || (this.k != paramRFWWindowConfig.b()))
    {
      this.k = paramRFWWindowConfig.b();
      n = this.k;
      this.l = new int[n];
      paramRFWWindowConfig = new RFWBaseBarrage[n];
      localObject = this.m;
      if (localObject != null) {
        System.arraycopy(localObject, 0, paramRFWWindowConfig, 0, Math.min(paramRFWWindowConfig.length, localObject.length));
      }
      this.m = paramRFWWindowConfig;
      paramRFWWindowConfig = this.j;
      if (paramRFWWindowConfig != null)
      {
        n = paramRFWWindowConfig.size();
        if (n < this.k) {
          while (n < this.k)
          {
            this.j.add(new LinkedList());
            n += 1;
          }
        }
        n -= 1;
        while (n >= this.k)
        {
          this.j.remove(n);
          n -= 1;
        }
      }
      this.j = new ArrayList(this.k);
      n = 0;
      while (n < this.k)
      {
        this.j.add(new LinkedList());
        n += 1;
      }
    }
    int i1 = this.e.c();
    Object localObject = new StringBuilder("[");
    int n = 0;
    while (n < this.k)
    {
      paramRFWWindowConfig = this.l;
      paramRFWWindowConfig[n] = (n * i1 + this.i);
      ((StringBuilder)localObject).append(paramRFWWindowConfig[n]);
      if (n != this.k - 1) {
        paramRFWWindowConfig = ", ";
      } else {
        paramRFWWindowConfig = "";
      }
      ((StringBuilder)localObject).append(paramRFWWindowConfig);
      n += 1;
    }
    ((StringBuilder)localObject).append("]");
    RFWBarrageLogger.b("RFWR2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.k), Integer.valueOf(this.i), Integer.valueOf(i1), localObject });
    a(this.j, this.l);
  }
  
  private void a(List<List<RFWBaseBarrage>> paramList, int[] paramArrayOfInt)
  {
    int i1 = paramList.size();
    int n = 0;
    while (n < i1)
    {
      Iterator localIterator = ((List)paramList.get(n)).iterator();
      while (localIterator.hasNext())
      {
        RFWR2LBarrage localRFWR2LBarrage = (RFWR2LBarrage)localIterator.next();
        localRFWR2LBarrage.a();
        long l1 = this.h.b();
        int i2 = (int)localRFWR2LBarrage.s();
        b(localRFWR2LBarrage);
        localRFWR2LBarrage.h(l1 - (int)((localRFWR2LBarrage.H() - i2) / -localRFWR2LBarrage.g()));
        localRFWR2LBarrage.i(paramArrayOfInt[n]);
        localRFWR2LBarrage.h(i2);
      }
      n += 1;
    }
  }
  
  private boolean c(RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (paramRFWBaseBarrage == null) {
      return true;
    }
    int n;
    if ((!paramRFWBaseBarrage.b(this.h.b())) && (!paramRFWBaseBarrage.a(this.g.a())) && (!d(paramRFWBaseBarrage))) {
      n = 0;
    } else {
      n = 1;
    }
    if ((n != 0) && (!paramRFWBaseBarrage.p()))
    {
      this.c.add(paramRFWBaseBarrage);
      return true;
    }
    return false;
  }
  
  private boolean d(RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (paramRFWBaseBarrage == null) {
      return false;
    }
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramRFWBaseBarrage))
      {
        RFWBarrageLogger.b("RFWR2LWindow", new Object[] { paramRFWBaseBarrage, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private void f()
  {
    int i7 = RFWBarrageContext.a().j();
    Iterator localIterator = this.b.iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      RFWBaseBarrage localRFWBaseBarrage = (RFWBaseBarrage)localIterator.next();
      localIterator.remove();
      if (!c(localRFWBaseBarrage))
      {
        if (!localRFWBaseBarrage.m()) {
          RFWBarrageMeasureManager.a(this.e, localRFWBaseBarrage);
        }
        int i2 = localRFWBaseBarrage.c(this.k);
        if (i2 >= 0) {
          i3 = i2;
        } else {
          i3 = localRFWBaseBarrage.b(this.k);
        }
        int n = 2147483647;
        int i5;
        if (i2 >= 0) {
          i5 = i3 + 1;
        } else {
          i5 = this.k + i3;
        }
        Object localObject1;
        while (i3 < i5)
        {
          int i4 = i3;
          for (;;)
          {
            i2 = this.k;
            if (i4 < i2) {
              break;
            }
            i4 -= i2;
          }
          Object localObject2 = this.m;
          localObject1 = localObject2[i4];
          if (localObject1 == null)
          {
            localObject2[i4] = localRFWBaseBarrage;
            ((List)this.j.get(i4)).add(localRFWBaseBarrage);
            this.a += 1;
            a(localRFWBaseBarrage, this.l[i4], i7);
            i2 = n;
            n = i1;
          }
          for (;;)
          {
            i1 = 1;
            break label467;
            if ((((RFWBaseBarrage)localObject1).e()) && (!((RFWBaseBarrage)localObject1).p())) {
              break label448;
            }
            localObject2 = this.h;
            i2 = i1;
            int i6 = RFWBarrageUtils.a((RFWBaseBarrage)localObject1, localRFWBaseBarrage, ((RFWBarrageDrawTimer)localObject2).b());
            i1 = n;
            if (i6 < n)
            {
              i1 = i6;
              i2 = i4;
            }
            if (i1 >= 0) {
              break;
            }
            this.m[i4] = localRFWBaseBarrage;
            ((List)this.j.get(i4)).add(localRFWBaseBarrage);
            this.a += 1;
            a(localRFWBaseBarrage, this.l[i4], i7);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.l[i4]);
            ((StringBuilder)localObject1).append(", hitTime = ");
            ((StringBuilder)localObject1).append(i1);
            RFWBarrageLogger.b("RFWR2LWindow", new Object[] { localRFWBaseBarrage, " layout success:", Integer.valueOf(i4), ",top:", ((StringBuilder)localObject1).toString() });
            n = i2;
            i2 = i1;
          }
          n = i1;
          i1 = i2;
          label448:
          i3 += 1;
        }
        int i3 = 0;
        i2 = n;
        n = i1;
        i1 = i3;
        label467:
        i3 = i1;
        if (i1 == 0)
        {
          i3 = i1;
          if (localRFWBaseBarrage.a(i2))
          {
            this.m[n] = localRFWBaseBarrage;
            ((List)this.j.get(n)).add(localRFWBaseBarrage);
            this.a += 1;
            a(localRFWBaseBarrage, this.l[n], i7);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.l[n]);
            ((StringBuilder)localObject1).append(", danmakuRepeatTime = ");
            ((StringBuilder)localObject1).append(localRFWBaseBarrage.D());
            RFWBarrageLogger.b("RFWR2LWindow", new Object[] { localRFWBaseBarrage, " layout success:", Integer.valueOf(n), ",top:", ((StringBuilder)localObject1).toString() });
            i3 = 1;
          }
        }
        if (i3 == 0)
        {
          this.c.add(localRFWBaseBarrage);
          RFWBarrageLogger.b("RFWR2LWindow", new Object[] { localRFWBaseBarrage, " can not in window" });
        }
        i1 = n;
        if (localRFWBaseBarrage.P())
        {
          i1 = n;
          if (i3 != 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("must show danmaku layout success :");
            ((StringBuilder)localObject1).append(localRFWBaseBarrage);
            RFWBarrageLogger.b("RFWR2LWindow", ((StringBuilder)localObject1).toString());
            i1 = n;
          }
        }
      }
    }
  }
  
  private void g()
  {
    int i1 = this.j.size();
    int n = 0;
    while (n < i1)
    {
      Iterator localIterator = ((List)this.j.get(n)).iterator();
      while (localIterator.hasNext())
      {
        RFWBaseBarrage localRFWBaseBarrage = (RFWBaseBarrage)localIterator.next();
        if ((!localRFWBaseBarrage.p()) && ((localRFWBaseBarrage.b(this.h.b())) || (!localRFWBaseBarrage.o())))
        {
          RFWBaseBarrage[] arrayOfRFWBaseBarrage = this.m;
          if (localRFWBaseBarrage == arrayOfRFWBaseBarrage[n]) {
            arrayOfRFWBaseBarrage[n] = null;
          }
          localIterator.remove();
          this.a -= 1;
          this.c.add(localRFWBaseBarrage);
        }
      }
      n += 1;
    }
  }
  
  public RFWBaseBarrage a(RFWTouchPoint paramRFWTouchPoint)
  {
    Object localObject = this.j;
    if (localObject == null) {
      return null;
    }
    int i1 = ((List)localObject).size();
    int n = 0;
    while (n < i1)
    {
      localObject = ((List)this.j.get(n)).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RFWBaseBarrage localRFWBaseBarrage = (RFWBaseBarrage)((Iterator)localObject).next();
        if ((localRFWBaseBarrage.E()) && (localRFWBaseBarrage.a(paramRFWTouchPoint.b.x, paramRFWTouchPoint.b.y, paramRFWTouchPoint.c, paramRFWTouchPoint.a))) {
          return localRFWBaseBarrage;
        }
      }
      n += 1;
    }
    RFWBarrageLogger.a("RFWR2LWindow", "onClick:null");
    return null;
  }
  
  public void b(Canvas paramCanvas, long paramLong)
  {
    int i1 = this.j.size();
    int n = 0;
    while (n < i1)
    {
      Iterator localIterator = ((List)this.j.get(n)).iterator();
      while (localIterator.hasNext())
      {
        RFWBaseBarrage localRFWBaseBarrage = (RFWBaseBarrage)localIterator.next();
        localRFWBaseBarrage.a(this.h.e(), this.h.b());
        if (!localRFWBaseBarrage.c(this.h.b())) {
          a(paramCanvas, localRFWBaseBarrage);
        }
      }
      n += 1;
    }
  }
  
  public void c()
  {
    RFWWindowConfig localRFWWindowConfig = RFWBarrageContext.a();
    this.i = localRFWWindowConfig.c();
    a(localRFWWindowConfig);
    a(this.j, this.l);
  }
  
  public void d()
  {
    f();
    g();
  }
  
  public void e()
  {
    int i1 = 0;
    int n = 0;
    while (n < this.k)
    {
      this.m[n] = null;
      n += 1;
    }
    Object localObject = this.j;
    if (localObject == null) {
      return;
    }
    int i2 = ((List)localObject).size();
    n = i1;
    while (n < i2)
    {
      localObject = ((List)this.j.get(n)).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RFWBaseBarrage localRFWBaseBarrage = (RFWBaseBarrage)((Iterator)localObject).next();
        ((Iterator)localObject).remove();
        this.a -= 1;
        this.c.add(localRFWBaseBarrage);
      }
      n += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWR2LWindow
 * JD-Core Version:    0.7.0.1
 */