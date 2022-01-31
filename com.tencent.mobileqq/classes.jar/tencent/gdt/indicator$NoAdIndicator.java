package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class indicator$NoAdIndicator
  extends MessageMicro<NoAdIndicator>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "partition_timestamp", "placement_id", "no_ad_reason", "ad_count" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null }, NoAdIndicator.class);
  public indicator.AdCount ad_count = new indicator.AdCount();
  public final PBEnumField no_ad_reason = PBField.initEnum(0);
  public final PBUInt32Field partition_timestamp = PBField.initUInt32(0);
  public final PBUInt64Field placement_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.indicator.NoAdIndicator
 * JD-Core Version:    0.7.0.1
 */