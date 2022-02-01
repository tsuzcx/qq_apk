package com.tencent.rfw.barrage.core;

import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.tool.RFWTouchPoint;
import java.lang.ref.WeakReference;

class RFWBarrageManager$ClickBarrageRunnableImpl
  implements Runnable
{
  private final WeakReference<RFWBarrageManager> a;
  private final WeakReference<RFWBaseBarrage> b;
  private RFWTouchPoint c;
  
  public RFWBarrageManager$ClickBarrageRunnableImpl(RFWBarrageManager paramRFWBarrageManager, RFWTouchPoint paramRFWTouchPoint, RFWBaseBarrage paramRFWBaseBarrage)
  {
    this.a = new WeakReference(paramRFWBarrageManager);
    this.b = new WeakReference(paramRFWBaseBarrage);
    this.c = paramRFWTouchPoint;
  }
  
  public void run()
  {
    RFWBarrageManager localRFWBarrageManager = (RFWBarrageManager)this.a.get();
    if (localRFWBarrageManager == null) {
      return;
    }
    RFWBarrageManager.a(localRFWBarrageManager, this.c, (RFWBaseBarrage)this.b.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWBarrageManager.ClickBarrageRunnableImpl
 * JD-Core Version:    0.7.0.1
 */