package com.tencent.mobileqq.qqexpand.match;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class BaseStateHandler
{
  private int jdField_a_of_type_Int = -1;
  MatchInfo jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo = new MatchInfo();
  LimitChatProtoStateMachine jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine;
  
  BaseStateHandler(LimitChatProtoStateMachine paramLimitChatProtoStateMachine, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine = paramLimitChatProtoStateMachine;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.a();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StateHandlerType : ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" cancelMatch in wrong state!!");
    QLog.i("ExtendFriendLimitChat", 2, localStringBuilder.toString());
  }
  
  void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StateHandlerType : ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" requestMatch in wrong state!! id:");
    localStringBuilder.append(paramInt);
    QLog.i("ExtendFriendLimitChat", 2, localStringBuilder.toString());
  }
  
  public void a(MatchInfo paramMatchInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.jdField_a_of_type_JavaLangString = paramMatchInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.jdField_a_of_type_ArrayOfByte = paramMatchInfo.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.jdField_b_of_type_JavaLangString = paramMatchInfo.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.c = paramMatchInfo.c;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.jdField_a_of_type_Long = paramMatchInfo.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.jdField_a_of_type_Int = paramMatchInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.e = paramMatchInfo.e;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.jdField_b_of_type_Int = paramMatchInfo.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.f = paramMatchInfo.f;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ExtendFriendLimitChat", 2, "saveMatchAlgorithmId UIN IS EMPTY");
      return;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("ExtendFriendLimitChat", 2, "saveMatchAlgorithmId algorithmId IS EMPTY");
      str = "0";
    }
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.1(this, paramString1, str));
  }
  
  protected void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.a.getMsgCache().b(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StateHandlerType : ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" onCScancelMatchMsg in wrong state!! ");
    localStringBuilder.append(paramBoolean);
    QLog.i("ExtendFriendLimitChat", 2, localStringBuilder.toString());
  }
  
  void a(boolean paramBoolean, int paramInt, MatchInfo paramMatchInfo, String paramString)
  {
    paramMatchInfo = new StringBuilder();
    paramMatchInfo.append("StateHandlerType : ");
    paramMatchInfo.append(this.jdField_a_of_type_Int);
    paramMatchInfo.append(" onCSRequestMsg in wrong state!!");
    QLog.i("ExtendFriendLimitChat", 2, paramMatchInfo.toString());
  }
  
  void a(boolean paramBoolean, MatchInfo paramMatchInfo)
  {
    paramMatchInfo = new StringBuilder();
    paramMatchInfo.append("StateHandlerType : ");
    paramMatchInfo.append(this.jdField_a_of_type_Int);
    paramMatchInfo.append(" onPushMsg in wrong state!!");
    QLog.i("ExtendFriendLimitChat", 2, paramMatchInfo.toString());
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.a();
  }
  
  public void b(MatchInfo paramMatchInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.a();
    if (paramMatchInfo != null) {
      a(paramMatchInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.BaseStateHandler
 * JD-Core Version:    0.7.0.1
 */