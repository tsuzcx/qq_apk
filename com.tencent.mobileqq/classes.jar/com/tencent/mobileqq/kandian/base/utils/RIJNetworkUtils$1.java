package com.tencent.mobileqq.kandian.base.utils;

import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class RIJNetworkUtils$1
  implements INetEventHandler
{
  RIJNetworkUtils$1(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RIJNetworkUtils.a(this.a);
      return;
    }
    RIJNetworkUtils.a("");
    RIJNetworkUtils.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.RIJNetworkUtils.1
 * JD-Core Version:    0.7.0.1
 */