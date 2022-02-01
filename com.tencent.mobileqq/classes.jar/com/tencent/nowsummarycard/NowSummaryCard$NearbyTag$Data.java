package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowSummaryCard$NearbyTag$Data
  extends MessageMicro<Data>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<NowSummaryCard.NearbyTag.Detail> detail = PBField.initRepeatMessage(NowSummaryCard.NearbyTag.Detail.class);
  public final PBStringField id = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field sort_id = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "id", "name", "type", "detail", "sort_id" }, new Object[] { "", "", localInteger, null, localInteger }, Data.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.NearbyTag.Data
 * JD-Core Version:    0.7.0.1
 */