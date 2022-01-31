package com.tencent.qwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class CodeGenerate$CodeGenerateReq
  extends MessageMicro<CodeGenerateReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 82, 90, 98, 106, 114, 122 }, new String[] { "uin", "cn", "guid", "device_id", "device_type", "device_name", "token_md5", "timestamp", "random", "sign", "h_location", "h_model", "h_edition", "h_qq_appid", "h_qq_guid" }, new Object[] { "", "", "", "", "", "", "", Long.valueOf(0L), "", "", "", "", "", "", "" }, CodeGenerateReq.class);
  public final PBStringField cn = PBField.initString("");
  public final PBStringField device_id = PBField.initString("");
  public final PBStringField device_name = PBField.initString("");
  public final PBStringField device_type = PBField.initString("");
  public final PBStringField guid = PBField.initString("");
  public final PBStringField h_edition = PBField.initString("");
  public final PBStringField h_location = PBField.initString("");
  public final PBStringField h_model = PBField.initString("");
  public final PBStringField h_qq_appid = PBField.initString("");
  public final PBStringField h_qq_guid = PBField.initString("");
  public final PBStringField random = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
  public final PBInt64Field timestamp = PBField.initInt64(0L);
  public final PBStringField token_md5 = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.qwallet.CodeGenerate.CodeGenerateReq
 * JD-Core Version:    0.7.0.1
 */