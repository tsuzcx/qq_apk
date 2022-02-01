package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class preAuth$PreAuthRequest
  extends MessageMicro<PreAuthRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 82, 90, 96, 106, 160, 168, 178, 184, 402, 522 }, new String[] { "appid", "sdkp", "sdkv", "icons", "qqv", "os", "scope", "skey", "md5time", "sign", "app_type", "channel_source", "appUniqueIdentifier", "referer", "proxy_req", "login_sig" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", "", "", Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(1), null, null }, PreAuthRequest.class);
  public final PBStringField appUniqueIdentifier = PBField.initString("");
  public final PBEnumField app_type = PBField.initEnum(0);
  public final PBInt64Field appid = PBField.initInt64(0L);
  public final PBInt64Field channel_source = PBField.initInt64(0L);
  public final PBRepeatField<String> icons = PBField.initRepeat(PBStringField.__repeatHelper__);
  public appType.LoginSig login_sig = new appType.LoginSig();
  public final PBInt64Field md5time = PBField.initInt64(0L);
  public final PBStringField os = PBField.initString("");
  public preAuth.PreAuthProxyRequest proxy_req = new preAuth.PreAuthProxyRequest();
  public final PBStringField qqv = PBField.initString("");
  public final PBEnumField referer = PBField.initEnum(1);
  public final PBStringField scope = PBField.initString("");
  public final PBStringField sdkp = PBField.initString("");
  public final PBStringField sdkv = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qconn.protofile.preAuth.PreAuthRequest
 * JD-Core Version:    0.7.0.1
 */