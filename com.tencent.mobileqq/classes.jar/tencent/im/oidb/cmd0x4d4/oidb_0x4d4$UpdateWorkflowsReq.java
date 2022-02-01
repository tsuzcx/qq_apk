package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x4d4$UpdateWorkflowsReq
  extends MessageMicro<UpdateWorkflowsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "enum_update_type", "rpt_msg_update_list", "rpt_msg_process_workflows", "msg_hand_over" }, new Object[] { Integer.valueOf(1), null, null, null }, UpdateWorkflowsReq.class);
  public final PBEnumField enum_update_type = PBField.initEnum(1);
  public oidb_0x4d4.UpdateHandOver msg_hand_over = new oidb_0x4d4.UpdateHandOver();
  public final PBRepeatMessageField<oidb_0x4d4.UpdateApproverProcessState> rpt_msg_process_workflows = PBField.initRepeatMessage(oidb_0x4d4.UpdateApproverProcessState.class);
  public final PBRepeatMessageField<oidb_0x4d4.UpdateApproverListOfState> rpt_msg_update_list = PBField.initRepeatMessage(oidb_0x4d4.UpdateApproverListOfState.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.UpdateWorkflowsReq
 * JD-Core Version:    0.7.0.1
 */