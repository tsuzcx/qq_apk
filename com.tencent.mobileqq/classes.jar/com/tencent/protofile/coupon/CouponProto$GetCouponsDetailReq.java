package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CouponProto$GetCouponsDetailReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "bids", "cids", "source_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetCouponsDetailReq.class);
  public final PBRepeatField bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField cids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.GetCouponsDetailReq
 * JD-Core Version:    0.7.0.1
 */