package tencent.im.oidb.cmd0x5d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5d6$SnsUpateBuffer
  extends MessageMicro<SnsUpateBuffer>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 3202, 3208 }, new String[] { "uint64_uin", "rpt_msg_sns_update_item", "rpt_uin32_idlist" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, SnsUpateBuffer.class);
  public final PBRepeatMessageField<oidb_0x5d6.SnsUpdateItem> rpt_msg_sns_update_item = PBField.initRepeatMessage(oidb_0x5d6.SnsUpdateItem.class);
  public final PBRepeatField<Integer> rpt_uin32_idlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer
 * JD-Core Version:    0.7.0.1
 */