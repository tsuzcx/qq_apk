package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ConfigurationService$ReqGetConfigByPage
  extends MessageMicro<ReqGetConfigByPage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "type", "page_info", "device_info", "adcode", "stagger_version" }, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(0L), Integer.valueOf(0) }, ReqGetConfigByPage.class);
  public final PBUInt64Field adcode = PBField.initUInt64(0L);
  public ConfigurationService.DeviceInfo device_info = new ConfigurationService.DeviceInfo();
  public ConfigurationService.PageReqInfo page_info = new ConfigurationService.PageReqInfo();
  public final PBUInt32Field stagger_version = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfigByPage
 * JD-Core Version:    0.7.0.1
 */