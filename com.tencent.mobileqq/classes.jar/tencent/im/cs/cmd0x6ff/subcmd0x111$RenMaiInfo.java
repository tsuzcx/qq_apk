package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x111$RenMaiInfo
  extends MessageMicro<RenMaiInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48 }, new String[] { "uint32_sync_type", "uint32_next_start_time", "rpt_msg_group_info", "rpt_msg_frd", "rpt_uint64_del_frd", "uint32_next_interval" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, Long.valueOf(0L), Integer.valueOf(0) }, RenMaiInfo.class);
  public final PBRepeatMessageField<subcmd0x111.OneRenMaiFrd> rpt_msg_frd = PBField.initRepeatMessage(subcmd0x111.OneRenMaiFrd.class);
  public final PBRepeatMessageField<subcmd0x111.GroupInfo> rpt_msg_group_info = PBField.initRepeatMessage(subcmd0x111.GroupInfo.class);
  public final PBRepeatField<Long> rpt_uint64_del_frd = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_next_interval = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_start_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sync_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x111.RenMaiInfo
 * JD-Core Version:    0.7.0.1
 */