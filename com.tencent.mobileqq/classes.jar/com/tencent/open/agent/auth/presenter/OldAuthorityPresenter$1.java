package com.tencent.open.agent.auth.presenter;

import android.os.Bundle;
import com.tencent.open.agent.auth.IOldAuthorityContract.View;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.appcommon.OpensdkBusinessObserver;

class OldAuthorityPresenter$1
  implements OpensdkBusinessObserver
{
  OldAuthorityPresenter$1(OldAuthorityPresenter paramOldAuthorityPresenter, long paramLong, boolean paramBoolean, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    SSOLog.a("OldAuthorityPresenter", new Object[] { "queryAuthList success=", Boolean.valueOf(paramBoolean) });
    OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter).c();
    OldAuthorityPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterOldAuthorityPresenter, paramBoolean, paramBundle, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.OldAuthorityPresenter.1
 * JD-Core Version:    0.7.0.1
 */