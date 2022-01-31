package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$SnsUpateBuffer
  extends MessageMicro<SnsUpateBuffer>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 3202, 3208 }, new String[] { "uint64_uin", "uint64_code", "uint32_result", "rpt_msg_sns_update_item", "rpt_uint32_idlist" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, SnsUpateBuffer.class);
  public final PBRepeatMessageField<SubMsgType0x27.SnsUpdateItem> rpt_msg_sns_update_item = PBField.initRepeatMessage(SubMsgType0x27.SnsUpdateItem.class);
  public final PBRepeatField<Integer> rpt_uint32_idlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpateBuffer
 * JD-Core Version:    0.7.0.1
 */