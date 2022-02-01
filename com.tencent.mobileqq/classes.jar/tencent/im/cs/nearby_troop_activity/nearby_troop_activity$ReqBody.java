package tencent.im.cs.nearby_troop_activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby_troop_activity$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int INT64_LATITUDE_FIELD_NUMBER = 2;
  public static final int INT64_LONGTITUDE_FIELD_NUMBER = 1;
  public static final int UINT64_DISTANCE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field int64_latitude = PBField.initInt64(0L);
  public final PBInt64Field int64_longtitude = PBField.initInt64(0L);
  public final PBUInt64Field uint64_distance = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int64_longtitude", "int64_latitude", "uint64_distance" }, new Object[] { localLong, localLong, localLong }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_activity.nearby_troop_activity.ReqBody
 * JD-Core Version:    0.7.0.1
 */