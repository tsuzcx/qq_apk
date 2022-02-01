package com.tencent.open.agent.strategy;

import android.os.Bundle;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.AccountManage.GetTicketCallback;

class SSOLoginAction$3
  implements AccountManage.GetTicketCallback
{
  SSOLoginAction$3(SSOLoginAction paramSSOLoginAction, Bundle paramBundle, String paramString1, long paramLong, String paramString2, int paramInt) {}
  
  public void a(AccountInfo paramAccountInfo)
  {
    SSOLog.a("SSOLoginAction", new Object[] { "getTicketNoPasswd onSuccess:", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramAccountInfo);
    SSOLoginAction.a(this.jdField_a_of_type_ComTencentOpenAgentStrategySSOLoginAction, paramAccountInfo, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", "", false);
    SSOLoginAction.a(this.jdField_a_of_type_ComTencentOpenAgentStrategySSOLoginAction, paramString, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.strategy.SSOLoginAction.3
 * JD-Core Version:    0.7.0.1
 */