package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class publicaccount_recommend$BusinessRecommendResponse
  extends MessageMicro
{
  public static final int BUSINESS_FIELD_NUMBER = 4;
  public static final int CURRENT_BUSINESS_COUNT_FIELD_NUMBER = 3;
  public static final int RET_INFO_FIELD_NUMBER = 1;
  public static final int TOTLE_BUSINESS_COUNT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "ret_info", "totle_business_count", "current_business_count", "business" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null }, BusinessRecommendResponse.class);
  public final PBRepeatMessageField business = PBField.initRepeatMessage(publicaccount_recommend.BusinessRecommend.class);
  public final PBUInt32Field current_business_count = PBField.initUInt32(0);
  public publicaccount_recommend.RetInfo ret_info = new publicaccount_recommend.RetInfo();
  public final PBUInt32Field totle_business_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.mp.publicaccount_recommend.BusinessRecommendResponse
 * JD-Core Version:    0.7.0.1
 */