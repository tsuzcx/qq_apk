package com.tencent.mobileqq.qqexpand.match;

import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;

public class LimitChatUiStateMachine$MatchingState
  extends LimitChatUiStateMachine.BaseState
{
  public LimitChatUiStateMachine$MatchingState(LimitChatUiStateMachine paramLimitChatUiStateMachine, ExtendFriendLimitChatManager paramExtendFriendLimitChatManager)
  {
    super(paramLimitChatUiStateMachine, paramExtendFriendLimitChatManager);
    this.a = 2;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.b.b();
    this.b.c().a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    switch (paramInt1)
    {
    default: 
      return false;
    case 105: 
      this.c.a(0, paramInt2);
      break;
    case 103: 
      this.b.c().a();
    case 104: 
      this.c.a(0, paramInt2);
      return true;
    }
    this.b.c().a();
    this.c.a(0, paramInt2);
    this.c.b(paramInt1, paramInt2);
    return false;
  }
  
  public void b()
  {
    super.b();
    this.b.c().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.LimitChatUiStateMachine.MatchingState
 * JD-Core Version:    0.7.0.1
 */