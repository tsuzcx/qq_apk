package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ConfigurationService$ConfigSeq
  extends MessageMicro<ConfigSeq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field compress = PBField.initInt32(0);
  public ConfigurationService.TabRule tab_rule = new ConfigurationService.TabRule();
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBInt32Field version = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "type", "version", "compress", "tab_rule" }, new Object[] { localInteger, localInteger, localInteger, null }, ConfigSeq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq
 * JD-Core Version:    0.7.0.1
 */