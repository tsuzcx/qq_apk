package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeatherReportStore$WeatherForecast
  extends MessageMicro<WeatherForecast>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 130 }, new String[] { "day_weather", "night_weather", "day_temper", "night_temper", "day_wind_direct", "night_wind_direct", "day_wind_power", "night_wind_power", "sunrise_time", "sunset_time", "pubtime", "day", "day_weather_type", "night_weather_type", "day_weather_type_id", "night_weather_type_id" }, new Object[] { "", "", "", "", "", "", "", "", "", "", "", Integer.valueOf(0), "", "", "", "" }, WeatherForecast.class);
  public final PBUInt32Field day = PBField.initUInt32(0);
  public final PBStringField day_temper = PBField.initString("");
  public final PBStringField day_weather = PBField.initString("");
  public final PBStringField day_weather_type = PBField.initString("");
  public final PBStringField day_weather_type_id = PBField.initString("");
  public final PBStringField day_wind_direct = PBField.initString("");
  public final PBStringField day_wind_power = PBField.initString("");
  public final PBStringField night_temper = PBField.initString("");
  public final PBStringField night_weather = PBField.initString("");
  public final PBStringField night_weather_type = PBField.initString("");
  public final PBStringField night_weather_type_id = PBField.initString("");
  public final PBStringField night_wind_direct = PBField.initString("");
  public final PBStringField night_wind_power = PBField.initString("");
  public final PBStringField pubtime = PBField.initString("");
  public final PBStringField sunrise_time = PBField.initString("");
  public final PBStringField sunset_time = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.WeatherForecast
 * JD-Core Version:    0.7.0.1
 */