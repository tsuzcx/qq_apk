package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowSummaryCard$NearbyTag$ChildDetail
  extends MessageMicro<ChildDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "id", "name", "checked", "sort_id" }, new Object[] { "", "", Boolean.valueOf(false), Integer.valueOf(0) }, ChildDetail.class);
  public final PBBoolField checked = PBField.initBool(false);
  public final PBStringField id = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field sort_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.NearbyTag.ChildDetail
 * JD-Core Version:    0.7.0.1
 */