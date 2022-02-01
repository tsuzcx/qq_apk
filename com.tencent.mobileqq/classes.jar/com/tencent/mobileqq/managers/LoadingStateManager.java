package com.tencent.mobileqq.managers;

import android.os.Message;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class LoadingStateManager
{
  private static LoadingStateManager jdField_a_of_type_ComTencentMobileqqManagersLoadingStateManager;
  private int jdField_a_of_type_Int = 1;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  private LoadingStateManager()
  {
    if (NetConnInfoCenter.socketConnState == 4) {
      this.jdField_a_of_type_Int = 2;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LoadingStateManager init loadingstate = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("LoadingStateManager", 2, localStringBuilder.toString());
    }
  }
  
  public static LoadingStateManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqManagersLoadingStateManager == null) {
      jdField_a_of_type_ComTencentMobileqqManagersLoadingStateManager = new LoadingStateManager();
    }
    return jdField_a_of_type_ComTencentMobileqqManagersLoadingStateManager;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqManagersLoadingStateManager = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, QQAppInterface paramQQAppInterface)
  {
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.getAttribute("_tag_socket") == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("notifyIsNotIllegalNetWork mShowIllegalNetworkBar=");
        paramFromServiceMsg.append(this.jdField_a_of_type_Boolean);
        QLog.d("LoadingStateManager", 2, paramFromServiceMsg.toString());
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("changeConversationLoadingState mShowErrorNetworkBar=");
        paramFromServiceMsg.append(this.b);
        QLog.d("LoadingStateManager", 2, paramFromServiceMsg.toString());
      }
      if ((!this.jdField_a_of_type_Boolean) && (!this.b)) {
        return;
      }
      if (this.b)
      {
        paramFromServiceMsg = paramQQAppInterface.getHandler(Conversation.class);
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.obtainMessage(10002, null).sendToTarget();
        }
        return;
      }
      if (!c()) {
        a(0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoadingStateManager", 2, "notifyIsNotIllegalNetWork");
      }
      paramFromServiceMsg = paramQQAppInterface.getHandler(Conversation.class);
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.obtainMessage(1134012, null).sendToTarget();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int == 3;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Int == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.LoadingStateManager
 * JD-Core Version:    0.7.0.1
 */