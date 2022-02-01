package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CouponProto$GetCouponsDetailReq
  extends MessageMicro<GetCouponsDetailReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> cids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "bids", "cids", "source_ids" }, new Object[] { localInteger, localInteger, localInteger }, GetCouponsDetailReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.GetCouponsDetailReq
 * JD-Core Version:    0.7.0.1
 */