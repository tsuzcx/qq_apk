package tencent.im.s2c.msgtype0x210.submsgtype0x89;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0x89$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uiUin", "uint32_push_red_ts", "rpt_msg_num_red" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, MsgBody.class);
  public final PBRepeatMessageField rpt_msg_num_red = PBField.initRepeatMessage(Submsgtype0x89.NumRedBusiInfo.class);
  public final PBUInt32Field uint32_push_red_ts = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uiUin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.MsgBody
 * JD-Core Version:    0.7.0.1
 */