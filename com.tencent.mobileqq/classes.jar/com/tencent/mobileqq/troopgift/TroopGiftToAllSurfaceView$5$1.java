package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.OpacityAction;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Label;

class TroopGiftToAllSurfaceView$5$1
  implements Action.OnActionEndListener
{
  TroopGiftToAllSurfaceView$5$1(TroopGiftToAllSurfaceView.5 param5) {}
  
  public void a()
  {
    TroopGiftToAllSurfaceView.a(this.a.this$0).a(new Action[] { new OpacityAction(600, 0, 255), new SequenceAction(new Action[] { new ScaleAction(300, 0.0F, 1.2F), new ScaleAction(300, 1.2F, 1.0F) }) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView.5.1
 * JD-Core Version:    0.7.0.1
 */