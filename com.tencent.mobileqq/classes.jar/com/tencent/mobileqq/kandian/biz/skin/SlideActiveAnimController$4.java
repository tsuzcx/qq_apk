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
    paramView.d = true;
    SlideActiveAnimController.a(paramView, new SlideActiveAnimController.4.1(this));
    SlideActiveAnimController.a(this.a).postDelayed(SlideActiveAnimController.a(this.a), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController.4
 * JD-Core Version:    0.7.0.1
 */