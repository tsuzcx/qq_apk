package com.tencent.mobileqq.qqexpand.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.qqexpand.widget.MatchingView;

class ExtendFriendVoiceMatchLoadingFragment$5
  extends AnimatorListenerAdapter
{
  ExtendFriendVoiceMatchLoadingFragment$5(ExtendFriendVoiceMatchLoadingFragment paramExtendFriendVoiceMatchLoadingFragment, MatchingView paramMatchingView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetMatchingView.a();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetMatchingView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendVoiceMatchLoadingFragment.5
 * JD-Core Version:    0.7.0.1
 */