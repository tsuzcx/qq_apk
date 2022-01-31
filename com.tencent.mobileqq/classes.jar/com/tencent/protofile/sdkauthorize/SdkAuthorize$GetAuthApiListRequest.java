package com.tencent.protofile.sdkauthorize;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SdkAuthorize$GetAuthApiListRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 66, 74, 80, 90 }, new String[] { "client_id", "scope", "pf", "sign", "sdkv", "sdkp", "time", "qqv", "os", "need_pay", "skey" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", Long.valueOf(0L), "", "", Integer.valueOf(0), "" }, GetAuthApiListRequest.class);
  public final PBInt64Field client_id = PBField.initInt64(0L);
  public final PBSInt32Field need_pay = PBField.initSInt32(0);
  public final PBStringField os = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField qqv = PBField.initString("");
  public final PBStringField scope = PBField.initString("");
  public final PBStringField sdkp = PBField.initString("");
  public final PBStringField sdkv = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public final PBInt64Field time = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest
 * JD-Core Version:    0.7.0.1
 */