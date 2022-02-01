package com.tencent.rfw.barrage.inject;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.rfw.barrage.core.RFWAbsWindow;
import com.tencent.rfw.barrage.core.RFWCacheDrawManager;
import com.tencent.rfw.barrage.core.RFWR2LWindow;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.data.RFWDefaultBarrage;
import com.tencent.rfw.barrage.data.RFWDefaultUIConfig;
import com.tencent.rfw.barrage.data.RFWViewBarrage;
import com.tencent.rfw.barrage.render.RFWBaseBarrageRender;
import com.tencent.rfw.barrage.render.RFWDefaultBarrageRender;
import com.tencent.rfw.barrage.tool.RFWBarrageDrawTimer;
import com.tencent.rfw.barrage.tool.RFWBarrageDrawableCacheManager;
import com.tencent.rfw.barrage.tool.RFWBasePlayerTimer;
import com.tencent.rfw.barrage.util.RFWDrawUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RFWBarrageContext
{
  private static final String a = "RFWBarrageContext";
  private static volatile RFWWindowConfig c;
  private static RFWDefaultUIConfig d;
  private static IRFWWindowConfigCreator i;
  private final RFWBarrageDrawableCacheManager<Drawable> b;
  private final SparseArray<IRFWBarrageUIConfig> e = new SparseArray();
  private boolean f = false;
  private IRFWBarragePlayTimeSupplier g;
  private IRFWBarrageExposureCallback h;
  private IRFWBarrageUIConfigCreator j;
  private IRFWBarrageLineHeightDecider k;
  private IRFWBarrageBarrageCreator l;
  private IRFWBarrageClearScreenCallback m;
  private List<RFWBaseBarrageRender> n;
  private RFWDefaultBarrageRender o = new RFWDefaultBarrageRender();
  private IRFWBarrageWindowCreator p;
  private int q;
  private boolean r;
  
  private RFWBarrageContext(RFWBarrageContext.Builder paramBuilder)
  {
    this.f = RFWBarrageContext.Builder.a(paramBuilder);
    this.g = RFWBarrageContext.Builder.b(paramBuilder);
    this.h = RFWBarrageContext.Builder.c(paramBuilder);
    i = RFWBarrageContext.Builder.d(paramBuilder);
    this.j = RFWBarrageContext.Builder.e(paramBuilder);
    this.k = paramBuilder.a;
    this.l = paramBuilder.b;
    this.m = RFWBarrageContext.Builder.f(paramBuilder);
    this.p = RFWBarrageContext.Builder.g(paramBuilder);
    this.q = RFWBarrageContext.Builder.h(paramBuilder);
    this.r = RFWBarrageContext.Builder.i(paramBuilder);
    this.b = new RFWBarrageDrawableCacheManager();
    a(paramBuilder);
    j();
  }
  
  public static RFWWindowConfig a()
  {
    if (c != null) {
      return c;
    }
    try
    {
      if ((c == null) && (i != null)) {
        c = i.a();
      }
      if (c == null) {
        c = new RFWWindowConfig();
      }
      return c;
    }
    finally {}
  }
  
  private void a(RFWBarrageContext.Builder paramBuilder)
  {
    this.n = new ArrayList();
    this.n.addAll(RFWBarrageContext.Builder.j(paramBuilder));
  }
  
  public static RFWDefaultUIConfig b()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new RFWDefaultUIConfig();
        }
      }
      finally {}
    }
    return d;
  }
  
  public static RFWBarrageContext.Builder i()
  {
    return new RFWBarrageContext.Builder(null);
  }
  
  private void j()
  {
    if (!this.f)
    {
      if (this.g != null) {
        return;
      }
      throw new IllegalArgumentException("Barrage module need an IBarragePlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public RFWAbsWindow a(RFWBarrageContext paramRFWBarrageContext, RFWCacheDrawManager paramRFWCacheDrawManager, Comparator<RFWBaseBarrage> paramComparator, RFWBasePlayerTimer paramRFWBasePlayerTimer, RFWBarrageDrawTimer paramRFWBarrageDrawTimer)
  {
    IRFWBarrageWindowCreator localIRFWBarrageWindowCreator = this.p;
    if (localIRFWBarrageWindowCreator != null) {
      return localIRFWBarrageWindowCreator.a(paramRFWBarrageContext, paramRFWCacheDrawManager, paramComparator, paramRFWBasePlayerTimer, paramRFWBarrageDrawTimer);
    }
    return new RFWR2LWindow(paramRFWBarrageContext, paramRFWCacheDrawManager, paramComparator, paramRFWBasePlayerTimer, paramRFWBarrageDrawTimer);
  }
  
  public IRFWBarrageUIConfig a(int paramInt)
  {
    Object localObject3 = (IRFWBarrageUIConfig)this.e.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      try
      {
        localObject3 = (IRFWBarrageUIConfig)this.e.get(paramInt);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = localObject3;
          if (this.j != null)
          {
            localObject1 = this.j.a(paramInt);
            this.e.put(paramInt, localObject1);
          }
        }
      }
      finally {}
    }
    localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = b();
    }
    return localObject3;
  }
  
  public RFWBaseBarrageRender a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    List localList = h();
    Object localObject2 = null;
    if (localList == null) {
      return null;
    }
    int i2 = localList.size();
    int i1 = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i1 >= i2) {
        break;
      }
      localObject1 = (RFWBaseBarrageRender)localList.get(i1);
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        break;
      }
      if (((RFWBaseBarrageRender)localObject1).a(paramRFWBaseBarrage)) {
        break;
      }
      i1 += 1;
    }
    paramRFWBaseBarrage = (RFWBaseBarrage)localObject1;
    if (localObject1 == null) {
      paramRFWBaseBarrage = this.o;
    }
    return paramRFWBaseBarrage;
  }
  
  public RFWBaseBarrage b(int paramInt)
  {
    if (paramInt == -2147483647) {
      return new RFWViewBarrage(this);
    }
    RFWBaseBarrage localRFWBaseBarrage = null;
    Object localObject = this.l;
    if (localObject != null) {
      localRFWBaseBarrage = ((IRFWBarrageBarrageCreator)localObject).a(this, paramInt);
    }
    localObject = localRFWBaseBarrage;
    if (localRFWBaseBarrage == null) {
      localObject = new RFWDefaultBarrage(this);
    }
    return localObject;
  }
  
  public void b(RFWBaseBarrage paramRFWBaseBarrage)
  {
    IRFWBarrageExposureCallback localIRFWBarrageExposureCallback = this.h;
    if (localIRFWBarrageExposureCallback != null) {
      localIRFWBarrageExposureCallback.a(paramRFWBaseBarrage);
    }
  }
  
  public int c()
  {
    IRFWBarrageLineHeightDecider localIRFWBarrageLineHeightDecider = this.k;
    if (localIRFWBarrageLineHeightDecider != null) {
      return localIRFWBarrageLineHeightDecider.a();
    }
    return (int)Math.ceil(RFWDrawUtils.a(a()));
  }
  
  public boolean d()
  {
    return (this.f) || (e() < 0L);
  }
  
  public long e()
  {
    IRFWBarragePlayTimeSupplier localIRFWBarragePlayTimeSupplier = this.g;
    if (localIRFWBarragePlayTimeSupplier == null) {
      return -1L;
    }
    return localIRFWBarragePlayTimeSupplier.a();
  }
  
  public void f()
  {
    this.b.a(0);
  }
  
  public int g()
  {
    return this.q;
  }
  
  public List<RFWBaseBarrageRender> h()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.inject.RFWBarrageContext
 * JD-Core Version:    0.7.0.1
 */