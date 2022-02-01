package com.tencent.mobileqq.extendfriend.bean;

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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSosoLbsInfo != null)
    {
      localObject1 = localObject2;
      if (paramSosoLbsInfo.mLocation != null)
      {
        localObject1 = new ExtendFriendLocationInfo();
        ((ExtendFriendLocationInfo)localObject1).a = ((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
        ((ExtendFriendLocationInfo)localObject1).b = ((int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
        ((ExtendFriendLocationInfo)localObject1).d = 1;
        ((ExtendFriendLocationInfo)localObject1).c = ((int)paramSosoLbsInfo.mLocation.altitude);
      }
    }
    return localObject1;
  }
  
  @NonNull
  public String toString()
  {
    return "lat:" + this.a + " lon:" + this.b + " alt:" + this.c + " type:" + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.ExtendFriendLocationInfo
 * JD-Core Version:    0.7.0.1
 */