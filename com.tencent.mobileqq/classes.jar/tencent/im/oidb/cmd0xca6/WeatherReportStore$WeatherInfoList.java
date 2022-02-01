package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WeatherReportStore$WeatherInfoList
  extends MessageMicro<WeatherInfoList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 34 }, new String[] { "weatherInfo" }, new Object[] { null }, WeatherInfoList.class);
  public final PBRepeatMessageField<WeatherReportStore.WeatherInfo> weatherInfo = PBField.initRepeatMessage(WeatherReportStore.WeatherInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.WeatherInfoList
 * JD-Core Version:    0.7.0.1
 */