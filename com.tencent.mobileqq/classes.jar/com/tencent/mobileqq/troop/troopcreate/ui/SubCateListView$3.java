package com.tencent.mobileqq.troop.troopcreate.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;

class SubCateListView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  SubCateListView$3(SubCateListView paramSubCateListView, SingleItemViewHolder paramSingleItemViewHolder) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    float f1 = (100 - i) * 1.0F / 100.0F;
    this.a.g.setAlpha(f1);
    float f2 = this.a.g.getHeight() / 2.0F;
    f1 = i;
    f2 = f2 * f1 / 100.0F;
    this.a.e.setTranslationY(f2);
    f1 = f1 * -180.0F / 100.0F;
    this.a.h.setRotation(f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.SubCateListView.3
 * JD-Core Version:    0.7.0.1
 */