package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RoomOperate$UserData
  extends MessageMicro<UserData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBDoubleField direction = PBField.initDouble(0.0D);
  public final PBUInt64Field join_time = PBField.initUInt64(0L);
  public final PBDoubleField lat = PBField.initDouble(0.0D);
  public final PBUInt64Field lbs_update_ts = PBField.initUInt64(0L);
  public final PBDoubleField lon = PBField.initDouble(0.0D);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    Double localDouble = Double.valueOf(0.0D);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 25, 33, 41, 48 }, new String[] { "uin", "join_time", "lon", "lat", "direction", "lbs_update_ts" }, new Object[] { localLong, localLong, localDouble, localDouble, localDouble, localLong }, UserData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.location.RoomOperate.UserData
 * JD-Core Version:    0.7.0.1
 */