package com.tencent.mobileqq.tribe;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ListView;
import com.tencent.mobileqq.util.DisplayUtil;

class TribePostTitlePrefixPanelController$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TribePostTitlePrefixPanelController$1(TribePostTitlePrefixPanelController paramTribePostTitlePrefixPanelController) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    TribePostTitlePrefixPanelController.a(this.a).setPadding(DisplayUtil.a(TribePostTitlePrefixPanelController.a(this.a).getContext(), 8.0F), i, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.TribePostTitlePrefixPanelController.1
 * JD-Core Version:    0.7.0.1
 */