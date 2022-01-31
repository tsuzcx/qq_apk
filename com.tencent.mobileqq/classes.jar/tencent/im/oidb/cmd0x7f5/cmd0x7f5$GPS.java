package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7f5$GPS
  extends MessageMicro<GPS>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_accuracy = PBField.initUInt32(0);
  public final PBUInt32Field uint32_altitude = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cityid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
  public final PBUInt32Field uint32_longitude = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72 }, new String[] { "uint32_latitude", "uint32_longitude", "uint32_altitude", "uint32_accuracy", "uint32_time", "uint32_flag", "uint32_cityid", "bytes_client_version", "uint32_client" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, GPS.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7f5.cmd0x7f5.GPS
 * JD-Core Version:    0.7.0.1
 */