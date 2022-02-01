package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeatherReportStore$AirInfo
  extends MessageMicro<AirInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "pm", "air_quality", "pubtime", "updatetime" }, new Object[] { "", "", "", Long.valueOf(0L) }, AirInfo.class);
  public final PBStringField air_quality = PBField.initString("");
  public final PBStringField pm = PBField.initString("");
  public final PBStringField pubtime = PBField.initString("");
  public final PBUInt64Field updatetime = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.AirInfo
 * JD-Core Version:    0.7.0.1
 */