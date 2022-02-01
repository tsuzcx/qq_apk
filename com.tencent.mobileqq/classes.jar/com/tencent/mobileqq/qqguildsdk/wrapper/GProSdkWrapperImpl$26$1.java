package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchVisibleMemberListByTinyIdCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.List;

class GProSdkWrapperImpl$26$1
  implements Runnable
{
  GProSdkWrapperImpl$26$1(GProSdkWrapperImpl.26 param26, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("memberList: ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", failList: ");
    ((StringBuilder)localObject).append(this.b.size());
    localObject = ((StringBuilder)localObject).toString();
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchVisibleMemberListByTinyId", "callback", this.c, this.d, (String)localObject, this.e.a);
    localObject = GProConvert.c(this.a);
    ArrayList localArrayList = GProConvert.b(this.b);
    this.e.b.onFetchVisibleMemberListByTinyId(this.c, this.d, (List)localObject, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.26.1
 * JD-Core Version:    0.7.0.1
 */