package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CouponProto$GetBusinessesDetailReq
  extends MessageMicro<GetBusinessesDetailReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bids", "source_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetBusinessesDetailReq.class);
  public final PBRepeatField<Integer> bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.GetBusinessesDetailReq
 * JD-Core Version:    0.7.0.1
 */