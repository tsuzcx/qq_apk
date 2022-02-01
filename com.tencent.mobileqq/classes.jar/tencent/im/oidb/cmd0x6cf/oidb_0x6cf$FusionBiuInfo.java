package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6cf$FusionBiuInfo
  extends MessageMicro<FusionBiuInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_biu = PBField.initBool(false);
  public final PBBoolField bool_is_gray = PBField.initBool(false);
  public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "bool_is_gray", "uint32_biu_count", "bool_is_biu", "uint64_feeds_id" }, new Object[] { localBoolean, Integer.valueOf(0), localBoolean, Long.valueOf(0L) }, FusionBiuInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FusionBiuInfo
 * JD-Core Version:    0.7.0.1
 */