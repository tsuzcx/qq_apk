package tencent.im.oidb.cmd0xe09;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe09$OnlineInfo
  extends MessageMicro<OnlineInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_friend_uin", "uint32_status", "uint32_ext_online_status", "uint64_act_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, OnlineInfo.class);
  public final PBUInt32Field uint32_ext_online_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_act_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe09.oidb_0xe09.OnlineInfo
 * JD-Core Version:    0.7.0.1
 */