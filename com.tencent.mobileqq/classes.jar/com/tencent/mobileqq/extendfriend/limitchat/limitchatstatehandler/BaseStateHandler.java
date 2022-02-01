package com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class BaseStateHandler
{
  private int jdField_a_of_type_Int = -1;
  MatchInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo = new MatchInfo();
  LimitChatProtoStateMachine jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitchatstatehandlerLimitChatProtoStateMachine;
  public final String a;
  
  BaseStateHandler(LimitChatProtoStateMachine paramLimitChatProtoStateMachine, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChat";
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitchatstatehandlerLimitChatProtoStateMachine = paramLimitChatProtoStateMachine;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.a();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a()
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " cancelMatch in wrong state!!");
  }
  
  void a(int paramInt)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " requestMatch in wrong state!! id:" + paramInt);
  }
  
  public void a(MatchInfo paramMatchInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.jdField_a_of_type_JavaLangString = paramMatchInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.jdField_a_of_type_ArrayOfByte = paramMatchInfo.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.jdField_b_of_type_JavaLangString = paramMatchInfo.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.c = paramMatchInfo.c;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.jdField_a_of_type_Long = paramMatchInfo.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.jdField_a_of_type_Int = paramMatchInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.e = paramMatchInfo.e;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.jdField_b_of_type_Int = paramMatchInfo.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.f = paramMatchInfo.f;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo;
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
      str = "0";
      QLog.e("ExtendFriendLimitChat", 2, "saveMatchAlgorithmId algorithmId IS EMPTY");
    }
    ThreadManager.getSubThreadHandler().post(new BaseStateHandler.1(this, paramString1, str));
  }
  
  protected void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatLimitchatstatehandlerLimitChatProtoStateMachine.a.getMsgCache().c(String.valueOf(paramString1), String.valueOf(paramString2), paramArrayOfByte);
  }
  
  void a(boolean paramBoolean)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCScancelMatchMsg in wrong state!! " + paramBoolean);
  }
  
  void a(boolean paramBoolean, int paramInt, MatchInfo paramMatchInfo, String paramString)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onCSRequestMsg in wrong state!!");
  }
  
  void a(boolean paramBoolean, MatchInfo paramMatchInfo)
  {
    QLog.i("ExtendFriendLimitChat", 2, "StateHandlerType : " + this.jdField_a_of_type_Int + " onPushMsg in wrong state!!");
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.a();
  }
  
  public void b(MatchInfo paramMatchInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchInfo.a();
    if (paramMatchInfo != null) {
      a(paramMatchInfo);
    }
  }
  
  protected void c(MatchInfo paramMatchInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (!((ExtendFriendManager)localQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f())) {
      ThreadManager.getSubThreadHandler().post(new BaseStateHandler.2(this, paramMatchInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitchatstatehandler.BaseStateHandler
 * JD-Core Version:    0.7.0.1
 */