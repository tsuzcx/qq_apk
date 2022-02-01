package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog;

import com.tencent.livesdk.accountengine.UserInitStateCallback;
import com.tencent.qphone.base.util.QLog;

class BaseWebDialogFragment$2
  implements UserInitStateCallback
{
  BaseWebDialogFragment$2(BaseWebDialogFragment paramBaseWebDialogFragment) {}
  
  public void onAvInitFail() {}
  
  public void onAvInitSucceed() {}
  
  public void onLoginFail(int paramInt)
  {
    QLog.e("BaseWebDialogFragment", 1, "wait login--fail--errCode=" + paramInt);
  }
  
  public void onLoginSucceed()
  {
    BaseWebDialogFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog.BaseWebDialogFragment.2
 * JD-Core Version:    0.7.0.1
 */