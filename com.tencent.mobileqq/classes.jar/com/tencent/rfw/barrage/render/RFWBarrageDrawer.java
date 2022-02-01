package com.tencent.rfw.barrage.render;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.rfw.barrage.core.RFWCacheDrawManager;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.inject.RFWWindowConfig;

public class RFWBarrageDrawer
{
  private final Matrix a = new Matrix();
  private final RFWCacheDrawManager b;
  private final Paint c = new Paint();
  
  public RFWBarrageDrawer(RFWCacheDrawManager paramRFWCacheDrawManager)
  {
    this.b = paramRFWCacheDrawManager;
  }
  
  private boolean a(Canvas paramCanvas, RFWBaseBarrage paramRFWBaseBarrage, RFWBarrageContext paramRFWBarrageContext)
  {
    paramRFWBarrageContext = this.b.a(paramRFWBaseBarrage, paramRFWBarrageContext);
    if (paramRFWBarrageContext == null) {
      return false;
    }
    float f1 = paramRFWBaseBarrage.s();
    float f2 = paramRFWBaseBarrage.t();
    this.a.setTranslate(f1, f2);
    paramCanvas.drawBitmap(paramRFWBarrageContext, this.a, this.c);
    return true;
  }
  
  private void b(Canvas paramCanvas, RFWBaseBarrage paramRFWBaseBarrage, RFWBarrageContext paramRFWBarrageContext, RFWBaseBarrageRender paramRFWBaseBarrageRender)
  {
    int i = paramCanvas.save();
    paramRFWBaseBarrageRender.a(paramCanvas, paramRFWBaseBarrage, paramRFWBarrageContext, paramRFWBaseBarrage.F(), paramRFWBaseBarrage.G());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, RFWBaseBarrage paramRFWBaseBarrage, RFWBarrageContext paramRFWBarrageContext, RFWBaseBarrageRender paramRFWBaseBarrageRender)
  {
    if (paramCanvas == null) {
      return;
    }
    if (paramRFWBaseBarrage == null) {
      return;
    }
    if (paramRFWBaseBarrage.J())
    {
      if (a(paramCanvas, paramRFWBaseBarrage, paramRFWBarrageContext)) {
        return;
      }
      RFWWindowConfig.a(false);
    }
    b(paramCanvas, paramRFWBaseBarrage, paramRFWBarrageContext, paramRFWBaseBarrageRender);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.render.RFWBarrageDrawer
 * JD-Core Version:    0.7.0.1
 */