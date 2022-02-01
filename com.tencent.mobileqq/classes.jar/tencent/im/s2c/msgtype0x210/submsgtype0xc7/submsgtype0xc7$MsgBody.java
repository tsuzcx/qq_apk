package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class submsgtype0xc7$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_mod_infos" }, new Object[] { null }, MsgBody.class);
  public final PBRepeatMessageField<submsgtype0xc7.ForwardBody> rpt_msg_mod_infos = PBField.initRepeatMessage(submsgtype0xc7.ForwardBody.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.MsgBody
 * JD-Core Version:    0.7.0.1
 */