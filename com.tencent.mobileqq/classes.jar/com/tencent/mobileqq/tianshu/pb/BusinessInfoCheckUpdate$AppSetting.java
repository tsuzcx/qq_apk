package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$AppSetting
  extends MessageMicro<AppSetting>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "appid", "setting", "modify_ts" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L) }, AppSetting.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt64Field modify_ts = PBField.initUInt64(0L);
  public final PBBoolField setting = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting
 * JD-Core Version:    0.7.0.1
 */