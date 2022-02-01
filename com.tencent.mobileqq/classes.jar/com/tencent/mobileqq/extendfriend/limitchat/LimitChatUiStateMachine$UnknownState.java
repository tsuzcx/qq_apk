package com.tencent.mobileqq.extendfriend.limitchat;

public class LimitChatUiStateMachine$UnknownState
  extends LimitChatUiStateMachine.BaseState
{
  public LimitChatUiStateMachine$UnknownState(LimitChatUiStateMachine paramLimitChatUiStateMachine, ExtendFriendLimitChatManager paramExtendFriendLimitChatManager)
  {
    super(paramLimitChatUiStateMachine, paramExtendFriendLimitChatManager);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatManager.b();
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    switch (paramInt1)
    {
    default: 
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitChatUiStateMachine.a(2, paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.LimitChatUiStateMachine.UnknownState
 * JD-Core Version:    0.7.0.1
 */