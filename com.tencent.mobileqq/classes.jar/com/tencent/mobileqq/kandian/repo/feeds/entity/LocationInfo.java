package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;

public class LocationInfo
  implements Cloneable
{
  public String a;
  public int b;
  public int c;
  public String d;
  
  public static LocationInfo a(feeds_info.LocationInfo paramLocationInfo)
  {
    LocationInfo localLocationInfo = new LocationInfo();
    boolean bool = paramLocationInfo.bytes_name.has();
    String str2 = "";
    if (bool) {
      str1 = paramLocationInfo.bytes_name.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localLocationInfo.a = str1;
    localLocationInfo.b = paramLocationInfo.uint32_longitude.get();
    localLocationInfo.c = paramLocationInfo.uint32_latitude.get();
    String str1 = str2;
    if (paramLocationInfo.bytes_icon_url.has()) {
      str1 = paramLocationInfo.bytes_icon_url.get().toStringUtf8();
    }
    localLocationInfo.d = str1;
    return localLocationInfo;
  }
  
  public LocationInfo a()
  {
    try
    {
      LocationInfo localLocationInfo = (LocationInfo)super.clone();
      return localLocationInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label10:
      break label10;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.LocationInfo
 * JD-Core Version:    0.7.0.1
 */