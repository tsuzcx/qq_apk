package tencent.im.s2c.msgtype0x210.submsgtype0xca;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xca$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "rpt_msg_list" }, new Object[] { Long.valueOf(0L), null }, MsgBody.class);
  public final PBRepeatMessageField rpt_msg_list = PBField.initRepeatMessage(submsgtype0xca.MsgContent.class);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xca.submsgtype0xca.MsgBody
 * JD-Core Version:    0.7.0.1
 */