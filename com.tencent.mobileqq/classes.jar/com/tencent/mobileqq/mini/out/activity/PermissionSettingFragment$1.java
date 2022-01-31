package com.tencent.mobileqq.mini.out.activity;

import NS_MINI_INTERFACE.INTERFACE.StGetAuthListRsp;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PermissionSettingFragment$1
  implements MiniAppCmdInterface
{
  PermissionSettingFragment$1(PermissionSettingFragment paramPermissionSettingFragment, String paramString) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      QLog.d(PermissionSettingFragment.access$000(), 1, "getSetting-getAuthList suc, ret:" + paramJSONObject.toString());
      paramJSONObject = paramJSONObject.opt("authList");
      if ((paramJSONObject instanceof byte[]))
      {
        INTERFACE.StGetAuthListRsp localStGetAuthListRsp = new INTERFACE.StGetAuthListRsp();
        try
        {
          localStGetAuthListRsp.mergeFrom((byte[])paramJSONObject);
          paramJSONObject = localStGetAuthListRsp.settings.get();
          this.this$0.authorizeCenter.updateAuthList(null, paramJSONObject);
          this.this$0.authorizeCenter.setAuthorizeSynchronized();
          this.this$0.getActivity().runOnUiThread(new PermissionSettingFragment.1.1(this));
          return;
        }
        catch (InvalidProtocolBufferMicroException paramJSONObject)
        {
          QLog.e(PermissionSettingFragment.access$000(), 1, "getSetting, InvalidProtocolBufferMicroException:" + paramJSONObject);
          paramJSONObject.printStackTrace();
        }
      }
    }
    for (;;)
    {
      this.this$0.getActivity().runOnUiThread(new PermissionSettingFragment.1.2(this));
      return;
      QLog.e(PermissionSettingFragment.access$000(), 1, "getSetting-getAuthList failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */