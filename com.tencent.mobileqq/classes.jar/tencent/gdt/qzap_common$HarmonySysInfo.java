package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qzap_common$HarmonySysInfo
  extends MessageMicro<HarmonySysInfo>
{
  public static final int HARMONY_PURE_MODE_CLOSE = 1;
  public static final int HARMONY_PURE_MODE_OPEN = 0;
  public static final int HARMONY_PURE_MODE_UNKNOWN = -1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "harmony_pure_mode", "os_version", "is_harmony_os" }, new Object[] { Integer.valueOf(-1), "", Boolean.valueOf(false) }, HarmonySysInfo.class);
  public final PBEnumField harmony_pure_mode = PBField.initEnum(-1);
  public final PBBoolField is_harmony_os = PBField.initBool(false);
  public final PBStringField os_version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qzap_common.HarmonySysInfo
 * JD-Core Version:    0.7.0.1
 */