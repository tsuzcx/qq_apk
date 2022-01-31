package tencent.im.s2c.msgtype0x210.submsgtype0xae;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xae$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_type", "msg_people_may_konw", "msg_persons_may_know" }, new Object[] { Integer.valueOf(0), null, null }, MsgBody.class);
  public SubMsgType0xae.PushPeopleMayKnow msg_people_may_konw = new SubMsgType0xae.PushPeopleMayKnow();
  public SubMsgType0xae.PushPeopleMayKnowV2 msg_persons_may_know = new SubMsgType0xae.PushPeopleMayKnowV2();
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody
 * JD-Core Version:    0.7.0.1
 */