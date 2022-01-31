package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$Hometown
  extends MessageMicro<Hometown>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_country", "uint32_province", "uint32_city" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Hometown.class);
  public final PBUInt32Field uint32_city = PBField.initUInt32(0);
  public final PBUInt32Field uint32_country = PBField.initUInt32(0);
  public final PBUInt32Field uint32_province = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.Hometown
 * JD-Core Version:    0.7.0.1
 */