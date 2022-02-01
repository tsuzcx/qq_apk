package com.tencent.mobileqq.listentogether.lyrics;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class LyricsController$13
  implements ValueAnimator.AnimatorUpdateListener
{
  LyricsController$13(LyricsController paramLyricsController, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.b)
    {
      paramValueAnimator.cancel();
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      return;
    }
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = this.jdField_a_of_type_Int;
    i = (int)(i + (this.b - i) * f1 + 0.5F);
    int j = this.c;
    j = (int)(j + (this.d - j) * f1 + 0.5F);
    int k = this.e;
    k = (int)(k + (this.f - k) * f1 + 0.5F);
    int m = this.g;
    m = (int)(m + (this.h - m) * f1 + 0.5F);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(i, j);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(k, m);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.13
 * JD-Core Version:    0.7.0.1
 */