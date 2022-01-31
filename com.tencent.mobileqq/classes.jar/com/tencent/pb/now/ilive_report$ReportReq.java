package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_report$ReportReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 74, 80, 88 }, new String[] { "reporter_uin", "reporter_tinyid", "reportee_uin", "reportee_tinyid", "room_id", "sub_room_id", "client", "text", "feedid", "type", "sub_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0) }, ReportReq.class);
  public final PBUInt32Field client = PBField.initUInt32(0);
  public final PBStringField feedid = PBField.initString("");
  public final PBUInt64Field reportee_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field reportee_uin = PBField.initUInt64(0L);
  public final PBUInt64Field reporter_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field reporter_uin = PBField.initUInt64(0L);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBUInt64Field sub_room_id = PBField.initUInt64(0L);
  public final PBUInt32Field sub_type = PBField.initUInt32(0);
  public final PBStringField text = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_report.ReportReq
 * JD-Core Version:    0.7.0.1
 */