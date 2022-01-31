package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x791$GetRedDotRes
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_uin", "rpt_msg_reddot_info", "uint32_interval" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, GetRedDotRes.class);
  public final PBRepeatMessageField rpt_msg_reddot_info = PBField.initRepeatMessage(oidb_0x791.RedDotInfo.class);
  public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes
 * JD-Core Version:    0.7.0.1
 */