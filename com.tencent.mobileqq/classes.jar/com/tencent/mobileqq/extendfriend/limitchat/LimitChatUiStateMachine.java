package com.tencent.mobileqq.extendfriend.limitchat;

import com.tencent.qphone.base.util.QLog;

public class LimitChatUiStateMachine
{
  private LimitChatUiStateMachine.BaseState jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState;
  private LimitChatUiStateMachine.ErrState jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$ErrState;
  private LimitChatUiStateMachine.MatchingState jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$MatchingState;
  private LimitChatUiStateMachine.UnknownState jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$UnknownState;
  
  public LimitChatUiStateMachine(ExtendFriendLimitChatManager paramExtendFriendLimitChatManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$UnknownState = new LimitChatUiStateMachine.UnknownState(this, paramExtendFriendLimitChatManager);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$MatchingState = new LimitChatUiStateMachine.MatchingState(this, paramExtendFriendLimitChatManager);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$ErrState = new LimitChatUiStateMachine.ErrState(this, paramExtendFriendLimitChatManager);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState = this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$UnknownState;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState.a;
  }
  
  public LimitChatUiStateMachine.BaseState a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$ErrState;
    case 0: 
      return this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$UnknownState;
    }
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$MatchingState;
  }
  
  public void a(int paramInt)
  {
    b(paramInt, -1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState.a)
    {
      LimitChatUiStateMachine.BaseState localBaseState = a(paramInt1);
      if (localBaseState != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState.a();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState = localBaseState;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState.a(paramInt2);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState.a;
    if ((!this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState.a(paramInt1, paramInt2)) && (QLog.isColorLevel())) {
      QLog.e("LimitChatUiStateMachine", 2, "state " + i + " not handle event " + paramInt1 + ", subEvent " + paramInt2);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState.a == 0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState.b();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState = this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$UnknownState;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine$BaseState.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.LimitChatUiStateMachine
 * JD-Core Version:    0.7.0.1
 */