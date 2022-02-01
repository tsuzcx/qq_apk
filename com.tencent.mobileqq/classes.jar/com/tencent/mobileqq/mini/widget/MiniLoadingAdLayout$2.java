package com.tencent.mobileqq.mini.widget;

import android.animation.ObjectAnimator;
import com.tencent.mobileqq.utils.ViewUtils;

class MiniLoadingAdLayout$2
  implements Runnable
{
  MiniLoadingAdLayout$2(MiniLoadingAdLayout paramMiniLoadingAdLayout) {}
  
  public void run()
  {
    float f = ViewUtils.b(70.0F);
    ObjectAnimator.ofFloat(MiniLoadingAdLayout.access$300(this.this$0), "translationY", new float[] { 0.0F, -f }).setDuration(500L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.2
 * JD-Core Version:    0.7.0.1
 */