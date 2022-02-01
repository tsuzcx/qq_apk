package com.tencent.weiyun;

import android.content.Context;
import android.net.NetworkInfo;
import com.tencent.weiyun.utils.NetworkUtils.INetworkInfoProvider;

class WeiyunLiteGlobal$2
  implements NetworkUtils.INetworkInfoProvider
{
  WeiyunLiteGlobal$2(WeiyunLiteGlobal paramWeiyunLiteGlobal) {}
  
  public NetworkInfo getNetworkInfo(Context paramContext)
  {
    return WeiyunLiteGlobal.access$100(this.this$0).getRecentNetworkInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.WeiyunLiteGlobal.2
 * JD-Core Version:    0.7.0.1
 */