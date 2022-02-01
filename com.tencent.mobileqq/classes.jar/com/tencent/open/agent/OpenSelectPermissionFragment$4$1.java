package com.tencent.open.agent;

import android.os.SystemClock;
import android.text.TextUtils;
import anni;
import bino;
import bios;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.model.AccountManage.RefreshReason;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSelectPermissionFragment$4$1
  implements Runnable
{
  public OpenSelectPermissionFragment$4$1(bino parambino, boolean paramBoolean, bios parambios, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bios != null))
    {
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bino.a, true);
      this.jdField_a_of_type_Bino.a.a(this.jdField_a_of_type_Bios.c.get());
      this.jdField_a_of_type_Bino.a.a(this.jdField_a_of_type_Bios.c.get(), this.jdField_a_of_type_Bios.e.get());
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", this.jdField_a_of_type_Bios.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get());
        localJSONObject.put("openid", this.jdField_a_of_type_Bios.c.get());
        localJSONObject.put("access_token", this.jdField_a_of_type_Bios.jdField_b_of_type_ComTencentMobileqqPbPBStringField.get());
        localJSONObject.put("pay_token", this.jdField_a_of_type_Bios.d.get());
        localJSONObject.put("expires_in", this.jdField_a_of_type_Bios.jdField_a_of_type_ComTencentMobileqqPbPBInt64Field.get());
        localJSONObject.put("code", this.jdField_a_of_type_Bios.n.get());
        localJSONObject.put("proxy_code", this.jdField_a_of_type_Bios.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse.code.get());
        localJSONObject.put("proxy_expires_in", this.jdField_a_of_type_Bios.jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse.expires_in.get());
        localJSONObject.put("pf", this.jdField_a_of_type_Bios.f.get());
        localJSONObject.put("pfkey", this.jdField_a_of_type_Bios.g.get());
        localJSONObject.put("msg", this.jdField_a_of_type_Bios.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get());
        localJSONObject.put("login_cost", OpenSelectPermissionFragment.c(this.jdField_a_of_type_Bino.a));
        localJSONObject.put("query_authority_cost", OpenSelectPermissionFragment.d(this.jdField_a_of_type_Bino.a));
        localJSONObject.put("authority_cost", SystemClock.elapsedRealtime() - OpenSelectPermissionFragment.e(this.jdField_a_of_type_Bino.a));
        if (this.jdField_a_of_type_Bios.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field.has()) {
          localJSONObject.put("sendinstall", this.jdField_a_of_type_Bios.jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field.get());
        }
        if ((this.jdField_a_of_type_Bios.j.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bios.j.get()))) {
          localJSONObject.put("installwording", this.jdField_a_of_type_Bios.j.get());
        }
        if ((this.jdField_a_of_type_Bios.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.has()) && (this.jdField_a_of_type_Bios.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.size() > 0))
        {
          Iterator localIterator = this.jdField_a_of_type_Bios.jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.get().iterator();
          while (localIterator.hasNext())
          {
            appType.PassData localPassData = (appType.PassData)localIterator.next();
            localJSONObject.put(localPassData.key.get(), localPassData.value.get());
            continue;
            this.jdField_a_of_type_Bino.a.a();
          }
        }
      }
      catch (JSONException localJSONException) {}
      for (;;)
      {
        return;
        this.jdField_a_of_type_Bino.a.a(this.jdField_a_of_type_Bios.jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get(), localJSONException.toString(), null, null);
      }
    }
    if (this.jdField_a_of_type_Int == 110509)
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "onDoAuthorize mAuthRetryCountBy110509=" + OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bino.a));
      if (OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bino.a) >= 2) {
        OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bino.a, anni.a(2131699946), false);
      }
      for (;;)
      {
        OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bino.a, false);
        break;
        OpenSelectPermissionFragment.b(this.jdField_a_of_type_Bino.a);
        OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bino.a, AccountManage.RefreshReason.forceRefreshBy110509);
      }
    }
    if ((this.jdField_a_of_type_Bios != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bios.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get()))) {
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bino.a, this.jdField_a_of_type_Bios.jdField_a_of_type_ComTencentMobileqqPbPBStringField.get() + anni.a(2131706619) + this.jdField_a_of_type_Int, false);
    }
    for (;;)
    {
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bino.a, false);
      break;
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bino.a, anni.a(2131706629) + this.jdField_a_of_type_Int, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.4.1
 * JD-Core Version:    0.7.0.1
 */