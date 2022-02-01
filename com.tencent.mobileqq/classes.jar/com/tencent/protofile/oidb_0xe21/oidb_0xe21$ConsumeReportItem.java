package com.tencent.protofile.oidb_0xe21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe21$ConsumeReportItem
  extends MessageMicro<ConsumeReportItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 34, 40, 48, 56, 66, 72 }, new String[] { "current_progress", "total_progress", "rowkey", "current_rowkey_progress", "need_record", "next_request_time", "rpt_tips_items", "current_rowkey_incr_progress" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0) }, ConsumeReportItem.class);
  public final PBUInt32Field current_progress = PBField.initUInt32(0);
  public final PBUInt32Field current_rowkey_incr_progress = PBField.initUInt32(0);
  public final PBUInt32Field current_rowkey_progress = PBField.initUInt32(0);
  public final PBUInt32Field need_record = PBField.initUInt32(0);
  public final PBUInt64Field next_request_time = PBField.initUInt64(0L);
  public final PBStringField rowkey = PBField.initString("");
  public final PBRepeatMessageField<oidb_0xe21.TipsItem> rpt_tips_items = PBField.initRepeatMessage(oidb_0xe21.TipsItem.class);
  public final PBUInt32Field total_progress = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protofile.oidb_0xe21.oidb_0xe21.ConsumeReportItem
 * JD-Core Version:    0.7.0.1
 */