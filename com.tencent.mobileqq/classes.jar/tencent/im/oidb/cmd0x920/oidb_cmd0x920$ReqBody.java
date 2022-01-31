package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x920$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int MSG_CANCLE_MEETING_FIELD_NUMBER = 3;
  public static final int MSG_CREATE_MEETING_FIELD_NUMBER = 2;
  public static final int MSG_GET_DISCUSS_MEETING_FIELD_NUMBER = 4;
  public static final int MSG_GET_SPECIFIED_MEETING_FIELD_NUMBER = 6;
  public static final int MSG_GET_USER_MEETING_FIELD_NUMBER = 5;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uint32_subcmd", "msg_create_meeting", "msg_cancle_meeting", "msg_get_discuss_meeting", "msg_get_user_meeting", "msg_get_specified_meeting" }, new Object[] { Integer.valueOf(0), null, null, null, null, null }, ReqBody.class);
  public oidb_cmd0x920.CancleMeeting msg_cancle_meeting = new oidb_cmd0x920.CancleMeeting();
  public oidb_cmd0x920.CreateMeeting msg_create_meeting = new oidb_cmd0x920.CreateMeeting();
  public oidb_cmd0x920.GetDiscussMeeting msg_get_discuss_meeting = new oidb_cmd0x920.GetDiscussMeeting();
  public oidb_cmd0x920.GetSpecifiedMeeting msg_get_specified_meeting = new oidb_cmd0x920.GetSpecifiedMeeting();
  public oidb_cmd0x920.GetUserMeeting msg_get_user_meeting = new oidb_cmd0x920.GetUserMeeting();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x920.oidb_cmd0x920.ReqBody
 * JD-Core Version:    0.7.0.1
 */