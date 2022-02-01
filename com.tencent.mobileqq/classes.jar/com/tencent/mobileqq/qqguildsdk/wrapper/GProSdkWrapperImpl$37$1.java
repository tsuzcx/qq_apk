package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.IGProFetchAudioChannelUserListCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GProSdkWrapperImpl$37$1
  implements Runnable
{
  GProSdkWrapperImpl$37$1(GProSdkWrapperImpl.37 param37, int paramInt, String paramString, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildId ：");
    ((StringBuilder)localObject).append(this.d.a);
    ((StringBuilder)localObject).append(this.c);
    if (((StringBuilder)localObject).toString() != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", channelMemberInfo size: ");
      ((StringBuilder)localObject).append(this.c.size());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchOneAudioChannelUserList", "", i, str, (String)localObject, this.d.b);
    this.d.c.onGetAudioChannelUsers(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.37.1
 * JD-Core Version:    0.7.0.1
 */