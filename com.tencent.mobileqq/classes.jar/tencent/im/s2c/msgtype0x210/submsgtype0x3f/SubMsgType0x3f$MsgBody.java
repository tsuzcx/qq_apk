package tencent.im.s2c.msgtype0x210.submsgtype0x3f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SubMsgType0x3f$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_pubunikey" }, new Object[] { null }, MsgBody.class);
  public final PBRepeatMessageField<SubMsgType0x3f.PubUniKey> rpt_msg_pubunikey = PBField.initRepeatMessage(SubMsgType0x3f.PubUniKey.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x3f.SubMsgType0x3f.MsgBody
 * JD-Core Version:    0.7.0.1
 */