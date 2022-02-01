package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCirclePhotocatemetadata$PhotoExifInfo
  extends MessageMicro<PhotoExifInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField aperture = PBField.initString("");
  public final PBStringField exposureTime = PBField.initString("");
  public final PBInt32Field flash = PBField.initInt32(0);
  public final PBStringField focalLength = PBField.initString("");
  public final PBStringField iso = PBField.initString("");
  public final PBInt64Field latitude = PBField.initInt64(0L);
  public final PBInt64Field longitude = PBField.initInt64(0L);
  public final PBStringField make = PBField.initString("");
  public final PBStringField model = PBField.initString("");
  public final PBInt32Field orientation = PBField.initInt32(0);
  public final PBStringField whiteBalance = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82, 90 }, new String[] { "orientation", "flash", "latitude", "longitude", "make", "model", "whiteBalance", "exposureTime", "aperture", "focalLength", "iso" }, new Object[] { localInteger, localInteger, localLong, localLong, "", "", "", "", "", "", "" }, PhotoExifInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePhotocatemetadata.PhotoExifInfo
 * JD-Core Version:    0.7.0.1
 */