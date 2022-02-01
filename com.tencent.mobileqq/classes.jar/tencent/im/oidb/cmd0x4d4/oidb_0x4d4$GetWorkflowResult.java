package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.trunk.Qworkflow.Qworkflow.Workflow;

public final class oidb_0x4d4$GetWorkflowResult
  extends MessageMicro<GetWorkflowResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "msg_workflow_source", "msg_workflow" }, new Object[] { Integer.valueOf(0), null, null }, GetWorkflowResult.class);
  public Qworkflow.Workflow msg_workflow = new Qworkflow.Workflow();
  public oidb_0x4d4.WorkflowSource msg_workflow_source = new oidb_0x4d4.WorkflowSource();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.GetWorkflowResult
 * JD-Core Version:    0.7.0.1
 */