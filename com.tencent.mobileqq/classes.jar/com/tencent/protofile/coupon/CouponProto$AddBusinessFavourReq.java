package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CouponProto$AddBusinessFavourReq
  extends MessageMicro<AddBusinessFavourReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field bid = PBField.initUInt32(0);
  public final PBUInt32Field source_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bid", "source_id" }, new Object[] { localInteger, localInteger }, AddBusinessFavourReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.AddBusinessFavourReq
 * JD-Core Version:    0.7.0.1
 */