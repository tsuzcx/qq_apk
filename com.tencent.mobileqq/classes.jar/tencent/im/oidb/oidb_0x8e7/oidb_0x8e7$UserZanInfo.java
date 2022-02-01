package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8e7$UserZanInfo
  extends MessageMicro<UserZanInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_uin", "uint64_tinyid", "uint64_free_zan", "uint64_pay_zan", "uint64_pay_stock" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, UserZanInfo.class);
  public final PBUInt64Field uint64_free_zan = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_pay_stock = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_pay_zan = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.UserZanInfo
 * JD-Core Version:    0.7.0.1
 */