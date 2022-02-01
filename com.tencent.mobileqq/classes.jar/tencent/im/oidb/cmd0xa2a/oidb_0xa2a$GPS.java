package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xa2a$GPS
  extends MessageMicro<GPS>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field int64_altitude = PBField.initInt64(0L);
  public final PBInt64Field int64_latitude = PBField.initInt64(0L);
  public final PBInt64Field int64_longitude = PBField.initInt64(0L);
  public final PBUInt32Field uint32_gps_type = PBField.initUInt32(0);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int64_latitude", "int64_longitude", "int64_altitude", "uint32_gps_type" }, new Object[] { localLong, localLong, localLong, Integer.valueOf(0) }, GPS.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa2a.oidb_0xa2a.GPS
 * JD-Core Version:    0.7.0.1
 */