package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x920$CancleMeeting
  extends MessageMicro<CancleMeeting>
{
  public static final int RPT_MSG_MEETING_INFO2_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_meeting_info2" }, new Object[] { null }, CancleMeeting.class);
  public final PBRepeatMessageField<oidb_cmd0x920.MeetingInfo> rpt_msg_meeting_info2 = PBField.initRepeatMessage(oidb_cmd0x920.MeetingInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x920.oidb_cmd0x920.CancleMeeting
 * JD-Core Version:    0.7.0.1
 */