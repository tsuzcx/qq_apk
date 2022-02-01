package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x920$RspBody
  extends MessageMicro<RspBody>
{
  public static final int MSG_CANCLE_MEETING_FIELD_NUMBER = 3;
  public static final int MSG_CREATE_MEETING_FIELD_NUMBER = 2;
  public static final int RPT_MSG_MEETING_INFO_FIELD_NUMBER = 4;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_subcmd", "msg_create_meeting", "msg_cancle_meeting", "rpt_msg_meeting_info" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
  public oidb_cmd0x920.CancleMeeting msg_cancle_meeting = new oidb_cmd0x920.CancleMeeting();
  public oidb_cmd0x920.CreateMeeting msg_create_meeting = new oidb_cmd0x920.CreateMeeting();
  public final PBRepeatMessageField<oidb_cmd0x920.MeetingInfo> rpt_msg_meeting_info = PBField.initRepeatMessage(oidb_cmd0x920.MeetingInfo.class);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x920.oidb_cmd0x920.RspBody
 * JD-Core Version:    0.7.0.1
 */