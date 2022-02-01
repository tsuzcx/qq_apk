package tencent.im.s2c.msgtype0x210.submsgtype0x67;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class submsgtype0x67$MsgBody
  extends MessageMicro<MsgBody>
{
  public static final int RPT_MSG_GRPINFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_grpinfo" }, new Object[] { null }, MsgBody.class);
  public final PBRepeatMessageField<submsgtype0x67.GroupInfo> rpt_msg_grpinfo = PBField.initRepeatMessage(submsgtype0x67.GroupInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody
 * JD-Core Version:    0.7.0.1
 */