package com.tencent.open.agent;

import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import anvx;
import bjfc;
import bjfd;
import bjgh;
import bjhg;
import bjhh;
import bjpl;
import bjqa;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSelectPermissionFragment$4$1
  implements Runnable
{
  public OpenSelectPermissionFragment$4$1(bjfc parambjfc, boolean paramBoolean, bjgh parambjgh, int paramInt) {}
  
  public void run()
  {
    Object localObject2;
    Object localObject3;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bjgh != null))
    {
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bjfc.a, true);
      this.jdField_a_of_type_Bjfc.a.a(this.jdField_a_of_type_Bjgh.c.get());
      this.jdField_a_of_type_Bjfc.a.a(this.jdField_a_of_type_Bjgh.c.get(), this.jdField_a_of_type_Bjgh.e.get());
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get());
        localJSONObject.put("openid", this.jdField_a_of_type_Bjgh.c.get());
        localJSONObject.put("access_token", this.jdField_a_of_type_Bjgh.jdField_b_of_type_ComTencentMobileqqPbPBStringField.get());
        localJSONObject.put("pay_token", this.jdField_a_of_type_Bjgh.d.get());
        localJSONObject.put("expires_in", this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field.get());
        localJSONObject.put("code", this.jdField_a_of_type_Bjgh.n.get());
        localJSONObject.put("proxy_code", this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse.code.get());
        localJSONObject.put("proxy_expires_in", this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse.expires_in.get());
        localJSONObject.put("pf", this.jdField_a_of_type_Bjgh.f.get());
        localJSONObject.put("pfkey", this.jdField_a_of_type_Bjgh.g.get());
        localJSONObject.put("msg", this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get());
        localJSONObject.put("login_cost", OpenSelectPermissionFragment.c(this.jdField_a_of_type_Bjfc.a));
        localJSONObject.put("query_authority_cost", OpenSelectPermissionFragment.d(this.jdField_a_of_type_Bjfc.a));
        localJSONObject.put("authority_cost", SystemClock.elapsedRealtime() - OpenSelectPermissionFragment.e(this.jdField_a_of_type_Bjfc.a));
        if (this.jdField_a_of_type_Bjgh.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field.has()) {
          localJSONObject.put("sendinstall", this.jdField_a_of_type_Bjgh.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field.get());
        }
        if ((this.jdField_a_of_type_Bjgh.j.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bjgh.j.get()))) {
          localJSONObject.put("installwording", this.jdField_a_of_type_Bjgh.j.get());
        }
        if ((this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.has()) && (this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.size() > 0))
        {
          localObject2 = this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (appType.PassData)((Iterator)localObject2).next();
            localJSONObject.put(((appType.PassData)localObject3).key.get(), ((appType.PassData)localObject3).value.get());
            continue;
            this.jdField_a_of_type_Bjfc.a.a();
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
      this.jdField_a_of_type_Bjfc.a.a(this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get(), localJSONException.toString(), null, null);
      continue;
      if (this.jdField_a_of_type_Int == 110509)
      {
        QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "onDoAuthorize mAuthRetryCountBy110509=" + OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bjfc.a));
        if (OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bjfc.a) >= 2) {
          OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bjfc.a);
        }
        for (;;)
        {
          OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bjfc.a, false);
          break;
          OpenSelectPermissionFragment.b(this.jdField_a_of_type_Bjfc.a);
          OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bjfc.a, 3);
        }
      }
      if (this.jdField_a_of_type_Int == 110537)
      {
        QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "onDoAuthorize 110537");
        bjhh.a(this.jdField_a_of_type_Bjfc.a.getActivity(), anvx.a(2131707309), false);
        OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bjfc.a);
      }
      else if (this.jdField_a_of_type_Int == 100044)
      {
        Object localObject1 = OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bjfc.a).a().a(OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bjfc.a));
        localObject2 = this.jdField_a_of_type_Bjfc.a.getActivity().getIntent().getStringExtra("packagename");
        localObject3 = this.jdField_a_of_type_Bjfc.a.getActivity().getIntent().getStringExtra("packagesign");
        bjhg.a(((bjpl)localObject1).a, OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bjfc.a), (String)localObject2, (String)localObject3);
        localObject2 = anvx.a(2131694461);
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bjgh != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get())) {
            localObject1 = this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get();
          }
        }
        localObject1 = String.format(this.jdField_a_of_type_Bjfc.a.getResources().getString(2131696223), new Object[] { localObject1, Integer.valueOf(this.jdField_a_of_type_Int) });
        bjhh.a(this.jdField_a_of_type_Bjfc.a.getActivity(), (String)localObject1, new bjfd(this));
      }
      else
      {
        if ((this.jdField_a_of_type_Bjgh != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get()))) {
          QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "-->onDoAuthorize error msg: " + this.jdField_a_of_type_Bjgh.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get());
        }
        bjhh.a(this.jdField_a_of_type_Bjfc.a.getActivity(), anvx.a(2131694461), false);
        OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bjfc.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.4.1
 * JD-Core Version:    0.7.0.1
 */