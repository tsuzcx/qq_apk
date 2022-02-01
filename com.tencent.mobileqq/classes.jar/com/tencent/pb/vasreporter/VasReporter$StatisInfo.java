package com.tencent.pb.vasreporter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class VasReporter$StatisInfo
  extends MessageMicro<StatisInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 29, 32, 42 }, new String[] { "appid", "key_list", "value_list", "ts", "msg" }, new Object[] { "", "", Float.valueOf(0.0F), Long.valueOf(0L), "" }, StatisInfo.class);
  public final PBStringField appid = PBField.initString("");
  public final PBRepeatField<String> key_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField msg = PBField.initString("");
  public final PBInt64Field ts = PBField.initInt64(0L);
  public final PBRepeatField<Float> value_list = PBField.initRepeat(PBFloatField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vasreporter.VasReporter.StatisInfo
 * JD-Core Version:    0.7.0.1
 */