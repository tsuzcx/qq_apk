package com.tencent.open.agent;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class OpenSelectPermissionFragment$4$1
  implements Runnable
{
  OpenSelectPermissionFragment$4$1(OpenSelectPermissionFragment.4 param4, boolean paramBoolean, AuthResponse paramAuthResponse, int paramInt) {}
  
  public void run()
  {
    Object localObject2;
    Object localObject3;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse != null))
    {
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a, true);
      this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.c.get());
      this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.c.get(), this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.e.get());
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get());
        localJSONObject.put("openid", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.c.get());
        localJSONObject.put("access_token", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.jdField_b_of_type_ComTencentMobileqqPbPBStringField.get());
        localJSONObject.put("pay_token", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.d.get());
        localJSONObject.put("expires_in", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field.get());
        localJSONObject.put("code", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.n.get());
        localJSONObject.put("proxy_code", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse.code.get());
        localJSONObject.put("proxy_expires_in", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse.expires_in.get());
        localJSONObject.put("pf", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.f.get());
        localJSONObject.put("pfkey", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.g.get());
        localJSONObject.put("msg", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get());
        localJSONObject.put("login_cost", OpenSelectPermissionFragment.c(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a));
        localJSONObject.put("query_authority_cost", OpenSelectPermissionFragment.d(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a));
        localJSONObject.put("authority_cost", SystemClock.elapsedRealtime() - OpenSelectPermissionFragment.e(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a));
        if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field.has()) {
          localJSONObject.put("sendinstall", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field.get());
        }
        if ((this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.j.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.j.get()))) {
          localJSONObject.put("installwording", this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.j.get());
        }
        if ((this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.has()) && (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.size() > 0))
        {
          localObject2 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (appType.PassData)((Iterator)localObject2).next();
            localJSONObject.put(((appType.PassData)localObject3).key.get(), ((appType.PassData)localObject3).value.get());
            continue;
            this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a.a();
          }
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "catch JSONException", localJSONException);
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get(), localJSONException.toString(), null, null);
      continue;
      if (this.jdField_a_of_type_Int == 110509)
      {
        QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "onDoAuthorize mAuthRetryCountBy110509=" + OpenSelectPermissionFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a));
        if (OpenSelectPermissionFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a) >= 2) {
          OpenSelectPermissionFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a);
        }
        for (;;)
        {
          OpenSelectPermissionFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a, false);
          break;
          OpenSelectPermissionFragment.b(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a);
          OpenSelectPermissionFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a, 3);
        }
      }
      if (this.jdField_a_of_type_Int == 110537)
      {
        QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "onDoAuthorize 110537");
        AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a.getActivity(), HardCodeUtil.a(2131707834), false);
        OpenSelectPermissionFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a);
      }
      else
      {
        Object localObject1;
        if (this.jdField_a_of_type_Int == 100044)
        {
          localObject1 = OpenSelectPermissionFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a).a().a(OpenSelectPermissionFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a));
          localObject2 = this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a.getActivity().getIntent().getStringExtra("packagename");
          localObject3 = this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a.getActivity().getIntent().getStringExtra("packagesign");
          AuthReporter.a(((AccountInfo)localObject1).a, OpenSelectPermissionFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a), (String)localObject2, (String)localObject3);
          localObject1 = AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse, this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a.getResources(), this.jdField_a_of_type_Int);
          AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a.getActivity(), (String)localObject1, new OpenSelectPermissionFragment.4.1.1(this));
        }
        else
        {
          localObject1 = AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthResponse, this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a.getResources(), this.jdField_a_of_type_Int);
          AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a.getActivity(), (String)localObject1, false);
          OpenSelectPermissionFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment$4.a, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.4.1
 * JD-Core Version:    0.7.0.1
 */