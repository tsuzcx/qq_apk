package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProNoticeRedPoint;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchNoticeRedPointCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildNoticeRedPoint;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GProSdkWrapperImpl$62$1
  implements Runnable
{
  GProSdkWrapperImpl$62$1(GProSdkWrapperImpl.62 param62, ArrayList paramArrayList, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("redPoints:");
    ArrayList localArrayList = this.a;
    int i;
    if (localArrayList != null) {
      i = localArrayList.size();
    } else {
      i = 0;
    }
    ((StringBuilder)localObject1).append(i);
    localObject1 = ((StringBuilder)localObject1).toString();
    localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (GProNoticeRedPoint)localIterator.next();
      Object localObject2 = new GuildNoticeRedPoint();
      ((GuildNoticeRedPoint)localObject2).b = ((GProNoticeRedPoint)localObject3).getCount();
      ((GuildNoticeRedPoint)localObject2).a = ((GProNoticeRedPoint)localObject3).getType();
      ((GuildNoticeRedPoint)localObject2).c = ((GProNoticeRedPoint)localObject3).getExpireTs();
      localArrayList.add(localObject2);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" info:{ type:");
      ((StringBuilder)localObject3).append(((GuildNoticeRedPoint)localObject2).a);
      ((StringBuilder)localObject3).append(" count:");
      ((StringBuilder)localObject3).append(((GuildNoticeRedPoint)localObject2).b);
      ((StringBuilder)localObject3).append(" expireTs");
      ((StringBuilder)localObject3).append(((GuildNoticeRedPoint)localObject2).c);
      ((StringBuilder)localObject3).append("}");
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject3).toString();
    }
    GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper callback", "on fetchNoticeRedPoint", "", this.b, this.c, (String)localObject1, this.d.a);
    this.d.b.a(this.b, this.c, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.62.1
 * JD-Core Version:    0.7.0.1
 */