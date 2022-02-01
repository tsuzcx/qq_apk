package com.tencent.mobileqq.trooppiceffects;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class TroopPicEffectGuidePicActivity$1
  implements View.OnTouchListener
{
  TroopPicEffectGuidePicActivity$1(TroopPicEffectGuidePicActivity paramTroopPicEffectGuidePicActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      paramView.setAlpha(0.5F);
    } else if ((i == 1) || (i == 3)) {
      paramView.setAlpha(1.0F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity.1
 * JD-Core Version:    0.7.0.1
 */