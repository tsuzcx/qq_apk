package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CouponProto$AddCouponFavourReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "bid", "cid", "source_id", "city" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, AddCouponFavourReq.class);
  public final PBUInt32Field bid = PBField.initUInt32(0);
  public final PBUInt32Field cid = PBField.initUInt32(0);
  public final PBStringField city = PBField.initString("");
  public final PBUInt32Field source_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.AddCouponFavourReq
 * JD-Core Version:    0.7.0.1
 */