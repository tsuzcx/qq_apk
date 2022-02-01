package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OnlineStatusExtInfo$WeatherBizInfo
  extends MessageMicro<WeatherBizInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField string_area = PBField.initString("");
  public final PBStringField string_city = PBField.initString("");
  public final PBStringField string_temper = PBField.initString("");
  public final PBStringField string_weather_desc = PBField.initString("");
  public final PBStringField string_weather_type = PBField.initString("");
  public final PBStringField string_weather_type_id = PBField.initString("");
  public final PBUInt32Field uint32_adcode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_update_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58, 64, 74 }, new String[] { "string_weather_type", "string_weather_type_id", "uint32_adcode", "uint64_update_time", "string_city", "string_area", "string_temper", "uint32_flag", "string_weather_desc" }, new Object[] { "", "", localInteger, Long.valueOf(0L), "", "", "", localInteger, "" }, WeatherBizInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.onlinestatus.OnlineStatusExtInfo.WeatherBizInfo
 * JD-Core Version:    0.7.0.1
 */