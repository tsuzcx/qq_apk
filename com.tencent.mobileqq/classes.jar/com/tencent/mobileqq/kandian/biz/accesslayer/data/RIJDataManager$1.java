package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import mqq.os.MqqHandler;

class RIJDataManager$1
  implements Animation.AnimationListener
{
  RIJDataManager$1(RIJDataManager paramRIJDataManager, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      ThreadManager.getUIHandler().post(new RIJDataManager.1.1(this));
      return;
    }
    catch (Exception paramAnimation)
    {
      paramAnimation.printStackTrace();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.1
 * JD-Core Version:    0.7.0.1
 */