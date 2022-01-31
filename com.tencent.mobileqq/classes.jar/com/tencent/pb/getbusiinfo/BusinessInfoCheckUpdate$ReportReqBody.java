package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$ReportReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 66, 72, 80, 88 }, new String[] { "uin", "platid", "clientver", "platver", "appid", "missionid", "buffer", "reportdata", "msgids", "cmd", "bHebaFlag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", null, Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false) }, ReportReqBody.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBBoolField bHebaFlag = PBField.initBool(false);
  public final PBStringField buffer = PBField.initString("");
  public final PBStringField clientver = PBField.initString("");
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBRepeatField missionid = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField msgids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field platid = PBField.initUInt32(0);
  public final PBStringField platver = PBField.initString("");
  public final PBRepeatMessageField reportdata = PBField.initRepeatMessage(BusinessInfoCheckUpdate.ReportStaticsData.class);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody
 * JD-Core Version:    0.7.0.1
 */