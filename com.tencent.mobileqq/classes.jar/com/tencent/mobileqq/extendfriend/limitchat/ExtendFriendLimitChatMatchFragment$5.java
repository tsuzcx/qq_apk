package com.tencent.mobileqq.extendfriend.limitchat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView;

class ExtendFriendLimitChatMatchFragment$5
  extends AnimatorListenerAdapter
{
  ExtendFriendLimitChatMatchFragment$5(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment, MatchingView paramMatchingView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    ExtendFriendLimitChatMatchFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.a();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetMatchingView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment.5
 * JD-Core Version:    0.7.0.1
 */