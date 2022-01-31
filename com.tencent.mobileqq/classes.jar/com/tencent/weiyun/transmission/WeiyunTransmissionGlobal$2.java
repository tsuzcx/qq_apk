package com.tencent.weiyun.transmission;

import android.content.Context;
import android.net.NetworkInfo;
import com.tencent.weiyun.utils.NetworkUtils.INetworkInfoProvider;

class WeiyunTransmissionGlobal$2
  implements NetworkUtils.INetworkInfoProvider
{
  WeiyunTransmissionGlobal$2(WeiyunTransmissionGlobal paramWeiyunTransmissionGlobal) {}
  
  public NetworkInfo getNetworkInfo(Context paramContext)
  {
    return WeiyunTransmissionGlobal.access$100(this.this$0).getRecentNetworkInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.2
 * JD-Core Version:    0.7.0.1
 */