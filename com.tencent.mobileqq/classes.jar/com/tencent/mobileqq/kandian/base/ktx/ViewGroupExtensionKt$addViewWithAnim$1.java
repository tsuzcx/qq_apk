package com.tencent.mobileqq.kandian.base.ktx;

import android.view.View;
import android.view.animation.Animation;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ViewGroupExtensionKt$addViewWithAnim$1
  implements Runnable
{
  ViewGroupExtensionKt$addViewWithAnim$1(View paramView, Animation paramAnimation) {}
  
  public final void run()
  {
    this.a.setVisibility(0);
    this.a.startAnimation(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.ViewGroupExtensionKt.addViewWithAnim.1
 * JD-Core Version:    0.7.0.1
 */