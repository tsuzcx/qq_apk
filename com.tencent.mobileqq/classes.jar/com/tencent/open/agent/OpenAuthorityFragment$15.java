package com.tencent.open.agent;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

class OpenAuthorityFragment$15
  implements OpenCardContainer.OnDeleteVirtualListener
{
  OpenAuthorityFragment$15(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a(long paramLong)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDeleteVirtual vid=", Long.valueOf(paramLong) });
    if (!NetworkUtil.g(BaseApplicationImpl.getApplication()))
    {
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.post(this.a.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    OpenAuthorityFragment.a(this.a).a().a(OpenAuthorityFragment.a(this.a), paramLong, this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.15
 * JD-Core Version:    0.7.0.1
 */