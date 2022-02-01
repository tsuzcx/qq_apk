package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.List;

class GProSdkWrapperImpl$2$1
  implements Runnable
{
  GProSdkWrapperImpl$2$1(GProSdkWrapperImpl.2 param2, int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, String paramString, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    if (this.a == 0)
    {
      localObject1 = GProConvert.c(this.b);
      localObject2 = GProConvert.c(this.c);
      localObject3 = GProConvert.c(this.d);
    }
    int i = this.a;
    Object localObject4 = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("aList ：");
    localStringBuilder.append(((List)localObject1).size());
    localStringBuilder.append(", nList ：");
    localStringBuilder.append(((List)localObject2).size());
    localStringBuilder.append(", rList ：");
    localStringBuilder.append(((List)localObject3).size());
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "getUserList", "Access DB first and then Svr", i, (String)localObject4, localStringBuilder.toString(), this.g.a);
    localObject4 = GProUserListPaginationRequest.PaginationCookie.a(this.g.b, this.f);
    this.g.c.onGetUserList(this.g.b, this.a, this.e, localObject4, (List)localObject1, (List)localObject2, (List)localObject3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.2.1
 * JD-Core Version:    0.7.0.1
 */