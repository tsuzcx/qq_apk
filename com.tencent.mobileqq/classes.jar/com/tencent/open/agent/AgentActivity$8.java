package com.tencent.open.agent;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.open.virtual.OpenSdkVirtualManager.GetTicketCallback;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

class AgentActivity$8
  implements OpenSdkVirtualManager.GetTicketCallback
{
  AgentActivity$8(AgentActivity paramAgentActivity, String paramString1, Bundle paramBundle, String paramString2, long paramLong, String paramString3, int paramInt) {}
  
  public void a(AccountInfo paramAccountInfo)
  {
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, null);
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", " getTicketNoPasswd onSuccess", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    ForwardStatisticsReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramAccountInfo);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity).a().a(this.b, paramAccountInfo);
    AgentActivity.b(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.b, false);
    long l1 = ForwardUtils.a(this.b);
    long l2 = ForwardUtils.a(this.c);
    preAuth.PreAuthRequest localPreAuthRequest = AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity).a().a(paramAccountInfo, AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity), l1, l2, this.jdField_a_of_type_AndroidOsBundle);
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity).a().a(localPreAuthRequest, this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, paramAccountInfo, new AgentActivity.8.1(this), 0);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, null);
    QLog.d("SDK_LOGIN.AgentActivity", 1, "--> getTicketNoPasswd onFail");
    ForwardStatisticsReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", "", false);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(SharedPrefs.a())))
    {
      AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.b, false, true);
      AuthReporter.a(paramString, "0X800B65D");
      return;
    }
    AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity.8
 * JD-Core Version:    0.7.0.1
 */