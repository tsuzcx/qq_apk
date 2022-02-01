package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$Hometown
  extends MessageMicro<Hometown>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_city = PBField.initUInt32(0);
  public final PBUInt32Field uint32_country = PBField.initUInt32(0);
  public final PBUInt32Field uint32_province = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_country", "uint32_province", "uint32_city" }, new Object[] { localInteger, localInteger, localInteger }, Hometown.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.Hometown
 * JD-Core Version:    0.7.0.1
 */