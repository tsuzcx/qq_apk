package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewParent;
import com.tencent.widget.XPanelContainer;

class EmoticonPanelExtendHelper$3
  implements ValueAnimator.AnimatorUpdateListener
{
  EmoticonPanelExtendHelper$3(EmoticonPanelExtendHelper paramEmoticonPanelExtendHelper, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (EmoticonPanelExtendHelper.access$300(this.this$0) == null) {
      return;
    }
    XPanelContainer.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (EmoticonPanelExtendHelper.access$000(this.this$0).getParent() != null) {
      EmoticonPanelExtendHelper.access$000(this.this$0).getParent().requestLayout();
    }
    if ((this.val$targetH == EmoticonPanelExtendHelper.access$100(this.this$0)) && (XPanelContainer.a == EmoticonPanelExtendHelper.access$100(this.this$0))) {
      this.this$0.abortFling();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelExtendHelper.3
 * JD-Core Version:    0.7.0.1
 */