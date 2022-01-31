package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow$Workflow
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public Qworkflow.WorkflowState msg_current_state = new Qworkflow.WorkflowState();
  public Qworkflow.Text msg_online_push_content = new Qworkflow.Text();
  public Qworkflow.RemindTimer msg_remind_timer = new Qworkflow.RemindTimer();
  public Qworkflow.TodoInfo msg_todo_info = new Qworkflow.TodoInfo();
  public Qworkflow.WorkflowContent msg_workflow_content = new Qworkflow.WorkflowContent();
  public Qworkflow.WorkflowExtendState msg_workflow_extend_state = new Qworkflow.WorkflowExtendState();
  public Qworkflow.AppID related_source_id = new Qworkflow.AppID();
  public final PBRepeatMessageField rpt_msg_observers = PBField.initRepeatMessage(Qworkflow.Observer.class);
  public final PBRepeatMessageField rpt_msg_workflow_state_with_approver = PBField.initRepeatMessage(Qworkflow.WorkflowStateWithApprover.class);
  public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_remind_bell_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_modify_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_recv_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 66, 74, 82, 90, 96, 106, 112, 122, 130, 138, 144 }, new String[] { "bytes_workflow_id", "uint64_author_uin", "uint32_main_type", "uint32_sub_type", "uint64_create_time", "uint64_last_modify_time", "msg_current_state", "msg_workflow_content", "rpt_msg_workflow_state_with_approver", "rpt_msg_observers", "msg_workflow_extend_state", "uint32_data_version", "msg_remind_timer", "uint64_recv_time", "msg_online_push_content", "msg_todo_info", "related_source_id", "uint32_remind_bell_switch" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, null, Integer.valueOf(0), null, Long.valueOf(0L), null, null, null, Integer.valueOf(0) }, Workflow.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.Workflow
 * JD-Core Version:    0.7.0.1
 */