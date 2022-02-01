package com.tencent.mobileqq.qqexpand.match;

import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.qphone.base.util.QLog;

public class LimitChatUiStateMachine
{
  private LimitChatUiStateMachine.BaseState jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState;
  private final LimitChatUiStateMachine.ErrState jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$ErrState;
  private final LimitChatUiStateMachine.MatchingState jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$MatchingState;
  private final LimitChatUiStateMachine.UnknownState jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$UnknownState;
  
  public LimitChatUiStateMachine(ExtendFriendLimitChatManager paramExtendFriendLimitChatManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$UnknownState = new LimitChatUiStateMachine.UnknownState(this, paramExtendFriendLimitChatManager);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$MatchingState = new LimitChatUiStateMachine.MatchingState(this, paramExtendFriendLimitChatManager);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$ErrState = new LimitChatUiStateMachine.ErrState(this, paramExtendFriendLimitChatManager);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$UnknownState;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState.a;
  }
  
  public LimitChatUiStateMachine.BaseState a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        return this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$ErrState;
      }
      return this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$MatchingState;
    }
    return this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$UnknownState;
  }
  
  public void a(int paramInt)
  {
    b(paramInt, -1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState.a)
    {
      LimitChatUiStateMachine.BaseState localBaseState = a(paramInt1);
      if (localBaseState != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState.a();
        this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState = localBaseState;
        this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState.a(paramInt2);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState.a;
    if ((!this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState.a(paramInt1, paramInt2)) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("state ");
      localStringBuilder.append(i);
      localStringBuilder.append(" not handle event ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", subEvent ");
      localStringBuilder.append(paramInt2);
      QLog.e("LimitChatUiStateMachine", 2, localStringBuilder.toString());
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 101) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState.a != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState.b();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$UnknownState;
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine$BaseState.a(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.LimitChatUiStateMachine
 * JD-Core Version:    0.7.0.1
 */