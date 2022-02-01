package com.tencent.rfw.barrage.core;

import android.os.HandlerThread;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.inject.RFWWindowConfig;
import com.tencent.rfw.barrage.render.RFWBaseBarrageRender;
import com.tencent.rfw.barrage.util.RFWBarrageContentSize;
import com.tencent.rfw.barrage.util.RFWBarrageUtils;

public class RFWBarrageMeasureManager
{
  private HandlerThread a;
  private RFWBarrageContext b;
  
  public RFWBarrageMeasureManager(RFWBarrageContext paramRFWBarrageContext)
  {
    this.b = paramRFWBarrageContext;
  }
  
  public static void a(RFWBarrageContext paramRFWBarrageContext, RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (paramRFWBaseBarrage == null) {
      return;
    }
    if (paramRFWBaseBarrage.m()) {
      return;
    }
    paramRFWBarrageContext = paramRFWBarrageContext.a(paramRFWBaseBarrage);
    if (paramRFWBarrageContext == null) {
      return;
    }
    paramRFWBarrageContext = paramRFWBarrageContext.b(paramRFWBaseBarrage);
    if (paramRFWBarrageContext == null) {
      return;
    }
    paramRFWBaseBarrage.d(paramRFWBarrageContext.a() + RFWBarrageContext.a().l() * 2);
    paramRFWBaseBarrage.e(paramRFWBarrageContext.b() + RFWBarrageContext.a().d() * 2);
    paramRFWBaseBarrage.n();
  }
  
  public void a()
  {
    HandlerThread localHandlerThread = this.a;
    if (localHandlerThread != null)
    {
      if (!localHandlerThread.isAlive()) {
        return;
      }
      if (RFWBarrageUtils.a())
      {
        this.a.quitSafely();
        return;
      }
      this.a.quit();
    }
  }
  
  public void a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    a(this.b, paramRFWBaseBarrage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWBarrageMeasureManager
 * JD-Core Version:    0.7.0.1
 */