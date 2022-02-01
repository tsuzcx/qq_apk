package com.tencent.mobileqq.troop.troopcreate.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;

class SubCateListView$2
  extends AnimatorListenerAdapter
{
  SubCateListView$2(SubCateListView paramSubCateListView, boolean paramBoolean, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    int j = 0;
    int i = j;
    if (!this.jdField_a_of_type_Boolean)
    {
      paramAnimator = new int[2];
      this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(paramAnimator);
      int k = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiSubCateListView.jdField_a_of_type_AndroidContentContext).b() - paramAnimator[1];
      int m = this.jdField_a_of_type_Int;
      i = j;
      if (k < m) {
        i = m - k;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiSubCateListView.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiSubCateListView$OnToggleSubListListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiSubCateListView.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiSubCateListView$OnToggleSubListListener.a(true ^ this.jdField_a_of_type_Boolean, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.SubCateListView.2
 * JD-Core Version:    0.7.0.1
 */