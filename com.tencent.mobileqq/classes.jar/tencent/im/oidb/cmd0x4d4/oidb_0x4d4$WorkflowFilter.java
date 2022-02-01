package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow.ApproverState;

public final class oidb_0x4d4$WorkflowFilter
  extends MessageMicro<WorkflowFilter>
{
  public static final int IGNORED = 1;
  public static final int NOT_IGNORED = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_ignore_state = PBField.initEnum(1);
  public oidb_0x4d4.WorkflowSource msg_workflow_source = new oidb_0x4d4.WorkflowSource();
  public final PBRepeatMessageField<Qworkflow.ApproverState> rpt_msg_my_state = PBField.initRepeatMessage(Qworkflow.ApproverState.class);
  public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50 }, new String[] { "uint32_main_type", "uint32_sub_type", "uint64_author_uin", "rpt_msg_my_state", "enum_ignore_state", "msg_workflow_source" }, new Object[] { localInteger, localInteger, Long.valueOf(0L), null, Integer.valueOf(1), null }, WorkflowFilter.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.WorkflowFilter
 * JD-Core Version:    0.7.0.1
 */