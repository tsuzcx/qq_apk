package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Bundle;
import com.tencent.gprosdk.IGProSdkWrapper;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import mqq.observer.BusinessObserver;

public class GProSdkWrapperImpl$GProSdkObserver
  implements BusinessObserver
{
  public GProSdkWrapperImpl$GProSdkObserver(GProSdkWrapperImpl paramGProSdkWrapperImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = paramBundle.getLong("requestId", 0L);
    Object localObject1 = new byte[0];
    if (paramBoolean)
    {
      localObject2 = paramBundle.getByteArray("bytes_bodybuffer");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new byte[0];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("requestId : ");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(" resp buff is null");
        GProLog.a("GProSdkWrapperImpl", true, "network", "onReceive", "", ((StringBuilder)localObject2).toString());
      }
    }
    paramInt = paramBundle.getInt("result");
    Object localObject2 = paramBundle.getString("data_error_msg", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestId : ");
    localStringBuilder.append(l);
    localStringBuilder.append(", isSuccess: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", result : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errorMsg : ");
    localStringBuilder.append((String)localObject2);
    GProLog.a("GProSdkWrapperImpl", false, "network", "onReceive", "", localStringBuilder.toString());
    if (paramBundle.getInt("type", 0) == 0)
    {
      int i = paramBundle.getInt("cmd_int", 0);
      paramBundle = new StringBuilder();
      paramBundle.append("cmd: ");
      paramBundle.append(i);
      GProLog.a("GProSdkWrapperImpl", false, "network", "onReceive", "", paramBundle.toString());
      GProSdkWrapperImpl.a(this.a).onSendPbReply(l, i, paramInt, (String)localObject2, (byte[])localObject1);
      return;
    }
    paramBundle = paramBundle.getString("cmd");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ssoCmd: ");
    localStringBuilder.append(paramBundle);
    GProLog.a("GProSdkWrapperImpl", false, "network", "onReceive", "", localStringBuilder.toString());
    GProSdkWrapperImpl.a(this.a).onSendSSOReply(l, paramBundle, paramInt, (String)localObject2, (byte[])localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkObserver
 * JD-Core Version:    0.7.0.1
 */