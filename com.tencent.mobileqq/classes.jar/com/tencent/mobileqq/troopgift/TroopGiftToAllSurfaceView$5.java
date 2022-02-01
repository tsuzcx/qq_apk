package com.tencent.mobileqq.troopgift;

import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.DelayAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Label;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

class TroopGiftToAllSurfaceView$5
  implements Runnable
{
  TroopGiftToAllSurfaceView$5(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    TroopGiftToAllSurfaceView.a((TroopGiftToAllSurfaceView)localObject, new Label((SpriteGLView)localObject, ((TroopGiftToAllSurfaceView)localObject).getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b));
    TroopGiftToAllSurfaceView.a(this.this$0).a(TroopGiftToAllSurfaceView.a(this.this$0).jdField_a_of_type_Int / 2, TroopGiftToAllSurfaceView.a(this.this$0).b * TroopGiftToAllSurfaceView.a(this.this$0).f / 100);
    localObject = this.this$0;
    ((TroopGiftToAllSurfaceView)localObject).a(TroopGiftToAllSurfaceView.a((TroopGiftToAllSurfaceView)localObject));
    TroopGiftToAllSurfaceView.a(this.this$0).jdField_a_of_type_Int = 0;
    localObject = new DelayAction(500);
    ((DelayAction)localObject).a(new TroopGiftToAllSurfaceView.5.1(this));
    TroopGiftToAllSurfaceView.a(this.this$0).a(new Action[] { localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView.5
 * JD-Core Version:    0.7.0.1
 */