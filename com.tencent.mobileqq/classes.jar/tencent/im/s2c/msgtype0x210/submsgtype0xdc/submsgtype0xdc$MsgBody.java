package tencent.im.s2c.msgtype0x210.submsgtype0xdc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xdc$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "rpt_msg_list", "uint32_msg_type", "rpt_msg_list_0x02", "minQqVer" }, new Object[] { null, Integer.valueOf(0), null, "" }, MsgBody.class);
  public final PBStringField minQqVer = PBField.initString("");
  public final PBRepeatMessageField<submsgtype0xdc.MsgContent> rpt_msg_list = PBField.initRepeatMessage(submsgtype0xdc.MsgContent.class);
  public final PBRepeatMessageField<submsgtype0xdc.MsgContent> rpt_msg_list_0x02 = PBField.initRepeatMessage(submsgtype0xdc.MsgContent.class);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xdc.submsgtype0xdc.MsgBody
 * JD-Core Version:    0.7.0.1
 */