package com.tencent.mobileqq.kandian.biz.fastweb.event;

import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class ListAdExposeData
  implements Comparable<ListAdExposeData>
{
  public int a = 0;
  public long b = 0L;
  public long c = 0L;
  public float d = 0.0F;
  public boolean e = false;
  public AdvertisementInfo f = null;
  
  public int a(ListAdExposeData paramListAdExposeData)
  {
    int i = this.a;
    int j = paramListAdExposeData.a;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool3 = paramObject instanceof ListAdExposeData;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      AdvertisementInfo localAdvertisementInfo1 = this.f;
      bool1 = bool2;
      if (localAdvertisementInfo1 != null)
      {
        paramObject = (ListAdExposeData)paramObject;
        AdvertisementInfo localAdvertisementInfo2 = paramObject.f;
        if (localAdvertisementInfo2 == null) {
          return false;
        }
        bool1 = bool2;
        if (localAdvertisementInfo1 == localAdvertisementInfo2)
        {
          bool1 = bool2;
          if (this.a == paramObject.a) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    AdvertisementInfo localAdvertisementInfo = this.f;
    int i;
    if (localAdvertisementInfo != null) {
      i = 527 + localAdvertisementInfo.hashCode();
    } else {
      i = 17;
    }
    return i * 31 + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.ListAdExposeData
 * JD-Core Version:    0.7.0.1
 */