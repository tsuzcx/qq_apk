package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.auth.ISelectPermissionContract.View;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import org.json.JSONException;
import org.json.JSONObject;

class SelectPermissionPresenter$3$1
  implements Runnable
{
  SelectPermissionPresenter$3$1(SelectPermissionPresenter.3 param3, boolean paramBoolean, AuthResponse paramAuthResponse, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse != null))
    {
      SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a, true);
      SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a, this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.c.get(), SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a));
      SelectPermissionPresenter.b(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a, this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.c.get(), this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.e.get());
    }
    for (;;)
    {
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = SelectPermissionPresenter.c(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a);
        Object localObject1 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse;
        long l3 = SelectPermissionPresenter.d(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a);
        long l4 = SelectPermissionPresenter.e(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a);
        if (SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a) == 0L) {
          break label596;
        }
        bool = true;
        localObject1 = AuthorityUtil.a((AuthResponse)localObject1, l3, l4, l1 - l2, bool);
        SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a, this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.a.get(), ((JSONObject)localObject1).toString(), null, null);
      }
      catch (JSONException localJSONException)
      {
        SSOLog.c("SelectPermissionPresenter", "catch JSONException", localJSONException);
      }
      int i = this.jdField_a_of_type_Int;
      Object localObject2;
      if (i == 110509)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDoAuthorize mAuthRetryCountBy110509=");
        ((StringBuilder)localObject2).append(SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a));
        SSOLog.a("SelectPermissionPresenter", new Object[] { ((StringBuilder)localObject2).toString() });
        if (SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a) >= 2)
        {
          SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a);
        }
        else
        {
          SelectPermissionPresenter.b(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a);
          SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a, 3);
        }
        SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a, false);
      }
      else if (i == 110537)
      {
        SSOLog.a("SelectPermissionPresenter", new Object[] { "onDoAuthorize 110537" });
        AuthUIUtil.a(SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a), HardCodeUtil.a(2131707857), false);
        SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a);
      }
      else if (i == 100044)
      {
        localObject2 = AuthMemoryCache.a().a(SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a));
        String str1 = SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a).getIntent().getStringExtra("packagename");
        String str2 = SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a).getIntent().getStringExtra("packagesign");
        AuthReporter.a(((AccountInfo)localObject2).a, SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a), str1, str2);
        localObject2 = AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse, SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a).getResources(), this.jdField_a_of_type_Int);
        AuthUIUtil.a(SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a), (String)localObject2, new SelectPermissionPresenter.3.1.1(this));
      }
      else
      {
        localObject2 = AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse, SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a).getResources(), this.jdField_a_of_type_Int);
        AuthUIUtil.a(SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a), (String)localObject2, false);
        SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a, false);
      }
      SelectPermissionPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterSelectPermissionPresenter$3.a).b();
      return;
      label596:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SelectPermissionPresenter.3.1
 * JD-Core Version:    0.7.0.1
 */