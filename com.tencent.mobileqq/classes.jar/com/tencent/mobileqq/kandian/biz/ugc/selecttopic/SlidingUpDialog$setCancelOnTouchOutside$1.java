package com.tencent.mobileqq.kandian.biz.ugc.selecttopic;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class SlidingUpDialog$setCancelOnTouchOutside$1
  implements View.OnTouchListener
{
  SlidingUpDialog$setCancelOnTouchOutside$1(SlidingUpDialog paramSlidingUpDialog) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.dismiss();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selecttopic.SlidingUpDialog.setCancelOnTouchOutside.1
 * JD-Core Version:    0.7.0.1
 */