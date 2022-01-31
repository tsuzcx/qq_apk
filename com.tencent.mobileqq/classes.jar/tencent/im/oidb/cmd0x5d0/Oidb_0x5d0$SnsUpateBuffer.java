package tencent.im.oidb.cmd0x5d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5d0$SnsUpateBuffer
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 3202, 3208 }, new String[] { "uint64_uin", "rpt_msg_sns_update_item", "rpt_uin32_idlist" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, SnsUpateBuffer.class);
  public final PBRepeatMessageField rpt_msg_sns_update_item = PBField.initRepeatMessage(Oidb_0x5d0.SnsUpdateItem.class);
  public final PBRepeatField rpt_uin32_idlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer
 * JD-Core Version:    0.7.0.1
 */