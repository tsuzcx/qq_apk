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

public class TenDocOCRExportHandler
  extends BusinessHandler
  implements Handler.Callback
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "docs.qq.com" };
  
  public TenDocOCRExportHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 16L, this.jdField_a_of_type_ArrayOfJavaLangString, new TenDocOCRExportHandler.2(this, paramRunnable)) == null) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  public void a(String paramString)
  {
    a(new TenDocOCRExportHandler.1(this, paramString));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return TenDocOCRExportObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocOCRExportHandler
 * JD-Core Version:    0.7.0.1
 */