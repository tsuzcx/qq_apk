package tencent.im.s2c.msgtype0x210.submsgtype0x87;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x87$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_friend_msg_type_flag", "rpt_msg_msg_notify", "msg_msg_notify_unread" }, new Object[] { Long.valueOf(0L), null, null }, MsgBody.class);
  public SubMsgType0x87.MsgNotifyUnread msg_msg_notify_unread = new SubMsgType0x87.MsgNotifyUnread();
  public final PBRepeatMessageField<SubMsgType0x87.MsgNotify> rpt_msg_msg_notify = PBField.initRepeatMessage(SubMsgType0x87.MsgNotify.class);
  public final PBUInt64Field uint64_friend_msg_type_flag = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgBody
 * JD-Core Version:    0.7.0.1
 */