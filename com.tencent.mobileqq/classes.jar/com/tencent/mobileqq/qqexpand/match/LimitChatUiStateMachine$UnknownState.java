package com.tencent.mobileqq.qqexpand.match;

import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;

public class LimitChatUiStateMachine$UnknownState
  extends LimitChatUiStateMachine.BaseState
{
  public LimitChatUiStateMachine$UnknownState(LimitChatUiStateMachine paramLimitChatUiStateMachine, ExtendFriendLimitChatManager paramExtendFriendLimitChatManager)
  {
    super(paramLimitChatUiStateMachine, paramExtendFriendLimitChatManager);
    this.a = 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.b.b();
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (paramInt1 != 102) {
      return false;
    }
    this.c.a(2, paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.LimitChatUiStateMachine.UnknownState
 * JD-Core Version:    0.7.0.1
 */