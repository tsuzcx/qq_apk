package com.tencent.qqmini.sdk.core.auth.ui;

import android.support.v4.app.FragmentActivity;
import com.tencent.qqmini.sdk.core.auth.AuthState;
import com.tencent.qqmini.sdk.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.List;

class PermissionSettingFragment$1
  implements ChannelProxy.AuthListResult
{
  PermissionSettingFragment$1(PermissionSettingFragment paramPermissionSettingFragment, String paramString) {}
  
  public void onReceiveResult(boolean paramBoolean, List<UserAuthInfo> paramList, List<UserSettingInfo> paramList1)
  {
    if (paramBoolean)
    {
      this.this$0.authState.updateAuthStateList(null, paramList1);
      this.this$0.authState.setSynchronized();
      this.this$0.getActivity().runOnUiThread(new PermissionSettingFragment.1.1(this));
      return;
    }
    QMLog.e(PermissionSettingFragment.access$200(), "getSetting-getAuthStateList failed");
    this.this$0.getActivity().runOnUiThread(new PermissionSettingFragment.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.auth.ui.PermissionSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */