package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

class TroopGiftToAllSurfaceView$2
  implements Action.OnActionEndListener
{
  TroopGiftToAllSurfaceView$2(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView) {}
  
  public void a()
  {
    TroopGiftToAllSurfaceView localTroopGiftToAllSurfaceView;
    if (TroopGiftToAllSurfaceView.a(this.a).e == 0)
    {
      localTroopGiftToAllSurfaceView = this.a;
      localTroopGiftToAllSurfaceView.a(1, TroopGiftToAllSurfaceView.b(localTroopGiftToAllSurfaceView));
    }
    else
    {
      localTroopGiftToAllSurfaceView = this.a;
      localTroopGiftToAllSurfaceView.a(0, TroopGiftToAllSurfaceView.b(localTroopGiftToAllSurfaceView));
    }
    if ((TroopGiftToAllSurfaceView.b(this.a) instanceof VideoSprite)) {
      ((VideoSprite)TroopGiftToAllSurfaceView.b(this.a)).c(TroopGiftToAllSurfaceView.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */