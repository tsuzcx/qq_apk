package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGet$DeviceInfo$Location
  extends MessageMicro<Location>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field coordinates_type = PBField.initUInt32(0);
  public final PBInt32Field latitude = PBField.initInt32(0);
  public final PBInt32Field longitude = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "latitude", "longitude", "coordinates_type" }, new Object[] { localInteger, localInteger, localInteger }, Location.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location
 * JD-Core Version:    0.7.0.1
 */