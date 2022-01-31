package tencent.im.oidb.cmd0xa80;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xa80$MemberInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_member_uin", "uint64_flag_ex_pos", "uint32_heartbeat_time", "uint64_group_msg_mask" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, MemberInfo.class);
  public final PBUInt32Field uint32_heartbeat_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_flag_ex_pos = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_msg_mask = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.MemberInfo
 * JD-Core Version:    0.7.0.1
 */