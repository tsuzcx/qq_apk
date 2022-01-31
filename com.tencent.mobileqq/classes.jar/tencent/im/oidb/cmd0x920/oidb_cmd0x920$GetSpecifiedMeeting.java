package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x920$GetSpecifiedMeeting
  extends MessageMicro<GetSpecifiedMeeting>
{
  public static final int RPT_MSG_MEETING_INFO3_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_meeting_info3" }, new Object[] { null }, GetSpecifiedMeeting.class);
  public final PBRepeatMessageField<oidb_cmd0x920.MeetingInfo> rpt_msg_meeting_info3 = PBField.initRepeatMessage(oidb_cmd0x920.MeetingInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x920.oidb_cmd0x920.GetSpecifiedMeeting
 * JD-Core Version:    0.7.0.1
 */