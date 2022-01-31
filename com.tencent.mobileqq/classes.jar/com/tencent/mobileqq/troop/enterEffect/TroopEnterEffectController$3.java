package com.tencent.mobileqq.troop.enterEffect;

import axbo;
import ayqv;
import ayqy;
import ayqz;
import ayra;
import ayrc;
import ayre;
import ayrf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class TroopEnterEffectController$3
  implements Runnable
{
  public TroopEnterEffectController$3(ayqv paramayqv, ayre paramayre) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    ayqv.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    new axbo().a(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getWidth()).a(ayqv.jdField_a_of_type_JavaLangString + this.a.a).a(new ayrc(this)).a(new ayrf(this.this$0, localQQAppInterface, this.a)).a(new ayra(this, localQQAppInterface)).a(new ayqz(this)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, new ayqy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3
 * JD-Core Version:    0.7.0.1
 */