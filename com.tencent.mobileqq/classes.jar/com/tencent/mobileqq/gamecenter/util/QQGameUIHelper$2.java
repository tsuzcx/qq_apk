package com.tencent.mobileqq.gamecenter.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;

final class QQGameUIHelper$2
  implements Runnable
{
  QQGameUIHelper$2(GameSessionView paramGameSessionView, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView == null) {
      return;
    }
    Object localObject2 = new int[2];
    Object localObject1 = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow((int[])localObject2);
    localObject2[0] += this.jdField_a_of_type_AndroidViewView.getWidth() / 2;
    localObject2[1] += this.jdField_a_of_type_AndroidViewView.getHeight() / 2;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.getLocationInWindow((int[])localObject1);
    localObject1[0] += this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.getWidth() / 2;
    localObject1[1] += this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.getHeight() / 2;
    localObject2[0] -= localObject1[0];
    localObject2[1] -= localObject1[1];
    localObject1 = new ScaleAnimation(1.0F, 0.1F, 1.0F, 0.1F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject1).setDuration(300L);
    int i = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.getLeft();
    int j = this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.getTop();
    localObject2 = new TranslateAnimation(i, i + localObject2[0], j, j + localObject2[1]);
    ((TranslateAnimation)localObject2).setStartOffset(300L);
    ((TranslateAnimation)localObject2).setDuration(200L);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.setAnimationListener(new QQGameUIHelper.2.1(this));
    QQGameUIHelper.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView, false);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameUIHelper.2
 * JD-Core Version:    0.7.0.1
 */