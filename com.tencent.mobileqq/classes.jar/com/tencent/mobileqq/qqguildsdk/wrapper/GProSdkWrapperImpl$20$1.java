package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$20$1
  implements Runnable
{
  GProSdkWrapperImpl$20$1(GProSdkWrapperImpl.20 param20, int paramInt, String paramString) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "customChannelMsgNotifyType", "ui-setMyMsgNotifyType", this.a, this.b, null, this.c.a);
    this.c.b.a(this.a, null, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.20.1
 * JD-Core Version:    0.7.0.1
 */