package com.tencent.mobileqq.trooppiceffects;

class TroopPicEffectsController$2
  implements Runnable
{
  TroopPicEffectsController$2(TroopPicEffectsController paramTroopPicEffectsController, TroopPicEffectsController.OnAnimationEndListener paramOnAnimationEndListener) {}
  
  public void run()
  {
    this.this$0.a();
    TroopPicEffectsController.OnAnimationEndListener localOnAnimationEndListener = this.a;
    if (localOnAnimationEndListener != null) {
      localOnAnimationEndListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController.2
 * JD-Core Version:    0.7.0.1
 */