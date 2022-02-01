package com.tencent.open.agent;

import android.os.Bundle;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.open.virtual.OpenSdkVirtualManager.GetTicketCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

class OpenSelectPermissionFragment$5
  implements OpenSdkVirtualManager.GetTicketCallback
{
  OpenSelectPermissionFragment$5(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void a(AccountInfo paramAccountInfo)
  {
    OpenSelectPermissionFragment.a(this.a, null);
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket success info.uin=" + AuthorityUtil.a(paramAccountInfo.a));
    if (OpenSelectPermissionFragment.b(this.a))
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket success Activity Finishing");
      return;
    }
    OpenSelectPermissionFragment.a(this.a).a().a(OpenSelectPermissionFragment.a(this.a), paramAccountInfo);
    OpenSelectPermissionFragment.b(this.a);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    OpenSelectPermissionFragment.a(this.a, null);
    QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket onFail");
    if (OpenSelectPermissionFragment.b(this.a))
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "refreshTicket onFail Activity Finishing");
      return;
    }
    OpenSelectPermissionFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.5
 * JD-Core Version:    0.7.0.1
 */