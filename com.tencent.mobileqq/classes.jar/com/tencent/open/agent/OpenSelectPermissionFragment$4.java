package com.tencent.open.agent;

import android.support.v4.app.FragmentActivity;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.agent.authority.AuthResponse;
import com.tencent.qphone.base.util.QLog;

class OpenSelectPermissionFragment$4
  extends AuthCallback
{
  OpenSelectPermissionFragment$4(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, AuthResponse paramAuthResponse)
  {
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, new Object[] { "-->onDoAuthorize isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    if (this.a.getActivity() == null)
    {
      QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "onDoAuthorize activity is null");
      return;
    }
    this.a.getActivity().runOnUiThread(new OpenSelectPermissionFragment.4.1(this, paramBoolean, paramAuthResponse, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.4
 * JD-Core Version:    0.7.0.1
 */