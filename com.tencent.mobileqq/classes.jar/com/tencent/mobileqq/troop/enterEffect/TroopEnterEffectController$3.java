package com.tencent.mobileqq.troop.enterEffect;

import bdxx;
import bftx;
import bfua;
import bfub;
import bfuc;
import bfue;
import bfug;
import bfuh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class TroopEnterEffectController$3
  implements Runnable
{
  public TroopEnterEffectController$3(bftx parambftx, bfug parambfug) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null) {
      return;
    }
    bftx.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    new bdxx().a(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getWidth()).a(bftx.jdField_a_of_type_JavaLangString + this.a.a).a(new bfue(this)).a(new bfuh(this.this$0, localQQAppInterface, this.a)).a(new bfuc(this, localQQAppInterface)).a(new bfub(this)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, new bfua(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3
 * JD-Core Version:    0.7.0.1
 */