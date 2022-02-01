package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.trunk.Qworkflow.Qworkflow.WorkflowState;

public final class oidb_0x4d4$ApproverChangeInState
  extends MessageMicro<ApproverChangeInState>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_workflow_state", "rpt_msg_approver_change_list" }, new Object[] { null, null }, ApproverChangeInState.class);
  public Qworkflow.WorkflowState msg_workflow_state = new Qworkflow.WorkflowState();
  public final PBRepeatMessageField<oidb_0x4d4.ApproverChange> rpt_msg_approver_change_list = PBField.initRepeatMessage(oidb_0x4d4.ApproverChange.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.ApproverChangeInState
 * JD-Core Version:    0.7.0.1
 */