package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleSwitch$GPS_V2
  extends MessageMicro<GPS_V2>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field eType = PBField.initInt32(0);
  public final PBInt32Field iAlt = PBField.initInt32(0);
  public final PBInt32Field iLat = PBField.initInt32(0);
  public final PBInt32Field iLon = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "iLat", "iLon", "eType", "iAlt" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, GPS_V2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.GPS_V2
 * JD-Core Version:    0.7.0.1
 */