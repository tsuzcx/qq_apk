package com.tencent.mobileqq.gamecenter.web;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import avgi;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;

public class QQGameFeedWebFragment$16
  implements Runnable
{
  QQGameFeedWebFragment$16(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
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
    localObject2 = new TranslateAnimation(i, i + localObject2[0], j, j + localObject2[1]);
    ((TranslateAnimation)localObject2).setStartOffset(300L);
    ((TranslateAnimation)localObject2).setDuration(200L);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.setAnimationListener(new avgi(this));
    QQGameFeedWebFragment.a(this.this$0, QQGameFeedWebFragment.a(this.this$0), false);
    QQGameFeedWebFragment.a(this.this$0).startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.16
 * JD-Core Version:    0.7.0.1
 */