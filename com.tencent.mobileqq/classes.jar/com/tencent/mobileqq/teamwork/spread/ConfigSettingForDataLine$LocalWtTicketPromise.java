package com.tencent.mobileqq.teamwork.spread;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class ConfigSettingForDataLine$LocalWtTicketPromise
  implements WtTicketPromise
{
  private TencentDocDataLineTipsConfigBean jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean;
  private WeakReference<ConfigSettingForDataLine> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ConfigSettingForDataLine$LocalWtTicketPromise(ConfigSettingForDataLine paramConfigSettingForDataLine, TencentDocDataLineTipsConfigBean paramTencentDocDataLineTipsConfigBean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramConfigSettingForDataLine);
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean = paramTencentDocDataLineTipsConfigBean;
  }
  
  public void Done(Ticket paramTicket)
  {
    if ((paramTicket != null) && (paramTicket._pskey_map != null))
    {
      ThreadManager.excute(new ConfigSettingForDataLine.LocalWtTicketPromise.1(this), 128, null, false);
      return;
    }
    paramTicket = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean;
    if (paramTicket != null) {
      paramTicket.a(false);
    }
    QLog.e("ConfigSettingForDataLine", 2, "get pskey failed ticket is null");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.e("ConfigSettingForDataLine", 2, "get pskey failed ticket failed");
    paramErrMsg = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean;
    if (paramErrMsg != null) {
      paramErrMsg.a(false);
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    paramErrMsg = this.jdField_a_of_type_ComTencentMobileqqConfigBusinessTendocTencentDocDataLineTipsConfigBean;
    if (paramErrMsg != null) {
      paramErrMsg.a(false);
    }
    QLog.e("ConfigSettingForDataLine", 2, "get pskey failed ticket time oiut");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.LocalWtTicketPromise
 * JD-Core Version:    0.7.0.1
 */