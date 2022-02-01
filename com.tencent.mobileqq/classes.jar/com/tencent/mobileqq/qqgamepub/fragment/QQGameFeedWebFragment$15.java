package com.tencent.mobileqq.qqgamepub.fragment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.qqgamepub.view.GameSessionView;

class QQGameFeedWebFragment$15
  implements Runnable
{
  QQGameFeedWebFragment$15(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void run()
  {
    Object localObject2 = new int[2];
    Object localObject1 = new int[2];
    QQGameFeedWebFragment.a(this.this$0).getLocationInWindow((int[])localObject2);
    localObject2[0] += QQGameFeedWebFragment.a(this.this$0).getWidth() / 2;
    localObject2[1] += QQGameFeedWebFragment.a(this.this$0).getHeight() / 2;
    QQGameFeedWebFragment.a(this.this$0).getLocationInWindow((int[])localObject1);
    localObject1[0] += QQGameFeedWebFragment.a(this.this$0).getWidth() / 2;
    localObject1[1] += QQGameFeedWebFragment.a(this.this$0).getHeight() / 2;
    localObject2[0] -= localObject1[0];
    localObject2[1] -= localObject1[1];
    localObject1 = new ScaleAnimation(1.0F, 0.1F, 1.0F, 0.1F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject1).setDuration(300L);
    int i = QQGameFeedWebFragment.a(this.this$0).getLeft();
    int j = QQGameFeedWebFragment.a(this.this$0).getTop();
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(i, i + localObject2[0], j, j + localObject2[1]);
    localTranslateAnimation.setStartOffset(300L);
    localTranslateAnimation.setDuration(200L);
    localObject2 = new AnimationSet(false);
    ((AnimationSet)localObject2).addAnimation((Animation)localObject1);
    ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
    ((AnimationSet)localObject2).setAnimationListener(new QQGameFeedWebFragment.15.1(this));
    localObject1 = this.this$0;
    QQGameFeedWebFragment.a((QQGameFeedWebFragment)localObject1, QQGameFeedWebFragment.a((QQGameFeedWebFragment)localObject1), false);
    QQGameFeedWebFragment.a(this.this$0).startAnimation((Animation)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.15
 * JD-Core Version:    0.7.0.1
 */