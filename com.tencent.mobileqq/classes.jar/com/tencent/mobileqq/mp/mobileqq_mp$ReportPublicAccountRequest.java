package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$ReportPublicAccountRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 74, 82, 90, 98 }, new String[] { "tag", "mainAction", "toUin", "subAction", "actionName", "fromType", "count", "result", "r2", "r3", "r4", "r5" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "" }, ReportPublicAccountRequest.class);
  public final PBStringField actionName = PBField.initString("");
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBUInt32Field fromType = PBField.initUInt32(0);
  public final PBStringField mainAction = PBField.initString("");
  public final PBStringField r2 = PBField.initString("");
  public final PBStringField r3 = PBField.initString("");
  public final PBStringField r4 = PBField.initString("");
  public final PBRepeatField r5 = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBStringField subAction = PBField.initString("");
  public final PBStringField tag = PBField.initString("");
  public final PBStringField toUin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.ReportPublicAccountRequest
 * JD-Core Version:    0.7.0.1
 */