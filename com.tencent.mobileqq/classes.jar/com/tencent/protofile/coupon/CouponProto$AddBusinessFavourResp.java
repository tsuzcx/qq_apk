package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$AddBusinessFavourResp
  extends MessageMicro<AddBusinessFavourResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "retcode", "business", "ts" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, AddBusinessFavourResp.class);
  public CouponProto.Business business = new CouponProto.Business();
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBUInt64Field ts = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.AddBusinessFavourResp
 * JD-Core Version:    0.7.0.1
 */