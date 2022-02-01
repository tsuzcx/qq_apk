package com.tencent.mobileqq.kandian.biz.fastweb.event;

import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class ListAdExposeData
  implements Comparable<ListAdExposeData>
{
  public float a;
  public int a;
  public long a;
  public AdvertisementInfo a;
  public long b = 0L;
  
  public ListAdExposeData()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
  }
  
  public int a(ListAdExposeData paramListAdExposeData)
  {
    int i = this.jdField_a_of_type_Int;
    int j = paramListAdExposeData.jdField_a_of_type_Int;
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
      AdvertisementInfo localAdvertisementInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      bool1 = bool2;
      if (localAdvertisementInfo1 != null)
      {
        paramObject = (ListAdExposeData)paramObject;
        AdvertisementInfo localAdvertisementInfo2 = paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
        if (localAdvertisementInfo2 == null) {
          return false;
        }
        bool1 = bool2;
        if (localAdvertisementInfo1 == localAdvertisementInfo2)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    int i;
    if (localAdvertisementInfo != null) {
      i = 527 + localAdvertisementInfo.hashCode();
    } else {
      i = 17;
    }
    return i * 31 + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.ListAdExposeData
 * JD-Core Version:    0.7.0.1
 */