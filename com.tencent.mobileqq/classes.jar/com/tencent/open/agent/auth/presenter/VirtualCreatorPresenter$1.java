package com.tencent.open.agent.auth.presenter;

import com.tencent.open.agent.authority.CGICallback;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import org.json.JSONException;
import org.json.JSONObject;

class VirtualCreatorPresenter$1
  implements CGICallback
{
  VirtualCreatorPresenter$1(VirtualCreatorPresenter paramVirtualCreatorPresenter, AccountInfo paramAccountInfo) {}
  
  public boolean a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    SSOLog.a("VirtualCreatorPresenter", new Object[] { "createVirtual onResult success=", Boolean.valueOf(paramBoolean), ", errCode=", Integer.valueOf(paramInt), ", errMsg=", paramString2 });
    AuthReporter.a("KEY_CREATE_VIRTUAL_D17", this.jdField_a_of_type_ComTencentOpenModelAccountInfo, paramBoolean);
    int i = paramInt;
    if (paramBoolean)
    {
      i = paramInt;
      try
      {
        paramString1 = new JSONObject(paramString1);
        i = paramInt;
        paramInt = paramString1.optInt("ErrorCode");
        i = paramInt;
        if (paramInt == 0)
        {
          i = paramInt;
          long l = paramString1.optLong("uint64_vuid");
          i = paramInt;
          VirtualCreatorPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterVirtualCreatorPresenter, true, l, paramInt);
          return false;
        }
      }
      catch (JSONException paramString1)
      {
        SSOLog.a("VirtualCreatorPresenter", "OpenVirtual.createVirtual.e:", paramString1);
      }
    }
    VirtualCreatorPresenter.a(this.jdField_a_of_type_ComTencentOpenAgentAuthPresenterVirtualCreatorPresenter, false, 0L, i);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.VirtualCreatorPresenter.1
 * JD-Core Version:    0.7.0.1
 */