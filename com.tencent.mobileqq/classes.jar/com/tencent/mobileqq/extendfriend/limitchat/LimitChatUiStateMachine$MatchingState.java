package com.tencent.mobileqq.extendfriend.limitchat;

import com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.LimitChatProtoStateMachine;

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
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.b();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a().a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    switch (paramInt1)
    {
    default: 
      return false;
    case 103: 
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a().a();
    case 104: 
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine.a(0, paramInt2);
    case 105: 
      for (;;)
      {
        return true;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine.a(0, paramInt2);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a().a();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine.a(0, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine.b(paramInt1, paramInt2);
    return false;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.LimitChatUiStateMachine.MatchingState
 * JD-Core Version:    0.7.0.1
 */