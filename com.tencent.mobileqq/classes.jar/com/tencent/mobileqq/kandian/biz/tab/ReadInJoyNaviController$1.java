package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

class ReadInJoyNaviController$1
  implements Runnable
{
  ReadInJoyNaviController$1(ReadInJoyNaviController paramReadInJoyNaviController) {}
  
  public void run()
  {
    Object localObject = ReadInJoyNaviController.a(this.this$0).getNaviBar();
    ReadInJoyNaviController.a(this.this$0, 1000L);
    if ((localObject != null) && (ReadInJoyNaviController.b(this.this$0)))
    {
      ReadInJoyNaviController.a(this.this$0, false);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -((View)localObject).getHeight(), ReadInJoyNaviController.e);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new ReadInJoyNaviController.1.1(this, (View)localObject));
      ((View)localObject).startAnimation(localTranslateAnimation);
      if (ReadInJoyNaviController.c(this.this$0) != null)
      {
        localObject = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject).setDuration(200L);
        ((Animation)localObject).setFillEnabled(true);
        ((Animation)localObject).setFillAfter(true);
        ReadInJoyNaviController.c(this.this$0).startAnimation((Animation)localObject);
      }
      ReadInJoyNaviController.a(0, ReadInJoyNaviController.a(0, null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNaviController.1
 * JD-Core Version:    0.7.0.1
 */