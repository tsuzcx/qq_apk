package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ConfigurationService$Memory
  extends MessageMicro<Memory>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field process = PBField.initUInt64(0L);
  public final PBUInt64Field total = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "total", "process" }, new Object[] { localLong, localLong }, Memory.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Memory
 * JD-Core Version:    0.7.0.1
 */