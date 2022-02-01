package com.tencent.open.virtual;

import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.CreateVirtualResult;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class OpenSdkVirtualManager$1$1
  extends OpenSdkVirtualUtil.CGICallback
{
  OpenSdkVirtualManager$1$1(OpenSdkVirtualManager.1 param1) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.createVirtual.result:", OpenSdkVirtualUtil.a(paramString1, this.a.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString) });
    ForwardStatisticsReporter.a("KEY_CREATE_VIRTUAL_D17", this.a.jdField_a_of_type_ComTencentOpenModelAccountInfo, paramBoolean);
    paramString2 = new CreateVirtualResult();
    int i;
    if (paramBoolean) {
      i = paramInt;
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        i = paramInt;
        paramInt = paramString1.optInt("ErrorCode");
        if (paramInt == 0)
        {
          i = paramInt;
          paramString2.jdField_a_of_type_Long = paramString1.optLong("uint64_vuid");
          i = paramInt;
          paramString2.jdField_a_of_type_JavaLangString = paramString1.optString("str_head_url");
        }
      }
      catch (JSONException paramString1)
      {
        int j = 0;
        paramInt = i;
        i = j;
      }
      try
      {
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.createResult=", OpenSdkVirtualUtil.a(paramString2.toString(), this.a.jdField_a_of_type_ComTencentOpenModelAccountInfo.jdField_a_of_type_JavaLangString) });
        if (this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback != null) {
          this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback.a(true, paramString2, paramInt);
        }
        return;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          i = 1;
        }
      }
      i = 0;
      if ((i == 0) && (this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback != null))
      {
        this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback.a(false, null, paramInt);
        return;
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "OpenVirtual.createVirtual.e:", paramString1);
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.virtual.OpenSdkVirtualManager.1.1
 * JD-Core Version:    0.7.0.1
 */