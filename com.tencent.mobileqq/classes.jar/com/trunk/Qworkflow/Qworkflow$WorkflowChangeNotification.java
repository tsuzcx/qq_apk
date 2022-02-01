package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow$WorkflowChangeNotification
  extends MessageMicro<WorkflowChangeNotification>
{
  public static final int DENY_END = 3;
  public static final int HASTEN_RECVED = 4;
  public static final int NEED_APPROVE = 7;
  public static final int NEED_OBSERVE = 8;
  public static final int PERMIT_END = 2;
  public static final int READED = 6;
  public static final int RECALLED = 1;
  public static final int SHARE_RECVD = 5;
  public static final int UPDATED = 9;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_change_type = PBField.initEnum(1);
  public Qworkflow.WorkflowState msg_current_state = new Qworkflow.WorkflowState();
  public Qworkflow.Text msg_summary = new Qworkflow.Text();
  public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 24, 32, 40, 50, 58, 64, 74, 80 }, new String[] { "bytes_workflow_id", "uint32_main_type", "uint32_sub_type", "uint64_author_uin", "bytes_title", "msg_summary", "enum_change_type", "msg_current_state", "uint32_data_version" }, new Object[] { localByteStringMicro1, localInteger, localInteger, Long.valueOf(0L), localByteStringMicro2, null, Integer.valueOf(1), null, localInteger }, WorkflowChangeNotification.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.WorkflowChangeNotification
 * JD-Core Version:    0.7.0.1
 */