package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x885$ClassInfo
  extends MessageMicro<ClassInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50 }, new String[] { "uint64_ch1_id", "string_ch1", "uint64_ch2_id", "string_ch2", "uint64_ch3_id", "string_ch3" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), "", Long.valueOf(0L), "" }, ClassInfo.class);
  public final PBStringField string_ch1 = PBField.initString("");
  public final PBStringField string_ch2 = PBField.initString("");
  public final PBStringField string_ch3 = PBField.initString("");
  public final PBUInt64Field uint64_ch1_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_ch2_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_ch3_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.ClassInfo
 * JD-Core Version:    0.7.0.1
 */