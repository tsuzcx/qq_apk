package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

final class BridgeModuleHelper$20
  extends LbsManagerServiceOnLocationChangeListener
{
  BridgeModuleHelper$20(String paramString1, BridgeModule paramBridgeModule, String paramString2)
  {
    super(paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      BridgeModuleHelper.a(this.a, paramSosoLbsInfo, this.b);
      return;
    }
    paramSosoLbsInfo = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errorCode: ");
    localStringBuilder.append(paramInt);
    BridgeModuleHelper.b(paramSosoLbsInfo, str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.20
 * JD-Core Version:    0.7.0.1
 */