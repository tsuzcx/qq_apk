package tencent.im.oidb.cmd0x899;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x899$uin_key
  extends MessageMicro<uin_key>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_group_code", "uint64_member_uin", "uint64_gen_time", "uint32_valid_time", "uint32_rand_num" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, uin_key.class);
  public final PBUInt32Field uint32_rand_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_valid_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_gen_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x899.oidb_0x899.uin_key
 * JD-Core Version:    0.7.0.1
 */