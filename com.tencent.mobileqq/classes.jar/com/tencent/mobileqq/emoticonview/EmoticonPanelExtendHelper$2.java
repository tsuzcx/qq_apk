package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.widget.XPanelContainer;

class EmoticonPanelExtendHelper$2
  implements ValueAnimator.AnimatorUpdateListener
{
  EmoticonPanelExtendHelper$2(EmoticonPanelExtendHelper paramEmoticonPanelExtendHelper, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    XPanelContainer.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (EmoticonPanelExtendHelper.access$000(this.this$0).getParent() != null) {
      EmoticonPanelExtendHelper.access$000(this.this$0).getParent().requestLayout();
    }
    if ((this.val$targetH == EmoticonPanelExtendHelper.access$100(this.this$0)) && (XPanelContainer.a == EmoticonPanelExtendHelper.access$100(this.this$0))) {
      this.this$0.abordFling();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelExtendHelper.2
 * JD-Core Version:    0.7.0.1
 */