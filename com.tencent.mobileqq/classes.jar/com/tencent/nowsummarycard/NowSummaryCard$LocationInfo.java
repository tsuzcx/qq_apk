package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class NowSummaryCard$LocationInfo
  extends MessageMicro<LocationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "longitude", "latitude" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, LocationInfo.class);
  public final PBInt64Field latitude = PBField.initInt64(0L);
  public final PBInt64Field longitude = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.LocationInfo
 * JD-Core Version:    0.7.0.1
 */