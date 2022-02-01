package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.trunk.Qworkflow.Qworkflow.Workflow;

public final class oidb_0x592$UpdateScheduleContentReq
  extends MessageMicro<UpdateScheduleContentReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_schedule" }, new Object[] { null }, UpdateScheduleContentReq.class);
  public Qworkflow.Workflow msg_schedule = new Qworkflow.Workflow();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.UpdateScheduleContentReq
 * JD-Core Version:    0.7.0.1
 */