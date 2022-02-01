package com.tencent.mobileqq.qqexpand.bean.match;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

public class ExtendFriendLocationInfo
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public static ExtendFriendLocationInfo a(SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      ExtendFriendLocationInfo localExtendFriendLocationInfo = new ExtendFriendLocationInfo();
      localExtendFriendLocationInfo.a = ((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
      localExtendFriendLocationInfo.b = ((int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      localExtendFriendLocationInfo.d = 1;
      localExtendFriendLocationInfo.c = ((int)paramSosoLbsInfo.mLocation.altitude);
      return localExtendFriendLocationInfo;
    }
    return null;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lat:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" lon:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" alt:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" type:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.match.ExtendFriendLocationInfo
 * JD-Core Version:    0.7.0.1
 */