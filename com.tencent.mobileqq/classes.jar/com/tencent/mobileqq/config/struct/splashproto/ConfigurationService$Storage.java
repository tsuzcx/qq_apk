package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ConfigurationService$Storage
  extends MessageMicro<Storage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "builtin", "external" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, Storage.class);
  public final PBUInt64Field builtin = PBField.initUInt64(0L);
  public final PBUInt64Field external = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Storage
 * JD-Core Version:    0.7.0.1
 */