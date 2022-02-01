package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowSummaryCard$NearbyUserFollowReq
  extends MessageMicro<NearbyUserFollowReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field from = PBField.initUInt32(0);
  public final PBUInt32Field id_type = PBField.initUInt32(0);
  public final PBUInt32Field operation = PBField.initUInt32(0);
  public final PBUInt64Field target_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "target_id", "id_type", "operation", "from" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger }, NearbyUserFollowReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowReq
 * JD-Core Version:    0.7.0.1
 */