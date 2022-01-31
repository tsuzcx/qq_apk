package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ConfigurationService$ReqGetConfigByPage
  extends MessageMicro<ReqGetConfigByPage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "type", "page_info", "device_info" }, new Object[] { Integer.valueOf(0), null, null }, ReqGetConfigByPage.class);
  public ConfigurationService.DeviceInfo device_info = new ConfigurationService.DeviceInfo();
  public ConfigurationService.PageReqInfo page_info = new ConfigurationService.PageReqInfo();
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfigByPage
 * JD-Core Version:    0.7.0.1
 */