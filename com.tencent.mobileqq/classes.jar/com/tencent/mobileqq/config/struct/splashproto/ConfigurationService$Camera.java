package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ConfigurationService$Camera
  extends MessageMicro<Camera>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField flash = PBField.initBool(false);
  public final PBUInt64Field primary = PBField.initUInt64(0L);
  public final PBUInt64Field secondary = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "primary", "secondary", "flash" }, new Object[] { localLong, localLong, Boolean.valueOf(false) }, Camera.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Camera
 * JD-Core Version:    0.7.0.1
 */