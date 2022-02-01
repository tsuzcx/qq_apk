package com.tencent.open.agent;

import android.os.Bundle;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.open.virtual.OpenSdkVirtualManager.GetTicketCallback;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

class AgentActivity$3
  implements OpenSdkVirtualManager.GetTicketCallback
{
  AgentActivity$3(AgentActivity paramAgentActivity, String paramString1, Bundle paramBundle, String paramString2, String paramString3) {}
  
  public void a(AccountInfo paramAccountInfo)
  {
    ForwardStatisticsReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramAccountInfo);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity).a().a(this.b, paramAccountInfo);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.b, false);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    ForwardStatisticsReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", "", false);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.b, false, true);
    AuthReporter.a(this.c, "0X800B65D");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity.3
 * JD-Core Version:    0.7.0.1
 */