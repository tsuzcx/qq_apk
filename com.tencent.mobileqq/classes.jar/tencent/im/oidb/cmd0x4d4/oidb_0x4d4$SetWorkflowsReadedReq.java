package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.trunk.Qworkflow.Qworkflow.WorkflowBrief;

public final class oidb_0x4d4$SetWorkflowsReadedReq
  extends MessageMicro<SetWorkflowsReadedReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_workflow_list" }, new Object[] { null }, SetWorkflowsReadedReq.class);
  public final PBRepeatMessageField<Qworkflow.WorkflowBrief> rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow.WorkflowBrief.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.SetWorkflowsReadedReq
 * JD-Core Version:    0.7.0.1
 */