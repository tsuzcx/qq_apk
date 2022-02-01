package tencent.im.oidb.cmd0x5d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5d0$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "rpt_msg_contentItem", "uint32_sys_time", "uint64_uin", "uint32_advise_gap" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField<Oidb_0x5d0.ContentItem> rpt_msg_contentItem = PBField.initRepeatMessage(Oidb_0x5d0.ContentItem.class);
  public final PBUInt32Field uint32_advise_gap = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sys_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.RspBody
 * JD-Core Version:    0.7.0.1
 */