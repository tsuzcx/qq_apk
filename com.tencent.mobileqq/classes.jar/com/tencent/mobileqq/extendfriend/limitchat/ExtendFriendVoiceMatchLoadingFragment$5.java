package com.tencent.mobileqq.extendfriend.limitchat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView;

class ExtendFriendVoiceMatchLoadingFragment$5
  extends AnimatorListenerAdapter
{
  ExtendFriendVoiceMatchLoadingFragment$5(ExtendFriendVoiceMatchLoadingFragment paramExtendFriendVoiceMatchLoadingFragment, MatchingView paramMatchingView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.a();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendVoiceMatchLoadingFragment.5
 * JD-Core Version:    0.7.0.1
 */