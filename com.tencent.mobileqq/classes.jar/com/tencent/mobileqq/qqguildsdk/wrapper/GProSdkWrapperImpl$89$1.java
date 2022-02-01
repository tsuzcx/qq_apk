package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ISearchMemberFromServerCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$89$1
  implements Runnable
{
  GProSdkWrapperImpl$89$1(GProSdkWrapperImpl.89 param89, int paramInt, String paramString1, boolean paramBoolean, ArrayList paramArrayList, String paramString2) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fromSvr: ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(this.d);
    if (((StringBuilder)localObject).toString() != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", size: ");
      ((StringBuilder)localObject).append(this.d.size());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "searchMemberFromServer", "", i, str, (String)localObject, this.f.a);
    this.f.b.a(this.a, this.b, this.e, this.c, GProConvert.c(this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.89.1
 * JD-Core Version:    0.7.0.1
 */