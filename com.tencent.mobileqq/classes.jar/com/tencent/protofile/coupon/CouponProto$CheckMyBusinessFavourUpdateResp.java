package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$CheckMyBusinessFavourUpdateResp
  extends MessageMicro<CheckMyBusinessFavourUpdateResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBRepeatField<Integer> source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Long> ts_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "retcode", "bids", "source_ids", "ts_list" }, new Object[] { localInteger, localInteger, localInteger, Long.valueOf(0L) }, CheckMyBusinessFavourUpdateResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.CheckMyBusinessFavourUpdateResp
 * JD-Core Version:    0.7.0.1
 */