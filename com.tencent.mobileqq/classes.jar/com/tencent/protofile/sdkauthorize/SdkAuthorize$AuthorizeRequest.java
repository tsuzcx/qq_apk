package com.tencent.protofile.sdkauthorize;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SdkAuthorize$AuthorizeRequest
  extends MessageMicro<AuthorizeRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50, 58, 66, 72, 82, 90, 98, 106, 114, 122, 128, 138, 144, 152 }, new String[] { "response_type", "client_id", "openapi", "pf", "need_pay", "sign", "sdkv", "sdkp", "time", "qqv", "os", "passData", "skey", "vkey", "sid", "app_type", "appUniqueIdentifier", "referer", "vID" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", Long.valueOf(0L), "", "", "", "", "", "", Integer.valueOf(0), "", Integer.valueOf(1), Long.valueOf(0L) }, AuthorizeRequest.class);
  public final PBStringField appUniqueIdentifier = PBField.initString("");
  public final PBEnumField app_type = PBField.initEnum(0);
  public final PBInt64Field client_id = PBField.initInt64(0L);
  public final PBSInt32Field need_pay = PBField.initSInt32(0);
  public final PBRepeatField<Integer> openapi = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField os = PBField.initString("");
  public final PBStringField passData = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField qqv = PBField.initString("");
  public final PBEnumField referer = PBField.initEnum(1);
  public final PBStringField response_type = PBField.initString("");
  public final PBStringField sdkp = PBField.initString("");
  public final PBStringField sdkv = PBField.initString("");
  public final PBStringField sid = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public final PBInt64Field time = PBField.initInt64(0L);
  public final PBUInt64Field vID = PBField.initUInt64(0L);
  public final PBStringField vkey = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest
 * JD-Core Version:    0.7.0.1
 */