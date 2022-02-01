package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.trunk.Qworkflow.Qworkflow.Workflow;

public final class oidb_0x4d4$AddWorkflowReq
  extends MessageMicro<AddWorkflowReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_workflow" }, new Object[] { null }, AddWorkflowReq.class);
  public Qworkflow.Workflow msg_workflow = new Qworkflow.Workflow();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.AddWorkflowReq
 * JD-Core Version:    0.7.0.1
 */