package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow$ScheduleChangeNotification
  extends MessageMicro
{
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
  public Qworkflow.Text msg_summary = new Qworkflow.Text();
  public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_remind_bell_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 24, 32, 40, 50, 58, 64, 72 }, new String[] { "bytes_workflow_id", "uint32_main_type", "uint32_sub_type", "uint64_author_uin", "bytes_title", "msg_summary", "enum_change_type", "uint32_remind_bell_switch" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, null, Integer.valueOf(1), Integer.valueOf(0) }, ScheduleChangeNotification.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.ScheduleChangeNotification
 * JD-Core Version:    0.7.0.1
 */