package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

class TroopGiftToAllSurfaceView$2
  implements Action.OnActionEndListener
{
  TroopGiftToAllSurfaceView$2(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView) {}
  
  public void a()
  {
    if (TroopGiftToAllSurfaceView.a(this.a).d == 0) {
      this.a.a(1, TroopGiftToAllSurfaceView.a(this.a));
    }
    for (;;)
    {
      if ((TroopGiftToAllSurfaceView.a(this.a) instanceof VideoSprite)) {
        ((VideoSprite)TroopGiftToAllSurfaceView.a(this.a)).c(TroopGiftToAllSurfaceView.a(this.a));
      }
      return;
      this.a.a(0, TroopGiftToAllSurfaceView.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */