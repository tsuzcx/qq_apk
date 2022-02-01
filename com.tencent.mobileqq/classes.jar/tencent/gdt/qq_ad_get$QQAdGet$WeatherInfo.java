package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class qq_ad_get$QQAdGet$WeatherInfo
  extends MessageMicro<WeatherInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field humidity = PBField.initInt32(0);
  public final PBInt32Field quality = PBField.initInt32(0);
  public final PBInt32Field temperature = PBField.initInt32(0);
  public final PBInt32Field warning_type = PBField.initInt32(0);
  public final PBInt32Field weather_type = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "temperature", "humidity", "quality", "weather_type", "warning_type" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger }, WeatherInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.WeatherInfo
 * JD-Core Version:    0.7.0.1
 */