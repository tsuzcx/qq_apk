package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class DynamicNowManager$10
  implements WtTicketPromise
{
  DynamicNowManager$10(DynamicNowManager paramDynamicNowManager, OnGetSkeyListener paramOnGetSkeyListener) {}
  
  public void Done(Ticket paramTicket)
  {
    if ((paramTicket != null) && (paramTicket._sig != null) && (paramTicket._sig.length != 0))
    {
      paramTicket = new String(paramTicket._sig);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicOnGetSkeyListener.a(1, paramTicket);
      return;
    }
    QLog.w("XProxy|NowProxy", 1, "skey is null");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicOnGetSkeyListener.a(3, null);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.w("XProxy|NowProxy", 1, "get skey failed");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicOnGetSkeyListener.a(5, null);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    QLog.w("XProxy|NowProxy", 1, "get skey time out");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicOnGetSkeyListener.a(4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.10
 * JD-Core Version:    0.7.0.1
 */