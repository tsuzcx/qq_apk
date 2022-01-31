package tencent.im.oidb.cmd0xff1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xff1$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_req_setalarm", "msg_req_revert_alarm", "msg_req_alarm_ring" }, new Object[] { null, null, null }, ReqBody.class);
  public oidb_0xff1.ReqAlarmRing msg_req_alarm_ring = new oidb_0xff1.ReqAlarmRing();
  public oidb_0xff1.ReqRevertAlarm msg_req_revert_alarm = new oidb_0xff1.ReqRevertAlarm();
  public oidb_0xff1.ReqSetAlarm msg_req_setalarm = new oidb_0xff1.ReqSetAlarm();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xff1.oidb_0xff1.ReqBody
 * JD-Core Version:    0.7.0.1
 */