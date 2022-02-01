package tencent.im.s2c.msgtype0x210.submsgtype0x101;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class SubMsgType0x27$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_push_platform", "msg_client_report" }, new Object[] { null, null }, MsgBody.class);
  public SubMsgType0x27.ClientReport msg_client_report = new SubMsgType0x27.ClientReport();
  public SubMsgType0x27.PushPlatform msg_push_platform = new SubMsgType0x27.PushPlatform();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.MsgBody
 * JD-Core Version:    0.7.0.1
 */