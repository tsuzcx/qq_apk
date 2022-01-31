package tencent.im.oidb.cmd0xb67;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb67$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_shield_uin", "int64_expire_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
  public final PBInt64Field int64_expire_time = PBField.initInt64(0L);
  public final PBUInt64Field uint64_shield_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb67.oidb_0xb67.ReqBody
 * JD-Core Version:    0.7.0.1
 */