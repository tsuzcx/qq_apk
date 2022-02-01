package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow.WorkflowBrief;

public final class oidb_0x4d4$GetWorkflowListReq
  extends MessageMicro<GetWorkflowListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint64_end_time", "rpt_msg_workflow_list", "uint32_amount", "msg_filter", "msg_order" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), null, null }, GetWorkflowListReq.class);
  public oidb_0x4d4.WorkflowFilter msg_filter = new oidb_0x4d4.WorkflowFilter();
  public oidb_0x4d4.WorkflowOrder msg_order = new oidb_0x4d4.WorkflowOrder();
  public final PBRepeatMessageField<Qworkflow.WorkflowBrief> rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow.WorkflowBrief.class);
  public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.GetWorkflowListReq
 * JD-Core Version:    0.7.0.1
 */