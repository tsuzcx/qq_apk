package com.tencent.open.agent;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.open.virtual.OpenSdkVirtualManager.PreAuthCallback;
import com.tencent.qphone.base.util.QLog;

class AgentActivity$8$1
  implements OpenSdkVirtualManager.PreAuthCallback
{
  AgentActivity$8$1(AgentActivity.8 param8) {}
  
  public void a()
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, "preAuthWithRetry onSuccess");
    AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity);
    AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidOsBundle, this.a.b, true);
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "preAuthWithRetry onFail errorCode=", Integer.valueOf(paramInt), ", msg=", paramString });
    AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity);
    if ((paramInt == 110530) || (paramInt == 1002))
    {
      AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidOsBundle, this.a.b, false);
      return;
    }
    if (paramInt == 110509)
    {
      if (this.a.jdField_a_of_type_Int == 1)
      {
        AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidOsBundle, this.a.b, 3);
        return;
      }
      AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidOsBundle, this.a.b, true, true);
      return;
    }
    if (paramInt == 110513)
    {
      AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity, 0, "", "");
      return;
    }
    if ((paramInt == 110537) || (paramInt == -10005))
    {
      AgentActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidOsBundle, this.a.b, false, true);
      return;
    }
    String str;
    if (paramInt == -1) {
      str = this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity.getResources().getString(2131694678);
    }
    for (;;)
    {
      ForwardUtils.a(str, this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity, new AgentActivity.8.1.1(this, paramInt, paramString));
      return;
      if (TextUtils.isEmpty(paramString)) {
        str = String.format(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity.getResources().getString(2131694667), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = String.format(this.a.jdField_a_of_type_ComTencentOpenAgentAgentActivity.getResources().getString(2131696476), new Object[] { paramString, Integer.valueOf(paramInt) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity.8.1
 * JD-Core Version:    0.7.0.1
 */