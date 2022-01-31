package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ConfigurationService$ReportConfig
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "type", "task_id", "version", "report_type", "result", "real_size", "total_size", "err_msgs" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, ReportConfig.class);
  public final PBRepeatField err_msgs = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field real_size = PBField.initUInt32(0);
  public final PBUInt32Field report_type = PBField.initUInt32(0);
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBUInt32Field task_id = PBField.initUInt32(0);
  public final PBUInt32Field total_size = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReportConfig
 * JD-Core Version:    0.7.0.1
 */