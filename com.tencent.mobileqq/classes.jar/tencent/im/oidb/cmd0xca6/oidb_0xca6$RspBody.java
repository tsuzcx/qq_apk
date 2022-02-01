package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xca6$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field adcode = PBField.initUInt32(0);
  public WeatherReportStore.AirInfo air_info = new WeatherReportStore.AirInfo();
  public final PBRepeatMessageField<WeatherReportStore.DailyAstroFortune> all_astro = PBField.initRepeatMessage(WeatherReportStore.DailyAstroFortune.class);
  public final PBStringField almanac = PBField.initString("");
  public final PBStringField area = PBField.initString("");
  public final PBUInt32Field area_id = PBField.initUInt32(0);
  public WeatherReportStore.DailyAstroFortune astro = new WeatherReportStore.DailyAstroFortune();
  public final PBStringField city = PBField.initString("");
  public final PBStringField en_name = PBField.initString("");
  public WeatherReportStore.WeatherForecast forecast = new WeatherReportStore.WeatherForecast();
  public WeatherReportStore.WeatherForecastList forecast_list = new WeatherReportStore.WeatherForecastList();
  public WeatherReportStore.WeatherHourInfoList hourinfo_list = new WeatherReportStore.WeatherHourInfoList();
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public WeatherReportStore.TipsList tips_list = new WeatherReportStore.TipsList();
  public final PBUInt32Field update_time = PBField.initUInt32(0);
  public WeatherReportStore.WeatherWarningList warning_list = new WeatherReportStore.WeatherWarningList();
  public WeatherReportStore.WeatherInfo weather_info = new WeatherReportStore.WeatherInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 114, 122, 128, 138 }, new String[] { "ret", "weather_info", "air_info", "forecast_list", "forecast", "hourinfo_list", "almanac", "warning_list", "astro", "city", "area", "adcode", "area_id", "all_astro", "en_name", "update_time", "tips_list" }, new Object[] { localInteger, null, null, null, null, null, "", null, null, "", "", localInteger, localInteger, null, "", localInteger, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.oidb_0xca6.RspBody
 * JD-Core Version:    0.7.0.1
 */