package tencent.im.s2c.msgtype0x210.submsgtype0x90;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class SubMsgType0x90$MsgBody
  extends MessageMicro
{
  public static final int MSG_BODY_FIELD_NUMBER = 2;
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "msg_body" }, new Object[] { null, null }, MsgBody.class);
  public SubMsgType0x90.PushBody msg_body = new SubMsgType0x90.PushBody();
  public SubMsgType0x90.Head msg_head = new SubMsgType0x90.Head();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.MsgBody
 * JD-Core Version:    0.7.0.1
 */