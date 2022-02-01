package com.tencent.mobileqq.nearby;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

class NearbyJsInterface$MyNetEventHandler
  implements INetEventHandler
{
  private int b = -1;
  
  NearbyJsInterface$MyNetEventHandler(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = HttpUtil.getNetWorkType();
    NearbyJsInterface.a(this.a, this.b, i);
    this.b = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.MyNetEventHandler
 * JD-Core Version:    0.7.0.1
 */