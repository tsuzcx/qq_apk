package tencent.im.s2c.msgtype0x211.submsgtype0x3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class SubMsgType0x3$MsgBody
  extends MessageMicro<MsgBody>
{
  public static final int MSG_FAIL_NOTIFY_FIELD_NUMBER = 2;
  public static final int MSG_PROGRESS_NOTIFY_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_progress_notify", "msg_fail_notify" }, new Object[] { null, null }, MsgBody.class);
  public SubMsgType0x3.FailNotify msg_fail_notify = new SubMsgType0x3.FailNotify();
  public SubMsgType0x3.ProgressNotify msg_progress_notify = new SubMsgType0x3.ProgressNotify();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.MsgBody
 * JD-Core Version:    0.7.0.1
 */