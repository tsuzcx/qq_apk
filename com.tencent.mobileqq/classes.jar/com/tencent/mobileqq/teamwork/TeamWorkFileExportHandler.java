package com.tencent.mobileqq.teamwork;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.manager.TicketManager;

public class TeamWorkFileExportHandler
  extends BusinessHandler
  implements Handler.Callback
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "docs.qq.com" };
  
  public TeamWorkFileExportHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 16L, this.jdField_a_of_type_ArrayOfJavaLangString, new TeamWorkFileExportHandler.2(this, paramRunnable)) == null) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(new TeamWorkFileExportHandler.1(this, paramString1, paramString2, paramString3, paramString4));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return TeamWorkExportObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileExportHandler
 * JD-Core Version:    0.7.0.1
 */