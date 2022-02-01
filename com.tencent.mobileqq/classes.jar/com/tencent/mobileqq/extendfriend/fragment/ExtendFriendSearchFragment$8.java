package com.tencent.mobileqq.extendfriend.fragment;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ExtendFriendSearchFragment$8
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ExtendFriendSearchFragment$8(ExtendFriendSearchFragment paramExtendFriendSearchFragment, View paramView) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow((int[])localObject);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment.e = localObject[1];
    localObject = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchFragment;
    ((ExtendFriendSearchFragment)localObject).e += this.jdField_a_of_type_AndroidViewView.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment.8
 * JD-Core Version:    0.7.0.1
 */