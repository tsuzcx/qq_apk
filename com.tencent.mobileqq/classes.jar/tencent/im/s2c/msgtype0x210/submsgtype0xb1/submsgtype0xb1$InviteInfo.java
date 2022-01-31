package tencent.im.s2c.msgtype0x210.submsgtype0xb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xb1$InviteInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_uin", "uint64_group_code", "uint32_expire_time", "str_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, InviteInfo.class);
  public final PBStringField str_id = PBField.initString("");
  public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.InviteInfo
 * JD-Core Version:    0.7.0.1
 */