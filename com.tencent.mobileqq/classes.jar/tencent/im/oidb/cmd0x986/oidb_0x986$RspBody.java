package tencent.im.oidb.cmd0x986;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x986$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_group_code", "rpt_msg_uin_info", "uint64_next_uin", "uint32_read_uin_num" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField<oidb_0x986.UinInfo> rpt_msg_uin_info = PBField.initRepeatMessage(oidb_0x986.UinInfo.class);
  public final PBUInt32Field uint32_read_uin_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_next_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x986.oidb_0x986.RspBody
 * JD-Core Version:    0.7.0.1
 */