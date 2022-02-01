package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowSummaryCard$NearbyTag$Detail
  extends MessageMicro<Detail>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField checked = PBField.initBool(false);
  public final PBRepeatMessageField<NowSummaryCard.NearbyTag.ChildDetail> child_detail = PBField.initRepeatMessage(NowSummaryCard.NearbyTag.ChildDetail.class);
  public final PBBoolField hide = PBField.initBool(false);
  public final PBStringField id = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field sort_id = PBField.initUInt32(0);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48 }, new String[] { "id", "name", "checked", "child_detail", "sort_id", "hide" }, new Object[] { "", "", localBoolean, null, Integer.valueOf(0), localBoolean }, Detail.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.NearbyTag.Detail
 * JD-Core Version:    0.7.0.1
 */