package com.tencent.mobileqq.qqexpand.match;

import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.qphone.base.util.QLog;

public class LimitChatUiStateMachine
{
  private LimitChatUiStateMachine.BaseState a;
  private final LimitChatUiStateMachine.UnknownState b;
  private final LimitChatUiStateMachine.MatchingState c;
  private final LimitChatUiStateMachine.ErrState d;
  
  public LimitChatUiStateMachine(ExtendFriendLimitChatManager paramExtendFriendLimitChatManager)
  {
    this.b = new LimitChatUiStateMachine.UnknownState(this, paramExtendFriendLimitChatManager);
    this.c = new LimitChatUiStateMachine.MatchingState(this, paramExtendFriendLimitChatManager);
    this.d = new LimitChatUiStateMachine.ErrState(this, paramExtendFriendLimitChatManager);
    this.a = this.b;
  }
  
  public int a()
  {
    return this.a.a;
  }
  
  public LimitChatUiStateMachine.BaseState a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        return this.d;
      }
      return this.c;
    }
    return this.b;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.a.a)
    {
      LimitChatUiStateMachine.BaseState localBaseState = a(paramInt1);
      if (localBaseState != null)
      {
        this.a.a();
        this.a = localBaseState;
        this.a.a(paramInt2);
      }
    }
  }
  
  public void b(int paramInt)
  {
    b(paramInt, -1);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    int i = this.a.a;
    if ((!this.a.a(paramInt1, paramInt2)) && (QLog.isColorLevel()))
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
    if (this.a.a != 0)
    {
      this.a.b();
      this.a = this.b;
      this.a.a(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.LimitChatUiStateMachine
 * JD-Core Version:    0.7.0.1
 */