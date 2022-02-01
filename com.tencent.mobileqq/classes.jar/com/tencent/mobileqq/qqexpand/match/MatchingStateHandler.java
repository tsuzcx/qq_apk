package com.tencent.mobileqq.qqexpand.match;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.bean.chat.ChatFriendInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MatchingStateHandler
  extends BaseStateHandler
  implements Handler.Callback
{
  public final int a;
  Handler a;
  public final String a;
  private int jdField_b_of_type_Int = 101;
  private String jdField_b_of_type_JavaLangString = "";
  private int c = 1;
  
  MatchingStateHandler(LimitChatProtoStateMachine paramLimitChatProtoStateMachine, int paramInt)
  {
    super(paramLimitChatProtoStateMachine, paramInt);
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChatMatchingStateHandler";
    this.jdField_a_of_type_Int = 60;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.a(100, null);
      c();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFailedMatchPb  failedType：");
    localStringBuilder.append(paramInt);
    QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, localStringBuilder.toString());
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine != null) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine$LimitChatMachineListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine$LimitChatMachineListener.a(paramInt, null, "", paramString);
    }
  }
  
  private void c()
  {
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "clearMsg");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  private void d()
  {
    ThreadManager.getUIHandler().post(new MatchingStateHandler.1(this));
  }
  
  public void a()
  {
    int i = this.jdField_b_of_type_Int;
    Object localObject;
    if ((i != 101) && (i != 104))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelMatch in matching state unknown!!");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state REQUEST_MATCHING or WAIT_PUSH ");
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine != null)
    {
      localObject = (IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
      if (localObject != null) {
        ((IExpandHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine.a(100, null);
      return;
    }
    QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "cancelMatch in matching state machine is null");
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestMatch in matching state id:");
    localStringBuilder.append(paramInt);
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, localStringBuilder.toString());
  }
  
  public void a(int paramInt, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCancelMatchMsg 取消匹配: ");
    localStringBuilder.append(paramBoolean);
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, localStringBuilder.toString());
  }
  
  void a(boolean paramBoolean, int paramInt, MatchInfo paramMatchInfo, String paramString)
  {
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg");
    String str = "";
    if (paramBoolean)
    {
      if (paramInt == 0)
      {
        if ((paramMatchInfo != null) && (paramMatchInfo.a()))
        {
          paramString = new StringBuilder();
          paramString.append("onCSRequestMsg - 》 STATE_PROTO_AIO_OPEN matchinf:");
          paramString.append(paramMatchInfo.toString());
          QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, paramString.toString());
          a(paramMatchInfo);
          a(paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.jdField_a_of_type_JavaLangString, paramMatchInfo.jdField_a_of_type_ArrayOfByte);
          a(paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.e);
          this.jdField_b_of_type_Int = 105;
          d();
          return;
        }
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg MatchInfo is wrong ");
        a(1, paramString);
        return;
      }
      if (paramInt == 1)
      {
        this.jdField_b_of_type_Int = 104;
        long l1 = 30000L;
        if (paramMatchInfo != null) {
          l1 = paramMatchInfo.jdField_a_of_type_Int * 1000;
        } else {
          QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onCSRequestMsg STATE_PROTO_WAIT_PUSH but matchinfo  is wrong,push time use 30");
        }
        long l2 = l1;
        if (60000L < l1) {
          l2 = 60000L;
        }
        a(1, l2);
        if (paramString != null) {
          str = paramString;
        }
        paramMatchInfo = new StringBuilder();
        paramMatchInfo.append("onCSRequestMsg - 》 STATE_PROTO_WAIT_PUSH  pushimte ：");
        paramMatchInfo.append(l2);
        paramMatchInfo.append("tips errm:");
        paramMatchInfo.append(str);
        QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, paramMatchInfo.toString());
        this.jdField_b_of_type_JavaLangString = paramString;
        return;
      }
      if (paramInt == 3)
      {
        if (paramString != null) {
          str = paramString;
        }
        paramMatchInfo = new StringBuilder();
        paramMatchInfo.append("onCSRequestMsg fail   ret is MatchOpRetCode_Security_Beat errmsg:");
        paramMatchInfo.append(str);
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, paramMatchInfo.toString());
        a(7, paramString);
        return;
      }
      if (paramInt == 4)
      {
        if (paramString != null) {
          str = paramString;
        }
        paramMatchInfo = new StringBuilder();
        paramMatchInfo.append("onCSRequestMsg fail   ret is MatchOpRetCode_Security_Limit errmsg:");
        paramMatchInfo.append(str);
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, paramMatchInfo.toString());
        a(8, paramString);
        return;
      }
      if (paramInt == 2)
      {
        if (paramString != null) {
          str = paramString;
        }
        paramMatchInfo = new StringBuilder();
        paramMatchInfo.append("onCSRequestMsg fail   ret is MatchOpRetCode_Security_Beat errmsg:");
        paramMatchInfo.append(str);
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, paramMatchInfo.toString());
        a(6, paramString);
        return;
      }
      if (paramInt == 12)
      {
        if (paramString != null) {
          str = paramString;
        }
        paramMatchInfo = new StringBuilder();
        paramMatchInfo.append("onCSRequestMsg fail   ret is MatchOpRetCode_No_Times errmsg:");
        paramMatchInfo.append(str);
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, paramMatchInfo.toString());
        a(9, paramString);
        return;
      }
      if (paramString != null) {
        str = paramString;
      }
      paramMatchInfo = new StringBuilder();
      paramMatchInfo.append("onCSRequestMsg RECODE = ");
      paramMatchInfo.append(paramInt);
      paramMatchInfo.append(" errMsg:");
      paramMatchInfo.append(str);
      QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, paramMatchInfo.toString());
      a(1, paramString);
      return;
    }
    paramMatchInfo = new StringBuilder();
    paramMatchInfo.append("onCSRequestMsg success = ");
    paramMatchInfo.append(paramBoolean);
    QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, paramMatchInfo.toString());
    a(1, "");
  }
  
  public void a(boolean paramBoolean, MatchInfo paramMatchInfo)
  {
    Object localObject;
    if ((paramBoolean) && (paramMatchInfo != null) && (paramMatchInfo.jdField_b_of_type_Int != this.c))
    {
      a(paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.jdField_a_of_type_JavaLangString, paramMatchInfo.jdField_a_of_type_ArrayOfByte);
      a(paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.e);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ON PUSH WITH PUSH TAG");
      ((StringBuilder)localObject).append(paramMatchInfo.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(" wait id:");
      ((StringBuilder)localObject).append(this.c);
      QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, ((StringBuilder)localObject).toString());
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (paramMatchInfo == null)
    {
      QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, "onPushMsg null indo");
      return;
    }
    QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, "onPushMsg ");
    if (paramBoolean)
    {
      a(paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.jdField_a_of_type_JavaLangString, paramMatchInfo.jdField_a_of_type_ArrayOfByte);
      a(paramMatchInfo);
      a(paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.e);
      if (this.jdField_b_of_type_Int == 104)
      {
        if (paramMatchInfo.a())
        {
          a(paramMatchInfo);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("STATE_PROTO_WAIT_PUSH - 》 STATE_PROTO_AIO_OPEN matchinf:");
          ((StringBuilder)localObject).append(paramMatchInfo.toString());
          QLog.i("ExtendFriendLimitChatMatchingStateHandler", 2, ((StringBuilder)localObject).toString());
          this.jdField_b_of_type_Int = 105;
          localObject = (IExpandManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
          if ((localObject != null) && (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo != null) && (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.g == 1)) {
            ((IExpandManager)localObject).a();
          }
          d();
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("WAIT PUSH IN STATE: UN HANDLED");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(paramMatchInfo.toString());
        QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      a(2, this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.a();
    c();
  }
  
  public void b(MatchInfo paramMatchInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.a();
    if (paramMatchInfo != null)
    {
      a(paramMatchInfo);
      this.c = paramMatchInfo.jdField_b_of_type_Int;
    }
    this.jdField_b_of_type_Int = 101;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    paramMessage = new StringBuilder();
    paramMessage.append("超时 on timer TIMER_FOR_PUSH：");
    paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchInfo.toString());
    QLog.e("ExtendFriendLimitChatMatchingStateHandler", 2, paramMessage.toString());
    a();
    a(2, this.jdField_b_of_type_JavaLangString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.MatchingStateHandler
 * JD-Core Version:    0.7.0.1
 */