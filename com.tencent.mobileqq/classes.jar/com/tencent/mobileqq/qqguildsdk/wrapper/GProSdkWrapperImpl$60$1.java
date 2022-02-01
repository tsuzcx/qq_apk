package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IGetMoreNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GProSdkWrapperImpl$60$1
  implements Runnable
{
  GProSdkWrapperImpl$60$1(GProSdkWrapperImpl.60 param60, int paramInt1, String paramString, ArrayList paramArrayList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {}
  
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
    ((StringBuilder)localObject2).append(" resetList:");
    ((StringBuilder)localObject2).append(this.f);
    GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper callback", "on getMoreNoticeList", "", j, (String)localObject1, ((StringBuilder)localObject2).toString(), this.g.a);
    localObject1 = GProSdkWrapperImpl.a(this.g.c, this.c);
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (GuildNotice)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("noticeInfo:");
      localStringBuilder.append(((GuildNotice)localObject3).toString());
      GProLog.a("GProSdkWrapperImpl", false, "sdkWrapper callback", "getMoreNoticeList", "", 0, "", localStringBuilder.toString());
    }
    this.g.b.a(this.a, this.b, this.f, this.d, this.e, (List)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.60.1
 * JD-Core Version:    0.7.0.1
 */