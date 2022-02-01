package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchVisibleMemberListCallback;
import java.util.ArrayList;
import java.util.List;

class GProSdkWrapperImpl$23$1
  implements Runnable
{
  GProSdkWrapperImpl$23$1(GProSdkWrapperImpl.23 param23, int paramInt1, long paramLong, ArrayList paramArrayList, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("memberCount=");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", nextIndex=");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", memberList=");
    ((StringBuilder)localObject).append(this.c.size());
    localObject = ((StringBuilder)localObject).toString();
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchVisibleMemberList", "callback", this.d, this.e, (String)localObject, this.f.a);
    localObject = GProConvert.c(this.c);
    this.f.b.a(this.d, this.e, this.a, this.b, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.23.1
 * JD-Core Version:    0.7.0.1
 */