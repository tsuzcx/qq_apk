package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$Business
  extends MessageMicro<Business>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 90, 96, 106, 112, 120, 128, 136 }, new String[] { "bid", "name", "detail", "type", "city", "tag", "contact", "tel", "logo", "mt", "cname", "update_count", "qlife_url", "source_id", "add2favour_time", "shids", "last_add_time" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", "", "", Long.valueOf(0L), "", Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, Business.class);
  public final PBUInt64Field add2favour_time = PBField.initUInt64(0L);
  public final PBUInt32Field bid = PBField.initUInt32(0);
  public final PBStringField city = PBField.initString("");
  public final PBStringField cname = PBField.initString("");
  public final PBStringField contact = PBField.initString("");
  public final PBStringField detail = PBField.initString("");
  public final PBUInt64Field last_add_time = PBField.initUInt64(0L);
  public final PBStringField logo = PBField.initString("");
  public final PBUInt64Field mt = PBField.initUInt64(0L);
  public final PBStringField name = PBField.initString("");
  public final PBStringField qlife_url = PBField.initString("");
  public final PBRepeatField<Integer> shids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field source_id = PBField.initUInt32(0);
  public final PBStringField tag = PBField.initString("");
  public final PBStringField tel = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field update_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.Business
 * JD-Core Version:    0.7.0.1
 */