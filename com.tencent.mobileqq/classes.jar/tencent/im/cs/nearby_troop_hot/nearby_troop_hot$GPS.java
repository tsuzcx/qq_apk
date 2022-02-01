package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby_troop_hot$GPS
  extends MessageMicro<GPS>
{
  public static final int LATITUDE_FIELD_NUMBER = 2;
  public static final int LONGTITUDE_FIELD_NUMBER = 1;
  public static final int RANGE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field latitude = PBField.initUInt64(0L);
  public final PBUInt64Field longtitude = PBField.initUInt64(0L);
  public final PBUInt64Field range = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "longtitude", "latitude", "range" }, new Object[] { localLong, localLong, localLong }, GPS.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_hot.nearby_troop_hot.GPS
 * JD-Core Version:    0.7.0.1
 */