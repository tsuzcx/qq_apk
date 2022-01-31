package tencent.im.s2c.msgtype0x210.submsgtype0x83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x83$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_msg_params", "uint64_seq", "uint64_group_id" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L) }, MsgBody.class);
  public final PBRepeatMessageField<SubMsgType0x83.MsgParams> rpt_msg_params = PBField.initRepeatMessage(SubMsgType0x83.MsgParams.class);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgBody
 * JD-Core Version:    0.7.0.1
 */