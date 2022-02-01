package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.ISearchVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.List;

class GProSdkWrapperImpl$25$1
  implements Runnable
{
  GProSdkWrapperImpl$25$1(GProSdkWrapperImpl.25 param25, int paramInt, String paramString, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("memberList: ");
    localStringBuilder.append(this.c.size());
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "searchVisibleMemberList", "callback", i, (String)localObject, localStringBuilder.toString(), this.d.a);
    localObject = GProConvert.c(this.c);
    this.d.b.onSearchVisibleMemberList(this.a, this.b, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.25.1
 * JD-Core Version:    0.7.0.1
 */