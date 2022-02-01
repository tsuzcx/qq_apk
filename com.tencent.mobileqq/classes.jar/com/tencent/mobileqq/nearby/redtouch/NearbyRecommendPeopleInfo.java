package com.tencent.mobileqq.nearby.redtouch;

import java.util.List;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyPeople;

public class NearbyRecommendPeopleInfo
{
  public static List<oidb_0x8dd.NearbyPeople> a;
  public static String b = "0";
  
  public static List<oidb_0x8dd.NearbyPeople> a()
  {
    return a;
  }
  
  public static void a(String paramString, List<oidb_0x8dd.NearbyPeople> paramList)
  {
    a = paramList;
    b = paramString;
  }
  
  public static String b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.NearbyRecommendPeopleInfo
 * JD-Core Version:    0.7.0.1
 */