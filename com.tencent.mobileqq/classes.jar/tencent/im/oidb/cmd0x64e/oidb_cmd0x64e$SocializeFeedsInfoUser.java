package tencent.im.oidb.cmd0x64e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x64e$SocializeFeedsInfoUser
  extends MessageMicro<SocializeFeedsInfoUser>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "enum_uin_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, SocializeFeedsInfoUser.class);
  public final PBEnumField enum_uin_type = PBField.initEnum(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SocializeFeedsInfoUser
 * JD-Core Version:    0.7.0.1
 */