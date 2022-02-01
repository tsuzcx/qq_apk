package com.tencent.mobileqq.troop.createNewTroop;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;

class SubCateListView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  SubCateListView$3(SubCateListView paramSubCateListView, CateListAdapter.SingleItemViewHolder paramSingleItemViewHolder) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    float f = 1.0F * (100 - i) / 100.0F;
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter$SingleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setAlpha(f);
    f = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter$SingleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getHeight() / 2.0F * i / 100.0F;
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter$SingleItemViewHolder.jdField_b_of_type_AndroidViewView.setTranslationY(f);
    f = i * -180.0F / 100.0F;
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter$SingleItemViewHolder.c.setRotation(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.SubCateListView.3
 * JD-Core Version:    0.7.0.1
 */