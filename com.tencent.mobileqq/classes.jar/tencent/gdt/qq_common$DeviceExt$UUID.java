package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_common$DeviceExt$UUID
  extends MessageMicro<UUID>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "v", "t", "u", "m" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", "" }, UUID.class);
  public final PBStringField m = PBField.initString("");
  public final PBUInt64Field t = PBField.initUInt64(0L);
  public final PBStringField u = PBField.initString("");
  public final PBInt32Field v = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.gdt.qq_common.DeviceExt.UUID
 * JD-Core Version:    0.7.0.1
 */