package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment;

import com.tencent.livesdk.accountengine.UserInitStateCallback;
import com.tencent.qphone.base.util.QLog;

class LiteLiveWebViewFragment$2
  implements UserInitStateCallback
{
  LiteLiveWebViewFragment$2(LiteLiveWebViewFragment paramLiteLiveWebViewFragment) {}
  
  public void onAvInitFail() {}
  
  public void onAvInitSucceed() {}
  
  public void onLoginFail(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wait login--fail--errCode=");
    localStringBuilder.append(paramInt);
    QLog.e("LiteLiveWebViewFragment", 1, localStringBuilder.toString());
  }
  
  public void onLoginSucceed()
  {
    LiteLiveWebViewFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment.LiteLiveWebViewFragment.2
 * JD-Core Version:    0.7.0.1
 */