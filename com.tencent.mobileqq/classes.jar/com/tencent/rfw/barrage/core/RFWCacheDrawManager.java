package com.tencent.rfw.barrage.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.inject.RFWWindowConfig;
import com.tencent.rfw.barrage.render.RFWBaseBarrageRender;
import com.tencent.rfw.barrage.tool.RFWBitmapCacheManager;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;
import com.tencent.rfw.barrage.util.RFWBarrageUtils;

public class RFWCacheDrawManager
{
  private final RFWBitmapCacheManager a = new RFWBitmapCacheManager();
  private HandlerThread b;
  
  public Bitmap a(RFWBaseBarrage paramRFWBaseBarrage, RFWBarrageContext paramRFWBarrageContext)
  {
    if (paramRFWBaseBarrage == null)
    {
      RFWBarrageLogger.a("RFWCacheDrawManager", "[fetchBitmapCache] error.", new RuntimeException("barrage should be null."));
      return null;
    }
    if (paramRFWBaseBarrage == null) {}
    try
    {
      RFWBarrageLogger.a("RFWCacheDrawManager", "[fetchBitmapCache] error.", new RuntimeException("barrage should be null."));
      return null;
    }
    finally {}
    if (paramRFWBaseBarrage.L())
    {
      Object localObject2 = paramRFWBaseBarrage.K();
      Object localObject1;
      if (localObject2 == null)
      {
        localObject1 = this.a.a((int)paramRFWBaseBarrage.A(), (int)paramRFWBaseBarrage.B());
      }
      else if (((Bitmap)localObject2).getWidth() >= (int)paramRFWBaseBarrage.A())
      {
        localObject1 = localObject2;
        if (((Bitmap)localObject2).getHeight() >= (int)paramRFWBaseBarrage.B()) {}
      }
      else
      {
        this.a.a((Bitmap)localObject2);
        localObject1 = this.a.a((int)paramRFWBaseBarrage.A(), (int)paramRFWBaseBarrage.B());
      }
      paramRFWBaseBarrage.a((Bitmap)localObject1);
      if (localObject1 == null) {
        return null;
      }
      localObject2 = paramRFWBaseBarrage.N();
      if (localObject2 == null)
      {
        localObject2 = new Canvas((Bitmap)localObject1);
        paramRFWBaseBarrage.a((Canvas)localObject2);
      }
      else
      {
        ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
      }
      ((Bitmap)localObject1).eraseColor(0);
      paramRFWBaseBarrage.d(false);
      RFWBaseBarrageRender localRFWBaseBarrageRender = paramRFWBarrageContext.a(paramRFWBaseBarrage);
      if (localRFWBaseBarrageRender == null) {
        return localObject1;
      }
      localRFWBaseBarrageRender.a((Canvas)localObject2, paramRFWBaseBarrage, paramRFWBarrageContext, RFWBarrageContext.a().l(), RFWBarrageContext.a().d());
      return localObject1;
    }
    paramRFWBaseBarrage = paramRFWBaseBarrage.K();
    return paramRFWBaseBarrage;
  }
  
  public void a()
  {
    HandlerThread localHandlerThread = this.b;
    if (localHandlerThread != null)
    {
      if (!localHandlerThread.isAlive()) {
        return;
      }
      if (RFWBarrageUtils.a())
      {
        this.b.quitSafely();
        return;
      }
      this.b.quit();
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    RFWBitmapCacheManager localRFWBitmapCacheManager = this.a;
    if (localRFWBitmapCacheManager == null) {
      return;
    }
    localRFWBitmapCacheManager.a(paramBitmap);
  }
  
  public void b()
  {
    RFWBitmapCacheManager localRFWBitmapCacheManager = this.a;
    if (localRFWBitmapCacheManager == null) {
      return;
    }
    localRFWBitmapCacheManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWCacheDrawManager
 * JD-Core Version:    0.7.0.1
 */