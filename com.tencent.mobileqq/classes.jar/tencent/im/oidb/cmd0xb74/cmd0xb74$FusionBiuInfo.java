package tencent.im.oidb.cmd0xb74;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xb74$FusionBiuInfo
  extends MessageMicro<FusionBiuInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "bool_is_gray", "uint32_biu_count", "bool_is_biu", "uint64_feeds_id" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L) }, FusionBiuInfo.class);
  public final PBBoolField bool_is_biu = PBField.initBool(false);
  public final PBBoolField bool_is_gray = PBField.initBool(false);
  public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb74.cmd0xb74.FusionBiuInfo
 * JD-Core Version:    0.7.0.1
 */