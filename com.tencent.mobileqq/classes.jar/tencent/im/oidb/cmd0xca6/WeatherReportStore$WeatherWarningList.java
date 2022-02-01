package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WeatherReportStore$WeatherWarningList
  extends MessageMicro<WeatherWarningList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "lst_warning", "last_proc_time" }, new Object[] { null, Integer.valueOf(0) }, WeatherWarningList.class);
  public final PBInt32Field last_proc_time = PBField.initInt32(0);
  public final PBRepeatMessageField<WeatherReportStore.WeatherWarningDetail> lst_warning = PBField.initRepeatMessage(WeatherReportStore.WeatherWarningDetail.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.WeatherWarningList
 * JD-Core Version:    0.7.0.1
 */