package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class QQCircleCity$GPS
  extends MessageMicro<GPS>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "lat", "lon", "eType", "alt" }, new Object[] { Long.valueOf(900000000L), Long.valueOf(900000000L), Integer.valueOf(2), Long.valueOf(-10000000L) }, GPS.class);
  public final PBInt64Field alt = PBField.initInt64(-10000000L);
  public final PBInt32Field eType = PBField.initInt32(2);
  public final PBInt64Field lat = PBField.initInt64(900000000L);
  public final PBInt64Field lon = PBField.initInt64(900000000L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleCity.GPS
 * JD-Core Version:    0.7.0.1
 */