package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow$WorkflowBrief
  extends MessageMicro<WorkflowBrief>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public Qworkflow.WorkflowExtendState msg_extend_state = new Qworkflow.WorkflowExtendState();
  public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
  public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_modify_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_recv_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 56 }, new String[] { "bytes_workflow_id", "uint64_author_uin", "uint64_last_modify_time", "uint64_create_time", "msg_extend_state", "uint32_data_version", "uint64_recv_time" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), Long.valueOf(0L) }, WorkflowBrief.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.WorkflowBrief
 * JD-Core Version:    0.7.0.1
 */