package com.tencent.mobileqq.troop.enterEffect;

import bdyn;
import bfkl;
import bfko;
import bfkp;
import bfkq;
import bfks;
import bfku;
import bfkv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class TroopEnterEffectController$3
  implements Runnable
{
  public TroopEnterEffectController$3(bfkl parambfkl, bfku parambfku) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    bfkl.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    new bdyn().a(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getWidth()).a(bfkl.jdField_a_of_type_JavaLangString + this.a.a).a(new bfks(this)).a(new bfkv(this.this$0, localQQAppInterface, this.a)).a(new bfkq(this, localQQAppInterface)).a(new bfkp(this)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, new bfko(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3
 * JD-Core Version:    0.7.0.1
 */