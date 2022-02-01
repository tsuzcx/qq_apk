package com.tencent.mobileqq.qqexpand.match;

import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.qphone.base.util.QLog;

public class LimitChatUiStateMachine$BaseState
{
  public int a = -1;
  protected ExtendFriendLimitChatManager b;
  protected LimitChatUiStateMachine c;
  
  public LimitChatUiStateMachine$BaseState(LimitChatUiStateMachine paramLimitChatUiStateMachine, ExtendFriendLimitChatManager paramExtendFriendLimitChatManager)
  {
    this.b = paramExtendFriendLimitChatManager;
    this.c = paramLimitChatUiStateMachine;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("state ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" onEnd");
      QLog.d("LimitChatUiStateMachine", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("state ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" onStart subinfo:");
      localStringBuilder.append(paramInt);
      QLog.d("LimitChatUiStateMachine", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("state ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" start handle event ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", subEvent ");
      localStringBuilder.append(paramInt2);
      QLog.d("LimitChatUiStateMachine", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("state ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" onForceEnd");
      QLog.d("LimitChatUiStateMachine", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.LimitChatUiStateMachine.BaseState
 * JD-Core Version:    0.7.0.1
 */