package com.tencent.rfw.barrage.core;

import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.data.RFWBaseBarrage.OnLeftBarrageListener;
import java.lang.ref.WeakReference;

class RFWBarrageManager$HitLeftSideCallback
  implements RFWBaseBarrage.OnLeftBarrageListener
{
  private WeakReference<RFWBarrageManager> a;
  
  public RFWBarrageManager$HitLeftSideCallback(RFWBarrageManager paramRFWBarrageManager)
  {
    this.a = new WeakReference(paramRFWBarrageManager);
  }
  
  public void a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (RFWBarrageManager)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    RFWBarrageManager.a((RFWBarrageManager)localObject, paramRFWBaseBarrage);
  }
  
  public void b(RFWBaseBarrage paramRFWBaseBarrage)
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (RFWBarrageManager)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    RFWBarrageManager.b((RFWBarrageManager)localObject, paramRFWBaseBarrage);
  }
  
  public void c(RFWBaseBarrage paramRFWBaseBarrage)
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (RFWBarrageManager)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    RFWBarrageManager.c((RFWBarrageManager)localObject, paramRFWBaseBarrage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWBarrageManager.HitLeftSideCallback
 * JD-Core Version:    0.7.0.1
 */