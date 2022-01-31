package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$ModuleDecrytRequest
  extends MessageMicro<ModuleDecrytRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "versionInfo", "module_id", "module_version" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, ModuleDecrytRequest.class);
  public final PBUInt32Field module_id = PBField.initUInt32(0);
  public final PBUInt32Field module_version = PBField.initUInt32(0);
  public final PBStringField versionInfo = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.ModuleDecrytRequest
 * JD-Core Version:    0.7.0.1
 */