package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeatherReportStore$AreaWeatherKey
  extends MessageMicro<AreaWeatherKey>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field area_id = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "area_id", "type" }, new Object[] { localInteger, localInteger }, AreaWeatherKey.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xca6.WeatherReportStore.AreaWeatherKey
 * JD-Core Version:    0.7.0.1
 */