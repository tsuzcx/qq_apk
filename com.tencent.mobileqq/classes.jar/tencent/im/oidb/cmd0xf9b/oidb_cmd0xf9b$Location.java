package tencent.im.oidb.cmd0xf9b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xf9b$Location
  extends MessageMicro<Location>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField address = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField area_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field distance = PBField.initUInt32(0);
  public final PBDoubleField lat = PBField.initDouble(0.0D);
  public final PBDoubleField lon = PBField.initDouble(0.0D);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Double localDouble = Double.valueOf(0.0D);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17, 26, 34, 40, 50, 58 }, new String[] { "lat", "lon", "title", "address", "distance", "city", "area_id" }, new Object[] { localDouble, localDouble, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4 }, Location.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf9b.oidb_cmd0xf9b.Location
 * JD-Core Version:    0.7.0.1
 */