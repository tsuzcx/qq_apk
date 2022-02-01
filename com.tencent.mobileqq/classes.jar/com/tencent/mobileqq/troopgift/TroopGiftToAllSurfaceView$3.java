package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton;

class TroopGiftToAllSurfaceView$3
  implements Action.OnActionEndListener
{
  TroopGiftToAllSurfaceView$3(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView) {}
  
  public void a()
  {
    SequenceAction localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(400, TroopGiftToAllSurfaceView.d(this.a), TroopGiftToAllSurfaceView.d(this.a) * 0.95F), new ScaleAction(400, TroopGiftToAllSurfaceView.d(this.a) * 0.95F, TroopGiftToAllSurfaceView.d(this.a)) });
    localSequenceAction.i = true;
    TroopGiftToAllSurfaceView.e(this.a).a(new Action[] { localSequenceAction });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView.3
 * JD-Core Version:    0.7.0.1
 */