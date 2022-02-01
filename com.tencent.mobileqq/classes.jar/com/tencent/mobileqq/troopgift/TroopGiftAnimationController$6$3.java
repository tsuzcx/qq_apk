package com.tencent.mobileqq.troopgift;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troop.utils.TroopUtils;

class TroopGiftAnimationController$6$3
  implements URLDrawable.URLDrawableListener
{
  TroopGiftAnimationController$6$3(TroopGiftAnimationController.6 param6, URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6.this$0.a == null) {
      return;
    }
    paramURLDrawable = TroopUtils.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$6.this$0.a.b(new TroopGiftAnimationController.6.3.1(this, paramURLDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.6.3
 * JD-Core Version:    0.7.0.1
 */