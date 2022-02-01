package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class PreloadInfoCheckUpdate$PreloadResult
  extends MessageMicro<PreloadResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field appid = PBField.initInt32(0);
  public final PBStringField ext1 = PBField.initString("");
  public final PBInt32Field mem_limit = PBField.initInt32(0);
  public final PBBoolField preload = PBField.initBool(false);
  public final PBBoolField preload_data = PBField.initBool(false);
  public final PBInt32Field preload_switch = PBField.initInt32(0);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "appid", "preload_switch", "preload", "preload_data", "mem_limit", "ext1" }, new Object[] { localInteger, localInteger, localBoolean, localBoolean, localInteger, "" }, PreloadResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate.PreloadResult
 * JD-Core Version:    0.7.0.1
 */