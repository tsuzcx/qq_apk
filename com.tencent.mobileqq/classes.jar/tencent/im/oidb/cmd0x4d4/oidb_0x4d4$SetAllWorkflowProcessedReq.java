package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow.ApproverState;

public final class oidb_0x4d4$SetAllWorkflowProcessedReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_end_time", "msg_approver_state" }, new Object[] { Long.valueOf(0L), null }, SetAllWorkflowProcessedReq.class);
  public Qworkflow.ApproverState msg_approver_state = new Qworkflow.ApproverState();
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.SetAllWorkflowProcessedReq
 * JD-Core Version:    0.7.0.1
 */