package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;

class ReadInJoyNaviController$2
  implements Runnable
{
  ReadInJoyNaviController$2(ReadInJoyNaviController paramReadInJoyNaviController, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    Object localObject = ReadInJoyNaviController.a(this.this$0).getNaviBar();
    ReadInJoyNaviController.a(this.this$0, 1000L);
    if ((localObject != null) && (ReadInJoyNaviController.b(this.this$0)))
    {
      ReadInJoyNaviController.a(this.this$0, false);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -((View)localObject).getHeight());
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new ReadInJoyNaviController.2.1(this));
      ((View)localObject).startAnimation(localTranslateAnimation);
      if (ReadInJoyNaviController.c(this.this$0) != null)
      {
        localObject = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject).setDuration(200L);
        ((Animation)localObject).setFillEnabled(true);
        ((Animation)localObject).setFillAfter(true);
        ReadInJoyNaviController.c(this.this$0).startAnimation((Animation)localObject);
      }
      ReadInJoyNaviController.a(1, ReadInJoyNaviController.a(1, this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNaviController.2
 * JD-Core Version:    0.7.0.1
 */