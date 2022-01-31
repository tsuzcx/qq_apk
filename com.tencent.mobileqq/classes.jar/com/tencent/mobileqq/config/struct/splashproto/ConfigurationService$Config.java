package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ConfigurationService$Config
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "type", "version", "content_list", "msg_content_list", "msg_rich_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null, null }, Config.class);
  public final PBRepeatField content_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatMessageField msg_content_list = PBField.initRepeatMessage(ConfigurationService.Content.class);
  public ConfigurationService.RichInfo msg_rich_info = new ConfigurationService.RichInfo();
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBInt32Field version = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config
 * JD-Core Version:    0.7.0.1
 */