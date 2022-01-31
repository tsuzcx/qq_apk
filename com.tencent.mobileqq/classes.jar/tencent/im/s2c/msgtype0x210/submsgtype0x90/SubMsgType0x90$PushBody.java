package tencent.im.s2c.msgtype0x210.submsgtype0x90;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class SubMsgType0x90$PushBody
  extends MessageMicro<PushBody>
{
  public static final int MSG_DP_NOTIFY_BODY_FIELD_NUMBER = 1;
  public static final int MSG_OCCUPY_MICROPHONE_BODY_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_dp_notify_body", "msg_occupy_microphone_body" }, new Object[] { null, null }, PushBody.class);
  public SubMsgType0x90.DpNotifyMsgBdoy msg_dp_notify_body = new SubMsgType0x90.DpNotifyMsgBdoy();
  public SubMsgType0x90.OccupyMicrophoneNotifyMsgBody msg_occupy_microphone_body = new SubMsgType0x90.OccupyMicrophoneNotifyMsgBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.PushBody
 * JD-Core Version:    0.7.0.1
 */