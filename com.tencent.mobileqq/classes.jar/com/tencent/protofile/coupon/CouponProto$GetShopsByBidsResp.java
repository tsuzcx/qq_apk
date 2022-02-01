package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CouponProto$GetShopsByBidsResp
  extends MessageMicro<GetShopsByBidsResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "shops" }, new Object[] { Integer.valueOf(0), null }, GetShopsByBidsResp.class);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBRepeatMessageField<CouponProto.Shop> shops = PBField.initRepeatMessage(CouponProto.Shop.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.GetShopsByBidsResp
 * JD-Core Version:    0.7.0.1
 */