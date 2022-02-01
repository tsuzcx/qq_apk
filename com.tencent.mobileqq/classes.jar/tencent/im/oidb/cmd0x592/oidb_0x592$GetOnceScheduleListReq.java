package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow.WorkflowBrief;

public final class oidb_0x592$GetOnceScheduleListReq
  extends MessageMicro<GetOnceScheduleListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<Qworkflow.WorkflowBrief> rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow.WorkflowBrief.class);
  public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
  public final PBUInt32Field uint32_get_direction = PBField.initUInt32(0);
  public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint32_get_direction", "uint64_start_time", "uint32_amount", "rpt_msg_workflow_list", "uint32_main_type", "uint64_end_time" }, new Object[] { localInteger, localLong, localInteger, null, localInteger, localLong }, GetOnceScheduleListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.GetOnceScheduleListReq
 * JD-Core Version:    0.7.0.1
 */