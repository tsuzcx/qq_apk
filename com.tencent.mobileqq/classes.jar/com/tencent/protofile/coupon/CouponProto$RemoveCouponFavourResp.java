package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$RemoveCouponFavourResp
  extends MessageMicro<RemoveCouponFavourResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "retcode", "ts" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, RemoveCouponFavourResp.class);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBUInt64Field ts = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.RemoveCouponFavourResp
 * JD-Core Version:    0.7.0.1
 */