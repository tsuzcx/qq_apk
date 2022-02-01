package com.tencent.open.agent.strategy;

import android.os.Bundle;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.AccountManage.GetTicketCallback;

class SSOLoginAction$6
  implements AccountManage.GetTicketCallback
{
  SSOLoginAction$6(SSOLoginAction paramSSOLoginAction, Bundle paramBundle, String paramString1, String paramString2) {}
  
  public void a(AccountInfo paramAccountInfo)
  {
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramAccountInfo);
    AuthMemoryCache.a().a(this.jdField_a_of_type_JavaLangString, paramAccountInfo);
    SSOLoginAction.a(this.jdField_a_of_type_ComTencentOpenAgentStrategySSOLoginAction, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, false);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", "", false);
    SSOLoginAction.a(this.jdField_a_of_type_ComTencentOpenAgentStrategySSOLoginAction, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, false, true);
    AuthReporter.a(this.b, "0X800B65D");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.strategy.SSOLoginAction.6
 * JD-Core Version:    0.7.0.1
 */