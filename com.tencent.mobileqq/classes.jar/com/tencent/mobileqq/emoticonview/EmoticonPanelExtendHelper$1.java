package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.image.AbstractGifImage;

class EmoticonPanelExtendHelper$1
  implements ValueAnimator.AnimatorUpdateListener
{
  EmoticonPanelExtendHelper$1(EmoticonPanelExtendHelper paramEmoticonPanelExtendHelper, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i == this.val$targetHeight) {
      AbstractGifImage.resumeAll();
    }
    com.tencent.widget.XPanelContainer.a = i;
    if (EmoticonPanelExtendHelper.access$000(this.this$0).getParent() != null) {
      EmoticonPanelExtendHelper.access$000(this.this$0).getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelExtendHelper.1
 * JD-Core Version:    0.7.0.1
 */