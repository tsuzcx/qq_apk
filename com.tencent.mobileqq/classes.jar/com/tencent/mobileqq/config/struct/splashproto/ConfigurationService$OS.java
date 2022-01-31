package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ConfigurationService$OS
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "type", "version", "sdk", "kernel", "rom" }, new Object[] { Integer.valueOf(1), "", "", "", "" }, OS.class);
  public final PBStringField kernel = PBField.initString("");
  public final PBStringField rom = PBField.initString("");
  public final PBStringField sdk = PBField.initString("");
  public final PBEnumField type = PBField.initEnum(1);
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.OS
 * JD-Core Version:    0.7.0.1
 */