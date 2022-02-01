package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_common$DeviceExt$IdInfo
  extends MessageMicro<IdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "id_h", "bitmap" }, new Object[] { "", Integer.valueOf(0) }, IdInfo.class);
  public final PBUInt32Field bitmap = PBField.initUInt32(0);
  public final PBStringField id_h = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.gdt.qq_common.DeviceExt.IdInfo
 * JD-Core Version:    0.7.0.1
 */