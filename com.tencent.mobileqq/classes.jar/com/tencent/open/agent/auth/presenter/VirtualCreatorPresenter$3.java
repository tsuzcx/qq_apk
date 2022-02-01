package com.tencent.open.agent.auth.presenter;

import com.tencent.open.agent.authority.CGICallback;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import org.json.JSONException;
import org.json.JSONObject;

class VirtualCreatorPresenter$3
  implements CGICallback
{
  VirtualCreatorPresenter$3(VirtualCreatorPresenter paramVirtualCreatorPresenter, AccountInfo paramAccountInfo, String paramString) {}
  
  public boolean a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    SSOLog.a("VirtualCreatorPresenter", new Object[] { "OpenVirtual.uploadAvatarImage.result:", OpenSdkVirtualUtil.a(paramString1, this.a.a) });
    Object localObject = null;
    paramString2 = null;
    int i = paramInt;
    if (paramBoolean)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        i = paramString1.optInt("ErrorCode");
        if (i == 0) {}
        try
        {
          paramString1 = paramString1.optJSONObject("msg_img_data");
          if (paramString1 == null) {
            break label227;
          }
          paramString1 = paramString1.optString("str_file_name");
          paramBoolean = true;
        }
        catch (JSONException paramString1)
        {
          paramInt = i;
          break label109;
        }
        paramInt = paramString1.optInt("uint32_ret_to_http", i);
        i = paramInt;
      }
      catch (JSONException paramString1) {}
      label109:
      SSOLog.a("VirtualCreatorPresenter", "OpenVirtual.uploadAvatarImage.e:", paramString1);
      i = paramInt;
    }
    paramBoolean = false;
    for (paramString1 = paramString2;; paramString1 = localObject)
    {
      if (paramBoolean)
      {
        VirtualCreatorPresenter.a(this.c, paramBoolean, this.b, paramString1, i);
        return false;
      }
      VirtualCreatorPresenter.b(this.c);
      if (VirtualCreatorPresenter.c(this.c) >= 2)
      {
        VirtualCreatorPresenter.a(this.c, paramBoolean, this.b, paramString1, i);
        return false;
      }
      paramString1 = new StringBuilder();
      paramString1.append("OpenVirtual.uploadAvatarImage need retry mUploadAvatarRetryCount=");
      paramString1.append(VirtualCreatorPresenter.c(this.c));
      SSOLog.a("VirtualCreatorPresenter", new Object[] { paramString1.toString() });
      return true;
      label227:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.VirtualCreatorPresenter.3
 * JD-Core Version:    0.7.0.1
 */