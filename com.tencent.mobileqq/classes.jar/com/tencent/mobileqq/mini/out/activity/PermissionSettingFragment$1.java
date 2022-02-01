package com.tencent.mobileqq.mini.out.activity;

import NS_MINI_INTERFACE.INTERFACE.StGetAuthListRsp;
import com.tencent.mobileqq.app.BaseActivity;
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
      Object localObject = PermissionSettingFragment.access$000();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSetting-getAuthList suc, ret:");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      paramJSONObject = paramJSONObject.opt("authList");
      if ((paramJSONObject instanceof byte[]))
      {
        localObject = new INTERFACE.StGetAuthListRsp();
        try
        {
          ((INTERFACE.StGetAuthListRsp)localObject).mergeFrom((byte[])paramJSONObject);
          paramJSONObject = ((INTERFACE.StGetAuthListRsp)localObject).settings.get();
          this.this$0.authorizeCenter.updateAuthList(null, paramJSONObject);
          this.this$0.authorizeCenter.setAuthorizeSynchronized();
          this.this$0.getBaseActivity().runOnUiThread(new PermissionSettingFragment.1.1(this));
          return;
        }
        catch (InvalidProtocolBufferMicroException paramJSONObject)
        {
          localObject = PermissionSettingFragment.access$000();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getSetting, InvalidProtocolBufferMicroException:");
          localStringBuilder.append(paramJSONObject);
          QLog.e((String)localObject, 1, localStringBuilder.toString());
          paramJSONObject.printStackTrace();
        }
      }
    }
    else
    {
      QLog.e(PermissionSettingFragment.access$000(), 1, "getSetting-getAuthList failed");
    }
    this.this$0.getBaseActivity().runOnUiThread(new PermissionSettingFragment.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */