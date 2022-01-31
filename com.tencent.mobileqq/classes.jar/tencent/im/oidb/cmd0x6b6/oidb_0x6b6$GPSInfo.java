package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_0x6b6$GPSInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int64_longitude", "int64_latitude", "int32_gps_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GPSInfo.class);
  public final PBInt32Field int32_gps_type = PBField.initInt32(0);
  public final PBInt64Field int64_latitude = PBField.initInt64(0L);
  public final PBInt64Field int64_longitude = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6b6.oidb_0x6b6.GPSInfo
 * JD-Core Version:    0.7.0.1
 */