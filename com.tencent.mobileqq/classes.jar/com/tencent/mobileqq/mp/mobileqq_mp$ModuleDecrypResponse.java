package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$ModuleDecrypResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "ret_info", "module_id", "module_version", "decrypt", "pwd" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), "" }, ModuleDecrypResponse.class);
  public final PBBoolField decrypt = PBField.initBool(false);
  public final PBUInt32Field module_id = PBField.initUInt32(0);
  public final PBUInt32Field module_version = PBField.initUInt32(0);
  public final PBStringField pwd = PBField.initString("");
  public mobileqq_mp.RetInfo ret_info = new mobileqq_mp.RetInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.ModuleDecrypResponse
 * JD-Core Version:    0.7.0.1
 */