package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class VideofeedsUserGuideController$4
  implements Runnable
{
  VideofeedsUserGuideController$4(VideofeedsUserGuideController paramVideofeedsUserGuideController) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = VideofeedsUserGuideController.d(this.this$0);
    if (localTranslateAnimation != null)
    {
      VideofeedsUserGuideController.a(this.this$0).setVisibility(0);
      VideofeedsUserGuideController.a(this.this$0).findViewById(2131449246).setVisibility(0);
      VideofeedsUserGuideController.a(this.this$0).findViewById(2131449242).setVisibility(0);
      VideofeedsUserGuideController.a(this.this$0).findViewById(2131449243).setVisibility(0);
      VideofeedsUserGuideController.a(this.this$0).bringToFront();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)VideofeedsUserGuideController.a(this.this$0).getLayoutParams();
      localMarginLayoutParams.setMargins(0, 0, 0, AIOUtils.b(187.0F, VideofeedsUserGuideController.e(this.this$0).getResources()));
      VideofeedsUserGuideController.a(this.this$0).setLayoutParams(localMarginLayoutParams);
      VideofeedsUserGuideController.a(this.this$0).startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideofeedsUserGuideController.4
 * JD-Core Version:    0.7.0.1
 */