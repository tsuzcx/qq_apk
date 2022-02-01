package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeatherReportStore$WeatherInfo
  extends MessageMicro<WeatherInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 74 }, new String[] { "temper", "air_humidity", "wind_power", "wind_direct", "weather", "pubtime", "updatetime", "weather_type", "weather_type_id" }, new Object[] { "", "", "", "", "", "", Long.valueOf(0L), "", "" }, WeatherInfo.class);
  public final PBStringField air_humidity = PBField.initString("");
  public final PBStringField pubtime = PBField.initString("");
  public final PBStringField temper = PBField.initString("");
  public final PBUInt64Field updatetime = PBField.initUInt64(0L);
  public final PBStringField weather = PBField.initString("");
  public final PBStringField weather_type = PBField.initString("");
  public final PBStringField weather_type_id = PBField.initString("");
  public final PBStringField wind_direct = PBField.initString("");
  public final PBStringField wind_power = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.WeatherInfo
 * JD-Core Version:    0.7.0.1
 */