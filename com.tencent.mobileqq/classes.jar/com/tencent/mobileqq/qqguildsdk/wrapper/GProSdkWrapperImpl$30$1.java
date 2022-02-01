package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProInviteInfo;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchInviteInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildInviteInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGuildInviteInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$30$1
  implements Runnable
{
  GProSdkWrapperImpl$30$1(GProSdkWrapperImpl.30 param30, int paramInt, String paramString, GProInviteInfo paramGProInviteInfo, GProSecurityResult paramGProSecurityResult) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject2 = this.b;
    Object localObject3 = new StringBuilder();
    if (this.c != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getName ：");
      ((StringBuilder)localObject1).append(this.c.getName());
      ((StringBuilder)localObject1).append(", getNickName ：");
      ((StringBuilder)localObject1).append(this.c.getNickName());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "inviteInfo is null";
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(GProSdkWrapperImpl.a(this.e.c, this.d));
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchGuildInfoByInviteCode", "ui", i, (String)localObject2, ((StringBuilder)localObject3).toString(), this.e.a);
    localObject2 = this.e.b;
    i = this.a;
    localObject3 = this.b;
    Object localObject1 = this.c;
    if (localObject1 != null) {
      localObject1 = new GuildInviteInfo((GProInviteInfo)localObject1);
    } else {
      localObject1 = null;
    }
    ((IFetchInviteInfoCallback)localObject2).a(i, (String)localObject3, (IGuildInviteInfo)localObject1, GProSdkWrapperImpl.b(this.e.c, this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.30.1
 * JD-Core Version:    0.7.0.1
 */