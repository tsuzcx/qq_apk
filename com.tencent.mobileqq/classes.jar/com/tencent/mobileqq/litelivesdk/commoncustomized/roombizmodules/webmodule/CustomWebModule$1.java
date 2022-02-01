package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import com.tencent.livesdk.accountengine.UserInitStateCallback;
import com.tencent.qphone.base.util.QLog;

class CustomWebModule$1
  implements UserInitStateCallback
{
  CustomWebModule$1(CustomWebModule paramCustomWebModule) {}
  
  public void onAvInitFail() {}
  
  public void onAvInitSucceed() {}
  
  public void onLoginFail(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wait login--fail--errCode=");
    localStringBuilder.append(paramInt);
    QLog.e("IliveCustomWebModule", 1, localStringBuilder.toString());
  }
  
  public void onLoginSucceed()
  {
    CustomWebModule.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.1
 * JD-Core Version:    0.7.0.1
 */