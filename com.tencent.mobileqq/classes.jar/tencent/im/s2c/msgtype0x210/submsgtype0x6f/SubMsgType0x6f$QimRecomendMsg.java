package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6f$QimRecomendMsg
  extends MessageMicro<QimRecomendMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_msg_recomend_list", "uint64_timestamp" }, new Object[] { null, Long.valueOf(0L) }, QimRecomendMsg.class);
  public final PBRepeatMessageField<SubMsgType0x6f.QimRecomendInfo> rpt_msg_recomend_list = PBField.initRepeatMessage(SubMsgType0x6f.QimRecomendInfo.class);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.QimRecomendMsg
 * JD-Core Version:    0.7.0.1
 */