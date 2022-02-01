package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeatherReportStore$UinWeatherInfo
  extends MessageMicro<UinWeatherInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field area_id = PBField.initUInt32(0);
  public final PBUInt32Field extra = PBField.initUInt32(0);
  public final PBUInt32Field ip = PBField.initUInt32(0);
  public final PBUInt32Field last_push_time = PBField.initUInt32(0);
  public final PBUInt32Field last_query_adcode = PBField.initUInt32(0);
  public final PBUInt32Field last_query_id = PBField.initUInt32(0);
  public final PBUInt32Field last_query_time = PBField.initUInt32(0);
  public final PBBoolField no_lbs = PBField.initBool(false);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 64, 72 }, new String[] { "last_push_time", "area_id", "ip", "last_query_id", "no_lbs", "extra", "last_query_time", "last_query_adcode" }, new Object[] { localInteger, localInteger, localInteger, localInteger, Boolean.valueOf(false), localInteger, localInteger, localInteger }, UinWeatherInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.UinWeatherInfo
 * JD-Core Version:    0.7.0.1
 */