package com.tencent.rfw.barrage.render;

import android.graphics.Canvas;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.util.RFWBarrageContentSize;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class RFWBaseBarrageRender<D extends RFWBaseBarrage>
{
  private ArrayList<IRFWBarrageOverlayDrawer> a;
  
  private void c(Canvas paramCanvas, D paramD, RFWBarrageContext paramRFWBarrageContext, float paramFloat1, float paramFloat2)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IRFWBarrageOverlayDrawer)((Iterator)localObject).next()).a(paramCanvas, paramD, paramRFWBarrageContext, paramFloat1, paramFloat2);
      }
    }
  }
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, D paramD, RFWBarrageContext paramRFWBarrageContext, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramRFWBarrageContext, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramRFWBarrageContext, paramFloat1, paramFloat2);
  }
  
  public abstract boolean a(RFWBaseBarrage paramRFWBaseBarrage);
  
  public abstract RFWBarrageContentSize b(D paramD);
  
  public abstract void b(Canvas paramCanvas, D paramD, RFWBarrageContext paramRFWBarrageContext, float paramFloat1, float paramFloat2);
  
  public void c(D paramD) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.render.RFWBaseBarrageRender
 * JD-Core Version:    0.7.0.1
 */