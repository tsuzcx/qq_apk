package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IInitGetNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GProSdkWrapperImpl$59$1
  implements Runnable
{
  GProSdkWrapperImpl$59$1(GProSdkWrapperImpl.59 param59, int paramInt1, String paramString, ArrayList paramArrayList, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    int j = this.a;
    Object localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("noticeList:");
    Object localObject3 = this.c;
    int i;
    if (localObject3 != null) {
      i = ((ArrayList)localObject3).size();
    } else {
      i = 0;
    }
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(" listOffset:");
    ((StringBuilder)localObject2).append(this.d);
    ((StringBuilder)localObject2).append(" isEnd:");
    ((StringBuilder)localObject2).append(this.e);
    GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper callback", "on initGetNoticeList", "", j, (String)localObject1, ((StringBuilder)localObject2).toString(), this.f.a);
    localObject1 = GProSdkWrapperImpl.a(this.f.c, this.c);
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (GuildNotice)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("noticeInfo:");
      localStringBuilder.append(((GuildNotice)localObject3).toString());
      GProLog.a("GProSdkWrapperImpl", false, "sdkWrapper callback", "initGetNoticeList", "", 0, "", localStringBuilder.toString());
    }
    this.f.b.a(this.a, this.b, this.d, this.e, (List)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.59.1
 * JD-Core Version:    0.7.0.1
 */