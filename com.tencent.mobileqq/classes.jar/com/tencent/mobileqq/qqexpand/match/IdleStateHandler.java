package com.tencent.mobileqq.qqexpand.match;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.qphone.base.util.QLog;

public class IdleStateHandler
  extends BaseStateHandler
{
  public final String a;
  
  IdleStateHandler(LimitChatProtoStateMachine paramLimitChatProtoStateMachine, int paramInt)
  {
    super(paramLimitChatProtoStateMachine, paramInt);
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChatIdleStateHandler";
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestMatch id");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, ((StringBuilder)localObject).toString());
    localObject = new MatchInfo();
    ((MatchInfo)localObject).jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.a(101, (MatchInfo)localObject);
    localObject = (IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localObject != null)
    {
      int i = ExtendFriendLimitChatManager.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.a);
      ((IExpandHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.a.getCurrentAccountUin(), i, paramInt);
    }
  }
  
  void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCancelMatchMsg 取消匹配: ");
    localStringBuilder.append(paramBoolean);
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, localStringBuilder.toString());
  }
  
  void a(boolean paramBoolean, int paramInt, MatchInfo paramMatchInfo, String paramString)
  {
    if ((paramBoolean) && (paramMatchInfo != null))
    {
      paramString = new StringBuilder();
      paramString.append("onCSRequestMsg 请求匹配 ");
      paramString.append(paramInt);
      paramString.append(paramMatchInfo.toString());
      QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, paramString.toString());
      return;
    }
    paramMatchInfo = paramString;
    if (paramString == null) {
      paramMatchInfo = "";
    }
    paramString = new StringBuilder();
    paramString.append("onCSRequestMsg 请求匹配失败 suc:");
    paramString.append(paramBoolean);
    paramString.append(" ret:");
    paramString.append(paramInt);
    paramString.append(" errMsg : ");
    paramString.append(paramMatchInfo);
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, paramString.toString());
  }
  
  void a(boolean paramBoolean, MatchInfo paramMatchInfo)
  {
    if (paramMatchInfo == null)
    {
      QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg null indo");
      return;
    }
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
    if (paramBoolean)
    {
      a(paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.jdField_a_of_type_JavaLangString, paramMatchInfo.jdField_a_of_type_ArrayOfByte);
      a(paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.e);
      return;
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.IdleStateHandler
 * JD-Core Version:    0.7.0.1
 */