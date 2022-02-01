package com.tencent.mobileqq.flashshow.part;

import android.animation.ValueAnimator;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;

class FSMainMultiTabFragmentPart$6
  implements Runnable
{
  FSMainMultiTabFragmentPart$6(FSMainMultiTabFragmentPart paramFSMainMultiTabFragmentPart) {}
  
  public void run()
  {
    if (FSMainMultiTabFragmentPart.f(this.this$0) == null) {
      return;
    }
    FSMainMultiTabFragmentPart.f(this.this$0).setAlpha(1.0F);
    FSMainMultiTabFragmentPart.a(this.this$0, new ValueAnimator());
    float f = FSMainMultiTabFragmentPart.f(this.this$0).getTranslationY();
    FSMainMultiTabFragmentPart.g(this.this$0).setFloatValues(new float[] { f, 0.0F });
    FSMainMultiTabFragmentPart.g(this.this$0).setDuration(300L);
    FSMainMultiTabFragmentPart.g(this.this$0).addUpdateListener(new FSMainMultiTabFragmentPart.6.1(this, f));
    FSMainMultiTabFragmentPart.g(this.this$0).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSMainMultiTabFragmentPart.6
 * JD-Core Version:    0.7.0.1
 */