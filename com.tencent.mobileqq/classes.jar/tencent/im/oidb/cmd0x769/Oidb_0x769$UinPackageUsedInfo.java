package tencent.im.oidb.cmd0x769;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x769$UinPackageUsedInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "rule_id", "author", "url", "uin_num" }, new Object[] { Integer.valueOf(0), "", "", Long.valueOf(0L) }, UinPackageUsedInfo.class);
  public final PBStringField author = PBField.initString("");
  public final PBUInt32Field rule_id = PBField.initUInt32(0);
  public final PBUInt64Field uin_num = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x769.Oidb_0x769.UinPackageUsedInfo
 * JD-Core Version:    0.7.0.1
 */