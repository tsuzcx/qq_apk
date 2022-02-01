package com.tencent.mobileqq.qqexpand.match;

import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;

public class LimitChatUiStateMachine$MatchingState
  extends LimitChatUiStateMachine.BaseState
{
  public LimitChatUiStateMachine$MatchingState(LimitChatUiStateMachine paramLimitChatUiStateMachine, ExtendFriendLimitChatManager paramExtendFriendLimitChatManager)
  {
    super(paramLimitChatUiStateMachine, paramExtendFriendLimitChatManager);
    this.jdField_a_of_type_Int = 2;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager.b();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager.a().a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    switch (paramInt1)
    {
    default: 
      return false;
    case 105: 
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine.a(0, paramInt2);
      break;
    case 103: 
      this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager.a().a();
    case 104: 
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine.a(0, paramInt2);
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager.a().a();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine.a(0, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine.b(paramInt1, paramInt2);
    return false;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.LimitChatUiStateMachine.MatchingState
 * JD-Core Version:    0.7.0.1
 */