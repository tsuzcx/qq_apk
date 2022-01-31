package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.trunk.Qworkflow.Qworkflow.Workflow;

public final class oidb_0x592$BatchAddScheduleReq
  extends MessageMicro<BatchAddScheduleReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_schedule_list" }, new Object[] { null }, BatchAddScheduleReq.class);
  public final PBRepeatMessageField<Qworkflow.Workflow> rpt_msg_schedule_list = PBField.initRepeatMessage(Qworkflow.Workflow.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.BatchAddScheduleReq
 * JD-Core Version:    0.7.0.1
 */