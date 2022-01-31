package tencent.im.lbs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class member_lbs$GPS
  extends MessageMicro<GPS>
{
  public static final int INT64_ALTITUDE_FIELD_NUMBER = 3;
  public static final int INT64_LATITUDE_FIELD_NUMBER = 1;
  public static final int INT64_LONGITUDE_FIELD_NUMBER = 2;
  public static final int UINT32_GPS_TYPE_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int64_latitude", "int64_longitude", "int64_altitude", "uint32_gps_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GPS.class);
  public final PBInt64Field int64_altitude = PBField.initInt64(0L);
  public final PBInt64Field int64_latitude = PBField.initInt64(0L);
  public final PBInt64Field int64_longitude = PBField.initInt64(0L);
  public final PBUInt32Field uint32_gps_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.lbs.member_lbs.GPS
 * JD-Core Version:    0.7.0.1
 */