package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_msg$Msg
  extends MessageMicro<Msg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "body" }, new Object[] { null, null }, Msg.class);
  public im_msg_body.MsgBody body = new im_msg_body.MsgBody();
  public im_msg.MsgHead head = new im_msg.MsgHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg.Msg
 * JD-Core Version:    0.7.0.1
 */