package com.tencent.mobileqq.kandian.biz.skin;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

class SlideActiveAnimController$4
  implements View.OnClickListener
{
  SlideActiveAnimController$4(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    paramView.q = true;
    SlideActiveAnimController.a(paramView, new SlideActiveAnimController.4.1(this));
    SlideActiveAnimController.c(this.a).postDelayed(SlideActiveAnimController.b(this.a), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController.4
 * JD-Core Version:    0.7.0.1
 */