package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProSwitchPresenceArchiveCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISwitchPresenceArchiveCallback;

class GProSdkWrapperImpl$85
  implements IGProSwitchPresenceArchiveCallback
{
  GProSdkWrapperImpl$85(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, ISwitchPresenceArchiveCallback paramISwitchPresenceArchiveCallback) {}
  
  public void onSwitchPresenceArchive(int paramInt1, String paramString, int paramInt2)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.85.1(this, paramInt1, paramString, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.85
 * JD-Core Version:    0.7.0.1
 */