package com.tencent.mobileqq.troop.enterEffect;

import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

class TroopEnterEffectController$3$4
  implements FrameSprite.OnFrameEndListener
{
  TroopEnterEffectController$3$4(TroopEnterEffectController.3 param3) {}
  
  public void a()
  {
    if (this.a.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null)
    {
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.n();
      this.a.this$0.jdField_a_of_type_AndroidOsHandler.post(new TroopEnterEffectController.3.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3.4
 * JD-Core Version:    0.7.0.1
 */