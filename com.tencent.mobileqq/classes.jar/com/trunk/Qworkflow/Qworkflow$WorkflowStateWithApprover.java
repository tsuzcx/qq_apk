package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Qworkflow$WorkflowStateWithApprover
  extends MessageMicro<WorkflowStateWithApprover>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_workflow_state", "rpt_msg_approver_list" }, new Object[] { null, null }, WorkflowStateWithApprover.class);
  public Qworkflow.WorkflowState msg_workflow_state = new Qworkflow.WorkflowState();
  public final PBRepeatMessageField<Qworkflow.Approver> rpt_msg_approver_list = PBField.initRepeatMessage(Qworkflow.Approver.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.WorkflowStateWithApprover
 * JD-Core Version:    0.7.0.1
 */