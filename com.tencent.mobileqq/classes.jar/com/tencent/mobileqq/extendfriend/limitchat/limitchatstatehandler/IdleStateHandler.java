package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.qphone.base.util.QLog;

public class IdleStateHandler
  extends BaseStateHandler
{
  public final String b;
  
  IdleStateHandler(LimitChatProtoStateMachine paramLimitChatProtoStateMachine, int paramInt)
  {
    super(paramLimitChatProtoStateMachine, paramInt);
    this.jdField_b_of_type_JavaLangString = "ExtendFriendLimitChatIdleStateHandler";
  }
  
  public void a(int paramInt)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "requestMatch id" + paramInt);
    Object localObject = new MatchInfo();
    ((MatchInfo)localObject).jdField_b_of_type_Int = paramInt;
    this.a.a(101, (MatchInfo)localObject);
    localObject = (ExtendFriendHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localObject != null)
    {
      int i = ExtendFriendLimitChatManager.a(this.a.a);
      ((ExtendFriendHandler)localObject).a(this.a.a.getCurrentAccountUin(), i, paramInt);
    }
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCancelMatchMsg 取消匹配: " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, MatchInfo paramMatchInfo, String paramString)
  {
    if ((paramBoolean) && (paramMatchInfo != null))
    {
      QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配 " + paramInt + paramMatchInfo.toString());
      return;
    }
    paramMatchInfo = paramString;
    if (paramString == null) {
      paramMatchInfo = "";
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg 请求匹配失败 suc:" + paramBoolean + " ret:" + paramInt + " errMsg : " + paramMatchInfo);
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
      c(paramMatchInfo);
      a(paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.e);
      return;
    }
    QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.IdleStateHandler
 * JD-Core Version:    0.7.0.1
 */