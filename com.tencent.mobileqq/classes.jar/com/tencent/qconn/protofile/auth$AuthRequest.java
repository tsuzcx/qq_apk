package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class auth$AuthRequest
  extends MessageMicro<AuthRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 90, 98, 120, 130, 152, 160, 168, 176, 242, 248, 320, 330, 338, 402, 482, 522 }, new String[] { "response_type", "appid", "openapi", "pf", "sdkp", "sdkv", "qqv", "os", "skey", "pass_data", "md5time", "sign", "vid", "app_type", "need_paytoken", "channel_source", "app_unique_identifier", "referer", "need_universal_link", "bundleid_from_app", "universal_link_from_app", "proxy_auth_req", "state", "login_sig" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", "", "", "", "", "", Long.valueOf(0L), "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(1), Boolean.valueOf(false), "", "", null, "", null }, AuthRequest.class);
  public final PBEnumField app_type = PBField.initEnum(0);
  public final PBStringField app_unique_identifier = PBField.initString("");
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBStringField bundleid_from_app = PBField.initString("");
  public final PBInt64Field channel_source = PBField.initInt64(0L);
  public appType.LoginSig login_sig = new appType.LoginSig();
  public final PBInt64Field md5time = PBField.initInt64(0L);
  public final PBSInt32Field need_paytoken = PBField.initSInt32(0);
  public final PBBoolField need_universal_link = PBField.initBool(false);
  public final PBRepeatField<Integer> openapi = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField os = PBField.initString("");
  public final PBStringField pass_data = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public auth.ProxyAuthRequest proxy_auth_req = new auth.ProxyAuthRequest();
  public final PBStringField qqv = PBField.initString("");
  public final PBEnumField referer = PBField.initEnum(1);
  public final PBEnumField response_type = PBField.initEnum(0);
  public final PBStringField sdkp = PBField.initString("");
  public final PBStringField sdkv = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public final PBStringField state = PBField.initString("");
  public final PBStringField universal_link_from_app = PBField.initString("");
  public final PBUInt64Field vid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qconn.protofile.auth.AuthRequest
 * JD-Core Version:    0.7.0.1
 */