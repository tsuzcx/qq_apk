package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto$Shop
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 112, 120, 130, 138, 144 }, new String[] { "shid", "bid", "name", "addr", "detail", "city", "region", "area", "tag", "contact", "tel", "maplng", "maplat", "mt", "couponids", "cname", "qlife_url", "source_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0) }, Shop.class);
  public final PBStringField addr = PBField.initString("");
  public final PBStringField area = PBField.initString("");
  public final PBUInt32Field bid = PBField.initUInt32(0);
  public final PBStringField city = PBField.initString("");
  public final PBStringField cname = PBField.initString("");
  public final PBStringField contact = PBField.initString("");
  public final PBRepeatField couponids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField detail = PBField.initString("");
  public final PBUInt32Field maplat = PBField.initUInt32(0);
  public final PBUInt32Field maplng = PBField.initUInt32(0);
  public final PBUInt64Field mt = PBField.initUInt64(0L);
  public final PBStringField name = PBField.initString("");
  public final PBStringField qlife_url = PBField.initString("");
  public final PBStringField region = PBField.initString("");
  public final PBUInt32Field shid = PBField.initUInt32(0);
  public final PBUInt32Field source_id = PBField.initUInt32(0);
  public final PBStringField tag = PBField.initString("");
  public final PBStringField tel = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto.Shop
 * JD-Core Version:    0.7.0.1
 */