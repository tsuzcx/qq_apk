package com.tencent.open.agent;

import android.os.Bundle;
import com.tencent.mobileqq.config.business.OpenSdkIFrameProcessor;
import com.tencent.open.OpenProxy;
import com.tencent.open.OpenSdkQIPCClient;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SSOAccountObserver;

class AgentActivity$11
  extends SSOAccountObserver
{
  AgentActivity$11(AgentActivity paramAgentActivity, boolean paramBoolean) {}
  
  private void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_sso_ret", paramInt);
    localBundle.putString("uin", paramString);
    localBundle.putBoolean("is_from_login", this.jdField_a_of_type_Boolean);
    OpenSdkQIPCClient.a(localBundle);
    this.jdField_a_of_type_ComTencentOpenAgentAgentActivity.jdField_a_of_type_Boolean = true;
    AgentActivity.b(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity);
    this.jdField_a_of_type_ComTencentOpenAgentAgentActivity.finish();
    if ((OpenSdkIFrameProcessor.a()) && (AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity) != null))
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "-->onSsoLoginComplete--unregisterReceiver");
      this.jdField_a_of_type_ComTencentOpenAgentAgentActivity.unregisterReceiver(AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity));
      AgentActivity.a(this.jdField_a_of_type_ComTencentOpenAgentAgentActivity, null);
    }
  }
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onFailed--", AuthorityUtil.a(paramString) });
    a(paramString, paramInt2);
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onLoginSuccess--", AuthorityUtil.a(paramString) });
    OpenProxy.a().a(paramString);
    OpenSdkQIPCClient.a(paramString);
    a(paramString, 0);
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onUserCancel--", AuthorityUtil.a(paramString) });
    a(paramString, 2006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity.11
 * JD-Core Version:    0.7.0.1
 */