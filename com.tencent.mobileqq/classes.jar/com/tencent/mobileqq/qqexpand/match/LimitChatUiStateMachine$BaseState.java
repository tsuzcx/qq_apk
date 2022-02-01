package com.tencent.mobileqq.qqexpand.match;

import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.qphone.base.util.QLog;

public class LimitChatUiStateMachine$BaseState
{
  public int a;
  protected ExtendFriendLimitChatManager a;
  protected LimitChatUiStateMachine a;
  
  public LimitChatUiStateMachine$BaseState(LimitChatUiStateMachine paramLimitChatUiStateMachine, ExtendFriendLimitChatManager paramExtendFriendLimitChatManager)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendLimitChatManager = paramExtendFriendLimitChatManager;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatUiStateMachine = paramLimitChatUiStateMachine;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("state ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
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
      localStringBuilder.append(this.jdField_a_of_type_Int);
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
      localStringBuilder.append(this.jdField_a_of_type_Int);
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
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" onForceEnd");
      QLog.d("LimitChatUiStateMachine", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.LimitChatUiStateMachine.BaseState
 * JD-Core Version:    0.7.0.1
 */