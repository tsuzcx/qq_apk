package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeatherReportStore$WeatherHourInfoList
  extends MessageMicro<WeatherHourInfoList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "weatherHourInfo", "updatetime" }, new Object[] { null, Long.valueOf(0L) }, WeatherHourInfoList.class);
  public final PBUInt64Field updatetime = PBField.initUInt64(0L);
  public final PBRepeatMessageField<WeatherReportStore.WeatherHourInfo> weatherHourInfo = PBField.initRepeatMessage(WeatherReportStore.WeatherHourInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.WeatherHourInfoList
 * JD-Core Version:    0.7.0.1
 */