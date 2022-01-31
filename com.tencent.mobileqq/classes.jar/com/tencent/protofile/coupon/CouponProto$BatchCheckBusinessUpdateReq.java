package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CouponProto$BatchCheckBusinessUpdateReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bids", "source_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BatchCheckBusinessUpdateReq.class);
  public final PBRepeatField bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.BatchCheckBusinessUpdateReq
 * JD-Core Version:    0.7.0.1
 */