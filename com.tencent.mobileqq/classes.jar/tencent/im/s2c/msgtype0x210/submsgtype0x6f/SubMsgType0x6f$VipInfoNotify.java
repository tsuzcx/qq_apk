package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6f$VipInfoNotify
  extends MessageMicro<VipInfoNotify>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 74 }, new String[] { "uint64_uin", "uint32_vip_level", "uint32_vip_identify", "uint32_ext", "str_ext", "uint32_red_flag", "uint32_disable_red_envelope", "uint32_redpack_id", "str_redpack_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, VipInfoNotify.class);
  public final PBStringField str_ext = PBField.initString("");
  public final PBStringField str_redpack_name = PBField.initString("");
  public final PBUInt32Field uint32_disable_red_envelope = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ext = PBField.initUInt32(0);
  public final PBUInt32Field uint32_red_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_redpack_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vip_identify = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vip_level = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VipInfoNotify
 * JD-Core Version:    0.7.0.1
 */