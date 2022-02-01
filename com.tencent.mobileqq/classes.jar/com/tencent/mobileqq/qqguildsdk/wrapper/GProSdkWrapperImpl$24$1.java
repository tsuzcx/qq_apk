package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchChannelMemberListCallback;
import java.util.ArrayList;
import java.util.List;

class GProSdkWrapperImpl$24$1
  implements Runnable
{
  GProSdkWrapperImpl$24$1(GProSdkWrapperImpl.24 param24, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, String paramString, long paramLong) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("memberList: ");
    ((StringBuilder)localObject).append(this.a.size());
    ((StringBuilder)localObject).append("visibleMemberList: ");
    ((StringBuilder)localObject).append(this.b.size());
    localObject = ((StringBuilder)localObject).toString();
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchChannelMemberList", "callback", this.c, this.d, (String)localObject, this.f.a);
    localObject = GProConvert.c(this.a);
    List localList = GProConvert.c(this.b);
    this.f.b.a(this.c, this.d, this.e, (List)localObject, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.24.1
 * JD-Core Version:    0.7.0.1
 */