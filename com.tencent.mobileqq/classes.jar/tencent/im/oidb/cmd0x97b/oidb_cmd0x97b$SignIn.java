package tencent.im.oidb.cmd0x97b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x97b$SignIn
  extends MessageMicro<SignIn>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int64_status", "uint32_current_continuous_sign_days", "uint32_max_continuous_sign_days" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, SignIn.class);
  public final PBInt64Field int64_status = PBField.initInt64(0L);
  public final PBUInt32Field uint32_current_continuous_sign_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_continuous_sign_days = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.SignIn
 * JD-Core Version:    0.7.0.1
 */