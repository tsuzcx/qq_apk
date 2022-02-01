package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowSummaryCard$NearbyMiniCardReq
  extends MessageMicro<NearbyMiniCardReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "target_id", "id_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, NearbyMiniCardReq.class);
  public final PBUInt32Field id_type = PBField.initUInt32(0);
  public final PBRepeatField<Long> target_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.NearbyMiniCardReq
 * JD-Core Version:    0.7.0.1
 */