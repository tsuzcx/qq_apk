package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cps_info$CpsChanTagInfo
  extends MessageMicro<CpsChanTagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "product_id", "trace_id", "is_distribution" }, new Object[] { Long.valueOf(0L), "", Boolean.valueOf(false) }, CpsChanTagInfo.class);
  public final PBBoolField is_distribution = PBField.initBool(false);
  public final PBUInt64Field product_id = PBField.initUInt64(0L);
  public final PBStringField trace_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.gdt.cps_info.CpsChanTagInfo
 * JD-Core Version:    0.7.0.1
 */