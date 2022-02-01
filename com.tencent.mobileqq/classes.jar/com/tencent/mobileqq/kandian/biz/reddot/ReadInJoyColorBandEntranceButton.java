package com.tencent.mobileqq.kandian.biz.reddot;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;

public class ReadInJoyColorBandEntranceButton
  extends ColorBandVideoEntranceButton
{
  private int a;
  
  public ReadInJoyColorBandEntranceButton(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
  }
  
  public ReadInJoyColorBandEntranceButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void c()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      super.c();
      return;
    }
    AnimatorSet localAnimatorSet;
    if (i == 1)
    {
      i = getResources().getInteger(2131427368);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setImageDrawable(getResources().getDrawable(2130849666));
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setVisibility(0);
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView, "translationX", new float[] { 0.0F, -AIOUtils.b(58.0F, getResources()) }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView, "translationY", new float[] { 0.0F, AIOUtils.b(54.0F, getResources()) }) });
      localAnimatorSet.setDuration(i);
      localAnimatorSet.addListener(new ReadInJoyColorBandEntranceButton.1(this));
      localAnimatorSet.start();
      return;
    }
    if (i == 2)
    {
      i = getResources().getInteger(2131427369);
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.b, "rotation", new float[] { 0.0F, 360.0F }) });
      localAnimatorSet.setDuration(i);
      localAnimatorSet.start();
    }
  }
  
  public void setClickAnimMode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyColorBandEntranceButton
 * JD-Core Version:    0.7.0.1
 */