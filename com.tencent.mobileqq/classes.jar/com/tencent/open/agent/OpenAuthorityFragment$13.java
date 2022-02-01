package com.tencent.open.agent;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.decoupleim.ThirdPartyLoginBlockUtilImpl;
import com.tencent.open.OpenSdkQIPCClient;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.open.virtual.OpenSdkVirtualManager.GetTicketCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

class OpenAuthorityFragment$13
  implements OpenSdkVirtualManager.GetTicketCallback
{
  OpenAuthorityFragment$13(OpenAuthorityFragment paramOpenAuthorityFragment, int paramInt) {}
  
  public void a(AccountInfo paramAccountInfo)
  {
    OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment, null);
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "refreshTicket success info.uin=" + AuthorityUtil.a(paramAccountInfo.a), ", triggerReason=", Integer.valueOf(this.jdField_a_of_type_Int) });
    if (OpenAuthorityFragment.i(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment)) {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket success Activity Finishing");
    }
    do
    {
      return;
      OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment).a().a(OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), paramAccountInfo);
      if (this.jdField_a_of_type_Int == 1)
      {
        long l = OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment).a();
        paramAccountInfo = OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment);
        OpenAuthorityFragment.e(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment, System.currentTimeMillis());
        OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment).a(OpenAuthorityFragment.f(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), OpenAuthorityFragment.f(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), OpenAuthorityFragment.c(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), paramAccountInfo, l, this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.a, AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.getActivity()), this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.getActivity());
        return;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        OpenAuthorityFragment.b(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment);
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    OpenAuthorityFragment.c(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment, null);
    QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "refreshTicket onFail triggerReason=", Integer.valueOf(this.jdField_a_of_type_Int) });
    if (OpenAuthorityFragment.i(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment)) {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket onFail Activity Finishing");
    }
    boolean bool;
    do
    {
      return;
      bool = ThirdPartyLoginBlockUtilImpl.a().a(paramBundle);
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket checkIMBlockByBundle uin: " + paramString + " isIMBlock: " + bool);
      AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.getActivity(), HardCodeUtil.a(2131707832), false);
      this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment.c(paramString);
      if (this.jdField_a_of_type_Int == 1) {
        AuthReporter.a(OpenAuthorityFragment.b(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment), "0X800B65F");
      }
    } while (!bool);
    OpenSdkQIPCClient.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.13
 * JD-Core Version:    0.7.0.1
 */