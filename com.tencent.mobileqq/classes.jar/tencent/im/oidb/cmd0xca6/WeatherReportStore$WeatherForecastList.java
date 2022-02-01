package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeatherReportStore$WeatherForecastList
  extends MessageMicro<WeatherForecastList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 24 }, new String[] { "weatherForecast", "updatetime" }, new Object[] { null, Long.valueOf(0L) }, WeatherForecastList.class);
  public final PBUInt64Field updatetime = PBField.initUInt64(0L);
  public final PBRepeatMessageField<WeatherReportStore.WeatherForecast> weatherForecast = PBField.initRepeatMessage(WeatherReportStore.WeatherForecast.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.WeatherForecastList
 * JD-Core Version:    0.7.0.1
 */