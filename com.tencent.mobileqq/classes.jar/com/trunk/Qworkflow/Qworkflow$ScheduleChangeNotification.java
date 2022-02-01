package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow$ScheduleChangeNotification
  extends MessageMicro<ScheduleChangeNotification>
{
  public static final int ACCEPT = 7;
  public static final int CREATE = 5;
  public static final int DELETE = 3;
  public static final int EXPIRED = 1;
  public static final int RECALL = 4;
  public static final int SHARE_RECVD = 2;
  public static final int UPDATE = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_change_type = PBField.initEnum(1);
  public final PBEnumField enum_repeated_type = PBField.initEnum(1);
  public Qworkflow.BusinessInfo msg_busi_info = new Qworkflow.BusinessInfo();
  public Qworkflow.Timespan msg_changed_timespan = new Qworkflow.Timespan();
  public Qworkflow.Text msg_summary = new Qworkflow.Text();
  public final PBRepeatMessageField<Qworkflow.Timespan> rpt_msg_repeated_effective_timespan = PBField.initRepeatMessage(Qworkflow.Timespan.class);
  public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_remind_bell_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 24, 32, 40, 50, 58, 64, 72, 80, 90, 98, 104, 112, 122 }, new String[] { "bytes_workflow_id", "uint32_main_type", "uint32_sub_type", "uint64_author_uin", "bytes_title", "msg_summary", "enum_change_type", "uint32_remind_bell_switch", "enum_repeated_type", "msg_changed_timespan", "rpt_msg_repeated_effective_timespan", "uint64_start_time", "uint64_end_time", "msg_busi_info" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, null, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), null, null, Long.valueOf(0L), Long.valueOf(0L), null }, ScheduleChangeNotification.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.ScheduleChangeNotification
 * JD-Core Version:    0.7.0.1
 */