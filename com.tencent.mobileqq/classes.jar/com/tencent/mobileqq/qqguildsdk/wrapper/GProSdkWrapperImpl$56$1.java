package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IGetAddGuildOptionCallback;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$56$1
  implements Runnable
{
  GProSdkWrapperImpl$56$1(GProSdkWrapperImpl.56 param56, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId ：");
    localStringBuilder.append(this.f.a);
    localStringBuilder.append(" option:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" question:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" answer:");
    localStringBuilder.append(this.e);
    GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper callback", "on getAddGuildOption", "ui", i, (String)localObject, localStringBuilder.toString(), this.f.b);
    localObject = new AddGuildOption();
    ((AddGuildOption)localObject).a = this.c;
    ((AddGuildOption)localObject).b = this.d;
    ((AddGuildOption)localObject).c = this.e;
    this.f.c.a(this.a, this.b, (AddGuildOption)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.56.1
 * JD-Core Version:    0.7.0.1
 */