package com.tencent.mobileqq.extendfriend.limitchat;

import com.tencent.qphone.base.util.QLog;

public class LimitChatUiStateMachine$BaseState
{
  public int a;
  protected ExtendFriendLimitChatManager a;
  protected LimitChatUiStateMachine a;
  
  public LimitChatUiStateMachine$BaseState(LimitChatUiStateMachine paramLimitChatUiStateMachine, ExtendFriendLimitChatManager paramExtendFriendLimitChatManager)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager = paramExtendFriendLimitChatManager;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine = paramLimitChatUiStateMachine;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUiStateMachine", 2, "state " + this.jdField_a_of_type_Int + " onEnd");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUiStateMachine", 2, "state " + this.jdField_a_of_type_Int + " onStart subinfo:" + paramInt);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUiStateMachine", 2, "state " + this.jdField_a_of_type_Int + " start handle event " + paramInt1 + ", subEvent " + paramInt2);
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUiStateMachine", 2, "state " + this.jdField_a_of_type_Int + " onForceEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.LimitChatUiStateMachine.BaseState
 * JD-Core Version:    0.7.0.1
 */