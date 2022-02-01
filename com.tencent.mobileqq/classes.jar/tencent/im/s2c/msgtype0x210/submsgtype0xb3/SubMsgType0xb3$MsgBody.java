package tencent.im.s2c.msgtype0x210.submsgtype0xb3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xb3$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_type", "msg_add_frd_notify" }, new Object[] { Integer.valueOf(0), null }, MsgBody.class);
  public SubMsgType0xb3.PushAddFrdNotify msg_add_frd_notify = new SubMsgType0xb3.PushAddFrdNotify();
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.MsgBody
 * JD-Core Version:    0.7.0.1
 */