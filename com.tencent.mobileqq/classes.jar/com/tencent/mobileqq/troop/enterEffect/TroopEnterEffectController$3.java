package com.tencent.mobileqq.troop.enterEffect;

import azzp;
import bbpw;
import bbpz;
import bbqa;
import bbqb;
import bbqd;
import bbqf;
import bbqg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class TroopEnterEffectController$3
  implements Runnable
{
  public TroopEnterEffectController$3(bbpw parambbpw, bbqf parambbqf) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    bbpw.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    new azzp().a(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getWidth()).a(bbpw.jdField_a_of_type_JavaLangString + this.a.a).a(new bbqd(this)).a(new bbqg(this.this$0, localQQAppInterface, this.a)).a(new bbqb(this, localQQAppInterface)).a(new bbqa(this)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, new bbpz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3
 * JD-Core Version:    0.7.0.1
 */