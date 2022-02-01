package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.callback.IKickChannelMemberCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GProSdkWrapperImpl$39$1
  implements Runnable
{
  GProSdkWrapperImpl$39$1(GProSdkWrapperImpl.39 param39, int paramInt, String paramString, GProSecurityResult paramGProSecurityResult, ArrayList paramArrayList) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "kickAudioChannelUsers", "", this.a, this.b, GProSdkWrapperImpl.a(this.e.c, this.c), this.e.a);
    this.e.b.a(this.a, this.b, GProSdkWrapperImpl.b(this.e.c, this.c), GProSdkWrapperImpl.a(this.e.c, this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.39.1
 * JD-Core Version:    0.7.0.1
 */