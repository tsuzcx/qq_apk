package tencent.im.oidb.cmd0xdc0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xdc0$LocationInfo
  extends MessageMicro<LocationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_city_code = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_country = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_province = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_order = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 114 }, new String[] { "uint32_id", "uint32_order", "bytes_country", "bytes_province", "bytes_city", "bytes_city_code" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, LocationInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc0.oidb_0xdc0.LocationInfo
 * JD-Core Version:    0.7.0.1
 */