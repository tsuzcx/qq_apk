package com.tencent.mobileqq.kandian.biz.pts.item;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class CommentBiuProteusItem$2
  implements Animation.AnimationListener
{
  CommentBiuProteusItem$2(CommentBiuProteusItem paramCommentBiuProteusItem, View paramView, boolean paramBoolean, Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    if (paramAnimation != null)
    {
      if (this.b)
      {
        CommentBiuProteusItem.a(this.e, paramAnimation, this.c, this.d, false);
        return;
      }
      paramAnimation.setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.CommentBiuProteusItem.2
 * JD-Core Version:    0.7.0.1
 */