package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.trunk.Qworkflow.Qworkflow.WorkflowBrief;

public final class oidb_0x4d4$SetWorkflowsIgnoreStateReq
  extends MessageMicro
{
  public static final int IGNORED = 1;
  public static final int NOT_IGNORED = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_state", "rpt_msg_workflow_list" }, new Object[] { Integer.valueOf(1), null }, SetWorkflowsIgnoreStateReq.class);
  public final PBEnumField enum_state = PBField.initEnum(1);
  public final PBRepeatMessageField rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow.WorkflowBrief.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.SetWorkflowsIgnoreStateReq
 * JD-Core Version:    0.7.0.1
 */