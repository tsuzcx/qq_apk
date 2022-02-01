package com.tencent.mobileqq.highway.ipv6;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;

public class Ipv6Flags
{
  public int mBdhStrategy;
  public int mConnAttemptDelay;
  public int mRMDownStrategy;
  
  Ipv6Flags() {}
  
  Ipv6Flags(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mRMDownStrategy = paramInt1;
    this.mBdhStrategy = paramInt2;
    this.mConnAttemptDelay = paramInt3;
  }
  
  public boolean isIpv6BDHFirst()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Ipv6Config.isIpv6BDHFirst, mBdhStrategy = ");
    localStringBuilder.append(this.mBdhStrategy);
    BdhLogUtil.LogEvent("E", localStringBuilder.toString());
    if (this.mBdhStrategy == 2) {
      return true;
    }
    if (this.mRMDownStrategy == 3) {
      return MsfServiceSdk.get().getConnectedIPFamily() == 2;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.ipv6.Ipv6Flags
 * JD-Core Version:    0.7.0.1
 */