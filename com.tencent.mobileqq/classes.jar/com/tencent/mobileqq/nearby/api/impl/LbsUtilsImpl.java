package com.tencent.mobileqq.nearby.api.impl;

import NearbyGroup.LBSInfo;
import com.tencent.mobileqq.nearby.api.ILbsUtils;
import com.tencent.mobileqq.nearby.api.LbsUtils;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

public class LbsUtilsImpl
  implements ILbsUtils
{
  public LBSInfo createLbsInfo(boolean paramBoolean, SosoLbsInfo paramSosoLbsInfo)
  {
    return LbsUtils.a(paramBoolean, paramSosoLbsInfo);
  }
  
  public Object getLbsInfo(String paramString)
  {
    return LbsUtils.a(paramString);
  }
  
  public LBSInfo getRawLbsInfo()
  {
    return LbsUtils.a();
  }
  
  public String lbsInfoToString(SosoLbsInfo paramSosoLbsInfo)
  {
    return LbsUtils.a(paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.LbsUtilsImpl
 * JD-Core Version:    0.7.0.1
 */