package tencent.im.oidb.cmd0x908;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x908$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint32_parent_channel_id", "rpt_child_channel_status_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspBody.class);
  public final PBRepeatMessageField<oidb_cmd0x908.ChildChannelStatus> rpt_child_channel_status_list = PBField.initRepeatMessage(oidb_cmd0x908.ChildChannelStatus.class);
  public final PBUInt32Field uint32_parent_channel_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x908.oidb_cmd0x908.RspBody
 * JD-Core Version:    0.7.0.1
 */