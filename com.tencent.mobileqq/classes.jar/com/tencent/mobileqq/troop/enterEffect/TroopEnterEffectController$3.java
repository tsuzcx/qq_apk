package com.tencent.mobileqq.troop.enterEffect;

import aybs;
import azrn;
import azrq;
import azrr;
import azrs;
import azru;
import azrw;
import azrx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class TroopEnterEffectController$3
  implements Runnable
{
  public TroopEnterEffectController$3(azrn paramazrn, azrw paramazrw) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    azrn.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    new aybs().a(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getWidth()).a(azrn.jdField_a_of_type_JavaLangString + this.a.a).a(new azru(this)).a(new azrx(this.this$0, localQQAppInterface, this.a)).a(new azrs(this, localQQAppInterface)).a(new azrr(this)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, new azrq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3
 * JD-Core Version:    0.7.0.1
 */