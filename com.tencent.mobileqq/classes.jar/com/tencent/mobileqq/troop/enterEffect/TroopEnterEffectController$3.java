package com.tencent.mobileqq.troop.enterEffect;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

class TroopEnterEffectController$3
  implements Runnable
{
  TroopEnterEffectController$3(TroopEnterEffectController paramTroopEnterEffectController, TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    TroopEnterEffectController.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    new SceneBuilder().a(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getWidth()).a(TroopEnterEffectController.jdField_a_of_type_JavaLangString + this.a.a).a(new TroopEnterEffectController.3.4(this)).a(new TroopEnterEffectController.TroopEnterEffectLabelTextHandle(this.this$0, localQQAppInterface, this.a)).a(new TroopEnterEffectController.3.3(this, localQQAppInterface)).a(new TroopEnterEffectController.3.2(this)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, new TroopEnterEffectController.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3
 * JD-Core Version:    0.7.0.1
 */