package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGet$DeviceInfo$Location
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "latitude", "longitude" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Location.class);
  public final PBUInt32Field latitude = PBField.initUInt32(0);
  public final PBUInt32Field longitude = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location
 * JD-Core Version:    0.7.0.1
 */