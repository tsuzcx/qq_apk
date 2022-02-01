package com.tencent.pb.vasreporter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VasReporter$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBStringField osversion = PBField.initString("");
  public final PBInt32Field plat = PBField.initInt32(0);
  public final PBStringField qqversion = PBField.initString("");
  public final PBRepeatMessageField<VasReporter.StatisInfo> statis_list = PBField.initRepeatMessage(VasReporter.StatisInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "cmd", "plat", "qqversion", "osversion", "statis_list" }, new Object[] { localInteger, localInteger, "", "", null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vasreporter.VasReporter.ReqBody
 * JD-Core Version:    0.7.0.1
 */