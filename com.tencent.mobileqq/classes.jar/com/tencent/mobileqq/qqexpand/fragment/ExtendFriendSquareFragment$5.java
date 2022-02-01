package com.tencent.mobileqq.qqexpand.fragment;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ExtendFriendSquareFragment$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ExtendFriendSquareFragment$5(ExtendFriendSquareFragment paramExtendFriendSquareFragment, View paramView) {}
  
  public void onGlobalLayout()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow(arrayOfInt);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment.f = arrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.5
 * JD-Core Version:    0.7.0.1
 */